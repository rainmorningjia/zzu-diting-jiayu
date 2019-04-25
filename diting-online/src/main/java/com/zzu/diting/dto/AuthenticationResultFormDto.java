package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResultFormDto {
    private Integer code;
    private String message;
    private AuthenticationResultDto authenticationResultDto;
}
