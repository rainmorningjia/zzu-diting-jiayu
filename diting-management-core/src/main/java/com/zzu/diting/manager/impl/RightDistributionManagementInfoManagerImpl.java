package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.RightDistributionManagementInfoPO;
import com.zzu.diting.mappers.RightDistributionManagementInfoMapper;
import com.zzu.diting.manager.RightDistributionManagementInfoManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/3 11:34
 */
@Service
@Transactional
public class RightDistributionManagementInfoManagerImpl implements RightDistributionManagementInfoManager {

    @Resource
    RightDistributionManagementInfoMapper rightDistributionManagementInfoMapper;

    @Override
    public void addRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO) {
        rightDistributionManagementInfoMapper.insert(rightDistributionManagementInfoPO);
    }

    @Override
    public void deleteRightDistributionManagementInfoById(Long id) {
        rightDistributionManagementInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RightDistributionManagementInfoPO getRightDistributionManagementInfoById(Long id) {
        RightDistributionManagementInfoPO rightDistributionManagementInfoPO=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoById(id);
        return rightDistributionManagementInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RightDistributionManagementInfoPO getRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO) {
        RightDistributionManagementInfoPO rightDistributionManagementInfoPO1=rightDistributionManagementInfoMapper.selectOne(rightDistributionManagementInfoPO);
        return rightDistributionManagementInfoPO1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoAll(Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoAll(num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByRightType(String rightType, Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByRightType(rightType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoWorkType(String workType, Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoWorkType(workType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByDistributionName(String distributionName, Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByDistributionName(distributionName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByOperatorName(String operatorName, Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByOperatorName(operatorName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByTime(String timeType, Long t1, Long t2, Integer num1, Integer num2, String time, String sort) {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByTime(timeType,t1,t2,num1,num2,time,sort);
        return list;
    }

    @Override
    public void updateRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO) {
        rightDistributionManagementInfoMapper.updateByPrimaryKeySelective(rightDistributionManagementInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightDistributionManagementInfoPO> getAll() {
        List<RightDistributionManagementInfoPO> list=rightDistributionManagementInfoMapper.selectAll();
        return list;
    }
}
