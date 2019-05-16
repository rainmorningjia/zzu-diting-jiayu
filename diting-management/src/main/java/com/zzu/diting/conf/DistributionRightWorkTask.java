package com.zzu.diting.conf;

import com.zzu.diting.dto.rightwork.RightType;
import com.zzu.diting.entity.RightDistributionManagementInfoPO;
import com.zzu.diting.entity.RightWorkInfoPO;
import com.zzu.diting.mappers.RightDistributionManagementInfoMapper;
import com.zzu.diting.mappers.RightWorkMapper;
import com.zzu.diting.util.AverageList;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/16 12:10
 */
@Component
public class DistributionRightWorkTask implements Runnable {

    @Override
    public void run() {
        distributionRightWorkByType(RightType.Copyright.getDesc(), "视频");
        distributionRightWorkByType(RightType.ReputationRight.getDesc(), null);
        distributionRightWorkByType(RightType.OtherRight.getDesc(), null);
    }

    public void distributionRightWorkByType(String type, String workType) {
        System.out.println("权利工单分配" + Thread.currentThread().getName());
        RightDistributionManagementInfoMapper rightDistributionManagementInfoMapper = SpringUtil.getBean(RightDistributionManagementInfoMapper.class);
        RightWorkMapper rightWorkMapper = SpringUtil.getBean(RightWorkMapper.class);
        RightWorkInfoPO rightWorkInfoPO = new RightWorkInfoPO();
        rightWorkInfoPO.setIsDistribution(new Byte("0"));
        rightWorkInfoPO.setRightType(type);
        RightDistributionManagementInfoPO rightDistributionManagementInfoPO = new RightDistributionManagementInfoPO();
        rightDistributionManagementInfoPO.setRightType(type);
        if (workType != null && type.equals(RightType.Copyright.getDesc())) {
            rightWorkInfoPO.setWorksType(workType);
            rightDistributionManagementInfoPO.setWorkType(workType);
        }
        List<RightWorkInfoPO> list = rightWorkMapper.select(rightWorkInfoPO);
        List<RightDistributionManagementInfoPO> rightDistributionManagementInfoPOList = rightDistributionManagementInfoMapper.select(rightDistributionManagementInfoPO);
        Integer size = rightDistributionManagementInfoPOList.size();
        if (list.size() != 0 && size != 0) {
            List<List<RightWorkInfoPO>> lists = AverageList.averageAssign(list, size);
            for (int i = 0; i < size; i++) {
                for (RightWorkInfoPO a :
                        lists.get(i)) {
                    RightWorkInfoPO newRightWorkInfoPO = new RightWorkInfoPO();
                    newRightWorkInfoPO.setId(a.getId());
                    newRightWorkInfoPO.setIsDistribution(new Byte("1"));
                    String managerName = rightDistributionManagementInfoPOList.get(i).getDistributionName();
                    String managerId = rightDistributionManagementInfoPOList.get(i).getManagerId();
                    newRightWorkInfoPO.setHandlePerson(managerName);
                    newRightWorkInfoPO.setAuditorId(managerId);
                    String handleRecord = a.getProcessingRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = handleRecord + ";" + date + " 系统操作，分配给 " + managerName + " " + managerId;
                    newRightWorkInfoPO.setProcessingRecord(newHandleRecord);
                    rightWorkMapper.updateByPrimaryKeySelective(newRightWorkInfoPO);
                }
            }
        }
    }
}
