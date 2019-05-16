package com.zzu.diting.dto.rightwork;

import com.zzu.diting.dto.HandleRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkDetailDto implements Serializable {
    /**
     * 处理进度
     */
    private String auditState;
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 历史 记录
     */
    private List<HandleRecord> handleRecords;
    /**
     * 优酷账号id
     */
    private Long userId;
    /**
     * 优酷账号昵称
     */
    private String nickname;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 类型
     */
    private String jobType;
    /**
     * 名称
     */
    private String rightName;
    /**
     * 作品类型
     */
    private String rightType;
    /**
     * 作品名称
     */
    private String worksName;
    /**
     * 著作权人名称
     */
    private String copyrightPersonName;
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
     * 权利链文件链接
     */
    private String copyrightDocumentChainUrl;
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
     * 企业证明文件链接
     */
    private String enterpriseProveFileUrl;
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
     * 新作品类型
     */
    private String newWorksType;
    /**
     * 新是否进行著作权登记
     */
    private String newIsRegister;
    /**
     * 新著作权登记号
     */
    private String newCopyrightRegistrationNumber;
    /**
     * 新著作权登记文件链接
     */
    private String newCopyrightRegistrationFileUrl;
    /**
     * 新权利人名称
     */
    private String newCopyrightPersonName;
    /**
     * 新著作权登记日
     */

    private String newCopyrightRegisterDate;
    /**
     * 新著作权有效期
     */
    private String newCopyrightVld;
    /**
     * 新导演信息
     */
    private String newDirectorInfo;
    /**
     * 新主演信息
     */
    private String newPerformerMainInfo;
    /**
     * 新作品属性
     */
    private String newWorksAttribute;
    /**
     * 新作品集数
     */
    private String newWorksNumber;
    /**
     * 新是否分销获取的权利
     */
    private String newIsDistribution;
    /**
     * 新著作权属性
     */
    private String newCopyrightAttribute;
    /**
     * 新权利人类型
     */
    private String newCopyrightPersonType;
    /**
     * 新证件类型
     */
    private String newCertificateType;
    /**
     * 新证件号码
     */
    private String newCertificateNumber;
    /**
     * 新身份证正面照链接
     */
    private String newCertificatePositiveUrl;
    /**
     * 新身份证反面照链接
     */
    private String newCertificateOppositeUrl;
    /**
     * 新护照身份页照链接
     */
    private String newPassportUrl;
    /**
     * 新企业统一社会信息用代码/注册号
     */
    private String newUnifiedSocialCreditCode;
    /**
     * 新企业证明文件链接
     */
    private String newEnterpriseProveFileUrl;
    /**
     * 新权利链文件链接
     */
    private String newCopyrightDocumentChainUrl;
    /**
     * 新是否是被维权委托
     */
    private String newIsRightEntrusted;
    /**
     * 新维权属性
     */
    private String newAttorneyAttribute;
    /**
     * 新委托维权起止日
     */
    private String newEntrustedProtectionStartdate;
    /**
     * 新委托维权截止日
     */
    private String newEntrustedProtectionEnddate;
    /**
     * 新委托文件链接
     */
    private String newAttorneyPowerUrl;
    /**
     * 证明材料文件链接
     */
    private String proofMaterialUrl;
    /**
     * 权利名称
     */
    private String copyrightName;
    /**
     * 新证明材料文件链接
     */
    private String newProofMaterialUrl;
    /**
     * 知识产权证书链接
     */
    private String intellctualPropertyCertificatesUrl;
    /**
     * 省份
     */
    private String country;
    /**
     * 城市
     */
    private String province;
    /**
     * 新城市
     */
    private String newCountry;
    /**
     * 新省份
     */
    private String newProvince;
    /**
     * 新知识产权证书链接
     */
    private String newIntellctualPropertyCertificatesUrl;
    /**
     * 完成时间
     */
    private Timestamp completeTime;
    /**
     * 意见
     */
    private String reason;
}
