package com.portal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.constants.Constants;
import com.portal.model.UserLoginInfo;
import com.usermanager.model.BsMenu;
import com.usermanager.model.BsUserinfo;
import com.usermanager.services.BsUserMenuService;
import com.usermanager.services.BsUserRoleService;
import com.usermanager.services.BsUserinfoService;
import com.usermanager.services.BsUserloginRecordService;

/**
 * 
 * 
 * <p>
 * Title: [登录首页]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping(value = "portal")
public class PortalController {


	
	@Resource
	private BsUserinfoService bsUserinfoService;

	@Autowired
	private BsUserMenuService bsUserMenuService;

	@Resource
	private BsUserloginRecordService bsUserloginRecordService;
	@Resource
	private BsUserRoleService bsUserRoleService;
    
	private static String keyString = "A3F2569DESJEIWBCJOTY45DYQWF68H1Y";// 获得密钥的参数

	/**
	 * 
	 * Created on 2016-3-29
	 * <p>
	 * Discription:[导航栏菜单]
	 * </p>
	 * 
	 * @param map
	 * @param req
	 * @param res
	 * @return
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "header.action")
	public String header(Map<String, Object> map, HttpServletRequest req, HttpServletResponse res) {

		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		if (userlogin != null) {

			List<BsMenu> menuList = bsUserMenuService.getMenuListByUser(userlogin.getLoginname(), null, false);
			map.put("navigatorMenu", menuList);
			String menuId = req.getParameter("menuId");
			if (StringUtils.isNotBlank(menuId)) {
				map.put("menuId", menuId);
			}else {
				map.put("menuId", menuList.get(0).getMenuid());
			}
		}
		
		return "header.jsp";
	}

	/**
	 * 

	 * <p>
	 * Discription:[首页]
	 * </p>
	 * 
	 * @param map
	 * @return

	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "index.action")
	public String index(Map<String, Object> map, HttpServletRequest req) {		
	
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		if (userlogin != null) {

			List<BsMenu> menuList = bsUserMenuService.getMenuListByUser(userlogin.getLoginname(), null, false);
			map.put("navigatorMenu", menuList);
			String menuId = req.getParameter("menuId");
			if (StringUtils.isNotBlank(menuId)) {
				map.put("menuId", menuId);
				return "index.jsp";
			}else {
				map.put("menuId", menuList.get(0).getMenuid());
				String menuurl = menuList.get(0).getMenuurl();
				return "/"+menuurl;
			}
		}
		return "index.jsp";
	}

	

	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "login.action")
	public String login(HttpServletRequest req) {
		req.getSession().removeAttribute(Constants.USERSESSION);
		String flag = req.getParameter("flag");
		if (StringUtils.isNotBlank(flag)) {
			req.setAttribute("flag", flag);
		}
		return "login.jsp";
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "oldlogin.action")
	public String oldlogin(HttpServletRequest req) {
		req.getSession().removeAttribute(Constants.USERSESSION);
		return "oldlogin.jsp";
	}
	
	/**
	 * 
	 * Created on 2016-3-29
	 * <p>
	 * Discription:[维护菜单]
	 * </p>
	 * 
	 * @param map
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "weihu_index.action")
	public String weihu_index(Map<String, Object> map, HttpServletRequest req, Integer menuId) {
		boolean processApprovalFlag=false;//是否拥有流程审批菜单权限
		String  processApprovalUrl="eoms/workflow/workflowUnapprovedList.action"; //流程审批菜单url
		String url = req.getServletPath().substring(1);
		UserLoginInfo userlogin = (UserLoginInfo) req.getSession().getAttribute(Constants.USERSESSION);
		map.put("menuId", menuId);
		if (userlogin != null) {
			
			BsMenu menu1 = bsUserMenuService.getMenuByurl(userlogin.getLoginname(), url);
			if (menu1 != null) {
				if (menuId == null) {
					map.put("menuId",menu1.getMenuid());
				}
				List<BsMenu> menuList = bsUserMenuService.getMenuListByUser(userlogin.getLoginname(), menu1.getMenuid(), true);
				if (menuList != null && menuList.size() > 0) {
					map.put("secondMenu", menuList);
				}
				BsMenu processApprovalMenu=bsUserMenuService.getMenuByurl(userlogin.getLoginname(),processApprovalUrl);//流程审批菜单
				if(processApprovalMenu!=null){
					processApprovalFlag=true;					
				}
				map.put("processApprovalFlag", false);
			}			
		}
		return "weihu_index.jsp";
	}


	/**
	 * 
	 * Created on 2016年9月30日
	 * <p>
	 * Discription:[方法功能中文描述]
	 * </p>
	 * 
	 * @param userlogin
	 * @param req
	 * @param res
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "userLogin.action")
	public String userLogin(UserLoginInfo userlogin, HttpServletRequest req, HttpServletResponse res) {
		if (req.getSession().getAttribute(Constants.USERSESSION) == null) {
			if (null != userlogin.getLoginname() && null != userlogin.getPwd()) {
				BsUserinfo buser = bsUserinfoService.getBsUserinfoByLoginname(userlogin.getLoginname());
				if (null != buser) {
					if (userlogin.getPwd().equals(buser.getDecodePwd())) {
						if (buser.getStatus() == 1) {
							boolean isAdminRole = bsUserRoleService.judgeAdminRoleByLoginname(userlogin.getLoginname());
							userlogin.setFullname(buser.getFullname());
							userlogin.setStatus(buser.getStatus());
							userlogin.setSex(buser.getSex());
							userlogin.setEmail(buser.getEmail());
							userlogin.setMobile(buser.getMobile());
							userlogin.setIsanalyzer(buser.getIsanalyzer());
							userlogin.setIsdeveloper(buser.getIsdeveloper());
							userlogin.setIsAdminRole(isAdminRole);
							req.getSession().setAttribute(Constants.USERSESSION, userlogin);

							// 登录时把登录菜单放到缓存
							bsUserMenuService.putUserMenuCache(userlogin.getLoginname());
							List<BsMenu> menuList = bsUserMenuService.getMenuListByUser(userlogin.getLoginname(), null, false);
							req.getSession().setAttribute("navigatorMenu", menuList);
						

							req.setAttribute("flag", "");
							String forgerP = req.getParameter("forgerP");// 记住密码复选框被选中
							if (forgerP != null && forgerP.equals("on")) {
								// 创建Cookie对象
								Cookie nameCookie = new Cookie("loginname", userlogin.getLoginname());
								// 设置Cookie的有效期为7天
								nameCookie.setMaxAge(60 * 60 * 24 * 7);
								Cookie pwdCookie = new Cookie("pwd", userlogin.getPwd());
								pwdCookie.setMaxAge(60 * 60 * 24 * 7);
								Cookie forgerPCookie = new Cookie("forgerP", forgerP);
								forgerPCookie.setMaxAge(60 * 60 * 24 * 7);
								res.addCookie(nameCookie);
								res.addCookie(pwdCookie);
								res.addCookie(forgerPCookie);
							} else {
								Cookie forgerPCookie = new Cookie("forgerP", null);
								forgerPCookie.setMaxAge(60 * 60 * 24 * 7);
								res.addCookie(forgerPCookie);
							}
							try {
								// String url = (String)
								// req.getSession().getAttribute(Constants.REDIRECT_URL);
								// if (StringUtils.isNotBlank(url))
								// {
								// //目录重定向
								// url=req.getSession().getServletContext().getContextPath()+url;
								// res.sendRedirect(url);
								// }
								// else
								// {
								res.sendRedirect("index.action");
								// }
							} catch (IOException e) {
								e.printStackTrace();
							}
						
							bsUserloginRecordService.addBsUserloginRecord(userlogin.getLoginname(), 1);
							return null;
						} else {
							req.getSession().setAttribute(Constants.USERSESSION, null);
							bsUserloginRecordService.addBsUserloginRecord(userlogin.getLoginname(), 0);
							if (buser.getStatus()==0){
								req.setAttribute("flag", "error3"); // error3用户状态禁用
							}
							if (buser.getStatus()==2){
								req.setAttribute("flag", "error-310"); // 用户状态冻结
								req.setAttribute("loginname", buser.getLoginname());
							}
							return "login.action";
						}
					} else {
						req.getSession().setAttribute(Constants.USERSESSION, null);
						
						req.setAttribute("flag", "error2"); // error2 密码输入错误
						return "login.action";
					}
				} else {
					req.getSession().setAttribute(Constants.USERSESSION, null);
					req.setAttribute("flag", "error1");// error1 用户名不存在
					return "login.action";
				}
			} else {
				return "login.action";
			}
		} else {
			return "index.action";
		}

	}




	/**
	 * 
	 * Created on 2016-3-31
	 * <p>
	 * Discription:[重新登录]
	 * </p>
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "reloadLogin.action")
	public String reloadLogin(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().removeAttribute(Constants.USERSESSION);
		try {
			res.sendRedirect("index.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void output(HttpServletResponse response, String content) {
		try {
			response.setStatus(200);
			if (content != null) {
				response.setContentType("text/plain;charset=UTF-8");
				response.getWriter().write(content);
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
	
}
