package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: wb-jcy525678
 * @Description: 投诉审核工单表
 * @Date:Created in 下午4:25 2019/3/21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appeal_audit_info")
public class AppealAuditInfoPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private Long appleaId;
    private String videoName;
    private String handlingReason;
    private String auditState;
    private Integer isTransmit;
    private Integer isAddSign;
    private String infoSourcel;
    private String handleState;
    private String remark;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}
