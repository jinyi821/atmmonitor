package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.TestUser;
import com.example.services.UserServices;

/**
 * 
 * Created on 2017年4月18日
 * <p>Title:       [项目名称_一级模块名称_模块名称]</p>
 * <p>Description: [示例用两种ORM(mybatis和hibernate) 框架对比实现]</p>
 * <p>Copyright:   Copyright (c) 2016</p>


 * @version        1.0
 */
@Controller
@RequestMapping(value = "/example/getUser.action")
public class UserController {

	@Resource(name="UserServiceImpl")
	private UserServices userServices; //注入mybatis service实现 
	
	@Resource(name="UserServiceHibernateImpl")
	private UserServices userServices1; //注入hibernate service实现

	@RequestMapping(value = "/getUser.action", method = RequestMethod.GET)
	@ResponseBody
	public TestUser getUser() {
		Integer id = 1;
		TestUser testUser = userServices.get(id);
		return testUser;
	}

	@RequestMapping(value = "/insertUser.action", method = RequestMethod.GET)
	@ResponseBody
	public TestUser insertUser() {

		TestUser testUser = new TestUser();
		testUser.setUserid(19);
		testUser.setUsername("uming");
		testUser.setPwd("222");
		userServices.addUser(testUser);
		return testUser;
	}
	
	@RequestMapping(value = "/getUser1.action", method = RequestMethod.GET)
	@ResponseBody
	public TestUser getUser1() {
		Integer id = 2;
		TestUser testUser = userServices1.get(id);
		return testUser;
	}

	@RequestMapping(value = "/insertUser1.action", method = RequestMethod.GET)
	@ResponseBody
	public TestUser insertUser1() {

		TestUser testUser = new TestUser();
		testUser.setUserid(20);
		testUser.setUsername("uming");
		testUser.setPwd("222");
		userServices1.addUser(testUser);
		return testUser;
	}

}
