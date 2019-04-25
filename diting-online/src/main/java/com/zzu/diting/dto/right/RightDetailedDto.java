package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RightDetailedDto implements Serializable {
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
     * 权利名称
     */
    private String copyrightName;
    /**
     * 作品名称
     */
    private String worksName;
    /**
     * 著作权人名称
     */
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
    /**
     * 作品相关网址
     */
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
     * 企业统一社会信息用代码/注册号
     */
    private String unifiedSocialCreditCode;
    /**
     * 企业证明文件链接
     */
    private String enterpriseProveFileUrl;
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
     * 权利链文件链接
     */
    private String copyrightDocumentChainUrl;
    /**
     * 知识产权证书链接
     */
    private String intellctualPropertyCertificatesUrl;

    /**
     * 证明材料文件链接
     */
    private String proofMaterialUrl;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;

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

}
