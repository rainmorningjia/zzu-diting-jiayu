package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/7 14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkDetailFormDto implements Serializable {
    private Integer code;
    private String message;
    private RightWorkDetailDto rightWorkDetailDto;
}
