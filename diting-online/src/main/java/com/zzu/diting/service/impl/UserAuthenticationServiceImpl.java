package com.zzu.diting.service.impl;


import com.zzu.diting.dto.AuthenticationResultDto;
import com.zzu.diting.entity.*;
import com.zzu.diting.manager.AuthenticationWorkManager;
import com.zzu.diting.manager.UserAuthenticationManager;
import com.zzu.diting.mapper.OrganizationAuthenticationInfoMapper;
import com.zzu.diting.mapper.OrganizationAuthenticationUpdateInfoPOMapper;
import com.zzu.diting.mapper.PersonalAuthenticationInfoMapper;
import com.zzu.diting.mapper.PersonalAuthenticationUpdateInfoPOMapper;
import com.zzu.diting.service.UserAuthenticationService;
import com.zzu.diting.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    @Resource
    UserAuthenticationManager userAuthenticationManager;
    @Resource
    AuthenticationWorkManager authenticationWorkManager;
    @Resource
    private OperationService operationService;
    @Resource
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public String getUserNameAuthenticationByUserId(Long id) {
        String name;
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

        authenticationWorkInfoPO.setNickname( (String) SecurityUtils.getSubject().getPrincipal());
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
        operationService.addOperator("添加", "用户生成个人认证信息", personalAuthenticationInfoPO.getUserId(), getUserNameAuthenticationByUserId(personalAuthenticationInfoPO.getUserId()));
        operationService.addOperator("添加", "系统生成个人认证工单", new Long("0"), "系统");
        authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPO);
    }

    @Override
    public void addUserAuthenticationOrganization(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {

        userAuthenticationManager.addOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO);
        //添加认证信息的同时生成工单信息，此时工单尚未分配，待每隔一段时间扫描数据库中未分配的工单进行随机平均分配
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setOrderType("首次认证");
        authenticationWorkInfoPO.setUserId(organizationAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPO.setNickname((String) SecurityUtils.getSubject().getPrincipal());
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
        operationService.addOperator("添加", "用户生成组织认证信息", organizationAuthenticationInfoPO.getUserId(), getUserNameAuthenticationByUserId(organizationAuthenticationInfoPO.getUserId()));
        operationService.addOperator("添加", "系统生成组织认证工单", new Long("0"), "系统");
        authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
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
    public void addUserAuthenticationUpdateOrganizationInfo(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPOt = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPOt.setUserId(organizationAuthenticationInfoPO.getUserId());
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPOUser = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPOt);
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setUserId(organizationAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPO.setOrderType("首次认证");
        authenticationWorkInfoPO.setAuditState("通过");
        AuthenticationWorkInfoPO authenticationWorkInfoPO1 = authenticationWorkManager.getAuthenticationWorkInfo(authenticationWorkInfoPO);
        AuthenticationWorkInfoPO authenticationWorkInfoPO2 = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO2.setOrderType("信息修改");
        authenticationWorkInfoPO2.setUserId(organizationAuthenticationInfoPO.getUserId());
        AuthenticationWorkInfoPO authenticationWorkInfoPO3 = authenticationWorkManager.getAuthenticationWorkInfo(authenticationWorkInfoPO2);
        AuthenticationWorkInfoPO authenticationWorkInfoPONew = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPONew.setUserId(organizationAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPONew.setNickname((String) SecurityUtils.getSubject().getPrincipal());
        authenticationWorkInfoPONew.setRealName(organizationAuthenticationInfoPO.getOrganizationName());
        authenticationWorkInfoPONew.setUserType("个人");
        authenticationWorkInfoPONew.setIsTransmit(new Byte("0"));
        authenticationWorkInfoPONew.setAuditState("处理中");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        authenticationWorkInfoPONew.setHandleRecord(date + " " + "系统生成认证工单");
        authenticationWorkInfoPONew.setIsDistribution(new Byte("0"));
        authenticationWorkInfoPONew.setCreateTime(System.currentTimeMillis());
        authenticationWorkInfoPONew.setUpdateTime(System.currentTimeMillis());
        operationService.addOperator("添加", "系统添加认证信息审核工单", new Long("0"), "系统");

        organizationAuthenticationInfoPO.setAuthenticationResult("审核中");
        organizationAuthenticationInfoPO.setRecentlyUpdateType("用户修改");
        organizationAuthenticationInfoPO.setRecentlyOperator("用户修改信息");
        organizationAuthenticationInfoPO.setId(organizationAuthenticationInfoPOUser.getId());
        OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO = new OrganizationAuthenticationUpdateInfoPO();
        organizationAuthenticationUpdateInfoPO.setAuthenticationId(organizationAuthenticationInfoPO.getId());
        organizationAuthenticationUpdateInfoPO.setNewCertificateType(organizationAuthenticationInfoPO.getCertificateType());
        organizationAuthenticationUpdateInfoPO.setNewOrganizationName(organizationAuthenticationInfoPO.getOrganizationName());
        organizationAuthenticationUpdateInfoPO.setNewCertificateNumber(organizationAuthenticationInfoPO.getCertificateNumber());
        organizationAuthenticationUpdateInfoPO.setNewCertificatePositiveUrl(organizationAuthenticationInfoPO.getCertificatePositiveUrl());
        organizationAuthenticationUpdateInfoPO.setUpdateTime(System.currentTimeMillis());

        if (authenticationWorkInfoPO1 == null) {
            organizationAuthenticationInfoPO.setAuthenticationResult("审核中");
            userAuthenticationManager.updateOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO);
            authenticationWorkInfoPONew.setOrderType("首次认证");
            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPONew);
            operationService.addOperator("修改", "用户修改个人认证信息", organizationAuthenticationInfoPO.getUserId(), organizationAuthenticationInfoPO.getOrganizationName());
        } else if (authenticationWorkInfoPO3 == null && authenticationWorkInfoPO1 != null) {
            organizationAuthenticationUpdateInfoPO.setCreateTime(System.currentTimeMillis());
            //添加用户认证修改信息
            userAuthenticationManager.insertUserOrganizationAuthenticationUpdateInfo(organizationAuthenticationUpdateInfoPO);
            operationService.addOperator("添加", "用户修改个人认证信息", organizationAuthenticationInfoPO.getUserId(), organizationAuthenticationInfoPO.getOrganizationName());
            OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO1 = new OrganizationAuthenticationInfoPO();
            organizationAuthenticationInfoPO1.setId(organizationAuthenticationInfoPO.getUserId());
            organizationAuthenticationInfoPO1.setAuthenticationResult("审核中");
            organizationAuthenticationInfoPO1.setRecentlyUpdateType("用户修改");
            authenticationWorkInfoPONew.setOrderType("信息修改");
            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPONew);
            //更新用户认证信息
            userAuthenticationManager.updateOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO1);

        } else if (authenticationWorkInfoPO3 != null && authenticationWorkInfoPO1 != null) {
            OrganizationAuthenticationUpdateInfoPO o = userAuthenticationManager.getUserOrganizationAuthenticationUpdateInfo(organizationAuthenticationUpdateInfoPO);
            organizationAuthenticationUpdateInfoPO.setId(o.getId());
            //修改用户认证更新信息
            userAuthenticationManager.updateOrganizationAuthenticationUpdateInfo(organizationAuthenticationUpdateInfoPO);
            OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO1 = new OrganizationAuthenticationInfoPO();
            organizationAuthenticationInfoPO1.setId(organizationAuthenticationInfoPO.getUserId());
            organizationAuthenticationInfoPO1.setAuthenticationResult("审核中");
            organizationAuthenticationInfoPO1.setRecentlyUpdateType("用户修改");
            authenticationWorkInfoPONew.setOrderType("信息修改");
            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPONew);
            //更新用户认证信息
            userAuthenticationManager.updateOrganizationAuthenticationInfoPO(organizationAuthenticationInfoPO1);


        }
    }

    @Override
    public void addUserAuthenticationUpdatePersonInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        PersonalAuthenticationInfoPO personalAuthenticationInfoPOt = new PersonalAuthenticationInfoPO();
        personalAuthenticationInfoPOt.setUserId(personalAuthenticationInfoPO.getUserId());
        PersonalAuthenticationInfoPO personalAuthenticationInfoPOUser = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPOt);
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setUserId(personalAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPO.setOrderType("首次认证");
        authenticationWorkInfoPO.setAuditState("通过");
        AuthenticationWorkInfoPO authenticationWorkInfoPO1 = authenticationWorkManager.getAuthenticationWorkInfo(authenticationWorkInfoPO);
        AuthenticationWorkInfoPO authenticationWorkInfoPO2 = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO2.setOrderType("信息修改");
        authenticationWorkInfoPO2.setUserId(personalAuthenticationInfoPO.getUserId());
        AuthenticationWorkInfoPO authenticationWorkInfoPO3 = authenticationWorkManager.getAuthenticationWorkInfo(authenticationWorkInfoPO2);
        AuthenticationWorkInfoPO authenticationWorkInfoPONew = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPONew.setUserId(personalAuthenticationInfoPO.getUserId());
        authenticationWorkInfoPONew.setNickname((String) SecurityUtils.getSubject().getPrincipal());
        authenticationWorkInfoPONew.setRealName(personalAuthenticationInfoPO.getRealName());
        authenticationWorkInfoPONew.setUserType("个人");
        authenticationWorkInfoPONew.setIsTransmit(new Byte("0"));
        authenticationWorkInfoPONew.setAuditState("处理中");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        authenticationWorkInfoPONew.setHandleRecord(date + " " + "系统生成认证工单");
        authenticationWorkInfoPONew.setIsDistribution(new Byte("0"));
        authenticationWorkInfoPONew.setCreateTime(System.currentTimeMillis());
        authenticationWorkInfoPONew.setUpdateTime(System.currentTimeMillis());
        personalAuthenticationInfoPO.setAuthenticationResult("审核中");
        personalAuthenticationInfoPO.setRecentlyUpdateType("用户修改");
        personalAuthenticationInfoPO.setRecentlyOperator("用户修改信息");
        personalAuthenticationInfoPO.setId(personalAuthenticationInfoPOUser.getId());
        operationService.addOperator("添加", "系统添加认证信息审核工单", new Long("0"), "系统");
        PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO = new PersonalAuthenticationUpdateInfoPO();
        personalAuthenticationUpdateInfoPO.setPersonInfoId(personalAuthenticationInfoPO.getId());
        personalAuthenticationUpdateInfoPO.setNewRealName(personalAuthenticationInfoPO.getRealName());
        personalAuthenticationUpdateInfoPO.setCertificateType(personalAuthenticationInfoPO.getCertificateType());
        personalAuthenticationUpdateInfoPO.setNewCertificateNumber(personalAuthenticationInfoPO.getCertificateNumber());
        if (personalAuthenticationInfoPO.getCertificateType().equals("身份证")) {
            personalAuthenticationUpdateInfoPO.setNewCertificatePositiveUrl(personalAuthenticationInfoPO.getCertificatePositiveUrl());
            personalAuthenticationUpdateInfoPO.setNewCertificateOppositeUrl(personalAuthenticationInfoPO.getCertificateOppositeUrl());
            personalAuthenticationUpdateInfoPO.setNewCertificateHandofUrl(personalAuthenticationInfoPO.getCertificateHandofUrl());

        } else {
            personalAuthenticationUpdateInfoPO.setNewCertificatePositiveUrl(personalAuthenticationInfoPO.getCertificatePositiveUrl());
        }
        personalAuthenticationUpdateInfoPO.setUpdateTime(System.currentTimeMillis());
        //第一次进行信息修改切首次认证未通过
        if (authenticationWorkInfoPO1 == null) {
            authenticationWorkInfoPONew.setOrderType("首次认证");

            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPO);
            userAuthenticationManager.updatePersonalAuthenticationInfoPO(personalAuthenticationInfoPO);
            operationService.addOperator("修改", "用户修改个人认证信息", personalAuthenticationInfoPO.getUserId(), personalAuthenticationInfoPO.getRealName());
        } else if (authenticationWorkInfoPO3 == null && authenticationWorkInfoPO1 != null) {

            authenticationWorkInfoPONew.setOrderType("信息修改");
            //修改用户认证状态
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO1 = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO1.setId(personalAuthenticationInfoPO.getId());
            personalAuthenticationInfoPO1.setAuthenticationResult("审核中");
            personalAuthenticationInfoPO1.setRecentlyUpdateType("用户修改");
            personalAuthenticationInfoPO1.setRecentlyOperator("用户修改信息");
            personalAuthenticationUpdateInfoPO.setCreateTime(System.currentTimeMillis());
            userAuthenticationManager.updatePersonalAuthenticationInfoPO(personalAuthenticationInfoPO1);
            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPONew);
            userAuthenticationManager.insertUserAuthenticationUpdateInfo(personalAuthenticationUpdateInfoPO);
            operationService.addOperator("添加", "用户添加个人认证修改信息", personalAuthenticationInfoPO.getUserId(), personalAuthenticationInfoPO.getRealName());

        } else if (authenticationWorkInfoPO3 != null && authenticationWorkInfoPO1 != null) {
            //更新用户修改信息
            PersonalAuthenticationUpdateInfoPO p = userAuthenticationManager.getUserAuthenticationUpdateInfo(personalAuthenticationUpdateInfoPO);
            personalAuthenticationUpdateInfoPO.setId(p.getId());
            userAuthenticationManager.updatePersonAuthenticationUpdateInfo(personalAuthenticationUpdateInfoPO);
            operationService.addOperator("修改", "用户修改个人认证修改信息", personalAuthenticationInfoPO.getUserId(), personalAuthenticationInfoPO.getRealName());
            authenticationWorkInfoPONew.setOrderType("信息修改");
            authenticationWorkManager.addAuthenticationWorkInfo(authenticationWorkInfoPONew);
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO1 = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO1.setId(personalAuthenticationInfoPO.getId());
            personalAuthenticationInfoPO1.setAuthenticationResult("审核中");
            personalAuthenticationInfoPO1.setRecentlyUpdateType("用户修改");
            personalAuthenticationInfoPO1.setRecentlyOperator("用户修改信息");
            userAuthenticationManager.updatePersonalAuthenticationInfoPO(personalAuthenticationInfoPO1);

        }


    }

    @Override
    public AuthenticationResultDto getFailReasonByUserId(Long id) {
        AuthenticationResultDto authenticationResultDto = new AuthenticationResultDto();
        String reason;
        Integer failType;
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
        organizationAuthenticationInfoPO.setUserId(id);
        OrganizationAuthenticationInfoPO o = userAuthenticationManager.queryOrganizationAuthenticationInfo(organizationAuthenticationInfoPO);

        if (o != null) {

            authenticationResultDto.setReason(organizationAuthenticationInfoPO.getReason());
            authenticationResultDto.setFailType(organizationAuthenticationInfoPO.getFailType());
            authenticationResultDto.setCode(0);
            authenticationResultDto.setMessage("查询消息成功");
            return authenticationResultDto;
        } else {
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(id);
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p != null) {
                authenticationResultDto.setReason(personalAuthenticationInfoPO.getReason());
                authenticationResultDto.setFailType(personalAuthenticationInfoPO.getFailType());
                authenticationResultDto.setCode(0);
                authenticationResultDto.setMessage("查询消息成功");
                return authenticationResultDto;
            } else {
                authenticationResultDto.setCode(1);
                authenticationResultDto.setMessage("查询消息失败");
                return authenticationResultDto;
            }

        }
    }
}
