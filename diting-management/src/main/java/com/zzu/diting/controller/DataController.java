package com.zzu.diting.controller;


import com.alibaba.fastjson.JSONObject;
import com.zzu.diting.entity.UserInfoPO;
import com.zzu.diting.service.DataService;
import io.goeasy.GoEasy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("data")
public class DataController {
    @Resource
    private DataService dataService;

    @RequestMapping("getUserAuthenticationData")
    public Map<String, Object> getUserAuthenticationData() {
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        long lastTime = calendar.getTime().getTime();
        Map<String, Object> map = new HashMap<>();
        List<UserInfoPO> userA1 = dataService.getUserAuthenticationData(2, lastTime);
        List<UserInfoPO> userNA1 = dataService.getUserAuthenticationData(0, lastTime);
        calendar.add(Calendar.DAY_OF_YEAR, -14);
        long lastTime2 = calendar.getTime().getTime();
        List<UserInfoPO> userA2 = dataService.getUserAuthenticationData(2, lastTime2);
        List<UserInfoPO> userNA2 = dataService.getUserAuthenticationData(0, lastTime2);
        calendar.add(Calendar.DAY_OF_YEAR, -21);
        long lastTime3 = calendar.getTime().getTime();
        List<UserInfoPO> userA3 = dataService.getUserAuthenticationData(2, lastTime3);
        List<UserInfoPO> userNA3 = dataService.getUserAuthenticationData(0, lastTime3);
        List<Integer[]> list=new ArrayList<>();
        list.add( new Integer[]{userA1.size(), userA2.size(), userA3.size()});
        list.add( new Integer[]{userNA1.size(), userNA2.size(), userNA3.size()});
        map.put("categ",new String[]{"已认证","未认证"});
        map.put("data",list);
        map.put("intervals", new String[]{"一周", "两周", "三周", });
/*        String content= JSONObject.toJSONString(map);
        GoEasy goEasy=new GoEasy("rest-hangzhou.goeasy.io","BC-70ebea0f04134206a763c136203244a0");
        goEasy.publish("dataanaysis",content);*/
        return map;

    }
}
