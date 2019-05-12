package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miles
 * @Title: MessageDto
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/19--20:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String message;
    private Integer code;
}
