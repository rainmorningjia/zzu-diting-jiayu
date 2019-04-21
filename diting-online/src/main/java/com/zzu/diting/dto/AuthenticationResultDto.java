package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miles
 * @Title: AuthenticationResultDto
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/19--20:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResultDto {
    private Integer type;
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
    private String corporationName;
    private String address;
    private Integer zip;
    private String tel;
    private String fas;
    private String relationName;
    private String authenticationResult;
    private String recentlyOperator;
    private String recentlyUpdateType;
    private String failType;
    private String reason;
    private String realName;
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
    private String state;

}
