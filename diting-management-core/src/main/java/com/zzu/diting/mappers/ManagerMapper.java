package com.zzu.diting.mappers;

import com.zzu.diting.entity.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ManagerMapper extends BaseMapper<ManagerInfo> {

    List<ManagerInfo> queryManagerInfoByName(@Param("name") String name);

}
