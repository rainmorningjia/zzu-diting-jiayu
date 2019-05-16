package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RejectInfoQueryParam;
import com.zzu.diting.dto.authenticationwork.AuthenticationDetailDto;
import com.zzu.diting.dto.authenticationwork.AuthenticationDetailFormDto;
import com.zzu.diting.dto.authenticationwork.AuthenticationWorkQueryParam;
import com.zzu.diting.dto.authenticationwork.AuthenticationWorkTableDto;
import com.zzu.diting.service.AuthenticationWorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("authenticationWork")
public class AuthenticationController {
    @Resource
    AuthenticationWorkService authenticationWorkService;

    @RequestMapping("authenticationTable")
    public AuthenticationWorkTableDto getAuthenticationTable(Integer page, Integer rows, Integer state, HttpServletRequest request) {
        String managerId = (String) request.getSession().getAttribute("managerId");
        AuthenticationWorkQueryParam authenticationWorkQueryParam = new AuthenticationWorkQueryParam();
        if (state == 1) {
            authenticationWorkQueryParam.setTableType(1);
        }
        if (state == 2) {
            authenticationWorkQueryParam.setTableType(2);
            authenticationWorkQueryParam.setProcessType(1);
        }
        authenticationWorkQueryParam.setSearchType(1);
        authenticationWorkQueryParam.setPageNumber(page);
        authenticationWorkQueryParam.setRowNumber(rows);
        authenticationWorkQueryParam.setTimeType(1);
        authenticationWorkQueryParam.setSortType(1);
        authenticationWorkQueryParam.setManagerId(managerId);
        AuthenticationWorkTableDto authenticationWorkTable;
        authenticationWorkTable = authenticationWorkService.getAuthenticationWorkTable(authenticationWorkQueryParam);
        return authenticationWorkTable;
    }

    @RequestMapping("getDetail")
    public AuthenticationDetailDto getAuthenDetailInfoByWorkId(Long id) {
        AuthenticationDetailFormDto authenticationDetailFormDto = authenticationWorkService.getAuthenDetailInfoByWorkId(id);
        return authenticationDetailFormDto.getAuthenticationDetailDto();
    }

    @RequestMapping("adoptWork")
    public MessageDto adoptWork(Long id) {
        MessageDto messageDto = authenticationWorkService.adoptAuthenticationWorkById(id);
        return messageDto;
    }

    @RequestMapping("rejectWork")
    public MessageDto rejectWork(RejectInfoQueryParam rejectInfoQueryParam) {
        MessageDto messageDto = authenticationWorkService.rejectWorkById(rejectInfoQueryParam);
        return messageDto;
    }
}
