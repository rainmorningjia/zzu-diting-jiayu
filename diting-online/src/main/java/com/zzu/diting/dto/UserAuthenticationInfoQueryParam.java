package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationInfoQueryParam implements Serializable {
    private Long id;
    private Long userId;
    private Integer authenticationType;
    private String organizationName;
    private String realName;
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
    /**
     * 身份证反面照链接
     */
    private String certificateOppositeUrl;
    private String certificateHandofUrl;
    private String corporationName;
    private String address;
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
    private Integer failType;
    private String reason;
    private String relationName;
    private String authenticationResult;

    private String recentlyOperator;
    private String recentlyUpdateType;
    private Long updateTime;
    private Long createTime;

}
