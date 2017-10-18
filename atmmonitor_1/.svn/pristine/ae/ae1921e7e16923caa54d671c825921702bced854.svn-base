package com.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.TestUserMapper;
import com.example.model.TestUser;

@Repository("TestUserHibernateDaoImpl")
public class TestUserHibernateDaoImpl implements TestUserMapper {
	
	@Autowired
	private org.springframework.orm.hibernate4.HibernateTemplate  hibernateTemplate;
	
	@Override
	public int deleteByPrimaryKey(Integer userid) {
		
		return 0;
	}

	@Override
	public int insert(TestUser record) {
		
		hibernateTemplate.save(record);
		
		return 0;
	}

	@Override
	public int insertSelective(TestUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestUser selectByPrimaryKey(Integer userid) {
		return hibernateTemplate.get(TestUser.class, userid);
		
	}

	@Override
	public int updateByPrimaryKeySelective(TestUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TestUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
