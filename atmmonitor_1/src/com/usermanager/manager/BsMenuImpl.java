package com.usermanager.manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsMenu;
import com.usermanager.services.BsMenuService;
@Transactional
@Service(value = "bsMenuService")
public class BsMenuImpl implements BsMenuService
{
	@Autowired
	private IDAO<BsMenu,Integer> bsMenuDao;

	 
	public IDAO<BsMenu, Integer> getBsMenuDao() {
		return bsMenuDao;
	}

	public void setBsMenuDao(IDAO<BsMenu, Integer> bsMenuDao) {
		this.bsMenuDao = bsMenuDao;
	}

	public boolean  addBsMenu(BsMenu bsMenu) 
	{
		boolean result=false;
		if(bsMenu!=null)
		{
			if(bsMenu.getStatus()==null)
			{
				bsMenu.setStatus(1);
			}
			bsMenu.setCreatetime(System.currentTimeMillis()/1000);
			bsMenuDao.save(bsMenu);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsMenu(BsMenu bsMenu)
	{
	  	boolean result=false;
	  	if(bsMenu!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsMenu.getMenuid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsMenu(bsMenu);
	  		}
	  		else
	  		{
	  			bsMenuDao.saveOrUpdate(bsMenu);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsMenuById(Integer bsMenuId) 
	{
	  	boolean result=false;
	  	bsMenuDao.deleteByKey(bsMenuId);
	  	result=true;
	  	return result;
	}
	 
	public BsMenu  getBsMenuById(Integer pid) 
	{
		return bsMenuDao.get(pid);
	}
	public boolean  deleteBsMenuByIds(List<Integer> bsMenuIdList) 
	{
		int lstLen=bsMenuIdList==null?0:bsMenuIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsMenuById( bsMenuIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public List<BsMenu> findChlidMenuByParentId(Integer parentid) {
		
			List<BsMenu> list =null;
			try {
				if(parentid==null){
					 list =  bsMenuDao.find("from BsMenu where parentid is NULL");					
				}else{
					 list =  bsMenuDao.find("from BsMenu where parentid = ?", parentid);					
				}							
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	
	}
	@Override
	public List<BsMenu> findUseChlidMenuByParentId(Integer parentid) {
		
			List<BsMenu> list =null;
			try {
				if(parentid==null){
					 list =  bsMenuDao.find("from BsMenu where status=1 and parentid is NULL");					
				}else{
					 list =  bsMenuDao.find("from BsMenu where status=1 and parentid = ?", parentid);					
				}							
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	
	}
	
}
