package com.zzu.diting.service;

import com.zzu.diting.entity.UserInfoPO;

import java.util.List;

/**
 * @author 驾驭
 */
public interface DataService {
    /**
     * 得到用户认证数据
     * @param state 认证状态
     * @param date 日期
     * @return 用户信息
     */
    List<UserInfoPO> getUserAuthenticationData(Integer state, Long date);

    /**
     * 投诉量数据
     * @param rightType 权利类型
     * @param date 日期
     * @return 投诉量
     */
    Integer getUserComplaintData(String rightType, Long date);
}
