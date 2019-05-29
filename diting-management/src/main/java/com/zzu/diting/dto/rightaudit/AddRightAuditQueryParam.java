package com.zzu.diting.dto.rightaudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRightAuditQueryParam implements Serializable {
    private Long id;
    private String distributionId;
    private String managerId;
    private String workType;
    private Integer rightType;
    private String distributionName;
    private String operatorName;
    private Long createTime;
    private Long updateTime;
    private List<ManagerNameAndId> list;
}
