package com.zzu.diting.service.impl;

import com.zzu.diting.dto.*;
import com.zzu.diting.dto.authenticationwork.*;
import com.zzu.diting.entity.AuthenticationWorkInfoPO;
import com.zzu.diting.entity.OrganizationAuthenticationInfoPO;
import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import com.zzu.diting.manager.UserAuthenticationManager;
import com.zzu.diting.mapper.OrganizationAuthenticationInfoMapper;
import com.zzu.diting.mapper.PersonalAuthenticationInfoMapper;
import com.zzu.diting.mappers.AuthenticationWorkInfoMapper;
import com.zzu.diting.service.AuthenticationWorkService;
import com.zzu.diting.service.OperationService;
import com.zzu.diting.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @date : 2019/4/27 11:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthenticationWorkServiceImpl implements AuthenticationWorkService {
    @Resource
    private AuthenticationWorkInfoMapper authenticationWorkInfoMapper;
    @Resource
    private OperationService operationService;
    @Resource
    OrganizationAuthenticationInfoMapper organizationAuthenticationInfoMapper;
    @Resource
    PersonalAuthenticationInfoMapper personalAuthenticationInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthenticationWorkTableDto getAuthenticationWorkTable(AuthenticationWorkQueryParam authenticationWorkQueryParam) {
        System.out.println(authenticationWorkQueryParam);
        AuthenticationWorkTableDto authenticationWorkTableDto = new AuthenticationWorkTableDto();

        Integer processState = authenticationWorkQueryParam.getProcessType();

        Integer searchType = authenticationWorkQueryParam.getSearchType();

        Integer tableType = authenticationWorkQueryParam.getTableType();

        Integer totalNumber = 0;

        Integer startNumber = (authenticationWorkQueryParam.getPageNumber() - 1) * authenticationWorkQueryParam.getRowNumber();
        Integer endNumber = authenticationWorkQueryParam.getPageNumber() * authenticationWorkQueryParam.getRowNumber();
        List<AuthenticationWorkDto> list1 = new ArrayList<>();
        List<AuthenticationWorkInfoPO> list = new ArrayList<>();
        String timeType = "gmt_create";
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        if (authenticationWorkQueryParam.getTimeType() != null) {
            if (authenticationWorkQueryParam.getTimeType() == 1) {
                timeType = "gmt_create";
            } else {
                timeType = "gmt_modified";
            }
        }
        String sortType = "desc";
        if (authenticationWorkQueryParam.getSortType() != null) {
            if (authenticationWorkQueryParam.getSortType() == 1) {
                sortType = "desc";
            } else {
                sortType = "asc";
            }
        }
        String orderType = "首次认证";
        String mId = authenticationWorkQueryParam.getManagerId();
        if (authenticationWorkQueryParam.getOrderType() != null) {
            if (authenticationWorkQueryParam.getOrderType() == 1) {
                orderType = "首次认证";
            } else {
                orderType = "信息修改";
            }
        }
        String userType = "个人";
        if (authenticationWorkQueryParam.getUserType() != null) {
            if (authenticationWorkQueryParam.getUserType() == 1) {
                userType = "个人";
            } else {
                userType = "机构";
            }
        }
        try {
            switch (tableType) {
                case 1:
                    switch (searchType) {
                        case 1:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByMIdAndPendingDisposalAndState(mId, "处理中");
                            list = authenticationWorkInfoMapper.queryAllWorksByMIdAndPendingDisposalAndState(mId, "处理中", startNumber, endNumber, timeType, sortType);
                            break;
                        case 2:
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndWorkIdAndState(mId, "处理中", authenticationWorkQueryParam.getId(), startNumber, endNumber, timeType, sortType);
                            totalNumber = list.size();
                            break;
                        case 3:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "处理中", orderType);
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "处理中", orderType, startNumber, endNumber, timeType, sortType);
                            break;
                        case 4:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "处理中", authenticationWorkQueryParam.getUserId());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "处理中", authenticationWorkQueryParam.getUserId(), startNumber, endNumber, timeType, sortType);
                            break;
                        case 5:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "处理中", authenticationWorkQueryParam.getNickname());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "处理中", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                            break;
                        case 6:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "处理中", authenticationWorkQueryParam.getName());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "处理中", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                            break;
                        case 7:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "处理中", userType);
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "处理中", userType, startNumber, endNumber, timeType, sortType);
                            break;
                        case 8:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "处理中", authenticationWorkQueryParam.getHandlePerson());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "处理中", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                            break;
                        case 9:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "处理中", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "处理中", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                            break;
                        case 10:
                            totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "处理中", "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                            list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "处理中", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (searchType) {
                        case 1:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorkByMIdAndProcessedAndAllState(mId);
                                    list = authenticationWorkInfoMapper.queryWorkByMIdAndProcessedAndAllState(mId, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByMIdAndPendingDisposalAndState(mId, "通过");
                                    list = authenticationWorkInfoMapper.queryAllWorksByMIdAndPendingDisposalAndState(mId, "通过", startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByMIdAndPendingDisposalAndState(mId, "驳回");
                                    list = authenticationWorkInfoMapper.queryAllWorksByMIdAndPendingDisposalAndState(mId, "驳回", startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            switch (processState) {
                                case 1:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditorId(authenticationWorkQueryParam.getManagerId());
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                case 2:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditorId(authenticationWorkQueryParam.getManagerId());
                                    authenticationWorkInfoPO.setAuditState("通过");
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                case 3:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditorId(authenticationWorkQueryParam.getManagerId());
                                    authenticationWorkInfoPO.setAuditState("驳回");
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndOrderTypeAndAllState(mId, orderType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndOrderTypeAndAllState(mId, orderType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "通过", orderType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "通过", orderType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "驳回", orderType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndOrderTypeAndState(mId, "驳回", orderType, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorkByMIdAndProcessedAndUserIdAndAllState(mId, authenticationWorkQueryParam.getUserId());
                                    list = authenticationWorkInfoMapper.queryWorkByMIdAndProcessedAndUserIdAndAllState(mId, authenticationWorkQueryParam.getUserId(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "通过", authenticationWorkQueryParam.getUserId());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "通过", authenticationWorkQueryParam.getUserId(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "驳回", authenticationWorkQueryParam.getUserId());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserIdAndState(mId, "驳回", authenticationWorkQueryParam.getUserId(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndNicknameAndAllState(mId, authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndNicknameAndAllState(mId, authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "通过", authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "通过", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "驳回", authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndNicknameAndState(mId, "驳回", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndRealNameAndAllState(mId, authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndRealNameAndAllState(mId, authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "通过", authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "通过", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "驳回", authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndRealNameAndState(mId, "驳回", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndUserTypeAndAllState(mId, userType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndRealNameAndAllState(mId, userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "通过", userType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "通过", userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "驳回", userType);
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndUserTypeAndState(mId, "驳回", userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndHandlePersonAndAllState(mId, authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndRealNameAndAllState(mId, authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "通过", authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "通过", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "驳回", authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "驳回", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 9:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndTimeAndAllState(mId, "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndTimeAndAllState(mId, "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "通过", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "通过", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "驳回", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "驳回", "gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 10:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndProcessedAndTimeAndAllState(mId, "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndProcessedAndTimeAndAllState(mId, "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "通过", "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "通过", "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberWorksByMIdAndPendingDisposalAndTimeAndState(mId, "驳回", "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndTimeAndState(mId, "驳回", "gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (searchType) {
                        case 1:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksAndAllAuditState();
                                    list = authenticationWorkInfoMapper.queryAllWorksAndAllAuditState(startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksAndAuditState("处理中");
                                    list = authenticationWorkInfoMapper.queryAllWorksAndAuditState("处理中", searchType, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksAndAuditState("通过");
                                    list = authenticationWorkInfoMapper.queryAllWorksAndAuditState("通过", searchType, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksAndAuditState("驳回");
                                    list = authenticationWorkInfoMapper.queryAllWorksAndAuditState("驳回", searchType, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            switch (processState) {
                                case 1:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                case 2:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditState("处理中");
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                case 3:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditState("通过");
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                case 4:
                                    authenticationWorkInfoPO.setId(authenticationWorkQueryParam.getId());
                                    authenticationWorkInfoPO.setAuditState("驳回");
                                    list = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
                                    totalNumber = list.size();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByOrderTypeAndAllState(orderType);
                                    list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndAllState(orderType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "处理中");
                                    list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndState(orderType, "处理中", startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "通过");
                                    list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndState(orderType, "通过", startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "驳回");
                                    list = authenticationWorkInfoMapper.queryAllWorksByOrderTypeAndState(orderType, "驳回", startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserIdAndStateAndAllState(authenticationWorkQueryParam.getUserId());
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserIdAndStateAndAllState(authenticationWorkQueryParam.getUserId(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "处理中");
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "处理中", startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "通过");
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "通过", startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "驳回");
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserIdAndStateAndState(authenticationWorkQueryParam.getUserId(), "驳回", startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorkByNicknameAndAllState(authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndAllState(authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorkByNicknameAndState("处理中", authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndState("处理中", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorkByNicknameAndState("通过", authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndState("通过", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorkByNicknameAndState("驳回", authenticationWorkQueryParam.getNickname());
                                    list = authenticationWorkInfoMapper.queryAllWorkByNicknameAndState("驳回", authenticationWorkQueryParam.getNickname(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByRealNameAndAllState(authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndAllState(authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByRealNameAndState("处理中", authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndState("处理中", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByRealNameAndState("通过", authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndState("通过", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByRealNameAndState("驳回", authenticationWorkQueryParam.getName());
                                    list = authenticationWorkInfoMapper.queryAllWorksByRealNameAndState("驳回", authenticationWorkQueryParam.getName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserTypeAndAllState(userType);
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndAllState(userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserTypeAndState("处理中", userType);
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndState("处理中", userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserTypeAndState("通过", userType);
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndState("通过", userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByUserTypeAndState("驳回", userType);
                                    list = authenticationWorkInfoMapper.queryAllWorksByUserTypeAndState("驳回", userType, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByHandlePersonAndAllState(authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryAllWorksByHandlePersonAndAllState(authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByHandlePersonAndState("处理中", authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryAllWorksByHandlePersonAndState("处理中", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByHandlePersonAndState("通过", authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryAllWorksByHandlePersonAndState("通过", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "驳回", authenticationWorkQueryParam.getHandlePerson());
                                    list = authenticationWorkInfoMapper.queryWorksByMIdAndPendingDisposalAndHandlePersonAndState(mId, "驳回", authenticationWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 9:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndAllState("gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndAllState("gmt_create", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_create", "处理中", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_create", "处理中", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_create", "通过", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_create", "通过", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_create", "驳回", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_create", "驳回", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 10:
                            switch (processState) {
                                case 1:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndAllState("gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndAllState("gmt_modified", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_modified", "处理中", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_modified", "处理中", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_modified", "通过", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_modified", "通过", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 4:
                                    totalNumber = authenticationWorkInfoMapper.queryTotalNumberForAllWorksByTimeAndState("gmt_modified", "驳回", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime());
                                    list = authenticationWorkInfoMapper.queryAllWorksByTimeAndState("gmt_modified", "驳回", DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(authenticationWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;

                    }
                default:
                    break;

            }
            System.out.println(list);
            DataObjectTransDto.populateList(list, list1, AuthenticationWorkDto.class);
            authenticationWorkTableDto.setCode(0);
            authenticationWorkTableDto.setMessage("查询消息成功");
            authenticationWorkTableDto.setTotal(totalNumber);
            authenticationWorkTableDto.setRows(list1);
            return authenticationWorkTableDto;
        } catch (Exception e) {
            e.printStackTrace();
            DataObjectTransDto.populateList(list, list1, AuthenticationWorkDto.class);
            authenticationWorkTableDto.setTotal(0);
            authenticationWorkTableDto.setRows(null);
            authenticationWorkTableDto.setCode(1);
            authenticationWorkTableDto.setMessage("SYSTEM_EXCEPTION");
            return authenticationWorkTableDto;
        }

    }

    @Override
    public AuthenticationDetailFormDto getAuthenDetailInfoByWorkId(Long id) {
        String orderTypeOne = "首次认证";
        String userTypeOne = "个人";
        AuthenticationDetailFormDto authenticationDetailFormDto = new AuthenticationDetailFormDto();
        AuthenticationDetailDto authenticationDetailDto = new AuthenticationDetailDto();
        try {
            AuthenticationWorkInfoPO authenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(id);
            String orderType = authenticationWorkInfoPO.getOrderType();
            String userType = authenticationWorkInfoPO.getUserType();
            DataObjectTransDto.populate(authenticationWorkInfoPO, authenticationDetailDto);
            String handleRecord = authenticationWorkInfoPO.getHandleRecord();

            List<HandleRecord> list = SplitUtil.splitHandle(handleRecord);
            authenticationDetailDto.setHandleRecords(list);
            if (orderTypeOne.equals(orderType)) {
                if (userType.equals(userTypeOne)) {
                    PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                    personalAuthenticationInfoPO.setUserId(authenticationWorkInfoPO.getUserId());
                    personalAuthenticationInfoPO = personalAuthenticationInfoMapper.selectOne(personalAuthenticationInfoPO);
                    DataObjectTransDto.populate(personalAuthenticationInfoPO, authenticationDetailDto);
                } else {
                    OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                    organizationAuthenticationInfoPO.setUserId(authenticationWorkInfoPO.getUserId());
                    organizationAuthenticationInfoPO = organizationAuthenticationInfoMapper.selectOne(organizationAuthenticationInfoPO);
                    DataObjectTransDto.populate(organizationAuthenticationInfoPO, authenticationDetailDto);
                }
            }
            authenticationDetailFormDto.setCode(0);
            authenticationDetailFormDto.setMessage("查询消息成功");
            authenticationDetailFormDto.setAuthenticationDetailDto(authenticationDetailDto);
            return authenticationDetailFormDto;
        } catch (Exception e) {
            e.printStackTrace();
            authenticationDetailFormDto.setCode(1);
            authenticationDetailFormDto.setMessage("SYSTEM_EXCEPTION");
            return authenticationDetailFormDto;
        }
    }

    @Override
    public MessageDto transmitWork(TransmitQueryParam transmitDto) {
        String newAuditorId = transmitDto.getAuditorId();
        Long workId = transmitDto.getWorkId();
        MessageDto messageDto = new MessageDto();
        try {
            AuthenticationWorkInfoPO authenticationWorkInfoPO;
            authenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(workId);
            String handleRecord = authenticationWorkInfoPO.getHandleRecord();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String newHandleRecord = handleRecord + ";" + date + "管理员操作，转交给" + " " + transmitDto.getName() + " " + transmitDto.getAuditorId();
            AuthenticationWorkInfoPO newAuthenticationWorkInfoPO = new AuthenticationWorkInfoPO();
            newAuthenticationWorkInfoPO.setId(workId);
            newAuthenticationWorkInfoPO.setAuditorId(newAuditorId);
            newAuthenticationWorkInfoPO.setHandleRecord(newHandleRecord);
            newAuthenticationWorkInfoPO.setHandlePerson(transmitDto.getName());
            newAuthenticationWorkInfoPO.setIsTransmit(new Byte("1"));
            newAuthenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            authenticationWorkInfoMapper.updateByPrimaryKeySelective(newAuthenticationWorkInfoPO);
            operationService.addOperator("修改", "内部人员修改认证工单", authenticationWorkInfoPO.getAuditorId(), authenticationWorkInfoPO.getHandlePerson());
            messageDto.setCode(0);
            messageDto.setMessage("修改成功");
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }

    @Override
    public MessageDto adoptAuthenticationWorkById(Long id) {
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        MessageDto messageDto = new MessageDto();
        try {
            authenticationWorkInfoPO.setId(id);
            AuthenticationWorkInfoPO oldAuthenticationWorkInfoPO;
            oldAuthenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(id);
            String handleRecord = oldAuthenticationWorkInfoPO.getHandleRecord();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String newHandleRecord = handleRecord + ";" + date + "管理员操作，通过" + " " + oldAuthenticationWorkInfoPO.getHandlePerson() + " " + oldAuthenticationWorkInfoPO.getAuditorId();
            authenticationWorkInfoPO.setHandleRecord(newHandleRecord);
            authenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            authenticationWorkInfoPO.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            authenticationWorkInfoPO.setAuditState("通过");
            authenticationWorkInfoMapper.updateByPrimaryKeySelective(authenticationWorkInfoPO);
            String userType = "个人";
            if (oldAuthenticationWorkInfoPO.getUserType().equals(userType)) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                PersonalAuthenticationInfoPO oldPersonalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                personalAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                personalAuthenticationInfoPO.setAuthenticationResult("认证成功");
                personalAuthenticationInfoPO.setRecentlyOperator("系统");
                personalAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
                personalAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                oldPersonalAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                oldPersonalAuthenticationInfoPO = personalAuthenticationInfoMapper.selectOne(oldPersonalAuthenticationInfoPO);
                personalAuthenticationInfoPO.setId(oldPersonalAuthenticationInfoPO.getId());
                personalAuthenticationInfoMapper.updateByPrimaryKeySelective(personalAuthenticationInfoPO);
            } else {
                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                OrganizationAuthenticationInfoPO oldOrganizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                organizationAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                organizationAuthenticationInfoPO.setAuthenticationResult("认证成功");
                organizationAuthenticationInfoPO.setRecentlyOperator("系统");
                organizationAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
                organizationAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                oldOrganizationAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                oldOrganizationAuthenticationInfoPO = organizationAuthenticationInfoMapper.selectOne(oldOrganizationAuthenticationInfoPO);
                organizationAuthenticationInfoPO.setId(oldOrganizationAuthenticationInfoPO.getId());
                organizationAuthenticationInfoMapper.updateByPrimaryKeySelective(organizationAuthenticationInfoPO);
            }
            messageDto.setCode(0);
            messageDto.setMessage("通过成功");
            return messageDto;
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }

    @Override
    public MessageDto rejectWorkById(RejectInfoQueryParam rejectInfoQueryParam) {

        MessageDto messageDto = new MessageDto();
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        try {
            authenticationWorkInfoPO.setId(rejectInfoQueryParam.getId());
            authenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            authenticationWorkInfoPO.setAuditState("驳回");
            authenticationWorkInfoPO.setFailType(rejectInfoQueryParam.getFailType());
            String other = "其他";
            if (rejectInfoQueryParam.getFailType().equals(other)) {
                authenticationWorkInfoPO.setReason(rejectInfoQueryParam.getReason());
            }
            authenticationWorkInfoMapper.updateByPrimaryKeySelective(authenticationWorkInfoPO);

            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            AuthenticationWorkInfoPO oldAuthenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(rejectInfoQueryParam.getId());
            String userType = "个人";
            if (oldAuthenticationWorkInfoPO.getUserType().equals(userType)) {
                PersonalAuthenticationInfoPO personalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                PersonalAuthenticationInfoPO oldPersonalAuthenticationInfoPO = new PersonalAuthenticationInfoPO();
                personalAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                personalAuthenticationInfoPO.setFailType(rejectInfoQueryParam.getFailType());
                if (rejectInfoQueryParam.getFailType().equals(other)) {
                    personalAuthenticationInfoPO.setReason(rejectInfoQueryParam.getReason());
                }
                personalAuthenticationInfoPO.setAuthenticationResult("认证失败");
                personalAuthenticationInfoPO.setRecentlyOperator("系统");
                personalAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
                personalAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                oldPersonalAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                oldPersonalAuthenticationInfoPO = personalAuthenticationInfoMapper.selectOne(oldPersonalAuthenticationInfoPO);
                personalAuthenticationInfoPO.setId(oldPersonalAuthenticationInfoPO.getId());
                personalAuthenticationInfoMapper.updateByPrimaryKeySelective(personalAuthenticationInfoPO);
            } else {
                OrganizationAuthenticationInfoPO organizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                OrganizationAuthenticationInfoPO oldOrganizationAuthenticationInfoPO = new OrganizationAuthenticationInfoPO();
                organizationAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                organizationAuthenticationInfoPO.setFailType(rejectInfoQueryParam.getFailType());
                if (rejectInfoQueryParam.getFailType().equals(other)) {
                    organizationAuthenticationInfoPO.setReason(rejectInfoQueryParam.getReason());
                }
                organizationAuthenticationInfoPO.setAuthenticationResult("认证失败");
                organizationAuthenticationInfoPO.setRecentlyOperator("系统");
                organizationAuthenticationInfoPO.setRecentlyUpdateType("内部修改");
                organizationAuthenticationInfoPO.setUpdateTime(System.currentTimeMillis());
                oldOrganizationAuthenticationInfoPO.setUserId(oldAuthenticationWorkInfoPO.getUserId());
                oldOrganizationAuthenticationInfoPO = organizationAuthenticationInfoMapper.selectOne(oldOrganizationAuthenticationInfoPO);
                organizationAuthenticationInfoPO.setId(oldOrganizationAuthenticationInfoPO.getId());
                organizationAuthenticationInfoMapper.updateByPrimaryKeySelective(organizationAuthenticationInfoPO);
            }
            messageDto.setCode(0);
            messageDto.setMessage("驳回成功");
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }

    @Override
    public MessageDto transmitLisWork(TransmitLisQueryParam transmitLisQueryParam) {
        MessageDto messageDto = new MessageDto();
        try {
            Integer totalNumberA = transmitLisQueryParam.getAuditors().size();
            List<List<Long>> lists = AverageList.averageAssign(transmitLisQueryParam.getIds(), totalNumberA);
            for (int i = 0; i < lists.size(); i++) {
                for (Long id :
                        lists.get(i)) {
                    AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
                    authenticationWorkInfoPO.setUpdateTime(System.currentTimeMillis());
                    authenticationWorkInfoPO.setIsTransmit(new Byte("1"));
                    List<String> string = SplitNameAndId.getNameAndIdNoID(transmitLisQueryParam.getAuditors().get(i));
                    authenticationWorkInfoPO.setAuditorId(string.get(1));
                    authenticationWorkInfoPO.setHandlePerson(string.get(0));
                    AuthenticationWorkInfoPO authenticationWorkInfoPOOld;
                    authenticationWorkInfoPOOld = authenticationWorkInfoMapper.selectByPrimaryKey(id);
                    String handleRecord = authenticationWorkInfoPOOld.getHandleRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = handleRecord + ";" + date + "管理员操作，转交给" + " " + string.get(0) + " " + string.get(1);
                    authenticationWorkInfoPO.setHandleRecord(newHandleRecord);
                    authenticationWorkInfoPO.setId(id);
                    authenticationWorkInfoMapper.updateByPrimaryKeySelective(authenticationWorkInfoPO);
                }
            }
            messageDto.setMessage("转交成功");
            messageDto.setCode(0);
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;

        }
    }

    @Override
    public String getFailReasonById(Long id) {
        AuthenticationWorkInfoPO authenticationWorkInfoPO = authenticationWorkInfoMapper.selectByPrimaryKey(id);
        String reason;
        String failType = authenticationWorkInfoPO.getFailType();
        String other = "其他";
        if (other.equals(failType)) {
            reason = authenticationWorkInfoPO.getReason();
        } else {
            reason = failType;
        }
        return reason;
    }
}
