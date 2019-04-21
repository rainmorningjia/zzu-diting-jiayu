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
 * @Author: wb-jcy525678
 * @Description: 用户投诉信息表
 * @Date:Created in 上午10:24 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_complaint_info")
public class UserComplaintInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private Long relationRightId;
    private String complaintsUrl;
    /**
     * 投诉平台
     */
    private String complaintPlatform;

    private String copyrightType;
    private String rightName;
    /**
     * 处理状态
     */
    private String processState;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
