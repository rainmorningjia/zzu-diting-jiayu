package com.zzu.diting.service.impl;


import com.zzu.diting.dto.right.RightNameAndIdDto;
import com.zzu.diting.entity.*;
import com.zzu.diting.manager.*;
import com.zzu.diting.mapper.CopyrightUpdateInfoPOMapper;
import com.zzu.diting.mapper.OtherRightUpdateInfoPOMapper;
import com.zzu.diting.mapper.ReputationPortraitUpdateInfoPOMapper;
import com.zzu.diting.mapper.RightMapper;
import com.zzu.diting.service.UserAuthenticationService;
import com.zzu.diting.service.UserRightInfoService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRightInfoServiceImpl implements UserRightInfoService {
    @Resource
    private UserRightManager userRightManager;
    @Resource
    private UserCopyrightManager userCopyrightManager;
    @Resource
    private UserOtherRightManager userOtherRightManager;
    @Resource
    private UserReputationPortraitManager userReputationPortraitManager;
    @Resource
    private RightWorkManager rightWorkManager;
    @Resource
    private UserAuthenticationManager userAuthenticationManager;

    @Resource
    private RightMapper rightMapper;
    @Resource
    ReputationPortraitUpdateInfoPOMapper reputationPortraitUpdateInfoPOMapper;
    @Resource
    CopyrightUpdateInfoPOMapper copyrightUpdateInfoPOMapper;
    @Resource
    OtherRightUpdateInfoPOMapper otherRightUpdateInfoPOMapper;
    @Resource
    OperationService operationService;
    @Resource
    private UserAuthenticationService userAuthenticationService;

    @Override
    public Integer getTotalNumber(Long userId, Long t1, Long t2) {
        Integer total = rightMapper.queryTotalNumberByUserIDAndRightAllAndTypeAll(userId, t1, t2);
        return total;
    }

    @Override
    public Integer getRightsByUserIDAndRightAllAndTypeAll(Long userId, Long t1, Long t2) {
        Integer total = rightMapper.queryTotalNumberByUserIDAndRightAllAndTypeAll(userId, t1, t2);
        return total;
    }

    @Override
    public List<RightVO> getListRightVOAll(Long userId, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightsByUserIDAndRightAllAndTypeAll(userId, startNumber, endNumber, startTime, endTime);
        return list;
    }

    @Override
    public Integer getTotalNumberByUserIDAndRightAllAndType(Long userId, Long t1, Long t2, String auditState) {
        Integer total = rightMapper.queryTotalNumberByUserIDAndRightAllAndType(userId, t1, t2, auditState);
        return total;
    }

    @Override
    public List<RightVO> getListRightVOAllTypeAndOneState(Long userId, String state, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightsByUserIDAndRightAllAndType(userId, startNumber, endNumber, startTime, endTime, state);
        return list;
    }


    @Override
    public Integer getTotalNumberByUserIDAndRightAndTypeAll(Long userId, Long t1, Long t2, String rightType) {
        Integer total = rightMapper.queryTotalNumberByUserIDAndRightAndTypeAll(userId, t1, t2, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByUserIdAndOneRightAndOneType(Long userId, Long t1, Long t2, String auditState, String rightType) {
        Integer total = rightMapper.queryTotalNumberByUserIDAndRightAndType(userId, t1, t2, rightType, auditState);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightNameAndAllStateAndAllRightType(Long userId, String rightName, Long startTime, Long endTime) {
        Integer total = rightMapper.getTotalNumberByUserIDAndRightNameAndAll(userId, startTime, endTime, rightName);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightNameAndAllStateAndOneType(Long userId, String rightName, String rightType, Long startTime, Long endTime) {
        Integer total = rightMapper.getTotalNumberByUserIDAndRightNameAndAllStateOneRight(userId, startTime, endTime, rightName, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightNameAndOneStateAndAllType(Long userId, String rightName, String rightState, Long startTime, Long endTime) {
        Integer total = rightMapper.getTotalNumberByUserIDAndRightNameAndOneStateAllRight(userId, startTime, endTime, rightName, rightState);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightNameAndOneStateAndOneType(Long userId, String rightName, String rightType, String rightState, Long startTime, Long endTime) {
        Integer total = rightMapper.getTotalNumberByUserIDAndRightNameAndOneStateOneRight(userId, startTime, endTime, rightName, rightState, rightType);
        return total;
    }

    @Override
    public List<RightVO> getListRightVOOneTypeAndAllState(Long userId, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightsByUserIDAndRightAndTypeAll(userId, startNumber, endNumber, startTime, endTime, rightType);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOOneTypeAndOneState(Long userId, String rightType, String state, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightsByUserIDAndRightAndType(userId, startNumber, endNumber, startTime, endTime, rightType, state);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightIdByAllTypeAndAllState(Long userId, Long rightId, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightIdAll(userId, startNumber, endNumber, startTime, endTime, rightId);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightIdByAllTypeAndState(Long userId, Long rightId, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightIdTypeAndAuditState(userId, rightState, startNumber, endNumber, startTime, endTime, rightId);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightIdByTypeAndAllState(Long userId, Long rightId, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightIdType(userId, startNumber, endNumber, startTime, endTime, rightId, rightType);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightIdByTypeAndState(Long userId, Long rightId, String rightType, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightIdTypeAndRight(userId, startNumber, endNumber, startTime, endTime, rightId, rightType, rightState);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightNameAndAllStateAndAllRightType(Long userId, String rightName, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightNameAndAll(userId, startNumber, endNumber, startTime, endTime, rightName);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightNameAndAllStateAndOneType(Long userId, String rightName, String rightType, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightNameAndAllStateOneRight(userId, startNumber, endNumber, startTime, endTime, rightName, rightType);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightNameAndOneStateAndAllType(Long userId, String rightName, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightNameAndOneStateAllRight(userId, startNumber, endNumber, startTime, endTime, rightName, rightState);
        return list;
    }

    @Override
    public List<RightVO> getListRightVOByRightNameAndOneStateAndOneType(Long userId, String rightName, String rightType, String rightState, Integer startNumber, Integer endNumber, Long startTime, Long endTime) {
        List<RightVO> list = userRightManager.getRightByUserIDAndRightNameAndOneStateOneRight(userId, startNumber, endNumber, startTime, endTime, rightName, rightState, rightType);
        return list;
    }

    @Override
    public OtherRightInfoPO getOtherRightInfoByRightId(Long id) {

        OtherRightInfoPO otherRightInfoPO = userOtherRightManager.getUserOtherRightInfoById(id);
        return otherRightInfoPO;
    }

    @Override
    public CopyrightInfoPO getCopyrightInfoByRightId(Long id) {
        CopyrightInfoPO copyrightInfoPO = userCopyrightManager.getCopyrightInfoPO(id);
        return copyrightInfoPO;
    }

    @Override
    public ReputationPortraitInfoPO getReputationPortraitInfoByRightId(Long id) {
        ReputationPortraitInfoPO reputationPortraitInfoPO = userReputationPortraitManager.getUserReputationPortraitInfoById(id);
        return reputationPortraitInfoPO;
    }

    @Override
    public String getReasonForFail(Long rightId) {
        RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
        rightWorkInfoPO.setRightId(rightId);
        rightWorkInfoPO.setAuditState("驳回");
        RightWorkInfoPO rightWorkInfoPO1 = rightWorkManager.getRightWork(rightWorkInfoPO);
        return rightWorkInfoPO1.getReason();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addCopyrightInfo(CopyrightInfoPO copyrightInfoPO) {
        try {
            copyrightInfoPO.setCreateTime(System.currentTimeMillis());
            copyrightInfoPO.setUpdateTime(System.currentTimeMillis());
            copyrightInfoPO.setAuditState("审核中");
            userCopyrightManager.addUserCopyright(copyrightInfoPO);
            //添加著作权的同时生成权利工单
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            rightWorkInfoPO.setRightId(copyrightInfoPO.getId());
            rightWorkInfoPO.setUserId(copyrightInfoPO.getUserId());
            rightWorkInfoPO.setJobType("首次认证");
            rightWorkInfoPO.setRightName(copyrightInfoPO.getWorksName());
            rightWorkInfoPO.setRightType("著作权");
            //等待调出passport服务中用户的信息
            rightWorkInfoPO.setRightPerson("待处理");
            rightWorkInfoPO.setWorksType(copyrightInfoPO.getWorksType());
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(copyrightInfoPO.getUserId());
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p == null) {
                rightWorkInfoPO.setUserType("机构/组织");
            } else {
                rightWorkInfoPO.setUserType("个人");
            }
            rightWorkInfoPO.setAuditState("处理中");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            rightWorkInfoPO.setProcessingRecord(date + "生成工单");
            rightWorkInfoPO.setIsDistribution(new Byte("0"));
            rightWorkInfoPO.setIsTransmit(new Byte("0"));
            rightWorkInfoPO.setCreateTime(System.currentTimeMillis());
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkManager.addRightWorkInfo(rightWorkInfoPO);
            operationService.addOperator("添加", "用户添加著作权信息", rightWorkInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());

            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO) {
        try {
            reputationPortraitInfoPO.setAuditStatus("审核中");
            reputationPortraitInfoPO.setCreateTime(System.currentTimeMillis());
            reputationPortraitInfoPO.setUpdateTime(System.currentTimeMillis());
            userReputationPortraitManager.addUserReputationPortraitInfo(reputationPortraitInfoPO);
            //添加肖像权的同时生成权利工单
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            rightWorkInfoPO.setRightId(reputationPortraitInfoPO.getId());
            rightWorkInfoPO.setUserId(reputationPortraitInfoPO.getUserId());
            rightWorkInfoPO.setJobType("首次认证");
            rightWorkInfoPO.setRightName(reputationPortraitInfoPO.getCopyrightName());
            rightWorkInfoPO.setRightType(reputationPortraitInfoPO.getCopyrightType());
            //等待调出passport服务中用户的信息
            rightWorkInfoPO.setRightPerson("待处理");
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(reputationPortraitInfoPO.getUserId());
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p == null) {
                rightWorkInfoPO.setUserType("机构/组织");
            } else {
                rightWorkInfoPO.setUserType("个人");
            }
            rightWorkInfoPO.setAuditState("处理中");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            rightWorkInfoPO.setProcessingRecord(date + "生成工单");
            rightWorkInfoPO.setIsDistribution(new Byte("0"));
            rightWorkInfoPO.setIsTransmit(new Byte("0"));
            rightWorkInfoPO.setCreateTime(System.currentTimeMillis());
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkManager.addRightWorkInfo(rightWorkInfoPO);
            operationService.addOperator("添加", "用户添加名誉权/肖像权信息", rightWorkInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addOtherRightInfo(OtherRightInfoPO otherRightInfoPO) {
        try {
            otherRightInfoPO.setAuditStatus("审核中");
            otherRightInfoPO.setCreateTime(System.currentTimeMillis());
            otherRightInfoPO.setUpdateTime(System.currentTimeMillis());
            userOtherRightManager.addUserOtherRightInfo(otherRightInfoPO);
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            rightWorkInfoPO.setRightId(otherRightInfoPO.getId());
            rightWorkInfoPO.setUserId(otherRightInfoPO.getUserId());
            rightWorkInfoPO.setJobType("首次认证");
            rightWorkInfoPO.setRightName(otherRightInfoPO.getCopyrightName());
            rightWorkInfoPO.setRightType(otherRightInfoPO.getCopyrightType());
            //等待调出passport服务中用户的信息
            rightWorkInfoPO.setRightPerson("待处理");
            PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
            personalAuthenticationInfoPO.setUserId(otherRightInfoPO.getUserId());
            PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
            if (p == null) {
                rightWorkInfoPO.setUserType("机构/组织");
            } else {
                rightWorkInfoPO.setUserType("个人");
            }
            rightWorkInfoPO.setAuditState("处理中");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            rightWorkInfoPO.setProcessingRecord(date + "生成工单");
            rightWorkInfoPO.setIsDistribution(new Byte("0"));
            rightWorkInfoPO.setIsTransmit(new Byte("0"));
            rightWorkInfoPO.setCreateTime(System.currentTimeMillis());
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkManager.addRightWorkInfo(rightWorkInfoPO);
            operationService.addOperator("添加", "用户添加其他权利信息", rightWorkInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO) {
        userOtherRightManager.addUserOtherRightUpdateInfo(otherRightUpdateInfoPO);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        userCopyrightManager.addCopyrightUpdateInfo(copyrightUpdateInfoPO);

        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO) {
        userReputationPortraitManager.addUserReputationPortraitUpdateInfo(reputationPortraitUpdateInfoPO);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateCopyrightInfoResubmit(CopyrightInfoPO copyrightInfoPO) {
        //第一次审核过程中修改权利信息 这次没有用到权利更新表1
        copyrightInfoPO.setUpdateTime(System.currentTimeMillis());
        copyrightInfoPO.setAuditState("审核中");
        userCopyrightManager.updateUserCopyright(copyrightInfoPO);
       addRightWork(copyrightInfoPO);

        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateReputationPortraitInfoResubmit(ReputationPortraitInfoPO reputationPortraitInfoPO) {

        reputationPortraitInfoPO.setAuditStatus("审核中");
        reputationPortraitInfoPO.setUpdateTime(System.currentTimeMillis());
        userReputationPortraitManager.updateUserReputationPortraitInfo(reputationPortraitInfoPO);
     addRightWork(reputationPortraitInfoPO);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateOtherRightResubmit(OtherRightInfoPO otherRightInfoPO) {
        otherRightInfoPO.setAuditStatus("审核中");
        otherRightInfoPO.setUpdateTime(System.currentTimeMillis());
        userOtherRightManager.updateUserOtherRightInfo(otherRightInfoPO);
        addRightWork(otherRightInfoPO);
        return "success";
    }

    public void addRightWork(Object object) {
        RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
        PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
        if (object instanceof OtherRightInfoPO) {
            OtherRightInfoPO otherRightInfoPO = (OtherRightInfoPO) object;
            rightWorkInfoPO.setRightId(otherRightInfoPO.getId());
            rightWorkInfoPO.setUserId(otherRightInfoPO.getUserId());
            rightWorkInfoPO.setRightName(otherRightInfoPO.getCopyrightName());
            rightWorkInfoPO.setRightPerson(userAuthenticationService.getUserNameAuthenticationByUserId(otherRightInfoPO.getUserId()));
            personalAuthenticationInfoPO.setUserId(otherRightInfoPO.getUserId());
            rightWorkInfoPO.setRightType("其他权利");
        } else if (object instanceof CopyrightInfoPO) {
            CopyrightInfoPO copyrightInfoPO = (CopyrightInfoPO) object;
            rightWorkInfoPO.setRightId(copyrightInfoPO.getId());
            rightWorkInfoPO.setUserId(copyrightInfoPO.getUserId());
            rightWorkInfoPO.setRightType("著作权");
            rightWorkInfoPO.setWorksType(copyrightInfoPO.getWorksType());
            rightWorkInfoPO.setRightName(copyrightInfoPO.getWorksName());
            rightWorkInfoPO.setRightPerson(userAuthenticationService.getUserNameAuthenticationByUserId(copyrightInfoPO.getUserId()));
            personalAuthenticationInfoPO.setUserId(copyrightInfoPO.getUserId());
        } else if (object instanceof ReputationPortraitInfoPO) {
            ReputationPortraitInfoPO reputationPortraitInfoPO = (ReputationPortraitInfoPO) object;
            rightWorkInfoPO.setRightId(reputationPortraitInfoPO.getId());
            rightWorkInfoPO.setUserId(reputationPortraitInfoPO.getUserId());
            rightWorkInfoPO.setRightType("名誉权/肖像权");
            rightWorkInfoPO.setRightName(reputationPortraitInfoPO.getCopyrightName());
            rightWorkInfoPO.setRightId(reputationPortraitInfoPO.getId());
            rightWorkInfoPO.setRightPerson(userAuthenticationService.getUserNameAuthenticationByUserId(reputationPortraitInfoPO.getUserId()));
            personalAuthenticationInfoPO.setUserId(reputationPortraitInfoPO.getUserId());
        }

        rightWorkInfoPO.setJobType("信息修改");
        PersonalAuthenticationInfoPO p = userAuthenticationManager.queryPersonAuthenticationInfo(personalAuthenticationInfoPO);
        if (p == null) {
            rightWorkInfoPO.setUserType("机构/组织");
        } else {
            rightWorkInfoPO.setUserType("个人");
        }
        rightWorkInfoPO.setAuditState("处理中");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        rightWorkInfoPO.setProcessingRecord(date + "生成工单");
        rightWorkInfoPO.setIsDistribution(new Byte("0"));
        rightWorkInfoPO.setIsTransmit(new Byte("0"));

        rightWorkInfoPO.setCreateTime(System.currentTimeMillis());
        rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
        rightWorkManager.addRightWorkInfo(rightWorkInfoPO);
    }

    @Override
    public List<RightNameAndIdDto> getRightNameAndIdDto(String rightType, String name) {
        List<RightNameAndIdDto> nameAndIds = new ArrayList<>();
        if ("著作权".equals(rightType)) {
            List<CopyrightInfoPO> list = userCopyrightManager.getCopyRightInfoOfNameAndId(name);
            for (CopyrightInfoPO c :
                    list) {
                RightNameAndIdDto rightNameAndIdDto = new RightNameAndIdDto(c.getWorksName(), c.getId());
                nameAndIds.add(rightNameAndIdDto);
            }
        }
        if ("名誉权/肖像权".equals(rightType)) {
            List<ReputationPortraitInfoPO> list = userReputationPortraitManager.queryReputationPortraitInfoOfNameAndId(name);
            for (ReputationPortraitInfoPO r :
                    list) {
                RightNameAndIdDto rightNameAndIdDto = new RightNameAndIdDto(r.getCopyrightName(), r.getId());
                nameAndIds.add(rightNameAndIdDto);
            }
        }
        if ("其他权利".equals(rightType)) {
            List<OtherRightInfoPO> list = userOtherRightManager.getOtherRightOfNameAndId(name);
            for (OtherRightInfoPO o :
                    list) {
                RightNameAndIdDto rightNameAndIdDto = new RightNameAndIdDto(o.getCopyrightName(), o.getId());
                nameAndIds.add(rightNameAndIdDto);
            }
        }
        return nameAndIds;
    }

    @Override
    public void updateCopyrightInfo(CopyrightInfoPO copyrightInfoPO) {
        userCopyrightManager.updateUserCopyright(copyrightInfoPO);
    }

    @Override
    public void updateOtherRightInfo(OtherRightInfoPO otherRightInfoPO) {
        userOtherRightManager.updateUserOtherRightInfo(otherRightInfoPO);
    }

    @Override
    public void updateReputationPortraitInfo(ReputationPortraitInfoPO reputationPortraitInfoPO) {
        userReputationPortraitManager.updateUserReputationPortraitInfo(reputationPortraitInfoPO);
    }

    @Override
    public void updateReputationPortraitUpdateInfo(ReputationPortraitUpdateInfoPO reputationPortraitUpdateInfoPO) {
        reputationPortraitUpdateInfoPOMapper.updateByPrimaryKeySelective(reputationPortraitUpdateInfoPO);
    }

    @Override
    public void updateCopyrightUpdateInfo(CopyrightUpdateInfoPO copyrightUpdateInfoPO) {
        copyrightUpdateInfoPOMapper.updateByPrimaryKeySelective(copyrightUpdateInfoPO);
    }

    @Override
    public void updateOtherRightUpdateInfo(OtherRightUpdateInfoPO otherRightUpdateInfoPO) {
        otherRightUpdateInfoPOMapper.updateByPrimaryKeySelective(otherRightUpdateInfoPO);

    }
}
