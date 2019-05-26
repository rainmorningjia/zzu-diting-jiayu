package com.zzu.diting.dto.complaint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/26 16:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintNumberDto implements Serializable {
    private Integer code;
    private String message;
    private UrlTotalNumberDto urlTotalNumberDto;

}
