package com.common.core.component.rquery.startup;

import java.io.File;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.common.core.component.rquery.util.RConstants;

public class Services implements ServletContextListener{
	
	
	 

	 private  String getClassPath(String resourceName)
	{
		 
		Assert.notNull(resourceName, "Resource name must not be null");
		ClassLoader clToUse = ClassUtils.getDefaultClassLoader();
		URL url = (URL) clToUse.getResource("security.properties");
		return "/" + url.getPath();
		
		 //return this.getClass().getResource("/").getPath();
		    
/*		    Properties properties = new Properties();
		    Enumeration urls = clToUse.getResources(resourceName);
		    while (urls.hasMoreElements()) {
		      URL url = (URL)urls.nextElement();
		      InputStream is = null;
		      try {
		        URLConnection con = url.openConnection();
		        
		        con.setUseCaches(false);
		        is = con.getInputStream();
		        properties.load(is);
		      }
		      finally {
		        if (is != null) {
		          is.close();
		        }
		      }
		    }
		    return properties;*/
	}
		  
	public void contextInitialized(ServletContextEvent ctxEvt)
	{ 
 
		String path=getClassPath("security.properties");
		int clsLen=path.indexOf("classes");
		path=path.substring(1,clsLen-1);
		RConstants.xmlPath=path+File.separator+"classes"+File.separatorChar+"sqlconfig";
		System.out.println("RConstants.xmlPath:"+RConstants.xmlPath);
		
		StartUp.loadFile(RConstants.xmlPath);
		
	}
	public void contextDestroyed(ServletContextEvent ctxEvt) 
	{ 
		
	}
	

}
