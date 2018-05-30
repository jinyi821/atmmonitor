package com.ultrapower.clustercontrol.dao;

import com.ultrapower.clustercontrol.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "itemDao")
public interface ItemDao {
    
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    Item selectByPhone(String phone);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectAllItem();
}