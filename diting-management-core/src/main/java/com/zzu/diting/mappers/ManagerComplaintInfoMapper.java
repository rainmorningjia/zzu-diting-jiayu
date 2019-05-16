package com.zzu.diting.mappers;

import com.zzu.diting.entity.ManagerComplaintInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface ManagerComplaintInfoMapper extends Mapper<ManagerComplaintInfoPO> {
    void insertManagerComplaint(ManagerComplaintInfoPO managerComplaintInfoPO);

    Integer queryTotalNumberForManagerComplaintsAll(@Param("mId") String mId);

    /**
     * 起始页面（查询全部处理结果的投诉
     *
     * @param mId  管理员id
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsAll(@Param("mId") String mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByResult(@Param("mId") String mId, @Param("result") String result);

    /**
     * 查询特定处理结果的投诉
     *
     * @param mId    管理员id
     * @param result 处理结果
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByResult(@Param("mId") String mId, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByIdAndAllResult(@Param("mId") String mId, @Param("ids") List<Long> ids);

    /**
     * 查询特定投诉集合的全部投诉
     *
     * @param mId  管理员id
     * @param ids  投诉ID
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByIdAndAllResult(@Param("mId") String mId, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByIdAndResult(@Param("mId") String mId, @Param("ids") List<Long> ids, @Param("result") String result);

    /**
     * 查询特定投诉集合的特定处理结果投诉
     *
     * @param mId    管理员id
     * @param result 处理结果
     * @param ids    投诉ID
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByIdAndResult(@Param("mId") String mId, @Param("ids") List<Long> ids, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByComplaintPersonAndAllResult(@Param("mId") String mId, @Param("person") String person);

    /**
     * 查询投诉人的全部
     *
     * @param mId    管理员id
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByComplaintPersonAndAllResult(@Param("mId") String mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByComplaintPersonAndResult(@Param("mId") String mId, @Param("person") String person, @Param("result") String result);

    /**
     * 查询投诉人的特定处理结果
     *
     * @param mId    管理员id
     * @param result 处理结果
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByComplaintPersonAndResult(@Param("mId") String mId, @Param("person") String person, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByRightTypeAndAllResult(@Param("mId") String mId, @Param("rightType") String rightType);

    /**
     * 根据投诉类型查询全部处理结果
     *
     * @param mId       管理员id
     * @param rightType 投诉类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByRightTypeAndAllResult(@Param("mId") String mId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByRightTypeAndResult(@Param("mId") String mId, @Param("rightType") String rightType, @Param("result") String result);

    /**
     * 根据投诉类型查询特定处理结果
     *
     * @param mId       管理员id
     * @param rightType 投诉类型
     * @param num1      起始行
     * @param result    处理结果
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByRightTypeAndResult(@Param("mId") String mId, @Param("rightType") String rightType, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByAllRightTypeAndResult(@Param("mId") String mId, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintsByAllRightTypeAndResult(@Param("mId") String mId, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByRightNameAndAllResult(@Param("mId") String mId, @Param("rightName") String rightName);

    /**
     * 根据涉及权利查询全部处理结果
     *
     * @param mId       管理员id
     * @param rightName 涉及权利
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByRightNameAndAllResult(@Param("mId") String mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByRightNameAndResult(@Param("mId") String mId, @Param("rightName") String rightName, @Param("result") String result);

    /**
     * 根据涉及权利查询全部处理结果
     *
     * @param mId       管理员id
     * @param rightName 涉及权利
     * @param num1      起始行
     * @param result    处理结果
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByRightNameAndResult(@Param("mId") String mId, @Param("rightName") String rightName, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByComplaintUrlAndAllResult(@Param("mId") String mId, @Param("complaintUrl") String complaintUrl);

    /**
     * 根据投诉链接模糊查询全部处理结果
     *
     * @param mId          管理员id
     * @param complaintUrl 投诉链接
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByComplaintUrlAndAllResult(@Param("mId") String mId, @Param("complaintUrl") String complaintUrl, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByComplaintUrlAndResult(@Param("mId") String mId, @Param("complaintUrl") String complaintUrl, @Param("result") String result);

    /**
     * 根据投诉链接模糊查询特定处理结果
     *
     * @param mId          管理员id
     * @param complaintUrl 投诉链接
     * @param num1         起始行
     * @param result       处理结果
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByComplaintUrlAndResult(@Param("mId") String mId, @Param("complaintUrl") String complaintUrl, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByHandlePersonAndAllResult(@Param("mId") String mId, @Param("handlePerson") String handlePerson);

    /**
     * 根据当前处理人模糊查询全部处理结果
     *
     * @param mId          管理员id
     * @param handlePerson 当前处理人
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByHandlePersonAndAllResult(@Param("mId") String mId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByHandlePersonAndResult(@Param("mId") String mId, @Param("handlePerson") String handlePerson, @Param("result") String result);

    /**
     * 根据当前处理人模糊查询特定处理结果
     *
     * @param mId          管理员id
     * @param handlePerson 当前处理人
     * @param num1         起始行
     * @param result       处理结果
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByHandlePersonAndResult(@Param("mId") String mId, @Param("handlePerson") String handlePerson, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByTimeAndAllResult(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 根据特定时间段查询全部处理结果
     *
     * @param mId       管理员id
     * @param timeType  时间类型
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 管理员投诉集合
     */
    List<ManagerComplaintInfoPO> queryManagerComplaintsByTimeAndAllResult(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintsByTimeAndResult(@Param("mId") String mId, @Param("timeType") String timeType, @Param("result") String result, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 根据特定时间段查询全部处理结果
     *
     * @param mId       管理员id
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
    List<ManagerComplaintInfoPO> queryManagerComplaintsByTimeAndResult(@Param("mId") String mId, @Param("timeType") String timeType, @Param("result") String result, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);


    /**
     * 通过投诉集id查询列起始
     *
     * @param complaintsId 投訴集id
     * @return 條數
     */
    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndListIdAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndListIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndListIdAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("ids") List<Long> ids, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndComplaintPersonAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("complaintPerson") String complaintPerson);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndComplaintPersonAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("complaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndComplaintPersonAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("complaintPerson") String complaintPerson, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndComplaintPersonAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("complaintPerson") String complaintPerson, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndOneTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndOneTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndOneTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndOneTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("rightType") String rightType, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndRightNameAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightName") String rightName);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndRightNameAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndRightNameAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("rightName") String rightName, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndRightNameAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("rightName") String rightName, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndUrlAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("rightName") String rightName);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndUrlAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndUrlAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("url") String url, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndUrlAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("url") String url, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndHandlePersonAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("handlePerson") String handlePerson, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndTimeAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndTimeAndAllTypeAndAllState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForManagerComplaintByComplaintsIdAndTimeAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("result") String result);

    List<ManagerComplaintInfoPO> queryManagerComplaintByComplaintsIdAndTimeAndAllTypeAndOneState(@Param("complaintsId") Long complaintsId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("result") String result, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
