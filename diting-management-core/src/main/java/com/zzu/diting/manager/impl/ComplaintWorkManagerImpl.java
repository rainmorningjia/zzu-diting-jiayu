package com.zzu.diting.manager.impl;

import com.zzu.diting.entity.ComplaintWorkInfoPO;
import com.zzu.diting.mappers.ComplaintWorkMapper;
import com.zzu.diting.manager.ComplaintWorkManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/2 20:13
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
public class ComplaintWorkManagerImpl implements ComplaintWorkManager {

    @Resource
    ComplaintWorkMapper complaintWorkMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO) {
        complaintWorkMapper.insert(complaintWorkInfoPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteComplaintWorkById(Long id) {
        complaintWorkMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO) {
        complaintWorkMapper.updateByPrimaryKeySelective(complaintWorkInfoPO);
    }

    @Override
    public ComplaintWorkInfoPO getComplaintWorkById(Long id) {
        ComplaintWorkInfoPO complaintWorkInfoPO = complaintWorkMapper.selectByPrimaryKey(id);
        return complaintWorkInfoPO;
    }

    @Override
    public ComplaintWorkInfoPO getComplaintWork(ComplaintWorkInfoPO complaintWorkInfoPO) {
        ComplaintWorkInfoPO complaintWorkInfoPO1 = complaintWorkMapper.selectOne(complaintWorkInfoPO);
        return complaintWorkInfoPO1;
    }

}
