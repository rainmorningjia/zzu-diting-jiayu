package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightManagerDto implements Serializable {

    private Long userId;
    /**
     * 2:权利id
     * 3：权利名称
     */
    private Integer searchType;

    private Long rightId;

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
     * 2：审核中
     * 3：审核通过
     * 4：审核未通过
     * 5：关闭
     */
    private Integer auditState;
    private String startDate;
    private String endDate;
    private Integer pageNumber;
    private Integer rowNumber;
}
