package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherRightInfoDto implements Serializable {
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
    private String attorneyAttribute;
    private String attorneyPowerUrl;
    private String  entrustedProtectionStartdate;
    private String  entrustedProtectionEnddate;
    private String auditStatus;
}
