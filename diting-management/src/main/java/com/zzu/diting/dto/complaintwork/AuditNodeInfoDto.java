package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/10 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditNodeInfoDto implements Serializable {
    /**
     * 序号
     */
    private Integer code;
    /**
     * 处理人
     */
    private String handlePerson;
    /**
     * 结果
     */
    private String auditState;
    /**
     * 意见
     */
    private String suggestion;
    /**
     * /**
     * 审核完成时间
     */
    private String completeTime;
}
