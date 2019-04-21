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
 * @ProjectName cmfz-jcy
 * @Date 2018/12/19--21:50
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping( "getAllUserParentMenu" )
    @ResponseBody
    public List<Menu> getAllParentMenu(){
        List<Menu> listm=menuService.queryAllUserParentManu();
        return listm;
    }
    @RequestMapping(value = "queryAllChildrenMenu",produces = "text/html;charset=UTF-8" )
    @ResponseBody
    public List<Tree> getAllChriMenu(Integer parentId){
        List<Tree> treeList=menuService.queryAllChildrenMenu(parentId);
        System.out.println(treeList);
        return treeList;
    }
}
