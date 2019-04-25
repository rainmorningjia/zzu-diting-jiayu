package com.zzu.diting.mapper;

import java.util.List;

import com.zzu.diting.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CityDao {
    public List<City> queryCityByProvince(@Param("name") String name);
}
