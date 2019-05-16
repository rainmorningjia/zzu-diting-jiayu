package com.zzu.diting.dto.authenticationwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/27 17:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDetailFormDto implements Serializable {
    private Integer code;
    private String message;
    private AuthenticationDetailDto authenticationDetailDto;
}
