package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.AuthenticationDistributionManagementInfoPO;
import com.zzu.diting.mappers.AuthenticationDistributionManagementInfoMapper;
import com.zzu.diting.manager.AuthenticationManagementInfoManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @date : 2019/4/3 10:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthenticationManagementManagerImpl implements AuthenticationManagementInfoManager {
    @Resource
    AuthenticationDistributionManagementInfoMapper authenticationManagementInfoMapper;

    @Override
    public void addAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO) {
        authenticationManagementInfoMapper.insert(authenticationManagementInfoPO);
    }

    @Override
    public void deleteAuthenticationManagementInfoById(Long id) {
        authenticationManagementInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthenticationDistributionManagementInfoPO getAuthenticationManagementInfoById(Long id) {
        AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO;
        authenticationManagementInfoPO = authenticationManagementInfoMapper.selectByPrimaryKey(id);
        return authenticationManagementInfoPO;
    }

    @Override
    public AuthenticationDistributionManagementInfoPO getAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO) {
        AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO1;
        authenticationManagementInfoPO1 = authenticationManagementInfoMapper.selectOne(authenticationManagementInfoPO);
        return authenticationManagementInfoPO1;
    }

    @Override
    public void updateAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO) {
        authenticationManagementInfoMapper.updateByPrimaryKeySelective(authenticationManagementInfoPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AuthenticationDistributionManagementInfoPO> getAllAuthenticationManagementInfo() {
        List<AuthenticationDistributionManagementInfoPO> list;
        list = authenticationManagementInfoMapper.selectAll();
        return list;
    }
}
