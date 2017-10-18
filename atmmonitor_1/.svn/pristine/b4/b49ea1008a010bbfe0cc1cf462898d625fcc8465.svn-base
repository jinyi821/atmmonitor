package com.usermanager.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.core.util.UUIDGenerator;
import com.common.dao.IDAO;
import com.usermanager.model.BsDep;
import com.usermanager.model.BsUserDep;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsUserDepService;

@Transactional
@Service("bsDepService")
public class BsDepImpl implements BsDepService {

	private static Log logger = LogFactory.getLog(BsDepImpl.class);
	@Resource
	private IDAO<BsDep, String> bsDepDao;
	@Resource
	private BsUserDepService bsUserDepService;

	public boolean addBsDep(BsDep bsDep) {
		boolean result = false;
		if (bsDep != null) {
			if (bsDep.getStatus() == null) {
				bsDep.setStatus(1);
			}
			bsDepDao.save(bsDep);
			result = true;
		}
		return result;
	}

	public boolean saveOrUpdateBsDep(BsDep bsDep) {
		boolean result = false;
		if (bsDep != null) {
			String pid = StringUtils.checkNullString(bsDep.getPid()).trim();
			setFullName(bsDep);
			if (StringUtils.checkNullString(bsDep.getDepdn()).equals("")) { // 没有dn
																			// 及dns
				String dn = createDn(this.getMaxDn(bsDep.getParentid(), pid));
				bsDep.setDepdn(dn);
				bsDep.setDepdns(this.createDns(bsDep.getParentid(), dn));
			}
			bsDep.setLastmodifytime(System.currentTimeMillis() / 1000);
			if (pid.equals("")) {
				bsDep.setCreatetime(System.currentTimeMillis() / 1000);
				bsDep.setPid(UUIDGenerator.getUUID());
				bsDep.setCreater(bsDep.getLastmodifier());
				result = this.addBsDep(bsDep);
			} else {
				bsDepDao.saveOrUpdate(bsDep);
				result = true;
			}
			result = true;
		}
		return result;
	}

	@Override
	public List<BsDep> getParent(String parentId, List<BsDep> list) {
		if (list == null) {
			list = new ArrayList<BsDep>();
		}
		if ("0".equals(parentId)) {
			return list;
		}
		BsDep bsDep = this.getBsDepById(parentId);
		list.add(bsDep);
		return getParent(parentId, list);
	}

	/**
	 * 得到用户部门全称
	 */
	@Override
	public String getDeptFullName(String id) {

		String deptFullName = "";
		String deptDns = "";
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();

		BsDep bsDep = this.getBsDepById(id);
		if (bsDep != null) {

			list.add(bsDep.getDepname());
			list1.add(bsDep.getDepdn());
			getParentFullName(bsDep.getParentid(), list, list1);
		}

		for (String deptName : list) {
			if (deptFullName.length() == 0) {
				deptFullName = deptName;
			} else {
				deptFullName = deptName + "·" + deptFullName;
			}
		}
		for (String dn : list1) {
			if (deptDns.length() == 0) {
				deptDns = dn;
			} else {
				deptDns = dn + "." + deptDns;
			}
		}
		return deptFullName + "," + deptDns;
	}

	/***
	 * 得到用户上级部门全称
	 */
	private void getParentFullName(String parentid, List<String> list, List<String> list1) {
		if (list == null) {
			list = new ArrayList<String>();
		}
		if ("0".equals(parentid)) {
			return;
		}
		BsDep bsDep = this.getBsDepById(parentid);
		if (bsDep != null) {
			list.add(bsDep.getDepname());
			list1.add(bsDep.getDepdn());
			getParentFullName(bsDep.getParentid(), list, list1);
		}
	}

	/**
	 * 对部门的全称缺陷进行修正
	 */
	@Override
	public Boolean modifyDeptFullName() {

		List<BsDep> list = new ArrayList<BsDep>();
		try {
			list = this.bsDepDao.find("from BsDep where status=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (BsDep bsDep : list) {

			String depfullnameDns = getDeptFullName(bsDep.getPid());

			if (depfullnameDns != null) {

				String[] depfullnameDnsArray = depfullnameDns.split(",");
				if (depfullnameDnsArray.length == 2) {

					logger.info(bsDep.getPid() + "部门的全称=" + depfullnameDnsArray[0]);
					logger.info(bsDep.getPid() + "部门的DNS=" + depfullnameDnsArray[1]);

					bsDep.setDepfullname(depfullnameDnsArray[0]);
					bsDep.setDepdns(depfullnameDnsArray[1]);
					bsDepDao.saveOrUpdate(bsDep);
				}
			}
		}
		return true;
	}

	@Override
	public boolean syncSaveOrUpdateBsDep(BsDep bsDep, String isAdd) {
		boolean result = false;
		if (bsDep != null) {
			if (bsDep.getParentid() == null) {
				bsDep.setParentid("0");
			}
			String pid = StringUtils.checkNullString(bsDep.getPid()).trim();
			if (StringUtils.checkNullString(bsDep.getDepdn()).equals("")) { // 没有dn
																			// 及dns
				String dn = createDn(this.getMaxDn(bsDep.getParentid(), pid));
				bsDep.setDepdn(dn);
				bsDep.setDepdns(this.createDns(bsDep.getParentid(), dn));
			}
			bsDep.setLastmodifytime(System.currentTimeMillis() / 1000);
			setFullName(bsDep);
			if (pid.equals("")) {
				bsDep.setPid(UUIDGenerator.getUUID());
			}

			if ("0".equals(isAdd)) {
				bsDepDao.add(bsDep);
			} else {
				bsDepDao.saveOrUpdate(bsDep);
			}
			result = true;
		}
		return result;
	}

	// 设置全名 及父ID
	private void setFullName(BsDep bsDep) {

		if (StringUtils.checkNullString(bsDep.getParentid()).equals("") || StringUtils.checkNullString(bsDep.getParentid()).equals("0")) {
			bsDep.setParentid("0");
			bsDep.setDepfullname(bsDep.getDepname());
		} else {
			BsDep parentDep = this.getBsDepById(bsDep.getParentid());
			if (parentDep == null) {
				bsDep.setDepfullname("NOParentFullName" + "·" + bsDep.getDepname());
			} else {
				bsDep.setDepfullname(parentDep.getDepfullname() + "·" + bsDep.getDepname());
			}

		}
	}

	@Override
	public boolean syncDeleteBsDep(String pid) {
		return this.deleteBsDepById(pid);
	}

	// 获取分类子节点中最大的dn
	private String getMaxDn(String parentId, String pid) {
		String dn = null;
		Object[] params = new Object[] { parentId };
		StringBuffer sql = new StringBuffer();
		sql.append("select max(bd.depdn) from BsDep bd ");
		sql.append("where bd.parentid=?  ");
		if (!"".equals(pid)) {
			sql.append(" and pid != ? ");
			params = new Object[] { parentId, pid };
		}

		List<Object[]> list = this.bsDepDao.queryBySql(sql.toString(), params);
		if (list != null && !list.isEmpty() && list.get(0) != null) {
			dn = String.valueOf(list.get(0));
		}
		return dn;
	}

	private String createDn(String maxDn) {
		String dn = "";
		if (StringUtils.checkNullString(maxDn).equals("")) {
			dn = "0001";
		} else {
			String f = "%0" + 4 + "d";
			dn = String.format(f, Integer.parseInt(maxDn) + 1);
		}
		return dn;
	}

	// 获取父节点的dns
	private String getDns(String pid) {
		String dns = "noParentDns";
		pid = pid == null ? "0" : pid;
		BsDep bsDep = this.getBsDepById(pid);
		if (bsDep != null) {
			dns = bsDep.getDepdns();
		}
		return dns;
	}

	private String createDns(String modelCategoryId, String dn) {
		String dns = null;
		if (modelCategoryId == null || modelCategoryId.equals("0")) {// 属于根节点分类
			dns = dn;
		} else {// 属于子分类
			String parentDns = getDns(modelCategoryId);
			dns = parentDns + "." + dn;
		}
		return dns;
	}

	public boolean deleteBsDepById(String bsDepId) {
		boolean result = false;
		List<BsDep> list = this.getListByParentId(bsDepId);
		if (list != null && !list.isEmpty())
			return result;
		bsDepDao.deleteByKey(bsDepId);
		List<BsUserDep> userDepMapList = bsUserDepService.selectUserDepMapListByDepid(bsDepId);
		for (int i = 0; i < userDepMapList.size(); i++) {
			BsUserDep userDepMap = userDepMapList.get(i);
			String loginname = userDepMap.getLoginname();
			bsUserDepService.deleteBsUserDepByDepid(bsDepId);
			bsUserDepService.maintenUserDepMap(loginname);
		}
		result = true;
		return result;
	}

	public BsDep getBsDepById(String pid) {
		return bsDepDao.get(pid);
	}

	public boolean deleteBsDepByIds(List<String> bsDepIdList) {
		int lstLen = bsDepIdList == null ? 0 : bsDepIdList.size();
		for (int i = 0; i < lstLen; i++) {
			if (!this.deleteBsDepById(bsDepIdList.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public List<BsDep> getListByParentId(String parentId) {
		List<BsDep> list = null;
		try {
			list = this.bsDepDao.find("from BsDep where parentid = ? order by ordernum asc", parentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * @param deptype
	 * @return
	 */
	public List<BsDep> getAllDeptList(Object[] deptype) {
		List<BsDep> list = null;
		try {
			list = this.bsDepDao.find("from BsDep  order by ordernum asc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getChildNode(String itemId) {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0'  encoding='utf-8'?>");
		xml.append("<tree id='" + itemId + "'>");
		if (itemId.equals("-1")) {// 加载根节点
			xml.append("<item id='0' text='部门' child='1'></item>");
		} else {
			List<BsDep> list = this.getListByParentId(itemId);
			int lens = list == null ? 0 : list.size();
			BsDep dep = null;
			for (int i = 0; i < lens; i++) {
				dep = list.get(i);
				xml.append("<item id='" + dep.getPid() + "' text='" + dep.getDepname() + "' child='1'></item>");
			}
		}
		xml.append("</tree>");
		return xml.toString();
	}

	@Override
	public List<BsDep> getUseListByParentId(String parentId) {
		List<BsDep> list = new ArrayList<BsDep>();
		try {
			list = this.bsDepDao.find("from BsDep where status=1 and parentid = ? order by ordernum asc", parentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getUseDepTreeNode() {
		// 通过此来拼接xml文件，这里注意选取StringBuilder，效率更高
		StringBuilder depTreeString = new StringBuilder(128);
		depTreeString.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		depTreeString.append("<tree id=\"0\">");
		List<BsDep> depList = this.getUseListByParentId("0");
		for (int i = 0; i < depList.size(); i++) {
			BsDep dep = depList.get(i);
			// 调用构建子节点的函数
			buildDepTree(dep, depTreeString);
		}
		depTreeString.append("</tree>");
		return depTreeString.toString();
	}

	/**
	 * 构建树形节点的内容
	 */
	private void buildDepTree(BsDep dep, StringBuilder depTreeString) {
		// 注意拼接字符串一些特殊符号的处理
		depTreeString.append("<item text=\"");
		depTreeString.append(dep.getDepname());
		depTreeString.append("\" open=\"1\" id=\"");
		depTreeString.append(dep.getPid());
		depTreeString.append("\" child=\"1\">");

		// 查看此节点的子节点
		List<BsDep> childDepList = this.getUseListByParentId(dep.getPid());
		// 如果有子节点，进行递归调用，调用自己这个函数
		for (int j = 0; j < childDepList.size(); j++) {
			BsDep childdep = childDepList.get(j);
			// 调用构建子节点的函数
			buildDepTree(childdep, depTreeString);
		}
		depTreeString.append("</item>");
	}

	@Override
	public String getUseChildNode(String itemId, String type) {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0'  encoding='utf-8'?>");
		xml.append("<tree id='" + itemId + "'>");
		List<BsDep> list = this.getUseListByParentId(itemId);
		int lens = list == null ? 0 : list.size();
		if (lens > 0) {
			BsDep dep = null;
			for (int i = 0; i < lens; i++) {
				dep = list.get(i);
				xml.append("<item id='" + dep.getPid() + "'  text='" + dep.getDepname() + "' child='1'><userdata name='type'>dep</userdata><userdata name='depfullname'>" + dep.getDepfullname()
						+ "</userdata></item>"); // open='1' 刷刷的加载，全部加载 call='1'
													// select='1' checked='1'
													// radio='1' open='1'
													// nocheckbox='1'
			}
		} else {
			if (type.equals("depuser")) {
				List<BsUserDep> userDepList = bsUserDepService.selectUserDepMapListByDepid(itemId);
				int userdeplen = userDepList == null ? 0 : userDepList.size();
				BsUserDep userdep = null;
				for (int i = 0; i < userdeplen; i++) {
					userdep = userDepList.get(i);
					xml.append("<item id='" + userdep.getLoginname() + "'  text='" + userdep.getUserinfo().getFullname() + "' child='1'><userdata name='type'>user</userdata></item>"); // open='1'
																																														// 刷刷的加载，全部加载
																																														// call='1'
																																														// select='1'
																																														// checked='1'
																																														// radio='1'
																																														// open='1'
																																														// nocheckbox='1'
				}
			}
		}

		xml.append("</tree>");
		return xml.toString();
	}

	@Override
	public List<BsDep> selectUserDepList(String loginname) {
		List<BsDep> userDepList = new ArrayList<BsDep>();
		String hql = "select new BsDep(dep.pid,dep.depname,dep.depfullname) from BsDep dep,BsUserDep userdep where dep.pid=userdep.depid and userdep.loginname=?";
		try {
			userDepList = bsDepDao.find(hql, loginname);
			return userDepList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDepList;
	}

	@Override
	public void createDnAndDns(String parentId, String parentDns) {
		parentId = parentId == null || parentId.equals("") ? "0" : parentId;
		List<BsDep> list = this.getListByParentId(parentId);
		int lens = list == null ? 0 : list.size();
		String dn = null;
		String dns = null;
		for (int i = 0; i < lens; i++) {
			dn = createDn(String.valueOf(i));
			dns = createDns(parentId, parentDns);
			list.get(i).setDepdn(dn);
			if (parentId.equals("0") || parentDns == null) {
				dns = dn;
			} else {
				dns = parentDns + "." + dn;
			}
			list.get(i).setDepdns(dns);
			createDnAndDns(list.get(i).getPid(), dns);
		}
		this.blukSaveBsDep(list);
	}

	@Override
	public boolean blukSaveBsDep(List<BsDep> list) {
		for (BsDep dep : list) {
			this.saveOrUpdateBsDep(dep);
		}
		return true;
	}

	public List<BsDep> getBsDepListByPid(String depids) {
		// String[] args;
		// String insql = "";
		// if("".equals(depids)){
		// args = new String[0];
		// } else {
		// args = depids.split(",");
		// insql = "'" + args[0] + "'";
		// for(int i = 1; i < args.length; i++){
		// insql = insql + ",'" + args[i] + "'";
		// }
		// }
		List<BsDep> list = new ArrayList<BsDep>();
		String sql = "from BsDep where pid in ('" + depids.replace(",", "','") + "') ";
		try {
			list = bsDepDao.find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	@Override
	public List<BsDep> getDepByLoginName(String loginName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select bd from BsDep bd,BsUserDep bud ");
		sql.append(" where bd.pid=bud.depid");
		sql.append(" and bud.loginname=?");
		List<BsDep> list = null;
		try {
			list = this.bsDepDao.find(sql.toString(), loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getDnsJsonByLonginName(String loginName) {
		List<String> dnsList = this.getDnsListByLonginName(loginName);
		if (dnsList == null || dnsList.isEmpty()) {
			return null;
		}
		return JSONArray.fromObject(dnsList).toString();
	}
	
	@Override
	public String getDnsConByLonginName(String loginNames) {
		List<String> dnsConList=new ArrayList<String>();
		String[] loginnameArray=loginNames.split(",");
		for (int i=0;i<loginnameArray.length; i++) {
			List<String> dnsList=getDnsListByLonginName(loginnameArray[i]);
			if (dnsList!=null&&!dnsList.isEmpty()) {
				if(i==0){ //第一个全部添加
					dnsConList.addAll(dnsList);	
				}else{
				Iterator<String> listIte=dnsList.iterator(); //其它的去掉返回的dns中重复的项
				while(listIte.hasNext()){
					String dns=listIte.next();
					if(!dnsConList.contains(dns)){
						dnsConList.add(dns);
					}					
				}					
				}				
			}
			
		}
		if (dnsConList == null||dnsConList.isEmpty()) {
			return null;
		} 		
		StringBuffer dns = new StringBuffer(dnsConList.get(0));
		for (int i = 1; i < dnsConList.size(); i++) {
			dns.append(",");
			dns.append(dnsConList.get(i));
		}
		return dns.toString();
	}

	@Override
	public List<String> getDnsListByLonginName(String loginNames) {
		List<BsDep> depList = this.getDepByLoginName(loginNames);
		return this.getDnsListByBsDep(depList);
	}

	@Override
	public List<String> getDnsListByBsDep(List<BsDep> depList) {
		int lens = depList == null ? 0 : depList.size();
		List<String> dnsList = new ArrayList<String>();
		// 0001.0001.0001
		for (int i = 0; i < lens; i++) {
			dnsList.addAll(getDnsListByDns(depList.get(i).getDepdns()));
		}
		Set<String> set = new HashSet<String>(); // 去掉重复dns
		set.addAll(dnsList);
		dnsList.clear();
		dnsList.addAll(set);

		return dnsList;
	}

	private List<String> getDnsListByDns(String dns) {
		List<String> dnsList = new ArrayList<String>();

		if (StringUtils.checkNullString(dns).equals("")) {
			return dnsList;
		}
		String newDns = null;
		String[] dnsArr = dns.split("\\.");
		for (int i = 0; i < dnsArr.length; i++) {
			if (i == 0) {
				newDns = dnsArr[i];
			} else {
				newDns = newDns + "." + dnsArr[i];
			}
			dnsList.add(newDns);
		}
		return dnsList;
	}

	
}
