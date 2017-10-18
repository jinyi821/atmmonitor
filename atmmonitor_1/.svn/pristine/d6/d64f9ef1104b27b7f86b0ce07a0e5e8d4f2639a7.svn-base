package com.usermanager.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.constants.Constants;
import com.portal.model.UserLoginInfo;
import com.usermanager.model.BsDep;
import com.usermanager.services.BsDepService;

@Controller
@RequestMapping(value="usermanager/bsdep")
public class BsDepController {
	private BsDep bsDep;
	@Resource
	private BsDepService bsDepService;

	@RequestMapping(value = "bsDepLoad.action")
	public String bsDepLoad(Map<String, Object> map, String pid) {
		if (pid != null ) {
			bsDep = this.bsDepService.getBsDepById(pid);
			map.put("bsDep", bsDep);
		}
		map.put("pid", pid);
		return "bsDepSave.jsp";
	}

	@RequestMapping(value = "bsDepSave.action")
	@ResponseBody	
	public String bsDepSave(BsDep bsDep,HttpServletRequest req) {
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		
		bsDep.setLastmodifier(userlogin.getLoginname());
		String result = "false";
		if (bsDepService.saveOrUpdateBsDep(bsDep)) {
			result = "ok";
		}
		return result;
	}

	@RequestMapping(value = "bsDepDel.action")
	@ResponseBody
	public String bsDepDel(String pid) {
		String result = "false";
		if(this.bsDepService.deleteBsDepById(pid)){
			result = "ok";
		}
		return result;
	}

	public String bsDepList() {
		return "bsDepList.jsp";
	}
	
	@RequestMapping(value = "bsDepTreeManager.action")
	public String bsDepTreeManager(){
		return "bsDepTreeManager.jsp";
	}
	
	@RequestMapping(value = "getChildNode.action")
	public void getChildNode(String id,HttpServletResponse response){
		String xml = this.bsDepService.getChildNode(id);
		response.setContentType("text/xml;charset=UTF-8");
		try {
			response.getWriter().write(xml.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "getUseDepChildNode.action")
	public void getUseDepChildNode(String id,String type,HttpServletResponse response){
			String xml = bsDepService.getUseChildNode(id,type);
			response.setContentType("text/xml;charset=UTF-8");
			try {
				response.getWriter().write(xml.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 

	@RequestMapping(value = "createDnsAndDn.action")
	public void createDnsAndDn(){
		this.bsDepService.createDnAndDns(null, null);
	}
}
