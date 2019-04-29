package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author wb-jcy525678
 * @Description: 组织认证信息表
 * @Date:Created in 下午7:21 2019/3/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization_authentication_info")
public class OrganizationAuthenticationInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private String organizationName;
    private String province;
    private String city;
    private String area;
    private String phoneNumber;
    private String email;
    /**
     * 证件类型
     */
    private String certificateType;
    /**
     * 证件号码
     */
    private String certificateNumber;
    /**
     * 证件照正面链接
     */
    private String certificatePositiveUrl;
    private String corporationName;
    private String address;
    private Integer zip;
    private String tel;
    private String fas;
    private String relationName;
    private String authenticationResult;
    private String recentlyOperator;
    private String recentlyUpdateType;
    /**
     * 失败类型
     */
    private String  failType;
    private String reason;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
