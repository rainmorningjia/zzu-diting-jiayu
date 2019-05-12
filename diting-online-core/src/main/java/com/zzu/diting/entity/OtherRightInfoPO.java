package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @author wb-jcy525678
 * @Description: 其他权利信息
 * @Date:Created in 上午10:21 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "other_right_info")
public class OtherRightInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private String copyrightType;
    private String copyrightName;
    private String country;
    private String province;
    /**
     * 知识产权证书链接
     */
    private String intellctualPropertyCertificatesUrl;
    /**
     * 是否被委托维权
     */
    private String isRightEntrusted;
    /**
     * 维权属性
     */
    private String attorneyAttribute;
    private String attorneyPowerUrl;

    private Date entrustedProtectionStartdate;
    private Date entrustedProtectionEnddate;
    private String auditStatus;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
