package com.zzu.diting.dto;


public class PersonalAuthenticationUpdateInfoDto {
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
    private Long updateTime;
    private Long createTime;
}
