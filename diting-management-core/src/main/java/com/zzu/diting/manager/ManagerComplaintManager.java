package com.zzu.diting.manager;

import com.zzu.diting.entity.ManagerComplaintInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ManagerComplaintManager {

    void addManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO);

    void deleteManagerComplaintById(Long id);

    ManagerComplaintInfoPO getManagerComplaintById(Long id);

    ManagerComplaintInfoPO getManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO);

    void updateManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO);
    Set<Long> getComplaintsByListId(List<Long> longs);

    /**
     * 起始页面（查询全部处理结果的投诉
     *
     * @param userId 管理员id
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsAll(@Param("mId") String userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询特定处理结果的投诉
     *
     * @param userId 管理员id
     * @param result 处理结果
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByResult(@Param("mId") String userId, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询特定投诉集合的全部投诉
     *
     * @param userId 管理员id
     * @param ids    投诉ID
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByIdAndAllResult(@Param("mId") String userId, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询特定投诉集合的特定处理结果投诉
     *
     * @param userId 管理员id
     * @param result 处理结果
     * @param ids    投诉ID
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByIdAndResult(@Param("mId") String userId, @Param("ids") List<Long> ids, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询投诉人的全部
     *
     * @param userId 管理员id
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintPersonAndAllResult(@Param("mId") String userId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询投诉人的特定处理结果
     *
     * @param userId 管理员id
     * @param result 处理结果
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintPersonAndResult(@Param("mId") String userId, @Param("person") String person, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉类型查询全部处理结果
     *
     * @param userId    管理员id
     * @param rightType 投诉类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByRightTypeAndAllResult(@Param("mId") String userId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉类型查询特定处理结果
     *
     * @param userId    管理员id
     * @param rightType 投诉类型
     * @param num1      起始行
     * @param result    处理结果
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByRightTypeAndResult(@Param("mId") String userId, @Param("rightType") String rightType, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据涉及权利查询全部处理结果
     *
     * @param userId    管理员id
     * @param rightName 涉及权利
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByRightNameAndAllResult(@Param("mId") String userId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据涉及权利查询全部处理结果
     *
     * @param userId    管理员id
     * @param rightName 涉及权利
     * @param num1      起始行
     * @param result    处理结果
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByRightNameAndResult(@Param("mId") String userId, @Param("rightName") String rightName, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉链接模糊查询全部处理结果
     *
     * @param userId       管理员id
     * @param complaintUrl 投诉链接
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintUrlAndAllResult(@Param("mId") String userId, @Param("complaintUrl") String complaintUrl, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉链接模糊查询特定处理结果
     *
     * @param userId       管理员id
     * @param complaintUrl 投诉链接
     * @param num1         起始行
     * @param result       处理结果
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByComplaintUrlAndResult(@Param("mId") String userId, @Param("complaintUrl") String complaintUrl, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据当前处理人模糊查询全部处理结果
     *
     * @param userId       管理员id
     * @param handlePerson 当前处理人
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByHandlePersonAndAllResult(@Param("mId") String userId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据当前处理人模糊查询特定处理结果
     *
     * @param userId       管理员id
     * @param handlePerson 当前处理人
     * @param num1         起始行
     * @param result       处理结果
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByHandlePersonAndResult(@Param("mId") String userId, @Param("handlePerson") String handlePerson, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据特定时间段查询全部处理结果
     *
     * @param userId    管理员id
     * @param timeType  时间类型
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByTimeAndAllResult(@Param("mId") String userId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据特定时间段查询全部处理结果
     *
     * @param userId    管理员id
     * @param timeType  时间类型
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param num1      起始行
     * @param result    处理结果
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> getManagerComplaintsByTimeAndResult(@Param("mId") String userId, @Param("timeType") String timeType, @Param("result") String result, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndListIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndOneTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndOneTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndUrlAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndUrlAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("url") String url, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndTimeAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ManagerComplaintInfoPO> getManagerComplaintByComplaintsIdAndTimeAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);


}
