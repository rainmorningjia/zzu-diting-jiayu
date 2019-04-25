package com.zzu.diting.service;


import com.zzu.diting.entity.City;
import com.zzu.diting.entity.Province;

import java.util.List;


public interface AddressSevice {
	public List<Province> queryAllProvice();
	public List<City> queryAllCityByProvince(String name);
}
