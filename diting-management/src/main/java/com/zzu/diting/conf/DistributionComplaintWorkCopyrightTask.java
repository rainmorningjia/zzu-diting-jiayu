package com.zzu.diting.conf;

import com.zzu.diting.dto.rightwork.RightType;
import com.zzu.diting.entity.ComplaintDistributionManagementInfoPO;
import com.zzu.diting.entity.ComplaintsWorkInfoPO;
import com.zzu.diting.mappers.ComplaintDistributionManagementInfoMapper;
import com.zzu.diting.mappers.ComplaintsWorkAllInfoMapper;
import com.zzu.diting.util.AverageList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/16 15:00
 */
public class DistributionComplaintWorkCopyrightTask implements Runnable {
    @Override
    public void run() {
        distributionRightWorkByType(RightType.Copyright.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.Copyright.getDesc(), "版权处理组审核");
        distributionRightWorkByType(RightType.Copyright.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.Copyright.getDesc(), "版权处理组审核");
        distributionRightWorkByType(RightType.ReputationRight.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.ReputationRight.getDesc(), "版权处理组审核");
        distributionRightWorkByType(RightType.ReputationRight.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.ReputationRight.getDesc(), "版权处理组审核");
        distributionRightWorkByType(RightType.OtherRight.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.OtherRight.getDesc(), "版权处理组审核");
        distributionRightWorkByType(RightType.OtherRight.getDesc(), "版权管理组审核");
        distributionRightWorkByType(RightType.OtherRight.getDesc(), "版权处理组审核");
    }

    public void distributionRightWorkByType(String type, String node) {
        System.out.println("投诉工单分配" + Thread.currentThread().getName());
        ComplaintsWorkAllInfoMapper complaintsWorkAllInfoMapper = SpringUtil.getBean(ComplaintsWorkAllInfoMapper.class);
        ComplaintDistributionManagementInfoMapper complaintDistributionManagementInfoMapper = SpringUtil.getBean(ComplaintDistributionManagementInfoMapper.class);
        String node1 = "版权管理组审核";
        ComplaintsWorkInfoPO complaintsWorkInfoPO = new ComplaintsWorkInfoPO();
        complaintsWorkInfoPO.setIsDistribution(0);
        complaintsWorkInfoPO.setComplaintType(type);
        complaintsWorkInfoPO.setNode(node);
        ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO = new ComplaintDistributionManagementInfoPO();
        complaintDistributionManagementInfoPO.setRightType(type);
        complaintDistributionManagementInfoPO.setNode(node);
        System.out.println(complaintDistributionManagementInfoPO+"分配信息11111111111111111111111111");
        List<ComplaintsWorkInfoPO> list = complaintsWorkAllInfoMapper.select(complaintsWorkInfoPO);
        List<ComplaintDistributionManagementInfoPO> complaintDistributionManagementInfoPOS = complaintDistributionManagementInfoMapper.select(complaintDistributionManagementInfoPO);
        System.out.println(complaintDistributionManagementInfoPOS+"分配信息！！！！！！！！！！！！！！！！！！！！！！！！！");
        Integer size = complaintDistributionManagementInfoPOS.size();
        if (size != 0 && list.size() != 0) {
            List<List<ComplaintsWorkInfoPO>> lists = AverageList.averageAssign(list, size);
            for (int i = 0; i < size; i++) {
                for (ComplaintsWorkInfoPO a :
                        lists.get(i)) {
                    ComplaintsWorkInfoPO newComplaintsWork = new ComplaintsWorkInfoPO();
                    newComplaintsWork.setId(a.getId());
                    newComplaintsWork.setIsDistribution(1);
                    String managerName = complaintDistributionManagementInfoPOS.get(i).getDistributionName();
                    String managerId = complaintDistributionManagementInfoPOS.get(i).getManagerId();
                    if (node.equals(node1)) {
                        newComplaintsWork.setHandlePerson(managerName);
                        newComplaintsWork.setHandlePersonId(managerId);
                    } else {
                        newComplaintsWork.setHandlePersonHandle(managerName);
                        newComplaintsWork.setHandlePersonHandleId(managerId);
                    }
                    String handleRecord = a.getHandleRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = handleRecord + ";" + date + " 系统操作，分配给 " + managerName + " " + managerId;
                    newComplaintsWork.setHandleRecord(newHandleRecord);
                    complaintsWorkAllInfoMapper.updateByPrimaryKeySelective(newComplaintsWork);
                }
            }
        }
    }
}
