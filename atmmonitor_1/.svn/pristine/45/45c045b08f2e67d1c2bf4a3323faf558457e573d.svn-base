package com.usermanager.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.component.rquery.RQuery;
import com.common.core.util.CryptUrlUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsDep;
import com.usermanager.model.BsMapUserType;
import com.usermanager.model.BsRole;
import com.usermanager.model.BsUserDep;
import com.usermanager.model.BsUserRole;
import com.usermanager.model.BsUserinfo;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsMapUserTypeService;
import com.usermanager.services.BsRoleService;
import com.usermanager.services.BsUserDepService;
import com.usermanager.services.BsUserRoleService;
import com.usermanager.services.BsUserinfoService;


@Transactional
@Service(value = "bsUserinfoService")
public class BsUserinfoImpl implements BsUserinfoService {
	@Autowired
	private IDAO<BsUserinfo, String> bsUserinfoDao;

	public IDAO<BsUserinfo, String> getBsUserinfoDao() {
		return bsUserinfoDao;
	}

	public void setBsUserinfoDao(IDAO<BsUserinfo, String> bsUserinfoDao) {
		this.bsUserinfoDao = bsUserinfoDao;
	}

	@Resource
	private BsUserRoleService bsUserRoleService;
	@Resource
	private BsMapUserTypeService bsMapUserTypeService;
	@Resource
	private BsUserDepService bsUserDepService;
	@Resource
	private BsDepService bsDepService;
	@Resource
	private BsRoleService bsRoleService;

	public boolean addBsUserinfo(BsUserinfo bsUserinfo) {
		boolean result = false;
		if (bsUserinfo != null) {
			bsUserinfo.setPwd(bsUserinfo.getEncodePwd());
			bsUserinfo.setCreatetime(System.currentTimeMillis() / 1000);
			bsUserinfoDao.save(bsUserinfo);
			result = true;
		}
		return result;
	}

	public boolean saveOrUpdateBsUserinfo(BsUserinfo bsUserinfo) {
		boolean result = false;
		if (bsUserinfo != null) {
			bsUserinfo.setPwd(bsUserinfo.getEncodePwd());
			bsUserinfoDao.saveOrUpdate(bsUserinfo);
			result = true;
		}
		return result;
	}

	public boolean deleteBsUserinfoById(String loginname) {
		boolean result = false;
		bsUserRoleService.deleteBsUserRoleByLoginname(loginname);
		bsMapUserTypeService.deleteBsMapUserTypeByLoginname(loginname);
		bsUserDepService.deleteBsUserDepByLoinname(loginname);
		bsUserinfoDao.deleteByKey(loginname);
		result = true;
		return result;
	}

	public BsUserinfo getBsUserinfoById(String loginname) {
		return bsUserinfoDao.get(loginname);
	}

	public boolean deleteBsUserinfoByIds(List<String> bsUserinfoIdList) {
		int lstLen = bsUserinfoIdList == null ? 0 : bsUserinfoIdList.size();
		for (int i = 0; i < lstLen; i++) {
			if (!this.deleteBsUserinfoById(bsUserinfoIdList.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public BsUserinfo getBsUserinfoByLoginname(String loginname) {
		BsUserinfo bsUserinfo = null;
		List<BsUserinfo> list;
		try {
			list = bsUserinfoDao.find("from  BsUserinfo where loginname=?", loginname);
			int lens = list == null ? 0 : list.size();
			if (lens > 0) {
				bsUserinfo = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bsUserinfo;
	}

	@Override
	public boolean loginnameExist(String loginname) {
		boolean flag = false;
		try {
			List<BsUserinfo> list = bsUserinfoDao.find("from BsUserinfo where loginname=?", loginname);
			int lens = list == null ? 0 : list.size();
			if (lens > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteBsUserinfoByLoignname(String loginname) {
		String hql = "delete  BsUserinfo where loginname=?";
		bsUserinfoDao.bulkUpdate(hql, loginname);
		return true;
	}

	@Override
	public void updateBsUserInfoDep(String loginname, String depid, String depname) {
		String hql = "update BsUserinfo set depid=?,depname=? where loginname=?";
		bsUserinfoDao.bulkUpdate(hql, depid, depname, loginname);
	}

	@Override
	public void updateBsUserInfoUserType(String loginname, Integer isanalyzer, Integer isdeveloper) {
		Integer[] paraInt = new Integer[] { 0, 1, 2, null };
		boolean isanalyzerflag = ArrayUtils.contains(paraInt, isanalyzer); // 判断数组中是否含有某个参数
		boolean isdeveloperflag = ArrayUtils.contains(paraInt, isdeveloper);
		if (!isanalyzerflag) {
			System.out.println("是否是数据分析师参数数据传入有误！");
			return;
		}
		if (!isdeveloperflag) {
			System.out.println("是否是开发者参数数据传入有误！");
			return;
		}
		if (isanalyzer != null && isdeveloper == null) {
			String hql = "update BsUserinfo set isanalyzer=? where loginname=?";
			bsUserinfoDao.bulkUpdate(hql, isanalyzer, loginname);
		}
		if (isanalyzer == null && isdeveloper != null) {
			String hql = "update BsUserinfo set isdeveloper=? where loginname=?";
			bsUserinfoDao.bulkUpdate(hql, isdeveloper, loginname);
		}
		if (isanalyzer != null && isdeveloper != null) {
			String hql = "update BsUserinfo set isanalyzer=?,isdeveloper=? where loginname=?";
			bsUserinfoDao.bulkUpdate(hql, isanalyzer, isdeveloper, loginname);
		}
	}

	/**
	 * 
	 * Created on 2016-4-9
	 * <p>
	 * Discription:[根据查询条件查询多个用户信息]
	 * </p>
	 * 
	 * @param condition
	 *            condition.put("loginname",new Object[]{"a","b"})
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@Override
	public List<BsUserinfo> getBsUserinfoByCondition(Map<String, Object> condition) {
		StringBuffer sb = new StringBuffer("select * from  bs_userinfo where 1=1 ");
		List<BsUserinfo> list = null;
		try {
			if (condition != null && condition.size() > 0) {

				if (condition.containsKey("loginname")) {
					sb.append(" and ").append(" loginname in (:loginname) ");
				}
				if (condition.containsKey("status")) {

					sb.append(" and ").append(" status = :status ");
				}
				if (condition.containsKey("mobile")) {

					sb.append(" and ").append(" mobile = :mobile ");
				}
				if (condition.containsKey("pwd")) {

					sb.append(" and ").append(" pwd = :pwd ");
				}

			}

			list = bsUserinfoDao.findBySql(sb.toString(), condition);

			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean operateBsUserinfo(int operation, BsUserinfo bsUserinfo, String[] userroleids, Integer[] usertypeids, String[] userdepids, String operator) {
		int userrolelen = userroleids == null ? 0 : userroleids.length;
		int usertypelen = usertypeids == null ? 0 : usertypeids.length;
		int userdeplen = userdepids == null ? 0 : userdepids.length;
		if (operation == 0 || operation == 1) {
			if (operation == 0) {
				this.addBsUserinfo(bsUserinfo);
				if (userroleids == null) { // 同步添加用户过来时，添加设置默认角色
					BsUserRole bsUserRole = new BsUserRole();
					// jinyi 2016-11-10 add
					if (bsUserinfo.getIsdepleader() == 1) {
						bsUserRole.setRoleid("3");
					} else {
						bsUserRole.setRoleid("0");
					}
					bsUserRole.setLoginname(bsUserinfo.getLoginname());
					bsUserRoleService.addBsUserRole(bsUserRole);
				}
				;
			} else if (operation == 1) {
				if (userrolelen > 0) {
					bsUserRoleService.deleteBsUserRoleByLoginname(bsUserinfo.getLoginname());
				}
				if (usertypelen > 0) {
					bsMapUserTypeService.deleteBsMapUserTypeByLoginname(bsUserinfo.getLoginname());
				}
				if (userdeplen > 0) {
					bsUserDepService.deleteBsUserDepByLoinname(bsUserinfo.getLoginname());
				}
				this.saveOrUpdateBsUserinfo(bsUserinfo);
				if (userroleids == null) { // 同步修改用户过来时，添加设置默认角色
					List<BsRole> userRoleList = bsRoleService.selectUserRoleList(bsUserinfo.getLoginname());
					int userRoleListLen = userRoleList.size();
					if (userRoleListLen == 0) { // userRoleListLen>0,userroleids==null的意思是对用户角色不做任何操作;userRoleListLen==0,userroleids==null的意思是添加设置默认角色
						BsUserRole bsUserRole = new BsUserRole();
						// jinyi 2016-11-10 add
						if (bsUserinfo.getIsdepleader() == 1) {
							bsUserRole.setRoleid("3");
						} else {
							bsUserRole.setRoleid("0");
						}
						bsUserRole.setLoginname(bsUserinfo.getLoginname());
						bsUserRoleService.addBsUserRole(bsUserRole);
					}
				}
				;
			}
			for (int i = 0; i < userrolelen; i++) {
				BsUserRole bsUserRole = new BsUserRole();
				bsUserRole.setRoleid(userroleids[i]);
				bsUserRole.setLoginname(bsUserinfo.getLoginname());
				bsUserRoleService.addBsUserRole(bsUserRole);
			}
			for (int i = 0; i < usertypelen; i++) {
				BsMapUserType bsMapUserType = new BsMapUserType();
				bsMapUserType.setLoginname(bsUserinfo.getLoginname());
				bsMapUserType.setUsertypeid(usertypeids[i]);
				bsMapUserType.setCreatetime(System.currentTimeMillis() / 1000);
				bsMapUserTypeService.addBsMapUserType(bsMapUserType);
			}
			StringBuilder userDepId = new StringBuilder();
			StringBuilder userDepName = new StringBuilder();
			for (int i = 0; i < userdeplen; i++) {
				BsUserDep userdep = new BsUserDep();
				userdep.setLoginname(bsUserinfo.getLoginname());
				userdep.setDepid(userdepids[i]);
				userdep.setRelatetype("1");
				userdep.setCreater(operator);
				userdep.setCreatetime(System.currentTimeMillis() / 1000);
				bsUserDepService.addBsUserDep(userdep);
				BsDep dep = bsDepService.getBsDepById(userdepids[i]);
				String depname = null;
				if (dep != null) {
					depname = dep.getDepfullname();
				}
				if (i < userdeplen - 1) {
					userDepId.append(userdepids[i] + ",");
					if (depname != null) {
						userDepName.append(depname + " ");
					}
				} else {
					userDepId.append(userdepids[i]);
					if (depname != null) {
						userDepName.append(depname);
					}
				}
			}
			this.updateBsUserInfoDep(bsUserinfo.getLoginname(), userDepId.toString(), userDepName.toString());
			return true;
		} else if (operation == 2) {
			return this.deleteBsUserinfoById(bsUserinfo.getLoginname());
		}
		return false;
	}

	@Override
	public boolean updateBsUserinfoPwd(String loginname, String pwd) {
		pwd = CryptUrlUtils.encode(pwd);
		String[] paraStr = { pwd, loginname };
		String hql = "update BsUserinfo set pwd=? where loginname=?";
		bsUserinfoDao.bulkUpdate(hql, paraStr);
		return true;
	}

	@Override
	public List<BsUserinfo> getBsUserinfoListById(String appuserid) {
		List<BsUserinfo> list = new ArrayList<BsUserinfo>();
		String sql = "from BsUserinfo where loginname in ('" + appuserid.replace(",", "','") + "') ";
		try {
			list = bsUserinfoDao.find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateIsanalyzer(Integer isanalyzer, Integer isdeveloper, String loginname) {
		StringBuffer sql = new StringBuffer();
		sql.append("update BsUserinfo set ");
		if (isanalyzer != null && isdeveloper != null) {
			sql.append("isanalyzer=" + isanalyzer);
			sql.append(",isdeveloper=" + isdeveloper);
		} else if (isanalyzer != null) {
			sql.append("isanalyzer=" + isanalyzer);
		} else if (isdeveloper != null) {
			sql.append("isdeveloper=" + isdeveloper);
		} else {
			return false;
		}
		sql.append(" where loginname='" + loginname + "'");
		this.bsUserinfoDao.bulkUpdate(sql.toString());
		return true;
	}

	@Override
	public Integer selectIsdeveloperStatus(String loginname) {
		String hql = "select isdeveloper from BsUserinfo where loginname= ? ";
		Integer isdeveloper = null;
		List userList;
		try {
			userList = bsUserinfoDao.find(hql, loginname);
			if (userList != null && userList.size() > 0) {
				isdeveloper = (Integer) userList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isdeveloper;
	}

	@Override
	public String selectBsUserinfoDepnameByLoginname(String loginname) {
		String hql = "select depname from  BsUserinfo where loginname= ? ";
		String userDepname = null;
		try {
			List userList = bsUserinfoDao.find(hql, loginname);
			if (userList != null && userList.size() > 0) {
				userDepname = (String) userList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
		return userDepname;
	}

	@Override
	public List<BsUserinfo> findUserDepLeaderList(String loginname) {
		BsUserinfo userinfo = this.getBsUserinfoById(loginname);
		String sqlname = "SQL_BsUserinfo.bsUserinfoDepLeader";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("depid", userinfo.getDepid());
		RQuery rquery = new RQuery(sqlname, map);
		rquery.setIsCount(2);
		String dataJson = rquery.getJsonString();
		if (dataJson == "") {
			dataJson = "[]";
		}
		JSONArray json = JSONArray.fromObject(dataJson);
		List<BsUserinfo> userLeaderList = (List<BsUserinfo>) JSONArray.toCollection(json, BsUserinfo.class);
		return userLeaderList;
	}

	@Override
	public String getUserFullnameByLoginname(String loginname) {
		String hql = "select fullname from  BsUserinfo where loginname= ? ";
		String userFullname = null;
		try {
			List userList = bsUserinfoDao.find(hql, loginname);
			if (userList != null && userList.size() > 0) {
				userFullname = (String) userList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userFullname;
	}

	@Override
	public String getUserMobilePhoneByLoginname(String loginname) {
		String hql = "select mobile from  BsUserinfo where loginname= ? ";
		String mobilePhone = null;
		try {
			List userList = bsUserinfoDao.find(hql, loginname);
			if (userList != null && userList.size() > 0) {
				mobilePhone = (String) userList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mobilePhone;
	}

	@Override
	public boolean judgeBsUserinfoExsitByLoginname(String loginname) {
		boolean flag = false;
		String hql = "select count(loginname) from BsUserinfo where loginname='" + loginname + "'";
		try {
			Long countSum = bsUserinfoDao.getSumCount(hql);
			if (countSum > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean unfreezeBsUserinfo(String loginname, Integer status, Long activetime) {
		boolean activeFlag = false;
		String hql = "update BsUserinfo set status=?,activeorlocktime=? where loginname=?";
		int updateCount = bsUserinfoDao.bulkUpdate(hql, status, activetime, loginname);
		if (updateCount == 1) {
			activeFlag = true;
		}
		return activeFlag;
	}

	@Override
	public boolean judgeBsUserinfoExsitByLoginnameAndStatus(String loginname, Integer status) {

		boolean flag = false;
		String hql = "select count(loginname) from BsUserinfo where loginname='" + loginname + "' and status=" + status;

		try {
			Long countSum = bsUserinfoDao.getSumCount(hql);
			if (countSum > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Map<String, String> getBsUserNameAndDepNameByCondition(String loginnames) {
		String loginnameCondition=loginnames.replace(",", "','");
		Map<String, String> userMap=new HashMap<String,String>();
		String sql="select loginname,fullname,depname from bs_userinfo where loginname in ('"+loginnameCondition+"')";
		List<Object[]>	objArrayList = bsUserinfoDao.findBySql(sql);
		for (Object[] objArray : objArrayList) {
			String loginname=String.valueOf(objArray[0]);
			String fullname=String.valueOf(objArray[1]);
			String depname=String.valueOf(objArray[2]);
			String userDepAndFullName=depname.split(",")[0].concat("·").concat(fullname);
			userMap.put(loginname,userDepAndFullName);
		}
		return userMap;
	}
}