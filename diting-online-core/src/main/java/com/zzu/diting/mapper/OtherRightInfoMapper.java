package com.zzu.diting.mapper;

import com.zzu.diting.entityOtherRightInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@Mapper
public interface OtherRightInfoMapper extends BaseMapper<OtherRightInfoPO> {

    Integer queryTotalNumberOtherRightInfoAll();

    List<OtherRightInfoPO> queryOtherRightInfoAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOtherRightInfoByCopyrightName(@Param("copyrightName") String copyrightName);

    List<OtherRightInfoPO> queryOtherRightInfoByCopyrightName(@Param("copyrightName") String copyrightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOtherRightInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<OtherRightInfoPO> queryOtherRightInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberOtherRightInfoByUserId(@Param("userIs") Long userId);

    List<OtherRightInfoPO> queryOtherRightInfoByUserId(@Param("userIs") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<OtherRightInfoPO> queryOtherRightInfoOfNameAndId(@Param("name") String name);
}
