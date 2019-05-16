package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/10 16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditNodeListInfoDto implements Serializable {
    private Integer code;
    private String message;
    private List<AuditNodeInfoDto> list;
}
