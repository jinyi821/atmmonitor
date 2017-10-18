package com.usermanager.manager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsRole;
import com.usermanager.services.BsRoleService;
@Transactional
@Service(value = "bsRoleService")
public class BsRoleImpl implements BsRoleService
{
	@Autowired
	private IDAO<BsRole,String> bsRoleDao;
	public  IDAO<BsRole,String> getBsRoleDao()
	{
		return bsRoleDao;
	}
	public  void setBsRoleDao(IDAO<BsRole,String> bsRoleDao)
	{
	 	this.bsRoleDao=bsRoleDao;
	}
	 
	public boolean  addBsRole(BsRole bsRole) 
	{
		boolean result=false;
		if(bsRole!=null)
		{
			bsRole.setCreatetime(System.currentTimeMillis()/1000);
			bsRoleDao.save(bsRole);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsRole(BsRole bsRole)
	{
	  	boolean result=false;
	  	if(bsRole!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsRole.getRoleid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsRole(bsRole);
	  		}
	  		else
	  		{
	  			bsRoleDao.saveOrUpdate(bsRole);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsRoleById(String bsRoleId) 
	{
	  	boolean result=false;
	  	bsRoleDao.deleteByKey(bsRoleId);
	  	result=true;
	  	return result;
	}
	 
	public BsRole  getBsRoleById(String pid) 
	{
		return bsRoleDao.get(pid);
	}
	public boolean  deleteBsRoleByIds(List<String> bsRoleIdList) 
	{
		int lstLen=bsRoleIdList==null?0:bsRoleIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsRoleById( bsRoleIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public boolean roleIdExist(String roleid) {
		boolean flag=false;		
		try {
			List<BsRole> list= bsRoleDao.find("from  BsRole where roleid=?",roleid);
			int lens=list==null?0:list.size();
			if(lens>0)
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public BsRole getBsRoleByRoleId(String roleid) {
		BsRole bsRole = null;
		List<BsRole> list;
		try {
			list = bsRoleDao.find("from  BsRole where roleid=?",roleid);
			int lens=list==null?0:list.size();
			if(lens>0)
			{
				bsRole=list.get(0);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bsRole;
	}
	@Override
	public boolean deleteBsRoleByRoleId(String roleid) {
		String hql="delete BsRole where roleid=?";
		bsRoleDao.bulkUpdate(hql, roleid);
		return true;
	}
	@Override
	public List<BsRole> findAllRole() {
		String hql="from  BsRole";
		List<BsRole>  roleList=new ArrayList<BsRole>();
		try {
			roleList=bsRoleDao.find(hql,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}
	@Override
	public List<BsRole> selectUserRoleList(String loginname) {
		List<BsRole> userRoleList=new ArrayList<BsRole>();
		String hql="select new BsRole(role.roleid,role.rolename) from BsRole role,BsUserRole userrole where role.roleid=userrole.roleid and userrole.loginname=?";
		try {
			 userRoleList=bsRoleDao.find(hql, loginname);
			return userRoleList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRoleList;
	}	
}
