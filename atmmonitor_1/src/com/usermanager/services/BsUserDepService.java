package com.usermanager.services;
import java.util.List;
import java.util.Map;

import com.usermanager.model.BsUserDep;
public interface BsUserDepService
{
	public boolean  addBsUserDep(BsUserDep bsuserdep); 
	public boolean  saveOrUpdateBsUserDep(BsUserDep bsuserdep); 
	public boolean  deleteBsUserDepById(Integer pid); 
	public BsUserDep  getBsUserDepById(Integer pid); 
	public boolean  deleteBsUserDepByIds(List<Integer> bsUserDepIdList);
	
	public  boolean findUserDepExist(String loginname,String depid);
	/**
	 * 根据用户登录名删除用户部门映射数据
	 * @param loginname 用户登录名
	 */
	public void deleteBsUserDepByLoinname(String loginname);
	/**
	 * 根据部门id删除用户部门映射数据
	 * @param depid 部门id
	 */
	public void deleteBsUserDepByDepid(String depid);	
	/**
	 * 根据用户登录名查找对应的用户部门映射集合
	 * @param loginname 用户登录名
	 * @return
	 */
	public List<BsUserDep> selectUserDepMapListByLoginname(String loginname);
	/**
	 * 根据用户登录名维护对应的用户部门映射
	 * @param loginname 用户登录名
	 */
	public void maintenUserDepMap(String loginname);
	/**
	 * 根据部门id查找对应的用户部门映射
	 * @param depid 部门id
	 * @return
	 */
	public List<BsUserDep> selectUserDepMapListByDepid(String depid);
	
	
	
	/**
	 * 操作用户部门信息
	 * @param userdepMap String,List<String> 第一个string指loginname用户登录名  List<String> 用户部门id集合
	 * @param operator 操作者,取当前登录用户的登录名
	 */
	public void operateUserDep(Map<String,List<String>> userdepMap,String operator);
}