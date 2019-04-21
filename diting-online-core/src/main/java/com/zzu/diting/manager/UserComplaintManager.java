package com.zzu.diting.manager;


import com.zzu.diting.entity.UserComplaintInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserComplaintManager {
    void addUserComplaint(UserComplaintInfoPO complaintInfoPO);
    void deleteUserComplaintById(Long id);
    UserComplaintInfoPO getUserComplaint(Long id);
    UserComplaintInfoPO getUserComplaint(UserComplaintInfoPO userComplaintInfoPO);

    List<UserComplaintInfoPO> getListComplaintByPageAndTimeAndAll(Long userId, Integer num1, Integer num2, Long t1, Long t2);

    /**
     * 全部权利的特定状态
     *
     * @param userId 用户id
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintsAllRightAndState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String processState);

    /**
     * 特定权利的全部状态
     *
     * @param userId    用户id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintsRightAndAllState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType);

    /**
     * 特定权利的全部状态
     *
     * @param userId    用户id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintsRightAndState(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType, String processState);

    /**
     * 特定id的全部投诉类型全部状态
     *
     * @param userId 用户id
     * @param id     投诉id
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByIdAllRightAndAllState(Long userId, @Param("id") Long id, Integer num1, Integer num2, Long t1, Long t2);

    /**
     * @param userId    用户id
     * @param id        投诉id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByIdRightAndAllState(Long userId, @Param("id") Long id, Integer num1, Integer num2, Long t1, Long t2, String rightType);

    /**
     * 特定id的全部投诉类型特定状态
     *
     * @param userId 用户id
     * @param id     投诉id
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @param state  状态
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByIdAllRightAndState(Long userId, @Param("id") Long id, Integer num1, Integer num2, Long t1, Long t2, String state);

    /**
     * 特定id的特定投诉类型特定状态
     *
     * @param userId    用户id
     * @param id        投诉id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param state     状态
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByIdRightAndState(Long userId, @Param("id") Long id, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType);

    /**
     * 根据投诉链接模糊查询所有投诉信息
     *
     * @param userId 用户id
     * @param url    投诉链接
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByUrlAndAllRightAndAllState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2);

    /**
     * 根据投诉链接模糊查询特定权利的全部状态投诉信息
     *
     * @param userId    用户id
     * @param url       投诉链接
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByUrlAndOneRightAndAllState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String rightType);

    /**
     * 根据投诉链接模糊查询全部权利的特定状态投诉信息
     *
     * @param userId 用户id
     * @param url    投诉链接
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @param state  状态
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByUrlAndAllRightAndOneState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String state);

    /**
     * 根据投诉链接模糊查询特定权利的特定状态投诉信息
     *
     * @param userId    用户id
     * @param url       投诉链接
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param state     状态
     * @param rightType 权利
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByUrlAndOneRightAndOneState(Long userId, String url, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType);

    /**
     * 根据权利名称模糊查询全部权利的全部状态投诉信息
     *
     * @param userId 用户id
     * @param name   权利名称
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByNameAndAllRightAndAllState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2);

    /**
     * 根据权利名称模糊查询特定权利的全部状态投诉信息
     *
     * @param userId    用户id
     * @param name      权利名称
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType :权利类型
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByNameAndOneRightAndAllState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String rightType);

    /**
     * 根据权利名称模糊查询全部权利的特定状态投诉信息
     *
     * @param userId 用户id
     * @param name   权利名称
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @param state  状态
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByNameAndAllRightAndOneState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String state);

    /**
     * 根据权利名称模糊查询特定权利的特定状态投诉信息
     *
     * @param userId    用户id
     * @param name      权利名称
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param state     状态
     * @param rightType 权利类型
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByNameAndOneRightAndOneState(Long userId, String name, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType);

    /**
     * 根据权利id精准查询特全部权利的全部状态投诉信息
     *
     * @param userId  用户id
     * @param rightId 权利id
     * @param num1    起始行
     * @param num2    结束行
     * @param t1      起始时间
     * @param t2      结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByRightIdAndAllRightAndAllState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2);

    /**
     * 根据权利id精准查询特定权利的全部状态投诉信息
     *
     * @param userId    用户id
     * @param rightId   权利id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param rightType 权利类型
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByRightIdAndOneRightAndAllState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String rightType);

    /**
     * 根据权利id精准查询全部权利的特定状态投诉信息
     *
     * @param userId  用户id
     * @param rightId 权利id
     * @param num1    起始行
     * @param num2    结束行
     * @param t1      起始时间
     * @param t2      结束时间
     * @param state   状态
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByRightIdAndAllRightAndOneState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String state);

    /**
     * 根据权利id精准查询特定权利的特定状态投诉信息
     *
     * @param userId    用户id
     * @param rightId   权利id
     * @param num1      起始行
     * @param num2      结束行
     * @param t1        起始时间
     * @param t2        结束时间
     * @param state     状态
     * @param rightType 权利类型
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> getComplaintByRightIdAndOneRightAndOneState(Long userId, Long rightId, Integer num1, Integer num2, Long t1, Long t2, String state, String rightType);
    void updateUserComplaint(UserComplaintInfoPO userComplaintInfoPO);
}
