package com.zzu.diting.dto.authenticationwork;

import com.zzu.diting.dto.HandleRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/4/27 17:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDetailDto implements Serializable {
    private Long id;
    /**
     * 优酷账号id
     */
    private Long userId;
    /**
     * 优酷昵称
     */
    private String nickname;
    /**
     * 类型
     */
    private String orderType;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 证件类型
     */
    private String certificateType;
    /**
     * 证件照正面链接\\护照正面照\\证件正面照链接
     */
    private String certificatePositiveUrl;
    /**
     * 身份证反面照链接
     */
    private String certificateOppositeUrl;
    /**
     * 身份证手持照链接
     */
    private String certificateHandofUrl;
    /**
     * 证件号码
     */
    private String certificateNumber;
    /**
     * 组织名
     */
    private String organizationName;
    /**
     * 法人姓名
     */
    private String corporationName;
    /**
     * 新真实姓名
     */
    private String newRealName;
    /**
     * 新机构名
     */
    private String newOrganizationName;
    /**
     * 新证件类型
     */
    private String newCertificateType;
    /**
     * 新证件号码
     */
    private String newCertificateNumber;
    /**
     * 新证件照正面链接\\护照正面照\\证件正面照链接
     */
    private String newCertificatePositiveUrl;

    /**
     * 身份证反面照链接
     */
    private String newCertificateOppositeUrl;
    /**
     * 身份证手持链接
     */
    private String newCertificateHandofUrl;

    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮编
     */
    private String zip;
    /**
     * 座机电话区号
     */
    private String telAreaCode;
    /**
     * 座机电话号码
     */
    private String telNumber;
    /**
     * 座机分机
     */
    private String telExtension;


    private String fasAreaCode;
    private String fasNumber;
    private String fasExtension;
    /**
     * 意见
     */
    private String reason;
    /**
     * 联系人
     */
    private String relationName;
    /**
     * 处理人
     */
    private String handlePerson;
    /**
     * 处理进度
     */
    private String auditState;
    /**
     * 完成时间
     */
    private Timestamp completeTime;
    /**
     * 处理记录
     */
    private List<HandleRecord> handleRecords;
}
