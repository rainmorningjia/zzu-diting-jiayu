package com.zzu.diting.mapper;

import com.zzu.diting.entity.AuthenticationWorkInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description: 认证审核工单表数据查询接口
 * @date : 2019/3/25 21:52
 */
@org.apache.ibatis.annotations.Mapper
public interface AuthenticationWorkInfoMapper extends Mapper<AuthenticationWorkInfoPO> {

    Integer queryTotalNumberForAllWorksAndAllAuditState();

    /**
     * 起始页面（查询所有类型的工单）
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksAndAllAuditState(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksAndAuditState(@Param("auditState") String auditState);

    /**
     * 查询特定处理进度的所有工单
     *
     * @param auditState 处理进度
     * @param num1       起始行
     * @param num2       结束行
     * @param time       时间类型
     * @param sort       排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksAndAuditState(@Param("auditState") String auditState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType);

    /**
     * 通过工单类型查询全部处理进度工单
     *
     * @param orderType 工单类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state);

    /**
     * 通过工单类型查询特定处理进度工单
     *
     * @param orderType 工单类型
     * @param state     处理进度
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorkByNicknameAndAllState(@Param("nickname") String nickname);

    /**
     * 通过昵称模糊查询全部处理进度工单
     *
     * @param nickname 昵称
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorkByNicknameAndAllState(@Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorkByNicknameAndState(@Param("nickname") String nickname, @Param("state") String state);

    /**
     * 通过昵称模糊查询特定处理进度工单
     *
     * @param nickname 昵称
     * @param state    处理进度
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorkByNicknameAndState(@Param("nickname") String nickname, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRealNameAndAllState(@Param("realName") String realName);

    /**
     * 根据用户昵称查询所有处理进度工单
     *
     * @param realName 真实姓名
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByRealNameAndAllState(@Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByRealNameAndState(@Param("realName") String realName, @Param("state") String state);

    /**
     * 根据用户昵称查询特定处理进度工单
     *
     * @param realName 真实姓名
     * @param state    处理进度
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByRealNameAndState(@Param("realName") String realName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserTypeAndAllState(@Param("userType") String userType);

    /**
     * 根据用户类型查询所有处理进度工单
     *
     * @param userType 用户类型
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByUserTypeAndAllState(@Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state);

    /**
     * 根据用户类型查询特定处理进度工单
     *
     * @param userType 用户类型
     * @param state    处理进度
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByHandlePersonAndAllState(@Param("handlePerson") String handlePerson);

    /**
     * 根據處理人模糊查詢全部處理進度工單
     *
     * @param handlePerson 處理人
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByHandlePersonAndAllState(@Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByHandlePersonAndState(@Param("handlePerson") String handlePerson, @Param("state") String state);

    /**
     * 根據處理人模糊查詢特定處理進度工單
     *
     * @param handlePerson 處理人
     * @param state        處理進度
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByHandlePersonAndState(@Param("handlePerson") String handlePerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserIdAndStateAndAllState(@Param("userId") Long userId);

    List<AuthenticationWorkInfoPO> queryAllWorksByUserIdAndStateAndAllState(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByUserIdAndStateAndState(@Param("userId") Long userId, @Param("state") String state);

    List<AuthenticationWorkInfoPO> queryAllWorksByUserIdAndStateAndState(@Param("userId") Long userId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByTimeAndAllState(@Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 根據特定時間段查看所有處理進度的工單
     *
     * @param timeType 時間類型
     * @param t1       起始時間
     * @param t2       結束時間
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByTimeAndAllState(@Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByTimeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 根據特定時間段查看特定處理進度的工單
     *
     * @param timeType 時間類型
     * @param state    處理進度
     * @param t1       起始時間
     * @param t2       結束時間
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByTimeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForAllWorksByMIdAndPendingDisposalAndState(@Param("aId") Long aId, @Param("state") String state);

    /**
     * 根据审核者id和处理类型查询全部工单
     *
     * @param aId   审核者id
     * @param state 处理状态
     * @param num1  起始行
     * @param num2  结束行
     * @param time  时间类型
     * @param sort  排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryAllWorksByMIdAndPendingDisposalAndState(@Param("aId") Long aId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    /**
     * 根据审核者id和工单id和处理类型查询全部工单
     *
     * @param aId    审核者id
     * @param state  处理状态
     * @param workId 工单id
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndWorkIdAndState(@Param("aId") Long aId, @Param("state") String state, @Param("workId") Long workId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndOrderTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("orderType") String orderType);

    /**
     * 根据审核者id和工单类型和处理类型查询全部工单
     *
     * @param aId       审核者id
     * @param state     处理状态
     * @param orderType 工单类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndOrderTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndUserIdAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userId") Long userId);

    /**
     * 根据审核者id和优酷id和处理类型查询全部工单
     *
     * @param aId    审核者id
     * @param state  处理状态
     * @param userId 优酷id
     * @param num1   起始行
     * @param num2   结束行
     * @param time   时间类型
     * @param sort   排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndUserIdAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndNicknameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("nickname") String nickname);

    /**
     * 根据审核者id和昵称和处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param state    处理状态
     * @param nickname 优酷昵称
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndNicknameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndRealNameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("realName") String realName);

    /**
     * 根据审核者id和真实姓名和处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param state    处理状态
     * @param realName 真实姓名
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndRealNameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndUserTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userType") String userType);

    /**
     * 根据审核者id和用户类型和处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param userType 用户类型
     * @param state    处理状态
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndUserTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndPendingDisposalAndHandlePersonAndState(@Param("aId") Long aId, @Param("state") String state, @Param("handlePerson") String handlePerson);

    /**
     * 根据审核者id和用户类型和处理类型查询全部工单
     *
     * @param aId          审核者id
     * @param handlePerson 处理人
     * @param state        处理状态
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(@Param("aId") Long aId, @Param("state") String state, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 根据审核者id和用户类型和处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param timeType 时间类型
     * @param t1       起始时间
     * @param t2       结束时间
     * @param state    处理状态
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndPendingDisposalAndTimeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndTimeAndAllState(@Param("aId") Long aId, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 根据审核者id和用户类型和已处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param timeType 时间类型
     * @param t1       起始时间
     * @param t2       结束时间
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndTimeAndAllState(@Param("aId") Long aId, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndHandlePersonAndAllState(@Param("aId") Long aId, @Param("handlePerson") String handlePerson);

    /**
     * 根据审核者id和用户类型和已处理类型查询全部工单
     *
     * @param aId          审核者id
     * @param handlePerson 处理人
     * @param num1         起始行
     * @param num2         结束行
     * @param time         时间类型
     * @param sort         排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndHandlePersonAndAllState(@Param("aId") Long aId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndUserTypeAndAllState(@Param("aId") Long aId, @Param("userType") String userType);

    /**
     * 根据审核者id和用户类型和已处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param userType 用户类型
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndUserTypeAndAllState(@Param("aId") Long aId, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndRealNameAndAllState(@Param("aId") Long aId, @Param("realName") String realName);

    /**
     * 根据审核者id和真实姓名和已处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param realName 真实姓名
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndRealNameAndAllState(@Param("aId") Long aId, @Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndNicknameAndAllState(@Param("aId") Long aId, @Param("nickname") String nickname);

    /**
     * 根据审核者id和昵称和已处理处理类型查询全部工单
     *
     * @param aId      审核者id
     * @param nickname 优酷昵称
     * @param num1     起始行
     * @param num2     结束行
     * @param time     时间类型
     * @param sort     排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndNicknameAndAllState(@Param("aId") Long aId, @Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorksByMIdAndProcessedAndOrderTypeAndAllState(@Param("aId") Long aId, @Param("orderType") String orderType);

    /**
     * 根据审核者id和工单类型和处理类型查询全部工单
     *
     * @param aId       审核者id
     * @param orderType 工单类型
     * @param num1      起始行
     * @param num2      结束行
     * @param time      时间类型
     * @param sort      排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> queryWorksByMIdAndProcessedAndOrderTypeAndAllState(@Param("aId") Long aId, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

    Integer queryTotalNumberForWorkByMIdAndProcessedAndUserIdAndAllState(@Param("aId") Long aId, @Param("userId") Long userId);

    List<AuthenticationWorkInfoPO> queryWorkByMIdAndProcessedAndUserIdAndAllState(@Param("aId") Long aId, @Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);
}
