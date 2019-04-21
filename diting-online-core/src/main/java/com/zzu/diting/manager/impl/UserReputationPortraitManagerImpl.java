package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.ReputationPortraitInfoPO;
import com.zzu.diting.entity.ReputationPortraitUpdateInfoPO;
import com.zzu.diting.manager.UserReputationPortraitManager;
import com.zzu.diting.mapper.ReputationPortraitInfoMapper;
import com.zzu.diting.mapper.ReputationPortraitUpdateInfoPOMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:24
 */
@Service
@Transactional
public class UserReputationPortraitManagerImpl implements UserReputationPortraitManager {

    @Resource
    ReputationPortraitInfoMapper reputationPortraitInfoMapper;

    @Resource
    ReputationPortraitUpdateInfoPOMapper reputationPortraitUpdateInfoPOMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ReputationPortraitInfoPO getUserReputationPortraitInfoById(Long oId) {

        ReputationPortraitInfoPO reputationPortraitInfoPO=reputationPortraitInfoMapper.selectByPrimaryKey(oId);

        return reputationPortraitInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ReputationPortraitInfoPO getUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO) {
        ReputationPortraitInfoPO reputationPortraitInfoPO1=reputationPortraitInfoMapper.selectOne(reputationPortraitInfoPO);
        return reputationPortraitInfoPO1;
    }

    @Override
    public void addUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO) {
        reputationPortraitInfoMapper.insert(reputationPortraitInfoPO);
    }

    @Override
    public void updateUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO) {
        reputationPortraitInfoMapper.updateByPrimaryKeySelective(reputationPortraitInfoPO);
    }

    @Override
    public void deleteUserReputationPortraitInfoById(Long oId) {
        reputationPortraitInfoMapper.deleteByPrimaryKey(oId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ReputationPortraitUpdateInfoPO getUserReputationPortraitUpdateInfoById(Long oId) {
        ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO=reputationPortraitUpdateInfoPOMapper.selectByPrimaryKey(oId);
        return reputationPortraitUpdateInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ReputationPortraitUpdateInfoPO getUserReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO) {
        ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO1=reputationPortraitUpdateInfoPOMapper.selectOne(reputationPortraitUpdateInfoPO);
        return reputationPortraitUpdateInfoPO1;
    }

    @Override
    public void addUserReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO) {
        reputationPortraitUpdateInfoPOMapper.insert(reputationPortraitUpdateInfoPO);
    }

    @Override
    public void deleteUserReputationPortraitUpdateInfoById(Long oId) {
        reputationPortraitUpdateInfoPOMapper.deleteByPrimaryKey(oId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int getUserReputationPortraitInfoNumberByUserId(Long userId) {
        ReputationPortraitInfoPO reputationPortraitInfoPO=new ReputationPortraitInfoPO();
        reputationPortraitInfoPO.setUserId(userId);
        int number=reputationPortraitInfoMapper.selectCount(reputationPortraitInfoPO);
        return number;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int getAllNumber() {
        int number=reputationPortraitInfoMapper.selectAll().size();
        return number;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ReputationPortraitInfoPO> getReputationPortraitInfoByUserId(Long userId, Integer num1, Integer num2, String time, String sort) {
        List<ReputationPortraitInfoPO> list=reputationPortraitInfoMapper.queryReputationPortraitInfoByUserId(userId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ReputationPortraitInfoPO> queryReputationPortraitInfoAll(Integer num1, Integer num2, String time, String sort) {
        List<ReputationPortraitInfoPO> list=reputationPortraitInfoMapper.queryReputationPortraitInfoAll(num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ReputationPortraitInfoPO> queryReputationPortraitInfoCopyrightName(String copyrightName, Integer num1, Integer num2, String time, String sort) {
        List<ReputationPortraitInfoPO> list=reputationPortraitInfoMapper.queryReputationPortraitInfoByCopyrightName(copyrightName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ReputationPortraitInfoPO> queryReputationPortraitInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ReputationPortraitInfoPO> list=reputationPortraitInfoMapper.queryReputationPortraitInfoByTime(timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    public List<ReputationPortraitInfoPO> queryReputationPortraitInfoOfNameAndId(String name) {
        return reputationPortraitInfoMapper.queryReputationPortraitInfoOfNameAndId(name);
    }
}
