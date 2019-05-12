package com.zzu.diting.service.impl;

import com.zzu.diting.entity.City;
import com.zzu.diting.entity.Province;
import com.zzu.diting.mapper.CityMapper;
import com.zzu.diting.mapper.ProvinceMapper;
import com.zzu.diting.service.AddressSevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressSevice {
    @Resource
    private CityMapper cityMapper;
    @Resource
    private ProvinceMapper provinceMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public List<Province> queryAllProvice() {
        List<Province> provinces = provinceMapper.queryAllProvince();
        return provinces;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public List<City> queryAllCityByProvince(String name) {
        List<City> cities = cityMapper.queryCityByProvince(name);
        return cities;
    }

}
