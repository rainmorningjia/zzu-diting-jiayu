package com.zzu.diting.service.impl;


import com.zzu.diting.dto.HandleRecord;
import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.TransmitLisQueryParam;
import com.zzu.diting.dto.complaintwork.*;
import com.zzu.diting.dto.rightwork.RightType;
import com.zzu.diting.entity.*;
import com.zzu.diting.mapper.CopyrightInfoMapper;
import com.zzu.diting.mapper.OtherRightInfoMapper;
import com.zzu.diting.mapper.ReputationPortraintInfoMapper;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.mappers.ComplaintWorkMapper;
import com.zzu.diting.mappers.ComplaintsInfoMapper;
import com.zzu.diting.mappers.ComplaintsWorkAllInfoMapper;
import com.zzu.diting.mappers.ComplaintsWorkByManagerIdMapper;
import com.zzu.diting.service.ComplaintsWorkService;
import com.zzu.diting.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @date : 2019/5/7 17:35
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ComplaintsWorkServiceImpl implements ComplaintsWorkService {

    @Resource
    private ComplaintsWorkByManagerIdMapper complaintsWorkByManagerIdMapper;
    @Resource
    private ComplaintsWorkAllInfoMapper complaintsWorkAllInfoMapper;
    @Resource
    private ComplaintWorkMapper complaintWorkMapper;

    @Resource
    private UserComplaintInfoMapper userComplaintInfoMapper;
    @Resource
    private ComplaintsInfoMapper complaintsInfoMapper;
    @Resource
    private OtherRightInfoMapper otherRightInfoMapper;
    @Resource
    CopyrightInfoMapper copyrightInfoMapper;
    @Resource
    ReputationPortraintInfoMapper reputationPortraintInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public ComplaintsWorkTableInfoDto getComplaintsWorkTableInfo(ComplaintsWorkQueryParam complaintsWorkQueryParam) {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        String timeType = "gmt_create";
        ComplaintsWorkTableInfoDto complaintsWorkTableInfoDto = new ComplaintsWorkTableInfoDto();
        List<ComplaintsWorkTableDto> complaintsWorkTableDtos = new ArrayList<>();
        List<ComplaintsWorkInfoPO> complaintsWorkInfoPOS = new ArrayList<>();
        Integer totalNumber = 0;
        if (complaintsWorkQueryParam.getTimeType() != null) {
            if (complaintsWorkQueryParam.getTimeType() == num2) {
                timeType = "gmt_modified";
            }
        } else {
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("缺少排序类型");
            return complaintsWorkTableInfoDto;
        }
        String sortType = "desc";
        if (complaintsWorkQueryParam.getSortType() != null) {
            if (complaintsWorkQueryParam.getTimeType() == num2) {
                sortType = "asc";
            }
        } else {
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("缺少排序方式");
            return complaintsWorkTableInfoDto;
        }

        if (complaintsWorkQueryParam.getSearchType() == null && complaintsWorkQueryParam.getTableType() == null) {
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("缺少检索类型");
            return complaintsWorkTableInfoDto;
        }
        String mId = "0";
        if (complaintsWorkQueryParam.getManagerId() != null) {
            mId = complaintsWorkQueryParam.getManagerId();
        }
        Integer node;
        String nodes = "";
        if (complaintsWorkQueryParam.getNode() == null) {
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("缺少处理状态");
            return complaintsWorkTableInfoDto;
        } else {
            node = complaintsWorkQueryParam.getNode();
            if (node == num2) {
                nodes = "版权管理组审核";
            }
            if (node == num3) {
                nodes = "版权处理组审核";
            }
        }
        Integer startNumber;
        Integer endNumber;
        if (complaintsWorkQueryParam.getPageNumber() != null && complaintsWorkQueryParam.getRowNumber() != null) {
            startNumber = (complaintsWorkQueryParam.getPageNumber() - 1) * complaintsWorkQueryParam.getRowNumber();
            endNumber = complaintsWorkQueryParam.getPageNumber() * complaintsWorkQueryParam.getRowNumber();
        } else {
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("缺少行页数");
            return complaintsWorkTableInfoDto;
        }
        if (complaintsWorkQueryParam.getTableType() == num3) {
            if (complaintsWorkQueryParam.getProcessState() == null) {
                complaintsWorkTableInfoDto.setCode(1);
                complaintsWorkTableInfoDto.setMessage("缺少处理进度");
                return complaintsWorkTableInfoDto;
            }
        }
        String complaintType = RightType.Copyright.getDesc();
        if (complaintsWorkQueryParam.getComplaintType() == num1) {
            complaintType = RightType.Copyright.getDesc();
        }
        if (complaintsWorkQueryParam.getComplaintType() == num2) {
            complaintType = RightType.ReputationRight.getDesc();
        }
        if (complaintsWorkQueryParam.getComplaintType() == num3) {
            complaintType = RightType.OtherRight.getDesc();
        }

        Integer searchType = complaintsWorkQueryParam.getSearchType();
        Integer tableType = complaintsWorkQueryParam.getTableType();
        try {
            switch (tableType) {
                case 1:
                    switch (searchType) {
                        case 1:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndManagerIdAndType(complaintType, mId);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndManagerIdAndType(complaintType, mId, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndManagerIdAndType(complaintType, mId, nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndManagerIdAndType(complaintType, mId, nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndManagerIdAndType(complaintType, mId, nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndManagerIdAndType(complaintType, mId, nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
                            switch (node) {
                                case 1:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                case 2:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setNode(nodes);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                case 3:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setNode(nodes);
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() == 1) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()));
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()));
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println(complaintsWorkQueryParam);
                            switch (node) {
                                case 1:

                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndPendingAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (searchType) {
                        case 1:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndManagerIdAndType(complaintType, mId);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndManagerIdAndType(complaintType, mId, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndManagerIdAndType(complaintType, mId, nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndManagerIdAndType(complaintType, mId, nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndManagerIdAndType(complaintType, mId, nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndManagerIdAndType(complaintType, mId, nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
                            switch (node) {
                                case 1:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                case 2:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setNode(nodes);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                case 3:
                                    complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                    complaintsWorkInfoPO.setNode(nodes);
                                    complaintsWorkInfoPO.setHandlePersonId(mId);
                                    complaintsWorkInfoPO.setComplaintType(complaintType);
                                    complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                    if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() == 1) {
                                        complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                        totalNumber = 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()));
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndWorkIdsAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()));
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndCommentIdAndManagerIdAndType(complaintType, mId, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndComplaintPersonAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndRelationTypeAndManagerIdAndType(complaintType, mId, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (node) {
                                case 1:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByAllNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                    break;
                                case 2:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                    break;
                                case 3:
                                    totalNumber = complaintsWorkByManagerIdMapper.queryTotalNumberForWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                    complaintsWorkInfoPOS = complaintsWorkByManagerIdMapper.queryWorksByOneNodeAndProcessedAndTimeTypeAndManagerIdAndType(complaintType, mId, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
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
                    Integer processeState = complaintsWorkQueryParam.getProcessState();
                    switch (searchType) {
                        case 1:
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndType(complaintType);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndType(complaintType, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndType(complaintType);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndType(complaintType, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndType(complaintType);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndType(complaintType, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndType(complaintType, nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.totalNumberForComplaintsWorkAllByOneNodeAndPendingAndType(complaintType, nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.totalNumberForComplaintsWorkAllByOneNodeAndProcessedAndType(complaintType, nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndType(complaintType, "版权处理审核组");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.totalNumberForComplaintsWorkAllByOneNodeAndPendingAndType(complaintType, nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.totalNumberForComplaintsWorkAllByOneNodeAndProcessedAndType(complaintType, nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndType(complaintType, nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 2:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 3:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() == 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode(nodes);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 2:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode(nodes);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 3:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode(nodes);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() == 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode("版权处理审核组");
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 2:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode(nodes);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() < 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
                                            break;
                                        case 3:
                                            complaintsWorkInfoPO.setId(complaintsWorkQueryParam.getId());
                                            complaintsWorkInfoPO.setComplaintType(complaintType);
                                            complaintsWorkInfoPO.setNode(nodes);
                                            complaintsWorkInfoPO = complaintsWorkByManagerIdMapper.selectOne(complaintsWorkInfoPO);
                                            if (complaintsWorkInfoPO != null && complaintsWorkInfoPO.getProcessing() == 1) {
                                                complaintsWorkInfoPOS.add(complaintsWorkInfoPO);
                                                totalNumber = 1;
                                            }
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
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndWorkIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndWorkIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndWorkIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndWorkIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), "版权处理审核组");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndWorksIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:

                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()));
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), "版权处理审核组");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndCommentIdsAndType(complaintType, SplitUtil.splitSting(complaintsWorkQueryParam.getCommentIds()), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), "版权处理审核组");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndComplaintPersonAndType(complaintType, complaintsWorkQueryParam.getComplaintPerson(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), "版权处理组审核");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndRelationRightAndType(complaintType, complaintsWorkQueryParam.getRightName(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 7:
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), "版权处理组审核");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_create", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 8:
                            switch (node) {
                                case 1:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllAndAllNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime());
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByAllNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (processeState) {
                                        case 1:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), "版权处理组审核");
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndAllProcessingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 2:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndPendingAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
                                            break;
                                        case 3:
                                            totalNumber = complaintsWorkAllInfoMapper.queryTotalNumberForComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes);
                                            complaintsWorkInfoPOS = complaintsWorkAllInfoMapper.queryComplaintsWorkAllByOneNodeAndProcessedAndTimeAndType(complaintType, "gmt_modified", DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintsWorkQueryParam.getEndTime()).getTime(), nodes, startNumber, endNumber, timeType, sortType);
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
                    break;
                default:
                    break;
            }
            if (complaintsWorkInfoPOS != null) {
                System.out.println(complaintsWorkInfoPOS);
                DataObjectTransDto.populateList(complaintsWorkInfoPOS, complaintsWorkTableDtos, ComplaintsWorkTableDto.class);
                complaintsWorkTableInfoDto.setCode(0);
                complaintsWorkTableInfoDto.setMessage("查询消息成功");
                complaintsWorkTableInfoDto.setTotal(totalNumber);
                complaintsWorkTableInfoDto.setRows(complaintsWorkTableDtos);
                return complaintsWorkTableInfoDto;
            } else {
                complaintsWorkTableInfoDto.setCode(1);
                complaintsWorkTableInfoDto.setMessage("没有数据");
                complaintsWorkTableInfoDto.setTotal(0);
                return complaintsWorkTableInfoDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            complaintsWorkTableInfoDto.setCode(1);
            complaintsWorkTableInfoDto.setMessage("SYSTEM_EXCEPTION");
            return complaintsWorkTableInfoDto;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ComplaintsWorkTableDto> setProcessing(List<ComplaintsWorkTableDto> complaintsWorkTableInfoDtos) {
        try {
            if (complaintsWorkTableInfoDtos != null) {
                for (ComplaintsWorkTableDto complaintsWorkTableDto : complaintsWorkTableInfoDtos) {
                    String node = "版权处理组审核";
                    if (complaintsWorkTableDto.getNode().equals(node)) {
                        complaintsWorkTableDto.setProcessing(complaintsWorkTableDto.getProcessingTwo());
                        complaintsWorkTableDto.setHandlePersonHandle(complaintsWorkTableDto.getHandlePersonHandle());
                    }
                }
            }
            return complaintsWorkTableInfoDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public ComplaintsWorkInfoPO getComplaintsWorkInfoById(Long id) {
        ComplaintsWorkInfoPO complaintsWorkInfoPO;
        try {
            complaintsWorkInfoPO = complaintsWorkAllInfoMapper.selectByPrimaryKey(id);
            return complaintsWorkInfoPO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ComplaintsWrokDetailFormDto getComplaintsWorkDetailInfo(ComplaintWorkQueryParam complaintWorkQueryParam) {
        ComplaintsWrokDetailFormDto complaintsWrokDetailFormDto = new ComplaintsWrokDetailFormDto();
        ComplaintsWorkDetailDto complaintsWorkDetailDto = new ComplaintsWorkDetailDto();
        try {
            ComplaintsWorkInfoPO complaintsWorkInfoPO = getComplaintsWorkInfoById(complaintWorkQueryParam.getId());

            if (complaintsWorkInfoPO != null) {
                String node = "版权管理组审核";
                if (complaintsWorkInfoPO.getNode().equals(node)) {
                    complaintsWorkDetailDto.setAuditState(complaintsWorkInfoPO.getProcessing());
                    complaintsWorkDetailDto.setHandlePerson(complaintsWorkInfoPO.getHandlePerson());
                } else {
                    complaintsWorkDetailDto.setAuditState(complaintsWorkInfoPO.getProcessingTwo());
                    complaintsWorkDetailDto.setHandlePerson(complaintsWorkInfoPO.getHandlePersonHandle());
                }
                List<HandleRecord> list = SplitUtil.splitHandle(complaintsWorkInfoPO.getHandleRecord());
                complaintsWorkDetailDto.setHandleRecords(list);
                List<ComplaintWorkTableDto> complaintWorkTableDtos = new ArrayList<>();
                List<ComplaintWorkInfoPO> complaintWorkInfoPOS = new ArrayList<>();
                int num2 = 2;
                int num3 = 3;
                int num4 = 4;
                int num5 = 5;
                String timeType = "gmt_create";
                Integer totalNumber = 0;
                String sortType = "desc";
                Integer startNumber;
                Integer endNumber;
                String nodeState = "";
                if (complaintWorkQueryParam.getProcessState() != null) {
                    if (complaintWorkQueryParam.getProcessState() == num2) {
                        nodeState = "处理中";
                    }
                    if (complaintWorkQueryParam.getProcessState() == num3) {
                        nodeState = "通过";
                    }
                    if (complaintWorkQueryParam.getProcessState() == num4) {
                        nodeState = "驳回";
                    }
                    if (complaintWorkQueryParam.getProcessState() == num5) {
                        nodeState = "关闭";
                    }
                } else {
                    complaintsWrokDetailFormDto.setCode(1);
                    complaintsWrokDetailFormDto.setMessage("缺少节点状态");
                    return complaintsWrokDetailFormDto;
                }
                if (complaintWorkQueryParam.getSearchType() == null) {
                    complaintsWrokDetailFormDto.setCode(1);
                    complaintsWrokDetailFormDto.setMessage("缺少检索类型");
                    return complaintsWrokDetailFormDto;
                }
                String nodes = "audit_state_one";
                if (complaintWorkQueryParam.getNode() != null) {
                    if (complaintWorkQueryParam.getNode() == num2) {
                        nodes = "audit_state_two";
                    }
                } else {
                    complaintsWrokDetailFormDto.setCode(1);
                    complaintsWrokDetailFormDto.setMessage("缺少审核节点");
                    return complaintsWrokDetailFormDto;
                }
                Long worksId;
                if (complaintWorkQueryParam.getId() != null) {
                    worksId = complaintWorkQueryParam.getId();
                } else {
                    complaintsWrokDetailFormDto.setCode(1);
                    complaintsWrokDetailFormDto.setMessage("缺少工单集id数据");
                    return complaintsWrokDetailFormDto;
                }
                Integer searchType = complaintWorkQueryParam.getSearchType();
                if (complaintWorkQueryParam.getPageNumber() != null && complaintWorkQueryParam.getRowNumber() != null) {
                    startNumber = (complaintWorkQueryParam.getPageNumber() - 1) * complaintWorkQueryParam.getRowNumber();
                    endNumber = complaintWorkQueryParam.getPageNumber() * complaintWorkQueryParam.getRowNumber();
                } else {
                    complaintsWrokDetailFormDto.setCode(1);
                    complaintsWrokDetailFormDto.setMessage("缺少行页数");
                    return complaintsWrokDetailFormDto;
                }
                switch (searchType) {
                    case 1:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessing(complaintWorkQueryParam.getId(), startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessing(complaintWorkQueryParam.getId());
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndListId(SplitUtil.splitSting(complaintWorkQueryParam.getIds()), worksId, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndListId(SplitUtil.splitSting(complaintWorkQueryParam.getIds()), worksId);
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListId(SplitUtil.splitSting(complaintWorkQueryParam.getIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListId(SplitUtil.splitSting(complaintWorkQueryParam.getIds()), worksId, nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessing(worksId, nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndListCompalintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndListCompalintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId);
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListComplaintIds(SplitUtil.splitSting(complaintWorkQueryParam.getComplaintIds()), worksId, nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 4:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId);
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndComplaintUrl(complaintWorkQueryParam.getComplaintUrl(), worksId, nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 5:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId);
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndListCommentIds(SplitUtil.splitSting(complaintWorkQueryParam.getCommentIds()), worksId, nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 6:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime());
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_create", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 7:
                        switch (complaintWorkQueryParam.getProcessState()) {
                            case 1:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndAllProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndAllProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime());
                                break;
                            case 2:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 3:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 4:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            case 5:
                                complaintWorkInfoPOS = complaintWorkMapper.queryWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes, startNumber, endNumber, timeType, sortType);
                                totalNumber = complaintWorkMapper.queryTotalNumberWorksByWorksIdAndOneProcessingAndTime("gmt_modified", worksId, DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(complaintWorkQueryParam.getEndTime()).getTime(), nodeState, nodes);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                System.out.println(complaintWorkInfoPOS);
                DataObjectTransDto.populateList(complaintWorkInfoPOS, complaintWorkTableDtos, ComplaintWorkTableDto.class);
                System.out.println(complaintWorkTableDtos);
                complaintsWrokDetailFormDto.setCode(0);
                complaintsWrokDetailFormDto.setMessage("查询消息成功");
                complaintsWorkDetailDto.setRows(complaintWorkTableDtos);
                complaintsWorkDetailDto.setTotal(totalNumber);
                complaintsWrokDetailFormDto.setComplaintsWorkDetailDto(complaintsWorkDetailDto);
                return complaintsWrokDetailFormDto;
            } else {
                complaintsWrokDetailFormDto.setCode(1);
                complaintsWrokDetailFormDto.setMessage("没有该工单集信息");
                return complaintsWrokDetailFormDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            complaintsWrokDetailFormDto.setCode(1);
            complaintsWrokDetailFormDto.setMessage("SYSTEM_EXCEPTION");
            return complaintsWrokDetailFormDto;
        }
    }


    @Override
    public AuditNodeListInfoDto getAuditNodeInfo(Long workId) {
        AuditNodeListInfoDto auditNodeListInfoDto = new AuditNodeListInfoDto();
        try {
            AuditNodeInfoDto auditNodeInfoDto1 = new AuditNodeInfoDto();
            AuditNodeInfoDto auditNodeInfoDto2 = new AuditNodeInfoDto();
            ComplaintWorkInfoPO complaintWorkInfoPO;
            complaintWorkInfoPO = complaintWorkMapper.selectByPrimaryKey(workId);
            ComplaintsWorkInfoPO complaintsWorkInfoPO = complaintsWorkAllInfoMapper.selectByPrimaryKey(complaintWorkInfoPO.getComplaintsWorkId());
            List<AuditNodeInfoDto> list = new ArrayList<>();
            auditNodeInfoDto1.setCode(1);
            auditNodeInfoDto1.setAuditState(complaintWorkInfoPO.getAuditStateOne());
            auditNodeInfoDto1.setHandlePerson(complaintsWorkInfoPO.getHandlePerson());
            String state = "驳回";
            String state2 = "通过";
            String state3 = "关闭";
            if (complaintWorkInfoPO.getAuditStateOne().equals(state)) {
                if (complaintWorkInfoPO.getRejectTypeOne() != null) {
                    String other = "其他";
                    if (complaintWorkInfoPO.getRejectTypeOne().equals(other)) {
                        auditNodeInfoDto1.setSuggestion(complaintWorkInfoPO.getReasonOne());
                    } else {
                        auditNodeInfoDto1.setSuggestion(complaintWorkInfoPO.getRejectTypeOne());
                    }
                }
            } else if (complaintWorkInfoPO.getAuditStateOne().equals(state2)) {
                auditNodeInfoDto1.setSuggestion(complaintWorkInfoPO.getHandleRank());
                if (complaintWorkInfoPO.getExplanation() != null) {
                    auditNodeInfoDto1.setSuggestion(complaintWorkInfoPO.getHandleRank() + "补充" + complaintWorkInfoPO.getExplanation());
                }
            } else if (complaintWorkInfoPO.getAuditStateOne().equals(state3)) {
                auditNodeInfoDto1.setSuggestion("用户撤回");
            }
            if (complaintWorkInfoPO.getCompleteTime1() != null) {
                auditNodeInfoDto1.setCompleteTime(DataTransformUtil.dateTransformString(complaintWorkInfoPO.getCompleteTime1()));
            }
            String node = "版权处理组审核";
            if (complaintsWorkInfoPO.getNode().equals(node)) {
                auditNodeInfoDto2.setAuditState(complaintWorkInfoPO.getAuditStateTwo());
                auditNodeInfoDto2.setHandlePerson(complaintsWorkInfoPO.getHandlePersonHandle());
                if (complaintWorkInfoPO.getAuditStateTwo().equals(state)) {
                    if (complaintWorkInfoPO.getRejectTypeTwo() != null) {
                        String other = "其他";
                        if (complaintWorkInfoPO.getRejectTypeTwo().equals(other)) {
                            auditNodeInfoDto2.setSuggestion(complaintWorkInfoPO.getReasonTwo());
                        } else {
                            auditNodeInfoDto2.setSuggestion(complaintWorkInfoPO.getRejectTypeTwo());
                        }
                    }
                } else if (complaintWorkInfoPO.getAuditStateTwo().equals(state2)) {
                    auditNodeInfoDto2.setSuggestion(complaintWorkInfoPO.getHandleMode());
                    if (complaintWorkInfoPO.getSpecificInformation() != null) {
                        auditNodeInfoDto2.setSuggestion(complaintWorkInfoPO.getHandleMode() + "补充" + complaintWorkInfoPO.getSpecificInformation());
                    }
                } else if (complaintWorkInfoPO.getAuditStateTwo().equals(state3)) {
                    auditNodeInfoDto2.setSuggestion("用户撤回");
                }
            }
            if (complaintWorkInfoPO.getCompleteTime2() != null) {
                auditNodeInfoDto2.setCompleteTime(DataTransformUtil.dateTransformString(complaintWorkInfoPO.getCompleteTime2()));
            }
            list.add(auditNodeInfoDto1);
            list.add(auditNodeInfoDto2);
            auditNodeListInfoDto.setCode(0);
            auditNodeListInfoDto.setMessage("查询信息成功");
            auditNodeListInfoDto.setList(list);
            return auditNodeListInfoDto;
        } catch (Exception e) {
            e.printStackTrace();
            auditNodeListInfoDto.setCode(1);
            auditNodeListInfoDto.setMessage("SYSTEM_EXCEPTION");
            return auditNodeListInfoDto;
        }


    }

    @Override
    public MessageDto transmitComplaintsWork(TransmitLisQueryParam transmitLisQueryParam) {
        MessageDto messageDto = new MessageDto();
        try {
            Integer totalNumberA = transmitLisQueryParam.getAuditors().size();
            List<List<Long>> lists = AverageList.averageAssign(transmitLisQueryParam.getIds(), totalNumberA);
            for (int i = 0; i < lists.size(); i++) {
                for (Long id :
                        lists.get(i)) {
                    ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
                    complaintsWorkInfoPO.setUpdateTime(System.currentTimeMillis());
                    List<String> string = SplitNameAndId.getNameAndIdNoID(transmitLisQueryParam.getAuditors().get(i));
                    if (transmitLisQueryParam.getNode() == 1) {
                        complaintsWorkInfoPO.setHandlePersonId(string.get(1));
                        complaintsWorkInfoPO.setHandlePerson(string.get(0));
                    } else {
                        complaintsWorkInfoPO.setHandlePersonHandleId(string.get(1));
                        complaintsWorkInfoPO.setHandlePersonHandle(string.get(0));
                    }
                    ComplaintsWorkInfoPO complaintsWorkInfoPOOld = complaintsWorkAllInfoMapper.selectByPrimaryKey(id);
                    String oldHandleRecord = complaintsWorkInfoPOOld.getHandleRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = oldHandleRecord + ";" + date + "管理员操作，转交给" + " " + string.get(0) + " " + string.get(1);
                    complaintsWorkInfoPO.setHandlePerson(newHandleRecord);
                    complaintsWorkInfoPO.setId(id);
                    complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(complaintsWorkInfoPO);
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
    public MessageDto adoptComplaintWork(AdoptComplaintWorkQueryParam adoptWorkQueryParam) {
        MessageDto messageDto = new MessageDto();
        try {
            for (Long id :
                    adoptWorkQueryParam.getWorkIds()) {
                ComplaintWorkInfoPO oldComplaintWorkInfoPO = complaintWorkMapper.selectByPrimaryKey(id);
                ComplaintsWorkInfoPO oldComplaintsWorkInfoPO = complaintsWorkAllInfoMapper.selectByPrimaryKey(oldComplaintWorkInfoPO.getComplaintsWorkId());
                Integer complaintNumber = oldComplaintsWorkInfoPO.getComplaintNumber();
                Integer processedNumber = oldComplaintsWorkInfoPO.getProcessedNumber();
                ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
                complaintWorkInfoPO.setUpdateTime(System.currentTimeMillis());
                complaintWorkInfoPO.setId(id);
                ComplaintsWorkInfoPO newComplaintsWork = new ComplaintsWorkInfoPO();
                newComplaintsWork.setId(oldComplaintsWorkInfoPO.getId());
                UserComplaintInfoPO userComplaintInfoDto = new UserComplaintInfoPO();
                userComplaintInfoDto.setId(oldComplaintWorkInfoPO.getComplaintId());
                userComplaintInfoDto.setUpdateTime(System.currentTimeMillis());
                if (adoptWorkQueryParam.getNode() == 1) {
                    complaintWorkInfoPO.setAuditStateOne("通过");
                    complaintWorkInfoPO.setHandleRank(adoptWorkQueryParam.getHandleRank());
                    if (adoptWorkQueryParam.getExplanation() != null) {
                        complaintWorkInfoPO.setExplanation(adoptWorkQueryParam.getExplanation());
                    }
                    if (processedNumber != null) {
                        processedNumber++;
                        if (processedNumber.equals(complaintNumber)) {
                            newComplaintsWork.setProcessedNumber(processedNumber);
                            newComplaintsWork.setCompleteTime(new Timestamp(System.currentTimeMillis()));
                            newComplaintsWork.setProcessing(new Double(1));
                        }else {
                            float num = (float)processedNumber / oldComplaintsWorkInfoPO.getComplaintNumber();
                            DecimalFormat df = new DecimalFormat("0.0000");
                            Double dd = new Double(df.format(num));
                            newComplaintsWork.setProcessing(dd);
                        }
                    } else {
                        newComplaintsWork.setProcessedNumber(1);
                        if (complaintNumber == 1) {
                            newComplaintsWork.setCompleteTime(new Timestamp(System.currentTimeMillis()));
                            newComplaintsWork.setProcessing(new Double(1));
                        }else {
                            float num = (float)1 / oldComplaintsWorkInfoPO.getComplaintNumber();
                            DecimalFormat df = new DecimalFormat("0.0000");
                            Double dd = new Double(df.format(num));
                            newComplaintsWork.setProcessing(dd);
                        }
                    }
                    complaintWorkInfoPO.setCompleteTime1(new Timestamp(System.currentTimeMillis()));
                    userComplaintInfoDto.setProcessState("处理完成");
                } else {
                    complaintWorkInfoPO.setAuditStateTwo("通过");
                    complaintWorkInfoPO.setHandleMode(adoptWorkQueryParam.getHandleRank());
                    if (adoptWorkQueryParam.getExplanation() != null) {
                        complaintWorkInfoPO.setSpecificInformation(adoptWorkQueryParam.getExplanation());
                    }
                    complaintWorkInfoPO.setCompleteTime2(new Timestamp(System.currentTimeMillis()));
                    userComplaintInfoDto.setProcessState("处理完成");
                }
                complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(newComplaintsWork);
                userComplaintInfoMapper.updateByPrimaryKeySelective(userComplaintInfoDto);
                complaintWorkMapper.updateByPrimaryKeySelective(complaintWorkInfoPO);
            }
            messageDto.setCode(0);
            messageDto.setMessage("通过成功");
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }

    @Override
    public MessageDto rejectManagementNodeWork(RejectComplaintWorkQueryParam rejectComplaintWorkQueryParam) {
        MessageDto messageDto = new MessageDto();
        System.out.println(rejectComplaintWorkQueryParam);
        try {
            for (Long id :
                    rejectComplaintWorkQueryParam.getIds()) {
                ComplaintWorkInfoPO oldComplaintWorkInfoPO = complaintWorkMapper.selectByPrimaryKey(id);
                ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
                ComplaintsWorkInfoPO oldComplaintsWorkInfoPO = complaintsWorkAllInfoMapper.selectByPrimaryKey(oldComplaintWorkInfoPO.getComplaintsWorkId());
                Integer complaintNumber = oldComplaintsWorkInfoPO.getComplaintNumber();
                Integer processedNumber = oldComplaintsWorkInfoPO.getProcessedNumber();
                ComplaintsWorkInfoPO newComplaintsWork = new ComplaintsWorkInfoPO();
                newComplaintsWork.setId(oldComplaintsWorkInfoPO.getId());
                complaintWorkInfoPO.setUpdateTime(System.currentTimeMillis());
                complaintWorkInfoPO.setId(id);
                UserComplaintInfoPO userComplaintInfoDto = new UserComplaintInfoPO();
                userComplaintInfoDto.setId(oldComplaintWorkInfoPO.getComplaintId());
                userComplaintInfoDto.setProcessState("投诉驳回");
                userComplaintInfoDto.setUpdateTime(System.currentTimeMillis());
                if (rejectComplaintWorkQueryParam.getNode() == 1) {
                    if (processedNumber != null) {
                        processedNumber++;
                        if (processedNumber.equals(complaintNumber)) {
                            newComplaintsWork.setProcessedNumber(processedNumber);
                            newComplaintsWork.setCompleteTime(new Timestamp(System.currentTimeMillis()));
                            newComplaintsWork.setProcessing(new Double(1));
                        }else {
                            float num = (float)processedNumber / oldComplaintsWorkInfoPO.getComplaintNumber();
                            DecimalFormat df = new DecimalFormat("0.0000");
                            Double dd = new Double(df.format(num));
                            newComplaintsWork.setProcessing(dd);
                        }
                    } else {
                        newComplaintsWork.setProcessedNumber(1);
                        if (complaintNumber == 1) {
                            newComplaintsWork.setCompleteTime(new Timestamp(System.currentTimeMillis()));
                            newComplaintsWork.setProcessing(new Double(1));
                        }else {
                            float num = (float)1 / oldComplaintsWorkInfoPO.getComplaintNumber();
                            DecimalFormat df = new DecimalFormat("0.0000");
                            Double dd = new Double(df.format(num));
                            newComplaintsWork.setProcessing(dd);
                        }
                    }

                    complaintWorkInfoPO.setCompleteTime1(new Timestamp(System.currentTimeMillis()));
                    complaintWorkInfoPO.setAuditStateOne("驳回");
                    complaintWorkInfoPO.setRejectTypeOne(rejectComplaintWorkQueryParam.getFailType());
                    userComplaintInfoDto.setReason(rejectComplaintWorkQueryParam.getFailType());
                    if (rejectComplaintWorkQueryParam.getReason() != null) {
                        complaintWorkInfoPO.setReasonOne(rejectComplaintWorkQueryParam.getReason());
                        userComplaintInfoDto.setReason(rejectComplaintWorkQueryParam.getFailType());
                    }
                } else {
                    complaintWorkInfoPO.setCompleteTime2(new Timestamp(System.currentTimeMillis()));
                    complaintWorkInfoPO.setAuditStateTwo("驳回");
                    complaintWorkInfoPO.setRejectTypeTwo(rejectComplaintWorkQueryParam.getFailType());
                    userComplaintInfoDto.setReason(rejectComplaintWorkQueryParam.getFailType());
                    if (rejectComplaintWorkQueryParam.getReason() != null) {
                        userComplaintInfoDto.setReason(rejectComplaintWorkQueryParam.getFailType());
                        complaintWorkInfoPO.setReasonTwo(rejectComplaintWorkQueryParam.getReason());
                    }
                }
                complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(newComplaintsWork);
                userComplaintInfoMapper.updateByPrimaryKeySelective(userComplaintInfoDto);
                complaintWorkMapper.updateByPrimaryKeySelective(complaintWorkInfoPO);
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
    public ComplaintInfoFormDto getComplaintInfoByComplaintsWorkId(Long id) {
        ComplaintInfoFormDto complaintInfoFormDto = new ComplaintInfoFormDto();
        ComplaintAndRightInfoDto complaintAndRightInfoDto = new ComplaintAndRightInfoDto();
        try {
            ComplaintsWorkInfoPO complaintsWorkInfoPO = complaintsWorkAllInfoMapper.selectByPrimaryKey(id);
            Long complaintsId = complaintsWorkInfoPO.getComplaintsId();
            ComplaintsInfo complaintsInfo = complaintsInfoMapper.selectByPrimaryKey(complaintsId);
            Long rightId = complaintsInfo.getRightId();
            ComplaintWorkInfoPO complaintWorkInfoPO = new ComplaintWorkInfoPO();
            complaintWorkInfoPO.setComplaintsWorkId(id);
            List<ComplaintWorkInfoPO> list = complaintWorkMapper.select(complaintWorkInfoPO);
            Long userComplaintId = list.get(0).getComplaintId();
            UserComplaintInfoPO userComplaintInfoPO = userComplaintInfoMapper.selectByPrimaryKey(userComplaintId);
            complaintAndRightInfoDto.setComplaintPlatform(userComplaintInfoPO.getComplaintPlatform());
            complaintAndRightInfoDto.setComplaintId(complaintsId);
            complaintAndRightInfoDto.setRightType(complaintsWorkInfoPO.getComplaintType());
            if (complaintsWorkInfoPO.getComplaintType().equals(RightType.Copyright.getDesc())) {
                CopyrightInfoPO copyrightInfoDto = copyrightInfoMapper.selectByPrimaryKey(rightId);
                complaintAndRightInfoDto.setRightName(copyrightInfoDto.getWorksName());
                complaintAndRightInfoDto.setDirectorInfo(copyrightInfoDto.getDirectorInfo());
                complaintAndRightInfoDto.setPerformerMainInfo(copyrightInfoDto.getPerformerMainInfo());
                complaintAndRightInfoDto.setWorksNumber(copyrightInfoDto.getWorksNumber());
                complaintAndRightInfoDto.setConsultUrl(copyrightInfoDto.getConsultUrl());
            }
            if (complaintsWorkInfoPO.getComplaintType().equals(RightType.ReputationRight.getDesc())) {
                ReputationPortraitInfoPO reputationPortraitInfoDto = reputationPortraintInfoMapper.selectByPrimaryKey(rightId);
                complaintAndRightInfoDto.setRightName(reputationPortraitInfoDto.getCopyrightName());
                complaintAndRightInfoDto.setProofMaterialUrl(reputationPortraitInfoDto.getProofMaterialUrl());
            }
            if (complaintsWorkInfoPO.getComplaintType().equals(RightType.OtherRight.getDesc())) {
                OtherRightInfoPO otherRightInfoDto = otherRightInfoMapper.selectByPrimaryKey(rightId);
                complaintAndRightInfoDto.setRightName(otherRightInfoDto.getCopyrightName());
                complaintAndRightInfoDto.setIntellctualPropertyCertificatesUrl(otherRightInfoDto.getIntellctualPropertyCertificatesUrl());
            }
            complaintInfoFormDto.setCode(0);
            complaintInfoFormDto.setMessage("查询信息成功");
            complaintInfoFormDto.setComplaintAndRightInfoDto(complaintAndRightInfoDto);
            return complaintInfoFormDto;
        } catch (Exception e) {
            complaintInfoFormDto.setCode(1);
            complaintInfoFormDto.setMessage("SYSTEM_EXCEPTION");
            return complaintInfoFormDto;
        }
    }
}
