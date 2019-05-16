package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 16:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintInfoFormDto implements Serializable {
    private Integer code;
    private String message;
    private ComplaintAndRightInfoDto complaintAndRightInfoDto;
}
