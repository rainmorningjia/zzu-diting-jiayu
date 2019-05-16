package com.zzu.diting.service;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RejectInfoQueryParam;
import com.zzu.diting.dto.TransmitLisQueryParam;
import com.zzu.diting.dto.rightwork.RightWorkDetailFormDto;
import com.zzu.diting.dto.rightwork.RightWorkDto;
import com.zzu.diting.dto.rightwork.RightWorkListDto;
import com.zzu.diting.dto.rightwork.RightWorkQueryParam;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/6 11:40
 */
public interface RightWorkService {
    /**
     * 查询权利审核工单数据表格信息
     *
     * @param rightWorkQueryParam 请求参数
     * @return 数据
     */
    RightWorkListDto getRightTable(RightWorkQueryParam rightWorkQueryParam);

    /**
     * 批量转交工单
     *
     * @param transmitLisQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto transmitWorks(TransmitLisQueryParam transmitLisQueryParam);

    /**
     * 通过权利工单id得到失败信息
     *
     * @param id 权利工单id
     * @return 失败信息
     */
    String getFailReasonById(Long id);

    /**
     * 审核通过
     *
     * @param id 工单id
     * @return 处理结果
     */
    MessageDto adoptWorkById(Long id);

    /**
     * 驳回权利审核工单
     *
     * @param rejectInfoQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto rejectWorkById(RejectInfoQueryParam rejectInfoQueryParam);

    /**
     * 查看权利审核工单详情
     *
     * @param id 权利工单id
     * @return 工单详情信息
     */
    RightWorkDetailFormDto getRightWorkDetailInfoById(Long id);

    /**
     * 添加权利工单
     *
     * @param rightWorkDto 权利工单信息
     * @return 处理结果
     */
    MessageDto addRightWork(RightWorkDto rightWorkDto);

    /**
     * 获取权利信息
     *
     * @param rightWorkDto 权利信息请求参数
     * @return 处理结果
     */
    RightWorkDto getRightWorkInfo(RightWorkDto rightWorkDto);

    /**
     * 更新权利工单信息
     *
     * @param rightWorkDto
     * @return
     */
    MessageDto updateRightWorkInfo(RightWorkDto rightWorkDto);
}
