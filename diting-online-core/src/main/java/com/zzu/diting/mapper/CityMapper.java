package com.zzu.diting.mapper;

import java.util.List;

import com.zzu.diting.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface CityMapper extends BaseMapper<City> {
    public List<City> queryCityByProvince(@Param("name") String name);
}
