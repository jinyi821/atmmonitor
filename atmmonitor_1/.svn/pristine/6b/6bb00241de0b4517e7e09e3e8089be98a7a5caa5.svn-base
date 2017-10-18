package com.usermanager.manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsUserRole;
import com.usermanager.services.BsUserRoleService;
@Transactional
@Service("bsUserRoleService")
public class BsUserRoleImpl implements BsUserRoleService
{
	@Autowired
	private IDAO<BsUserRole,Long> bsUserRoleDao;
	public  IDAO<BsUserRole,Long> getBsUserRoleDao()
	{
		return bsUserRoleDao;
	}
	public  void setBsUserRoleDao(IDAO<BsUserRole,Long> bsUserRoleDao)
	{
	 	this.bsUserRoleDao=bsUserRoleDao;
	}
	 
	public boolean  addBsUserRole(BsUserRole bsUserRole) 
	{
		boolean result=false;
		if(bsUserRole!=null)
		{
			//bsUserRole.setCreatetime(System.currentTimeMillis()/1000);
			bsUserRoleDao.save(bsUserRole);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsUserRole(BsUserRole bsUserRole)
	{
	  	boolean result=false;
	  	if(bsUserRole!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsUserRole.getPid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsUserRole(bsUserRole);
	  		}
	  		else
	  		{
	  			bsUserRoleDao.saveOrUpdate(bsUserRole);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsUserRoleById(Long bsUserRoleId) 
	{
	  	boolean result=false;
	  	bsUserRoleDao.deleteByKey(bsUserRoleId);
	  	result=true;
	  	return result;
	}
	 
	public BsUserRole  getBsUserRoleById(Long pid) 
	{
		return bsUserRoleDao.get(pid);
	}
	public boolean  deleteBsUserRoleByIds(List<Long> bsUserRoleIdList) 
	{
		int lstLen=bsUserRoleIdList==null?0:bsUserRoleIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsUserRoleById( bsUserRoleIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteBsUserRoleByLoginname(String loginname) {
		String hql="delete BsUserRole where loginname=?";
		bsUserRoleDao.bulkUpdate(hql,loginname);
		return true;
	}
	@Override
	public boolean judgeAdminRoleByLoginname(String loginname) {
		boolean flag=false;
		String hql="from  BsUserRole where roleid=1 and loginname=?";
		try {
			Integer size=bsUserRoleDao.find(hql, loginname).size();
			if(size>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<BsUserRole> getUserRoleByRole(String roleid) {
		boolean flag=false;
		
		String hql=" from  BsUserRole where roleid=?";
		try {
			List<BsUserRole> find = bsUserRoleDao.find(hql, roleid);
			return find;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<String> getAdminRoleLoginnames() {
		String hql="select distinct loginname from  BsUserRole where roleid=1";
		List adminList = null;
		try {
			adminList=bsUserRoleDao.find(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return adminList;
	}	
}
