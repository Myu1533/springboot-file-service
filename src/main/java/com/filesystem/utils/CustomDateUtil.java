package com.filesystem.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @author Man Yu
 * @version 2023/1/20
 * @email manyu@hongtastock.com
 */
public class CustomDateUtil extends DateUtils {
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        long diff = endDate.getTime() - nowDate.getTime();
        long day = diff / nd;
        long hour = diff % nd / nh;
        long min = diff % nd % nh / nm;

        return day + "天" + hour + "小时" + min + "分钟";
    }
}
