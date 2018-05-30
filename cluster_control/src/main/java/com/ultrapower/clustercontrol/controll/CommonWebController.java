package com.ultrapower.clustercontrol.controll;

import com.ultrapower.clustercontrol.model.TestModel;
import com.ultrapower.clustercontrol.service.TestModelService;
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
	
	@Autowired
	private TestModelService testModelService;
	
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
