package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherRightUpdateInfoDto implements Serializable {
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
    private String newEntrustedProtectionStartdate;
    private String newEntrustedProtectionEnddate;
}
