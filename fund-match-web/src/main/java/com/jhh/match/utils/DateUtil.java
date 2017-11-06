package com.jhh.match.utils;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author tianweichang
 * @create 2017-10-27 14:09
 **/
public class DateUtil {
    /**
     * 时间格式
     */
    public final static String TIME_SHORT_FORMAT = "HH:mm:ss";
    /**
     * 日期格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    /**
     * 日期+时间格式----到秒
     */
    public static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date convertStrToDate(String time, String format) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        DateTime dt = DateTime.parse(time, formatter);
        return dt.toDate();
    }

    //2017-10-27
    public static Date convertStrToDate(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_FORMAT);
        DateTime dt = DateTime.parse(time, formatter);
        return dt.toDate();
    }

    public static String convertDateToString(Date date, String format) {
        if (date == null || StringUtils.isEmpty(format)) {
            return "";
        }
        DateTime dt = new DateTime(date);
        return dt.toString(DateTimeFormat.forPattern(format));
    }

    /**
     *
     * @param time  the milliseconds since January 1, 1970, 00:00:00 GMT.
     * @param dateFormat format type
     * @return
     */
    public static String convertDateToStr(long time, String dateFormat) {
        return convertDateToString(new Date(time), dateFormat);
    }

    public static String convertDateToStr(long time) {
        return convertDateToString(new Date(time), DEFAULT_FORMAT);
    }

    public static void main(String[] args) throws ParseException {
//        System.out.println(convertDateToString(new Date(), FULL_FORMAT));
        long old=1509414986000l;
        System.out.println(convertDateToStr(old,FULL_FORMAT));
        long b=convertStrToDate("2017-10-31 09:56:26",FULL_FORMAT).getTime();
        System.out.println(b);
        System.out.println(convertDateToStr(b,FULL_FORMAT));
    }
}
