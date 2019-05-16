package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: wb-jcy525678
 * @Description: 投诉审核工单表
 * @Date:Created in 下午3:25 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complaint_work_info")
public class ComplaintWorkInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 投诉id
     */
    private Long complaintId;
    private Long complaintsWorkId;
    private String orderType;
    private String complaintUrl;
    private Long commentId;
    /**
     * 节点一处理状态
     */
    private String auditStateOne;
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
    private String infoSource;
    /**
     * 是否已被分配
     */
    private Byte isDistribution;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
    /**
     * 处理完成时间1
     */
    private Timestamp completeTime1;
    /**
     * 处理完成时间2
     */
    private Timestamp completeTime2;
}
