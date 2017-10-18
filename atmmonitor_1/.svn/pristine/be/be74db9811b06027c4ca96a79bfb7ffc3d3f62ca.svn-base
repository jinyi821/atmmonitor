package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsUserRole;
public interface BsUserRoleService
{
	public boolean  addBsUserRole(BsUserRole bsuserrole); 
	public boolean  saveOrUpdateBsUserRole(BsUserRole bsuserrole); 
	public boolean  deleteBsUserRoleById(Long pid); 
	public BsUserRole  getBsUserRoleById(Long pid); 
	public boolean  deleteBsUserRoleByIds(List<Long> bsUserRoleIdList);
    /**
    * 根据用户登录名删除用户角色
    * @param loginname
    * @return
    */
	public boolean deleteBsUserRoleByLoginname(String loginname);
	/**
	 * 根据用户登录名判断用户是否拥有管理员角色
	 * @param loginname 用户登录名
	 * @return
	 */
	public boolean judgeAdminRoleByLoginname(String loginname);
	/**
	 * 获取具有管理员角色的用户登录名
	 * @return
	 */
	public List<String> getAdminRoleLoginnames();
	List<BsUserRole> getUserRoleByRole(String roleid);	
}
