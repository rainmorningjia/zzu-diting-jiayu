package com.zzu.diting.service;

import com.zzu.diting.entity.realmObject.Role;

import java.util.List;

/**
 * @author Miles
 * @Title: RoleService
 * @ProjectName cmfz-jcy
 * @Date 2019/1/4--18:31
 */
public interface RoleService {
    List<Role> queryRolesByUserName(String username);
}
