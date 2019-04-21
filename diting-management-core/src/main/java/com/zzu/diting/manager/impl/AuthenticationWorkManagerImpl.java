package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.AuthenticationWorkInfoPO;
import com.zzu.diting.mapper.AuthenticationWorkInfoMapper;
import com.zzu.diting.manager.AuthenticationWorkManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 17:58
 */
@Service
@Transactional
public class AuthenticationWorkManagerImpl implements AuthenticationWorkManager {
    @Resource
    AuthenticationWorkInfoMapper authenticationWorkInfoMapper;

    @Override
    public void addAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO) {
        authenticationWorkInfoMapper.insert(authenticationWorkInfoPO);
    }

    @Override
    public void deleteAuthenticationWorkInfoById(Long id) {
        authenticationWorkInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO) {
        authenticationWorkInfoMapper.updateByPrimaryKeySelective(authenticationWorkInfoPO);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthenticationWorkInfoPO getAuthenticationWorkInfoById(Long id) {
        AuthenticationWorkInfoPO authenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(id);
        return authenticationWorkInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthenticationWorkInfoPO getAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO) {
        AuthenticationWorkInfoPO authenticationWorkInfoPO1 = authenticationWorkInfoMapper.selectOne(authenticationWorkInfoPO);
        return authenticationWorkInfoPO1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksAndAllAuditState(Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksAndAllAuditState(num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksAndAuditState(String auditState, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksAndAuditState(auditState, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByOrderTypeAndAllState(String orderType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndAllState(orderType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByOrderTypeAndState(String orderType, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndState(orderType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorkByNicknameAndAllState(String nickname, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndAllState(nickname, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorkByNicknameAndState(String nickname, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndState(nickname, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByRealNameAndAllState(String realName, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndAllState(realName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByRealNameAndState(String realName, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndState(realName, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByUserTypeAndAllState(String userType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndAllState(userType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByUserTypeAndState(String userType, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndState(userType, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByHandlePersonAndAllState(String handlePerson, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByHandlePersonAndAllState(handlePerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByHandlePersonAndState(String handlePerson, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByHandlePersonAndState(handlePerson, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByTimeAndAllState(String timeType, Long t1, Long t2, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByTimeAndAllState(timeType, t1, t2, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByTimeAndState(String timeType, String state, Long t1, Long t2, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState(timeType, state, t1, t2, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getAllWorksByMIdAndPendingDisposalAndState(Long aId, String state, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryAllWorksByMIdAndPendingDisposalAndState(aId, state, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndWorkIdAndState(Long aId, String state, Long workId, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndWorkIdAndState(aId, state, workId, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndOrderTypeAndState(Long aId, String state, String orderType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndOrderTypeAndState(aId, state, orderType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndUserIdAndState(Long aId, String state, Long userId, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserIdAndState(aId, state, userId, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndNicknameAndState(Long aId, String state, String nickname, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndNicknameAndState(aId, state, nickname, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndRealNameAndState(Long aId, String state, String realName, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndRealNameAndState(aId, state, realName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndUserTypeAndState(Long aId, String state, String userType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserTypeAndState(aId, state, userType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndHandlePersonAndState(Long aId, String state, String handlePerson, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(aId, state, handlePerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndTimeAndState(Long aId, String state, String timeType, Long t1, Long t2, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(aId, state, timeType, t1, t2, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndTimeAndAllState(Long aId, String timeType, Long t1, Long t2, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndTimeAndAllState(aId, timeType, t1, t2, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndHandlePersonAndAllState(Long aId, String handlePerson, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndHandlePersonAndAllState(aId, handlePerson, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndUserTypeAndAllState(Long aId, String userType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndUserTypeAndAllState(aId, userType, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndRealNameAndAllState(Long aId, String realName, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndRealNameAndAllState(aId, realName, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndNicknameAndAllState(Long aId, String nickname, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndNicknameAndAllState(aId, nickname, num1, num2, time, sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndOrderTypeAndAllState(Long aId, String orderType, Integer num1, Integer num2, String time, String sort) {
        List<AuthenticationWorkInfoPO> list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndOrderTypeAndAllState(aId, orderType, num1, num2, time, sort);
        return list;
    }
}
