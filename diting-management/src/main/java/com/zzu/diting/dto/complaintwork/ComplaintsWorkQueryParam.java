package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 16:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsWorkQueryParam implements Serializable {
    /**
     * 管理员id
     */
    private String managerId;
    /**
     * table类型
     * 1：待处理
     * 2：我的已处理
     * 3：所有工单
     */
    private Integer tableType;
    /**
     * 搜素类型
     * 1：默认
     * 2：工单ID
     */
    private Integer searchType;
    /**
     * 处理节点
     */
    private Integer node;
    /**
     * 处理进度
     */
    private Integer processState;
    /**
     * 排序时间类型
     * 1：创建时间
     * 2：最近更新时间
     */
    private Integer timeType;
    /**
     * 排序方式
     * 1：正序
     * 2：倒叙
     */
    private Integer sortType;
    /**
     * 工单集ID
     */
    private Long id;
    /**
     * 工单id
     */
    private String ids;
    /**
     * 内容id
     */
    private String commentIds;
    /**
     * 投诉人
     */
    private String complaintPerson;
    /**
     * 投诉类型
     * 1：著作权
     * 2：名誉权/肖像权
     * 3：其他权利
     */
    private Integer complaintType;
    /**
     * 涉及权利
     */
    private String rightName;
    /**
     * 开始时间时间
     */
    private String startTime;
    /**
     * 结束时间时间
     */
    private String endTime;
    /**
     * 起始行
     */
    private Integer pageNumber;
    /**
     * 结束行
     */
    private Integer rowNumber;
}
