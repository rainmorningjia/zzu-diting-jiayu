package com.zzu.diting.dto.complaintwork;

import com.zzu.diting.dto.HandleRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/9 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsWorkDetailDto implements Serializable {
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 处理记录
     */
    private List<HandleRecord> handleRecords;
    /**
     * 处理进度
     */
    private Double auditState;
    /**
     * 列表信息
     */
    private List<ComplaintWorkTableDto> rows;
    /**
     * 总条数
     */
    private Integer total;
}
