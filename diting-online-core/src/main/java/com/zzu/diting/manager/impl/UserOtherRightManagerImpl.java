package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.OtherRightInfoPO;
import com.zzu.diting.entity.OtherRightUpdateInfoPO;
import com.zzu.diting.manager.UserOtherRightManager;
import com.zzu.diting.mapper.OtherRightInfoMapper;
import com.zzu.diting.mapper.OtherRightUpdateInfoPOMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:32
 */
@Service
@Transactional
public class UserOtherRightManagerImpl implements UserOtherRightManager {

    @Resource
    OtherRightInfoMapper otherRightInfoMapper;

    @Resource
    OtherRightUpdateInfoPOMapper otherRightUpdateInfoPOMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public OtherRightInfoPO getUserOtherRightInfoById(Long oId) {
        OtherRightInfoPO otherRightInfoPO = otherRightInfoMapper.selectByPrimaryKey(oId);
        return otherRightInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public OtherRightInfoPO getUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO) {
        OtherRightInfoPO otherRightInfoPO1 = otherRightInfoMapper.selectOne(otherRightInfoPO);
        return otherRightInfoPO1;
    }

    @Override
    public void addUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO) {
        otherRightInfoMapper.insert(otherRightInfoPO);
    }

    @Override
    public void updateUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO) {
        otherRightInfoMapper.updateByPrimaryKeySelective(otherRightInfoPO);
    }

    @Override
    public void deleteUserOtherRightInfoById(Long oId) {
        otherRightInfoMapper.deleteByPrimaryKey(oId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void getUserOtherRightUpdateInfoById(Long oId) {
        otherRightUpdateInfoPOMapper.selectByPrimaryKey(oId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void getUserOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO) {
        otherRightUpdateInfoPOMapper.selectOne(otherRightUpdateInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void addUserOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO) {
        otherRightUpdateInfoPOMapper.insert(otherRightUpdateInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void deleteUserOtherRightUpdateInfoById(Long oId) {
        otherRightUpdateInfoPOMapper.deleteByPrimaryKey(oId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OtherRightInfoPO> getListOtherRightInfoAll(Integer num1, Integer num2, String time, String sort) {
        List<OtherRightInfoPO> list = otherRightInfoMapper.queryOtherRightInfoAll(num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OtherRightInfoPO> getListOtherRightInfoByUserId(Long userId, Integer num1, Integer num2, String time, String sort) {
        List<OtherRightInfoPO> list = otherRightInfoMapper.queryOtherRightInfoByUserId(userId, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OtherRightInfoPO> getListOtherRightInfoByRightName(String rightName, Integer num1, Integer num2, String time, String sort) {
        List<OtherRightInfoPO> list = otherRightInfoMapper.queryOtherRightInfoByCopyrightName(rightName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OtherRightInfoPO> getListOtherRightInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<OtherRightInfoPO> list = otherRightInfoMapper.queryOtherRightInfoByTime(timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getNumberByUserId(Long useId) {
        OtherRightInfoPO otherRightInfoPO = new OtherRightInfoPO();
        otherRightInfoPO.setUserId(useId);
        int number = otherRightInfoMapper.selectCount(otherRightInfoPO);
        return number;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAllNumber() {
        int number = otherRightInfoMapper.selectAll().size();
        return number;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OtherRightInfoPO> getOtherRightOfNameAndId(String name) {
        return otherRightInfoMapper.queryOtherRightInfoOfNameAndId(name);
    }
}
