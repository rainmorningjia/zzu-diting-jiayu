package com.zzu.diting.service;

import com.zzu.diting.dto.right.RightNameAndIdDto;
import com.zzu.diting.entity.*;

import java.util.List;

/**
 * @author wb-jcy525678
 */
public interface UserRightInfoService {
    Integer getTotalNumber(Long userId, Long t1, Long t2);

    Integer getRightsByUserIDAndRightAllAndTypeAll(Long userId, Long t1, Long t2);

    Integer getTotalNumberByUserIDAndRightAllAndType(Long userId, Long t1, Long t2, String auditState);

    Integer getTotalNumberByUserIDAndRightAndTypeAll(Long userId, Long t1, Long t2, String rightType);

    Integer getTotalNumberByUserIdAndOneRightAndOneType(Long userId, Long t1, Long t2, String auditState, String rightType);

    Integer getTotalNumberByRightNameAndAllStateAndAllRightType(Long userId, String rightName, Long startTime, Long endTime);

    Integer getTotalNumberByRightNameAndAllStateAndOneType(Long userId, String rightName, String rightType, Long startTime, Long endTime);

    Integer getTotalNumberByRightNameAndOneStateAndAllType(Long userId, String rightName, String rightState, Long startTime, Long endTime);

    Integer getTotalNumberByRightNameAndOneStateAndOneType(Long userId, String rightName, String rightType, String rightState, Long startTime, Long endTime);

    List<RightVO> getListRightVOAll(Long userId, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOAllTypeAndOneState(Long userId, String state, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOOneTypeAndAllState(Long userId, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOOneTypeAndOneState(Long userId, String rightType, String state, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightIdByAllTypeAndAllState(Long userId, Long rightId, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightIdByAllTypeAndState(Long userId, Long rightId, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightIdByTypeAndAllState(Long userId, Long rightId, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightIdByTypeAndState(Long userId, Long rightId, String rightType, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightNameAndAllStateAndAllRightType(Long userId, String rightName, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightNameAndAllStateAndOneType(Long userId, String rightName, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightNameAndOneStateAndAllType(Long userId, String rightName, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    List<RightVO> getListRightVOByRightNameAndOneStateAndOneType(Long userId, String rightName, String rightType, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime);

    OtherRightInfoPO getOtherRightInfoByRightId(Long id);

    CopyrightInfoPO getCopyrightInfoByRightId(Long id);

    ReputationPortraitInfoPO getReputationPortraitInfoByRightId(Long id);

    String getReasonForFail(Long rightId);

    String addCopyrightInfo(CopyrightInfoPO copyrightInfoPO);

    String addReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO);

    String addOtherRightInfo(OtherRightInfoPO otherRightInfoPO);

    String addOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO);

    String addCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);

    String addReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO);

    String updateCopyrightInfoResubmit(CopyrightInfoPO copyrightInfoPO);

    String updateReputationPortraitInfoResubmit(ReputationPortraitInfoPO reputationPortraitInfoPO);

    String updateOtherRightResubmit(OtherRightInfoPO otherRightInfoPO);

    void updateCopyrightInfo(CopyrightInfoPO copyrightInfoPO);

    void updateOtherRightInfo(OtherRightInfoPO otherRightInfoPO);

    void updateReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO);

    void updateReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO);

    void updateCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO);

    void updateOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO);

    List<RightNameAndIdDto> getRightNameAndIdDto(String rightType, String name);
}
