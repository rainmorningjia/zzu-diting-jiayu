package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.rightaudit.AddRightAuditQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditFormQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditTablesDto;
import com.zzu.diting.service.RightAuditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
=======
>>>>>>> a16dbfba1920490a6fd73b14f1ee04ede432a9b7

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
<<<<<<< HEAD
    public MessageDto addRightAuditInfo(AddRightAuditQueryParam addRightAuditQueryParam, HttpServletRequest request) {
        HttpSession session=request.getSession();
        String opreatorName=(String) session.getAttribute("name");
        String id=(String)session.getAttribute("managerId") ;
        addRightAuditQueryParam.setDistributionId(id);
        addRightAuditQueryParam.setOperatorName(opreatorName);
=======
    public MessageDto addRightAuditInfo(AddRightAuditQueryParam addRightAuditQueryParam) {
>>>>>>> a16dbfba1920490a6fd73b14f1ee04ede432a9b7
        MessageDto messageDto;
        messageDto = rightAuditService.addRightAuditInfo(addRightAuditQueryParam);
        return messageDto;
    }
}
