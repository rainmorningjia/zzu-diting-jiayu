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
    private String handleRank;
    private String explanation;
    private String rejectTypeTwo;
    private String reasonTwo;
    private String handleMode;
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
    private Timestamp completeTime;
}
