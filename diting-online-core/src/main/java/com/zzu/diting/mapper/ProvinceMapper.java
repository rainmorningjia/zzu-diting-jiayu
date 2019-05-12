package com.zzu.diting.mapper;

import com.zzu.diting.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
    public List<Province> queryAllProvince();
}
