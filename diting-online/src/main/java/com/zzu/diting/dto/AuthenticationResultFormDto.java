package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miles
 * @Title: AuthenticationResultFormDto
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/19--20:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResultFormDto {
    private Integer code;
    private String message;
    private AuthenticationResultDto authenticationResultDto;
    private Integer userAuthenticationType;
}
