package com.zzu.diting.service;


import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RejectInfoQueryParam;
import com.zzu.diting.dto.TransmitLisQueryParam;
import com.zzu.diting.dto.TransmitQueryParam;
import com.zzu.diting.dto.authenticationwork.AuthenticationDetailFormDto;
import com.zzu.diting.dto.authenticationwork.AuthenticationWorkQueryParam;
import com.zzu.diting.dto.authenticationwork.AuthenticationWorkTableDto;

/**
 * @author wb-jcy525678
 */
public interface AuthenticationWorkService {
    /**
     * 获取认证审核表格数据
     *
     * @param authenticationWorkQueryParam 请求参数
     * @return 认证审核表单数据
     */
    AuthenticationWorkTableDto getAuthenticationWorkTable(AuthenticationWorkQueryParam authenticationWorkQueryParam);

    /**
     * 通过工单id得到认证详情
     *
     * @param id 工单id
     * @return 认证详情
     */
    AuthenticationDetailFormDto getAuthenDetailInfoByWorkId(Long id);

    /**
     * 转交认证工单
     *
     * @param transmitDto 转交信息
     * @return 处理结果
     */
    MessageDto transmitWork(TransmitQueryParam transmitDto);

    /**
     * 认证通过
     *
     * @param id 工单id
     * @return 处理结果
     */
    MessageDto adoptAuthenticationWorkById(Long id);

    /**
     * 驳回
     * @param rejectInfoQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto rejectWorkById(RejectInfoQueryParam rejectInfoQueryParam);

    /**
     * 转件多个工单至多个审核者
     * @param transmitLisQueryParam 请求参数
     * @return 处理结果
     */
    MessageDto transmitLisWork(TransmitLisQueryParam transmitLisQueryParam);

    /**
     * 获取失败原因
     * @param id 认证工单信息id
     * @return 处理结果
     */
    String  getFailReasonById(Long id);
}
