package com.zzu.diting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/5 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransmitLisQueryParam implements Serializable {
    /**
     * 转交工单id集合
     */
    private List<Long> ids;
    /**
     * 转交审核者id工单集合
     */
    private List<String> auditors;
    /**
     * 节点信息
     * 1:版权管理组
     * 2:版权处理组
     */
    private Integer node;

}
