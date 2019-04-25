package com.zzu.diting.dto;


public class OrganizationAuthenticationUpdateInfoDto {
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
    private Long updateTime;
    private Long createTime;
}
