package com.zzu.diting.manager;

import com.zzu.diting.entity.RightWorkInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightWorkManager {
    void addRightWorkInfo(RightWorkInfoPO rightWorkInfoPO);

    void deleteRightWorkById(Long id);

    void updateRightWork(RightWorkInfoPO rightWorkInfoPO);

    RightWorkInfoPO getRightWorkById(Long id);

    RightWorkInfoPO getRightWork(RightWorkInfoPO rightWorkInfoPO);

    /**
     * 查询所有权利工单
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 排序时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */

    List<RightWorkInfoPO> getAllWorksByAllState(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<RightWorkInfoPO> getAllWorksByState(@Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightTypeAndAllState(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightTypeAndState(@Param("rightType") String rightType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightNameAndAllState(@Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightNameAndState(@Param("rightName") String rightName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightPersonAndAllState(@Param("rightPerson") String rightPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByRightPersonAndState(@Param("rightPerson") String rightPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByUserTypeAndAllState(@Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByHandlePersonAndAllState(@Param("handlerPerson") String handlerPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByHandlePersonAndState(@Param("handlerPerson") String handlerPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByTimeTypeAndAllState(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getAllWorksByTimeTypeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<RightWorkInfoPO> getWorksByMIdAndState(@Param("mId") String mId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据审核者id查询已处理进度的全部权利工单
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 排序时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */
    List<RightWorkInfoPO> getWorksByMIdAndProcessedState(@Param("mId") String mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndOrderTypeAndAllProcessed(@Param("mId") String mId, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndOrderTypeAndState(@Param("mId") String mId, @Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightTypeAndAllProcessed(@Param("mId") String mId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightTypeAndState(@Param("mId") String mId, @Param("rightType") String rightType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightNameAndAllProcessed(@Param("mId") String mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightNameAndState(@Param("mId") String mId, @Param("rightName") String rightName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightPersonAndAllProcessed(@Param("mId") String mId, @Param("rightPerson") String rightPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndRightPersonAndState(@Param("mId") String mId, @Param("rightPerson") String rightPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndUserTypeAndAllProcessed(@Param("mId") String mId, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndUserTypeAndState(@Param("mId") String mId, @Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndHandlePersonAndAllProcessed(@Param("mId") String mId, @Param("handlerPerson") String handlerPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndHandlePersonAndState(@Param("mId") String mId, @Param("handlerPerson") String handlerPerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndTimeTypeAndAllProcessed(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<RightWorkInfoPO> getWorksByMIdAndTimeTypeAndState(@Param("mId") String mId, @Param("timeType") String timeType, @Param("state") String state, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
