package com.zzu.diting.dto.right;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRightDto {
    /**
     * 权利id
     */
    private Long id;
    private RightDetailedDto rightDetailedDto;
    /**
     * 审核状态
     */
    private String auditState;
}
