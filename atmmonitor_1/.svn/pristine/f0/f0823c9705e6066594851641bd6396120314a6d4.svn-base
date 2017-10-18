package com.common.startup;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * Created on 2016年11月23日
 * <p>Title:       [项目名称_一级模块名称_模块名称]</p>
 * <p>Description: [监控登录会话]</p>
 * <p>Copyright:   Copyright (c) 2016</p>

 
 * @version        1.0
 */
public class OnlineUserListener implements HttpSessionListener {
	private Long sessionBeginTime=0L;
    public void sessionCreated(HttpSessionEvent event) {
     	sessionBeginTime=System.currentTimeMillis();
     }
 
    public void sessionDestroyed(HttpSessionEvent event) {

         Long aa=(System.currentTimeMillis() -sessionBeginTime) /(60*1000);
         System.out.println("会话时间"+aa+"分钟后，失效。");
     }
 
}