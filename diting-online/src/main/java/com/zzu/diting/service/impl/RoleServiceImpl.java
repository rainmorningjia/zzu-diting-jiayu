package com.zzu.diting.service.impl;

import com.zzu.diting.entity.realmObject.Role;
import com.zzu.diting.mapper.RoleMapper;
import com.zzu.diting.mapper.RoleMapper;
import com.zzu.diting.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Miles
 * @Title: RoleServiceImpl
 * @ProjectName cmfz-jcy
 * @Date 2019/1/4--18:32
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Role> queryRolesByUserName(String username) {
        Role role=new Role();
        role.setUsername(username);
        List<Role> roleList=roleMapper.select(role);
        return roleList;
    }
}
