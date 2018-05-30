package com.ultrapower.clustercontrol.model;

import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName:com.ultrapower.cluster.control.model.TestModel
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月22日 下午5:29:23
 * @version 1.0
 */
@Mapper
public class TestModel {
      private Integer id;  
      private String name;  
      public Integer getId() {  
        return id;  
      }  
      public void setId(Integer id) {  
        this.id = id;  
      }  
      public String getName() {  
       return name;  
      }  
      public void setName(String name) {  
        this.name = name;  
      }  

}
