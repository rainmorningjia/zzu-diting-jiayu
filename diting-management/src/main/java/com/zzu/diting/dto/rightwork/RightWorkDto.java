package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkDto implements Serializable {
    private Long id;
    /**
     * 权利用户id
     */
    private Long userId;
    /**
     * 审核者id
     */
  private String auditorId;
    /**
     * 权利信息表id
     */
    private Long rightId;
    /**
     * 类型
     */
    private String jobType;
    /**
     * 权利名称
     */
    private String rightName;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 权利人
     */
    private String rightPerson;
    /**
     * 作品类型
     */
    private String worksType;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 审核状态
     */
    private String auditState;
    /**
     * 驳回类型
     */
    private String failType;
    /**
     * 驳回原因
     */
    private String reason;

    /**
     * 处理记录
     */
    private String processingRecord;

    /**
     * 是否被转交
     */
    private Byte isTransmit;

    private Byte isDistribution;

    private String createTime;

    private String updateTime;
}
