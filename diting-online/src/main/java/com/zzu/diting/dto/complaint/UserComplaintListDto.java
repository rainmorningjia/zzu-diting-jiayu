package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author :wb-jcy525678
* @ :
 * @date : 2019/4/16 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintListDto {
    private List<UserComplaintInfoDto> rows;
    private Integer total;

}
