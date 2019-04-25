package com.zzu.diting.mapper;

import com.zzu.diting.entityReputationPortraitInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@Mapper
public interface ReputationPortraitInfoMapper extends BaseMapper<ReputationPortraitInfoPO> {

    Integer queryTotalNumberReputationPortraitInfoAll();

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberReputationPortraitInfoByCopyrightName(@Param("copyrightName") String copyrightName);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoByCopyrightName(@Param("copyrightName") String copyrightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberReputationPortraitInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberReputationPortraitInfoByUserId(@Param("userId") Long userId);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoByUserId(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoOfNameAndId(@Param("name") String name);
}
