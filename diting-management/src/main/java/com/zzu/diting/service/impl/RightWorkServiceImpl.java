package com.zzu.diting.service.impl;

import com.zzu.diting.dto.HandleRecord;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.RejectInfoQueryParam;
import com.zzu.diting.dto.TransmitLisQueryParam;
import com.zzu.diting.dto.rightwork.*;
import com.zzu.diting.entity.*;
import com.zzu.diting.mapper.*;
import com.zzu.diting.mappers.RightWorkMapper;
import com.zzu.diting.service.RightWorkService;
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
 * @date : 2019/5/6 11:41
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RightWorkServiceImpl implements RightWorkService {
    @Resource
    private RightWorkMapper rightWorkMapper;
    @Resource
    private OtherRightInfoMapper otherRightInfoMapper;
    @Resource
    CopyrightInfoMapper copyrightInfoMapper;
    @Resource
    ReputationPortraintInfoMapper reputationPortraintInfoMapper;
    @Resource
    CopyrightUpdateInfoPOMapper copyrightUpdateInfoPOMapper;
    @Resource
    ReputationPortraitUpdateInfoPOMapper reputationPortraitUpdateInfoPOMapper;
    @Resource
    OtherRightUpdateInfoPOMapper otherRightUpdateInfoPOMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public RightWorkListDto getRightTable(RightWorkQueryParam rightWorkQueryParam) {
        System.out.println(rightWorkQueryParam);
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        String timeType = "gmt_create";
        RightWorkListDto rightWorkListDto = new RightWorkListDto();
        List<RightWorkTableInfoDto> rightWorkTableInfoDtos = new ArrayList<>();
        List<RightWorkInfoPO> rightWorkInfoPOS = new ArrayList<>();
        Integer totalNumber = 0;
        if (rightWorkQueryParam.getTimeType() != null) {
            if (rightWorkQueryParam.getTimeType() == num2) {
                timeType = "gmt_modified";
            }
        } else {
            rightWorkListDto.setCode(1);
            rightWorkListDto.setMessage("缺少排序类型");
            return rightWorkListDto;
        }
        String sortType = "desc";
        if (rightWorkQueryParam.getSortType() != null) {
            if (rightWorkQueryParam.getTimeType() == num2) {
                sortType = "asc";
            }
        } else {
            rightWorkListDto.setCode(1);
            rightWorkListDto.setMessage("缺少排序方式");
            return rightWorkListDto;
        }
        if (rightWorkQueryParam.getSearchType() == null && rightWorkQueryParam.getTableType() == null) {
            rightWorkListDto.setCode(1);
            rightWorkListDto.setMessage("缺少检索类型");
            return rightWorkListDto;
        }
        String mId = "0";
        if (rightWorkQueryParam.getManagerId() != null) {
            mId = rightWorkQueryParam.getManagerId();
        }
        if (rightWorkQueryParam.getTableType() != num1) {
            if (rightWorkQueryParam.getProcessType() == null) {
                rightWorkListDto.setCode(1);
                rightWorkListDto.setMessage("缺少处理状态");
                return rightWorkListDto;
            }
        }
        Integer startNumber;
        Integer endNumber;
        if (rightWorkQueryParam.getPageNumber() != null && rightWorkQueryParam.getRowNumber() != null) {
            startNumber = (rightWorkQueryParam.getPageNumber() - 1) * rightWorkQueryParam.getRowNumber();
            endNumber = rightWorkQueryParam.getPageNumber() * rightWorkQueryParam.getRowNumber();
        } else {
            rightWorkListDto.setCode(1);
            rightWorkListDto.setMessage("缺少行页数");
            return rightWorkListDto;
        }
        String orderType = "首次认证";
        if (rightWorkQueryParam.getOrderType() != null) {
            if (rightWorkQueryParam.getOrderType() == num2) {
                orderType = "信息修改";
            }
        }
        String rightType = "著作权";
        if (rightWorkQueryParam.getRightType() != null) {
            if (rightWorkQueryParam.getRightType() == num1) {
                rightType = "著作权";
            }
            if (rightWorkQueryParam.getRightType() == num2) {
                rightType = "名誉权/肖像权";
            }
            if (rightWorkQueryParam.getRightType() == num3) {
                rightType = "其他权利";
            }
        }
        Integer searchType = rightWorkQueryParam.getSearchType();
        Integer tableType = rightWorkQueryParam.getTableType();

        try {
            switch (tableType) {
                case 1:
                    switch (searchType) {
                        case 1:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndState(mId, "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndState(mId, "处理中");
                            break;
                        case 2:
                            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
                            rightWorkInfoPO.setAuditorId(mId);
                            rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                            rightWorkInfoPO.setAuditState("处理中");
                            rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                            if (rightWorkInfoPOS != null) {
                                totalNumber = rightWorkInfoPOS.size();
                            } else {
                                totalNumber = 0;
                            }
                            break;
                        case 3:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndOrderTypeAndState(mId, orderType, "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndOrderTypeAndState(mId, orderType, "处理中");
                            break;
                        case 4:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightTypeAndState(mId, rightType, "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightTypeAndState(mId, rightType, "处理中");
                            break;
                        case 5:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "处理中");
                            break;
                        case 6:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "处理中");
                            break;
                        case 7:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "处理中");
                            break;
                        case 8:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "处理中");
                            break;
                        case 9:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "处理中", startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "处理中");
                            break;
                        case 10:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                            break;
                        case 11:
                            rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                            totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (searchType) {
                        case 1:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndAllProcessed(mId, startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndAllProcessed(mId);
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndState(mId, "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndState(mId, "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndState(mId, "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndState(mId, "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndState(mId, "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndState(mId, "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
                            String processing = "处理中";
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditorId(mId);
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);

                                    if (processing.equals(rightWorkInfoPOS.get(0).getAuditState())) {
                                        rightWorkInfoPOS = null;
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = 1;
                                    }
                                    break;
                                case 2:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditorId(mId);
                                    rightWorkInfoPO.setAuditState("通过");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                case 3:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditorId(mId);
                                    rightWorkInfoPO.setAuditState("驳回");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                case 4:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditorId(mId);
                                    rightWorkInfoPO.setAuditState("关闭");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndOrderTypeAndAllProcessed(mId, orderType, startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndOrderTypeAndAllProcessed(mId, orderType);
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndOrderTypeAndState(mId, orderType, "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndOrderTypeAndState(mId, orderType, "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndOrderTypeAndState(mId, orderType, "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndOrderTypeAndState(mId, orderType, "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndOrderTypeAndState(mId, orderType, "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndOrderTypeAndState(mId, orderType, "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightTypeAndAllProcessed(mId, rightType, startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightTypeAndAllProcessed(mId, rightType);
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightTypeAndState(mId, rightType, "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightTypeAndState(mId, rightType, "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightTypeAndState(mId, rightType, "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightTypeAndState(mId, rightType, "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightTypeAndState(mId, rightType, "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightTypeAndState(mId, rightType, "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightNameAndAllProcessed(mId, rightWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightNameAndAllProcessed(mId, rightWorkQueryParam.getRightName());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightNameAndState(mId, rightWorkQueryParam.getRightName(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightIdAndAllProcessed(mId, rightWorkQueryParam.getRightId(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightIdAndAllProcessed(mId, rightWorkQueryParam.getRightId());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightIdAndState(mId, rightWorkQueryParam.getRightId(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightPersonAndAllProcessed(mId, rightWorkQueryParam.getRightPerson(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightPersonAndAllProcessed(mId, rightWorkQueryParam.getRightPerson());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndRightPersonAndState(mId, rightWorkQueryParam.getRightPerson(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndUserTypeAndAllProcessed(mId, rightWorkQueryParam.getUserType(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndUserTypeAndAllProcessed(mId, rightWorkQueryParam.getUserType());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndUserTypeAndState(mId, rightWorkQueryParam.getUserType(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 9:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndHandlePersonAndAllProcessed(mId, rightWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndHandlePersonAndAllProcessed(mId, rightWorkQueryParam.getHandlePerson());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "通过");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "驳回");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndHandlePersonAndState(mId, rightWorkQueryParam.getHandlePerson(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 10:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndAllProcessed(mId, "gmt_create", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndAllProcessed(mId, "gmt_create", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_create", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 11:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndAllProcessed(mId, "gmt_modified", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndAllProcessed(mId, "gmt_modified", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForWorksByMIdAndTimeTypeAndState(mId, "gmt_modified", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
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
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByAllState(startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByAllState();
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByState("处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByState("处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByState("通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByState("通过");
                                    break;

                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByState("驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByState("驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByState("关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByState("关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    break;
                                case 2:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditState("处理中");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                case 3:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditState("通过");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                case 4:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditState("驳回");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                case 5:
                                    rightWorkInfoPO.setId(rightWorkQueryParam.getId());
                                    rightWorkInfoPO.setAuditState("关闭");
                                    rightWorkInfoPOS = rightWorkMapper.select(rightWorkInfoPO);
                                    if (rightWorkInfoPOS == null) {
                                        totalNumber = 0;
                                    } else {
                                        totalNumber = rightWorkInfoPOS.size();
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByOrderTypeAndAllState(orderType, startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByOrderTypeAndAllState(orderType);
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByOrderTypeAndState(orderType, "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByOrderTypeAndState(orderType, "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByOrderTypeAndState(orderType, "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByOrderTypeAndState(orderType, "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByOrderTypeAndState(orderType, "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightTypeAndAllState(rightType, startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightTypeAndAllState(rightType);
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightTypeAndState(rightType, "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightTypeAndState(rightType, "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightTypeAndState(rightType, "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightTypeAndState(rightType, "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightTypeAndState(rightType, "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightTypeAndState(rightType, "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightTypeAndState(rightType, "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightTypeAndState(rightType, "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightNameAndAllState(rightWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightNameAndAllState(rightWorkQueryParam.getRightName());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightNameAndState(rightWorkQueryParam.getRightName(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightIdAndAllState(rightWorkQueryParam.getRightId(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightIdAndAllState(rightWorkQueryParam.getRightId());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightIdAndState(rightWorkQueryParam.getRightId(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightPersonAndAllState(rightWorkQueryParam.getRightPerson(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightPersonAndAllState(rightWorkQueryParam.getRightPerson());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByRightPersonAndState(rightWorkQueryParam.getRightPerson(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByUserTypeAndAllState(rightWorkQueryParam.getUserType(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByUserTypeAndAllState(rightWorkQueryParam.getUserType());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByUserTypeAndState(rightWorkQueryParam.getUserType(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 9:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByHandlePersonAndAllState(rightWorkQueryParam.getHandlePerson(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByHandlePersonAndAllState(rightWorkQueryParam.getHandlePerson());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "处理中", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "处理中");
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "通过", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "通过");
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "驳回", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "驳回");
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "关闭", startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByHandlePersonAndState(rightWorkQueryParam.getHandlePerson(), "关闭");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 10:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndAllState("gmt_create", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndAllState("gmt_create", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_create", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_create", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_create", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_create", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_create", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_create", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_create", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_create", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 11:
                            switch (rightWorkQueryParam.getProcessType()) {
                                case 1:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndAllState("gmt_modified", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndAllState("gmt_modified", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 2:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_modified", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_modified", "处理中", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 3:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_modified", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_modified", "通过", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 4:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_modified", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_modified", "驳回", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                case 5:
                                    rightWorkInfoPOS = rightWorkMapper.queryAllWorksByTimeTypeAndState("gmt_modified", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    totalNumber = rightWorkMapper.queryTotalNumberForAllWorksByTimeTypeAndState("gmt_modified", "关闭", DataTransformUtil.stringTransformDate(rightWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightWorkQueryParam.getEndTime()).getTime());
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            if (rightWorkInfoPOS != null) {
                DataObjectTransDto.populateList(rightWorkInfoPOS, rightWorkTableInfoDtos, RightWorkTableInfoDto.class);
                rightWorkListDto.setCode(0);
                rightWorkListDto.setMessage("查询消息成功");
                rightWorkListDto.setTotal(totalNumber);
                rightWorkListDto.setRows(rightWorkTableInfoDtos);
                return rightWorkListDto;
            } else {
                rightWorkListDto.setCode(1);
                rightWorkListDto.setMessage("没有数据");
                return rightWorkListDto;
            }

        } catch (Exception e) {
            e.printStackTrace();
            rightWorkListDto.setCode(1);
            rightWorkListDto.setMessage("SYSTEM_EXCEPTION");
            return rightWorkListDto;
        }
    }

    @Override
    public MessageDto transmitWorks(TransmitLisQueryParam transmitLisQueryParam) {
        MessageDto messageDto = new MessageDto();
        try {
            Integer totalNumberA = transmitLisQueryParam.getAuditors().size();
            List<List<Long>> lists = AverageList.averageAssign(transmitLisQueryParam.getIds(), totalNumberA);
            for (int i = 0; i < lists.size(); i++) {
                for (Long id :
                        lists.get(i)) {
                    List<String> string = SplitNameAndId.getNameAndIdNoID(transmitLisQueryParam.getAuditors().get(i));
                    RightWorkInfoPO rightWorkInfoPOOld = rightWorkMapper.selectByPrimaryKey(id);
                    String handleRecord = rightWorkInfoPOOld.getProcessingRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = handleRecord + ";" + date + "管理员操作，转交给" + " " + string.get(0) + " " + string.get(1);
                    RightWorkInfoPO rightWorkInfoPONew = new RightWorkInfoPO();
                    rightWorkInfoPONew.setId(id);
                    rightWorkInfoPONew.setProcessingRecord(newHandleRecord);
                    rightWorkInfoPONew.setAuditorId(string.get(1));
                    rightWorkInfoPONew.setIsTransmit(new Byte("1"));
                    rightWorkInfoPONew.setHandlePerson(string.get(0));
                    rightWorkInfoPONew.setUpdateTime(System.currentTimeMillis());
                    rightWorkMapper.updateByPrimaryKeySelective(rightWorkInfoPONew);
                }
            }
            messageDto.setCode(0);
            messageDto.setMessage("转交成功");
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setMessage("SYSTEM_EXCEPTION");
            messageDto.setCode(1);
            return messageDto;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public String getFailReasonById(Long id) {
        RightWorkInfoPO rightWorkInfoPO = rightWorkMapper.selectByPrimaryKey(id);
        String reason;
        String failType = rightWorkInfoPO.getFailType();
        String other = "其他";
        if (other.equals(failType)) {
            reason = rightWorkInfoPO.getReason();
        } else {
            reason = failType;
        }
        return reason;
    }

    @Override
    public MessageDto adoptWorkById(Long id) {
        MessageDto messageDto = new MessageDto();
        try {
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            rightWorkInfoPO.setId(id);
            rightWorkInfoPO.setAuditState("通过");
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkInfoPO.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            RightWorkInfoPO rightWorkInfoPOOld = rightWorkMapper.selectByPrimaryKey(id);
            String handleRecord = rightWorkInfoPOOld.getProcessingRecord();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String newHandleRecord = handleRecord + ";" + date + "管理员操作，通过" + " " + rightWorkInfoPOOld.getHandlePerson() + " " + rightWorkInfoPOOld.getAuditorId();
            rightWorkInfoPO.setProcessingRecord(newHandleRecord);
            rightWorkMapper.updateByPrimaryKeySelective(rightWorkInfoPO);
            if (rightWorkInfoPOOld.getRightType().equals(RightType.Copyright.getDesc())) {
                CopyrightInfoDto copyrightInfoDto = new CopyrightInfoDto();
                copyrightInfoDto.setId(rightWorkInfoPOOld.getRightId());
                copyrightInfoDto.setAuditState("审核通过");
                copyrightInfoDto.setUpdateTime(System.currentTimeMillis());
                CopyrightInfoPO copyrightInfoPO=new CopyrightInfoPO();
                DataObjectTransDto.populate(copyrightInfoDto,copyrightInfoPO);
                copyrightInfoMapper.updateByPrimaryKeySelective(copyrightInfoPO);
            }
            if (rightWorkInfoPOOld.getRightType().equals(RightType.ReputationRight.getDesc())) {
                ReputationPortraitInfoDto reputationPortraitInfoDto = new ReputationPortraitInfoDto();
                reputationPortraitInfoDto.setId(rightWorkInfoPOOld.getRightId());
                reputationPortraitInfoDto.setAuditStatus("审核通过");
                reputationPortraitInfoDto.setUpdateTime(System.currentTimeMillis());
                ReputationPortraitInfoPO reputationPortraitInfoPO=new ReputationPortraitInfoPO();
                DataObjectTransDto.populate(reputationPortraitInfoDto,reputationPortraitInfoPO);
                reputationPortraintInfoMapper.updateByPrimaryKeySelective(reputationPortraitInfoPO);
            }
            if (rightWorkInfoPOOld.getRightType().equals(RightType.OtherRight.getDesc())) {
                OtherRightInfoDto otherRightInfoDto = new OtherRightInfoDto();
                otherRightInfoDto.setId(rightWorkInfoPOOld.getRightId());
                otherRightInfoDto.setUpdateTime(System.currentTimeMillis());
                otherRightInfoDto.setAuditStatus("审核通过");
                OtherRightInfoPO otherRightInfoPO=new OtherRightInfoPO();
                DataObjectTransDto.populate(otherRightInfoDto,otherRightInfoPO);
                otherRightInfoMapper.updateByPrimaryKeySelective(otherRightInfoPO);
            }
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
    public MessageDto rejectWorkById(RejectInfoQueryParam rejectInfoQueryParam) {
        MessageDto messageDto = new MessageDto();
        try {
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkInfoPO.setAuditState("驳回");
            rightWorkInfoPO.setId(rejectInfoQueryParam.getId());
            String fail = "其他";
            RightWorkInfoPO oldRightWork = rightWorkMapper.selectByPrimaryKey(rejectInfoQueryParam.getId());
            if (fail.equals(rejectInfoQueryParam.getFailType())) {
                rightWorkInfoPO.setFailType(rejectInfoQueryParam.getFailType());
                rightWorkInfoPO.setReason(rejectInfoQueryParam.getReason());
            } else {
                rightWorkInfoPO.setFailType(rejectInfoQueryParam.getFailType());
            }
            String handleRecord = oldRightWork.getProcessingRecord();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String newHandleRecord = handleRecord + ";" + date + "管理员操作，驳回" + " " + oldRightWork.getHandlePerson() + " " + oldRightWork.getAuditorId();
            rightWorkInfoPO.setProcessingRecord(newHandleRecord);
            rightWorkMapper.updateByPrimaryKeySelective(rightWorkInfoPO);
            if (oldRightWork.getRightType().equals(RightType.Copyright.getDesc())) {
                CopyrightInfoDto copyrightInfoDto = new CopyrightInfoDto();
                copyrightInfoDto.setId(oldRightWork.getRightId());
                copyrightInfoDto.setAuditState("审核未通过");
                copyrightInfoDto.setUpdateTime(System.currentTimeMillis());
                CopyrightInfoPO copyrightInfoPO=new CopyrightInfoPO();
                DataObjectTransDto.populate(copyrightInfoDto,copyrightInfoPO);
                copyrightInfoMapper.updateByPrimaryKeySelective(copyrightInfoPO);
            }
            if (oldRightWork.getRightType().equals(RightType.ReputationRight.getDesc())) {
                ReputationPortraitInfoDto reputationPortraitInfoDto = new ReputationPortraitInfoDto();
                reputationPortraitInfoDto.setId(oldRightWork.getRightId());
                reputationPortraitInfoDto.setAuditStatus("审核未通过");
                reputationPortraitInfoDto.setUpdateTime(System.currentTimeMillis());
                ReputationPortraitInfoPO reputationPortraitInfoPO=new ReputationPortraitInfoPO();
                DataObjectTransDto.populate(reputationPortraitInfoDto,reputationPortraitInfoPO);
                reputationPortraintInfoMapper.updateByPrimaryKeySelective(reputationPortraitInfoPO);
            }
            if (oldRightWork.getRightType().equals(RightType.OtherRight.getDesc())) {
                OtherRightInfoDto otherRightInfoDto = new OtherRightInfoDto();
                otherRightInfoDto.setId(oldRightWork.getRightId());
                otherRightInfoDto.setUpdateTime(System.currentTimeMillis());
                otherRightInfoDto.setAuditStatus("审核未通过");
                OtherRightInfoPO otherRightInfoPO=new OtherRightInfoPO();
                DataObjectTransDto.populate(otherRightInfoDto,otherRightInfoPO);
                otherRightInfoMapper.updateByPrimaryKeySelective(otherRightInfoPO);
            }
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
    public RightWorkDetailFormDto getRightWorkDetailInfoById(Long id) {
        RightWorkDetailFormDto rightWorkDetailFormDto = new RightWorkDetailFormDto();
        RightWorkDetailDto rightWorkDetailDto = new RightWorkDetailDto();
        try {
            RightWorkInfoPO rightWorkInfoPO = rightWorkMapper.selectByPrimaryKey(id);
            List<HandleRecord> handleRecords = SplitUtil.splitHandle(rightWorkInfoPO.getProcessingRecord());
            rightWorkDetailDto.setHandleRecords(handleRecords);
            DataObjectTransDto.populate(rightWorkInfoPO, rightWorkDetailDto);
            String orderType = "首次认证";
            if (orderType.equals(rightWorkInfoPO.getJobType())) {
                if (rightWorkInfoPO.getRightType().equals(RightType.Copyright.getDesc())) {
                    CopyrightInfoPO copyrightInfoPO = copyrightInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(copyrightInfoPO, rightWorkDetailDto);
                }
                if (rightWorkInfoPO.getRightType().equals(RightType.ReputationRight.getDesc())) {
                    ReputationPortraitInfoPO reputationPortraitInfoDto = reputationPortraintInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(reputationPortraitInfoDto, rightWorkDetailDto);
                }
                if (rightWorkInfoPO.getRightType().equals(RightType.OtherRight.getDesc())) {
                    OtherRightInfoPO otherRightInfoDto = otherRightInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(otherRightInfoDto, rightWorkDetailDto);
                }
            } else {
                if (rightWorkInfoPO.getRightType().equals(RightType.Copyright.getDesc())) {
                    CopyrightInfoPO copyrightInfoPO = copyrightInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(copyrightInfoPO, rightWorkDetailDto);
                    CopyrightUpdateInfoPO copyrightUpdateInfoPO=new CopyrightUpdateInfoPO();
                    copyrightUpdateInfoPO.setCopyrightId(rightWorkInfoPO.getRightId());
                    CopyrightUpdateInfoPO copyrightUpdateInfoDto =copyrightUpdateInfoPOMapper .selectOne(copyrightUpdateInfoPO);
                    DataObjectTransDto.populate(copyrightUpdateInfoDto, rightWorkDetailDto);
                }
                if (rightWorkInfoPO.getRightType().equals(RightType.ReputationRight.getDesc())) {
                    ReputationPortraitInfoPO reputationPortraitInfoDto = reputationPortraintInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(reputationPortraitInfoDto, rightWorkDetailDto);
              /*      ReputationPortraitUpdateInfoDto reputationPortraitUpdateInfoDto = userRightApi.getReputationPortraitUpdateInfoByRightId(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(reputationPortraitUpdateInfoDto, rightWorkDetailDto);*/
                }
                if (rightWorkInfoPO.getRightType().equals(RightType.OtherRight.getDesc())) {
                    OtherRightInfoPO otherRightInfoDto = otherRightInfoMapper.selectByPrimaryKey(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(otherRightInfoDto, rightWorkDetailDto);
                /*    OtherRightUpdateInfoDto otherRightUpdateInfoDto = userRightApi.getOtherRightUpdateInfoByRightId(rightWorkInfoPO.getRightId());
                    DataObjectTransDto.populate(otherRightUpdateInfoDto, rightWorkDetailDto);*/
                }
            }
            rightWorkDetailFormDto.setRightWorkDetailDto(rightWorkDetailDto);
            rightWorkDetailFormDto.setCode(0);
            rightWorkDetailFormDto.setMessage("查询消息成功");
            return rightWorkDetailFormDto;
        } catch (Exception e) {
            e.printStackTrace();
            rightWorkDetailFormDto.setCode(1);
            rightWorkDetailFormDto.setMessage("SYSTEM_EXCEPTION");
            return rightWorkDetailFormDto;
        }
    }

    @Override
    public MessageDto addRightWork(RightWorkDto rightWorkDto) {
        MessageDto messageDto = new MessageDto();
        RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
        try {
            DataObjectTransDto.populate(rightWorkDto, rightWorkInfoPO);
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkInfoPO.setCreateTime(System.currentTimeMillis());
            rightWorkMapper.insert(rightWorkInfoPO);
            messageDto.setCode(0);
            messageDto.setMessage("添加成功");
            return messageDto;
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }

    @Override
    public RightWorkDto getRightWorkInfo(RightWorkDto rightWorkDto) {
        try {
            RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
            DataObjectTransDto.populate(rightWorkDto, rightWorkInfoPO);
            rightWorkInfoPO = rightWorkMapper.selectOne(rightWorkInfoPO);
            DataObjectTransDto.populate(rightWorkInfoPO, rightWorkDto);
            return rightWorkDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MessageDto updateRightWorkInfo(RightWorkDto rightWorkDto) {
        MessageDto messageDto = new MessageDto();
        RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
        try {
            DataObjectTransDto.populate(rightWorkDto, rightWorkInfoPO);
            rightWorkInfoPO.setUpdateTime(System.currentTimeMillis());
            rightWorkMapper.updateByPrimaryKeySelective(rightWorkInfoPO);
            messageDto.setCode(0);
            messageDto.setMessage("添加成功");
            return messageDto;
        } catch (Exception e) {
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }
}
