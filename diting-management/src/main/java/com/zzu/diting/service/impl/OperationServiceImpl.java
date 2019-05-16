package com.zzu.diting.service.impl;

import com.zzu.diting.entity.OperationRecordInfoPO;
import com.zzu.diting.manager.OperationRecordInfoManager;
import com.zzu.diting.service.OperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/17 11:36
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Resource
    OperationRecordInfoManager operationRecordInfoManager;
    @Override
    public void addOperator(String operationType, String type, String  userId, String name) {
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
