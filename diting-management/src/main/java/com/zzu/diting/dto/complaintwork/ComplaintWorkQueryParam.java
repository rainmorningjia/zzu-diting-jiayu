package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/9 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintWorkQueryParam {
    /**
     * 搜素类型
     * 1：默认
     * 2：工单ID
     */
    private Integer searchType;
    /**
     * 节点
     */
    private Integer node;
    /**
     * 节点状态
     * 1:全部
     * 2：处理中
     * 3：通过
     * 4：驳回
     * 5：关闭
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
     * 投诉id
     */
    private String complaintIds;
    /**
     * 投诉链接
     */
    private String complaintUrl;
    /**
     * 内容id
     */
    private String commentIds;
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
