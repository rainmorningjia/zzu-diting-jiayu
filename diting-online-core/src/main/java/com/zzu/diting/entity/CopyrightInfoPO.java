package com.zzu.diting.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wb-jcy525678
 * @Description: 著作权信息表
 * @Date:Created in 下午1:21 2019/3/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "copyright_info")
public class CopyrightInfoPO implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 作品类型
     */
    private String worksType;
    /**
     * 权利类型
     */
    private String copyrightType;
    /**
     * 是否进行著作权登记
     */
    private String isRegister;
    /**
     * 著作权登记号6
     */
    private String copyrightRegistrationNumber;
    /**
     * 著作权登记文件链接7
     */
    private String copyrightRegistrationFileUrl;
    /**
     * 作品名称8
     */
    private String worksName;
    /**
     * 著作权人名称9
     */
    private String copyrightPersonName;
    /**
     * 著作权登记日10
     */
    private Date copyrightRegisterDate;
    /**
     * 著作权有效期11
     */
    private Date copyrightVld;
    /**
     * 导演信息12
     */
    private String directorInfo;
    /**
     * 主演信息13
     */
    private String performerMainInfo;
    /**
     * 作品属性14
     */
    private String worksAttribute;
    /**
     * 作品集数15
     */
    private String worksNumber;
    /**
     * 作品信息可参考网址
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entrustedProtectionStartdate;
    /**
     * 委托维权截止日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entrustedProtectionEnddate;
    /**
     * 委托文件链接
     */
    @Column(name = "entrust_file_url")
    private String attorneyPowerUrl;
    /**
     * 审核状态
     */
    private String auditState;
    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;

}
