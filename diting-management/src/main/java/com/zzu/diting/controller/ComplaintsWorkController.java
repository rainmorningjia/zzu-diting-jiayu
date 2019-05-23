package com.zzu.diting.controller;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.complaintwork.*;
import com.zzu.diting.service.ComplaintsWorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("complaintsWork")
public class ComplaintsWorkController {
    @Resource
    ComplaintsWorkService complaintsWorkService;
    @RequestMapping("getComplainsWork")
    public ComplaintsWorkTableInfoDto getComplaintsWorkTableInfo(Integer page,Integer rows,ComplaintsWorkQueryParam complaintsWorkQueryParam, HttpServletRequest request) {
        String managerId = (String) request.getSession().getAttribute("managerId");
        complaintsWorkQueryParam.setNode(1);
        complaintsWorkQueryParam.setTimeType(1);
        complaintsWorkQueryParam.setSortType(1);
        complaintsWorkQueryParam.setPageNumber(page);
        complaintsWorkQueryParam.setRowNumber(rows);
        complaintsWorkQueryParam.setProcessState(1);
        complaintsWorkQueryParam.setManagerId(managerId);
        ComplaintsWorkTableInfoDto complaintsWorkTableInfoDto = complaintsWorkService.getComplaintsWorkTableInfo(complaintsWorkQueryParam);
        if (complaintsWorkTableInfoDto.getRows() != null) {
            List<ComplaintsWorkTableDto> complaintsWorkTableDtos = complaintsWorkService.setProcessing(complaintsWorkTableInfoDto.getRows());
            complaintsWorkTableInfoDto.setRows(complaintsWorkTableDtos);

        }
        System.out.println(complaintsWorkTableInfoDto);
        return complaintsWorkTableInfoDto;
    }
    @RequestMapping("getComplainWork")
    public ComplaintsWorkDetailDto getComplaintsWorkDetailInfo(Integer page,Integer rows,ComplaintWorkQueryParam complaintWorkQueryParam) {
        complaintWorkQueryParam.setSearchType(1);
        complaintWorkQueryParam.setNode(1);
        complaintWorkQueryParam.setTimeType(1);
        complaintWorkQueryParam.setSortType(1);
        complaintWorkQueryParam.setPageNumber(1);
        complaintWorkQueryParam.setPageNumber(page);
        complaintWorkQueryParam.setRowNumber(rows);
        complaintWorkQueryParam.setProcessState(1);
        ComplaintsWrokDetailFormDto complaintsWorkDetailDto = complaintsWorkService.getComplaintsWorkDetailInfo(complaintWorkQueryParam);
        if (complaintsWorkDetailDto.getComplaintsWorkDetailDto().getRows().size() != 0) {
            for (ComplaintWorkTableDto complaintWorkTableDto : complaintsWorkDetailDto.getComplaintsWorkDetailDto().getRows()) {
                if (complaintWorkQueryParam.getNode() == 1) {
                    complaintWorkTableDto.setAuditState(complaintWorkTableDto.getAuditStateOne());
                } else {
                    complaintWorkTableDto.setAuditState(complaintWorkTableDto.getAuditStateTwo());
                }
                if (complaintWorkTableDto.getRejectTypeOne() != null) {
                    String other = "其他";
                    if (complaintWorkTableDto.getRejectTypeOne().equals(other)) {
                        complaintWorkTableDto.setReason(complaintWorkTableDto.getReasonOne());
                    } else {
                        complaintWorkTableDto.setReason(complaintWorkTableDto.getRejectTypeOne());
                    }
                } else if (complaintWorkTableDto.getRejectTypeTwo() != null) {
                    String other = "其他";
                    if (complaintWorkTableDto.getRejectTypeTwo().equals(other)) {
                        complaintWorkTableDto.setReason(complaintWorkTableDto.getReasonTwo());
                    } else {
                        complaintWorkTableDto.setReason(complaintWorkTableDto.getRejectTypeTwo());
                    }
                }
            }
        }
        return complaintsWorkDetailDto.getComplaintsWorkDetailDto();
    }
    @RequestMapping("adoptWork")
    public MessageDto adoptComplaintWork(AdoptComplaintWorkQueryParam adoptWorkQueryParam) {
        MessageDto messageDto;
        messageDto=complaintsWorkService.adoptComplaintWork(adoptWorkQueryParam);
        return messageDto;
    }
    @RequestMapping("rejectWork")
    public MessageDto rejectManagementNodeWork(RejectComplaintWorkQueryParam rejectComplaintWorkQueryParam) {
        MessageDto messageDto;
        messageDto=complaintsWorkService.rejectManagementNodeWork(rejectComplaintWorkQueryParam);
        return messageDto;
    }
    @RequestMapping("getComplaintInfo")
    public ComplaintInfoFormDto getComplaintInfoByComplaintsWorkId(Long id) {
        ComplaintInfoFormDto complaintInfoFormDto;
        complaintInfoFormDto = complaintsWorkService.getComplaintInfoByComplaintsWorkId(id);
        return complaintInfoFormDto;
    }
}
