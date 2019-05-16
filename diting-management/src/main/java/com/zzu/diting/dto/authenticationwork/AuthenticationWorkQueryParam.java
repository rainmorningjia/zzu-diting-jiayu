package com.zzu.diting.dto.authenticationwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/27 11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationWorkQueryParam implements Serializable {
    private String managerId;
    /**
     * table类型
     * 1：待处理
     * 2：我的已处理
     * 3：所有
     */
    private Integer tableType;
    /**
     * 搜素类型
     * 1：默认
     * 2：工单ID
     * 3：类型
     * 4：优酷账号ID
     * 5：优酷账号昵称
     * 6：名称
     * 7：用户类型
     * 8：当前处理人
     * 9：创建时间
     * 10：最近更新时间
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
     * 工单类型
     * 1:首次认证
     * 2：信息修改
     */
    private Integer orderType;
    /**
     * 优酷账号ID
     */
    private Long userId;
    /**
     * 优酷账号昵称
     */
    private String nickname;
    /**
     * 名称
     */
    private String name;
    /**
     * 用户类型
     * 1：个人
     * 2：机构/组织
     */
    private Integer userType;
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
