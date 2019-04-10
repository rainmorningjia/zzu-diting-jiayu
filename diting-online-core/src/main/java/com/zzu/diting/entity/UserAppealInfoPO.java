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
 * @Description: 用户申诉信息表
 * @Date:Created in 下午3:25 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_appeal_info")
public class UserAppealInfoPO implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private String appealInfo;
    /**
     * 申诉理由说明
     */
    private String appealReasonInfo;
    /**
     * 相关证明链接
     */
    private String relavantEvidenceUrl;
    /**
     * 审核状态
     */
    private String auditState;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
