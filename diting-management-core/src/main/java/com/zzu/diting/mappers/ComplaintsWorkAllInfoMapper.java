package com.zzu.diting.mappers;

import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/9 16:52
 */
@Mapper
public interface ComplaintsWorkAllInfoMapper extends BaseMapper<ComplaintsWorkInfoPO> {


    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndType(@Param("rightType") String rightType);

    /**
     * 查询所有处理节点中的全部处理进度
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndType(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndType(@Param("rightType") String rightType);

    /**
     * 查询所有处理节点中待处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndType(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndType(@Param("rightType") String rightType);

    /**
     * 查询所有处理节点中已处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndType(@Param("rightType") String rightType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndType(@Param("rightType") String rightType, @Param("node") String node);

    /**
     * 查询某个处理节点中的所有处理进度信息
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndType(@Param("rightType") String rightType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer totalNumberForComplaintsWorkAllByOneNodeAndPendingAndType(@Param("rightType") String rightType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndType(@Param("rightType") String rightType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer totalNumberForComplaintsWorkAllByOneNodeAndProcessedAndType(@Param("rightType") String rightType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndType(@Param("rightType") String rightType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndWorkIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中的全部处理进度通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndWorkIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndWorkIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中待处理的工单通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndWorkIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中已处理的工单通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    /**
     * 查询某个处理节点中的所有处理进度信息通过工单id集合
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中的全部处理进度通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中待处理的工单通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids);

    /**
     * 查询所有处理节点中已处理的工单通过工单id集合
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    /**
     * 查询某个处理节点中的所有处理进度信息通过工单id集合
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(@Param("rightType") String rightType, @Param("ids") List<Long> ids, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson);

    /**
     * 通过投诉人模糊查询所有处理节点中的全部处理进度
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson);

    /**
     * 通过投诉人模糊查询所有处理节点中待处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson);

    /**
     * 通过投诉人模糊查询所有处理节点中已处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node);

    /**
     * 通过投诉人模糊查询某个处理节点中的所有处理进度信息
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(@Param("rightType") String rightType, @Param("ComplaintPerson") String complaintPerson, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType);

    /**
     * 通过投诉类型查询所有处理节点中的全部处理进度
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType);

    /**
     * 通过投诉类型查询所有处理节点中待处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType);

    /**
     * 通过投诉类型查询所有处理节点中已处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node);

    /**
     * 通过投诉类型查询某个处理节点中的所有处理进度信息
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndComplaintTypeAndType(@Param("rightType") String rightType, @Param("ComplaintType") String complaintType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight);

    /**
     * 通过涉及权利模糊查询所有处理节点中的全部处理进度
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight);

    /**
     * 通过涉及权利模糊查询所有处理节点中待处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight);

    /**
     * 通过涉及权利模糊查询所有处理节点中已处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node);

    /**
     * 通过涉及权利模糊查询某个处理节点中的所有处理进度信息
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(@Param("rightType") String rightType, @Param("RelationRight") String relationRight, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 通过时间范围查询所有处理节点中的全部处理进度
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 通过时间范围查询所有处理节点中待处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 通过时间范围查询所有处理节点中已处理的工单
     *
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node);

    /**
     * 通过时间范围查询某个处理节点中的所有处理进度信息
     *
     * @param node
     * @param num1
     * @param num2
     * @return
     */
    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(@Param("rightType") String rightType, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

}
