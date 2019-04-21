package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import com.zzu.diting.entity.OrganizationAuthenticationUpdateInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationUpdateInfoPO;
import com.zzu.diting.mapper.OrganizationAuthenticationInfoMapper;
import com.zzu.diting.mapper.OrganizationAuthenticationUpdateInfoPOMapper;
import com.zzu.diting.mapper.PersonalAuthenticationInfoMapper;
import com.zzu.diting.mapper.PersonalAuthenticationUpdateInfoPOMapper;
import com.zzu.diting.manager.UserAuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/1 17:55
 */
@Service
@Transactional
public class UserAuthenticationManagerImpl implements UserAuthenticationManager {

    @Resource
    private PersonalAuthenticationInfoMapper personalAuthenticationInfoMapper;

    @Resource
    private OrganizationAuthenticationInfoMapper organizationAuthenticationInfoMapper;

    @Resource
    PersonalAuthenticationUpdateInfoPOMapper personalAuthenticationUpdateInfoPOMapper;

    @Resource
    OrganizationAuthenticationUpdateInfoPOMapper organizationAuthenticationUpdateInfoPOMapper;

    @Override
    public List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationAll(Integer num1, Integer num2, String time, String sort) {
        List<PersonalAuthenticationInfoPO> list = personalAuthenticationInfoMapper.queryPersonalAuthenticationAll(num1, num2, time, sort);
        return list;
    }

    @Override
    public List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByRealName(String realName, Integer num1, Integer num2, String time, String sort) {
        List<PersonalAuthenticationInfoPO> list = personalAuthenticationInfoMapper.queryPersonalAuthenticationByRealName(realName, num1, num2, time, sort);
        return list;
    }

    @Override
    public List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByEmail(String email, Integer num1, Integer num2, String time, String sort) {
        List<PersonalAuthenticationInfoPO> list = personalAuthenticationInfoMapper.queryPersonalAuthenticationByEmail(email, num1, num2, time, sort);
        return list;
    }

    @Override
    public List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<PersonalAuthenticationInfoPO> list = personalAuthenticationInfoMapper.queryPersonalAuthenticationByTime(timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    public PersonalAuthenticationUpdateInfoPO getUserAuthenticationUpdateInfoById(Long aId) {
        PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO = personalAuthenticationUpdateInfoPOMapper.selectByPrimaryKey(aId);
        return personalAuthenticationUpdateInfoPO;
    }

    @Override
    public PersonalAuthenticationUpdateInfoPO getUserAuthenticationUpdateInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO) {
        PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO1 = personalAuthenticationUpdateInfoPOMapper.selectOne(personalAuthenticationUpdateInfoPO);
        return personalAuthenticationUpdateInfoPO1;
    }

    @Override
    public void insertUserAuthenticationUpdateInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO) {
        personalAuthenticationUpdateInfoPOMapper.insert(personalAuthenticationUpdateInfoPO);
    }

    @Override
    public void deleteUserAuthenticationUpdateInfoById(Long aId) {
        personalAuthenticationUpdateInfoPOMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public OrganizationAuthenticationUpdateInfoPO getUserOrganizationAuthenticationUpdateInfoById(Long aId) {
        OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO = organizationAuthenticationUpdateInfoPOMapper.selectByPrimaryKey(aId);
        return organizationAuthenticationUpdateInfoPO;
    }

    @Override
    public OrganizationAuthenticationUpdateInfoPO getUserOrganizationAuthenticationUpdateInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO) {
        OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO1 = organizationAuthenticationUpdateInfoPOMapper.selectOne(organizationAuthenticationUpdateInfoPO);
        return organizationAuthenticationUpdateInfoPO1;
    }

    @Override
    public void insertUserOrganizationAuthenticationUpdateInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO) {
        organizationAuthenticationUpdateInfoPOMapper.insert(organizationAuthenticationUpdateInfoPO);
    }

    @Override
    public void deleteUserOrganizationAuthenticationUpdateInfoPO(Long aId) {
        organizationAuthenticationUpdateInfoPOMapper.deleteByPrimaryKey(aId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationAll(Integer num1, Integer num2, String time, String sort) {
        List<OrganizationAuthenticationInfoPO> list = organizationAuthenticationInfoMapper.queryOrganizationAuthenticationAll(num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByOrganizationName(String organizationName, Integer num1, Integer num2, String time, String sort) {
        List<OrganizationAuthenticationInfoPO> list = organizationAuthenticationInfoMapper.queryOrganizationAuthenticationByOrganizationName(organizationName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByEmail(String email, Integer num1, Integer num2, String time, String sort) {
        List<OrganizationAuthenticationInfoPO> list = organizationAuthenticationInfoMapper.queryOrganizationAuthenticationByEmail(email, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByCorporationName(String corporationName, Integer num1, Integer num2, String time, String sort) {
        List<OrganizationAuthenticationInfoPO> list = organizationAuthenticationInfoMapper.queryOrganizationAuthenticationByCorporationName(corporationName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<OrganizationAuthenticationInfoPO> list = organizationAuthenticationInfoMapper.queryOrganizationAuthenticationByTime(timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PersonalAuthenticationInfoPO queryPersonAuthenticationInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        PersonalAuthenticationInfoPO personal = personalAuthenticationInfoMapper.selectOne(personalAuthenticationInfoPO);
        return personal;
    }

    @Override
    public void addPersonAuthenticationInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        personalAuthenticationInfoMapper.insert(personalAuthenticationInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public OrganizationAuthenticationInfoPO queryOrganizationAuthenticationInfo(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO1 = organizationAuthenticationInfoMapper.selectOne(organizationAuthenticationInfoPO);
        return organizationAuthenticationInfoPO1;
    }

    @Override
    public void addOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        organizationAuthenticationInfoMapper.insert(organizationAuthenticationInfoPO);
    }

    @Override

    public void updatePersonalAuthenticationInfoPO(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        personalAuthenticationInfoMapper.updateByPrimaryKeySelective(personalAuthenticationInfoPO);
    }

    @Override
    public void updateOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        organizationAuthenticationInfoMapper.updateByPrimaryKeySelective(organizationAuthenticationInfoPO);
    }

    @Override
    public void deletePersonAuthenticationInfoPO(PersonalAuthenticationInfoPO personalAuthenticationInfoPO) {
        personalAuthenticationInfoMapper.delete(personalAuthenticationInfoPO);
    }

    @Override
    public void deleteOrganizationAuthenticationInfoPO(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO) {
        organizationAuthenticationInfoMapper.delete(organizationAuthenticationInfoPO);
    }
}
