package com.zzu.diting.dto.rightaudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 21:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightAuditFormQueryParam implements Serializable {
    /**
     * 搜索类型
     */
    private Integer searchType;
    /**
     * 时间类型
     */
    private Integer timeType;
    /**
     * 排序类型
     */
    private Integer sortType;
    /**
     * 规则id
     */
    private Long id;
    /**
     * 权利类型
     */
    private Integer rightType;
    /**
     * 作品类型
     */
    private String workType;
    /**
     * 分配员工
     */
    private String managerName;
    /**
     * 操作者
     */
    private String operatorName;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 行数
     */
    private Integer rows;
}
