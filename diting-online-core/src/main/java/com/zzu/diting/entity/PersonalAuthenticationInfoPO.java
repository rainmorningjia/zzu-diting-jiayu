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

/**
 * @Author wb-jcy525678
 * @Description: 个人认证信息表
 * @Date:Created in 下午7:21 2019/3/20
 */
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personal_authentication_info")
public class PersonalAuthenticationInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long personInfoId;
    private String realName;
    private String phoneNumber;
    private String email;
    private String province;
    private String city;
    private String area;
    private String certificateType;
    private String certificateNumber;
    /**
     * 身份证正面照链接
     */
    private String certificatePositiveUrl;
    /**
     * 身份证反面照链接
     */
    private String certificateOppositeUrl;
    /**
     * 身份证手持链接
     */
    private String certificateHandofUrl;
    private String address;
    private Integer zip;
    /**
     * 受理结果
     */
    private String authenticationResult;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
