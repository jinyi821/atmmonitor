package com.usermanager.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usermanager.services.BsVistRecordeService;

/**
 * 
 * Created on 2016-3-23
 * <p>Title:       [移动-用户管理-访问记录]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     </p>
 * @author         <a href=####@neusoft.com>jinyi</a>
 * @version        1.0
 */
@Controller  
@RequestMapping(value = "usermanager/bsvistrecorde")
public class BsVistRecordeController {
    

	@Resource
	private BsVistRecordeService bsVistRecordeService;

	// 查询信息
	@RequestMapping(value = "bsVistRecordeList.action")
	public String bsVistRecordeList() {
		
		return "bsVistRecordeList.jsp";
	}
	
    //删除信息
	@RequestMapping(value = "deleteBsVistRecordeById.action")
	public  String deleteBsVistRecordeById(Long pid,HttpServletRequest request)
	{
	    bsVistRecordeService.deleteBsVistRecordeById(pid);
		request.setAttribute("flag", "del");
		return "bsVistRecordesList.jsp";
	}

}
