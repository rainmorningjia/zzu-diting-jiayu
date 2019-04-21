package com.zzu.diting.service.impl;

import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.mapper.UserInfoMapper;
import com.zzu.diting.service.UserService;
import com.zzu.diting.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import org.apache.shiro.subject.Subject;

/**
 * @author Miles
 * @Title: UserServiceImpl
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/14--14:07
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public void LoginUser(String userName, String password) {
        Subject subject= SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(userName,password);
        subject.login(token);
    }

    @Override
    public void addUser(UserInfoPO user) {
        String password=user.getPassword();
        String salt= Md5Util.getSalt();
        String s=new SimpleHash("MD5",user.getPassword(),salt,1024).toString();
        user.setPassword(s);
        user.setSalt(salt);
        user.setAuthenticationState(0);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());
        userInfoMapper.insert(user);
    }

    @Override
    public void updateUser(UserInfoPO user) {
        userInfoMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserInfoPO getUserById(Long id) {
        UserInfoPO userInfoPO=userInfoMapper.selectByPrimaryKey(id);
        return userInfoPO;
    }

    @Override
    public UserInfoPO getUserByUserInfo(UserInfoPO user) {
        UserInfoPO userInfoPO=userInfoMapper.selectOne(user);
        return userInfoPO;
    }
}
