package com.zzu.diting.manager;

import com.zzu.diting.entity.AuthenticationWorkInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 17:00
 */
public interface AuthenticationWorkManager  {
    void addAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO);
    void deleteAuthenticationWorkInfoById(Long id);
    void updateAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO);
    AuthenticationWorkInfoPO getAuthenticationWorkInfoById(Long id);
    AuthenticationWorkInfoPO getAuthenticationWorkInfo(AuthenticationWorkInfoPO authenticationWorkInfoPO);
    /**
     * 起始页面（查询所有类型的工单）
     *
     * @param num1 起始行
     * @param num2 结束行
     * @param time 时间类型
     * @param sort 排序方式
     * @return 权利工单集合
     */
    List<AuthenticationWorkInfoPO> getAllWorksAndAllAuditState(@Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksAndAuditState(@Param("auditState") String auditState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByOrderTypeAndAllState(@Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByOrderTypeAndState(@Param("orderType") String orderType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorkByNicknameAndAllState(@Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorkByNicknameAndState(@Param("nickname") String nickname, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByRealNameAndAllState(@Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByRealNameAndState(@Param("realName") String realName, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByUserTypeAndAllState(@Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByUserTypeAndState(@Param("userType") String userType, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByHandlePersonAndAllState(@Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByHandlePersonAndState(@Param("handlePerson") String handlePerson, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByTimeAndAllState(@Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByTimeAndState(@Param("timeType") String timeType, @Param("state") String state, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getAllWorksByMIdAndPendingDisposalAndState(@Param("aId") Long aId, @Param("state") String state, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndWorkIdAndState(@Param("aId") Long aId, @Param("state") String state, @Param("workId") Long workId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndOrderTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndUserIdAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndNicknameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndRealNameAndState(@Param("aId") Long aId, @Param("state") String state, @Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndUserTypeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndHandlePersonAndState(@Param("aId") Long aId, @Param("state") String state, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndPendingDisposalAndTimeAndState(@Param("aId") Long aId, @Param("state") String state, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndTimeAndAllState(@Param("aId") Long aId, @Param("timeType") String timeType, @Param("t1") Long t1, @Param("t2") Long t2, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndHandlePersonAndAllState(@Param("aId") Long aId, @Param("handlePerson") String handlePerson, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndUserTypeAndAllState(@Param("aId") Long aId, @Param("userType") String userType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndRealNameAndAllState(@Param("aId") Long aId, @Param("realName") String realName, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndNicknameAndAllState(@Param("aId") Long aId, @Param("nickname") String nickname, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);
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
    List<AuthenticationWorkInfoPO> getWorksByMIdAndProcessedAndOrderTypeAndAllState(@Param("aId") Long aId, @Param("orderType") String orderType, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("time") String time, @Param("sort") String sort);

}
