package com.zzu.diting.controller;

import com.zzu.diting.entity.ManagerInfo;
import com.zzu.diting.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("manager")
public class ManagerController {
    @Resource
    ManagerService managerService;

    @RequestMapping("managerLogin")
    public String managerLogin(String name, String password, HttpSession session) {
        try {
            managerService.loginManager(name, password);
            ManagerInfo managerInfo=new ManagerInfo();
            managerInfo.setName(name);
             managerInfo=managerService.getManagerInfo(managerInfo);
             session.setAttribute("managerId",managerInfo.getId());
             session.setAttribute("name",managerInfo.getName());
            return "redirect:/main/main.jsp";
        } catch (RuntimeException e) {
            session.setAttribute("message", e.getMessage());
            return "redirect:/Login_M.jsp";
        }
    }
}
