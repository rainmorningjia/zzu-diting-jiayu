package com.zzu.diting.mappers;

import com.zzu.diting.entity.ComplaintDistributionManagementInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ComplaintDistributionManagementInfoMapper extends Mapper<ComplaintDistributionManagementInfoPO> {

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndAll(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndComplaintPlatform(@Param("complaintPlatform") String complaintForm, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndNode(@Param("node") String node, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndDistributionName(@Param("distributionName") String distributionName, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndOperatorName(@Param("operatorName") String operatorName, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintDistributionManagementInfoPO> queryDistributionManagementInfoByRightTypeAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer getTotalNumberByRightType(@Param("rightType") String rightType);

    Integer getTotalNumberByRightTypeAndComplaintPlatform(@Param("complaintPlatform") String complaintForm, @Param("rightType") String rightType);

    Integer getTotalNumberByRightTypeAndNode(@Param("node") String node, @Param("rightType") String rightType);

    Integer getTotalNumberByRightTypeAndDistributionName(@Param("distributionName") String distributionName, @Param("rightType") String rightType);

    Integer getTotalNumberByRightTypeAndOperatorName(@Param("operatorName") String operatorName, @Param("rightType") String rightType);

    Integer getTotalNumberByRightTypeAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("rightType") String rightType);
}