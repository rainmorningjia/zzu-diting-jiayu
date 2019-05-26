package com.zzu.diting.controller;

import com.zzu.diting.dto.other.CityDto;
import com.zzu.diting.dto.other.ProvinceDto;
import com.zzu.diting.entity.City;
import com.zzu.diting.entity.Province;
import com.zzu.diting.service.AddressSevice;
import com.zzu.diting.util.DataObjectTransDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Resource
    private AddressSevice addressSevice;

    @RequestMapping("province")
    public List<ProvinceDto> getAllProvince() {
        List<Province> list = addressSevice.queryAllProvice();
        List<ProvinceDto> provinceDtos = new ArrayList<>();
        DataObjectTransDto.populateList(list, provinceDtos, ProvinceDto.class);
        return provinceDtos;
    }

    @RequestMapping("city")
    public List<CityDto> getCity(String name) {
        List<City> list = addressSevice.queryAllCityByProvince(name);
        List<CityDto> cityDtos = new ArrayList<>();
        DataObjectTransDto.populateList(list, cityDtos, CityDto.class);
        return cityDtos;
    }
}
