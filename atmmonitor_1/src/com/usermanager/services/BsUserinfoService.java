package com.usermanager.services;
import java.util.List;
import java.util.Map;

import com.usermanager.model.BsUserinfo;
public interface BsUserinfoService
{
	public boolean  addBsUserinfo(BsUserinfo bsuserinfo); 
	public boolean  saveOrUpdateBsUserinfo(BsUserinfo bsuserinfo); 
	public boolean  deleteBsUserinfoById(String loginname); 
	public BsUserinfo  getBsUserinfoById(String loginname); 
	public boolean  deleteBsUserinfoByIds(List<String> bsUserinfoIdList);
	//根据登录名获得用户
	public BsUserinfo  getBsUserinfoByLoginname(String loginname); 
	//验证登录名是否重复
	public boolean  loginnameExist(String  loginname); 
	//根据登录名删除用户
	public boolean  deleteBsUserinfoByLoignname(String loginname); 
	
	/**
	 * 操作用户
	 * @param operation 0 新增 1修改 2删除 
	 * @param bsuserinfo 用户基本信息	 
	 * @param userroleids 用户角色id集合
	 * @param usertypeids 用户类型id集合  1数据分析师 2开发者
	 * @param userdepids  用户部门id集合
	 * @param operator   操作者,取当前登录用户的登录名
	 * @return
	 */
	public boolean  operateBsUserinfo(int operation,BsUserinfo bsUserinfo,String[] userroleids,Integer[] usertypeids,String[] userdepids,String operator); 
    /**
     * 修改用户密码
     * @param loginname 用户登录名
     * @param pwd 用户密码
     * @return
     */
	public boolean  updateBsUserinfoPwd(String loginname,String pwd);
	/**
	 *修改用户表中用户部门id、用户部门名称数据
	 * @param loginname 用户登录名
	 * @param depid 用户部门id集合，以逗号为分隔符
	 * @param depname 用户部门名称集合（部门名称全全称），以空格为分隔符
	 */
	public void updateBsUserInfoDep(String loginname,String depid,String depname);
	
	/**
	 * 修改用户表中用户类型
	 * @param loginname 用户登录名 
	 * @param isanalyzer 是否是数据分析师 ，0 ：否 1：是  2：申请中,null视为该项不修改
	 * @param isdeveloper 是否是开发者 ，0 ：否 1：是  2：申请中,null视为该项不修改
	 */
	public void updateBsUserInfoUserType(String loginname,Integer isanalyzer,Integer isdeveloper);
	
	
	/**
	 * 
	 * Created on 2016-4-9 
	 * <p>Discription:[根据查询条件查询多个人的用户信息]</p>
	 * @param condition
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public List<BsUserinfo> getBsUserinfoByCondition(Map<String,Object> condition);
	
	public List<BsUserinfo> getBsUserinfoListById(String appuserid);

	/**
	 * 更改分析师或开发者
	 * @param isanalyzer   是否分析师
	 * @param isdeveloper  是否开发者
	 * @param loginname    用户标识
	 * @return
	 */
	public boolean updateIsanalyzer(Integer isanalyzer,Integer isdeveloper,String loginname);
	/**
	 * 查看用户是否开发者状态
	 * @param loginname 用户名
	 * @return
	 */
	public Integer selectIsdeveloperStatus(String loginname);
	/**
	 * 根据用户登录名查用户部门
	 * @param loginname 用户登录名
	 * @return
	 */
	public String selectBsUserinfoDepnameByLoginname(String loginname);
	/**
	 * 根据用户名查找所在部门领导
	 * @param loginname 用户登录名
	 * @return
	 */
	public List<BsUserinfo> findUserDepLeaderList(String loginname);
	/**
	 * 根据用户获得用户姓名
	 * @param loginname 用户登录名
	 * @return
	 */	
	public String getUserFullnameByLoginname(String loginname);
	/**
	 * 根据用户获得用户手机号
	 * @param loginname 用户登录名
	 * @return
	 */	
	public String getUserMobilePhoneByLoginname(String loginname);
	
	
	/**
	 * 根据登录名判断用户是否存在
	 * @param loginname 登录名
	 * @return
	 */
	public boolean judgeBsUserinfoExsitByLoginname(String loginname);
		
	/**
	 *  根据登录名和状态判断符合条件的用户是否存在
	 * @param loginname 登录名
	 * @param status 状态 1正常 0停用 2冻结
	 * @return
	 */
	public boolean judgeBsUserinfoExsitByLoginnameAndStatus(String loginname,Integer status);
	/**
	 * 用户登录账号申请审批成功后解冻用户
	 * @param loginname 用户登录名
	 * @param status   状态，传1正常
	 * @param activetime 解冻激活时间
	 * @return
	 */
	public boolean unfreezeBsUserinfo(String loginname,Integer status,Long activetime);
	/**
	 * 根据用户登录名集合查询用户姓名、部门相关人员信息集合
	 * @param loginnames 用户登录名条件集合
	 * @return map key(loginname),value(fullname/depname)
	 */
	public Map<String,String> getBsUserNameAndDepNameByCondition(String  loginnames);
	
}