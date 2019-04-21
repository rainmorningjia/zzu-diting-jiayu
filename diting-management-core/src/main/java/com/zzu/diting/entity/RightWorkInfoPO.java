package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: wb-jcy525678
 * @Description: 权利审核工单表
 * @Date:Created in 下午12:21 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "right_work_info")
public class RightWorkInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 权利用户id
     */
    private Long userId;
    /**
     * 审核者id
     */
    private Long auditorId;
    /**
     * 权利信息表id
     */
    private Long rightId;
    /**
     * 工单类型
     */
    private String jobType;
    /**
     * 权利名称
     */
    private String rightName;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 权利人
     */
    private String rightPerson;
    /**
     * 工单类型
     */
    private String worksType;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 当前处理人
     */
    private String handlePerson;
    private String auditState;
    /**
     * 驳回原因
     */
    private String reason;

    /**
     * 处理记录
     */
    private String processingRecord;

    /**
     * 是否被转交
     */
    private Byte isTransmit;
    private Byte isDistribution;

    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
