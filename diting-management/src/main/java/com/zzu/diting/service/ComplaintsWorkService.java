package com.zzu.diting.service;

import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.TransmitLisQueryParam;
import com.zzu.diting.dto.complaintwork.*;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 17:34
 */
public interface ComplaintsWorkService {

    /**
     * 得到工单集表格信息
     *
     * @param complaintsWorkQueryParam 请求参数
     * @return 表格信息
     */
    ComplaintsWorkTableInfoDto getComplaintsWorkTableInfo(ComplaintsWorkQueryParam complaintsWorkQueryParam);

    /**
     * 设置处理状态
     *
     * @param complaintsWorkTableDtos 工单集集合
     * @return 处理结果
     */
    List<ComplaintsWorkTableDto> setProcessing(List<ComplaintsWorkTableDto> complaintsWorkTableDtos);

    /**
     * 得到处理工单集信息
     *
     * @param id 工单集id
     * @return 工单集信息
     */
    ComplaintsWorkInfoPO getComplaintsWorkInfoById(Long id);

    /**
     * 得到投诉工单集详情界面
     *
     * @param complaintWorkQueryParam 请求参数
     * @return 返回数据
     */
    ComplaintsWrokDetailFormDto getComplaintsWorkDetailInfo(ComplaintWorkQueryParam complaintWorkQueryParam);

    /**
     * 得到工单节点信息
     *
     * @param workId
     * @return
     */
    AuditNodeListInfoDto getAuditNodeInfo(Long workId);

    /**
     * 转交投诉工单集
     *
     * @param transmitLisQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto transmitComplaintsWork(TransmitLisQueryParam transmitLisQueryParam);

    /**
     * 通过投诉工单
     *
     * @param adoptWorkQueryParam 通过请求参数
     * @return 处理结果
     */
    MessageDto adoptComplaintWork(AdoptComplaintWorkQueryParam adoptWorkQueryParam);

    /**
     * 驳回投诉工单管理组节点
     *
     * @param rejectComplaintWorkQueryParam 驳回请求参数
     * @return 处理结果
     */
    MessageDto rejectManagementNodeWork(RejectComplaintWorkQueryParam rejectComplaintWorkQueryParam);

    /**
     * 通过投诉集工单id得到投诉信息
     *
     * @param id 投诉工单集id
     * @return 投诉信息
     */
    ComplaintInfoFormDto getComplaintInfoByComplaintsWorkId(Long id);
}
