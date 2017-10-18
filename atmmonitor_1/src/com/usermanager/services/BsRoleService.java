package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsRole;
public interface BsRoleService
{
	public boolean  addBsRole(BsRole bsrole); 
	public boolean  saveOrUpdateBsRole(BsRole bsrole); 
	public boolean  deleteBsRoleById(String pid); 
	public BsRole  getBsRoleById(String pid); 
	public boolean  deleteBsRoleByIds(List<String> bsRoleIdList);
	//验证角色id是否存在
	public boolean  roleIdExist (String  roleid); 
	//根据角色id获取角色
	public BsRole  getBsRoleByRoleId(String  roleid);
	//根据角色id删除角色
	public boolean  deleteBsRoleByRoleId(String roleid); 
	//查找所有的角色
	public List<BsRole> findAllRole();
	/**
	 * 根据用户登录名查找用户角色集合
	 * @param loginname
	 * @return
	 */
	public List<BsRole> selectUserRoleList(String loginname);
	
}
