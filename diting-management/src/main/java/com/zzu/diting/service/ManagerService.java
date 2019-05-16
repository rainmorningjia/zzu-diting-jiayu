package com.zzu.diting.service;

import com.zzu.diting.entity.ManagerInfo;

public interface ManagerService {
    /**
     * 得到管理者信息
     *
     * @param managerInfo 管理则信息
     * @return 管理者信息
     */
    ManagerInfo getManagerInfo(ManagerInfo managerInfo);

    /**
     * 添加管理者
     *
     * @param managerInfo 管理者信息
     */
    void addManagerInfo(ManagerInfo managerInfo);

    /**
     * 管理员登录
     * @param name 姓名
     * @param password 密码
     */
    void loginManager(String name, String password);
}
