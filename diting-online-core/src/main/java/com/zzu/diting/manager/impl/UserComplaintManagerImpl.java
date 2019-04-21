package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.UserComplaintInfoPO;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.manager.UserComplaintManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 12:41
 */
@Service
@Transactional
public class UserComplaintManagerImpl implements UserComplaintManager {
    @Resource
    UserComplaintInfoMapper userComplaintInfoMapper;

    @Override
    public void addUserComplaint(UserComplaintInfoPO complaintInfoPO) {
        userComplaintInfoMapper.insert(complaintInfoPO);
    }

    @Override
    public void deleteUserComplaintById(Long id) {
        userComplaintInfoMapper.deleteByPrimaryKey(id);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public UserComplaintInfoPO getUserComplaint(Long id) {
        UserComplaintInfoPO userComplaintInfoPO=userComplaintInfoMapper.selectByPrimaryKey(id);
        return userComplaintInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public UserComplaintInfoPO getUserComplaint(UserComplaintInfoPO userComplaintInfoPO) {
        UserComplaintInfoPO userComplaintInfoPO1=userComplaintInfoMapper.selectOne(userComplaintInfoPO);
        return userComplaintInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getListComplaintByPageAndTimeAndAll(Long userId, Integer num1, Integer num2, Long t1, Long t2) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryListComplaintByPageAndTimeAndAll(userId,num1,num2,t1,t2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintsAllRightAndState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String processState) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintsAllRightAndState(userId,num1,num2,t1,t2,processState);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintsRightAndAllState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintsRightAndAllState(userId,num1,num2,t1,t2,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintsRightAndState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType, String processState) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintsRightAndState(userId,num1,num2,t1,t2,rightType,processState);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByIdAllRightAndAllState(Long userId, Long id, Integer num1, Integer num2, Long t1, Long t2) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByIdAllRightAndAllState(userId,id,num1,num2,t1,t2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByIdRightAndAllState(Long userId, Long id, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByIdRightAndAllState(userId,id,num1,num2,t1,t2,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByIdAllRightAndState(Long userId, Long id, Integer num1, Integer num2, Long t1, Long t2, String state) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByIdAllRightAndState(userId,id,num1,num2,t1,t2,state);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByIdRightAndState(Long userId, Long id, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByIdRightAndState(userId,id,num1,num2,t1,t2,state,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByUrlAndAllRightAndAllState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByUrlAndAllRightAndAllState(userId,url,num1,num2,t1,t2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByUrlAndOneRightAndAllState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByUrlAndOneRightAndAllState(userId,url,num1,num2,t1,t2,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByUrlAndAllRightAndOneState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String state) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByUrlAndAllRightAndOneState(userId,url,num1,num2,t1,t2,state);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByUrlAndOneRightAndOneState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByUrlAndOneRightAndOneState(userId,url,num1,num2,t1,t2,state,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByNameAndAllRightAndAllState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByNameAndAllRightAndAllState(userId,name,num1,num2,t1,t2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByNameAndOneRightAndAllState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByNameAndOneRightAndAllState(userId,name,num1,num2,t1,t2,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByNameAndAllRightAndOneState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String state) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByNameAndAllRightAndOneState(userId,name,num1,num2,t1,t2,state);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByNameAndOneRightAndOneState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByNameAndOneRightAndOneState(userId,name,num1,num2,t1,t2,state,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByRightIdAndAllRightAndAllState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByRightIdAndAllRightAndAllState(userId,rightId,num1,num2,t1,t2);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByRightIdAndOneRightAndAllState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByRightIdAndOneRightAndAllState(userId,rightId,num1,num2,t1,t2,rightType);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByRightIdAndAllRightAndOneState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String state) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByRightIdAndAllRightAndOneState(userId,rightId,num1,num2,t1,t2,state);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserComplaintInfoPO> getComplaintByRightIdAndOneRightAndOneState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType) {
        List<UserComplaintInfoPO> list=userComplaintInfoMapper.queryComplaintByRightIdAndOneRightAndOneState(userId,rightId,num1,num2,t1,t2,state,rightType);
        return list;
    }

    @Override
    public void updateUserComplaint(UserComplaintInfoPO userComplaintInfoPO) {
        userComplaintInfoMapper.updateByPrimaryKeySelective(userComplaintInfoPO);
    }
}
