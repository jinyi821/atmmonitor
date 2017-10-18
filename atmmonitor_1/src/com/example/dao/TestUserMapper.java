package com.example.dao;

import com.example.model.TestUser;

public interface TestUserMapper {
	
    int deleteByPrimaryKey(Integer userid);

	int insert(TestUser record);

	int insertSelective(TestUser record);

	TestUser selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(TestUser record);

	int updateByPrimaryKey(TestUser record);


}