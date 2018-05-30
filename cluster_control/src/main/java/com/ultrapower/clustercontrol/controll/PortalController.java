package com.ultrapower.clustercontrol.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**登录、首页控制导航控制类
 * @ClassName:com.ultrapower.cluster.control.contrller.PortalController
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月24日 下午2:40:47
 * @version 1.0
 */
@Controller
@RequestMapping({"/portal"})
public class PortalController {
	
	@RequestMapping(value = "/index")
	public String index(){
     System.out.println("index:"+"/index");
	return "index";
	}
	
	@RequestMapping(value = "/indexTest")
	public String indexTest(){
     System.out.println("index:"+"/indexTest");
	return "index_test";
	}

}
