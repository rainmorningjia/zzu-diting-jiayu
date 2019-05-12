package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
* @ : 投诉详情数据
 * @date : 2019/4/18 18:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintDetailDto implements Serializable {
    private String complaintPlatform;
    private String complaintsUrl;
    private String copyrightType;
    private String rightName;
}
