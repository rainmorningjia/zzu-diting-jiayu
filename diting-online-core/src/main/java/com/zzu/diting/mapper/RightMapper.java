package com.zzu.diting.mapper;
import com.zzu.diting.entity.RightVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author :wb-jcy525678
 * @description: 权利信息表的数据对象
 * @date : 2019/3/22 13:40
 */
@Mapper
public interface RightMapper {
    /**
     * 所有的都是全部类型
     *
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1          :起始时间
     * @param t2          ：结束时间
     * @return 权利集合
     */
    List<RightVO> queryRightsByUserIDAndRightAllAndTypeAll(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2);

    /**
     * 全部类型中的特定状态
     *
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1          :起始时间
     * @param t2          ：结束时间
     * @return 权利集合
     */
    List<RightVO> queryRightsByUserIDAndRightAllAndType(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("auditState") String auditState);

    /**
     * 特定类型中的全部状态
     *
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1          :起始时间
     * @param t2          ：结束时间
     * @return 权利集合
     */

    List<RightVO> queryRightsByUserIDAndRightAndTypeAll(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType);

    /**
     * 特定类型中的特定状态
     *
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1          :起始时间
     * @param t2          ：结束时间
     * @return 权利集合
     */

    List<RightVO> queryRightsByUserIDAndRightAndType(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("rightType") String rightType, @Param("auditState") String auditState);

    /**
     * 查询特定ID全部权利全部状态
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param id
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightIdAll(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("id") Long id);

    /**
     * 查询特定ID全部状态的特定权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param id
     * @param rightType
     * @return
     */

    List<RightVO> queryRightByUserIDAndRightIdType(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("id") Long id, @Param("rightType") String rightType);

    /**
     * 查询特定ID特定状态的全部权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param id
     * @param auditState
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightIdTypeAndAuditState(@Param("userId") Long userId, @Param("auditState") String auditState, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("id") Long id);


    /**
     * 查询特定ID特定状态的特定权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param id
     * @param rightType
     * @param auditState
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightIdTypeAndRight(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("id") Long id, @Param("rightType") String rightType, @Param("auditState") String auditState);

    /**
     * 根据权利名称模糊查询特定权利类型的全部状态权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param name
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightNameAndAll(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("name") String name);


    /**
     * 根据权利名称模糊查询特定权利类型的全部状态权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param name
     * @param rightType
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightNameAndAllStateOneRight(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("name") String name, @Param("rightType") String rightType);

    /**
     * 根据权利名称模糊查询特定权利类型的全部状态权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param name
     * @param state
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightNameAndOneStateAllRight(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("name") String name, @Param("state") String state);


    /**
     * 根据权利名称模糊查询特定权利类型的特定状态权利信息
     *
     * @param userId
     * @param num1
     * @param num2
     * @param t1
     * @param t2
     * @param name
     * @param state
     * @param rightType
     * @return
     */
    List<RightVO> queryRightByUserIDAndRightNameAndOneStateOneRight(@Param("userId") Long userId, @Param("num1") Integer num1, @Param("num2") Integer num2, @Param("t1") Long t1, @Param("t2") Long t2, @Param("name") String name, @Param("state") String state, @Param("rightType") String rightType);


    /**
     *  没有Id时的著作权的全部类型链接
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @param auditState:
     * @return 权利集合
     *
     */
    /*
     List<RightVO> queryRightsByUserIDAndCopyrightAndTypeAll(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2,@Param("auditState")String auditState);
    /**
     *  没有Id时的著作权的特定类型链接
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @param auditState:
     * @return 权利集合
     *
     *//*
    List<RightVO> queryRightsByUserIDAndCopyrightAndType(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2,@Param("auditState")String auditState);

    *//**
     *  没有Id时的名誉权全部类型链接
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @return 权利集合
     *
     *//*

    List<RightVO> queryRightsByUserIDAndPorightAndTypeAll(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2);


    *//**
     *  没有Id时的名誉权特定类型
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @param auditState:审核状态
     * @return 权利集合
     *
     *//*

    List<RightVO> queryRightsByUserIDAndPorightAndType(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2,@Param("auditState")String auditState);
    *//**
     *  没有id的其他权利全部类型信息
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @return 权利集合
     *//*
     List<RightVO> queryRightsByUserIDAndOtherRightAndTypeAll(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2);

    *//**
     *没有id的其他权利特定类型信息
     * @param userId:用户ID
     * @param num1:起始页码
     * @param num2:行数
     * @param t1 :起始时间
     * @param t2 ：结束时间
     * @param auditState:审核状态
     * @return 权利集合
     *//*
    List<RightVO> queryRightsByUserIDAndOtherRightAndType(@Param("userId") Long userId, @Param("num1")Integer num1,@Param("num2")Integer num2,@Param("t1")Long t1,@Param("t2")Long t2,@Param("auditState")String auditState);

    List<RightVO> queryRightsByUserIDAndRightIdOther(@Param("userId")Long userId,@Param("rightId") Long id,@Param("t1")Long t1,@Param("t2")Long t2);
    List<RightVO> queryRightsByUserIDAndRightIdPor(@Param("userId")Long userId,@Param("rightId") Long id,@Param("t1")Long t1,@Param("t2")Long t2);
    */
}
