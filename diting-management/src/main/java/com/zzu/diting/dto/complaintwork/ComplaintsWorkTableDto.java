package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsWorkTableDto implements Serializable {
    /**
     * 工单集id
     */
    private Long id;
    /**
     * 投诉人
     */
    private String complaintPerson;
    /**
     * 投诉类型
     */
    private String complaintType;

    /**
     * 涉及权利
     */
    private String relationRight;
    /**
     * 投诉量
     */
    private Integer complaintNumber;
    /**
     * 处理进度
     */
    private Double processing;
    /**
     * 处理进度
     */
    private Double processingTwo;
    /**
     * 处理节点
     */
    private String node;
    /**
     * 版权审核组处理人
     */
    private String handlePerson;
    /**
     * 版权处理组处理人id
     */
    private String handlePersonHandleId;
    /**
     * 版权处理组处理人
     */
    private String handlePersonHandle;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最近更新时间
     */
    private String updateTime;
}
