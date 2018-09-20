package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.model.DcsUser;
import com.ultrapower.dcs.cluster.control.service.DcsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**登录、首页控制导航控制类
 * @ClassName:com.ultrapower.cluster.control.contrller.PortalController
 * @Description:TODO
 * @author  fanjianfeng
 * @time  2018年5月24日 下午2:40:47
 * @version 1.0
 */
@Controller
public class PortalController{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DcsUserService dcsUserService;
	@RequestMapping(value = "/index")
	public String index(ModelMap map,HttpServletRequest request){
		
		String contextPath = request.getContextPath();
		Object loginUser = request.getSession().getAttribute("loginUser");
		if (loginUser!=null) {
			map.addAttribute("loginUser", loginUser);
		}
		map.addAttribute("BASE_PATH", contextPath);

		// return模板文件的名称，对应src/main/resources/templates/index.html
		logger.info("-----index------");
		return "index";
	}
	
	/* *
	 * @Title   登录首页
	 * @Description  
	 * @Param     [map, request]
	 * @Return   java.lang.String
	 * @throws      
	 * @author   jinyi
	 * @Date   2018/7/13  10:35
	 **/
	@RequestMapping(value = "/")
	public String loginPage(ModelMap map,HttpServletRequest request){
		
		logger.info("-----loginPage------");
		String contextPath = request.getContextPath();
		map.addAttribute("BASE_PATH", contextPath);
		return "login";
	}
	
	/* *
	 * @Title     判断是否登录成功
	 * @Description  
	 * @Param     [map, request, dcsUser]
	 * @Return   java.lang.String
	 * @throws      
	 * @author   jinyi
	 * @Date   2018/7/13  10:35
	 **/
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(ModelMap map,HttpServletRequest request,DcsUser dcsUser){

		logger.info("-----login------");
		String contextPath = request.getContextPath();
		map.addAttribute("BASE_PATH", contextPath);
		List<DcsUser> list = dcsUserService.selectUserByloginname(dcsUser);

		if (list!=null && list.size()>0){
			request.getSession().setAttribute("loginUser",list.get(0));
			return "1";
		} else {
			return "0";
		}

	}
	
	/* *
	 * @Title     退出登录
	 * @Description  
	 * @Param     [request]
	 * @Return   java.lang.String
	 * @throws      
	 * @author   jinyi
	 * @Date   2018/7/13  14:05
	 **/
	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("loginUser");
		return "1";
	}

	@RequestMapping(value = "/demo")
	public String demo(ModelMap map,HttpServletRequest request){

		logger.info("-----loginPage------");
		String contextPath = request.getContextPath();
		map.addAttribute("BASE_PATH", contextPath);
		logger.info("-----demo------");
		return "form-templates";
	}







}
