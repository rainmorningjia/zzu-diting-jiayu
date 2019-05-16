package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description: 权利工单数据表格请求参数
 * @date : 2019/5/6 10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkQueryParam implements Serializable {
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
     * 3：类型
     * 4：权利类型
     * 5：权利名称
     * 6：权利ID
     * 7：权利人名称
     * 8：用户类型
     * 9：当前处理人
     * 10：创建时间
     * 11：最近更新时间
     */
    private Integer searchType;
    /**
     * 处理进度
     */
    private Integer processType;
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
     * 工单ID
     */
    private Long id;
    /**
     * 类型
     * 1:首次认证
     * 2：信息修改
     */
    private Integer orderType;
    /**
     * 权利类型
     * 1：著作权
     * 2：名誉权/肖像权
     * 3：其他权利
     */
    private Integer rightType;
    /**
     * 权利名称
     */
    private String rightName;
    /**
     * 权利ID
     */
    private Long rightId;
    /**
     * 权利人名称
     */
    private String rightPerson;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 当前处理人
     */
    private String handlePerson;
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
