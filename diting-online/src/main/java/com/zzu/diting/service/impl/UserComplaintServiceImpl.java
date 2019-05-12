package com.zzu.diting.service.impl;


import com.zzu.diting.dto.complaint.UrlTotalNumberDto;
import com.zzu.diting.dto.complaint.UserComplaintNumberDto;
import com.zzu.diting.entity.ComplaintWorkInfoPO;
import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import com.zzu.diting.entity.UserComplaintInfoPO;
import com.zzu.diting.manager.ComplaintWorkManager;
import com.zzu.diting.manager.UserComplaintManager;
import com.zzu.diting.mappers.ComplaintsWorkAllInfoMapper;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.service.UserAuthenticationService;
import com.zzu.diting.service.UserComplaintService;
import com.zzu.diting.util.SplitNameAndId;
import com.zzu.diting.util.UrlUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserComplaintServiceImpl implements UserComplaintService {
    @Resource
    UserComplaintManager userComplaintManager;
    @Resource
    ComplaintWorkManager complaintWorkManager;
    @Resource
    ComplaintsWorkAllInfoMapper complaintsWorkAllInfoMapper;
    @Resource
    UserAuthenticationService userAuthenticationService;
    @Resource
    OperationService operationService;
    @Resource
    UserComplaintInfoMapper userComplaintInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserComplaintNumberDto addComplaintInfo(UserComplaintInfoPO userComplaintInfoPO) {
        UserComplaintNumberDto userComplaintNumberDto = new UserComplaintNumberDto();
        UrlTotalNumberDto urlTotalNumberDto = new UrlTotalNumberDto();
        try {

            //添加投诉信息的同时生成投诉工单集
            ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
            complaintsWorkInfoPO.setComplaintPersonId(userComplaintInfoPO.getUserId());
            complaintsWorkInfoPO.setInfoSource("外部");
            complaintsWorkInfoPO.setComplaintType(userComplaintInfoPO.getCopyrightType());
            complaintsWorkInfoPO.setComplaintPerson(userAuthenticationService.getUserNameAuthenticationByUserId(userComplaintInfoPO.getUserId()));
            complaintsWorkInfoPO.setRelationRight(userComplaintInfoPO.getRightName());
            complaintsWorkInfoPO.setNode("版权管理组审核");
            complaintsWorkInfoPO.setProcessing(0.00);
            complaintsWorkInfoPO.setIsDistribution(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            complaintsWorkInfoPO.setHandleRecord(date + " " + "生成工单集" + " 系统" + " 0");
            complaintsWorkInfoPO.setCreateTime(System.currentTimeMillis());
            complaintsWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            List<String> list = UrlUtil.splitUrl(userComplaintInfoPO.getComplaintsUrl());
            complaintsWorkInfoPO.setComplaintNumber(list.size());
            complaintsWorkAllInfoMapper.insert(complaintsWorkInfoPO);
            operationService.addOperator("添加", "系统生成投诉工单集", new Long("0"), "系统");
            int successTotalNumber = list.size();
            int existNumber = 0;
            //之后生成工单信息与每条投诉信息
            for (String url : list) {
                UserComplaintInfoPO userComplaintInfoPOUrl = new UserComplaintInfoPO();
                userComplaintInfoPOUrl.setComplaintsUrl(url);
                userComplaintInfoPOUrl.setUserId(userComplaintInfoPO.getUserId());
                UserComplaintInfoPO userComplaintInfoPOUrlT1 = userComplaintInfoMapper.selectOne(userComplaintInfoPOUrl);
                if (userComplaintInfoPOUrlT1 != null) {
                    successTotalNumber--;
                    existNumber++;
                } else {
                    UserComplaintInfoPO userComplaintInfoPO1 = new UserComplaintInfoPO();
                    userComplaintInfoPO1.setUserId(userComplaintInfoPO.getUserId());
                    userComplaintInfoPO1.setRelationRightId(userComplaintInfoPO.getRelationRightId());
                    userComplaintInfoPO1.setComplaintPlatform(userComplaintInfoPO.getComplaintPlatform());
                    userComplaintInfoPO1.setCopyrightType(userComplaintInfoPO.getCopyrightType());
                    userComplaintInfoPO1.setComplaintsUrl(url);
                    userComplaintInfoPO1.setProcessState("处理中");
                    userComplaintInfoPO1.setCreateTime(System.currentTimeMillis());
                    userComplaintInfoPO1.setUpdateTime(System.currentTimeMillis());
                    userComplaintInfoPO1.setRightName(userComplaintInfoPO.getRightName());
                    userComplaintInfoPO1.setRelationRightId(userComplaintInfoPO.getRelationRightId());
                    operationService.addOperator("添加", "生成用户投诉信息", userComplaintInfoPO.getUserId(), userAuthenticationService.getUserNameAuthenticationByUserId(userComplaintInfoPO.getUserId()));
                    userComplaintManager.addUserComplaint(userComplaintInfoPO1);
                    ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
                    userComplaintInfoPO1 = userComplaintManager.getUserComplaint(userComplaintInfoPO1);
                    complaintWorkInfoPO.setComplaintId(userComplaintInfoPO1.getId());
                    complaintWorkInfoPO.setComplaintsWorkId(complaintsWorkInfoPO.getId());
                    complaintWorkInfoPO.setOrderType("首次投诉");
                    complaintWorkInfoPO.setComplaintUrl(url);
//            complaintWorkInfoPO.setCommentId();
                    complaintWorkInfoPO.setAuditStateOne("处理中");
                    complaintWorkInfoPO.setInfoSource("外部");
                    complaintWorkInfoPO.setIsDistribution(new Byte("0"));
                    complaintWorkInfoPO.setCreateTime(System.currentTimeMillis());
                    complaintWorkInfoPO.setUpdateTime(System.currentTimeMillis());
                    complaintWorkManager.addComplaintWork(complaintWorkInfoPO);
                    operationService.addOperator("添加", "系统生成投诉工单", new Long("0"), "系统");
                }
                ComplaintsWorkInfoPO complaintsWorkInfoPONew = new ComplaintsWorkInfoPO();
                complaintsWorkInfoPONew.setComplaintNumber(successTotalNumber);
                complaintsWorkInfoPONew.setId(complaintsWorkInfoPO.getId());
                complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(complaintsWorkInfoPONew);

            }
            userComplaintNumberDto.setCode(0);
            userComplaintNumberDto.setMessage("添加成功");
            urlTotalNumberDto.setExistNumber(existNumber);
            urlTotalNumberDto.setSuccessNumber(successTotalNumber);
            urlTotalNumberDto.setTotalNumber(list.size());
            userComplaintNumberDto.setUrlTotalNumberDto(urlTotalNumberDto);
            return userComplaintNumberDto;
        } catch (Exception e) {
            e.printStackTrace();
            userComplaintNumberDto.setCode(1);
            userComplaintNumberDto.setMessage("系统错误");
            return userComplaintNumberDto;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addComplaintsInfo(List<UserComplaintInfoPO> complaints) {
        for (UserComplaintInfoPO complaintInfoPO :
                complaints) {
            addComplaintInfo(complaintInfoPO);
        }
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteUserComplaintById(Long id) {
        userComplaintManager.deleteUserComplaintById(id);
        return "success";
    }

    @Override
    public UserComplaintInfoPO getUserComplaint(Long id) {
        UserComplaintInfoPO complaintInfoPO = userComplaintManager.getUserComplaint(id);
        return complaintInfoPO;
    }

    @Override
    public UserComplaintInfoPO getUserComplaint(UserComplaintInfoPO userComplaintInfoPO) {
        UserComplaintInfoPO userComplaintInfoPO1 = userComplaintManager.getUserComplaint(userComplaintInfoPO);
        return userComplaintInfoPO1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateUserComplaint(UserComplaintInfoPO userComplaintInfoPO) {
        userComplaintManager.updateUserComplaint(userComplaintInfoPO);
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recallUserComplaint(Long id) {
        UserComplaintInfoPO userComplaintInfoPO = new UserComplaintInfoPO();
        userComplaintInfoPO.setId(id);
        userComplaintInfoPO.setProcessState("关闭");
        updateUserComplaint(userComplaintInfoPO);
        ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
        complaintWorkInfoPO.setComplaintId(id);
        complaintWorkInfoPO = complaintWorkManager.getComplaintWork(complaintWorkInfoPO);
        if (complaintWorkInfoPO.getAuditStateTwo() != null) {
            complaintWorkInfoPO.setAuditStateTwo("关闭");
            complaintWorkManager.updateComplaintWork(complaintWorkInfoPO);
        } else {
            complaintWorkInfoPO.setAuditStateOne("关闭");
            complaintWorkManager.updateComplaintWork(complaintWorkInfoPO);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resubmitUserCompliantInfo(UserComplaintInfoPO userComplaintInfoPO) {

        ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
        complaintsWorkInfoPO.setComplaintPersonId(userComplaintInfoPO.getUserId());
        complaintsWorkInfoPO.setInfoSource("外部");
        complaintsWorkInfoPO.setComplaintType(userComplaintInfoPO.getCopyrightType());
        complaintsWorkInfoPO.setComplaintPerson(userAuthenticationService.getUserNameAuthenticationByUserId(userComplaintInfoPO.getUserId()));
        complaintsWorkInfoPO.setRelationRight(userComplaintInfoPO.getRightName());
        complaintsWorkInfoPO.setNode("版权管理组审核");
        complaintsWorkInfoPO.setProcessing(0.00);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        complaintsWorkInfoPO.setHandleRecord(date + " " + "生成工单");
        complaintsWorkInfoPO.setCreateTime(System.currentTimeMillis());
        complaintsWorkInfoPO.setUpdateTime(System.currentTimeMillis());
        complaintsWorkInfoPO.setComplaintNumber(1);
        complaintsWorkAllInfoMapper.insert(complaintsWorkInfoPO);
        operationService.addOperator("添加", "系统生成投诉工单集", new Long("0"), "系统");

        UserComplaintInfoPO userComplaintInfoPO1 = new UserComplaintInfoPO();
        userComplaintInfoPO1.setUserId(userComplaintInfoPO.getUserId());
        userComplaintInfoPO1.setRelationRightId(userComplaintInfoPO.getRelationRightId());
        userComplaintInfoPO1.setComplaintPlatform(userComplaintInfoPO.getComplaintPlatform());
        userComplaintInfoPO1.setCopyrightType(userComplaintInfoPO.getCopyrightType());
        userComplaintInfoPO1.setRightName(userComplaintInfoPO.getRightName());
        userComplaintInfoPO1.setComplaintsUrl(userComplaintInfoPO.getComplaintsUrl());
        userComplaintInfoPO1.setProcessState("处理中");
        userComplaintInfoPO1.setCreateTime(System.currentTimeMillis());
        userComplaintInfoPO1.setUpdateTime(System.currentTimeMillis());
        userComplaintManager.addUserComplaint(userComplaintInfoPO1);
        ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
        userComplaintInfoPO1 = userComplaintManager.getUserComplaint(userComplaintInfoPO1);
        complaintWorkInfoPO.setComplaintId(userComplaintInfoPO1.getId());
        complaintWorkInfoPO.setComplaintsWorkId(complaintsWorkAllInfoMapper.selectOne(complaintsWorkInfoPO).getId());
        complaintWorkInfoPO.setOrderType("首次投诉");
        complaintWorkInfoPO.setComplaintUrl(userComplaintInfoPO.getComplaintsUrl());
//            complaintWorkInfoPO.setCommentId();
        complaintWorkInfoPO.setAuditStateOne("处理中");
        complaintWorkInfoPO.setIsDistribution(new Byte("0"));
        complaintWorkInfoPO.setCreateTime(System.currentTimeMillis());
        complaintWorkInfoPO.setUpdateTime(System.currentTimeMillis());
        complaintWorkManager.addComplaintWork(complaintWorkInfoPO);
        operationService.addOperator("添加", "系统生成投诉工单", new Long("0"), "系统");
        //覆盖原来的信息
        userComplaintInfoPO.setProcessState("处理中");
        userComplaintManager.updateUserComplaint(userComplaintInfoPO);
        operationService.addOperator("修改", "用户修改投诉信息", userComplaintInfoPO.getUserId(), (String) SecurityUtils.getSubject().getPrincipal());

    }

    @Override
    public String getReasonFailByComplaintId(Long id) {
        ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
        complaintWorkInfoPO.setComplaintId(id);
        String reason = complaintWorkManager.getComplaintWork(complaintWorkInfoPO).getReasonOne();
        return reason;
    }

    @Override
    public Integer getTotalTotalNumberByPageAndTimeAndAll(Long userId, Long t1, Long t2) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByPageAndTimeAndAll(userId, t1, t2);
        return total;
    }

    @Override
    public Integer getTotalNumberByAllRightAndState(Long userId, Long t1, Long t2, String processState) {
        Integer total = userComplaintInfoMapper.queryTotalNumberAllRightAndState(userId, t1, t2, processState);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightAndAllState(Long userId, Long t1, Long t2, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberRightAndAllState(userId, t1, t2, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightAndState(Long userId, Long t1, Long t2, String rightType, String processState) {
        Integer total = userComplaintInfoMapper.queryTotalNumberRightAndState(userId, t1, t2, rightType, processState);
        return total;
    }

    @Override
    public Integer getTotalNumberByUrlAndOneRightAndAllState(Long userId, String url, Long t1, Long t2, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByUrlAndOneRightAndAllState(userId, url, t1, t2, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByUrlAndAllRightAndAllState(Long userId, String url, Long t1, Long t2) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByUrlAndAllRightAndAllState(userId, url, t1, t2);
        return total;
    }

    @Override
    public Integer getTotalNumberByUrlAndAllRightAndOneState(Long userId, String url, Long t1, Long t2, String state) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByUrlAndAllRightAndOneState(userId, url, t1, t2, state);
        return total;
    }

    @Override
    public Integer getTotalNumberByUrlAndOneRightAndOneState(Long userId, String url, Long t1, Long t2, String state, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByUrlAndOneRightAndOneState(userId, url, t1, t2, state, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByNameAndAllRightAndAllState(Long userId, String name, Long t1, Long t2) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByNameAndAllRightAndAllState(userId, name, t1, t2);
        return total;
    }

    @Override
    public Integer getTotalNumberByNameAndOneRightAndAllState(Long useId, String name, Long t1, Long t2, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByNameAndOneRightAndAllState(useId, name, t1, t2, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByNameAndAllRightAndOneState(Long userId, String name, Long t1, Long t2, String state) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByNameAndAllRightAndOneState(userId, name, t1, t2, state);
        return total;
    }

    @Override
    public Integer getTotalNumberByNameAndOneRightAndOneState(Long userID, String name, Long t1, Long t2, String state, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByNameAndOneRightAndOneState(userID, name, t1, t2, state, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightIdAndAllRightAndAllState(Long userId, Long rightId, Long t1, Long t2) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByRightIdAndAllRightAndAllState(userId, rightId, t1, t2);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightIdAndOneRightAndAllState(Long useId, Long rightId, Long t1, Long t2, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByRightIdAndOneRightAndAllState(useId, rightId, t1, t2, rightType);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightIdAndAllRightAndOneState(Long userId, Long rightId, Long t1, Long t2, String state) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByRightIdAndAllRightAndOneState(userId, rightId, t1, t2, state);
        return total;
    }

    @Override
    public Integer getTotalNumberByRightIdAndOneRightAndOneState(Long userID, Long rightId, Long t1, Long t2, String state, String rightType) {
        Integer total = userComplaintInfoMapper.queryTotalNumberByRightIdAndOneRightAndOneState(userID, rightId, t1, t2, state, rightType);
        return total;
    }

}
