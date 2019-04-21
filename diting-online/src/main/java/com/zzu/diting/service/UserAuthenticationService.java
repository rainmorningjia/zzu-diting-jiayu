package com.zzu.diting.service;

import com.zzu.diting.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 17:21
 */

public interface UserAuthenticationService {

    void addUserAuthenticationPerson(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    void addUserAuthenticationOrganization(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    String getUserNameAuthenticationByUserId(Long id);

    String getUserAuthenticationStateByUserId(Long id);

    PersonalAuthenticationInfoPO getUserAuthenticationPersonByUserId(Long id);

    OrganizationAuthenticationInfoPO getUserAuthenticationOrganizationByUserId(Long id);

    void UpdateUserAuthenticationPerson(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    void UpdateUserAuthenticationOrganization(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    void addUserAuthenticationUpdateOrganizationInfo(OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO);

    void addUserAuthenticationUpdatePersonInfo(PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO);

    String getFailReasonByUserId(Long id);

}
