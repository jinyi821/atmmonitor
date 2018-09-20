package com.ultrapower.dcs.cluster.control;

import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ultrapower.dcs.cluster.control.dao")//将项目中对应的mapper类的路径加进来就可以了
public class ClusterControlApplication {
	public static void main(String[] args) {
		PropertiesUtils.init();
		SpringApplication.run(ClusterControlApplication.class, args);
	}
}
