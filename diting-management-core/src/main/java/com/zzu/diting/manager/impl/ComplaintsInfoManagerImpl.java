package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.ComplaintsInfo;
import com.zzu.diting.mappers.ComplaintsInfoMapper;
import com.zzu.diting.manager.ComplaintsInfoManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 15:52
 */
@Service
@Transactional
public class ComplaintsInfoManagerImpl implements ComplaintsInfoManager {

    @Resource
    ComplaintsInfoMapper complaintsInfoMapper;
    @Override
    public void addComplaintInfo(ComplaintsInfo complaintsInfo) {
        complaintsInfoMapper.insert(complaintsInfo);
    }

    @Override
    public void deleteComplaintInfoById(Long id) {
        complaintsInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateComplaintInfo(ComplaintsInfo complaintsInfo) {
        complaintsInfoMapper.updateByPrimaryKeySelective(complaintsInfo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ComplaintsInfo getComplaintInfoById(Long id) {
        ComplaintsInfo complaintsInfo=complaintsInfoMapper.selectByPrimaryKey(id);
        return complaintsInfo;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ComplaintsInfo getComplaintInfo(ComplaintsInfo complaintsInfo) {
        ComplaintsInfo complaintsInfo1=complaintsInfoMapper.selectOne(complaintsInfo);
        return complaintsInfo1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsAll(String mId, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsAll(mId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByProcessing(String mId, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByProcessing(mId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByProcessingComplete(String mId, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByProcessingComplete(mId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByComId(String mId, Long cId) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByComId(mId,cId);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByPersonAllPro(String mId, String person, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByPersonAllPro(mId,person,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByPersonAndProcessing(String mId, String person, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByPersonAndProcessing(mId,person,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByPersonAndProcessComplete(String mId, String person, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByPersonAndProcessComplete(mId,person,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByListComplaintsIdAll(String mId, List<Long> list, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list1=complaintsInfoMapper.queryComplaintsByListComplaintsIdAll(mId,list,num1,num2,time,sort);
        return list1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByListComplaintsIdProcessing(String mId, List<Long> list, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list1=complaintsInfoMapper.queryComplaintsByListComplaintsIdProcessing(mId,list,num1,num2,time,sort);
        return list1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByListComplaintsIdComplete(String mId, List<Long> list, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list1=complaintsInfoMapper.queryComplaintsByListComplaintsIdComplete(mId,list,num1,num2,time,sort);
        return list1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByComplaintTypeAll(String mId, String complaintType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByComplaintTypeAll(mId,complaintType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByComplaintTypeProcessing(String mId, String complaintType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByComplaintTypeProcessing(mId,complaintType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByComplaintTypeComplete(String mId, String complaintType, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByComplaintTypeComplete(mId,complaintType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByRightNameAll(String mId, String rightName, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByRightNameAll(mId,rightName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByRightNameProcessing(String mId, String rightName, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByRightNameProcessing(mId,rightName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByRightNameComplete(String mId, String rightName, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByRightNameComplete(mId,rightName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByTimeAll(String mId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByTimeAll(mId,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByTimeProcessing(String mId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByTimeProcessing(mId,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ComplaintsInfo> getComplaintsByTimeComplete(String mId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ComplaintsInfo> list=complaintsInfoMapper.queryComplaintsByTimeComplete(mId,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }
}
