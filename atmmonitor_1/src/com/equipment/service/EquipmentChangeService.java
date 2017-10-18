package com.equipment.service;

import java.util.List;

import com.equipment.model.Equipment;
import com.equipment.model.EquipmentChange;
import com.statis.contoller.DeptStatisVO;
/**
 * 
 * Created on 2017年6月3日
 * <p>Title:       [项目名称_一级模块名称_模块名称]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>

 * @version        1.0
 */
public interface EquipmentChangeService {

	EquipmentChange selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);

	int insert(EquipmentChange record);

	int insertSelective(EquipmentChange record);

	int updateByPrimaryKeySelective(EquipmentChange record);

	int updateByPrimaryKey(EquipmentChange record);
	
	List<DeptStatisVO> getEquipChangeValueList();

}
