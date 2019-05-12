package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manager_info")
public class ManagerInfo implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String email;
    private String sex;
    private String password;
    private String department;
    private String sign;
    private String address;
    private String salt;
    private String node;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;

}
