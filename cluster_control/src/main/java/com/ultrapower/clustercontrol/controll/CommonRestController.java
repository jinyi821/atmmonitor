package com.ultrapower.clustercontrol.controll;

import com.ultrapower.clustercontrol.model.TestModel;
import com.ultrapower.clustercontrol.tools.DataAccessConfig;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName:com.ultrapower.cluster.control.contrller.CommonRestController
 * @Description:TODO  
 * @author  fanjianfeng
 * @time  2018年5月21日 下午4:56:22
 * @version 1.0
 */

@RestController
@RequestMapping({"/common"})
public class CommonRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataAccessConfig  jdbcConfig;
	
	@RequestMapping(value = "/restTest")
	@ResponseBody
	public String restTest(){
	return "restTest";
	}
	
	@RequestMapping(value = "/jdbcTemplateTest")
	@ResponseBody
	@ApiOperation(value="获取测试模型", notes="")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	public String  jdbcTemplateTest(String user){
	List<TestModel> list = jdbcTemplate.query("SELECT id,name FROM test_model",new RowMapper<TestModel>(){
		  public TestModel mapRow(ResultSet resultSet, int i) throws SQLException {
			  TestModel testModel = new TestModel();
			  testModel.setId(resultSet.getInt("id"));
			  testModel.setName(resultSet.getString("name"));
              return testModel;
          }
	});
	System.out.println("listSize:"+list.size());
	for(int i=0;i<list.size();i++){
    TestModel  testModel=list.get(i);
	System.out.println(i+"/id:"+testModel.getId()+"/name:"+testModel.getName());
	}
	 return "jdbcTemplateTest";	
	}
	
	
	@RequestMapping(value = "/mainDataSourceTest")
	@ResponseBody
	public String  mainDataSourceTest() {
		System.out.println("mainDataSourceTest:");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn=jdbcConfig.getConnection();
			 String sql = "SELECT id,name FROM test_model";
			 pstmt=conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				  System.out.println("id:"+rs.getInt("id") + "\\name:"+rs.getString("name")); 				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		     if(conn!=null){
		    	 try {
					rs.close();
					pstmt.close();
			    	conn.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	 	    	 
		     }
			
		}
	return "mainDataSourceTest";	
	}
	
}