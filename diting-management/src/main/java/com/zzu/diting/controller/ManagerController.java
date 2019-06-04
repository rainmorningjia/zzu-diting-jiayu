package com.zzu.diting.controller;

import com.zzu.diting.dto.rightaudit.ManagerNameAndId;
import com.zzu.diting.entity.ManagerInfo;
import com.zzu.diting.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("getManagerByName")
    @ResponseBody
    public List<ManagerNameAndId> queryManagerNameAndId(String name) {
        List<ManagerNameAndId> list = new ArrayList<>();
        try {
            List<ManagerInfo> list1 = managerService.queryManagerInfoByName(name);
            for (ManagerInfo m :
                    list1) {
                ManagerNameAndId managerNameAndId = new ManagerNameAndId();
                managerNameAndId.setId(m.getId());
                managerNameAndId.setName(m.getName());
                list.add(managerNameAndId);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    @RequestMapping("queit")
    public String queit(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("managerId");
        session.removeAttribute("name");
        return "redirect:/Login_M.jsp";
    }
}
