package com.zzu.diting.dto.complaintwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 15:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintAndRightInfoDto implements Serializable {
    /**
     * 类型
     */
    private String orderType;
    /**
     * 投诉id
     */
    private Long complaintId;
    /**
     * 投诉平台
     */
    private String complaintPlatform;
    /**
     * 权利类型
     */
    private String rightType;
    /**
     * 权利名称
     */
    private String rightName;
    /**
     * 导演信息
     */
    private String directorInfo;
    /**
     * 主演信息
     */
    private String performerMainInfo;
    /**
     * 作品集数
     */
    private String worksNumber;
    /**
     * 作品信息可参考网址
     */
    private String consultUrl;
    /**
     * 证明材料文件链接
     */
    private String proofMaterialUrl;
    /**
     * 知识产权证书链接
     */
    private String intellctualPropertyCertificatesUrl;
}
