package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @ :
 * @date : 2019/4/19 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintResubmitDto implements Serializable {
    private Long id;
    private Long userId;
    private String processState;
    private UserComplaintDetailDto userComplaintDetailDto;
}
