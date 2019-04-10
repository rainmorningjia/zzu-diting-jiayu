package com.zzu.diting.mapper;

import com.zzu.diting.entity.PersonalAuthenticationInfoPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wb-jcy525678
 */
@org.apache.ibatis.annotations.Mapper
public interface PersonalAuthenticationInfoMapper extends Mapper<PersonalAuthenticationInfoPO> {
    /**
     * 查询固定页码的个人权利信息数据
     *
     * @param num1
     * @param num2
     * @return
     */
    public List<PersonalAuthenticationInfoPO> queryPersonalAuthenByPage(@Param("num1") Integer num1, @Param("num2") Integer num2);
}
