package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/16 15:10
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MessageDto {
    private String message;
    private Integer code;
}
