package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsWrokDetailFormDto {
    private Integer code;
    private String message;
    private ComplaintsWorkDetailDto complaintsWorkDetailDto;

}
