package com.zzu.diting.service;

import com.zzu.diting.entity.Menu;
import com.zzu.diting.entity.Tree;
import java.util.List;

/**
 * @author Miles
 * @Title: MenuService
 * @ProjectName cmfz-jcy
 * @Date 2018/12/19--21:45
 */
public interface MenuService {
    public List<Menu> queryAllUserParentManu();
    public List<Tree> queryAllChildrenMenu(Integer parentId);
}
