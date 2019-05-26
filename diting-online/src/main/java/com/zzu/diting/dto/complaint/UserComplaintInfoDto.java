package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @ :
 * @date : 2019/4/16 14:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintInfoDto implements Serializable {
    private Long id;
    private Long userId;
    /**
     * 投诉平台
     */
    private String complaintPlatform;
    private String complaintsUrl;
    private String copyrightType;
    private String rightName;
    private Long relationRightId;
    /**
     * 处理状态
     */
    private String processState;
    private String reason;
    private String createTime;
    private String updateTime;
}
