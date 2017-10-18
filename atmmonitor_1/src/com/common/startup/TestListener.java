package com.common.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 

public class TestListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
	
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		System.out.println("===="+System.getProperty("java.runtime.version")+"===="); 
		System.out.println("===="+System.getProperty("java.class.version")+"====");
		init();
	}

	private void init()
	{
		
	}
	
	

	
}
