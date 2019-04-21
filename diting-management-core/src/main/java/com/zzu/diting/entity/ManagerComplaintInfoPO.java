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
 * @description : 小二投诉信息
 * @date : 2019/3/25 18:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manager_complaint_info")
public class ManagerComplaintInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long managerId;
    private String complaintPerson;
    private String rightType;
    private String rightName;
    private String complaintUrl;
    private String complaintPlatform;
    private String result;
    /**
     * 投诉集id
     */
    private Long complaintsId;
    /**
     * 当前处理人
     */
    private String handlePerson;
    private String remark;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
