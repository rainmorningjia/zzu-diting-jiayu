package com.zzu.diting.controller;

import com.aliyun.oss.OSSClient;
import com.zzu.diting.dto.UserInfoDto;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.service.UserService;
import com.zzu.diting.util.OSSClientUtil;
import org.apache.commons.io.FileUtils;
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
        if (!code.equals(codeS)) {
            return "redirect:/login.jsp";
        } else {
            try {
                System.out.println(name);
                userService.LoginUser(name, password);
                System.out.println(1);
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
        UserInfoDto userInfoDto = new UserInfoDto();
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserName(userName);
        UserInfoPO userInfoPO1 = userService.getUserByUserInfo(userInfoPO);
        return userInfoPO1;
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
                OSSClientUtil.stopOssClinet();
                user.setHeadIconUrl(headUrl);
                userService.addUser(user);
            } else {
                throw new RuntimeException("验证码错误！");
            }
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/user/regist";
        }
    }

}
