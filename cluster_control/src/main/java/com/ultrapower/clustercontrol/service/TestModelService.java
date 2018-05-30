package com.ultrapower.clustercontrol.service;

import com.ultrapower.clustercontrol.model.TestModel;

import java.util.List;

/**
 * @ClassName:com.ultrapower.cluster.control.service.TestModelService
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月22日 下午5:36:17
 * @version 1.0
 */

public interface TestModelService {
	 public List<TestModel> findAllTestModels(); 
	 
	 public List<TestModel> findAllTestModelsBysingleDataSource();
}
