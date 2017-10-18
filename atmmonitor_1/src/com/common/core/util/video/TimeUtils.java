package com.common.core.util.video;
public class TimeUtils {
	
	public static long Test(String str){
	long t=Integer.parseInt(str.substring(1,3))*60*60+Integer.parseInt(str.substring(4,6))*60+Integer.parseInt(str.substring(7,9));
		System.out.println(t);
		return t;
	}
}