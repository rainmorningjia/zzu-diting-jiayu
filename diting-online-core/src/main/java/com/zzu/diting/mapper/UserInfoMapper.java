package com.zzu.diting.mapper;

import com.zzu.diting.entity.UserInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author Miles
 * @Title: UserInfoMapper
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/10--22:49
 */
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {
    /**
     * 根据日期和认证状态查询用户
     *
     * @param date 日期
     * @return 已认证用户
     */
    List<UserInfoPO> queryUserByAuthenticationStateByDate(@Param("state") Integer state,@Param("date") Long date);

}
