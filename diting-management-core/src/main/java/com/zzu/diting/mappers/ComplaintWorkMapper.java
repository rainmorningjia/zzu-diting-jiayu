package com.zzu.diting.mappers;

import com.zzu.diting.entity.ComplaintWorkInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/3/30 15:07
 */
@org.apache.ibatis.annotations.Mapper
public interface ComplaintWorkMapper extends Mapper<ComplaintWorkInfoPO> {

    /**
     * 添加工单信息
     *
     * @param complaintWorkInfoPO 工单信息
     */
    void insertComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO);

    /**
     * 通过工单id和状态查询工单信息
     *
     * @param complaintId 工单id
     * @param stateOne    节点一状态
     * @return 工单信息
     */
    ComplaintWorkInfoPO selectComplaintWorkByComplaintIdAndStateOne(@Param("complaintId") Long complaintId, @Param("stateOne") String stateOne);

    /**
     * 通过工单id和状态查询工单信息
     *
     * @param complaintId 工单id
     * @param stateTwo    节点一状态
     * @return 工单信息
     */
    ComplaintWorkInfoPO selectComplaintWorkByComplaintIdAndStateTwo(@Param("complaintId") Long complaintId, @Param("stateTwo") String stateTwo);

    /**
     * 查询总行数
     *
     * @param worksId 工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessing(@Param("worksId") Long worksId);

    /**
     * 通过工单集id查询工单信息
     *
     * @param worksId 工单集信息
     * @param num1    起始行
     * @param num2    结束行
     * @param time    排序时间类型
     * @param sort    排序方式
     * @return 查询结果
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessing(@Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param nodeState 节点状态
     * @param state     节点
     * @param worksId   工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessing(@Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * 通过工单集id查询工单信息
     *
     * @param worksId   工单集信息
     * @param num1      起始行
     * @param num2      结束行
     * @param state     节点
     * @param nodeState 节点状态
     * @param time      排序时间类型
     * @param sort      排序方式
     * @return 查询结果
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessing(@Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param ids     工单id集
     * @param worksId 工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId);

    /**
     * 通过工单集id和工单id集合查询工单信息
     *
     * @param ids     工单id集
     * @param worksId 工单集id
     * @param num1    起始行
     * @param num2    结束行
     * @param time    排序时间类型
     * @param sort    排序方式
     * @return 查询结果
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param ids       工单id集
     * @param worksId   工单集id
     * @param state     节点
     * @param nodeState 节点状态
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * @param ids       工单id集合
     * @param worksId   工单集id
     * @param state     节点
     * @param nodeState 节点状态
     * @param num1      起始行
     * @param num2      结束行
     * @param time      排序时间类型
     * @param sort      排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param complaintIds 投诉id集
     * @param worksId      工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessingAndListCompalintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId);

    /**
     * @param complaintIds 投诉id集
     * @param worksId      工单集id
     * @param num1         起始行
     * @param num2         结束行
     * @param time         排序时间类型
     * @param sort         排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListCompalintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param complaintIds 投诉id集
     * @param worksId      工单集id
     * @param state        节点
     * @param nodeState    节点状态
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessingAndListComplaintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * @param complaintIds 投诉id集
     * @param worksId      工单集id
     * @param state        节点
     * @param nodeState    节点状态
     * @param num1         起始行
     * @param num2         结束行
     * @param time         排序时间类型
     * @param sort         排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListComplaintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param commentIds 内容id集合
     * @param worksId    工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId);

    /**
     * @param commentIds 内容id集
     * @param worksId    工单集id
     * @param num1       起始行
     * @param num2       结束行
     * @param time       排序时间类型
     * @param sort       排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param commentIds 内容id集合
     * @param worksId    工单集id
     * @param state      节点
     * @param nodeState  节点状态
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * @param commentIds 内容id集
     * @param worksId    工单集id
     * @param state      节点
     * @param nodeState  节点状态
     * @param num1       起始行
     * @param num2       结束行
     * @param time       排序时间类型
     * @param sort       排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 总条数
     *
     * @param complaintUrl 投诉类型
     * @param worksId      工单集id
     * @return 总条数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId);

    /**
     * 查询投诉工单集合
     *
     * @param complaintUrl 投诉类型
     * @param worksId      工单集id
     * @param num1         起始行
     * @param num2         结束行
     * @param time         排序时间类型
     * @param sort         排序方式
     * @return 投诉工单集合
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 总条数
     *
     * @param complaintUrl 投诉类型
     * @param worksId      工单集id
     * @param state        节点
     * @param nodeState    节点状态
     * @return 总条数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * 查询投诉工单集合
     *
     * @param complaintUrl 投诉类型
     * @param worksId      工单集id
     * @param state        节点
     * @param nodeState    节点状态
     * @param num1         起始行
     * @param num2         结束行
     * @param time         排序时间类型
     * @param sort         排序方式
     * @return 投诉工单集合
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param timeType  时间类型
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param worksId   工单集id
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndAllProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId);

    /**
     * @param timeType  时间类型
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param worksId   工单集id
     * @param num1      起始行
     * @param num2      结束行
     * @param time      排序时间类型
     * @param sort      排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 查询总行数
     *
     * @param timeType  时间类型
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param worksId   工单集id
     * @param state     节点
     * @param nodeState 节点状态
     * @return 总行数
     */
    Integer queryTotalNumberWorksByWorksIdAndOneProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState);

    /**
     * @param timeType  时间类型
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param worksId   工单集id
     * @param state     节点
     * @param nodeState 节点状态
     * @param num1      起始行
     * @param num2      结束行
     * @param time      排序时间类型
     * @param sort      排序方式
     * @return
     */
    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
