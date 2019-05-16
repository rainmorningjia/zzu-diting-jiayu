package com.zzu.diting.controller;

import com.zzu.diting.entity.Menu;
import com.zzu.diting.entity.Tree;
import com.zzu.diting.service.MenuService;
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


    @RequestMapping("getAllUserParentMenu")
    @ResponseBody
    public List<Menu> getAllParentMenu() {
        List<Menu> listM = menuService.queryAllUserParentManu();
        return listM;
    }

    @RequestMapping(value = "queryAllChildrenMenu", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public List<Tree> getAllChildrenMenu(Integer parentId) {
        System.out.println(parentId);
        List<Tree> treeList = menuService.queryAllChildrenMenu(parentId);
        return treeList;
    }
}
