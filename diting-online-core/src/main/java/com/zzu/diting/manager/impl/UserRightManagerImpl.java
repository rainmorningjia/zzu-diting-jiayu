package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.RightVO;
import com.zzu.diting.manager.UserRightManager;
import com.zzu.diting.mapper.RightMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 11:29
 */
@Service
@Transactional
public class UserRightManagerImpl implements UserRightManager {

    @Resource
    RightMapper rightMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightsByUserIDAndRightAllAndTypeAll(Long userId, Integer num1, Integer num2, Long t1, Long t2) {
        List<RightVO> rightVOS=rightMapper.queryRightsByUserIDAndRightAllAndTypeAll(userId,num1,num2,t1,t2);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightsByUserIDAndRightAllAndType(Long userId, Integer num1, Integer num2, Long t1, Long t2, String auditState) {
        List<RightVO> rightVOS=rightMapper.queryRightsByUserIDAndRightAllAndType(userId,num1,num2,t1,t2,auditState);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightsByUserIDAndRightAndTypeAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType) {
        List<RightVO> rightVOS=rightMapper.queryRightsByUserIDAndRightAndTypeAll(userId,num1,num2,t1,t2,rightType);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightsByUserIDAndRightAndType(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType, String auditState) {
        List<RightVO> rightVOS=rightMapper.queryRightsByUserIDAndRightAndType(userId,num1,num2,t1,t2,rightType,auditState);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightIdAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightIdAll(userId,num1,num2,t1,t2,id);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightIdType(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id, String rightType) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightIdType(userId,num1,num2,t1,t2,id,rightType);
        return rightVOS;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightIdTypeAndAuditState(Long userId, String auditState, Integer num1, Integer num2, Long t1, Long t2, Long id) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightIdAllTypeAndAuditState(userId,auditState,num1,num2,t1,t2,id);
        return rightVOS;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightIdTypeAndRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id, String rightType, String auditState) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightIdTypeAndRight(userId,num1,num2,t1,t2,id,rightType,auditState);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightNameAndAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightNameAndAll(userId,num1,num2,t1,t2,name);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightNameAndAllStateOneRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String rightType) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightNameAndAllStateOneRight(userId,num1,num2,t1,t2,name,rightType);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightNameAndOneStateAllRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String state) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightNameAndOneStateAllRight(userId,num1,num2,t1,t2,name,state);
        return rightVOS;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RightVO> getRightByUserIDAndRightNameAndOneStateOneRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String state, String rightType) {
        List<RightVO> rightVOS=rightMapper.queryRightByUserIDAndRightNameAndOneStateOneRight(userId,num1,num2,t1,t2,name,state,rightType);
        return rightVOS;
    }
}
