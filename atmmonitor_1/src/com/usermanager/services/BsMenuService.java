package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsMenu;
public interface BsMenuService
{
	public boolean  addBsMenu(BsMenu bsmenu); 
	public boolean  saveOrUpdateBsMenu(BsMenu bsmenu); 
	public boolean  deleteBsMenuById(Integer pid); 
	public BsMenu  getBsMenuById(Integer pid); 
	public boolean  deleteBsMenuByIds(List<Integer> bsMenuIdList);
	//获取该菜单下的子菜单
	public List<BsMenu> findChlidMenuByParentId(Integer parentid);
	//获取该菜单下的菜单状态为可用的子菜单
	public List<BsMenu> findUseChlidMenuByParentId(Integer parentid);
	
	
}
