package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/26 16:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlTotalNumberDto implements Serializable {
    /**
     * 总条数
     */
    private Integer totalNumber;
    /**
     * 已存在条数
     */
    private Integer existNumber;
    /**
     * 成功条数
     */
    private Integer successNumber;
}
