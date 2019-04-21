package com.zzu.diting.manager;


import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import com.zzu.diting.entity.OrganizationAuthenticationUpdateInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationUpdateInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/1 17:52
 */
public interface UserAuthenticationManager {

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationAll(Integer num1, Integer num2, String time, String sort);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByOrganizationName(String organizationName, Integer num1, Integer num2, String time, String sort);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByEmail(String email, Integer num1, Integer num2, String time, String sort);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByCorporationName(String corporationName, Integer num1, Integer num2, String time, String sort);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationAll(Integer num1, Integer num2, String time, String sort);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByRealName(String realName, Integer num1, Integer num2, String time, String sort);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByEmail(String email, Integer num1, Integer num2, String time, String sort);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort);

    PersonalAuthenticationUpdateInfoPO getUserAuthenticationUpdateInfoById(Long aId);

    PersonalAuthenticationUpdateInfoPO getUserAuthenticationUpdateInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO);

    void insertUserAuthenticationUpdateInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO);

    void deleteUserAuthenticationUpdateInfoById(Long aId);

    OrganizationAuthenticationUpdateInfoPO getUserOrganizationAuthenticationUpdateInfoById(Long aId);

    OrganizationAuthenticationUpdateInfoPO getUserOrganizationAuthenticationUpdateInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO);

    void insertUserOrganizationAuthenticationUpdateInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO);

    void deleteUserOrganizationAuthenticationUpdateInfoPO(Long aId);

    /**
     * 根据信息调出个人用户认证信息
     *
     * @param personalAuthenticationInfoPO 带有个人用户认证信息用户id的对象
     * @return 个人用户认证信息
     */
    PersonalAuthenticationInfoPO queryPersonAuthenticationInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    /**
     * 添加个人用户认证信息
     *
     * @param personalAuthenticationInfoPO 个人认证信息参数
     */
    void addPersonAuthenticationInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    /**
     * 查询组织机构认证信息
     *
     * @param organizationAuthenticationInfoPO 组织认证信息参数
     * @return 组织机构认证信息
     */
    OrganizationAuthenticationInfoPO queryOrganizationAuthenticationInfo(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    /**
     * 添加组织机构认证信息
     *
     * @param organizationAuthenticationInfoPO 组织认证信息参数
     */
    void addOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    /**
     * 更新个人认证信息
     *
     * @param personalAuthenticationInfoPO 个人认证信息参数
     */
    void updatePersonalAuthenticationInfoPO(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    /**
     * 更新组织机构认证信息
     *
     * @param organizationAuthenticationInfoPO 组织认证信息参数
     */
    void updateOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    /**
     * 删除个人认证信息
     *
     * @param personalAuthenticationInfoPO 个人认证信息参数
     */
    void deletePersonAuthenticationInfoPO(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    /**
     * 删除机构认证信息
     *
     * @param organizationAuthenticationInfoPO 机构认证信息参数
     */
    void deleteOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);
}
