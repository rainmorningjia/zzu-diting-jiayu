package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.OperationRecordInfoPO;
import com.zzu.diting.mappers.OperationRecordInfoMapper;
import com.zzu.diting.manager.OperationRecordInfoManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/3 10:35
 */
@Service
@Transactional
public class OperationRecordImpl implements OperationRecordInfoManager {
    @Resource
    OperationRecordInfoMapper operationRecordInfoMapper;
    @Override
    public void addOperationRecord(OperationRecordInfoPO operationRecordInfoPO) {
    operationRecordInfoMapper.insert(operationRecordInfoPO);
    }

    @Override
    public void deleteOperationRecordById(Long id) {
    operationRecordInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public OperationRecordInfoPO getOperationRecordById(Long id) {
        OperationRecordInfoPO operationRecordInfoPO=operationRecordInfoMapper.selectByPrimaryKey(id);
        return operationRecordInfoPO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public OperationRecordInfoPO getOperationRecord(OperationRecordInfoPO operationRecordInfoPO) {
        OperationRecordInfoPO operationRecordInfoPO1=operationRecordInfoMapper.selectOne(operationRecordInfoPO);
        return operationRecordInfoPO1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<OperationRecordInfoPO> getOperationRecords(OperationRecordInfoPO operationRecordInfoPO) {
        List<OperationRecordInfoPO> list=operationRecordInfoMapper.select(operationRecordInfoPO);
        return list;
    }

    @Override
    public void updateOperationRecord(OperationRecordInfoPO operationRecordInfoPO) {
        operationRecordInfoMapper.updateByPrimaryKeySelective(operationRecordInfoPO);
    }
}
