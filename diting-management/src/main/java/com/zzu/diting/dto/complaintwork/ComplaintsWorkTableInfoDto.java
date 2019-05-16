package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsWorkTableInfoDto implements Serializable {
    private Integer code;
    private String message;
    private Integer total;
    private List<ComplaintsWorkTableDto> rows;
}
