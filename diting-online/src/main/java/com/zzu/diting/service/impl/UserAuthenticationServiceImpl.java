package com.zzu.diting.service.impl;

import com.zzu.diting.entity.*;
import com.zzu.diting.manager.AuthenticationWorkManager;
import com.zzu.diting.manager.OperationRecordInfoManager;
import com.zzu.diting.manager.UserAuthenticationManager;
import com.zzu.diting.service.OperationService;
import com.zzu.diting.service.UserAuthenticationService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 17:23
 */
@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    @Resource
    UserAuthenticationManager userAuthenticationManager;
    @Resource
    AuthenticationWorkManager authenticationWorkManager;
    @Resource
    private OperationService operationService;

    @Override
    public String getUserNameAuthenticationByUserId(Long id) {
        String name = null;
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setUserId(id);
        OrganizationAuthenticationInfoPO o = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPO);
        if (o != null) {
            name = o.getOrganizationName();
            return name;
        } else {
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(id);
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            name = p.getRealName();
            return name;
        }
    }

    @Override
    public void addUserAuthenticationPerson(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        userAuthenticationManager.addPersonAuthenticationInfo(personalAuthenticationInfoPO);
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setOrderType("首次认证");
        authenticationWorkInfoPO.setUserId(personalAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPO.setNickname("待处理");
        authenticationWorkInfoPO.setRealName(personalAuthenticationInfoPO.getRealName());
        authenticationWorkInfoPO.setUserType("个人");
        authenticationWorkInfoPO.setIsTransmit(new Byte("0"));
        authenticationWorkInfoPO.setAuditState("处理中");
        authenticationWorkInfoPO.setIsDistribution(new Byte("0"));
        authenticationWorkInfoPO.setCreateTime(System.currentTimeMillis());
        authenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        authenticationWorkInfoPO.setHandleRecord(date + "生成" + "工单");
        operationService.addOperator("添加", "用户生成个人认证信息", personalAuthenticationInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());
        operationService.addOperator("添加", "系统生成个人认证工单", new Long(0), "系统");
        authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPO);
    }

    @Override
    public void addUserAuthenticationOrganization(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {

        userAuthenticationManager.addOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO);
        //添加认证信息的同时生成工单信息，此时工单尚未分配，待每隔一段时间扫描数据库中未分配的工单进行随机平均分配
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setOrderType("首次认证");
        authenticationWorkInfoPO.setUserId(organizationAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPO.setNickname("待处理");
        authenticationWorkInfoPO.setRealName(organizationAuthenticationInfoPO.getOrganizationName());
        authenticationWorkInfoPO.setUserType("机构/组织");
        authenticationWorkInfoPO.setIsTransmit(new Byte("0"));
        authenticationWorkInfoPO.setAuditState("处理中");
        authenticationWorkInfoPO.setIsDistribution(new Byte("0"));
        authenticationWorkInfoPO.setCreateTime(System.currentTimeMillis());
        authenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        authenticationWorkInfoPO.setHandleRecord(date + "生成" + "工单");
        operationService.addOperator("添加", "用户生成组织认证信息", organizationAuthenticationInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());
        operationService.addOperator("添加", "系统生成组织认证工单", new Long(0), "系统");
        authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPO);
    }

    @Override
    public String getUserAuthenticationStateByUserId(Long id) {
        String state = null;
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setUserId(id);
        OrganizationAuthenticationInfoPO o = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPO);
        if (o != null) {
            state = o.getAuthenticationResult();
            return state;
        } else {
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(id);
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p != null) {
                state = p.getAuthenticationResult();
                return state;
            } else {
                state = "未认证";
                return state;
            }

        }
    }

    @Override
    public PersonalAuthenticationInfoPO getUserAuthenticationPersonByUserId(Long id) {
        PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
        personalAuthenticationInfoPO.setUserId(id);
        PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
        return p;
    }

    @Override
    public OrganizationAuthenticationInfoPO getUserAuthenticationOrganizationByUserId(Long id) {
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setUserId(id);
        OrganizationAuthenticationInfoPO o = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPO);
        return o;
    }

    @Override
    public void UpdateUserAuthenticationPerson(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        userAuthenticationManager.updatePersonalAuthenticationInfoPO(personalAuthenticationInfoPO);
    }

    @Override
    public void UpdateUserAuthenticationOrganization(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        userAuthenticationManager.updateOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO);
    }

    @Override
    public void addUserAuthenticationUpdateOrganizationInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO) {
        userAuthenticationManager.insertUserOrganizationAuthenticationUpdateInfo(organizationAuthenticationUpdateInfoPO);
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
        organizationAuthenticationInfoPO.setId(organizationAuthenticationUpdateInfoPO.getAuthenticationId());
        userAuthenticationManager.updateOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO);
    }

    @Override
    public void addUserAuthenticationUpdatePersonInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO) {
        userAuthenticationManager.insertUserAuthenticationUpdateInfo(personalAuthenticationUpdateInfoPO);
        PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
        personalAuthenticationInfoPO.setId(personalAuthenticationUpdateInfoPO.getPersonInfoId());
        personalAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
        userAuthenticationManager.updatePersonalAuthenticationInfoPO(personalAuthenticationInfoPO);
        personalAuthenticationInfoPO = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
        operationService.addOperator("添加", "用户添加个人认证修改信息", personalAuthenticationInfoPO.getUserId(), personalAuthenticationInfoPO.getRealName());
    }

    @Override
    public String getFailReasonByUserId(Long id) {
        String reason;
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setUserId(id);
        OrganizationAuthenticationInfoPO o = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPO);
        if (o != null) {
            reason = o.getReason();
            return reason;
        } else {
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(id);
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p != null) {
                reason = p.getReason();
                return reason;
            } else {
                return null;
            }

        }
    }
}
