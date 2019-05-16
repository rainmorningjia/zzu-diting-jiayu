package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/5 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleRecord implements Serializable {
    /**
     * 处理时间
     */
    private String date;
    /**
     * 操作
     */
    private String operation;
    /**
     * 人员
     */
    private String name;
    /**
     * id
     */
    private String id;
}
