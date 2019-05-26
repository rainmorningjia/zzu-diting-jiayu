package com.zzu.diting.realm;

import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.entity.realmObject.Perm;
import com.zzu.diting.entity.realmObject.Role;
import com.zzu.diting.service.PermService;
import com.zzu.diting.service.RoleService;
import com.zzu.diting.service.UserService;
import org.apache.catalina.Manager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @Title: MyRealm
 * @ProjectName diting-jcy
 * @Date 2019/1/3--19:35
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //将传过来的AuthenticationInfo对象转为UsernamePasswToken对象
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //接受其传过来的username
        String username=token.getUsername();
        //判断是否为空
        if (username!=null&&!"".equals(username)){
            //调用数据库查出密码
            UserInfoPO userInfoPO=new UserInfoPO();
            userInfoPO.setUserName(username);
            UserInfoPO userInfo=userService.getUserByUserInfo(userInfoPO);
            if (userInfo==null){
                throw new RuntimeException("该用户不存在!");
            }
            String password=userInfo.getPassword();
            String salt=userInfo.getSalt();
            if (password!=null){
                return  new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(salt),getName());
            }
        }
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取前台传过来的用户名
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String username=(String) principalCollection.fromRealm(getName()).iterator().next();
        if (username!=null){
            //根据用户名获取角色集合
            List<String> roles=new ArrayList<>();
            for (Role role:
                    roleService.queryRolesByUserName(username)) {
                roles.add(role.getRoles());
            }
            simpleAuthorizationInfo.addRoles(roles);
            List<String> perms=new ArrayList<>();
            for (String s:
                    roles) {
                for (Perm perm:
                        permService.queryPermsByRole(s)) {
                    if (!perms.contains(perm.getPerm())){
                        perms.add(perm.getPerm());
                    }

                }
                simpleAuthorizationInfo.addStringPermissions(roles);
            }
        }
        return simpleAuthorizationInfo;
    }
}
