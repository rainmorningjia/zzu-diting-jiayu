package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author wb-jcy525678
 * @Description: 个人认证信息表
 * @Date:Created in 下午7:21 2019/3/20
 */
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personal_authentication_update_info")
public class PersonalAuthenticationUpdateInfoPO implements Serializable {
    @Id
    private Long id;
    private Long personInfoId;
    private String newRealName;
    private String certificateType;
    private String newCertificateNumber;
    /**
     * 身份证正面照链接
     */
    private String newCertificatePositiveUrl;
    /**
     * 身份证反面照链接
     */
    private String newCertificateOppositeUrl;
    /**
     * 身份证手持链接
     */
    private String newCertificateHandofUrl;

    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
