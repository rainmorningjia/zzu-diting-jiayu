package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationInfoDto {
    private Long id;
    private Long userId;
    /**
     * 认证类型
     */
    private Integer authenticationType;
    /**
     * 组织名
     */
    private String organizationName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
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
     * 证件照正面链接\\护照正面照\\证件正面照链接
     */
    private String certificatePositiveUrl;
    /**
     * 身份证反面照链接
     */
    private String certificateOppositeUrl;
    /**
     * 身份证反面照链接
     */
    private String certificateHandofUrl;
    /**
     * 法人姓名
     */
    private String corporationName;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮编
     */
    private Integer zip;
    /**
     * 座机电话区号
     */
    private String telAreaCode;
    /**
     * 座机电话号码
     */
    private String telNumber;
    /**
     * 座机分机
     */
    private String telExtension;


    private String fasAreaCode;
    private String fasNumber;
    private String fasExtension;
    /**
     * 失败原因
     */
    private String reason;
    /**
     * 联系人
     */
    private String relationName;
}
