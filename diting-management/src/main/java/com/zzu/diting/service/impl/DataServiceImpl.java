package com.zzu.diting.service.impl;

import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.mapper.UserComplaintInfoMapper;
import com.zzu.diting.mapper.UserInfoMapper;
import com.zzu.diting.service.DataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DataServiceImpl implements DataService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    UserComplaintInfoMapper userComplaintInfoMapper;

    @Override
    public List<UserInfoPO> getUserAuthenticationData(Integer state, Long date) {
        return userInfoMapper.queryUserByAuthenticationStateByDate(state, date);
    }

    @Override
    public Integer getUserComplaintData(String rightType, Long date) {
        return userComplaintInfoMapper.queryComplaintNumberByRightTypeAndDate(rightType, date);
    }
}
