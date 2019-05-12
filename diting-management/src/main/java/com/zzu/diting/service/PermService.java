package com.zzu.diting.service;

import com.zzu.diting.entity.realmObject.Perm;

import java.util.List;

/**
 * @author Miles
 * @Title: PermService
 * @ProjectName cmfz-jcy
 * @Date 2019/1/4--18:36
 */
public interface PermService {
    List<Perm> queryPermsByRole(String role);
}
