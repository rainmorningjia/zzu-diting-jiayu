package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResultDto implements Serializable {
    private Integer code;
    private String message;
    private String reason;
    private String  failType;

}
