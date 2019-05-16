package com.zzu.diting.manager;

import com.zzu.diting.entity.ComplaintsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 15:43
 */
public interface ComplaintsInfoManager {
    void addComplaintInfo(ComplaintsInfo complaintsInfo);
    void deleteComplaintInfoById(Long id);
    void updateComplaintInfo(ComplaintsInfo complaintsInfo);
    ComplaintsInfo getComplaintInfoById(Long id);
    ComplaintsInfo getComplaintInfo(ComplaintsInfo complaintsInfo);
    /**
     * 查询所有投诉集以特定时间排序
     *
     * @param mId  管理员id
     * @param num1 起始行数
     * @param num2 结束行数
     * @param time 时间类型
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsAll(@Param("mId") String mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);


    /**
     * 查询特定处理中进度状态投诉集以特定时间排序
     *
     * @param mId  管理员id
     * @param num1 起始行数
     * @param num2 结束行数
     * @param time 时间类型
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByProcessing(@Param("mId") String mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询特定已完成处理进度状态投诉集以特定时间排序
     *
     * @param mId  管理员id
     * @param num1 起始行数
     * @param time 时间类型
     * @param num2 结束行数
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByProcessingComplete(@Param("mId") String mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉集id精准查询
     *
     * @param mId 管理员id
     * @param cId 投诉集id
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByComId(@Param("mId") String mId, @Param("cId") Long cId);

    /**
     * 通过投诉人模糊查询全部处理结果以特定时间排序
     *
     * @param mId    管理员id
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByPersonAllPro(@Param("mId") String mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉人模糊查询处理中以特定时间排序
     *
     * @param mId    管理员id
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 投诉集集合
     */

    List<ComplaintsInfo> getComplaintsByPersonAndProcessing(@Param("mId") String mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉人模糊查询处理完成以特定时间排序
     *
     * @param mId    管理员id
     * @param person 投诉人
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByPersonAndProcessComplete(@Param("mId") String mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉集id集合模糊查询全部处理以特定时间排序
     *
     * @param mId  管理员id
     * @param list 投诉集id集合
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByListComplaintsIdAll(@Param("mId") String mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉集id集合模糊查询处理中以特定时间排序
     *
     * @param mId  管理员id
     * @param list 投诉集id集合
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByListComplaintsIdProcessing(@Param("mId") String mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉集id集合模糊查询处理完成以特定时间排序
     *
     * @param mId  管理员id
     * @param list 投诉集id集合
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByListComplaintsIdComplete(@Param("mId") String mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉类型查询全部处理进度以特定时间排序
     *
     * @param mId           管理员id
     * @param complaintType 投诉类型
     * @param num1          起始行
     * @param num2          结束行
     * @param time          时间类型
     * @param sort          排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByComplaintTypeAll(@Param("mId") String mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉类型查询处理中以特定时间排序
     *
     * @param mId           管理员id
     * @param complaintType 投诉类型
     * @param num1          起始行
     * @param num2          结束行
     * @param time          时间类型
     * @param sort          排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByComplaintTypeProcessing(@Param("mId") String mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过投诉类型查询处理完成以特定时间排序
     *
     * @param mId           管理员id
     * @param complaintType 投诉类型
     * @param num1          起始行
     * @param num2          结束行
     * @param time          时间类型
     * @param sort          排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByComplaintTypeComplete(@Param("mId") String mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及权利模糊查询全部处理进度以特定时间排序
     *
     * @param mId       管理员id
     * @param rightName 涉及权利
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByRightNameAll(@Param("mId") String mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及权利模糊查询处理中以特定时间排序
     *
     * @param mId       管理员id
     * @param rightName 涉及权利名称
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByRightNameProcessing(@Param("mId") String mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及权利模糊查询处理完成以特定时间排序
     *
     * @param mId       管理员id
     * @param rightName 涉及权利名称
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByRightNameComplete(@Param("mId") String mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及创建时间查询全部处理以特定时间排序
     *
     * @param mId       管理员id
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param timeType  时间类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByTimeAll(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及创建时间查询处理中以特定时间排序
     *
     * @param mId       管理员id
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param timeType  时间类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByTimeProcessing(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 通过涉及创建时间查询处理完成以特定时间排序
     *
     * @param mId       管理员id
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param timeType  时间类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 投诉集集合
     */
    List<ComplaintsInfo> getComplaintsByTimeComplete(@Param("mId") String mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
