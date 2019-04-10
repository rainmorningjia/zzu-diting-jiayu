package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/3/28 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "copyright_update_info")
public class CopyrightUpdateInfoPO implements Serializable {
    @Id
    private Long id;
    /**
     * 原作品ID
     */
    private Long copyrightId;
    private String newWorksType;
    /**
     * 是否进行著作权登记
     */
    private String isRegister;
    /**
     * 著作权登记号
     */
    private String newCopyrightRegistrationNumber;
    /**
     * 著作权登记文件链接
     */
    private String newCopyrightRegistrationFileUrl;

    private String newCopyrightPersonName;
    /**
     * 著作权登记日
     */

    private Timestamp newCopyrightRegisterDate;
    /**
     * 著作权有效期
     */
    private Timestamp newCopyrightVld;
    /**
     * 导演信息
     */
    private String newDirectorInfo;
    /**
     * 主演信息
     */
    private String newPerformerMainInfo;
    /**
     * 作品属性
     */
    private String worksAttribute;
    /**
     * 作品集数
     */
    private String newWorksNumber;
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
     * 护照身份页照链接
     */
    private String newPassportUrl;
    /**
     * 企业统一社会信息用代码/注册号
     */
    private String newUnifiedSocialCreditCode;
    /**
     * 企业证明文件链接
     */
    private String newEnterpriseProveFileUrl;
    /**
     * 权利链文件链接
     */
    private String newCopyrightDocumentChainUrl;
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
    private Timestamp newEntrustProtectionStartdate;
    /**
     * 委托维权截止日
     */
    private Timestamp newEntrustProtectionEnddate;
    /**
     * 委托文件链接
     */
    private String newEntrustFileUrl;
    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
