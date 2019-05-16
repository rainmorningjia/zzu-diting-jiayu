package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.ComplaintDistributionManagementInfoPO;
import com.zzu.diting.mappers.ComplaintDistributionManagementInfoMapper;
import com.zzu.diting.manager.ComplaintDistributionManagementInfoManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/3 10:55
 */
@Service
@Transactional
public class ComplaintDistributionManagementInfoManagerImpl implements ComplaintDistributionManagementInfoManager {

    @Resource
    ComplaintDistributionManagementInfoMapper complaintDistributionManagementInfoMapper;

    @Override
    public void addComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO) {
        complaintDistributionManagementInfoMapper.insert(complaintDistributionManagementInfoPO);
    }

    @Override
    public void deleteComplaintDistributionManagementInfoById(Long id) {
        complaintDistributionManagementInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public ComplaintDistributionManagementInfoPO getComplaintDistributionManagementInfoById(Long id) {
        ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO = complaintDistributionManagementInfoMapper.selectByPrimaryKey(id);
        return complaintDistributionManagementInfoPO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public ComplaintDistributionManagementInfoPO getComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO) {
        ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO1 = complaintDistributionManagementInfoMapper.selectOne(complaintDistributionManagementInfoPO);
        return complaintDistributionManagementInfoPO1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndAll(String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.queryDistributionManagementInfoByRightTypeAndAll(rightType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndComplaintPlatform(String complaintForm, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.queryDistributionManagementInfoByRightTypeAndComplaintPlatform(complaintForm, rightType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndDistributionName(String distributionName, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.queryDistributionManagementInfoByRightTypeAndDistributionName(distributionName, rightType, num1, num1, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndOperatorName(String operatorName, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.queryDistributionManagementInfoByRightTypeAndOperatorName(operatorName, rightType, num1, num1, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndTime(String timeType, Long startTime, Long endTime, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.queryDistributionManagementInfoByRightTypeAndTime(timeType, startTime, endTime, rightType, num1, num1, time, sort);
        return list;
    }

    @Override
    public void updateComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO) {
        complaintDistributionManagementInfoMapper.updateByPrimaryKeySelective(complaintDistributionManagementInfoPO);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintDistributionManagementInfoPO> getAll() {
        List<ComplaintDistributionManagementInfoPO> list = complaintDistributionManagementInfoMapper.selectAll();
        return list;
    }

}
