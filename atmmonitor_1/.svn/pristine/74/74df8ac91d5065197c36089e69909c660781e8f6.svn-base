package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsUserType;
public interface BsUserTypeService
{
	public boolean  addBsUserType(BsUserType bsusertype); 
	public boolean  saveOrUpdateBsUserType(BsUserType bsusertype); 
	public boolean  deleteBsUserTypeById(Long pid); 
	public BsUserType  getBsUserTypeById(Long pid); 
	public boolean  deleteBsUserTypeByIds(List<Long> bsUserTypeIdList);
	//验证用户类型id是否存在
	public boolean  pIdExist (long  pid);
	//验证用户类型名称是否存在
	public boolean  userTypeExist (String userType);
	
	//查找所有的用户类型
	public List<BsUserType> findAllUserType();
	
	/**
	 * 根据用户登录名查找用户类型集合
	 * @param loginname
	 * @return
	 */
	public List<BsUserType> selectUserTypeListByLoginname(String loginname);
}
