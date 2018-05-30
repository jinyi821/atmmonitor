package com.ultrapower.clustercontrol.dao;

import com.ultrapower.clustercontrol.model.TestModel;

import java.util.List;

/**
 * @ClassName:com.ultrapower.cluster.control.dao.TestModelDaoMapper
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月22日 下午5:31:41
 * @version 1.0
 */
//@Mapper
public interface TestModelDaoMapper {	
   public List<TestModel> findAllTestModels(); 
}
