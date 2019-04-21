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
 * @date : 2019/4/9 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complaints_work_info")
public class ComplaintsWorkInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 投诉集id
     */
    private Long complaintsId;
    /**
     * 投诉人id
     */
    private Long complaintPersonId;
    /**
     * 处理人id
     */
    private Long handlePersonId;
    /**
     * 信息来源
     */
    private String infoSource;
    @Column(name = "right_type")
    private String complaintType;
    /**
     * 投诉人
     */
    private String complaintPerson;
    /**
     * 设计权利
     */
    private String relationRight;
    /**
     * 投诉量
     */
    private Integer complaintNumber;
    /**
     * 节点
     */
    private String node;
    /**
     * 处理进度
     */
    private Double processing;
    /**
     * 处理人
     */
    private String handlePerson;
    /**
     * 是否已被分配
     */
    private Integer isDistribution;
    /**
     * 处理记录
     */
    private String handleRecord;
    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Long createTime;
    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Long updateTime;

}
