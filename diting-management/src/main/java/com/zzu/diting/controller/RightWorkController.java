package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RejectInfoQueryParam;
import com.zzu.diting.dto.rightwork.*;
import com.zzu.diting.service.RightWorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("rightWork")
public class RightWorkController {
    @Resource
    RightWorkService rightWorkService;

    @RequestMapping("getTable")
    public RightWorkListDto getRightTable(Integer rows, Integer page, Integer rightType, HttpServletRequest request, Integer tableType,Long id,String rightName,String name) {
        String managerId = (String) request.getSession().getAttribute("managerId");
        RightWorkQueryParam rightWorkQueryParam = new RightWorkQueryParam();
        rightWorkQueryParam.setSearchType(4);
        if (id!=null){
            rightWorkQueryParam.setSearchType(2);
            rightWorkQueryParam.setId(id);
        }else if (rightName!=null&&!rightName.equals("")){
            rightWorkQueryParam.setSearchType(5);
            rightWorkQueryParam.setRightName(rightName);
        }else if (name!=null){
            System.out.println("12321321");
            rightWorkQueryParam.setSearchType(7);
            rightWorkQueryParam.setRightPerson(name);
        }

        rightWorkQueryParam.setRightType(rightType);
        rightWorkQueryParam.setManagerId(managerId);
        rightWorkQueryParam.setTableType(tableType);
        rightWorkQueryParam.setProcessType(1);
        rightWorkQueryParam.setTimeType(1);
        rightWorkQueryParam.setSortType(1);
        rightWorkQueryParam.setRowNumber(rows);
        rightWorkQueryParam.setPageNumber(page);
        RightWorkListDto rightWorkListDto;
        rightWorkListDto = rightWorkService.getRightTable(rightWorkQueryParam);
        if (rightWorkListDto.getRows() != null) {
            for (RightWorkTableInfoDto rightWorkTableInfoDto :
                    rightWorkListDto.getRows()) {
                String fail = "驳回";
                if (rightWorkTableInfoDto.getAuditState().equals(fail)) {
                    String reason = rightWorkService.getFailReasonById(rightWorkTableInfoDto.getId());
                    rightWorkTableInfoDto.setFailReason(reason);
                }
            }
        }

        return rightWorkListDto;
    }

    @RequestMapping("adopt")
    public MessageDto adoptWork(Long id) {
        MessageDto messageDto;
        messageDto = rightWorkService.adoptWorkById(id);
        return messageDto;
    }

    @RequestMapping("reject")
    public MessageDto rejectWork(RejectInfoQueryParam rejectInfoQueryParam) {
        MessageDto messageDto;
        messageDto = rightWorkService.rejectWorkById(rejectInfoQueryParam);
        return messageDto;
    }

    @RequestMapping("getDetail")
    public RightWorkDetailDto getRightWorkDetailInfoById(Long id) {
        RightWorkDetailFormDto rightWorkDetailFormDto;
        rightWorkDetailFormDto = rightWorkService.getRightWorkDetailInfoById(id);
        RightWorkDetailDto rightWorkDetailDto = rightWorkDetailFormDto.getRightWorkDetailDto();
        String auditState = "驳回";
            if (rightWorkDetailDto.getAuditState().equals(auditState)) {
            String reason = rightWorkService.getFailReasonById(id);
            rightWorkDetailDto.setReason(reason);
        }
        System.out.println(rightWorkDetailDto);
        return rightWorkDetailDto;
    }
}
