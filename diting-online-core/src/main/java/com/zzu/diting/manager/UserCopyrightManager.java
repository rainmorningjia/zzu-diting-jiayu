package com.zzu.diting.manager;

import com.zzu.diting.entity.CopyrightInfoPO;
import com.zzu.diting.entity.CopyrightUpdateInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:04
 */
public interface UserCopyrightManager {


    void addUserCopyright(CopyrightInfoPO copyrightInfoPO);
    void updateUserCopyright(CopyrightInfoPO copyrightInfoPO);
    CopyrightInfoPO getCopyrightInfoPO(Long cId);
    void deleteCopyrightInfoPO(Long cId);
    int queryCopyrightInfoNumberByUserId(Long userId);
    List<CopyrightInfoPO> getCopyrightInfoListByUserId(Long userId, Integer num1, Integer num2, String time, String sort);
    List<CopyrightInfoPO> queryCopyrightInfoList(Integer num1, Integer num2);
    List<CopyrightInfoPO> queryCopyrightInfoAll(Integer num1, Integer num2, String time, String sort);
    List<CopyrightInfoPO> queryCopyrightInfoByCopyrightName(String copyrightName, Integer num1, Integer num2, String time, String sort);
    List<CopyrightInfoPO> queryCopyrightInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort);
    CopyrightUpdateInfoPO getCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);
    void addCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);
    void deleteCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);
    int getAllNumber();
    List<CopyrightInfoPO> getCopyRightInfoOfNameAndId(String name);
    void updateCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);

}
