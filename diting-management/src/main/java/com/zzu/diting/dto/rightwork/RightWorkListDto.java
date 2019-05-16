package com.zzu.diting.dto.rightwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/6 11:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWorkListDto implements Serializable {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 处理消息
     */
    private String message;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 表格数据
     */
    private List<RightWorkTableInfoDto> rows;
}
