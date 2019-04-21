package com.zzu.diting.service;

import com.zzu.diting.entity.UserInfoPO;

/**
 * @author Miles
 * @Title: UserService
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/14--14:06
 */
public interface UserService {
    void LoginUser(String userName,String password);
    void addUser(UserInfoPO user);
    void updateUser(UserInfoPO user);
    UserInfoPO getUserById(Long id);
    UserInfoPO getUserByUserInfo(UserInfoPO user);

}
