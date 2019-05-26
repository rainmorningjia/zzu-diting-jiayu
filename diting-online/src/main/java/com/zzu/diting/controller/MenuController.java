package com.zzu.diting.controller;

import com.zzu.diting.entity.Menu;
import com.zzu.diting.entity.Tree;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.service.MenuService;
import com.zzu.diting.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Miles
 * @Title: MenuController
 * @Date 2018/12/19--21:50
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;

    @RequestMapping("getAllUserParentMenu")
    @ResponseBody
    public List<Menu> getAllParentMenu() {
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserName(name);
        UserInfoPO userInfoPO1 = userService.getUserByUserInfo(userInfoPO);
        List<Menu> listM = menuService.queryAllUserParentManu();
        if (userInfoPO1.getAuthenticationState() == 2) {
            return listM;
        } else {
            Menu menu = new Menu();
            menu.setId(4);
            menu.setName("用户信息");
            listM.clear();
            listM.add(menu);
            return listM;
        }

    }

    @RequestMapping(value = "queryAllChildrenMenu", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public List<Tree> getAllChildrenMenu(Integer parentId) {
        List<Tree> treeList = menuService.queryAllChildrenMenu(parentId);
        return treeList;
    }
}
