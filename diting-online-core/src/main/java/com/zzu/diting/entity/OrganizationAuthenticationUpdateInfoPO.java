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
 * @Author wb-jcy525678
 * @Description: 组织认证信息表
 * @Date:Created in 下午7:21 2019/3/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization_authentication_update_info")
public class OrganizationAuthenticationUpdateInfoPO implements Serializable {
    @Id
    private Long id;
    private Long authenticationId;
    /**
     * 证件类型
     */
    private String newCertificateType;
    /**
     * 证件号码
     */
    private String newCertificateNumber;
    /**
     * 证件照正面链接
     */
    private String newCertificatePostiveUrl;
    /**
     * 证件照手持链接
     */
    private String newCertificateHandofUrl;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
