package com.zzu.diting.mapper;

import com.zzu.diting.entity.ComplaintsInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 投诉集映射
 *
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface ComplaintsInfoMapper extends Mapper<ComplaintsInfo> {

    Integer queryTotalNumberForComplaintsAll(@Param("mId") Long mId);

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
    List<ComplaintsInfo> queryComplaintsAll(@Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByProcessing(@Param("mId") Long mId);

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
    List<ComplaintsInfo> queryComplaintsByProcessing(@Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByProcessingComplete(@Param("mId") Long mId);

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
    List<ComplaintsInfo> queryComplaintsByProcessingComplete(@Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据投诉集id精准查询
     *
     * @param mId 管理员id
     * @param cId 投诉集id
     * @return 投诉集集合
     */
    List<ComplaintsInfo> queryComplaintsByComId(@Param("mId") Long mId, @Param("cId") Long cId);

    Integer queryTotalNumberForComplaintsByPersonAllPro(@Param("mId") Long mId, @Param("person") String person);

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
    List<ComplaintsInfo> queryComplaintsByPersonAllPro(@Param("mId") Long mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByPersonAndProcessing(@Param("mId") Long mId, @Param("person") String person);

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

    List<ComplaintsInfo> queryComplaintsByPersonAndProcessing(@Param("mId") Long mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByPersonAndProcessComplete(@Param("mId") Long mId, @Param("person") String person);

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
    List<ComplaintsInfo> queryComplaintsByPersonAndProcessComplete(@Param("mId") Long mId, @Param("person") String person, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByListComplaintsIdAll(@Param("mId") Long mId, @Param("ComIdList") List<Long> list);

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
    List<ComplaintsInfo> queryComplaintsByListComplaintsIdAll(@Param("mId") Long mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByListComplaintsIdProcessing(@Param("mId") Long mId, @Param("ComIdList") List<Long> list);

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
    List<ComplaintsInfo> queryComplaintsByListComplaintsIdProcessing(@Param("mId") Long mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByListComplaintsIdComplete(@Param("mId") Long mId, @Param("ComIdList") List<Long> list);

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
    List<ComplaintsInfo> queryComplaintsByListComplaintsIdComplete(@Param("mId") Long mId, @Param("ComIdList") List<Long> list, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberComplaintsByComplaintTypeAll(@Param("mId") Long mId, @Param("complaintType") String complaintType);

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
    List<ComplaintsInfo> queryComplaintsByComplaintTypeAll(@Param("mId") Long mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByComplaintTypeProcessing(@Param("mId") Long mId, @Param("complaintType") String complaintType);

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
    List<ComplaintsInfo> queryComplaintsByComplaintTypeProcessing(@Param("mId") Long mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByComplaintTypeComplete(@Param("mId") Long mId, @Param("complaintType") String complaintType);

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
    List<ComplaintsInfo> queryComplaintsByComplaintTypeComplete(@Param("mId") Long mId, @Param("complaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByRightNameAll(@Param("mId") Long mId, @Param("rightName") String rightName);

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
    List<ComplaintsInfo> queryComplaintsByRightNameAll(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByRightNameProcessing(@Param("mId") Long mId, @Param("rightName") String rightName);

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
    List<ComplaintsInfo> queryComplaintsByRightNameProcessing(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByRightNameComplete(@Param("mId") Long mId, @Param("rightName") String rightName);

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
    List<ComplaintsInfo> queryComplaintsByRightNameComplete(@Param("mId") Long mId, @Param("rightName") String rightName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByTimeAll(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

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
    List<ComplaintsInfo> queryComplaintsByTimeAll(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByTimeProcessing(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

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
    List<ComplaintsInfo> queryComplaintsByTimeProcessing(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsByTimeComplete(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

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
    List<ComplaintsInfo> queryComplaintsByTimeComplete(@Param("mId") Long mId, @Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);


}
