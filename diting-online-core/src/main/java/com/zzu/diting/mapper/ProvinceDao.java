package com.zzu.diting.mapper;

import com.zzu.diting.entity.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceDao {
	public List<Province> queryAllProvince();
}
