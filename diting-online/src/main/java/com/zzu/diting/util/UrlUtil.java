package com.zzu.diting.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/12 15:45
 */
public class UrlUtil {
    public static List<String> splitUrl(String url){
        String[] urls=url.split(";");
        List<String> list=new ArrayList<>();
        for (String s:urls){
            list.add(s);
        }
        return list;
    }
}
