package com.zzu.diting.mappers;

import com.zzu.diting.entity.RightDistributionManagementInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/1 9:58
 */
@Component(value = "rightDistributionManagementInfoMapper")
@org.apache.ibatis.annotations.Mapper
public interface RightDistributionManagementInfoMapper extends Mapper<RightDistributionManagementInfoPO> {

    Integer getTotalNumber(@Param("rightType") String rightType, @Param("workType") String workType, @Param("distribution") String distribution, @Param("operator") String operator, @Param("createTime") String createTime, @Param("updateTime") String updateTime, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * @param num1
     * @param num2
     * @param time
     * @param sort
     * @return
     */
    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * @param id
     * @return
     */
    RightDistributionManagementInfoPO queryRightDistributionManagementInfoById(@Param("id") Long id);

    /**
     * @param rightType
     * @param num1
     * @param num2
     * @param time
     * @param sort
     * @return
     */
    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoByRightType(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoWorkType(@Param("workType") String workType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoByDistributionName(@Param("distributionName") String distributionName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoByOperatorName(@Param("operatorName") String operatorName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightDistributionManagementInfoPO> queryRightDistributionManagementInfoByTime(@Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
