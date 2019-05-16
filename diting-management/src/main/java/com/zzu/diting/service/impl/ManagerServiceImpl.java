package com.zzu.diting.service.impl;

import com.zzu.diting.entity.ManagerInfo;
import com.zzu.diting.mappers.ManagerMapper;
import com.zzu.diting.service.ManagerService;
import com.zzu.diting.util.Md5Util;
import com.zzu.diting.util.MybatisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class ManagerServiceImpl implements ManagerService {
    @Resource
    ManagerMapper managerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public ManagerInfo getManagerInfo(ManagerInfo managerInfo) {
        ManagerInfo managerInfo1 = managerMapper.selectOne(managerInfo);
        return managerInfo1;
    }

    @Override
    public void addManagerInfo(ManagerInfo managerInfo) {
        String id = MybatisUtils.getUUID();
        managerInfo.setId(id);
        String password = managerInfo.getPassword();
        String salt = Md5Util.getSalt();
        String s = new SimpleHash("MD5", password, salt, 1024).toString();
        managerInfo.setPassword(s);
        managerInfo.setSalt(salt);
        managerInfo.setCreateTime(System.currentTimeMillis());
        managerInfo.setUpdateTime(System.currentTimeMillis());
        managerMapper.insert(managerInfo);
    }

    @Override
    public void loginManager(String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        subject.login(token);
    }
}
