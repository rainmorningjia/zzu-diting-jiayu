package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @Author: wb-jcy525678
 * @Description: 名誉/肖像权信息
 * @Date:Created in 下午1:21 2019/3/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reputation_portrait_update_info")
public class ReputationPortraitUpdateInfoPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long reputationPortraitInfoId;
    /**
     * 证明材料文件链接
     */
    private String newProofMaterialUrl;
    /**
     * 是否被维权委托
     */
    private String isEntrustedProtection;
    private String protectionRightAttribute;
    /**
     * 委托维权起止日
     */
    private Timestamp newEntrustedProtectionStartdate;
    /**
     * 委托维权截止日
     */
    private Timestamp newEntrustedProtectionEnddate;
    /**
     * 维权委托文件链接
     */
    private String newAttorneyPowerUrl;
    @Column(name = "gmt_modified")
    private Long updateTime;
    @Column(name = "gmt_create")
    private Long createTime;
}
