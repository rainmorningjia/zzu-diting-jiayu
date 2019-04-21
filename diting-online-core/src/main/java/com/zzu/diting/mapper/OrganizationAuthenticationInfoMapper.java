package com.zzu.diting.mapper;

import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrganizationAuthenticationInfoMapper extends Mapper<OrganizationAuthenticationInfoPO> {

    Integer queryTotalNumberOrganizationAuthenticationAll();

    /**
     * 查询固定页码的个人权利信息数据
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间
     * @param sort 排序方式
     * @return 个人认证信息集合
     */
    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOrganizationAuthenticationByOrganizationName(@Param("organizationName") String organizationName);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByOrganizationName(@Param("organizationName") String organizationName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOrganizationAuthenticationByEmail(@Param("email") String email);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByEmail(@Param("email") String email, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOrganizationAuthenticationByCorporationName(@Param("corporationName") String corporationName);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByCorporationName(@Param("corporationName") String corporationName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOrganizationAuthenticationByTime(@Param("timeType") String timeType);

    List<OrganizationAuthenticationInfoPO> queryOrganizationAuthenticationByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
