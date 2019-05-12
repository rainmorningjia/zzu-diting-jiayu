package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.service.ManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("manager")
public class ManagerController {
    @Resource
    ManagerService managerService;

    @RequestMapping("managerLogin")
    public MessageDto managerLogin(String name, String password) {
        MessageDto messageDto = new MessageDto();
        messageDto.setCode(0);
        messageDto.setMessage("登录成功");
        return messageDto;
    }
}
