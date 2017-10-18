package com.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.TestUserMapper;
import com.example.model.TestUser;

@Repository("TestUserDaoImpl")
public class TestUserDaoImpl implements TestUserMapper {
	
	@Autowired
	private org.mybatis.spring.SqlSessionTemplate sqlSession;
	
	
	
	
	@Override
	public int deleteByPrimaryKey(Integer userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TestUser record) {
		
		sqlSession.insert("insert", record);
		
		return 0;
	}

	@Override
	public int insertSelective(TestUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestUser selectByPrimaryKey(Integer userid) {
		// TODO Auto-generated method stub
		return null;
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
