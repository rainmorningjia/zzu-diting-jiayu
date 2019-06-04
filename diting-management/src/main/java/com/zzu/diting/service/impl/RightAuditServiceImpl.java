package com.zzu.diting.service.impl;

import com.zzu.diting.dto.MessageDto;
import com.zzu.diting.dto.rightaudit.AddRightAuditQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditFormQueryParam;
import com.zzu.diting.dto.rightaudit.RightAuditTableDto;
import com.zzu.diting.dto.rightaudit.RightAuditTablesDto;
import com.zzu.diting.entity.RightDistributionManagementInfoPO;
import com.zzu.diting.mappers.RightDistributionManagementInfoMapper;
import com.zzu.diting.service.RightAuditService;
import com.zzu.diting.util.DataObjectTransDto;
import com.zzu.diting.util.DataTransformUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/13 21:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RightAuditServiceImpl implements RightAuditService {
    @Resource
    private RightDistributionManagementInfoMapper rightDistributionManagementInfoMapper;

    @Override
    public RightAuditTablesDto getRightAuditTableInfo(RightAuditFormQueryParam rightAuditFormQueryParam) {
        RightAuditTablesDto rightAuditTablesDto = new RightAuditTablesDto();
        int num7 = 7;
        int num8 = 8;
        int num2 = 2;
        int num3 = 3;
        Integer searchType = 1;
        String sortType = "desc";
        String timeType = "gmt_create";
        List<RightDistributionManagementInfoPO> rightDistributionManagementInfoPOS = new ArrayList<>();
        List<RightAuditTableDto> list = new ArrayList<>();
        try {
            if (rightAuditFormQueryParam.getSearchType() == null) {
                rightAuditTablesDto.setCode(1);
                rightAuditTablesDto.setMessage("缺少检索类型");
                return rightAuditTablesDto;
            } else {
                searchType = rightAuditFormQueryParam.getSearchType();
            }
            if (rightAuditFormQueryParam.getTimeType() == null) {
                rightAuditTablesDto.setCode(1);
                rightAuditTablesDto.setMessage("缺少排序时间类型");
                return rightAuditTablesDto;
            } else {
                if (rightAuditFormQueryParam.getTimeType() == num2) {
                    timeType = "gmt_create";
                }
            }
            if (rightAuditFormQueryParam.getSortType() == null) {
                rightAuditTablesDto.setCode(1);
                rightAuditTablesDto.setMessage("缺少排序方式");
                return rightAuditTablesDto;
            } else {
                if (rightAuditFormQueryParam.getSortType() == num2) {
                    sortType = "asc";
                }
            }
            Integer totalNumber;
            String rightType = null;
            if (searchType == num2) {
                if (searchType == 1) {
                    rightType = "著作权";
                }
                if (searchType == num2) {
                    rightType = "名誉权/肖像权";
                }
                if (searchType == num3) {
                    rightType = "其他权利";
                }
            }
            Integer startNumber = (rightAuditFormQueryParam.getPage() - 1) * rightAuditFormQueryParam.getRows();
            Integer endNumber = rightAuditFormQueryParam.getPage() * rightAuditFormQueryParam.getRows();
            totalNumber = rightDistributionManagementInfoMapper.getTotalNumber(rightType, rightAuditFormQueryParam.getWorkType(), rightAuditFormQueryParam.getManagerName(), rightAuditFormQueryParam.getOperatorName(), null, null, null, null);
            if (rightAuditFormQueryParam.getSearchType() == num7) {
                totalNumber = rightDistributionManagementInfoMapper.getTotalNumber(rightType, rightAuditFormQueryParam.getWorkType(), rightAuditFormQueryParam.getManagerName(), rightAuditFormQueryParam.getOperatorName(), "gmt_create", null, DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getEndTime()).getTime());

            }
            if (rightAuditFormQueryParam.getSearchType() == num8) {
                totalNumber = rightDistributionManagementInfoMapper.getTotalNumber(rightType, rightAuditFormQueryParam.getWorkType(), rightAuditFormQueryParam.getManagerName(), rightAuditFormQueryParam.getOperatorName(), null, "gmt_modified", DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getEndTime()).getTime());

            }
            switch (searchType) {
                case 1:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoAll(startNumber, endNumber, timeType, sortType);
                    break;
                case 2:
                    RightDistributionManagementInfoPO rightDistributionManagementInfoPO = new RightDistributionManagementInfoPO();
                    rightDistributionManagementInfoPO = rightDistributionManagementInfoMapper.selectByPrimaryKey(rightAuditFormQueryParam.getId());
                    if (rightDistributionManagementInfoPO != null) {
                        rightDistributionManagementInfoPOS.add(rightDistributionManagementInfoPO);
                    }
                    break;
                case 3:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByRightType(rightType, startNumber, endNumber, timeType, sortType);
                    break;
                case 4:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoWorkType(rightAuditFormQueryParam.getWorkType(), startNumber, endNumber, timeType, sortType);
                    break;
                case 5:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByDistributionName(rightAuditFormQueryParam.getManagerName(), startNumber, endNumber, timeType, sortType);
                    break;
                case 6:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByOperatorName(rightAuditFormQueryParam.getOperatorName(), startNumber, endNumber, timeType, sortType);
                    break;
                case 7:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByTime("gmt_create", DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                    break;
                case 8:
                    rightDistributionManagementInfoPOS = rightDistributionManagementInfoMapper.queryRightDistributionManagementInfoByTime("gmt_modified", DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getStartTime()).getTime(), DataTransformUtil.stringTransformDate(rightAuditFormQueryParam.getEndTime()).getTime(), startNumber, endNumber, timeType, sortType);
                    break;
                default:
                    break;
            }
            DataObjectTransDto.populateList(rightDistributionManagementInfoPOS, list, RightAuditTableDto.class);
            rightAuditTablesDto.setRows(list);
            rightAuditTablesDto.setTotal(totalNumber);
            rightAuditTablesDto.setCode(0);
            rightAuditTablesDto.setMessage("查询消息成功");
            return rightAuditTablesDto;
        } catch (Exception e) {
            e.printStackTrace();
            rightAuditTablesDto.setCode(1);
            rightAuditTablesDto.setMessage("SYSTEM_EXCEPTION");
            return rightAuditTablesDto;
        }
    }

    @Override
    public MessageDto addRightAuditInfo(AddRightAuditQueryParam addRightAuditQueryParam) {
        int num3 = 3;
        int num2 = 2;
        MessageDto messageDto = new MessageDto();
        try {
            String rightType = "";
            String workType = "";
            if (addRightAuditQueryParam.getRightType() == 1) {
                rightType = "著作权";
                if (addRightAuditQueryParam.getWorkType() != null) {
                    workType = addRightAuditQueryParam.getWorkType();
                }
            }
            if (addRightAuditQueryParam.getRightType() == num2) {
                rightType = "名誉权/肖像权";
            }
            if (addRightAuditQueryParam.getRightType() == num3) {
                rightType = "其他权利";
            }
            RightDistributionManagementInfoPO rightDistributionManagementInfoPO = new RightDistributionManagementInfoPO();
            rightDistributionManagementInfoPO.setOperatorName(addRightAuditQueryParam.getOperatorName());
            rightDistributionManagementInfoPO.setRightType(rightType);
            rightDistributionManagementInfoPO.setWorkType(workType);
            rightDistributionManagementInfoPO.setUpdateTime(System.currentTimeMillis());
            rightDistributionManagementInfoPO.setCreateTime(System.currentTimeMillis());
            rightDistributionManagementInfoPO.setDistributionId(addRightAuditQueryParam.getDistributionId());
            rightDistributionManagementInfoPO.setDistributionName(addRightAuditQueryParam.getDistributionName());
            rightDistributionManagementInfoPO.setManagerId(addRightAuditQueryParam.getManagerId());
            System.out.println(rightDistributionManagementInfoPO);
            rightDistributionManagementInfoMapper.insert(rightDistributionManagementInfoPO);

            messageDto.setCode(0);
            messageDto.setMessage("添加权利信息成功");
            return messageDto;
        } catch (Exception e) {
            e.printStackTrace();
            messageDto.setCode(1);
            messageDto.setMessage("SYSTEM_EXCEPTION");
            return messageDto;
        }
    }
}
