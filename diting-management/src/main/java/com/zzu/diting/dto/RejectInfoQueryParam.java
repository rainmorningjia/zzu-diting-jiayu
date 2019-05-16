package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/5 17:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RejectInfoQueryParam {
    /**
     * id
     */
    private Long id;
    /**
     * 驳回类型
     */
    private String failType;
    /**
     * 驳回原因
     */
    private String reason;
}
