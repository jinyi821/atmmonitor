package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsUserinfo;
import com.usermanager.model.BsUserloginRecord;
public interface BsUserloginRecordService
{
	public boolean  addBsUserloginRecord(BsUserloginRecord bsuserloginrecord); 
	public boolean  saveOrUpdateBsUserloginRecord(BsUserloginRecord bsuserloginrecord); 
	public boolean  deleteBsUserloginRecordById(Long pid); 
	public BsUserloginRecord  getBsUserloginRecordById(Long pid); 
	public boolean  deleteBsUserloginRecordByIds(List<Long> bsUserloginRecordIdList);
	
	//添加用户登录日志
	public void addBsUserloginRecord(String loginname,Integer issuccess);
	
	/**
	 * 读取最后二次登录日志
	 * @param loginname
	 * @return
	 */
    List<BsUserloginRecord> getLastBsUserloginRecordByloginname(String loginname);
    
    /**
     * 当前已经登录是否超过三个月没有登录
     * @param month
     * @param bsUserinfoByLoginname
     * @return
     */
    public Boolean isOverMonthLogin(Integer month, BsUserinfo bsUserinfoByLoginname);
    
    /**
     * 处理三个月未登录用户
     */
    public void process();
}
