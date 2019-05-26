package com.zzu.diting.controller;

import com.aliyun.oss.OSSClient;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.UserInfoDto;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.service.UserService;
import com.zzu.diting.util.Md5Util;
import com.zzu.diting.util.OSSClientUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
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
 * @Title: UserContorller
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/14--13:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String loginUser(String name, String password, String code, HttpSession session) {
        code = code.toLowerCase();
        String codeS = (String) session.getAttribute("code");
        session.setAttribute("managerId", "100");
        session.setAttribute("name", "贾晨雨test");
        if (!code.equals(codeS)) {
            return "redirect:/login.jsp";
        } else {
            try {
                userService.LoginUser(name, password);
                UserInfoPO userInfoPO=new UserInfoPO();
                userInfoPO.setUserName(name);
                 userInfoPO=userService.getUserByUserInfo(userInfoPO);
                    session.setAttribute("userId", userInfoPO.getId());
                 session.setAttribute("userHeadIcon",userInfoPO.getHeadIconUrl());
                return "redirect:/main/main.jsp";
            } catch (RuntimeException e) {
                session.setAttribute("message", e.getMessage());
                return "redirect:/login.jsp";

            }
        }
    }

    @RequestMapping("loginUserName")
    @ResponseBody
    public String loginUserName(String name, HttpServletRequest request) {
        try {
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setUserName(name);
            UserInfoPO userInfoPO1 = userService.getUserByUserInfo(userInfoPO);
            if (userInfoPO1 == null) {
                return "用户不存在!";
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userInfoPO1.getId());
                return "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("getUserInfo")
    @ResponseBody
    public UserInfoPO queryUserInfo() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserName(userName);
        UserInfoPO userInfoPO1 = userService.getUserByUserInfo(userInfoPO);
        return userInfoPO1;
    }

    @RequestMapping("updateUserInfo")
    @ResponseBody
    public MessageDto updateUserInfo(UserInfoPO user, MultipartFile file, HttpServletRequest request) {
        MessageDto messageDto = new MessageDto();
        try {
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setUserName(user.getUserName());
            userInfoPO = userService.getUserByUserInfo(userInfoPO);
            userInfoPO.setCreateTime(System.currentTimeMillis());
            userInfoPO.setUpdateTime(System.currentTimeMillis());
            userInfoPO.setAuthenticationState(user.getAuthenticationState());
            userInfoPO.setAddress(user.getAddress());
            userInfoPO.setAge(user.getAge());
            userInfoPO.setEmail(user.getEmail());
            userInfoPO.setPhone(user.getPhone());
            userInfoPO.setSign(user.getSign());
            userInfoPO.setSex(user.getSex());
            String password = user.getPassword();
            String salt = Md5Util.getSalt();
            String s = new SimpleHash("MD5", password, salt, 1024).toString();
            userInfoPO.setPassword(s);
            userInfoPO.setSalt(salt);
            OSSClient client = OSSClientUtil.getOSSClient();
            File file1 = null;
            if (file!=null) {
                if (!file.isEmpty()) {
                    String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
                    File dir = new File(filePath);
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    String path = filePath + file.getOriginalFilename();
                    //save to the /upload path
                    file1 = new File(path);
                    FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
                }
                String[] s1 = OSSClientUtil.uploadObject2OSS(client, file1, "zzu-diting", user.getUserName());
                String headUrl = OSSClientUtil.getUrl(client, "zzu-diting", s1[1]);
                userInfoPO.setHeadIconUrl(headUrl);
            }else {
                userInfoPO.setHeadIconUrl("未填写");
            }
            userService.updateUser(userInfoPO);
            messageDto.setCode(0);
            messageDto.setMessage("修改成功");
            return messageDto;
        } catch (Exception e) {
            messageDto.setCode(1);
            return messageDto;
        }
    }

    @RequestMapping("addUser")
    public String addUser(UserInfoPO user, MultipartFile file, HttpSession session, HttpServletRequest request, String code) {
        try {
            String code2 = (String) session.getAttribute("code");
            if (code2.equals(code.toLowerCase())) {
                OSSClient client = OSSClientUtil.getOSSClient();
                File file1 = null;
                if (!file.isEmpty()) {
                    String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
                    File dir = new File(filePath);
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    String path = filePath + file.getOriginalFilename();
                    //save to the /upload path
                    file1 = new File(path);
                    FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
                }

                String[] s1 = OSSClientUtil.uploadObject2OSS(client, file1, "zzu-diting", user.getUserName());
                String headUrl = OSSClientUtil.getUrl(client, "zzu-diting", s1[1]);
                user.setHeadIconUrl(headUrl);
                userService.addUser(user);
            } else {
                session.setAttribute("message","验证码错误");
                return "redirect:/user/regist";
            }
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/user/regist";
        }
    }
    @RequestMapping("exitUser")
    public String exit(HttpSession session){
        session.removeAttribute("userId");
        return "login";
    }

}
