package com.zzu.diting.manager;

import com.zzu.diting.entity.RightVO;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:04
 */
public interface UserRightManager {
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
    List<RightVO> getRightsByUserIDAndRightAllAndTypeAll(Long userId, Integer num1, Integer num2, Long t1, Long t2);

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
    List<RightVO> getRightsByUserIDAndRightAllAndType(Long userId, Integer num1, Integer num2, Long t1, Long t2, String auditState);

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

    List<RightVO> getRightsByUserIDAndRightAndTypeAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType);

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

    List<RightVO> getRightsByUserIDAndRightAndType(Long userId, Integer num1, Integer num2, Long t1, Long t2, String rightType, String auditState);

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
    List<RightVO> getRightByUserIDAndRightIdAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id);

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

    List<RightVO> getRightByUserIDAndRightIdType(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id, String rightType);

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
    List<RightVO> getRightByUserIDAndRightIdTypeAndAuditState(Long userId, String auditState, Integer num1, Integer num2, Long t1, Long t2, Long id);


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
    List<RightVO> getRightByUserIDAndRightIdTypeAndRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, Long id, String rightType, String auditState);

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
    List<RightVO> getRightByUserIDAndRightNameAndAll(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name);


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
    List<RightVO> getRightByUserIDAndRightNameAndAllStateOneRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String rightType);

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
    List<RightVO> getRightByUserIDAndRightNameAndOneStateAllRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String state);


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
    List<RightVO> getRightByUserIDAndRightNameAndOneStateOneRight(Long userId, Integer num1, Integer num2, Long t1, Long t2, String name, String state, String rightType);
    
}
