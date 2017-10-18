package com.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.sf.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CreateFile {
	public static final String LINE_SEPERATOR = "";
//			(String)java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));

	private void createModel(String path,String bean,String module,String tab)throws Exception
	{
		String fullPath=path+"/"+bean+".java";
		//FileOperUtil.createNewFile(fullPath);
		File myFilePath = new File(fullPath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println("package "+module+".model;");
		myFile.println( CreateFile.LINE_SEPERATOR);
		myFile.println("import javax.persistence.Entity;");
		myFile.println("import javax.persistence.Table;");
		myFile.println("import javax.persistence.Column;");
		myFile.println("import javax.persistence.Id;");
		myFile.println("import javax.persistence.GeneratedValue;");
		myFile.println("import javax.persistence.GenerationType;");
		myFile.println("import org.hibernate.annotations.GenericGenerator;");
		myFile.println(LINE_SEPERATOR);
		myFile.println("@Entity");
		myFile.println("@Table(name=\""+tab+"\")");
		myFile.println(LINE_SEPERATOR);
		myFile.println("public class "+bean+" implements java.io.Serializable ");
		 
		myFile.println("{");
		
		Connection con = this.getConnect();
		if(con!=null)
		{
			Statement pstmt=(Statement) con.createStatement();
			ResultSet resultSet=pstmt.executeQuery("show columns from "+tab);
			String colName;
			String type;
			String allowNull;
			String key;
			
			int precision=0;
			int scale=0;
			
			String colNameUp;
			StringBuffer strSeting=new StringBuffer();
			
			while(resultSet.next())
			{
				colName=resultSet.getString("Field").toLowerCase();
				colNameUp=colName.substring(0,1).toUpperCase() +colName.substring(1);
				type=resultSet.getString("type");
				allowNull=resultSet.getString("null");
				key=resultSet.getString("key");
				if("PRI".equals(key))
				{
					if(type.indexOf("varchar")>-1||type.indexOf("bigint")>-1)
					{
						strSeting.append("	@Id\r\n");
						strSeting.append("	@GeneratedValue(strategy=GenerationType.IDENTITY)\r\n");
					}
				}
				if(type.indexOf("varchar")>-1||type.indexOf("text")>-1)
				{
					/*
					if(type.indexOf("varchar")>-1)
					{
						precision=Integer.parseInt(type.substring(type.indexOf("(")+1,type.indexOf(")")));
					}
					else
					{
						precision=0;
					}
					*/
	 
					/*
					strSeting.append("	@Column(name=\""+colName.toUpperCase()+"\", ");
					if("PRI".equals(key))
					{
						strSeting.append(" unique=true,");
					}
					else
					{
						strSeting.append(" unique=false,");
					}
					if("YES".equals(allowNull))
					{
						strSeting.append("nullable=true,");
					}
					else
					{
						strSeting.append("nullable=false,");
					}
					strSeting.append("insertable=true, updatable=true");
					if(precision>0)
					{
						strSeting.append(",length="+precision+")\r\n");
					}
					else
					{
						strSeting.append(")\r\n");
					}
					*/
					strSeting.append("	public String get"+colNameUp+"() \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		return this."+colName+";\r\n");
					strSeting.append("	}\r\n");	
					
					myFile.println("	private String "+ colName+";");
					strSeting.append("	public void set"+colNameUp+"(String "+colName+") \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		this."+colName+"="+colName+";\r\n");
					strSeting.append("	}\r\n");					
				}
				else if(type.indexOf("decimal")>-1 )
				{
					/*
					precision=Integer.parseInt(type.substring(type.indexOf("(")+1,type.indexOf(",")));
					scale=Integer.parseInt(type.substring(type.indexOf(",")+1,type.indexOf(")")));
				
					strSeting.append("	@Column(name=\""+colName.toUpperCase()+"\", ");
					if("PRI".equals(key))
					{
						strSeting.append(" unique=true,");
					}
					else
					{
						strSeting.append(" unique=false,");
					}
					if("YES".equals(allowNull))
					{
						strSeting.append("nullable=true,");
					}
					else
					{
						strSeting.append("nullable=false,");
					}
					strSeting.append("insertable=true, updatable=true,");
					strSeting.append("precision="+precision+", scale="+scale+") \r\n");
					*/
					if(scale>0)
					{
						strSeting.append("	public Double get"+colNameUp+"() \r\n");
					}
					else
					{
						strSeting.append("	public Long get"+colNameUp+"() \r\n");
					}
					strSeting.append("	{\r\n");
					strSeting.append("		return this."+colName+";\r\n");
					strSeting.append("	}\r\n");	
					
					if(scale>0)
					{
						myFile.println("	private Double "+ colName+";");
						strSeting.append("	public void set"+colNameUp+"(Double "+colName+") \r\n");
					}
					else
					{
						myFile.println("	private Long "+ colName+";");
						strSeting.append("	public void set"+colNameUp+"(Long "+colName+") \r\n");
					}
					
					strSeting.append("	{\r\n");
					strSeting.append("		this."+colName+"="+colName+";\r\n");
					strSeting.append("	}\r\n");					
					
					
				}
				else if(type.indexOf("bigint")>-1)
				{
					myFile.println("	private Long "+ colName+";");
					strSeting.append("	public Long get"+colNameUp+"() \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		return this."+colName+";\r\n");
					strSeting.append("	}\r\n");	
					strSeting.append("	public void set"+colNameUp+"(Long "+colName+") \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		this."+colName+"="+colName+";\r\n");
					strSeting.append("	}\r\n");					
				}
				else if(type.indexOf("int")>-1)
				{
					myFile.println("	private Integer "+ colName+";");
					strSeting.append("	public Integer get"+colNameUp+"() \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		return this."+colName+";\r\n");
					strSeting.append("	}\r\n");	
					strSeting.append("	public void set"+colNameUp+"(Integer "+colName+") \r\n");
					strSeting.append("	{\r\n");
					strSeting.append("		this."+colName+"="+colName+";\r\n");
					strSeting.append("	}\r\n");					
					
					
				}
				else
				{
				//	precision=Integer.parseInt(type.substring(type.indexOf("(")+1,type.indexOf(")")));
					//type=type.substring(0,type.indexOf("("));
					myFile.println("	private "+type+" "+ colName+";");
		 
					strSeting.append("	public void set"+colNameUp+"("+type+" "+colName+") \r\n");
						
					
					strSeting.append("	{\r\n");
					strSeting.append("		this."+colName+"="+colName+";\r\n");
					strSeting.append("	}\r\n");
					/*
					strSeting.append("	@Column(name=\""+colName.toUpperCase()+"\", ");
					if("PRI".equals(key))
					{
						strSeting.append(" unique=true,");
					}
					else
					{
						strSeting.append(" unique=false,");
					}
					if("YES".equals(allowNull))
					{
						strSeting.append("nullable=true,");
					}
					else
					{
						strSeting.append("nullable=false,");
					}
					strSeting.append("insertable=true, updatable=true,");
					strSeting.append("length="+precision+") \r\n");
		 			*/
					strSeting.append("	public "+type+" get"+colNameUp+"() \r\n");
					 
					strSeting.append("	{\r\n");
					strSeting.append("		return this."+colName+";\r\n");
					strSeting.append("	}\r\n");							
					
				}
			}

			myFile.println(strSeting.toString());
			resultSet.close();
			pstmt.close();
			con.close();
		}
		myFile.println("}");
		resultFile.close();		
	}
	private void createWeb()
	{
		
	}
	private void createImpl(String path,String bean,String module) throws Exception
	{
		String fullPath=path+"/"+bean+"Impl.java";
		//FileOperUtil.createNewFile(fullPath);
		File myFilePath = new File(fullPath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println("package "+module+".manager;");
		myFile.println("import org.springframework.transaction.annotation.Transactional;");
		
		myFile.println("import java.util.List;");
		myFile.println("import com.common.dao.IDAO;");
		myFile.println("import "+module+".services."+bean+"Service;");
		myFile.println("import com.common.core.util.StringUtils;");
		myFile.println("import "+module+".model."+bean+";");
		myFile.println("@Transactional");
		myFile.println("public class "+bean+"Impl implements "+bean+"Service");
		myFile.println("{");
		
		String beanLc=bean.substring(0,1).toLowerCase()+bean.substring(1);
		String daoName=beanLc+"Dao";
		myFile.println("	private IDAO<"+bean+",Long> "+daoName+";");
		myFile.println("	public  IDAO<"+bean+",Long> get"+bean+"Dao()");
		myFile.println("	{");
		myFile.println("		return "+daoName+";");
		myFile.println("	}");
		myFile.println("	public  void set"+bean+"Dao(IDAO<"+bean+",Long> "+daoName+")");
		myFile.println("	{");
		myFile.println("	 	this."+daoName+"="+daoName+";");
		myFile.println("	}");
		
		 
		
		myFile.println("	 ");
		
		myFile.println("	public boolean  add"+bean+"("+bean+" "+beanLc+") ");
		myFile.println("	{");
		myFile.println("		boolean result=false;");
		myFile.println("		if("+beanLc+"!=null)");
		myFile.println("		{");
		myFile.println("			if("+beanLc+".getStatus()==null)");
		myFile.println("			{");
		myFile.println("				"+beanLc+".setStatus(1);");
		myFile.println("			}");
		myFile.println("			"+beanLc+".setCreatetime(System.currentTimeMillis()/1000);");
		myFile.println("			"+daoName+".save("+beanLc+");");
	    myFile.println("			result=true;");
		myFile.println("		}");
		myFile.println("		return result;");
		myFile.println("	}");
			 
		myFile.println("	 ");
		
	
		
		
/*		myFile.println("	public boolean  update"+bean+"("+bean+" "+beanLc+") ");
		myFile.println("	{");
		myFile.println("	  boolean result=false;");
		myFile.println("	  "+daoName+".saveOrUpdate("+bean+");");
		myFile.println("	  return result;");
		myFile.println("	}");
		myFile.println("	 ");*/
		
		myFile.println("	public boolean  saveOrUpdate"+bean+"("+bean+" "+beanLc+")");
		myFile.println("	{");
		
		myFile.println("	  	boolean result=false;");
		myFile.println("	  	if("+beanLc+"!=null)");		
		myFile.println("	  	{");		
		myFile.println("	  		String pid=StringUtils.checkNullString("+beanLc+".getPid()).trim();");		
		myFile.println("	  		if(pid.equals(\"\"))");		
		myFile.println("	  		{");		
		myFile.println("	  			result=this.add"+bean+"("+beanLc+");");
		myFile.println("	  		}");		
		myFile.println("	  		else");		
		myFile.println("	  		{");		
		myFile.println("	  			"+daoName+".saveOrUpdate("+beanLc+");");
		myFile.println("	  			result=true;");
		myFile.println("	  		}");		
		myFile.println("	  	}");		
		myFile.println("	  	return result;");
		myFile.println("	}");
		myFile.println("	 ");
		
		myFile.println("	public boolean  delete"+bean+"ById"+"(Long "+beanLc+"Id) ");
		myFile.println("	{");
		myFile.println("	  	boolean result=false;");
		myFile.println("	  	"+daoName+".deleteByKey("+beanLc+"Id);");
		myFile.println("	  	result=true;");
		myFile.println("	  	return result;");
		myFile.println("	}");
		myFile.println("	 ");
		myFile.println("	public "+bean+"  get"+bean+"ById"+"(Long pid) ");
		myFile.println("	{");
		myFile.println("		return "+daoName+".get(pid);");
		myFile.println("	}");
		
		myFile.println("	public boolean  delete"+bean+"ByIds"+"(List<Long> "+beanLc+"IdList) ");
		myFile.println("	{");
		myFile.println("		int lstLen="+beanLc+"IdList==null?0:"+beanLc+"IdList.size();");
		myFile.println("		for (int i = 0; i < lstLen; i++)");
		myFile.println("		{");
		myFile.println("			if (!this.delete"+bean+"ById( "+beanLc+"IdList.get(i)))");
		myFile.println("			return false;");
		myFile.println("		}");
		myFile.println("		return true;");		
		myFile.println("	}");
		
		myFile.println("}");
		
		resultFile.close();		
	}
	
	private void createServices(String path,String bean,String module) throws Exception
	{
		String fullPath=path+"/"+bean+"Service.java";
		//FileOperUtil.createNewFile(fullPath);
		File myFilePath = new File(fullPath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		String beanLc=bean.substring(0,1).toLowerCase()+bean.substring(1);
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println("package "+module+".services;");
		myFile.println("import java.util.List;");
		myFile.println("import "+module+".model."+bean+";");
		myFile.println("public interface "+bean+"Service");
		myFile.println("{");
		myFile.println("	public boolean  add"+bean+"("+bean+" "+bean.toLowerCase()+"); ");
//		myFile.println("	public boolean  update"+bean+"("+bean+" "+bean.toLowerCase()+"); ");
		myFile.println("	public boolean  saveOrUpdate"+bean+"("+bean+" "+bean.toLowerCase()+"); ");
		myFile.println("	public boolean  delete"+bean+"ById"+"(Long pid); ");
		myFile.println("	public "+bean+"  get"+bean+"ById"+"(Long pid); ");
		myFile.println("	public boolean  delete"+bean+"ByIds"+"(List<Long> "+beanLc+"IdList);");
		myFile.println("}");
		resultFile.close();
		
	}
	
	public Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			connection = (Connection)DriverManager.getConnection("jdbc:mysql://10.204.210.134:3306/test?useUnicode=true&characterEncoding=UTF8","root", "root123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
	private void createAction(String path,String bean,String module) throws Exception
	{
		String fullPath=path+"/"+bean+"Controller.java";
		//FileOperUtil.createNewFile(fullPath);
		File myFilePath = new File(fullPath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println("package "+module+".controller;");
		
		myFile.println("import java.util.Map;");
		myFile.println("import javax.annotation.Resource;");
		myFile.println("import org.springframework.stereotype.Controller;");
		myFile.println("import org.springframework.web.bind.annotation.PathVariable;");
		myFile.println("import org.springframework.web.bind.annotation.RequestMapping;");
		myFile.println("import org.springframework.web.bind.annotation.RequestMethod;");
		myFile.println("import com.common.core.util.StringUtils;");
		myFile.println("import "+module+".services."+bean+"Service;");
		myFile.println("import "+module+".model."+bean+";");
		String beanLc=bean.substring(0,1).toLowerCase()+bean.substring(1);
		myFile.println("@Controller");
		myFile.println("public class "+bean+"Controller {");
		myFile.println("	private "+bean+"  "+beanLc+";");
		myFile.println("	private "+bean+"Service  "+beanLc+"Service;");
 	
		
		myFile.println("	public  "+bean+"Service get"+bean+"Service()");
		myFile.println("	{");
		myFile.println("		return "+beanLc+"Service;");
		myFile.println("	}");
		myFile.println("	public  void set"+bean+"Service("+bean+"Service "+beanLc+"Service)");
		myFile.println("	{");
		myFile.println("	 	this."+beanLc+"Service="+beanLc+"Service;");
		myFile.println("	}");
		myFile.println("");		
		myFile.println("@RequestMapping(value = \""+beanLc+"Load.action\")");
		myFile.println("	public  String "+beanLc+"Load(Map<String,Object> map,Long pid)");
		myFile.println("	{");	
		myFile.println("		if (pid!=null)");
		myFile.println("		{");
		myFile.println("			"+beanLc+"=this."+beanLc+"Service.get"+bean+"ById(pid);");
		myFile.println("			map.put(\""+beanLc+"\","+beanLc+");");
		myFile.println("		}");
		myFile.println("		return \""+beanLc+"Save.jsp\";");		
		myFile.println("	}");		
		myFile.println("");		
		myFile.println("@RequestMapping(value = \""+beanLc+"Save.action\")");
		myFile.println("	public  String "+beanLc+"Save("+bean+" "+beanLc+")");
		myFile.println("	{");		
		myFile.println("		if("+beanLc+"Service.saveOrUpdate"+bean+"("+beanLc+"))");
		myFile.println("		{");
		myFile.println("		}");
		myFile.println("		return \"\";");		
		myFile.println("	}");		
		myFile.println("@RequestMapping(value = \""+beanLc+"Del.action\")");
		myFile.println("	public  String "+beanLc+"Del()");
		myFile.println("	{");		
		myFile.println("		return \"\";");		
		myFile.println("	}");
		myFile.println("	public  String "+beanLc+"List()");
		myFile.println("	{");		
		myFile.println("		return \""+beanLc+"List.jsp\";");		
		myFile.println("	}");
		
  	
		
		myFile.println("}");
		
		resultFile.close();
		
	}
	public void createConfig(String path,String bean,String module) throws Exception
	{
		String fullPath=path+"/"+bean+"config.txt";
		//FileOperUtil.createNewFile(fullPath);
		File myFilePath = new File(fullPath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		String beanLc=bean.substring(0,1).toLowerCase()+bean.substring(1);
		myFile.println("<!------ Spring config ------->");
		
		myFile.println("<bean id=\""+beanLc+"Service\" class=\""+module+".manager."+bean+"Impl\" />");
		myFile.println("<bean id=\""+beanLc+"Dao\" class=\"com.common.dao.HibernateDaoImpl\">");
		myFile.println("	<property name=\"entityClass\">");
		myFile.println("		<value>"+module+".model."+bean+"</value>");
		myFile.println("	</property>");
		myFile.println("</bean>");	
		
 		
		resultFile.close();
	}
	
	public static void main(String[] args)
	{
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 3);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(calendar.getTime()));
	/*	try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			Connection conn=(Connection) DriverManager.getConnection("proxool.mysql");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
 		 
		CreateFile ctfile=new CreateFile();
		String filepath="E:\\testjava";
		String module="com.metadata.tableau";
		String bean="TableauDatasourceAccessStatistics";
		String tab="tableau_datasource_access_statistics";
		try {
			ctfile.createModel(filepath,bean,module,tab);
			ctfile.createServices(filepath,bean,module);
			ctfile.createImpl(filepath,bean,module);
			ctfile.createAction(filepath,bean,module);
			ctfile.createConfig(filepath,bean,module);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
