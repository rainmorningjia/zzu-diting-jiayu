package com.zzu.diting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Miles
 * @Title: UserInfoPO
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/10--22:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfoPO {
    private Long id;
    private String userName;
    private String sex;
    private Integer age;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String sign;
    private String headIconUrl;
    @Column(name = "gmt_create")
    private String createTime;
    @Column(name = "gmt_modified")
    private String updateTime;

}
