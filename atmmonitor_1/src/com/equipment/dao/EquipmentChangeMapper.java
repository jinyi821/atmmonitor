package com.equipment.dao;

import java.util.List;

import com.equipment.model.EquipmentChange;
import com.statis.contoller.DeptStatisVO;

public interface EquipmentChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentChange record);

    int insertSelective(EquipmentChange record);

    EquipmentChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentChange record);

    int updateByPrimaryKey(EquipmentChange record);
    List<DeptStatisVO> getEquipChangeValueList();
}