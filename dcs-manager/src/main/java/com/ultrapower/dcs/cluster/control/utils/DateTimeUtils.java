package com.ultrapower.dcs.cluster.control.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.utils.DateTimeUtils
 * @Title 日期时间格式化处理组件
 * @Description
 * @Author fanjianfeng
 * @Version v1.0
 * @Created by   2018-06-11 9:58
 */
public class DateTimeUtils {
    /**
     * 将字符串转换为日期类型
     * @param strDate 字符型日期
     * @return Date 日期类型时间
     */
    public static Date formatStringToDate(String strDate) {
        SimpleDateFormat format;
        if (strDate.trim().equals(""))
            return null;
        try {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale
                    .getDefault());
            return format.parse(strDate);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 比较两个字符串时间相差的分钟数
     * @param startDateTime
     * @param endDateTime
     * @return 返回两个时间相差的分钟数,如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
     */
    public static long  minuteBetween(Date startDateTime, Date endDateTime) {
        long distanceMinuteTime = 0;
        try {
            Long startTime=startDateTime.getTime();
            Long endTime=endDateTime.getTime();
            long diff;
            if(startTime<endTime) {
               diff = endTime-startTime;
            } else {
               diff = endTime-startTime;
            }
            distanceMinuteTime =diff/(60*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceMinuteTime;
    }




    /**
     * 两个字符串日期时间进行大小比较
     * @param src_time 源时间数据
     * @param dest_time 目标时间数据
     * @return 如果dest_time>src_time则返回true,否则返回false
     */
    public static boolean timeCompare(String src_time, String dest_time,String _format) {
        boolean flag = false;
        SimpleDateFormat format = new SimpleDateFormat(_format);
        try {
            Date start = format.parse(src_time);
            Date end = format.parse(dest_time);
            long time = (end.getTime() - start.getTime());
            if (time > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 比较两个字符串时间相差的分钟数
     * @param startTime 一个源数据时间(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
     * @param endTime 一个目标数据时间(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
     * @return 返回两个时间相差的小时数,如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
     */
    public static long  minuteBetween(String startTime, String endTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long distanceTime = 0;
        try {
            Date startDate = format.parse(startTime);
            Date endDate = format.parse(endTime);
            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            distanceTime = endCalendar.get(Calendar.MINUTE)
                    - startCalendar.get(Calendar.MINUTE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceTime;
    }




}
