package com.zzu.diting.mapper;

import com.zzu.diting.entity.AuthenticationWorkInfoPO;
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

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessing(@Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessing(@Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListId(@Param("ids") List<Long> ids, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListCompalintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListComplaintIds(@Param("complaintIds") List<Long> complaintIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndListCommentIds(@Param("commentIds") List<Long> commentIds, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndComplaintUrl(@Param("complaintUrl") String complaintUrl, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndAllProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    List<ComplaintWorkInfoPO> queryWorksByWorksIdAndOneProcessingAndTime(@Param("timeType") String timeType, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("worksId") Long worksId, @Param("state") String state, @Param("nodeState") String nodeState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
