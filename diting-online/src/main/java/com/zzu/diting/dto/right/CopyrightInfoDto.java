package com.zzu.diting.dto.right;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CopyrightInfoDto implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 作品类型
     */
    private String worksType;
    private String copyrightType;
    /**
     * 是否进行著作权登记
     */
    private String isRegister;
    /**
     * 著作权登记号
     */
    private String copyrightRegistrationNumber;
    /**
     * 著作权登记文件链接
     */
    private String copyrightRegistrationFileUrl;
    /**
     * 作品名称
     */
    private String worksName;


    private String copyrightPersonName;
    /**
     * 著作权登记日
     */
    private String copyrightRegisterDate;
    /**
     * 著作权有效期
     */
    private String copyrightVld;
    /**
     * 导演信息
     */
    private String directorInfo;
    /**
     * 主演信息
     */
    private String performerMainInfo;
    /**
     * 作品属性
     */
    private String worksAttribute;
    /**
     * 作品集数
     */
    private String worksNumber;

    private String consultUrl;
    /**
     * 是否分销获取的权利
     */
    private String isDistribution;
    /**
     * 著作权属性
     */
    private String copyrightAttribute;
    /**
     * 权利人类型
     */
    private String copyrightPersonType;
    /**
     * 证件类型
     */
    private String certificateType;
    /**
     * 证件号码
     */
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
     * 护照身份页照链接
     */
    private String passportUrl;
    /**
     * 企业统一社会信息用代码/注册号
     */
    private String unifiedSocialCreditCode;
    /**
     * 权利链文件链接
     */
    private String copyrightDocumentChainUrl;
    /**
     * 是否是被维权委托
     */
    private String isRightEntrusted;
    /**
     * 维权属性
     */
    private String attorneyAttribute;
    /**
     * 委托维权起止日
     */
    private String entrustedProtectionStartdate;
    /**
     * 委托维权截止日
     */
    private String entrustedProtectionEnddate;
    /**
     * 委托文件链接
     */
    private String attorneyPowerUrl;
    /**
     * 审核状态
     */
    private String auditState;
}
