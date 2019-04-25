package com.zzu.diting.service.impl;


import com.zzu.diting.entity.OperationRecordInfoPO;
import com.zzu.diting.manager.OperationRecordInfoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OperationServiceImpl implements OperationService {
    @Resource
    OperationRecordInfoManager operationRecordInfoManager;
    @Override
    public void addOperator(String operationType, String type, Long userId, String name) {
        OperationRecordInfoPO operationRecordInfoPO = new OperationRecordInfoPO();
        operationRecordInfoPO.setOperationPersonId(userId);
        operationRecordInfoPO.setName(name);
        operationRecordInfoPO.setOperationType(operationType);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        operationRecordInfoPO.setOperationRecord(date + " " + type);
        operationRecordInfoPO.setCreateTime(System.currentTimeMillis());
        operationRecordInfoPO.setUpdateTime(System.currentTimeMillis());
        operationRecordInfoManager.addOperationRecord(operationRecordInfoPO);
    }
}
