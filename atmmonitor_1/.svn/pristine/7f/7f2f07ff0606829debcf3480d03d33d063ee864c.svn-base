package com.usermanager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usermanager.model.BsMenu;
import com.usermanager.services.BsMenuService;

@Controller
@RequestMapping(value = "usermanager/bsmenu")
public class BsMenuController {
	private BsMenu bsMenu;
	private BsMenuService bsMenuService;

	public BsMenuService getBsMenuService() {
		return bsMenuService;
	}

	public void setBsMenuService(BsMenuService bsMenuService) {
		this.bsMenuService = bsMenuService;
	}

	@RequestMapping(value = "bsMenuLoad.action")
	public String bsMenuLoad(Map<String, Object> map, Integer pid) {
		if (pid != null) {
			bsMenu = this.bsMenuService.getBsMenuById(pid);
			map.put("bsMenu", bsMenu);
		}
		return "bsMenuSave.jsp";
	}

	@RequestMapping(value = "toBsMenuSave.action")
	public String toBsMenuLoadSave(Map<String, Object> map, Integer parentid) {
		map.put("parentid", parentid);
		return "bsMenuSave.jsp";
	}

	@RequestMapping(value = "bsMenuSave.action")
	@ResponseBody
	public String bsMenuSave(BsMenu bsMenu) {
		bsMenu.setCreatetime(System.currentTimeMillis() / 1000);
		if (bsMenuService.saveOrUpdateBsMenu(bsMenu)) {
		}
		return "ok";
	}

	@RequestMapping(value = "bsMenuChildExist.action")
	@ResponseBody
	public String bsMenuChildExist(Map<String, Object> map, Integer menuid) {
		String result = "";
		boolean flag = false;
		List<BsMenu> bsMenuList = bsMenuService.findChlidMenuByParentId(menuid);
		int lens = bsMenuList == null ? 0 : bsMenuList.size();
		if (lens > 0) {
			flag = true;
		}
		JSONObject json = new JSONObject();
		json.put("flag", String.valueOf(flag));
		result = json.toString();
		return result;
	}

	@RequestMapping(value = "saveBsMenuForJson.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveBsMenuForJson(String menujson) {
		String result = "";
		JSONArray jsonArray = JSONArray.fromObject(menujson);
		Object[] aryJson = jsonArray.toArray();
		int lens = aryJson == null ? 0 : aryJson.length;
		JSONObject jsonObject;
		BsMenu bsmenu1;
		if (lens > 0) {
			jsonObject = (JSONObject) aryJson[0];
			bsmenu1 = (BsMenu) JSONObject.toBean(jsonObject, BsMenu.class);
			bsmenu1.setCreatetime(System.currentTimeMillis() / 1000);
			if (bsMenuService.saveOrUpdateBsMenu(bsmenu1)) {
			}
		}
		result = "ok";
		return result;
	}

	@RequestMapping(value = "bsMenuDel.action")
	@ResponseBody
	public String bsMenuDel(Integer menuid) {
		String result = "";
		bsMenuService.deleteBsMenuById(menuid);
		result = "ok";
		return result;
	}

	@RequestMapping(value = "bsMenuLeft.action")
	public String bsMenuLeft() {
		return "bsMenuLeft.jsp";
	}

	@RequestMapping(value = "getChildNode.action")
	public void getChildNode(HttpServletResponse response, Integer id) throws IOException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0'  encoding='utf-8'?>");
		if (id == 0) {
			xml.append("<tree id='" + id + "'>");
			xml.append("<item id='999999' text='系统菜单'>");
			String item = "";
			List<BsMenu> bsMenuList = bsMenuService.findChlidMenuByParentId(null);
			int lens = bsMenuList == null ? 0 : bsMenuList.size();
			BsMenu bsmenu;
			for (int i = 0; i < lens; i++) {
				bsmenu = bsMenuList.get(i);
				xml.append("<item id='" + bsmenu.getMenuid() + "' text='" + bsmenu.getMenuname() + "' child='1'/>");
			}
			xml.append(item);
			xml.append("</item>");
		} else {
			xml.append("<tree id='" + id + "'>");
			String item = "";
			List<BsMenu> bsMenuList = bsMenuService.findChlidMenuByParentId(id);
			int lens = bsMenuList == null ? 0 : bsMenuList.size();
			BsMenu bsmenu;
			for (int i = 0; i < lens; i++) {
				bsmenu = bsMenuList.get(i);
				xml.append("<item id='" + bsmenu.getMenuid() + "' text='" + bsmenu.getMenuname() + "' child='1'/>");
			}
			xml.append(item);
		}
		xml.append("</tree>");
		response.setContentType("text/xml;charset=UTF-8");
		response.getWriter().write(xml.toString());
	}

	@RequestMapping(value = "bsMenuRight.action")
	public String bsMenuRight(Map<String, Object> map, Integer id) throws Exception {

		if (id == 0) {
		} else {
			bsMenu = bsMenuService.getBsMenuById(id);
		}
		map.put("id", id);
		map.put("bsMenu", bsMenu);
		return "bsMenuRight.jsp";
	}

	@RequestMapping(value = "bsMenuList.action")
	public String bsMenuList() {
		return "bsMenuFrame.jsp";
	}
}
