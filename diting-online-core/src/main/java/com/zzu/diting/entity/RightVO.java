package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/3/22 11:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightVO implements Serializable {
    private Long id;
    private String rightName;
    private String rightType;
    private String rightUrl;
    private String copyrightPersonType;
    private String auditResult;
    private Long createTime;
}
