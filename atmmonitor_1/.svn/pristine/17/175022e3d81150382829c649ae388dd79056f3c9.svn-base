package com.example.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.TestUserMapper;
import com.example.model.TestUser;
import com.example.services.UserServices;

@Service("UserServiceHibernateImpl")
@Transactional(value="txManager")
public class UserServiceHibernateImpl implements UserServices{
	
    @Resource(name="TestUserHibernateDaoImpl")
	private TestUserMapper testUserMapper;
    
	@Override
	public Integer addUser(TestUser user) {
		testUserMapper.insert(user);
		return null;
	}

	@Override
	public TestUser get(Integer id) {
		return testUserMapper.selectByPrimaryKey(id);
		
	}

}
