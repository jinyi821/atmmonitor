package com.equipment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.constants.Constants;
import com.equipment.model.Equipment;
import com.equipment.model.EquipmentChange;
import com.equipment.service.EquipmentChangeService;
import com.equipment.service.EquipmentService;
import com.portal.model.UserLoginInfo;
import com.usermanager.model.BsDep;
import com.usermanager.model.BsUserRole;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsUserRoleService;


@Controller
@RequestMapping(value = "/equipmentchange")
public class EquipmentChangeController {

	@Autowired
	private EquipmentChangeService equipmentChangeService;
	@Autowired
	private BsDepService bsDepService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private BsUserRoleService bsUserRoleService;

	private static Log logger = LogFactory.getLog(EquipmentChangeController.class);
    
	/**
     * 
     * @param req
     * @param map
     * @return
     */
	@RequestMapping(value = "/enter")
	public String enter(HttpServletRequest req, Map<String, Object> map) {
		String menuId = req.getParameter("menuId");
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("loginname", userlogin.getLoginname());
		map.put("menuId", menuId);
		return "/equipmentchange/equipmentChangeList.jsp";
	}

	@RequestMapping(value = "/enterApprover")
	public String enterApprover(HttpServletRequest req, Map<String, Object> map) {

		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("loginname", userlogin.getLoginname());

		return "/equipmentchange/equipmentChangeApproverList.jsp";
	}

	@RequestMapping(value = "/enterMaintain")
	public String enterMaintain(HttpServletRequest req, Map<String, Object> map) {

		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("loginname", userlogin.getLoginname());

		return "/equipmentchange/equipmentChangeMaintainList.jsp";
	}

	@RequestMapping("equipmentChangeDetail.action")
	public String equipmentChangeDetail(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentDetail begin");
		if (pid != null) {

			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(pid);
			map.put("equipmentChange", selectByPrimaryKey);

		} else {
			map.put("equipmentChange", new EquipmentChange());
		}

		UserLoginInfo userlogin = (UserLoginInfo) request.getSession().getAttribute(Constants.USERSESSION);
		List<BsDep> depByLoginName = bsDepService.getDepByLoginName(userlogin.getLoginname());

		if (depByLoginName != null && depByLoginName.size() > 0) {
			Equipment record = new Equipment();
			record.setStatus(1);
			record.setOwndept(depByLoginName.get(0).getPid());
			List<Equipment> selectByStatus = equipmentService.selectByStatus(record);
			map.put("equipmentList", selectByStatus);
		}
		List<BsUserRole> userRoleByRole = bsUserRoleService.getUserRoleByRole(Constants.APPROVER_ROLE);
		map.put("userList", userRoleByRole);

		return "/equipmentchange/equipmentChangeSave.jsp";
	}

	@RequestMapping("equipmentChangeApproveDetail.action")
	public String equipmentChangeApproveDetail(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentDetail begin");
		if (pid != null) {

			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(pid);
			map.put("equipmentChange", selectByPrimaryKey);

		}

		List<BsUserRole> userRoleByRole = bsUserRoleService.getUserRoleByRole(Constants.MAINTAINR_ROLR);
		map.put("userList", userRoleByRole);

		return "/equipmentchange/equipmentChangeApproveSave.jsp";
	}

	/**
	 * 
	 * Created on 2016-4-27
	 * <p>
	 * Discription:[保存商品]
	 * </p>
	 * 
	 * @param request
	 * @param jobId
	 * @param cmd
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping("saveEquipmentChange.action")
	public String saveEquipmentChange(@ModelAttribute EquipmentChange equipmentChange, HttpServletRequest req, HttpServletResponse res, Map<String, Object> map) {

		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		if (equipmentChange.getId() != null) {
			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(equipmentChange.getId());
			equipmentChange.setStatus(selectByPrimaryKey.getStatus());
			equipmentChange.setCreatetime(selectByPrimaryKey.getCreatetime());

			Equipment selectByPrimaryKey2 = equipmentService.selectByPrimaryKey(equipmentChange.getEquipmentid());
			equipmentChange.setEquipmentname(selectByPrimaryKey2.getName());

			equipmentChange.setCreater(selectByPrimaryKey.getCreater());
			equipmentChange.setApplydept(selectByPrimaryKey.getApplydept());
			equipmentChangeService.updateByPrimaryKeySelective(equipmentChange);

		} else {

			equipmentChange.setCreatetime(new Long(System.currentTimeMillis() / 1000).intValue());
			equipmentChange.setStatus(0);
			equipmentChange.setCreater(userlogin.getLoginname());
			List<BsDep> depByLoginName = bsDepService.getDepByLoginName(userlogin.getLoginname());

			if (depByLoginName != null && depByLoginName.size() > 0) {
				equipmentChange.setApplydept(depByLoginName.get(0).getDepname());
			}

			Equipment selectByPrimaryKey = equipmentService.selectByPrimaryKey(equipmentChange.getEquipmentid());
			if (selectByPrimaryKey != null) {
				equipmentChange.setEquipmentname(selectByPrimaryKey.getName());
			}
			equipmentChangeService.insert(equipmentChange);
		}

		return "/equipmentchange/equipmentChangeList.jsp";
	}

	@RequestMapping("equipmentChangeDel.action")
	@ResponseBody
	public Boolean equipmentChangeDel(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentChangeDel begin");
		if (pid != null) {

			equipmentChangeService.deleteByPrimaryKey(pid);
			return true;
		}

		return false;
	}

	@RequestMapping("activeEquipmentChange.action")
	@ResponseBody
	public Boolean activeEquipmentChange(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("activeEquipmentChange begin");
		if (pid != null) {

			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(pid);
			selectByPrimaryKey.setStatus(1);
			equipmentChangeService.updateByPrimaryKeySelective(selectByPrimaryKey);
			return true;
		}

		return false;
	}

	/**
	 * 
	 * Created on 2016-4-27
	 * <p>
	 * Discription:[保存商品]
	 * </p>
	 * 
	 * @param request
	 * @param jobId
	 * @param cmd
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping("saveEquipmentApprove.action")
	public String saveEquipmentApprove(@ModelAttribute EquipmentChange equipmentChange, HttpServletRequest req, HttpServletResponse res, Map<String, Object> map) {
		
		if (equipmentChange.getId() != null) {
			
			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(equipmentChange.getId());
			selectByPrimaryKey.setStatus(equipmentChange.getStatus());
			selectByPrimaryKey.setApproverremark(equipmentChange.getApproverremark());
			selectByPrimaryKey.setApprovetime(new Long(System.currentTimeMillis() / 1000).intValue());
			if (selectByPrimaryKey.getStatus()==2){
				selectByPrimaryKey.setMaintainer(equipmentChange.getMaintainer());
			} 

			equipmentChangeService.updateByPrimaryKeySelective(selectByPrimaryKey);

		}
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("loginname", userlogin.getLoginname());
		return "/equipmentchange/equipmentChangeApproverList.jsp";
	}
	
	@RequestMapping("equipmentChangeMaintainDetail.action")
	public String equipmentChangeMaintainDetail(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentDetail begin");
		if (pid != null) {

			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(pid);
			map.put("equipmentChange", selectByPrimaryKey);

		}

		List<BsUserRole> userRoleByRole = bsUserRoleService.getUserRoleByRole(Constants.MAINTAINR_ROLR);
		map.put("userList", userRoleByRole);

		return "/equipmentchange/equipmentChangeMaintainSave.jsp";
	}
	
	
	@RequestMapping("saveEquipmentMaintain.action")
	public String saveEquipmentMaintain(@ModelAttribute EquipmentChange equipmentChange, HttpServletRequest req, HttpServletResponse res, Map<String, Object> map) {
		
		if (equipmentChange.getId() != null) {
			
			EquipmentChange selectByPrimaryKey = equipmentChangeService.selectByPrimaryKey(equipmentChange.getId());
			selectByPrimaryKey.setStatus(equipmentChange.getStatus());
			selectByPrimaryKey.setMaintainremark(equipmentChange.getMaintainremark());
			selectByPrimaryKey.setMaintaintime(new Long(System.currentTimeMillis() / 1000).intValue());
			

			equipmentChangeService.updateByPrimaryKeySelective(selectByPrimaryKey);

		}
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("loginname", userlogin.getLoginname());
		return "/equipmentchange/equipmentChangeMaintainList.jsp";
	}

}
