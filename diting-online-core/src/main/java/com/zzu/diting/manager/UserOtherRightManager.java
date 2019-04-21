package com.zzu.diting.manager;

import com.zzu.diting.entity.OtherRightInfoPO;
import com.zzu.diting.entity.OtherRightUpdateInfoPO;

import java.util.List;

/**
 * @author wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:05
 */
public interface UserOtherRightManager {

    OtherRightInfoPO getUserOtherRightInfoById(Long oId);

    OtherRightInfoPO getUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO);

    void addUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO);

    void updateUserOtherRightInfo(OtherRightInfoPO otherRightInfoPO);

    void deleteUserOtherRightInfoById(Long oId);

    void getUserOtherRightUpdateInfoById(Long oId);

    void getUserOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO);

    void addUserOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO);

    void deleteUserOtherRightUpdateInfoById(Long oId);
    int getNumberByUserId(Long useId);
    int getAllNumber();

    List<OtherRightInfoPO> getListOtherRightInfoAll(Integer num1, Integer num2, String time, String sort);

    List<OtherRightInfoPO> getListOtherRightInfoByUserId(Long userId, Integer num1, Integer num2, String time, String sort);

    List<OtherRightInfoPO> getListOtherRightInfoByRightName(String rightName, Integer num1, Integer num2, String time, String sort);

    List<OtherRightInfoPO> getListOtherRightInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort);

    List<OtherRightInfoPO> getOtherRightOfNameAndId(String name);
}
