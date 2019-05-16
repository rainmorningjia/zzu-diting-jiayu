package com.zzu.diting.util;


import com.zzu.diting.dto.HandleRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/12 15:45
 */
public class SplitUtil {
    public static List<String> splitUrl(String url) {
        String[] urls = url.split(";");
        List<String> list = new ArrayList<>();
        for (String s : urls) {
            list.add(s);
        }
        return list;
    }

    public static List<Long> splitSting(String ss) {
        String[] urls = ss.split(";");
        List<Long> list = new ArrayList<>();
        for (String s : urls) {
            list.add(new Long(s));
        }
        return list;
    }

    public static List<HandleRecord> splitHandle(String handleRecord) {
        String[] handles = handleRecord.split(";");
        List<HandleRecord> handleRecords = new ArrayList<>();
        for (String s : handles) {
            System.out.println(s);
            String[] strings = s.split(" ");
            HandleRecord handleRecordNew = new HandleRecord();
            handleRecordNew.setDate(strings[0] + " " + strings[1]);
            if (strings.length == 5) {
                handleRecordNew.setOperation(strings[2]);
                handleRecordNew.setName(strings[3]);
                handleRecordNew.setId(strings[4]);
            }
            handleRecords.add(handleRecordNew);
        }
        return handleRecords;
    }
}
