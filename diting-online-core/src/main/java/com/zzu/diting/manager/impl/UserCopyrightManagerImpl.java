package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.CopyrightInfoPO;
import com.zzu.diting.entity.CopyrightUpdateInfoPO;
import com.zzu.diting.mapper.CopyrightInfoMapper;
import com.zzu.diting.mapper.CopyrightUpdateInfoPOMapper;
import com.zzu.diting.manager.UserCopyrightManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:07
 */
@Service
@Transactional
public class UserCopyrightManagerImpl implements UserCopyrightManager {
    @Resource
    CopyrightInfoMapper copyrightInfoMapper;
    @Resource
    CopyrightUpdateInfoPOMapper copyrightUpdateInfoPOMapper;

    @Override
    public void addUserCopyright(CopyrightInfoPO copyrightInfoPO) {
        copyrightInfoMapper.insert(copyrightInfoPO);
    }

    @Override
    public void updateUserCopyright(CopyrightInfoPO copyrightInfoPO) {
        copyrightInfoMapper.updateByPrimaryKeySelective(copyrightInfoPO);
    }

    @Override
    public int queryCopyrightInfoNumberByUserId(Long userId) {
        CopyrightInfoPO copyrightInfoPO = new CopyrightInfoPO();
        copyrightInfoPO.setUserId(userId);
        int num = copyrightInfoMapper.selectCount(copyrightInfoPO);
        return num;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public CopyrightInfoPO getCopyrightInfoPO(Long cId) {
        CopyrightInfoPO copyrightInfoPO = copyrightInfoMapper.selectByPrimaryKey(cId);
        return copyrightInfoPO;
    }

    @Override
    public void deleteCopyrightInfoPO(Long cId) {
        copyrightInfoMapper.deleteByPrimaryKey(cId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public CopyrightUpdateInfoPO getCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        copyrightUpdateInfoPO = copyrightUpdateInfoPOMapper.selectOne(copyrightUpdateInfoPO);
        return copyrightUpdateInfoPO;
    }

    @Override
    public List<CopyrightInfoPO> getCopyrightInfoListByUserId(Long userId, Integer num1, Integer num2, String time, String sort) {
        List<CopyrightInfoPO> list = copyrightInfoMapper.queryCopyrightInfoByUserId(userId, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CopyrightInfoPO> queryCopyrightInfoList(Integer num1, Integer num2) {
        List<CopyrightInfoPO> list = copyrightInfoMapper.queryCopyrightInfoList(num1, num2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CopyrightInfoPO> queryCopyrightInfoAll(Integer num1, Integer num2, String time, String sort) {
        List<CopyrightInfoPO> list = copyrightInfoMapper.queryCopyrightInfoAll(num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CopyrightInfoPO> queryCopyrightInfoByCopyrightName(String copyrightName, Integer num1, Integer num2, String time, String sort) {
        List<CopyrightInfoPO> list = copyrightInfoMapper.queryCopyrightInfoByCopyrightName(copyrightName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CopyrightInfoPO> queryCopyrightInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<CopyrightInfoPO> list = copyrightInfoMapper.queryCopyrightInfoByTime(timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    public void addCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        copyrightUpdateInfoPOMapper.insert(copyrightUpdateInfoPO);
    }


    @Override
    public void deleteCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        copyrightUpdateInfoPOMapper.delete(copyrightUpdateInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAllNumber() {
        int number = copyrightInfoMapper.selectAll().size();
        return number;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CopyrightInfoPO> getCopyRightInfoOfNameAndId(String name) {
        return copyrightInfoMapper.queryCopyRightInfoOfNameAndId(name);
    }

    @Override
    public void updateCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        copyrightUpdateInfoPOMapper.updateByPrimaryKeySelective(copyrightUpdateInfoPO);
    }
}
