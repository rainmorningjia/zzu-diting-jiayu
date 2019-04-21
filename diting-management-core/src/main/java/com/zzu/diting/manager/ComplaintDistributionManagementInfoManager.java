package com.zzu.diting.manager;

import com.zzu.diting.entity.ComplaintDistributionManagementInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wb-jcy525678
 */
public interface ComplaintDistributionManagementInfoManager {
    void addComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO);
    void deleteComplaintDistributionManagementInfoById(Long id);
    ComplaintDistributionManagementInfoPO getComplaintDistributionManagementInfoById(Long id);
    ComplaintDistributionManagementInfoPO getComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO);
    List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndAll(String rightType, Integer num1, Integer num2, String time, String sort);

    List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndComplaintPlatform(String complaintForm, String rightType, Integer num1, Integer num2, String time, String sort);

    List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndDistributionName(String distributionName, String rightType, Integer num1, Integer num2, String time, String sort);

    List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndOperatorName(String operatorName, String rightType, Integer num1, Integer num2, String time, String sort);

    List<ComplaintDistributionManagementInfoPO> queryComplaintDistributionManagementInfoByRightTypeAndTime(String timeType, Long startTime, Long endTime, String rightType, Integer num1, Integer num2, String time, String sort);

    void updateComplaintDistributionManagementInfo(ComplaintDistributionManagementInfoPO complaintDistributionManagementInfoPO);



}
