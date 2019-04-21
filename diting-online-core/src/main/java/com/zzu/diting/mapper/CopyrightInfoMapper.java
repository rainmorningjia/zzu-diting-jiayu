package com.zzu.diting.mapper;

import com.zzu.diting.entity.CopyrightInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@Mapper
public interface CopyrightInfoMapper extends BaseMapper<CopyrightInfoPO> {

    /**
     * 查询固定页码的著作权信息
     *
     * @param num1
     * @param num2
     * @return
     */
    List<CopyrightInfoPO> queryCopyrightInfoList(@Param("num1") Integer num1, @Param("num2") Integer num2);

    Integer queryTotalNumberCopyrightInfoAll();

    List<CopyrightInfoPO> queryCopyrightInfoAll(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberCopyrightInfoByCopyrightName(@Param("copyrightName") String copyrightName);

    List<CopyrightInfoPO> queryCopyrightInfoByCopyrightName(@Param("copyrightName") String copyrightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberCopyrightInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<CopyrightInfoPO> queryCopyrightInfoByTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberCopyrightInfoByUserId(@Param("userId") Long userId);

    List<CopyrightInfoPO> queryCopyrightInfoByUserId(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<CopyrightInfoPO> queryCopyRightInfoOfNameAndId(@Param("name") String name);

}
