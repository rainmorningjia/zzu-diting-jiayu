package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.RightWorkInfoPO;
import com.zzu.diting.mappers.RightWorkMapper;
import com.zzu.diting.manager.RightWorkManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 18:40
 */
@Service
@Transactional
public class RightManagerImpl implements RightWorkManager {
    @Resource
    RightWorkMapper rightWorkMapper;

    @Override
    public void addRightWorkInfo(RightWorkInfoPO rightWorkInfoPO) {
        rightWorkMapper.insert(rightWorkInfoPO);
    }

    @Override
    public void deleteRightWorkById(Long id) {
        rightWorkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRightWork(RightWorkInfoPO rightWorkInfoPO) {
        rightWorkMapper.updateByPrimaryKeySelective(rightWorkInfoPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public RightWorkInfoPO getRightWorkById(Long id) {
        RightWorkInfoPO rightWorkInfoPO = rightWorkMapper.selectByPrimaryKey(id);
        return rightWorkInfoPO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public RightWorkInfoPO getRightWork(RightWorkInfoPO rightWorkInfoPO) {
        RightWorkInfoPO rightWorkInfoPO1 = rightWorkMapper.selectOne(rightWorkInfoPO);
        return rightWorkInfoPO1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByAllState(Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByAllState(num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByState(String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByState(state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByOrderTypeAndAllState(String orderType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByOrderTypeAndAllState(orderType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByOrderTypeAndState(String orderType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByOrderTypeAndState(orderType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightTypeAndAllState(String rightType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightTypeAndAllState(rightType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightTypeAndState(String rightType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightTypeAndState(rightType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightNameAndAllState(String rightName, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightNameAndAllState(rightName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightNameAndState(String rightName, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightNameAndState(rightName, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightPersonAndAllState(String rightPerson, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightPersonAndAllState(rightPerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByRightPersonAndState(String rightPerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByRightPersonAndState(rightPerson, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByUserTypeAndAllState(String userType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByUserTypeAndAllState(userType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByUserTypeAndState(String userType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByUserTypeAndState(userType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByHandlePersonAndAllState(String handlerPerson, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByHandlePersonAndAllState(handlerPerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByHandlePersonAndState(String handlerPerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByHandlePersonAndState(handlerPerson, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByTimeTypeAndAllState(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByTimeTypeAndAllState(timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getAllWorksByTimeTypeAndState(String timeType, String state, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryAllWorksByTimeTypeAndState(timeType, state, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndState(String mId, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndState(mId, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndProcessedState(String mId, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndAllProcessed(mId, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndOrderTypeAndAllProcessed(String mId, String orderType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndOrderTypeAndAllProcessed(mId, orderType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndOrderTypeAndState(String mId, String orderType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndOrderTypeAndState(mId, orderType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightTypeAndAllProcessed(String mId, String rightType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightTypeAndAllProcessed(mId, rightType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightTypeAndState(String mId, String rightType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightTypeAndState(mId, sort, rightType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightNameAndAllProcessed(String mId, String rightName, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightNameAndAllProcessed(mId, rightName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightNameAndState(String mId, String rightName, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightNameAndState(mId, rightName, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightPersonAndAllProcessed(String mId, String rightPerson, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightPersonAndAllProcessed(mId, rightPerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndRightPersonAndState(String mId, String rightPerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndRightPersonAndState(mId, rightPerson, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndUserTypeAndAllProcessed(String mId, String userType, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndUserTypeAndAllProcessed(mId, userType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndUserTypeAndState(String mId, String userType, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndUserTypeAndState(mId, userType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndHandlePersonAndAllProcessed(String mId, String handlerPerson, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndHandlePersonAndAllProcessed(mId, handlerPerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndHandlePersonAndState(String mId, String handlerPerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndHandlePersonAndState(mId, handlerPerson, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndTimeTypeAndAllProcessed(String mId, String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndTimeTypeAndAllProcessed(mId, timeType, startTime, endTime, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<RightWorkInfoPO> getWorksByMIdAndTimeTypeAndState(String mId, String timeType, String state, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort) {
        List<RightWorkInfoPO> list = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, timeType, state, startTime, endTime, num1, num2, time, sort);
        return list;
    }
}
