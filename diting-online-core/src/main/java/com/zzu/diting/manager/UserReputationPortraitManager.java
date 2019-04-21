package com.zzu.diting.manager;

import com.zzu.diting.entity.ReputationPortraitInfoPO;
import com.zzu.diting.entity.ReputationPortraitUpdateInfoPO;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 10:05
 */
public interface UserReputationPortraitManager {

    ReputationPortraitInfoPO getUserReputationPortraitInfoById(Long oId);

    ReputationPortraitInfoPO getUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO);

    void addUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO);

    void updateUserReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO);

    void deleteUserReputationPortraitInfoById(Long oId);

    ReputationPortraitUpdateInfoPO getUserReputationPortraitUpdateInfoById(Long oId);

    ReputationPortraitUpdateInfoPO getUserReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO);

    void addUserReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO);

    void deleteUserReputationPortraitUpdateInfoById(Long oId);

    int getAllNumber();

    int getUserReputationPortraitInfoNumberByUserId(Long userId);

    List<ReputationPortraitInfoPO> getReputationPortraitInfoByUserId(Long userId, Integer num1, Integer num2, String time, String sort);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoAll(Integer num1, Integer num2, String time, String sort);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoCopyrightName(String copyrightName, Integer num1, Integer num2, String time, String sort);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoByTime(String timeType, Long startTime, Long endTime, Integer num1, Integer num2, String time, String sort);

    List<ReputationPortraitInfoPO> queryReputationPortraitInfoOfNameAndId(String name);

}
