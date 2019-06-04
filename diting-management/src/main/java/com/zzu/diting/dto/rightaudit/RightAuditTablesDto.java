package com.zzu.diting.dto.rightaudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 21:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightAuditTablesDto {
    private Integer code;
    private String message;
    private Integer total;
    private List<RightAuditTableDto> rows;
}
