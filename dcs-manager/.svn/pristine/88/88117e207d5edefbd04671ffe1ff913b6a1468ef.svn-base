package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.model.TestModel;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.TestModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @ClassName:com.ultrapower.cluster.control.contrller.CommonWebController
 * @Description:TODO  
 * @author  fanjianfeng
 * @tim  2018年5月22日 上午10:05:07
 * @version 1.0
 */
@ApiIgnore
@Controller
@RequestMapping({"/common"})
public class CommonWebController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TestModelService testModelService;

	@Autowired
	private DcsFtpServerServer dcsFtpServerServer;
	
	@RequestMapping(value = "/webTest")
	public String webTest(){
     System.out.println("webTest:"+"/index_test");
	return "index_test";
	}
	
	@RequestMapping(value = "/modelTest")
	public String modelTest(Model model){
	 List<TestModel> testModelList=testModelService.findAllTestModels();
	 System.out.println("testModelList.length:"+testModelList.size());
	 model.addAttribute("testModelList", testModelList);
	return "model_test";
	}

}
