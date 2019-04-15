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
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllUserParentManu() {
        Menu menu=new Menu();
        menu.setParentId(1);
        List<Menu> listm=menuMapper.select(menu);
        return listm;
    }

    @Override
    public List<Tree> queryAllChildrenMenu(Integer parentId) {
       List<Tree> treeList=new ArrayList<>();
        Menu menu=new Menu();
        menu.setParentId(parentId);
        System.out.println(parentId);
        List<Menu> listm=menuMapper.select(menu);
        for (Menu m:
                listm) {
            Tree tree=new Tree();
            tree.setId(m.getId());
            tree.setText(m.getName());
            tree.setUrl(m.getUrl());
            treeList.add(tree);
        }
        return treeList;
    }
}
