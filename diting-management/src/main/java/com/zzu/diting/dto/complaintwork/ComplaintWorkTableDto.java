package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 16:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintWorkTableDto implements Serializable {
    /**
     * 工单id
     */
    private Long id;
    /**
     * 投诉id
     */
    private Long complaintId;
    /**
     * 投诉链接
     */
    private String complaintUrl;
    /**
     * 内容id
     */
    private Long commentId;
    /**
     * 节点状态
     */
    private String auditState;
    /**
     * 驳回原因
     */
    private String reason;
    /**
     * 节点一处理状态
     */
    private String auditStateOne;
    /**
     * 节点二处理状态
     */
    private String auditStateTwo;
    /**
     * 驳回类型1
     */
    private String rejectTypeOne;
    /**
     * 驳回原因1
     */
    private String reasonOne;
    /**
     * 通过等级
     */
    private String handleRank;

    /**
     * 补充说明
     */
    private String explanation;
    /**
     * 驳回类型处理组
     */
    private String rejectTypeTwo;
    /**
     * 处理组驳回原因
     */
    private String reasonTwo;
    /**
     * 处理组通过等级
     */
    private String handleMode;
    /**
     * 处理组补充信息
     */
    private String specificInformation;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 创建时间
     */
    private String createTime;
}
