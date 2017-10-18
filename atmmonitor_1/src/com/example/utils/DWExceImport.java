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

public class DWExceImport {

	

	private void importTble(HSSFSheet st,Connection connection)
	{
		if(st==null)
			return ;
		StringBuffer tblsql=new StringBuffer(" INSERT INTO  `CFG_COLUMNSET`");
		tblsql.append("(");
		tblsql.append("`COLUMNSET_NAME`,");
		tblsql.append("`COLUMNSET_TYPE_ID`,");
		tblsql.append("`DS_ID`,");
		tblsql.append("`COLUMNSET_DESC`,");
		tblsql.append("`COLUMNSET_FRIENDLY_NAME`,");
		tblsql.append("`COLUMNSET_LOCATION`,");
		tblsql.append("`CREATETIME`,");
		tblsql.append("`LASTMODIFYTIME`)");
		tblsql.append("VALUES");
		tblsql.append("(");
		String COLUMNSET_NAME;
		int startLine=1;
		StringBuffer tblInsert;
		
		Statement stmt =null;
		HSSFRow row;
		String categoryname;
		String COLUMNSET_DESC;
		long tblid;
		try {
				stmt = connection.createStatement();
				while (true)
				{
					  row= st.getRow(startLine);
					  if(row==null)
						  break;
					categoryname=StringUtils.checkNullString(row.getCell(1).getStringCellValue()).trim();
					COLUMNSET_NAME=StringUtils.checkNullString(row.getCell(2).getStringCellValue()).trim();
					COLUMNSET_DESC=StringUtils.checkNullString(row.getCell(3).getStringCellValue()).trim();
					tblid=this.getTblid(stmt, COLUMNSET_NAME);
					if(tblid>0)
					{
						stmt.execute("delete from cfg_column where columnset_id='"+tblid+"'");
						//stmt.execute("delete from cfg_column where  columnset_id in (select  columnset_id from cfg_columnset where columnset_name='"+tblid+"')");
						stmt.execute("delete from cfg_columnset where columnset_id='"+tblid+"'");
						stmt.execute("delete from map_columnset_model where columnset_id='"+tblid+"'");
						continue;
					}					
					if(COLUMNSET_NAME.equals(""))
					{
						break;
					}
					tblInsert=new StringBuffer();
					tblInsert.append(tblsql.toString());
					tblInsert.append("'"+COLUMNSET_NAME+"',");
					tblInsert.append("0,");
					tblInsert.append("0,");
					tblInsert.append("'"+COLUMNSET_DESC+"',");
					tblInsert.append("'',");
					tblInsert.append("'',");
					tblInsert.append(System.currentTimeMillis()/1000+"," );
					tblInsert.append(System.currentTimeMillis()/1000 +");");
					//stmt.execute(tblInsert.toString());
					int columnsetid=0;
					stmt.execute(tblInsert.toString(),Statement.RETURN_GENERATED_KEYS);
					ResultSet resultSet2 = stmt.getGeneratedKeys();  
		            if (resultSet2.next()) {  
		            	columnsetid= resultSet2.getInt(1);  
		            }  					
					insertMode(stmt,columnsetid,categoryname);
					startLine++;
				}			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	
private String insertMode(Statement stmt,long columnsetid, String categoryname)
{
	long MODEL_CATEGORY_ID=getCategoreId(stmt,categoryname);
	
	
	String sql="INSERT INTO `MAP_COLUMNSET_MODEL` ";
	sql+="(`COLUMNSET_ID`,`MODEL_CATEGORY_ID`)VALUES("+columnsetid+","+MODEL_CATEGORY_ID;
	sql+=")";
	try {
		stmt.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sql;
}

private long getCategoreId(Statement stmt,String categoryname)
{
	long result=0;
	categoryname=StringUtils.checkNullString(categoryname).trim();
	 try {
		ResultSet rs = stmt.executeQuery("SELECT  MODEL_CATEGORY_ID FROM DIC_MODEL_CATEGORY  where MODEL_CATEGORY_NAME='"+categoryname+"'");
		 while(rs.next()) 
		 {
			 result=rs.getLong("MODEL_CATEGORY_ID");
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	 
	return result;
}

private  void insertcolumn(Connection connection,String tblname,HSSFSheet st)
{
	StringBuffer sql;
	long COLUMNSET_ID;
	long DATA_TYPE_ID=1;
	String COLUMN_NAME=tblname;
	String COLUMN_DESC="";
	long COLUMN_SEQUENCE_NUMBER=0;
	long CREATETIME=System.currentTimeMillis()/1000;
	long LASTMODIFYTIME=CREATETIME;
	int startLine=2;
	Statement stmt =null;
	HSSFRow row;
	if(COLUMN_NAME.equals(""))
	{
		return ;
	}
	try {
		stmt = connection.createStatement();
		COLUMNSET_ID=this.getTblid(stmt, tblname);
		stmt.execute("delete from cfg_column where columnset_id='"+COLUMNSET_ID+"'");
		while (true)
		{
	
			sql=new StringBuffer();
			row=st.getRow(startLine);
			if(row==null) break ;
			COLUMN_NAME=StringUtils.checkNullString(row.getCell(0).getStringCellValue()).trim();
			if(row.getCell(1)!=null)
			{
				COLUMN_DESC=StringUtils.checkNullString(row.getCell(1).getStringCellValue()).trim();
			}
			if(COLUMN_DESC.length()>60)
			{
				COLUMN_DESC=COLUMN_DESC.substring(0,60);
			}
			if(COLUMN_NAME.equals("")) break;
			sql.append("INSERT INTO  `cfg_column` (`COLUMNSET_ID`,`DATA_TYPE_ID`,`COLUMN_NAME`,`COLUMN_DESC`,`COLUMN_SEQUENCE_NUMBER`,`CREATETIME`,`LASTMODIFYTIME`) VALUES");
			sql.append("(");
			sql.append(COLUMNSET_ID+",");
			sql.append(DATA_TYPE_ID+",");
			sql.append("'"+COLUMN_NAME+"',");
			sql.append("'"+COLUMN_DESC+"',");
			sql.append(COLUMN_SEQUENCE_NUMBER+",");
			sql.append(CREATETIME+",");
			sql.append(LASTMODIFYTIME);
			sql.append(")");
			stmt.execute(sql.toString());
			startLine++;
		}
		stmt.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
			//connection = (Connection) DriverManager.getConnection("proxool.test:org.gjt.mm.mysql.Driver:jdbc:mysql://127.0.0.1:3306/metadata?useUnicode=true&characterEncoding=UTF8","wyt", "wyt");
			connection = (Connection) DriverManager.getConnection("proxool.test:org.gjt.mm.mysql.Driver:jdbc:mysql://10.204.210.81:3310/test","root", "root123");
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
		HSSFSheet st;
		int sheets=rwb.getNumberOfSheets();
		Connection connect;
		for(int i=0;i<sheets;i++)
		{
			st=rwb.getSheetAt(i);
			if(i==0)
			{
				connect=this.getConnect();
				//导入表
				importTble(st,connect);
				try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
			 String tblname=StringUtils.checkNullString(st.getSheetName()).trim();
			 System.out.println(i+"开始导 "+tblname+" "+TimeUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			 connect=this.getConnect();
			// insertcolumn(connect,tblname,st);
			 try {
				connect.close();
				connect=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		HSSFWorkbook rwb = null;
		InputStream ins = null;
		File file = new File("/Users/xufq/Desktop/数据导入/XDR信令DW模型.xls");
		try {
			DWExceImport exceImport=new DWExceImport();
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
