package com.common.startup;

import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.common.core.util.WebApplicationManager;
 

public class WebApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
	
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		ServletContext servletContext=arg0.getServletContext();
		WebApplicationManager.servletContext=servletContext;
		init();
	}

	private void init()
	{
		
	}
	private  String getClassPath(String resourceName)
	{
		Assert.notNull(resourceName, "Resource name must not be null");
		ClassLoader clToUse = ClassUtils.getDefaultClassLoader();
		URL url = (URL) clToUse.getResource(resourceName);
		return "/" + url.getPath();		
     }
	

	
}
