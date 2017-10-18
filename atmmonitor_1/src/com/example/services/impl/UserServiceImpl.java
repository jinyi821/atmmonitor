package com.example.services.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.TestUserMapper;
import com.example.model.TestUser;
import com.example.services.UserServices;

@Service("UserServiceImpl")
@Transactional(value="transactionManager")
public class UserServiceImpl  implements UserServices{

	@Autowired
	private TestUserMapper testUserMapper;
	
	@Resource(name="TestUserDaoImpl")
	private TestUserMapper testUserMapper1;
	
	public Integer addUser(TestUser user) {
		testUserMapper.insert(user);
		//testUserMapper1.insert(user);
		return null;
	}

	
	public TestUser get(Integer id) {
		
		return testUserMapper.selectByPrimaryKey(id);
	}

	
}