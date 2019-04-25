package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReputationPortraitUpdateInfoDto implements Serializable {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp newEntrustedProtectionStartdate;
    /**
     * 委托维权截止日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp newEntrustedProtectionEnddate;
    /**
     * 维权委托文件链接
     */
    private String newAttorneyPowerUrl;
}
