package com.usermanager.manager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsDep;
import com.usermanager.model.BsUserDep;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsUserDepService;
import com.usermanager.services.BsUserinfoService;
@Transactional
@Service("bsUserDepService")
public class BsUserDepImpl implements BsUserDepService
{
	@Autowired
	private IDAO<BsUserDep,Integer> bsUserDepDao;
	@Resource
	private BsUserinfoService bsUserinfoService;
	@Resource
	private BsDepService bsDepService;
	
	public  IDAO<BsUserDep,Integer> getBsUserDepDao()
	{
		return bsUserDepDao;
	}
	public  void setBsUserDepDao(IDAO<BsUserDep,Integer> bsUserDepDao)
	{
	 	this.bsUserDepDao=bsUserDepDao;
	}
	 
	public boolean  addBsUserDep(BsUserDep bsUserDep) 
	{
		boolean result=false;
		if(bsUserDep!=null)
		{
			bsUserDep.setCreatetime(System.currentTimeMillis()/1000);
			bsUserDepDao.save(bsUserDep);
			result=true;
		}
		return result;
	}
	 
	public boolean  saveOrUpdateBsUserDep(BsUserDep bsUserDep)
	{
	  	boolean result=false;
	  	if(bsUserDep!=null)
	  	{
	  		String pid=StringUtils.checkNullString(bsUserDep.getPid()).trim();
	  		if(pid.equals(""))
	  		{
	  			result=this.addBsUserDep(bsUserDep);
	  		}
	  		else
	  		{
	  			bsUserDep.setLastmodifytime(System.currentTimeMillis()/1000);
	  			bsUserDepDao.saveOrUpdate(bsUserDep);
	  			result=true;
	  		}
	  	}
	  	return result;
	}
	 
	public boolean  deleteBsUserDepById(Integer pid) 
	{
	  	boolean result=false;
	  	BsUserDep  bsUserDep=bsUserDepDao.get(pid);
	  	String loginname=bsUserDep.getLoginname();
	  	bsUserDepDao.deleteByKey(pid);
	  	this.maintenUserDepMap(loginname);  	
	  	result=true;
	  	return result;
	}
	 
	public BsUserDep  getBsUserDepById(Integer pid) 
	{
		return bsUserDepDao.get(pid);
	}
	public boolean  deleteBsUserDepByIds(List<Integer> bsUserDepIdList) 
	{
		int lstLen=bsUserDepIdList==null?0:bsUserDepIdList.size();
		for (int i = 0; i < lstLen; i++)
		{
			if (!this.deleteBsUserDepById( bsUserDepIdList.get(i)))
			return false;
		}
		return true;
	}
	@Override
	public boolean findUserDepExist(String loginname, String depid) {
			String hql = " from  BsUserDep where loginname=? and depid=?";
			try {
				List<BsUserDep> list = bsUserDepDao.find(hql, loginname,depid);
				int len = list == null ? 0 : list.size();
				if (len > 0) {
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
	@Override
	public void deleteBsUserDepByLoinname(String loginname) {
		String hql="delete BsUserDep where loginname=?";
		bsUserDepDao.bulkUpdate(hql, loginname);		
	}
	@Override
	public void deleteBsUserDepByDepid(String depid) {
		String hql="delete BsUserDep where depid=?";
		bsUserDepDao.bulkUpdate(hql, depid);		
	}
	
	@Override
	public List<BsUserDep> selectUserDepMapListByLoginname(String loginname) {
		List<BsUserDep> userDepMapList=new ArrayList<BsUserDep>();
		String hql="from BsUserDep where  loginname=?";
		try {
			userDepMapList=bsUserDepDao.find(hql, loginname);
			return userDepMapList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDepMapList;
	}	
	@Override
	public List<BsUserDep> selectUserDepMapListByDepid(String depid) {
		List<BsUserDep> userDepMapList=new ArrayList<BsUserDep>();
		String hql="from BsUserDep where depid=?";
		try {
			userDepMapList=bsUserDepDao.find(hql, depid);
			return userDepMapList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDepMapList;
	}
	@Override
	public void maintenUserDepMap(String loginname) {
		List<BsUserDep> userDepMapList=this.selectUserDepMapListByLoginname(loginname);
		int userDepMapSize=userDepMapList.size();
		StringBuilder userDepId=new StringBuilder(); 
        StringBuilder userDepName=new StringBuilder();
		for(int i=0;i<userDepMapSize;i++){
			BsUserDep userdep=userDepMapList.get(i);
			String depid=userdep.getDepid();
			BsDep dep=bsDepService.getBsDepById(depid);       		
       		String depname = null;
       		if(dep!=null){
       			depname=dep.getDepfullname();
       		}
       		if(i<userDepMapSize-1){
       			userDepId.append(depid+","); 
       			if(depname!=null){
       			userDepName.append(depname+" ");
       			}
       		}else{
       			userDepId.append(depid);
       			if(depname!=null){
       		    userDepName.append(depname);  
       			}
       		}			
		}
		bsUserinfoService.updateBsUserInfoDep(loginname, userDepId.toString(),userDepName.toString()); 
	}
	@Override
	public void operateUserDep(Map<String, List<String>> userdepMap, String operator) {
		Iterator iter = userdepMap.entrySet().iterator();
		while(iter.hasNext()){		 
	            Entry element = (Entry) iter.next(); 
	            String  loginname = (String) element.getKey();
	            List<String> depidList=(List<String>) element.getValue();
	            int depidSize=depidList.size();
	            this.deleteBsUserDepByLoinname(loginname);  
	            StringBuilder userDepId=new StringBuilder(); 
	            StringBuilder userDepName=new StringBuilder(); 
	    		for(int i=0;i<depidSize;i++){	    		
	    		 BsUserDep userdep=new BsUserDep();
	        		userdep.setLoginname(loginname);
	        		userdep.setDepid(depidList.get(i));
	        		userdep.setRelatetype("1");
	        		userdep.setCreater(operator);
	        		userdep.setCreatetime(System.currentTimeMillis()/1000);
	        		this.addBsUserDep(userdep);	
	        		BsDep dep=bsDepService.getBsDepById(depidList.get(i));       		
	           		String depname = null;
	           		if(dep!=null){
	           			depname=dep.getDepfullname();
	           		}
	           		if(i<depidSize-1){
	           			userDepId.append(depidList.get(i)+","); 
	           			if(depname!=null){
	           			userDepName.append(depname+" ");
	           			}
	           		}else{
	           			userDepId.append(depidList.get(i));
	           			if(depname!=null){
	           		  userDepName.append(depname);  
	           			}
	           		}	        		
	    		}	
	    		bsUserinfoService.updateBsUserInfoDep(loginname, userDepId.toString(),userDepName.toString());         
		}    		
	}	
}
