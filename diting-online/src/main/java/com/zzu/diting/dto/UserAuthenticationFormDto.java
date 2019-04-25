package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationFormDto {
    private String message;
    private Integer code;
    private String authenticationResult;
    private UserAuthenticationInfoDto userAuthenticationInfoDto;
}
