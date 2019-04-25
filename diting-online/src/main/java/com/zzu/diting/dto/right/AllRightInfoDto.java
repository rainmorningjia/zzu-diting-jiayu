package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AllRightInfoDto {
    /**
     * 权利信息
     */
    private FormDataRight formDataRight;

    /**
     * 消息状态
     */
    private Integer  code;
    private String message;

}
