package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.rightaudit.AddRightAuditQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditFormQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditTablesDto;
import com.zzu.diting.service.RightAuditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("rightDistribution")
public class RightWorkDistributionController {
    @Resource
    private RightAuditService rightAuditService;

    @RequestMapping("getTable")
    public RightAuditTablesDto getRightAuditTableInfo(RightAuditFormQueryParam rightAuditFormQueryParam) {
        RightAuditTablesDto rightAuditTableInfo;
        rightAuditTableInfo = rightAuditService.getRightAuditTableInfo(rightAuditFormQueryParam);
        return rightAuditTableInfo;
    }

    @RequestMapping("addRightAuditPerson")
    public MessageDto addRightAuditInfo(AddRightAuditQueryParam addRightAuditQueryParam) {
        MessageDto messageDto;
        messageDto = rightAuditService.addRightAuditInfo(addRightAuditQueryParam);
        return messageDto;
    }
}
