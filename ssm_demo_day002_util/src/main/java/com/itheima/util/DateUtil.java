package com.itheima.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getStringTime(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String str = format.format(date);
        return str;
    }

    public static Date getDateTime(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = format.parse(str);
        return date;
    }
}
