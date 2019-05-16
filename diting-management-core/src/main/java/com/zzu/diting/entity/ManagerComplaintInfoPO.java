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
    /**
     * 投诉id
     */
    private Long id;
    /**
     * 管理员id
     */
    private String managerId;
    /**
     * 投诉人
     */
    private String complaintPerson;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 涉及权利
     */
    private String rightName;
    /**
     * 投诉链接
     */
    private String complaintUrl;
    /**
     * 投诉平台
     */
    private String complaintPlatform;
    /**
     * 审核结果
     */
    private String result;
    /**
     * 投诉集id
     */
    private Long complaintsId;
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 备注
     */
    private String remark;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
