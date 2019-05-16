package com.zzu.diting.service.impl;

import com.zzu.diting.entity.Menu;
import com.zzu.diting.entity.Tree;
import com.zzu.diting.mapper.MenuMapper;
import com.zzu.diting.service.MenuService;
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


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Menu> queryAllUserParentManu() {
        Menu menu = new Menu();
        menu.setParentId(0);
        return menuMapper.select(menu);
    }

    @Override
    public List<Tree> queryAllChildrenMenu(Integer parentId) {
        List<Tree> treeList = new ArrayList<>();
        Menu menu = new Menu();
        menu.setParentId(parentId);
        System.out.println(parentId);
        List<Menu> listM = menuMapper.select(menu);
        for (Menu m :
                listM) {
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
