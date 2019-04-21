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
 * @date : 2019/4/1 9:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authentication_distribution_management")
public class AuthenticationDistributionManagementInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long distributionId;
    private Long managerId;
    private String operatorName;
    private String managerName;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
