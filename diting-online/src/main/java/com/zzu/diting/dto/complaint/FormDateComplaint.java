package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
* @ :
 * @date : 2019/4/18 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDateComplaint implements Serializable {
    /**
     * 处理状态
     */
    private String state;
    private UserComplaintInfoDto userComplaintDetailDto;
}
