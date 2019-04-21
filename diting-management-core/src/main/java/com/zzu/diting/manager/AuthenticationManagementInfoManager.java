package com.zzu.diting.manager;

import com.zzu.diting.entity.AuthenticationDistributionManagementInfoPO;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/3 10:41
 */
public interface AuthenticationManagementInfoManager {
    void addAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO);
    void deleteAuthenticationManagementInfoById(Long id);
    AuthenticationDistributionManagementInfoPO getAuthenticationManagementInfoById(Long id);
    AuthenticationDistributionManagementInfoPO getAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO);
    void updateAuthenticationManagementInfo(AuthenticationDistributionManagementInfoPO authenticationManagementInfoPO);
    List<AuthenticationDistributionManagementInfoPO> getAllAuthenticationManagementInfo();
}
