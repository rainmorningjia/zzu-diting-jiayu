package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RejectComplaintWorkQueryParam implements Serializable {
    /**
     * 工单id
     */
    private List<Long> ids;
    /**
     * 驳回类型
     */
    private String failType;
    /**
     * 驳回原因
     */
    private String reason;
    /**
     * 节点信息
     * 1：版权管理组
     * 2：版权处理组
     */
    private Integer node;
}
