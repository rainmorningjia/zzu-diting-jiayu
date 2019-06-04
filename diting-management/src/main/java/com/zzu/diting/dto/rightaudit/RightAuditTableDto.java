package com.zzu.diting.dto.rightaudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 21:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightAuditTableDto implements Serializable {
    /**
     * 规则id
     */
    private Long id;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 作品类型
     */
    private String workType;
    /**
     * 分配员工
     */
    private String distributionName;
    /**
     * 操作者
     */
    private String operatorName;
    private String createTime;
    private String updateTime;
}
