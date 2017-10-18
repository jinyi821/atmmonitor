package com.equipment.dao;

import java.util.List;

import com.equipment.model.Equipment;
import com.statis.contoller.DeptStatisVO;

/**
 * 
 * Created on 2017年6月3日
 * <p>
 * Title: [项目名称_一级模块名称_模块名称]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 

 * @version 1.0
 */
public interface EquipmentMapper {
	
	int deleteByPrimaryKey(Integer id);

	int insert(Equipment record);

	int insertSelective(Equipment record);

	Equipment selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Equipment record);

	int updateByPrimaryKey(Equipment record);
	
	List<Equipment> selectByStatus(Equipment record);
	
	List<DeptStatisVO> getDeptEquipValueList();
	
	
}