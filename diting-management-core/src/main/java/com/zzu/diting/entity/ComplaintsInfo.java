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
 * @description: 投诉集信息表
 * @date : 2019/3/26 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complaints_info")
public class ComplaintsInfo implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String managerId;
    private Long complaintPersonId;
    private String complaintPerson;
    private String rightType;
    private Long rightId;
    private String rightName;
    /**
     *投诉数量
     */
    private Byte complaintNumber;
    /**
     * 处理进度
     */
    private Double processing;
    /**
     * 备注
     */
    private String remark;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
