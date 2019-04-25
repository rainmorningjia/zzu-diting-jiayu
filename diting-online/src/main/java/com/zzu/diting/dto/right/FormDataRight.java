package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDataRight {
    /**
     * 审结状态
     */
    private String auditState;
    RightDetailedDto rightDetailedDto;
}
