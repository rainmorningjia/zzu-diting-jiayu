package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightInfoDto implements Serializable {
    private Long id;
    private String rightName;
    private String rightType;
    private String isEntrustedProtection;
    private String auditResult;
    private String  createTime;
    private String  updateTime;
    private String reason;
}
