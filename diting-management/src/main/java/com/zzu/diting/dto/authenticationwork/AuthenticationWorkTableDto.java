package com.zzu.diting.dto.authenticationwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/27 11:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationWorkTableDto implements Serializable {
    private String message;
    private Integer code;
    private Integer total;
    private List<AuthenticationWorkDto> rows;
}
