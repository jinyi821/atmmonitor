package com.usermanager.manager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsRoleMenu;
import com.usermanager.services.BsRoleMenuService;
@Transactional
@Service(value = "bsRoleMenuService")
public class BsRoleMenuImpl implements BsRoleMenuService
{
	@Autowired
	private IDAO<BsRoleMenu,Long> bsRoleMenuDao;
	public  IDAO<BsRoleMenu,Long> getBsRoleMenuDao()
	{
		return bsRoleMenuDao;
	}
	public  void setBsRoleMenuDao(IDAO<BsRoleMenu,Long> bsRoleMenuDao)
	{
	 	this.bsRoleMenuDao=bsRoleMenuDao;
	}
	 
	public boolean  addBsRoleMenu(BsRoleMenu bsRoleMenu) 
	{
		boolean result=false;
		if(bsRoleMenu!=null)
		{			
			bsRoleMenuDao.save(bsRoleMenu);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsRoleMenu(BsRoleMenu bsRoleMenu)
	{
	  	boolean result=false;
	  	if(bsRoleMenu!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsRoleMenu.getPid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsRoleMenu(bsRoleMenu);
	  		}
	  		else
	  		{
	  			bsRoleMenuDao.saveOrUpdate(bsRoleMenu);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsRoleMenuById(Long bsRoleMenuId) 
	{
	  	boolean result=false;
	  	bsRoleMenuDao.deleteByKey(bsRoleMenuId);
	  	result=true;
	  	return result;
	}
	 
	public BsRoleMenu  getBsRoleMenuById(Long pid) 
	{
		return bsRoleMenuDao.get(pid);
	}
	public boolean  deleteBsRoleMenuByIds(List<Long> bsRoleMenuIdList) 
	{
		int lstLen=bsRoleMenuIdList==null?0:bsRoleMenuIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsRoleMenuById( bsRoleMenuIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteBsRoleMenuByRoleId(String roleid) {
		String hql="delete BsRoleMenu where roleid=?";
		bsRoleMenuDao.bulkUpdate(hql, roleid);
		return true;
	}
	@Override
	public List<BsRoleMenu> findBsRoleMenuByRoleId(String roleid) {
		String hql="from BsRoleMenu where roleid=?";
		List<BsRoleMenu> roleMenuList = new ArrayList<BsRoleMenu>();
		try {
			roleMenuList=bsRoleMenuDao.find(hql, roleid);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleMenuList;
	}
}
