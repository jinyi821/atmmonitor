package com.ultrapower.clustercontrol.service.impl;

import com.ultrapower.clustercontrol.dao.TestModelDaoMapper;
import com.ultrapower.clustercontrol.model.TestModel;
import com.ultrapower.clustercontrol.service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:com.ultrapower.cluster.control.service.impl.TestModelServiceImpl
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月22日 下午5:49:50
 * @version 1.0
 */

@Service("testModelService")  
public class TestModelServiceImpl implements TestModelService {
   @Autowired  
   private TestModelDaoMapper testModelDaoMapper;  
   
   /**
	 * @Title
	 * @Description  
	 * @return
	 * @author  fanjianfeng
	 * @time  2018年5月22日 下午5:49:50
	 */
	@Override
	public List<TestModel> findAllTestModels() {		
		return testModelDaoMapper.findAllTestModels();
	}
	
    /**
     * @Title
     * @Description  
     * @return
     * @author  fanjianfeng
     * @time  2018年5月23日 下午5:31:43
    */
    @Override
    public List<TestModel> findAllTestModelsBysingleDataSource() {
	
	
	
	
	return null;
   }

}
