package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @author wb-jcy525678
 * @Description: 其他权利信息
 * @Date:Created in 上午10:21 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "other_right_update_info")
public class OtherRightUpdateInfoPO implements Serializable {
    @Id
    private Long id;
    private Long otherRightInfoId;
    private String newCountry;
    private String newProvince;
    /**
     * 知识产权证书链接
     */
    private String newIntellctualPropertyCertificatesUrl;
    /**
     * 是否被委托维权
     */
    private String isEntrustedProtection;
    private String protectionRightAttribute;
    private String newAttorneyPowerUrl;
    private Timestamp newEntrustedProtectionStartdate;
    private Timestamp newEntrustedProtectionEnddate;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
