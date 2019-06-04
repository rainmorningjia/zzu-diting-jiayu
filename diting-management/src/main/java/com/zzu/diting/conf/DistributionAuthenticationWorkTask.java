package com.zzu.diting.conf;


import com.zzu.diting.entity.AuthenticationDistributionManagementInfoPO;
import com.zzu.diting.entity.AuthenticationWorkInfoPO;
import com.zzu.diting.mappers.AuthenticationDistributionManagementInfoMapper;
import com.zzu.diting.mappers.AuthenticationWorkInfoMapper;
import com.zzu.diting.util.AverageList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/16 11:44
 */
public class DistributionAuthenticationWorkTask implements Runnable {

    @Override
    public void run() {
        distributionAuthenticationWork();
    }

    public void distributionAuthenticationWork() {
        System.out.println("认证工单分配" + Thread.currentThread().getName() + "!!!!!!!!!!!!!!!!!!!!!!");
        AuthenticationDistributionManagementInfoMapper authenticationDistributionManagementInfoMapper = SpringUtil.getBean(AuthenticationDistributionManagementInfoMapper.class);
        AuthenticationWorkInfoMapper authenticationWorkInfoMapper = SpringUtil.getBean(AuthenticationWorkInfoMapper.class);
        AuthenticationWorkInfoPO authenticationWorkInfoPO = new AuthenticationWorkInfoPO();
        authenticationWorkInfoPO.setIsDistribution(new Byte("0"));
        List<AuthenticationWorkInfoPO> authenticationWorkInfoPOList = authenticationWorkInfoMapper.select(authenticationWorkInfoPO);
        List<AuthenticationDistributionManagementInfoPO> authenticationDistributionManagementInfoPOList = authenticationDistributionManagementInfoMapper.selectAll();
        Integer size = authenticationDistributionManagementInfoPOList.size();
        if (size != 0 && authenticationWorkInfoPOList.size() != 0) {
            List<List<AuthenticationWorkInfoPO>> lists = AverageList.averageAssign(authenticationWorkInfoPOList, size);
            for (int i = 0; i < size; i++) {
                for (AuthenticationWorkInfoPO a :
                        lists.get(i)) {
                    AuthenticationWorkInfoPO newAuthenticationWorkInfoPO = new AuthenticationWorkInfoPO();
                    newAuthenticationWorkInfoPO.setId(a.getId());
                    newAuthenticationWorkInfoPO.setIsDistribution(new Byte("1"));
                    String managerName = authenticationDistributionManagementInfoPOList.get(i).getManagerName();
                    String managerId = authenticationDistributionManagementInfoPOList.get(i).getManagerId();
                    newAuthenticationWorkInfoPO.setHandlePerson(managerName);
                    newAuthenticationWorkInfoPO.setAuditorId(managerId);
                    String handleRecord = a.getHandleRecord();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String date = sdf.format(new Date());
                    String newHandleRecord = handleRecord + ";" + date + " 系统操作，分配给 " + managerName + " " + managerId;
                    newAuthenticationWorkInfoPO.setHandleRecord(newHandleRecord);
                    authenticationWorkInfoMapper.updateByPrimaryKeySelective(newAuthenticationWorkInfoPO);
                }
            }
        }
    }
}
