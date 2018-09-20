package com.ultrapower.dcs.cluster.control.utils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * @ClassName:com.ultrapower.dcs.cluster.control.tools.PropertiesUtils
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年6月5日 下午2:45:40
 * @version 1.0
 */
public class PropertiesUtils {	 
	 private static Properties props;

	  public static void init()
	  {
	    InputStream stream = null;
	    try {
	      stream = PropertiesUtils.class.getResourceAsStream("/config.properties");
	      props = new Properties();
	      props.load(stream);
	    } catch (Exception e) {
	    }
	  }

	  public static String getProperty(String name)
	  {
	    if (props != null) {
	      //System.out.println(name + ":" + props.getProperty(name));
	     /* for (Iterator localIterator = props.keySet().iterator(); localIterator.hasNext(); ) {
			Object object = localIterator.next();
			System.out.println("object:"+object);
	      }*/
	      return props.getProperty(name);
	    }
	    //System.out.println("------" + name);
	    return null;
	  }
}
