package com.zzu.diting.mapper;

import com.zzu.diting.entity.RightWorkInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface RightWorkMapper extends Mapper<RightWorkInfoPO> {

    Integer queryTotalNumberForAllWorksByAllState();

    /**
     * 查询所有权利工单
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 排序时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */
    List<RightWorkInfoPO> queryAllWorksByAllState(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByState(@Param("state") String state);

    /**
     * 查询特定处理进度的全部权利工单
     *
     * @param state 处理进度
     * @param num1  起始行
     * @param num2  结束行
     * @param time  排序时间类型
     * @param sort  排序方式
     * @return 权利工单集合
     */
    List<RightWorkInfoPO> queryAllWorksByState(@Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType);

    List<RightWorkInfoPO> queryAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightTypeAndAllState(@Param("rightType") String rightType);

    List<RightWorkInfoPO> queryAllWorksByRightTypeAndAllState(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightTypeAndState(@Param("rightType") String rightType, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByRightTypeAndState(@Param("rightType") String rightType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightNameAndAllState(@Param("rightName") String rightName);

    List<RightWorkInfoPO> queryAllWorksByRightNameAndAllState(@Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightNameAndState(@Param("rightName") String rightName, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByRightNameAndState(@Param("rightName") String rightName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightPersonAndAllState(@Param("rightPerson") String rightPerson);

    List<RightWorkInfoPO> queryAllWorksByRightPersonAndAllState(@Param("rightPerson") String rightPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightPersonAndState(@Param("rightPerson") String rightPerson, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByRightPersonAndState(@Param("rightPerson") String rightPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserTypeAndAllState(@Param("userType") String userType);

    List<RightWorkInfoPO> queryAllWorksByUserTypeAndAllState(@Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByHandlePersonAndAllState(@Param("handlerPerson") String handlerPerson);

    List<RightWorkInfoPO> queryAllWorksByHandlePersonAndAllState(@Param("handlerPerson") String handlerPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByHandlePersonAndState(@Param("handlerPerson") String handlerPerson, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByHandlePersonAndState(@Param("handlerPerson") String handlerPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByTimeTypeAndAllState(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<RightWorkInfoPO> queryAllWorksByTimeTypeAndAllState(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByTimeTypeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<RightWorkInfoPO> queryAllWorksByTimeTypeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightIdAndAllState(@Param("rightId") Long rightId);

    List<RightWorkInfoPO> queryAllWorksByRightIdAndAllState(@Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRightIdAndState(@Param("rightId") Long rightId, @Param("state") String state);

    List<RightWorkInfoPO> queryAllWorksByRightIdAndState(@Param("rightId") Long rightId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndState(@Param("mId") Long mId, @Param("state") Long state);

    /**
     * 根据审核者id查询特定处理进度的全部权利工单
     *
     * @param state 处理进度
     * @param num1  起始行
     * @param num2  结束行
     * @param time  排序时间类型
     * @param sort  排序方式
     * @return 权利工单集合
     */
    List<RightWorkInfoPO> queryWorksByMIdAndState(@Param("mId") Long mId, @Param("state") Long state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndAllProcessed(@Param("mId") Long mId);

    /**
     * 根据审核者id查询已处理进度的全部权利工单
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 排序时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */
    List<RightWorkInfoPO> queryWorksByMIdAndAllProcessed(@Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndOrderTypeAndAllProcessed(@Param("mId") Long mId, @Param("orderType") String orderType);

    List<RightWorkInfoPO> queryWorksByMIdAndOrderTypeAndAllProcessed(@Param("mId") Long mId, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndOrderTypeAndState(@Param("mId") Long mId, @Param("orderType") String orderType, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndOrderTypeAndState(@Param("mId") Long mId, @Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightTypeAndAllProcessed(@Param("mId") Long mId, @Param("rightType") String rightType);

    List<RightWorkInfoPO> queryWorksByMIdAndRightTypeAndAllProcessed(@Param("mId") Long mId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightTypeAndState(@Param("mId") Long mId, @Param("rightType") String rightType, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndRightTypeAndState(@Param("mId") Long mId, @Param("rightType") String rightType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightNameAndAllProcessed(@Param("mId") Long mId, @Param("rightName") String rightName);

    List<RightWorkInfoPO> queryWorksByMIdAndRightNameAndAllProcessed(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightNameAndState(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndRightNameAndState(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightIdAndAllProcessed(@Param("mId") Long mId, @Param("rightId") Long rightId);

    List<RightWorkInfoPO> queryWorksByMIdAndRightIdAndAllProcessed(@Param("mId") Long mId, @Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightIdAndState(@Param("mId") Long mId, @Param("rightId") Long rightId, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndRightIdAndState(@Param("mId") Long mId, @Param("rightId") Long rightId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightPersonAndAllProcessed(@Param("mId") Long mId, @Param("rightPerson") String rightPerson);

    List<RightWorkInfoPO> queryWorksByMIdAndRightPersonAndAllProcessed(@Param("mId") Long mId, @Param("rightPerson") String rightPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndRightPersonAndState(@Param("mId") Long mId, @Param("rightPerson") String rightPerson, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndRightPersonAndState(@Param("mId") Long mId, @Param("rightPerson") String rightPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndUserTypeAndAllProcessed(@Param("mId") Long mId, @Param("userType") String userType);

    List<RightWorkInfoPO> queryWorksByMIdAndUserTypeAndAllProcessed(@Param("mId") Long mId, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndUserTypeAndState(@Param("mId") Long mId, @Param("userType") String userType, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndUserTypeAndState(@Param("mId") Long mId, @Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndHandlePersonAndAllProcessed(@Param("mId") Long mId, @Param("handlerPerson") String handlerPerson);

    List<RightWorkInfoPO> queryWorksByMIdAndHandlePersonAndAllProcessed(@Param("mId") Long mId, @Param("handlerPerson") String handlerPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndHandlePersonAndState(@Param("mId") Long mId, @Param("handlerPerson") String handlerPerson, @Param("state") String state);

    List<RightWorkInfoPO> queryWorksByMIdAndHandlePersonAndState(@Param("mId") Long mId, @Param("handlerPerson") String handlerPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndTimeTypeAndAllProcessed(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<RightWorkInfoPO> queryWorksByMIdAndTimeTypeAndAllProcessed(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndTimeTypeAndState(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<RightWorkInfoPO> queryWorksByMIdAndTimeTypeAndState(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);


}
