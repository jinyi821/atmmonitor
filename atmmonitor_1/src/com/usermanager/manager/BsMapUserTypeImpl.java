package com.usermanager.manager;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsMapUserType;
import com.usermanager.services.BsMapUserTypeService;
@Transactional
@Service("bsMapUserTypeService")
public class BsMapUserTypeImpl implements BsMapUserTypeService
{
	private IDAO<BsMapUserType,Integer> bsMapUserTypeDao;
	public  IDAO<BsMapUserType,Integer> getBsMapUserTypeDao()
	{
		return bsMapUserTypeDao;
	}
	public  void setBsMapUserTypeDao(IDAO<BsMapUserType,Integer> bsMapUserTypeDao)
	{
	 	this.bsMapUserTypeDao=bsMapUserTypeDao;
	}
	 
	public boolean  addBsMapUserType(BsMapUserType bsMapUserType) 
	{
		boolean result=false;
		if(bsMapUserType!=null)
		{
			
			bsMapUserType.setCreatetime(System.currentTimeMillis()/1000);
			bsMapUserTypeDao.save(bsMapUserType);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsMapUserType(BsMapUserType bsMapUserType)
	{
	  	boolean result=false;
	  	if(bsMapUserType!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsMapUserType.getPid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsMapUserType(bsMapUserType);
	  		}
	  		else
	  		{
	  			bsMapUserTypeDao.saveOrUpdate(bsMapUserType);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsMapUserTypeById(Integer bsMapUserTypeId) 
	{
	  	boolean result=false;
	  	bsMapUserTypeDao.deleteByKey(bsMapUserTypeId);
	  	result=true;
	  	return result;
	}
	 
	public BsMapUserType  getBsMapUserTypeById(Integer pid) 
	{
		return bsMapUserTypeDao.get(pid);
	}
	public boolean  deleteBsMapUserTypeByIds(List<Integer> bsMapUserTypeIdList) 
	{
		int lstLen=bsMapUserTypeIdList==null?0:bsMapUserTypeIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsMapUserTypeById( bsMapUserTypeIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteBsMapUserTypeByLoginname(String loginname) {
		String hql="delete BsMapUserType where loginname=? ";
		bsMapUserTypeDao.bulkUpdate(hql, loginname);
		return true;
	}
}
