package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.TestItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "itemDao")
public interface TestItemDao {
    
    int deleteByPrimaryKey(Integer itemId);

    int insert(TestItem record);

    int insertSelective(TestItem record);

    TestItem selectByPrimaryKey(Integer itemId);

    TestItem selectByPhone(String phone);

    int updateByPrimaryKeySelective(TestItem record);

    int updateByPrimaryKey(TestItem record);

    List<TestItem> selectAllItem();
}