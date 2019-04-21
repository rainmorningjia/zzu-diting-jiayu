package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 14:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "operation_record_info")
public class OperationRecordInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long operationPersonId;
    /**
     * 操作人姓名
     */
    private String  name;
    private String operationType;
    private String operationRecord;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
