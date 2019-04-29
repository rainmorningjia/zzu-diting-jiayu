package com.zzu.diting.controller;

import com.aliyun.oss.OSSClient;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.UserAuthenticationFormDto;
import com.zzu.diting.dto.UserAuthenticationInfoDto;
import com.zzu.diting.dto.UserAuthenticationInfoQueryParam;
import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import com.zzu.diting.entity.UserInfoPO;
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
import javax.servlet.http.HttpSession;
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
    public UserAuthenticationInfoDto getUserAuthenticationInfoByUserId(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        UserAuthenticationFormDto userAuthenticationFormDto = new UserAuthenticationFormDto();
        UserAuthenticationInfoDto userAuthenticationInfoDto = new UserAuthenticationInfoDto();
        OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = userAuthenticationService.getUserAuthenticationOrganizationByUserId(userId);
        if (organizationAuthenticationInfoPO != null) {
            Object o = DataObjectTransDto.populate(organizationAuthenticationInfoPO, userAuthenticationInfoDto);
            userAuthenticationInfoDto = (UserAuthenticationInfoDto) o;
            userAuthenticationInfoDto.setAuthenticationType(1);
            return userAuthenticationInfoDto;
        } else {
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = userAuthenticationService.getUserAuthenticationPersonByUserId(userId);
            if (personalAuthenticationInfoPO != null) {
                Object o = DataObjectTransDto.populate(personalAuthenticationInfoPO, userAuthenticationInfoDto);
                userAuthenticationInfoDto = (UserAuthenticationInfoDto) o;
                userAuthenticationInfoDto.setAuthenticationType(0);
                return userAuthenticationInfoDto;
            } else {

                return null;
            }
        }
    }

   /* public MessageDto updateUserAuthenticationInfo(UserAuthenticationInfoQueryParam userAuthenticationInfo, HttpServletRequest request) {
        MessageDto messageDto = new MessageDto();
        try {
            HttpSession session = request.getSession();
            Long userId = (Long) session.getAttribute("userId");

            if (userAuthenticationInfo.getAuthenticationType() == 0) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                personalAuthenticationInfoPO = (PersonalAuthenticationInfoPO) DataObjectTransDto.populate(userAuthenticationInfo, personalAuthenticationInfoPO);
                userAuthenticationService.addUserAuthenticationUpdatePersonInfo(personalAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            } else {
                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                organizationAuthenticationInfoPO = (OrganizationAuthenticationInfoPO) DataObjectTransDto.populate(userAuthenticationInfo, organizationAuthenticationInfoPO);
                userAuthenticationService.addUserAuthenticationUpdateOrganizationInfo(organizationAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("修改信息失败");
            return messageDto;
        }
    }*/

    @RequestMapping("addUserAuthentication")
    @ResponseBody
    public MessageDto addUserAuthenticationInfo(UserAuthenticationInfoQueryParam userAuthenticationInfoQueryParam, MultipartFile file1, MultipartFile file2, MultipartFile file3, HttpServletRequest request) {
        MessageDto messageDto = new MessageDto();
        OSSClient client = OSSClientUtil.getOSSClient();
        try {
            Integer userAuthenticationType = userAuthenticationInfoQueryParam.getAuthenticationType();
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setUserName(name);
            Long id = userService.getUserByUserInfo(userInfoPO).getId();
            if (userAuthenticationType == 0) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                Object o = DataObjectTransDto.populate(userAuthenticationInfoQueryParam, personalAuthenticationInfoPO);
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
                Object o = DataObjectTransDto.populate(userAuthenticationInfoQueryParam, organizationAuthenticationInfoPO);
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
    @RequestMapping("updateUserNoAuthen")
    public MessageDto updateUserNoAuthenticationInfo(UserAuthenticationInfoQueryParam userAuthenticationInfo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        userAuthenticationInfo.setUserId(userId);
        MessageDto messageDto = new MessageDto();
        Integer userAuthenticationType = userAuthenticationInfo.getAuthenticationType();
        try {
            if (userAuthenticationType == 0) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                Object o = DataObjectTransDto.populate(userAuthenticationInfo, personalAuthenticationInfoPO);
                personalAuthenticationInfoPO = (PersonalAuthenticationInfoPO) o;
                personalAuthenticationInfoPO.setId(userAuthenticationInfo.getId());
                userAuthenticationService.UpdateUserAuthenticationPerson(personalAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            } else {
                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                Object o = DataObjectTransDto.populate(userAuthenticationInfo, organizationAuthenticationInfoPO);
                organizationAuthenticationInfoPO = (OrganizationAuthenticationInfoPO) o;
                organizationAuthenticationInfoPO.setId(userAuthenticationInfo.getId());
                userAuthenticationService.UpdateUserAuthenticationOrganization(organizationAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("系统异常");
            return messageDto;
        }

    }


    @RequestMapping("updateUserAutentication")
    @ResponseBody
    public MessageDto updateUserAuthenticationInfo(UserAuthenticationInfoQueryParam userAuthenticationInfo) {
        MessageDto messageDto = new MessageDto();
        try {

            userAuthenticationInfo.setUserId(new Long("2000223007"));
            if (userAuthenticationInfo.getAuthenticationType() == 0) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                personalAuthenticationInfoPO = (PersonalAuthenticationInfoPO) DataObjectTransDto.populate(userAuthenticationInfo, personalAuthenticationInfoPO);
                userAuthenticationService.addUserAuthenticationUpdatePersonInfo(personalAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            } else {
                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                organizationAuthenticationInfoPO = (OrganizationAuthenticationInfoPO) DataObjectTransDto.populate(userAuthenticationInfo, organizationAuthenticationInfoPO);
                userAuthenticationService.addUserAuthenticationUpdateOrganizationInfo(organizationAuthenticationInfoPO);
                messageDto.setCode(0);
                messageDto.setMessage("修改信息成功");
                return messageDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("修改信息失败");
            return messageDto;
        }
    }
}
