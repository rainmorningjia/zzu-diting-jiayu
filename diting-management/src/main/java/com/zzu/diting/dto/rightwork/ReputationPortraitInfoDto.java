package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReputationPortraitInfoDto implements Serializable {
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
     * 维权委托文件链接
     */
    private String attorneyPowerUrl;
    /**
     * 审核状态
     */
    private String auditStatus;
    private Long updateTime;
}
