package com.common.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class TimeUtils {

	/**
	 * 将长整型的日期转化为字符型日期字符串
	 * @param intDate 长整型日期
	 */
	public static String formatIntToDateString(long intDate)
	{
		Date time;
		SimpleDateFormat format;
		String strtime;		
		if (intDate > 0) {
			try {
				long c_unix_time2 = intDate;
				time = new Date();
				time.setTime(c_unix_time2 * 1000);
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
				strtime = format.format(time);
			} catch (Exception ex) {
				strtime = "";
				ex.printStackTrace();
			}
		} else {
			strtime = "";
		}
		return strtime;
	}
	
	public static String formatDateToDateString(Date p_date, String _format) {
		String date = null;
		try {
			SimpleDateFormat simpleDateFormat;
			simpleDateFormat = new SimpleDateFormat(_format);
			date = simpleDateFormat.format(p_date);
		} catch (Exception e) {
			date = "";
		}
		return date;

	}
	
	/**
	 * 将长整型的日期转化为字符型日期字符串
	 * @param intDate 长整型日期
	 * @return pattern 格式
	 */
	public static String formatIntToDateString(long intDate,String pattern)
	{
		Date time;
		SimpleDateFormat format;
		String strtime;		
		if (intDate > 0) {
			try {
				long c_unix_time2 = intDate;
				time = new Date();
				time.setTime(c_unix_time2 * 1000);
				if(pattern!=null)
				{
					format = new SimpleDateFormat(pattern, Locale.getDefault());
				}
				else
				{
					format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
				}
				strtime = format.format(time);
			} catch (Exception ex) {
				strtime = "";
				ex.printStackTrace();
			}
		} else {
			strtime = "";
		}
		return strtime;
	}
	
	/**
	 * 将长整型的日期转化为字符型日期字符串yyyy-MM-dd
	 * @param intDate 长整型日期
	 * @return String 字符型时间
	 */
	public static String formatIntToDateStringT(long intDate)
	{
		Date time;
		SimpleDateFormat format;
		String strtime;			
		if (intDate > 0) {
			try {
				long c_unix_time2 = intDate;
				time = new Date();
				time.setTime(c_unix_time2 * 1000);
				format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
				strtime = format.format(time);
			} catch (Exception ex) {
				strtime = "";
				ex.printStackTrace();
			}
		} else {
			strtime = "";
		}
		return strtime;
	}

	/**
	 * 将长整型的日期转化为一定格式字符型日期字符串
	 * @param _format 格式化 例如:yyyy-MM-dd HH:mm:ss
	 * @param intDate 长整型日期
	 * @return String 字符型时间
	 */
	public static String formatIntToDateString(String _format, long intDate)
	{
		Date time = new Date();
		SimpleDateFormat format;
		String strtime;	
		if (intDate > 0) 
		{
			try {
				long c_unix_time2 = intDate;
				time.setTime(c_unix_time2 * 1000);
				format = new SimpleDateFormat(_format, Locale.getDefault());
				strtime = format.format(time);
			} catch (Exception ex) {
				strtime = "";
				ex.printStackTrace();
			}
		} else {
			strtime = "";
		}
		return strtime;
	}

	/**
	 * 将长整型转换为日期类型
	 * @param intDate 长整型日期
	 * @return Date 日期类型时间
	 */
	public static Date formatIntToDate(long intDate) {
		Date time = new Date();
		if(intDate>0){
			time.setTime(intDate * 1000);
		}
		return time;
	}

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
     * 将字符串转换为日期类型
     * @param strDate 字符型日期
     * @return Date 日期类型时间
     */
    public static Date formatStringToDate(String strDate,String formatString) {
        SimpleDateFormat format;
        if (strDate.trim().equals(""))
            return null;
        try {
            format = new SimpleDateFormat(formatString, Locale
                    .getDefault());
            return format.parse(strDate);
        } catch (Exception ex) {
            return null;
        }
    }
	/**
	 * 将字符串转换为日期类型
	 * @param strDate 字符型日期
	 * @return Date 日期类型时间
	 */
	public static Date formatStrToDate(String strDate) {
		SimpleDateFormat format;
		if (strDate.trim().equals(""))
			return null;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd", Locale
					.getDefault());
			return format.parse(strDate);
		} catch (Exception ex) {
			return null;
		}
	}



	/**
	 * 将日期转换成长整型
	 * @param p_date 日期型时间
	 * @return long 长整型时间
	 */
	public static long formatDateToInt(Date p_date) {
		if (p_date != null) {
			return p_date.getTime() / 1000;
		}
		return 0;
	}

	/**
	 * 将字符串日期转换成长整类型日期
	 * @param strDate 字符串型时间
	 * @return long 长整型时间
	 */
	public static long formatDateStringToInt(String strDate) {
		SimpleDateFormat format;
		Date time;
		if (strDate.trim().equals(""))
			return -1;
		String strAry[] = strDate.split(":");
		if (strAry.length > 1)
		{
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		}
		else
		{
			if(strDate.indexOf("-")>0)
			{
				format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			}
			else
			{
				//不带“-”的 如：20150520 格式的日期
				format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
			}
		}
		try {
			time = format.parse(strDate + ":00");
			return time.getTime() / 1000;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 将字符串类型转换为长整型(按格式)
	 * @param strDate 字符串型时间
	 * @param _format 字符串时间格式
	 * @return long 长整型时间
	 */
	public static long formatDateStringToInt(String strDate, String _format) {
		try{
			//如果传入的strDate已经为10为秒的话，直接返回int类型
			return Integer.parseInt(strDate);
		}catch(Exception ex){
		}
		Date time;
		SimpleDateFormat format = new SimpleDateFormat(_format, Locale.getDefault());
		try {
			time = format.parse(strDate);
			return time.getTime() / 1000;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 将日期类型转化为长日期字符串
	 * @param p_date 日期型时间
	 * @return String 字符串时间
	 */
	public static String formatLongDateToString(Date p_date) {
		String strtime = "";
		SimpleDateFormat format;
		if (formatDateToInt(p_date) > 0) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale
					.getDefault());
			strtime = format.format(p_date);
		}
		return strtime;
	}

	/**
	 * 将日期类型转化为短日期字符串
	 * @param p_date 日期型时间
	 * @return String 字符串时间
	 */
	public static String formatShortDateToString(Date p_date) {
		String strtime = "";
		SimpleDateFormat format;
		format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		strtime = format.format(p_date);
		return strtime;
	}
	
	/**
	 * 用于获得指定格式的当前日期 
	 * @param format 字符串时间格式  eg:yyyy-MM-dd hh:mm:ss
	 * @return String 字符串时间
	 */
	public static String getCurrentDate(String format) {
		String currentDate = "";
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat;
			Date date = calendar.getTime();
			simpleDateFormat = new SimpleDateFormat(format);
			currentDate = simpleDateFormat.format(date);
		} catch (Exception e) {
			currentDate = "";
		}
		return currentDate;

	}

	/**
	 * 用于获得当前日期
	 * @return Date 日期型时间
	 */
	public static Date getCurrentDate() {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取当前时间的秒数
	 * @return
	 */
	public static long getCurrentTime() {
		return System.currentTimeMillis()/1000;
	}
	
	/**
	 * 获取指定日期的年
	 * @param p_date  util.Date日期
	 * @return 返回的月,例如2010-05-17 则返回2010
	 */
	public static int getYearOfDate(java.util.Date p_date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(p_date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * 获取指定日期的月时间
	 * @param p_date util.Date日期
	 * @return 返回的月,例如2010-05-17 则返回5
	 */
	public static int getMonthOfDate(java.util.Date p_date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(p_date);
		return c.get(java.util.Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取指定日期的日时间
	 * @param p_date util.Date日期格式
	 * @return 返回的日,例如2010-05-17 则返回17
	 */
	public static int getDayOfDate(java.util.Date p_date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(p_date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 比较两个字符串时间相差的年数,只要年份不同，不到一年的，返回一年
	 * @param startTime 一个源时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @return 如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
	 */
	public static long yearBetween(String startTime, String endTime) {
		long distanceYear = 0;
		String[] date = dateBetween(startTime,endTime).split(":");
		if (date.length != 6) {
			int year = Integer.parseInt(date[0]);
			distanceYear = year;
		}
		return distanceYear;
	}
	
	/**
	 * 比较两个字符串时间相差的月数
	 * @param startTime 一个源时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @return 如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
	 */
	public static long monthBetween(String startTime, String endTime) {
		long distanceDay = 0;
		String[] date = dateBetween(startTime,endTime).split(":");
		if(date.length == 6){
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			distanceDay = year*12+month;
		}
		return distanceDay;
	}
	
	/**
	 * 比较两个字符串时间相差的天数
	 * @param startTime 一个源时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @return	如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
	 */
	public static long daysBetween(String startTime, String endTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long distanceDay = 0;
		try {
			if (!StringUtils.checkNullString(startTime).equals("") && !StringUtils.checkNullString(endTime).equals("")) {
				Date startDate = format.parse(startTime);
				Date endDate = format.parse(endTime);
				distanceDay = (endDate.getTime() - startDate.getTime())/(1000*60*60*24);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distanceDay;
	}
	
	/**
	 * 比较两个字符串时间相差的小时数 
	 * @param startTime 一个源数据时间(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标数据时间(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @return 返回两个时间相差的小时数,如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
	 */
	public static long timeBetween(String startTime, String endTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		long distanceTime = 0;
		try {
			Date startDate = format.parse(startTime);
			Date endDate = format.parse(endTime);
			Calendar startCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate);
			endCalendar.setTime(endDate);
			distanceTime = endCalendar.get(Calendar.HOUR)
					- startCalendar.get(Calendar.HOUR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distanceTime;
	}
	
	/**
	 * 比较两个字符串时间的时间差
	 * @param startTime 一个源时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * return 输出格式为 年:月:日:时:分:秒
	 */	
	private static String dateBetween(String startTime, String endTime) {
		String date = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			if (!StringUtils.checkNullString(startTime).equals("") && !StringUtils.checkNullString(endTime).equals("")) {
				Date startDate = format.parse(startTime);
				Date endDate = format.parse(endTime);
				int year = endDate.getYear() - startDate.getYear();
				int month = endDate.getMonth() - startDate.getMonth();
				int day = endDate.getDay() - startDate.getDay();
				int hour = endDate.getHours()-startDate.getHours();
				int minute = endDate.getMinutes() - startDate.getMinutes();
				int second = endDate.getSeconds() - startDate.getSeconds();
				date = year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
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
	 * 计算两个日期相差的天数
	 * @author yhg
	 * @param fistDate
	 * @param secondDate
	 * @return
	 */
	public static int getBetweenDays(String begin, String end) {
		if (begin == null || end == null) {
			return 0;
		}
		int days = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date sdate = sdf.parse(begin);
			Date edate = sdf.parse(end);
			long times = edate.getTime() - sdate.getTime();
			days = (int) (times / 86400000);// 24 * 60 * 60 * 1000 = 86400000
		} catch (Exception pe) {
			//log.warn("计算两个日期的时间发生异常，可能是日期的格式有错,请用yyyy-MM-dd格式");
			pe.printStackTrace();
		}
		return days;
	}
	/**
	 *  制定时间格式，将String时间转换成Data
	 *  @author yhg
	 * @param time
	 * @param dateFormate
	 * @return
	 */
	public static Date getDate(String time, String dateFormate) {
		SimpleDateFormat smdf = new SimpleDateFormat(dateFormate);
		Date theDate = null;
		try {
			theDate = smdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theDate;
	}
	
	/**
	 *  为给定的日期添加或减去指定的天数
	 *  @author magl
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getModifyDate(Date date, int n) {
		Date theDate = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, n);
		theDate = cal.getTime();
		return theDate;
	}
	
	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }
	
    public static String getWeekOfDate(String strdate) {
    	String result="";
    	Date date=formatStrToDate(strdate);
    	if(date!=null)
    	{
    		result=getWeekOfDate(date);
    	}
        return result;
    }    
	
	 /**
     * 判断某天是星期几
     * @author yhg
     * @param date
     * @return
     */
	public static String getWeekday(String date) {// 必须yyyy-MM-dd
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdw.format(d);
	}
	 /**
     * 判断某天是星期几
     * @author yhg
     * @param date
     * @return
     */
	public static String getWeekday(Date date) {// 必须yyyy-MM-dd
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		return sdw.format(date);
	}	
	/**
	 * 将"00:00:00" 格式的时分秒转换成秒
	 * @author yhg
	 * @param date
	 * @return
	 */
	 public static long getSecond(String date){
	    	long secondLong = 0;
	    	if(date != null && !"".equals(date)){
	    		String[] timeStr = date.split(":");
	    		long hour= Integer.valueOf(timeStr[0]).intValue() * 3600;
	    		long minute = Integer.valueOf(timeStr[1]).intValue() * 60;
	    		long second = Integer.valueOf(timeStr[2]).intValue();
	    		secondLong = hour+minute+second;
	    	}
	    	return secondLong;
	    }
	 /**
	  * 查询yyyy-MM月有几天
	  * @author yhg
	  * @param data
	  */
	 public static int getData(String data){
		    Calendar cal = Calendar.getInstance();   
		    cal.set(Calendar.YEAR,Integer.parseInt(data.substring(0,4)));   
		    cal.set(Calendar.MONTH,Integer.parseInt(data.substring(data.indexOf("-")+1,data.length()))-1);   
		    int maxDate = cal.getActualMaximum(Calendar.DATE);//当前月最大天数
		    return maxDate;
		    
		   
		}
	 
	/**
     * 判断某天是否是周末
     * @author yhg
     * @param date
     * @return
     */
	public static boolean isWeekend(Date date) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		//判断是否周末
		int dayOfWeek = dateCal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SATURDAY
				|| dayOfWeek == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}
	
	/**
	 * 取得当前系统时间是第几季度
	 * @return -1,异常;1,第一季度;2,第二季度;3,第三季度;4,第四季度
	 */
	public static int getCurrentQuarter() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		switch (month) {
			case 0 : return 1;
			case 1 : return 1;
			case 2 : return 1;
			case 3 : return 2;
			case 4 : return 2;
			case 5 : return 2;
			case 6 : return 3;
			case 7 : return 3;
			case 8 : return 3;
			case 9 : return 4;
			case 10 : return 4;
			case 11 : return 4;
			default : return -1;
		}
	}
	public void testTime(){
		String strarttime = "2010-11-01";
		   String endtime = "2010-12-31";
		   int days = TimeUtils.getBetweenDays(strarttime, endtime);
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   Date dateTime = TimeUtils.getDate(strarttime, "yyyy-MM-dd");
		   Calendar dateCal = Calendar.getInstance();
		   dateCal.setTime(dateTime);
		   int weeknum = 2;
		   for (int i = 1; i <= days+1; i++) {
			   int dayOfWeek = dateCal.get(Calendar.DAY_OF_WEEK);
			   if(weeknum != 1){
				   if (dayOfWeek == Calendar.SUNDAY) {
						i +=  weeknum * 7;
						dateCal.add(Calendar.DATE, weeknum * 7+1);// 将日期设为下一天
						strarttime = df.format(dateCal.getTime());
						continue;
					}
			   }
			   dateCal.add(Calendar.DATE, 1);// 将日期设为下一天
			   strarttime = df.format(dateCal.getTime());
		   }
	
	}
	public static boolean isLastdayByMonth(String currenttime){
		boolean istrue = false;
		Date todate = formatStrToDate(currenttime);
		Date secdate = new   Date(todate.getYear(),todate.getMonth(),todate.getDate()+1);
		istrue = secdate.getDate() < 2 ? true : false;
		return istrue;
	}
	
	/** 
	* 获取指定日期的月份 
	* @param 日期时间的秒
	* @return int   月份 
	*/
	public static int getMonthOfDate(Long dateTime) {
	   java.util.Calendar c = java.util.Calendar.getInstance();
	   c.setTimeInMillis(dateTime*1000);
	   return c.get( java.util.Calendar.MONTH ) + 1;
	}
	
	/** 
	* 获取指定日期的日份 
	* @param 日期时间的秒 
	* @return int   日份 
	*/
	public static int getDayOfDate(Long dateTime) {
	   java.util.Calendar c = java.util.Calendar.getInstance();
	   c.setTimeInMillis(dateTime*1000);
	   return c.get( java.util.Calendar.DAY_OF_MONTH );
	}
	/**
	 * 获取指定日期为周几
	 * @param dateTime
	 * @return
	 */
	public static long getDayOfWeek(Long dateTime) {
	   java.util.Calendar c = java.util.Calendar.getInstance();
	   c.setTimeInMillis( dateTime *1000 );
	   return c.get(java.util.Calendar.DAY_OF_WEEK);
	}
	/** 
	* 获取指定日期的小时 
	* @param p_date util.Date日期 
	* @return int   日份 
	*/
	public static int getHourOfDate( java.util.Date p_date ) {
	   java.util.Calendar c = java.util.Calendar.getInstance();
	   c.setTime( p_date );
	   return c.get( java.util.Calendar.HOUR_OF_DAY );
	}
	
	public static int getMinuteOfDate( java.util.Date p_date ) {
		   java.util.Calendar c = java.util.Calendar.getInstance();
		   c.setTime( p_date );
		   return c.get( java.util.Calendar.MINUTE );
		}

	
	/**
	 * 比较两个日期的前后
	 * @param starts 秒
	 * @param ends 秒
	 * @param format
	 * @return
	 */
	public static boolean after(long starts, long ends, String formats) {
		boolean flag = false;
		try {
			SimpleDateFormat format = new SimpleDateFormat(formats);
			Date start = formatIntToDate(starts);
			Date end = formatIntToDate(ends);
			String startStr = format.format(start);
			String endStr = format.format(end);
			System.out.println("startStr=" + startStr + ",endStr=" + endStr);
			Date tarS = format.parse(startStr);
			Date tarE = format.parse(endStr);
			flag = tarE.after(tarS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
 
	public static int dayToInt(Date date)
	{
		int result=0;
		if(date!=null)
		{
			String strdate=formatShortDateToString(date);
			result=dayToInt(strdate);
		}
		return result;
	}	
	
	public static int dayToInt(String date)
	{
		int result=0;
		if(date!=null)
		{
			date=StringUtils.checkNullString(date).trim();
			String d2=date.replaceAll("-","");
			result=NumberUtils.formatToInt(d2);
		}
		return result;
			
	}
	public static String intToDay(long date)
	{
		String result="";
		if(date>0)
		{
			result=String.valueOf(date) ;
			if(result.length()>=8)
			{
				result=result.substring(0,4)+"-"+result.substring(4,6)+"-"+result.substring(6,8);
			}
		}
		return result;
			
	}
	
	public static String corseDate(long date){
		String result="";
		if(date>0)
		{
			result=String.valueOf(date) ;
			if(result.length()>=8)
			{
				result=result.substring(4,6)+"月"+result.substring(6,8)+"日";
			}
		}
		return result;
	}
	
	public static Date intToDate(long date)
	{
		Date result=null;
		if(date>0)
		{
			String strdate=String.valueOf(date) ;
			if(strdate.length()>=8)
			{
				int intyear=NumberUtils.formatToInt(strdate.substring(0,4));
				int intmonth=NumberUtils.formatToInt(strdate.substring(4,6));
				int intdate=NumberUtils.formatToInt(strdate.substring(6,8));
				Calendar calendar = Calendar.getInstance();
				calendar.set(intyear, intmonth-1, intdate,0,0,0);
				result=calendar.getTime(); 		
			}
		}
		return result;
			
	}	
	
	/**
	 * 获取指定日期 yyyyMMdd
	 * @param date 例如System.currentTimeMillis()/1000这样的格式、10位数
	 * @return
	 */
	public static int dateToInt(long date)
	{
		String datestr = formatIntToDateString(date,"yyyy-MM-dd").replaceAll("-","");
		return Integer.parseInt(datestr);
			
	}	
	
	/**
	 * 根据整型日期计算一年中第几周
	 * @param intdate 整型日期 例如： 20140910
	 * @return
	 */
	public static int getWeeks(int intdate)
	{
		String strdate=intToDay(intdate);
		return getWeeks(strdate);
		
	}
	/**
	 * 根据字符日期计算一年中第几周
	 * @param strdate 字符日期 例如： 2014-09-10
	 * @return
	 */
	public static int getWeeks(String strdate)
	{
		int result=0;
		Date date=getDate(strdate,"yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		result=cal.get(Calendar.WEEK_OF_YEAR);
		return result;
	}
	
	
	
	/**
	 * 
	 * @param date  日期 例如 20140902
	 * @param yearAmount 要加的年份
	 * @param monthAmount 要加的月份
	 * @param dayAmount 要加的天
	 * @return 返回日期  例如 20140905
	 */
	public static int dayAdd(int date, int  yearAmount,int monthAmount,int dayAmount)
	{
		Calendar calendar = Calendar.getInstance();
		if(date>0)
		{
			String day=String.valueOf(date);
			if(day.length()==8)
			{
				Date dateTime = TimeUtils.getDate(String.valueOf(date) , "yyyyMMdd");
				calendar.setTime(dateTime);
			}
			else
			{
				return 0;
			}
		}
		if(yearAmount!=0)
		{
			calendar.add(Calendar.YEAR, yearAmount);
		}
		if(monthAmount!=0)
		{
			calendar.add(Calendar.MONTH, monthAmount);
		}
		if(dayAmount!=0)
		{
			calendar.add(Calendar.DATE, dayAmount);
		}
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");			
		String time=df.format(calendar.getTime());
		return dayToInt(time); 
	}
	
	/**
	 * 偏移到某星期的星期几
	 * @param intdate 输入的日期
	 * @param offset -1向前偏移一周 0不偏移 1 向后偏移一周  
	 * @param weekday 偏移到星期几 Calendar的日期参数 例如 星期一: Calendar.MONDAY
	 * @return
	 * 计算20141007这周的周五的例子：offsetWeekOfDay(20141007,0,Calendar.FRIDAY)
	 */
	public static String  offsetWeekOfDay(int intdate,int offset,int weekday)
	{
		String strdate="";
		if(intdate<1)
		{
			return ""; 
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate(String.valueOf(intdate),"yyyyMMdd" ));
		int curweekday=calendar.get(Calendar.DAY_OF_WEEK);
		int eddate=weekday==Calendar.SUNDAY?7:weekday-1;
		int stdate=curweekday==Calendar.SUNDAY?7:curweekday-1;
		int offsetday=eddate-stdate;//计算偏移的天数

		if(offset<0) 
		{
			offsetday=offsetday-7;
		}
		else if(offset>0)
		{
			offsetday=offsetday+7;
		}
 
		calendar.add(Calendar.DATE, offsetday);
		strdate=formatDateToDateString(calendar.getTime(),"yyyy-MM-dd");
		return strdate;
	}
  
	public static String getCurrentMonthFirstDay(String date)
	{
		Date dateTime = TimeUtils.getDate(String.valueOf(date) , "yyyyMMdd");
		Calendar calendar = Calendar.getInstance();    
		calendar.setTime(dateTime);
		
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");			
		String time=df.format(calendar.getTime());
		return time;
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(TimeUtils.getCurrentMonthFirstDay("20150620"));
		
		//System.out.println(dayAdd(20150301,0,0,-1));
//		System.out.println(TimeUtils.formatIntToDateString("yyyy-MM-dd HH:mm:ss", 1425279613));
	//	System.out.println(TimeUtils.formatDateStringToInt("20150520"));
		
	/*	Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 0, 2);
		System.out.println( formatDateToDateString(intToDate(20150102),"yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatDateToDateString(intToDate(20150102),"MM-dd"));*/
//		int curhour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
		//System.out.println(curhour);
		
		//System.out.println(getWeekOfDate("2015-01-21"));
	//	System.out.println(getWeekOfDate(calendar.getTime()));
		//System.out.print(offsetWeekOfDay(20141027,-1,Calendar.SUNDAY));
		
		//System.out.print(getWeekday("2014-10-09"));
		//System.out.println(dayAdd(20140903,0,1,0));
		//System.out.print( intToDay(20140820));
	/*	String strarttime = "2010-09-08";
		   String endtime = "2010-12-31";
		   int days = TimeUtils.getBetweenDays(strarttime, endtime);
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   Date dateTime = TimeUtils.getDate(strarttime, "yyyy-MM-dd");
		   Calendar dateCal = Calendar.getInstance();
		   dateCal.setTime(dateTime);
		   Calendar timeCal = Calendar.getInstance();
		   int mnnum = 2;
		   boolean istrue = false;
		   for (int i = 1; i <= days+1; i++) {
			   istrue = isLastdayByMonth(strarttime);
			   if(mnnum != 1){
				   if (istrue) {
					   String timeday = strarttime;
					   Date weekTime = TimeUtils.getDate(timeday, "yyyy-MM-dd");
					   timeCal.setTime(weekTime);
					    for(int k = 0;k< mnnum;k++){
					    	i += getData(timeday.substring(0, 7));
					    	timeCal.add(Calendar.MONTH, 1);// 将日期设为一个月
					    	timeday = df.format(timeCal.getTime());
					    }
						dateCal.add(Calendar.MONTH, mnnum);// 将日期设为下一天
						dateCal.add(Calendar.DATE, 1);// 将日期设为下一天
						strarttime = df.format(dateCal.getTime());
						continue;
					}
			   }
			   System.out.println(i);
			   dateCal.add(Calendar.DATE, 1);// 将日期设为下一天
			   strarttime = df.format(dateCal.getTime());
		   }*/
		
		System.out.println(dateToInt(System.currentTimeMillis()/1000));
		System.out.println(formatIntToDateString(1469901600));
	}	
	
	/**
	 * 获取所给date的前day日期   
	 * @user wes
	 * @param day     前几天   整数 是延后   负数是前day的日期
	 * @param date    日期
	 * @param format  返回格式
	 * @return
	 */
	public static String getBeforDay(int day,Date date,String format){
		try {
			Calendar ca = Calendar.getInstance();
			if(date != null){
				ca.setTime(date);
			}
			ca.add(Calendar.DATE, day);
			return formatDateToDateString(ca.getTime(), format);
			
		} catch (Exception e) {
			e.printStackTrace();
			return formatDateToDateString(new Date(), format);
		}
	}
	
	/** 
	* 获取所给date的前day日期   
     * @param day     前几天   整数 是延后   负数是前day的日期
	 * @param date    日期yyyy-MM-dd
	 * @param format  返回格式
	*/ 
	public static String getBeforDay(int day,String date,String format){ 
	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar ca = Calendar.getInstance(); 
	SimpleDateFormat simpleDateFormat;	
	Date parseDate=null; 
	try {
		simpleDateFormat = new SimpleDateFormat(format);		
		parseDate = simpleDateFormat.parse(date);
		ca.setTime(parseDate); 
		ca.add(Calendar.DATE, day);
		return formatDateToDateString(ca.getTime(), format);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return formatDateToDateString(ca.getTime(), format); 
	} 
	
	
	/**
	 * 获取所给date的前month日期   
	 * @user wes
	 * @param month     前几月   整数 是延后   负数是前month的日期
	 * @param date    日期
	 * @param format  返回格式
	 * @return
	 */
	public static String getBeforMonth(int month,Date date,String format){
		try {
			Calendar ca = Calendar.getInstance();
			if(date != null){
				ca.setTime(date);
			}
			ca.add(Calendar.MONTH, month);
			return formatDateToDateString(ca.getTime(), format);			
		} catch (Exception e) {
			e.printStackTrace();
			return formatDateToDateString(new Date(), format);
		}
	}
	/**
	 * 获取所给date的前month月日期
	 * @param month 前几月   整数 是延后   负数是前month的日期
	 * @param date 日期yyyy-MM-dd
	 * @param format
	 * @return
	 */
	public static String getBeforMonthDay(int month,String date,String format){ 
	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar ca = Calendar.getInstance(); 
	SimpleDateFormat simpleDateFormat;	
	Date parseDate=null; 
	try {
		simpleDateFormat = new SimpleDateFormat(format);		
		parseDate = simpleDateFormat.parse(date);
		ca.setTime(parseDate); 
		ca.add(Calendar.MONTH,month);
		return formatDateToDateString(ca.getTime(), format);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return formatDateToDateString(ca.getTime(), format); 
	} 
	
	
	 /**
     * 
     * Created on 2016-4-21 
     * <p>Discription:[把日期转化为字符]</p>
     * @param strDate
     * @param _format
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public static String formatDateToString(Date strDate, String _format)
    {
        SimpleDateFormat format = new SimpleDateFormat(_format, Locale.getDefault());
        try
        {
            String format2 = format.format(strDate);
            return format2;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
   
    /**
     * 把日期转换成Long   
     * @param date
     * @param format   yyyyMMddHHmmss (只能是此类型格式,不能为yyyy-MM-dd HH:mm:ss 类型)
     * @return
     */
    public static Long formatDateToLong(Date date,String format){
    	if(date == null){
    		return 0l;
    	}
    	try{
    		return Long.parseLong(formatDateToString(date, format));
    	}catch (Exception e){
    		throw new RuntimeException(e.getMessage());
    	}
    }
    
    /**
	 * 比较两个字符串时间相差的天数
	 * @param startTime 
	 * @param endTime 
	 * @param _format 日期格式 
	 * @return	如果endTime>startTime返回正整数,否则返回负整数,相等则返回0
	 */
	public static long daysBetween(String startTime, String endTime ,String _format) {
		SimpleDateFormat format = new SimpleDateFormat(_format);
		long distanceDay = 0;
		try {
			if (!StringUtils.checkNullString(startTime).equals("") && !StringUtils.checkNullString(endTime).equals("")) {
				Date startDate = format.parse(startTime);
				Date endDate = format.parse(endTime);
				distanceDay = (endDate.getTime() - startDate.getTime())/(1000*60*60*24);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distanceDay;
	}
	
	/**
	 * 比较两个字符串时间相差的秒数
	 * @param startTime
	 * @param endTime
	 * @param _format  日期格式 
	 * @return
	 */
	public static long secondsBetween(String startTime,String endTime,String _format){
		SimpleDateFormat format = new SimpleDateFormat(_format);
		long distanceSecond = 0;
		try {
			if (!StringUtils.checkNullString(startTime).equals("") && !StringUtils.checkNullString(endTime).equals("")) {
				Date startDate = format.parse(startTime);
				Date endDate = format.parse(endTime);
				distanceSecond = (endDate.getTime() - startDate.getTime())/1000l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distanceSecond;
	}
	
	/**
	 * 比较两个时间戳相差的分钟
	 * @param startTime 开始时间戳
	 * @param endTime	结束时间戳
	 * @return
	 */
	public static long minutesBetween(Long startTime,Long endTime){	
		long distance = 0;
		distance =endTime-startTime;		
		return distance/60; 
	}
	
	
	/**
	 * 将长整型的日期转化为字符型日期字符串
	 * @param intDate 长整型日期
	 * @return pattern 格式
	 */
	public static String formatIntToDate(long intDate,String pattern)
	{
		Date time;
		SimpleDateFormat format;
		String strtime;		
		if (intDate > 0) {
			try {
				long c_unix_time2 = intDate;
				time = new Date();
				time.setTime(c_unix_time2);
				if(pattern!=null)
				{
					format = new SimpleDateFormat(pattern, Locale.getDefault());
				}
				else
				{
					format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
				}
				strtime = format.format(time);
			} catch (Exception ex) {
				strtime = "";
				ex.printStackTrace();
			}
		} else {
			strtime = "";
		}
		return strtime;
	}
	
	public static String validTime(Date d1,Date d2){
		StringBuffer sb = new StringBuffer();
		 long l=d1.getTime()-d2.getTime();
		   long day=l/(24*60*60*1000);
		   long hour=(l/(60*60*1000)-day*24);
		   long min=((l/(60*1000))-day*24*60-hour*60);
		   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		   sb.append(day).append("天").append(hour).append("小时").append(min).append("分").append(s).append("秒");
		   String validtime = sb.toString();
		   if(validtime.contains("-")){
			   validtime="已过期"; 
		   }
		   return validtime;
	}
}
