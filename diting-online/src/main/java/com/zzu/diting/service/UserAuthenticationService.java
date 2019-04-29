package com.zzu.diting.service;


import com.zzu.diting.dto.AuthenticationResultDto;
import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :wb-jcy525678
* @ :
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

    void addUserAuthenticationUpdateOrganizationInfo(OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO);

    void addUserAuthenticationUpdatePersonInfo(PersonalAuthenticationInfoPO personalAuthenticationInfoPO);

    AuthenticationResultDto getFailReasonByUserId(Long id);

}
