package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.common.core.util.StringUtils;
import com.common.core.util.TimeUtils;
import com.mysql.jdbc.Connection;

public class GbRelation {

	private void importgbTableRational(HSSFSheet st,Connection connection,long dominid)
	{
		Statement stmt;
		HSSFRow row;
		int startLine=1;
		String targetTblname;
		String targetColname;
		String sourceTblname;
		String sourceColname;
		String sql;
		String[] strary;
		try {
			stmt = connection.createStatement();
			while (true)
			{
				  row= st.getRow(startLine);
				  if(row==null)
					  break;
				  targetTblname=StringUtils.checkNullString(row.getCell(0).getStringCellValue()).trim();
				  targetColname=StringUtils.checkNullString(row.getCell(1).getStringCellValue()).trim();
				  sourceTblname=StringUtils.checkNullString(row.getCell(2).getStringCellValue()).trim();
				  sourceColname=StringUtils.checkNullString(row.getCell(3).getStringCellValue()).trim();
				  dominid=this.getTableDomainId(stmt, targetTblname);
				  strary=targetTblname.split("\\.");
				  if(strary.length>1)
					  targetTblname=strary[1];
				  strary=sourceTblname.split("\\.");
				  if(strary.length>1)
					  sourceTblname=strary[1];
				if(targetTblname.equals("")||sourceTblname.equals(""))
				{
					break;
				}
				sql=getImportgbTableRationalSql(stmt,dominid,targetTblname,targetColname,sourceTblname,sourceColname);
				if(!"".equals(sql))
				{
					stmt.execute(sql.toString());
				}
				
				startLine++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
	private String getImportgbTableRationalSql(Statement stmt, long dominid,String targetTblname,String targetColname,String sourceTblname,String sourceColname)
	{
		StringBuffer sql=new StringBuffer();
		long DOMAIN_ID=dominid;
		long COLUMNSET_ID=getTblid(stmt,targetTblname);
		long COLUMN_ID=getTableColumnid(stmt,COLUMNSET_ID,targetColname);
		long REF_COLUMNSET_ID=getTblid(stmt,sourceTblname);
		long REF_COLUMN_ID=getTableColumnid(stmt,REF_COLUMNSET_ID,sourceColname);
		long CREATETIME=0;
		
		if(checkExits(stmt,dominid,COLUMNSET_ID,REF_COLUMNSET_ID)<1)
		{
			sql.append("INSERT INTO `CFG_DOMAIN_COLUMNSET_REL` (`DOMAIN_ID`, `COLUMNSET_ID`,`COLUMN_ID`,`REF_COLUMNSET_ID`,`REF_COLUMN_ID`,`CREATETIME`) VALUES ( ");
			sql.append(DOMAIN_ID);
			sql.append(","+COLUMNSET_ID);
			sql.append(","+COLUMN_ID);
			sql.append(","+REF_COLUMNSET_ID);
			sql.append(","+REF_COLUMN_ID);
			sql.append(","+CREATETIME);
			sql.append(")");
		}
		
		checkdomain_columnset(stmt,dominid,COLUMNSET_ID);
		checkdomain_columnset(stmt,dominid,REF_COLUMNSET_ID);
		return sql.toString();

	}
	private long getTableDomainId(Statement stmt,String columnsetname)
	{
		long result=0;
		 try {
			 String sql="select d.domain_id from CFG_COLUMNSET a ,MAP_COLUMNSET_MODEL b,DIC_MODEL_CATEGORY c,dic_domain d "; 
			 sql+=" where  a.columnset_id=b.columnset_id and b.model_category_id=c.model_category_id and c.model_category_name=d.domain_name ";
			sql+=" and a.columnset_name='"+columnsetname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next()) 
			 {
				 result=rs.getLong("domain_id");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return result;
	}	
	private long getTableColumnid(Statement stmt,long columnsetid,String columnname)
	{
		long result=0;
		columnname=StringUtils.checkNullString(columnname).trim();
		 try {
			ResultSet rs = stmt.executeQuery("SELECT  COLUMN_ID from CFG_COLUMN where columnset_id="+columnsetid+" and column_name='"+columnname+"'");
			 while(rs.next()) 
			 {
				 result=rs.getLong("COLUMN_ID");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return result;
	}
	private long  checkdomain_columnset(Statement stmt,long DOMAIN_ID,long columnsetid)
	{
		long result=0;
	 
		 try {
			ResultSet rs = stmt.executeQuery("SELECT  count(*)  qty  from map_domain_columnset where COLUMNSET_ID="+columnsetid);
			 while(rs.next()) 
			 {
				 result=rs.getLong("qty");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		 if(result<1)
		 {
			 String sql=" INSERT INTO `map_domain_columnset` (`DOMAIN_ID`,`COLUMNSET_ID`) VALUES (  " +DOMAIN_ID+","+columnsetid+")";
			 try {
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return result;
	}
	
	private long  checkExits(Statement stmt,long dominid,long targetTblid,long sourceTblid)
	{
		long result=0;
	 
		 try {
			ResultSet rs = stmt.executeQuery("SELECT  count(*)  qty  from CFG_DOMAIN_COLUMNSET_REL where COLUMNSET_ID="+targetTblid+" and  REF_COLUMNSET_ID="+sourceTblid);
			 while(rs.next()) 
			 {
				 result=rs.getLong("qty");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return result;
	}
private long getTblid(Statement stmt,String tblname)
{
	long result=0;
	tblname=StringUtils.checkNullString(tblname).trim();
	 try {
		ResultSet rs = stmt.executeQuery("SELECT  COLUMNSET_ID from CFG_COLUMNSET where COLUMNSET_name='"+tblname+"'");
		 while(rs.next()) 
		 {
			 result=rs.getLong("COLUMNSET_ID");
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	return result;
}
	
	public static Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			connection = (Connection) DriverManager.getConnection("proxool.test:org.gjt.mm.mysql.Driver:jdbc:mysql://10.204.210.81:3310/test","root", "root123");
			//connection = (Connection) DriverManager.getConnection("proxool.test:org.gjt.mm.mysql.Driver:jdbc:mysql://127.0.0.1:3306/metadata?useUnicode=true&characterEncoding=UTF8","wyt", "wyt");
			// connection =
			// (Connection)DriverManager.getConnection("proxool.test:org.gjt.mm.mysql.Driver:jdbc:mysql://10.204.210.134:3306/test","root",
			// "root123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	private void importData(HSSFWorkbook rwb)
	{
		int sheets=rwb.getNumberOfSheets();
		Connection connect=this.getConnect();
		long dominid=1;
		HSSFSheet sheet=rwb.getSheetAt(0);
		importgbTableRational(sheet,connect,1);
	}
	public static void main(String[] args) throws Exception {
		HSSFWorkbook rwb = null;
		InputStream ins = null;
		File file = new File("/Users/xufq/Desktop/数据导入/GP库中表关联关系.xls");
		try {
			GbRelation exceImport=new GbRelation();
			ins = (InputStream) (new FileInputStream(file));
			rwb = new HSSFWorkbook(ins);
			Connection connection =getConnect();
			System.out.println("开始导数据"+TimeUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			exceImport.importData(rwb);
			System.out.println("结束导数据"+TimeUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
