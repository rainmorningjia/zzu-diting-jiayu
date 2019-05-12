package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
* @ :
 * @date : 2019/4/16 14:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComplaintManagerDto implements Serializable {
    /**
     * 投诉id
     */
    private Long id;
    private Long userId;
    /**
     * 1:初始状态
     * 2:投诉id
     * 3：投诉链接
     * 4：权利名称
     * 5：权利id
     */
    private Integer searchType;
    /**
     * 权利id
     */
    private Long rightId;
    /**
     * 投诉链接
     */
    private String complaintUrl;

    private String rightName;
    /**
     * 1：全部
     * 2：著作权
     * 3：名誉权
     * 4：其他权利
     */
    private Integer rightType;
    /**
     * 1:全部
     * 2：处理中
     * 3：处理完成
     * 4：投诉驳回
     * 5：关闭
     */
    private Integer auditState;
    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    private Integer pageNumber;
    private Integer rowNumber;
}
