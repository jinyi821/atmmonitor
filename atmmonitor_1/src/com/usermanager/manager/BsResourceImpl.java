package com.usermanager.manager;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsResource;
import com.usermanager.services.BsResourceService;
@Transactional
@Service("bsResourceService")
public class BsResourceImpl implements BsResourceService
{
	private IDAO<BsResource,Integer> bsResourceDao;
	public  IDAO<BsResource,Integer> getBsResourceDao()
	{
		return bsResourceDao;
	}
	public  void setBsResourceDao(IDAO<BsResource,Integer> bsResourceDao)
	{
	 	this.bsResourceDao=bsResourceDao;
	}
	 
	public boolean  addBsResource(BsResource bsResource) 
	{
		boolean result=false;
		if(bsResource!=null)
		{
		
			bsResource.setCreatetime(System.currentTimeMillis()/1000);
			bsResourceDao.save(bsResource);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsResource(BsResource bsResource)
	{
	  	boolean result=false;
	  	if(bsResource!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsResource.getPid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsResource(bsResource);
	  		}
	  		else
	  		{
	  			bsResource.setLastmodifytime(System.currentTimeMillis()/1000);
	  			bsResourceDao.saveOrUpdate(bsResource);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsResourceById(Integer bsResourceId) 
	{
	  	boolean result=false;
	  	bsResourceDao.deleteByKey(bsResourceId);
	  	result=true;
	  	return result;
	}
	 
	public BsResource  getBsResourceById(Integer pid) 
	{
		return bsResourceDao.get(pid);
	}
	public boolean  deleteBsResourceByIds(List<Integer> bsResourceIdList) 
	{
		int lstLen=bsResourceIdList==null?0:bsResourceIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsResourceById( bsResourceIdList.get(i)))
			return false;
		}
		return true;
	}
}
