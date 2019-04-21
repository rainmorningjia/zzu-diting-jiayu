package com.zzu.diting.service.impl;

import com.zzu.diting.entity.Menu;
import com.zzu.diting.entity.Tree;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.mapper.MenuMapper;
import com.zzu.diting.service.MenuService;
import com.zzu.diting.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @Title: MenuServiceImpl
 * @ProjectName cmfz-jcy
 * @Date 2018/12/19--21:47
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Menu> queryAllUserParentManu() {
        Menu menu = new Menu();
        menu.setParentId(1);
        List<Menu> listm = menuMapper.select(menu);
        return listm;
    }

    @Override
    public List<Tree> queryAllChildrenMenu(Integer parentId) {
        List<Tree> treeList = new ArrayList<>();
        Menu menu = new Menu();
        menu.setParentId(parentId);
        System.out.println(parentId);
        List<Menu> listm = menuMapper.select(menu);
        for (Menu m :
                listm) {
            if (m.getName().equals("用户认证信息")) {
                String name = (String) SecurityUtils.getSubject().getPrincipal();
                UserInfoPO userInfoPO = new UserInfoPO();
                userInfoPO.setUserName(name);
                UserInfoPO userInfoPO1 = userService.getUserByUserInfo(userInfoPO);
                if (userInfoPO1.getAuthenticationState() == 0) {
                    m.setUrl("authen/noAuthentication.jsp");

                }
                if (userInfoPO1.getAuthenticationState() == 1) {
                    m.setUrl("authen/authenticaionAuditing.jsp");
                }
                if ((userInfoPO1.getAuthenticationState() == 2)) {
                    m.setUrl("authen/authenticationNoAdopt.jsp");
                }
                if (userInfoPO1.getAuthenticationState() == 3) {
                    m.setUrl("authen/detailUserAuthentication.jsp");
                }
            }
            Tree tree = new Tree();
            tree.setId(m.getId());
            tree.setText(m.getName());
            tree.setUrl(m.getUrl());
            treeList.add(tree);
        }
        System.out.println(treeList);
        return treeList;
    }
}
