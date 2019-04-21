package com.zzu.diting.controller;

import com.aliyun.oss.OSSClient;
import com.zzu.diting.dto.AuthenticationResultDto;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.entity.*;
import com.zzu.diting.service.UserAuthenticationService;
import com.zzu.diting.service.UserService;
import com.zzu.diting.util.DataObjectTransDto;
import com.zzu.diting.util.FileUtil;
import com.zzu.diting.util.OSSClientUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author Miles
 * @Title: UserAuthenticationController
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/19--20:23
 */
@RequestMapping("userAuthentication")
@Controller
public class UserAuthenticationController {
    private String s = "认证失败";
    private String s1 = "未认证";
    private String s2 = "审核中";
    @Resource
    UserAuthenticationService userAuthenticationService;
    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("userAuthenticationInfo")
    public AuthenticationResultDto userAuthenticationInfo(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        AuthenticationResultDto authenticationResultDto = new AuthenticationResultDto();
        String state = userAuthenticationService.getUserAuthenticationStateByUserId(userId);
        if (state.equals(s)) {
            authenticationResultDto.setState("未通过");
            String reason = userAuthenticationService.getFailReasonByUserId(userId);
            authenticationResultDto.setReason(reason);
            return authenticationResultDto;
        } else if (state.equals(s1)) {
            authenticationResultDto.setState("未认证");
            return authenticationResultDto;

        } else if (state.equals(s2)) {
            authenticationResultDto.setState("审核中");
            return authenticationResultDto;
        } else {
            OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = userAuthenticationService.getUserAuthenticationOrganizationByUserId(userId);
            if (organizationAuthenticationInfoPO != null) {
                Object o = DataObjectTransDto.populate(organizationAuthenticationInfoPO, authenticationResultDto);
                authenticationResultDto = (AuthenticationResultDto) o;
                authenticationResultDto.setType(2);
                return authenticationResultDto;
            } else {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = userAuthenticationService.getUserAuthenticationPersonByUserId(userId);
                if (personalAuthenticationInfoPO != null) {
                    Object o = DataObjectTransDto.populate(personalAuthenticationInfoPO, authenticationResultDto);
                    authenticationResultDto = (AuthenticationResultDto) o;
                    authenticationResultDto.setType(1);
                    return authenticationResultDto;
                } else {
                    authenticationResultDto.setType(0);
                    return authenticationResultDto;
                }
            }

        }

    }

    @RequestMapping("addUserAuthentication")
    @ResponseBody
    public MessageDto addUserAuthenticationInfo(AuthenticationResultDto authenticationResultDto, MultipartFile file1, MultipartFile file2, MultipartFile file3, HttpServletRequest request) {
        MessageDto messageDto = new MessageDto();
        OSSClient client = OSSClientUtil.getOSSClient();
        try {
            Integer userAuthenticationType = authenticationResultDto.getType();
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setUserName(name);
            Long id = userService.getUserByUserInfo(userInfoPO).getId();
            if (userAuthenticationType == 0) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                Object o = DataObjectTransDto.populate(authenticationResultDto, personalAuthenticationInfoPO);
                personalAuthenticationInfoPO = (PersonalAuthenticationInfoPO) o;
                personalAuthenticationInfoPO.setUserId(id);
                personalAuthenticationInfoPO.setCreateTime(System.currentTimeMillis());
                personalAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                personalAuthenticationInfoPO.setAuthenticationResult("待审核");
                personalAuthenticationInfoPO.setRecentlyOperator("内部创建");
                personalAuthenticationInfoPO.setRecentlyUpdateType("内部创建");
                File files1 = FileUtil.transerFile(file1, request);
                String[] s1 = OSSClientUtil.uploadObject2OSS(client, files1, "zzu-diting", personalAuthenticationInfoPO.getRealName());
                String positiveUrl = OSSClientUtil.getUrl(client, "zzu-diting", s1[1]);
                personalAuthenticationInfoPO.setCertificatePositiveUrl(positiveUrl);
                File files2 = FileUtil.transerFile(file2, request);
                String[] s2 = OSSClientUtil.uploadObject2OSS(client, files2, "zzu-diting", personalAuthenticationInfoPO.getRealName());
                String oppsiteUrl = OSSClientUtil.getUrl(client, "zzu-diting", s2[1]);
                personalAuthenticationInfoPO.setCertificateOppositeUrl(oppsiteUrl);
                File files3 = FileUtil.transerFile(file3, request);
                String[] s3 = OSSClientUtil.uploadObject2OSS(client, files3, "zzu-diting", personalAuthenticationInfoPO.getRealName());
                String handofUrl = OSSClientUtil.getUrl(client, "zzu-diting", s3[1]);
                personalAuthenticationInfoPO.setCertificateHandofUrl(handofUrl);
                OSSClientUtil.stopOssClinet();
                userAuthenticationService.addUserAuthenticationPerson(personalAuthenticationInfoPO);
                userInfoPO.setAuthenticationState(1);
                userInfoPO.setId(id);
                System.out.println(userInfoPO);
                userService.updateUser(userInfoPO);
            } else {

                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                Object o = DataObjectTransDto.populate(authenticationResultDto, organizationAuthenticationInfoPO);
                File files1 = FileUtil.transerFile(file1, request);
                String[] s1 = OSSClientUtil.uploadObject2OSS(client, files1, "zzu-diting", organizationAuthenticationInfoPO.getOrganizationName());
                String positiveUrl = OSSClientUtil.getUrl(client, "zzu-diting", s1[1]);
                organizationAuthenticationInfoPO = (OrganizationAuthenticationInfoPO) o;
                ((OrganizationAuthenticationInfoPO) o).setCertificatePositiveUrl(positiveUrl);
                organizationAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                organizationAuthenticationInfoPO.setCreateTime(System.currentTimeMillis());
                organizationAuthenticationInfoPO.setUserId(id);
                organizationAuthenticationInfoPO.setRecentlyUpdateType("内部创建");
                organizationAuthenticationInfoPO.setRecentlyOperator("内部创建");
                organizationAuthenticationInfoPO.setAuthenticationResult("待审核");
                OSSClientUtil.stopOssClinet();
                userAuthenticationService.addUserAuthenticationOrganization(organizationAuthenticationInfoPO);
                userInfoPO.setAuthenticationState(1);
                userInfoPO.setId(id);
                userService.updateUser(userInfoPO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("系统异常");
            return messageDto;
        }
        messageDto.setCode(0);
        messageDto.setMessage("添加成功");
        return messageDto;
    }

    @ResponseBody
    @RequestMapping("updateUserPerson")
    public MessageDto UpdateUserPersonAuthenticationInfo(AuthenticationResultDto AuthenticationResultDto) {
        MessageDto messageDto = new MessageDto();
        try {
            PersonalAuthenticationUpdateInfoPO personalAuthenticationUpdateInfoPO = new PersonalAuthenticationUpdateInfoPO();
            Object o = DataObjectTransDto.populate(AuthenticationResultDto, personalAuthenticationUpdateInfoPO);
            personalAuthenticationUpdateInfoPO = (PersonalAuthenticationUpdateInfoPO) o;
            personalAuthenticationUpdateInfoPO.setCreateTime(System.currentTimeMillis());
            personalAuthenticationUpdateInfoPO.setUpdateTime(System.currentTimeMillis());
            userAuthenticationService.addUserAuthenticationUpdatePersonInfo(personalAuthenticationUpdateInfoPO);
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage("系统异常");
            return messageDto;
        }
        messageDto.setCode(0);
        messageDto.setMessage("修改成功");
        return messageDto;
    }

    @RequestMapping("updateUserOrganization")
    @ResponseBody
    public MessageDto UpdateUserOrganizationAuthenticationInfo(AuthenticationResultDto AuthenticationResultDto) {
        MessageDto messageDto = new MessageDto();
        try {
            OrganizationAuthenticationUpdateInfoPO organizationAuthenticationUpdateInfoPO = new OrganizationAuthenticationUpdateInfoPO();
            Object o = DataObjectTransDto.populate(AuthenticationResultDto, organizationAuthenticationUpdateInfoPO);
            organizationAuthenticationUpdateInfoPO = (OrganizationAuthenticationUpdateInfoPO) o;
            organizationAuthenticationUpdateInfoPO.setCreateTime(System.currentTimeMillis());
            organizationAuthenticationUpdateInfoPO.setUpdateTime(System.currentTimeMillis());
            userAuthenticationService.addUserAuthenticationUpdateOrganizationInfo(organizationAuthenticationUpdateInfoPO);
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage("系统异常");
            return messageDto;
        }
        messageDto.setCode(0);
        messageDto.setMessage("修改成功");
        return messageDto;

    }
}
