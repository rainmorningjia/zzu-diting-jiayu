package com.zzu.diting.mapper;

import com.zzu.diting.entityPersonalAuthenticationInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface PersonalAuthenticationInfoMapper extends Mapper<PersonalAuthenticationInfoPO> {
    Integer queryTotalNumberPersonalAuthenticationAll();

    /**
     * 查询固定页码的个人权利信息数据
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间
     * @param sort 排序方式
     * @return 个人认证信息集合
     */
    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberPersonalAuthenticationByRealName(@Param("realName") String realName);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByRealName(@Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberPersonalAuthenticationByEmail(@Param("email") String email);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByEmail(@Param("email") String email, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberPersonalAuthenticationByTime(@Param("timeType") String timeType);

    List<PersonalAuthenticationInfoPO> queryPersonalAuthenticationByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
