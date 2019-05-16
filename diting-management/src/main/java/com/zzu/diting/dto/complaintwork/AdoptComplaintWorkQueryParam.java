package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 11:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptComplaintWorkQueryParam {

    /**
     * 工单id
     */
    private List<Long> workIds;
    /**
     * 通过等级/处理方式
     */
    private String handleRank;
    /**
     * 补充说明/具体信息
     */
    private String explanation;
    /**
     * 节点信息
     * 1.版权管理组
     * 2.版权处理组
     */
    private Integer node;
}
