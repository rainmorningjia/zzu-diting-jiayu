package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/5 12:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransmitQueryParam implements Serializable {
    /**
     * 工单id
     */
    private Long workId;
    /**
     * 审核者id
     */
  private String auditorId;
    /**
     * 审核者姓名
     */
    private String name;
}
