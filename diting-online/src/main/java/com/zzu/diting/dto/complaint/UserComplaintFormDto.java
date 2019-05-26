package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @ :
 * @date : 2019/4/18 17:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintFormDto implements Serializable {
    private String message;
    private Integer code;
    private String state;
    private UserComplaintDetailDto userComplaintDetailDto;
}
