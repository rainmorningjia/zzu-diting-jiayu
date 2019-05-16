package com.zzu.diting.dto.authenticationwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/27 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationWorkDto implements Serializable {
    private Long id;
    /**
     * 类型
     */
    private String orderType;
    /**
     * 用户账号id
     */
    private Long userId;
    /**
     * 账号昵称
     */
    private String nickname;
    /**
     * 名称
     */
    private String realName;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 当前处理人
     */
    private String handlePerson;
    /**
     * 处理进度
     */
    private String auditState;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 处理记录
     */
    private String handleRecord;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
