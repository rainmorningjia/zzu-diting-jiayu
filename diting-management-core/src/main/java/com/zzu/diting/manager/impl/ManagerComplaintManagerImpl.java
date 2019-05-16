package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.ManagerComplaintInfoPO;
import com.zzu.diting.mappers.ManagerComplaintInfoMapper;
import com.zzu.diting.manager.ManagerComplaintManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 14:26
 */
@Service("managerComplaintManager")
@Transactional
public class ManagerComplaintManagerImpl implements ManagerComplaintManager {
    @Resource
    ManagerComplaintInfoMapper managerComplaintInfoMapper;
    @Override
    public void addManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO) {
        managerComplaintInfoMapper.insert(managerComplaintInfoPO);
    }

    @Override
    public void deleteManagerComplaintById(Long id) {
        managerComplaintInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ManagerComplaintInfoPO getManagerComplaintById(Long id) {
        ManagerComplaintInfoPO managerComplaintInfoPO=managerComplaintInfoMapper.selectByPrimaryKey(id);
        return managerComplaintInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ManagerComplaintInfoPO getManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO) {
        ManagerComplaintInfoPO managerComplaintInfoPO1=managerComplaintInfoMapper.selectOne(managerComplaintInfoPO);
        return managerComplaintInfoPO1;
    }

    @Override
    public void updateManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO) {
        managerComplaintInfoMapper.updateByPrimaryKeySelective(managerComplaintInfoPO);
    }

    @Override
    public Set<Long> getComplaintsByListId(List<Long> longs) {
        Set<Long> set=new HashSet<>();
        for (Long l:
             longs) {
           ManagerComplaintInfoPO managerComplaintInfoPO=managerComplaintInfoMapper.selectByPrimaryKey(l);
           set.add(managerComplaintInfoPO.getComplaintsId());
        }
        return set;
    }

    @Override
    public List<ManagerComplaintInfoPO> getManagerComplaintsAll(String userId, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsAll(userId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByResult(String userId, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByResult(userId,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByIdAndAllResult(String userId, List<Long> ids, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByIdAndAllResult(userId,ids,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByIdAndResult(String userId, List<Long> ids, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByIdAndResult(userId,ids,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintPersonAndAllResult(String userId, String person, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByHandlePersonAndAllResult(userId,person,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintPersonAndResult(String userId, String person, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByComplaintPersonAndResult(userId,person,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByRightTypeAndAllResult(String userId, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByRightTypeAndAllResult(userId,rightType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByRightTypeAndResult(String userId, String rightType, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByRightTypeAndResult(userId,rightType,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByRightNameAndAllResult(String userId, String rightName, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByRightTypeAndAllResult(userId,rightName,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByRightNameAndResult(String userId, String rightName, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByRightNameAndResult(userId,rightName,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintUrlAndAllResult(String userId, String complaintUrl, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByComplaintUrlAndAllResult(userId,complaintUrl,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintUrlAndResult(String userId, String complaintUrl, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByComplaintUrlAndResult(userId,complaintUrl,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByHandlePersonAndAllResult(String userId, String handlePerson, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByHandlePersonAndAllResult(userId,handlePerson,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByHandlePersonAndResult(String userId, String handlePerson, String result, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByHandlePersonAndResult(userId,handlePerson,result,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByTimeAndAllResult(String userId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByTimeAndAllResult(userId,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintsByTimeAndResult(String userId, String timeType, String result, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintsByTimeAndResult(userId,result,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndAllTypeAndAllState(Long complaintsId, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndAllTypeAndAllState(complaintsId,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndAllTypeAndOneState(Long complaintsId, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndAllTypeAndOneState(complaintsId,state,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(Long complaintsId, List<Long> ids, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(complaintsId,ids,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndListIdAndAllTypeAndOneState(Long complaintsId, List<Long> ids, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(complaintsId,ids,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndOneTypeAndAllState(Long complaintsId, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndOneTypeAndAllState(complaintsId,rightType,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndOneTypeAndOneState(Long complaintsId, String rightType, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndOneTypeAndOneState(complaintsId,rightType,state,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndUrlAndAllTypeAndAllState(Long complaintsId, String url, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndUrlAndAllTypeAndAllState(complaintsId,url,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndUrlAndAllTypeAndOneState(Long complaintsId, String url, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndUrlAndAllTypeAndOneState(complaintsId,url,state,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndAllState(Long complaintsId, String handlePerson, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndAllState(complaintsId,handlePerson,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndOneState(Long complaintsId, String handlePerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndOneState(complaintsId,handlePerson,state,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndTimeAndAllTypeAndAllState(Long complaintsId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndTimeAndAllTypeAndAllState(complaintsId,timeType,startTime,endTime,num1,num2,time,sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndTimeAndAllTypeAndOneState(Long complaintsId, String timeType, Long startTime, Long endTime, String state, Integer num1, Integer num2, String time, String sort) {
        List<ManagerComplaintInfoPO> list=managerComplaintInfoMapper.queryManagerComplaintByComplaintsIdAndTimeAndAllTypeAndOneState(complaintsId,timeType,startTime,endTime,state,num1,num2,time,sort);
        return list;
    }
}
