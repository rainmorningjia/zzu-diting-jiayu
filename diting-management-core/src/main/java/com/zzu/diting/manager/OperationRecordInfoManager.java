package com.zzu.diting.manager;

import com.zzu.diting.entity.OperationRecordInfoPO;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/3 10:29
 */
public interface OperationRecordInfoManager {
    void addOperationRecord(OperationRecordInfoPO operationRecordInfoPO);
    void deleteOperationRecordById(Long id);
    OperationRecordInfoPO getOperationRecordById(Long id);
    OperationRecordInfoPO getOperationRecord(OperationRecordInfoPO operationRecordInfoPO);
    List<OperationRecordInfoPO> getOperationRecords(OperationRecordInfoPO operationRecordInfoPO);
    void updateOperationRecord(OperationRecordInfoPO operationRecordInfoPO);
}
