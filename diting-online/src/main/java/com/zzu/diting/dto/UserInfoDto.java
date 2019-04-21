package com.zzu.diting.dto;

import com.zzu.diting.entity.UserInfoPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miles
 * @Title: UserInfoDto
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/20--18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private Integer code;
    private String message;
    private UserInfoPO userInfoPO;
}
