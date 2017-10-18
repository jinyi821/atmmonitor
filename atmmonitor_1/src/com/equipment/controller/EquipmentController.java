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

import com.equipment.model.Equipment;
import com.equipment.service.EquipmentService;
import com.usermanager.model.BsDep;
import com.usermanager.services.BsDepService;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private BsDepService bsDepService;

	private static Log logger = LogFactory.getLog(EquipmentController.class);

	@RequestMapping(value = "/enter")
	public String enter() {

		return "/equipment/equipmentList.jsp";
	}

	@RequestMapping("equipmentDetail.action")
	public String equipmentDetail(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentDetail begin");
		if (pid != null) {

			Equipment selectByPrimaryKey = equipmentService.selectByPrimaryKey(pid);
			map.put("equipment", selectByPrimaryKey);

		}
		List<BsDep> listByParentId = bsDepService.getAllDeptList(new Object[]{});
		map.put("deptList", listByParentId);
		return "/equipment/equipmentSave.jsp";
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
	@RequestMapping("saveEquipment.action")
	public String saveEquipment(@ModelAttribute Equipment equipment, HttpServletRequest req, HttpServletResponse res, Map<String, Object> map) {

		if (equipment.getId() != null) {
			Equipment selectByPrimaryKey = equipmentService.selectByPrimaryKey(equipment.getId());
			equipment.setStatus(selectByPrimaryKey.getStatus());
			equipment.setCreatetime(selectByPrimaryKey.getCreatetime());
			equipmentService.updateByPrimaryKeySelective(equipment);
		} else {
			equipment.setCreatetime(new Long(System.currentTimeMillis() / 1000).intValue());
			equipment.setStatus(0);
			// sjcsProduct.setReleaseman(userlogin.getLoginname());
			// sjcsProduct.setReleasemanname(userlogin.getFullname());
			equipmentService.insert(equipment);
		}

		return "/equipment/equipmentList.jsp";
	}
	
	@RequestMapping("equipmentDel.action")
	@ResponseBody
	public Boolean equipmentDel(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("equipmentDel begin");
		if (pid != null) {

			int deleteByPrimaryKey = equipmentService.deleteByPrimaryKey(pid);
			return true;
		}

		return false;
	}
	
	@RequestMapping("activeEquipment.action")
	@ResponseBody
	public Boolean activeEquipment(HttpServletRequest request, Integer pid, Map<String, Object> map) {

		logger.info("activeEquipment begin");
		if (pid != null) {

			Equipment selectByPrimaryKey = equipmentService.selectByPrimaryKey(pid);
			selectByPrimaryKey.setStatus(1);
			equipmentService.updateByPrimaryKeySelective(selectByPrimaryKey);
			return true;
		}

		return false;
	}
	

}