package com.zzu.diting.manager;

import com.zzu.diting.entity.RightDistributionManagementInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightDistributionManagementInfoManager {
    void addRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO);
    void deleteRightDistributionManagementInfoById(Long id);
    RightDistributionManagementInfoPO getRightDistributionManagementInfoById(Long id);
    RightDistributionManagementInfoPO getRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO);
    /**
     *
     * @param num1
     * @param num2
     * @param time
     * @param sort
     * @return
     */
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoAll(Integer num1, Integer num2, String time, String sort);
    /**
     *
     * @param rightType
     * @param num1
     * @param num2
     * @param time
     * @param sort
     * @return
     */
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByRightType(String rightType, Integer num1, Integer num2, String time, String sort);
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoWorkType(String workType, Integer num1, Integer num2, String time, String sort);
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByDistributionName(String distributionName, Integer num1, Integer num2, String time, String sort);
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByOperatorName(String operatorName, Integer num1, Integer num2, String time, String sort);
    List<RightDistributionManagementInfoPO> getRightDistributionManagementInfoByTime(String timeType, Long t1, Long t2, Integer num1, Integer num2, String time, String sort);
    List<RightDistributionManagementInfoPO> getAll();
    void updateRightDistributionManagementInfo(RightDistributionManagementInfoPO rightDistributionManagementInfoPO);
}
