package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Miles
 * @Title: Tree
 * @ProjectName cmfz-jcy
 * @Date 2018/12/20--9:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree implements Serializable {
    private Integer id;
    private String text;
    private String state;
    private String url;
}
