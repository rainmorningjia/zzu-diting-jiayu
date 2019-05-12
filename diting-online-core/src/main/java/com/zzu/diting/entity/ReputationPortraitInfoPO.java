package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: wb-jcy525678
 * @Description: 名誉/肖像权信息
 * @Date:Created in 下午1:21 2019/3/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reputation_portrait_info")
public class ReputationPortraitInfoPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private String copyrightName;
    private String copyrightType;
    /**
     * 证明材料文件链接
     */
    private String proofMaterialUrl;
    /**
     * 是否被维权委托
     */
    private String isRightEntrusted;
    /**
     * 维权属性
     */
    private String attorneyAttribute;
    /**
     * 委托维权起止日
     */
    private Date entrustedProtectionStartdate;
    /**
     * 委托维权截止日
     */
    private Date entrustedProtectionEnddate;
    /**
     * 维权委托文件链接
     */
    private String attorneyPowerUrl;
    /**
     * 审核状态
     */
    private String auditStatus;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
