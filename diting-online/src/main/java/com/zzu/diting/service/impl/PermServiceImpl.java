package com.zzu.diting.service.impl;

import com.zzu.diting.entity.realmObject.Perm;
import com.zzu.diting.mapper.PermMapper;
import com.zzu.diting.service.PermService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Miles
 * @Title: PermServiceImpl
 * @ProjectName cmfz-jcy
 * @Date 2019/1/4--18:37
 */
@Service
@Transactional
public class PermServiceImpl implements PermService {
    @Resource
    private PermMapper permMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Perm> queryPermsByRole(String role) {
        Perm perm=new Perm();
        perm.setRole(role);
        List<Perm> permList=permMapper.select(perm);
        return permList;
    }
}
