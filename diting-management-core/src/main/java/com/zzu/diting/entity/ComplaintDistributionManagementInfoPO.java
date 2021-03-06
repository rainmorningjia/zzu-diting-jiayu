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
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/1 9:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complaint_distribution_management_info")
public class ComplaintDistributionManagementInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String distributionId;
    private String managerId;
    private String rightType;
    private String node;
    private String complaintPlatform;
    private String distributionName;
    private String operatorName;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
