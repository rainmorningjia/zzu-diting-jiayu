package com.zzu.diting.mapper;

import com.zzu.diting.entity.UserComplaintInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :wb-jcy525678
 */
@Mapper
public interface UserComplaintInfoTMapper {
    //1
    Integer queryTotalNumberByPageAndTimeAndAll(@Param("userId") Long userId, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 全部权利全部状态
     *
     * @param userId 用户id
     * @param num1   起始行
     * @param num2   结束行
     * @param t1     起始时间
     * @param t2     结束时间
     * @return 投诉集合
     */
    List<UserComplaintInfoPO> queryListComplaintByPageAndTimeAndAll(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

    //2
    Integer queryTotalNumberAllRightAndState(@Param("userId") Long userId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String processState);

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
    List<UserComplaintInfoPO> queryComplaintsAllRightAndState(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String processState);

    //3
    Integer queryTotalNumberRightAndAllState(@Param("userId") Long userId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintsRightAndAllState(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

    //4
    Integer queryTotalNumberRightAndState(@Param("userId") Long userId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType, @Param("state") String processState);

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
    List<UserComplaintInfoPO> queryComplaintsRightAndState(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType, @Param("state") String processState);

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
    List<UserComplaintInfoPO> queryComplaintByIdAllRightAndAllState(@Param("userId") Long userId, @Param("id") Long id, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

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
    List<UserComplaintInfoPO> queryComplaintByIdRightAndAllState(@Param("userId") Long userId, @Param("id") Long id, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);


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
    List<UserComplaintInfoPO> queryComplaintByIdAllRightAndState(@Param("userId") Long userId, @Param("id") Long id, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

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
    List<UserComplaintInfoPO> queryComplaintByIdRightAndState(@Param("userId") Long userId, @Param("id") Long id, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

    //5
    Integer queryTotalNumberByUrlAndAllRightAndAllState(@Param("userId") Long userId, @Param("url") String url, @Param("t1") Long t1, @Param("t2") Long t2);

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
    List<UserComplaintInfoPO> queryComplaintByUrlAndAllRightAndAllState(@Param("userId") Long userId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

    //6
    Integer queryTotalNumberByUrlAndOneRightAndAllState(@Param("userId") Long userId, @Param("url") String url, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByUrlAndOneRightAndAllState(@Param("userId") Long userId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

    //7
    Integer queryTotalNumberByUrlAndAllRightAndOneState(@Param("userId") Long userId, @Param("url") String url, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

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
    List<UserComplaintInfoPO> queryComplaintByUrlAndAllRightAndOneState(@Param("userId") Long userId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

    //8
    Integer queryTotalNumberByUrlAndOneRightAndOneState(@Param("userId") Long userId, @Param("url") String url, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByUrlAndOneRightAndOneState(@Param("userId") Long userId, @Param("url") String url, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

    //9
    Integer queryTotalNumberByNameAndAllRightAndAllState(@Param("userId") Long userId, @Param("name") String name, @Param("t1") Long t1, @Param("t2") Long t2);

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
    List<UserComplaintInfoPO> queryComplaintByNameAndAllRightAndAllState(@Param("userId") Long userId, @Param("name") String name, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

    //10
    Integer queryTotalNumberByNameAndOneRightAndAllState(@Param("userId") Long userId, @Param("name") String name, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByNameAndOneRightAndAllState(@Param("userId") Long userId, @Param("name") String name, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

    //11
    Integer queryTotalNumberByNameAndAllRightAndOneState(@Param("userId") Long userId, @Param("name") String name, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

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
    List<UserComplaintInfoPO> queryComplaintByNameAndAllRightAndOneState(@Param("userId") Long userId, @Param("name") String name, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

    //12
    Integer queryTotalNumberByNameAndOneRightAndOneState(@Param("userId") Long userId, @Param("name") String name, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByNameAndOneRightAndOneState(@Param("userId") Long userId, @Param("name") String name, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

    //13
    Integer queryTotalNumberByRightIdAndAllRightAndAllState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("t1") Long t1, @Param("t2") Long t2);

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
    List<UserComplaintInfoPO> queryComplaintByRightIdAndAllRightAndAllState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

    //14
    Integer queryTotalNumberByRightIdAndOneRightAndAllState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByRightIdAndOneRightAndAllState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

    //15
    Integer queryTotalNumberByRightIdAndAllRightAndOneState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

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
    List<UserComplaintInfoPO> queryComplaintByRightIdAndAllRightAndOneState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state);

    //16
    Integer queryTotalNumberByRightIdAndOneRightAndOneState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

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
    List<UserComplaintInfoPO> queryComplaintByRightIdAndOneRightAndOneState(@Param("userId") Long userId, @Param("rightId") Long rightId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("state") String state, @Param("rightType") String rightType);

}


