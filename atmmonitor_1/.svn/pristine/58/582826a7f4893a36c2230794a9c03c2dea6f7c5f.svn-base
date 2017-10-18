package com.common.constants;

import java.io.IOException;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtils {
	public static String getProperty(String name) {
		String result = null;
		java.util.Properties props;
		try {
			props = PropertiesLoaderUtils.loadAllProperties("security.properties");
			result = props.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
