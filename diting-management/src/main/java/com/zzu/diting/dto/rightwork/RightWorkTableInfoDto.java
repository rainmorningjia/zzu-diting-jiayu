package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description: 权利工单表格信息
 * @date : 2019/5/6 11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkTableInfoDto implements Serializable {
    /**
     * 工单id
     */
    private Long id;
    /**
     * 类型
     */
    private String jobType;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 作品类型
     */
    private String worksType;

    /**
     * 权利名称
     */
    private String rightName;
    /**
     * 权利id
     */
    private Long rightId;

    /**
     * 权利人名称
     */
    private String rightPerson;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 处理进度
     */
    private String auditState;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
