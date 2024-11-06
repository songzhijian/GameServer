package com.tool.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    public static final long SECOND = 1000L;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long ONEDAYTIME = 24 * HOUR;

    public static final long WEEKDAYTIME = ONEDAYTIME * 7;

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String fromTimeToStandardStr(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return sdf.format(calendar.getTime());
    }

    public static String fromTimeToFormatStr(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return sdf.format(calendar.getTime());
    }

    public static String getTimeFormat() {
        return fromTimeToStandardStr(System.currentTimeMillis());
    }
}
