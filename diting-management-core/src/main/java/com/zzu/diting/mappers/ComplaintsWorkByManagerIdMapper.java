package com.zzu.diting.mappers;

import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/10 11:01
 */
@Mapper
public interface ComplaintsWorkByManagerIdMapper extends tk.mybatis.mapper.common.Mapper<ComplaintsWorkInfoPO> {

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId);

    /**
     * 查询我的待处理的全部节点下的工单集
     *
     * @param mId
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId);

    /**
     * 查询我的已处理的全部节点下的工单集
     *
     * @param mId
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds);

    /**
     * 查询我的待处理下工单id集合有关的所有节点的工单集
     *
     * @param mId
     * @param workIds
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("node") String node);

    /**
     * 查询我的待处理下工单id集合有关的某个节点的工单集
     *
     * @param mId
     * @param workIds
     * @param node
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("workIds") List<Long> workIds, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds);

    /**
     * 根据管理员id和内容id集合查询所有节点下的工单集集合
     *
     * @param mId
     * @param commentIds
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("node") String node);

    /**
     * 根据管理员id和内容id集合查询某个节点下的工单集集合
     *
     * @param mId
     * @param commentIds
     * @param node
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("commentIds") List<Long> commentIds, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson);

    /**
     * 根据管理员id和投诉人查询所有节点下的工单集集合
     *
     * @param mId
     * @param complaintPerson
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("node") String node);

    /**
     * 根据管理员id和投诉人模糊查询某个节点下的工单集合
     *
     * @param mId
     * @param complaintPerson
     * @param node
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintPerson") String complaintPerson, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("node") String node);

    /**
     * 根据投诉类型
     *
     * @param mId
     * @param complaintTye
     * @param node
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndComplaintTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("complaintTye") String complaintTye, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType);

    /**
     * 根据涉及权利模糊查询
     *
     * @param mId
     * @param relationType
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("relationType") String relationType, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    /**
     * 通过特定时间段
     *
     * @param mId
     * @param time
     * @param startTime
     * @param endTime
     * @param num1
     * @param num2
     * @param timeType
     * @param sort
     * @return
     */
    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<ComplaintsWorkInfoPO> queryWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node);

    List<ComplaintsWorkInfoPO> queryWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(@Param("rightType") String rightType, @Param("mId") Long mId, @Param("time") String time, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("node") String node, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("timeType") String timeType, @Param("sort") String sort);

}
