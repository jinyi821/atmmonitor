package com.example.services.impl;

import org.springframework.stereotype.Service;

@Service("demoWebService")
public class DemoWebServiceImpl {
	
	public String sayHello(String name) {
		return "Hello， " + name + ".";
	}

	public String getWorld() {
		return "Hello,World";
	}

}
