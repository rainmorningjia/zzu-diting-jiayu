package com.zzu.diting.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/15 13:56
 */
public class DataTransformUtil {
    public static Date stringTransformDate(String s)throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=simpleDateFormat.parse(s);
            return date;
    }
    public static String stringDateTransformLong(Long l){
        Date d=new Date(l);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data=sdf.format(d);
        return data;
    }
    public static String dateTransformString(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String d=simpleDateFormat.format(date);
        return d;

    }
    public static Timestamp stringTransformTimeDate(String s)throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(s);
        Timestamp timestamp=new Timestamp(date.getTime());
        return timestamp;
    }
    public static String timeDateTransformString(Timestamp timestamp){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String s=simpleDateFormat.format(timestamp);
        return s;
    }
}
