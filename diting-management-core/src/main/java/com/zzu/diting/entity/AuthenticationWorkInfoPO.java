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
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/3/25 20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authentication_work_info")
public class  AuthenticationWorkInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 认证用户id
     */
    private String auditorId;
    private Long userId;
    private String nickname;
    private String realName;
    private String orderType;
    private String userType;
    private String auditState;
    /**
     *处理人
     */
    private String handlePerson;
    /**
     * 处理记录
     */
    private String handleRecord;
    /**
     * 驳回类型
     */
    private String failType;
    /**
     * 驳回理由
     */
    private String reason;
    /**
     * 是否被转交
     */
    private Byte isTransmit;
    /**
     * 是否已被分配
     */
    private Byte isDistribution;
    /**
     * 完成时间
     */
    private Timestamp completeTime;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;

}
