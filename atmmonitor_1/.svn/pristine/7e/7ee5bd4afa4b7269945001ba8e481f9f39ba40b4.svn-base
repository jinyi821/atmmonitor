package com.gp.manager;

import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.common.constants.PropertiesUtils;
import com.gp.service.GPDataImportService;


@Service("gpDataImportService")
public class GPDataImportImpl implements GPDataImportService {

	private static Log logger = LogFactory.getLog(GPDataImportImpl.class);

	/**
	 * 批量插入
	 */
	@Override
	public void insertData(List<String[]> data, String gptablename) {

		Connection con = getConnection();
		String tableName = gptablename;

		PreparedStatement ps = null;
		PreparedStatement deletePs = null;
		try {

			con.setAutoCommit(false);

			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, "%", tableName, "%");

			StringBuffer insertsql = getInsertSQl(gptablename, columns);
			StringBuffer deleSQl = getDeleteSQl(gptablename);

			ps = con.prepareStatement(insertsql.toString());
			deletePs = con.prepareStatement(deleSQl.toString());

			for (int i = 0; i < data.size(); i++) {

				String[] col = data.get(i);
				int n = 1;
				columns = metaData.getColumns(null, "%", tableName, "%");
				while (columns.next()) {

					String value = col[n - 1];
					if (value != null) {
						value = value.trim();
					}
					// String columnName = columns.getString("COLUMN_NAME");//列名
					String typeName = columns.getString("TYPE_NAME");// 字段类型名称(例如：VACHAR2)
					// System.out.println(""+typeName);

					if (typeName.equals("timestamp")||typeName.equals("DATE")) {
						if (StringUtils.isNotBlank(value))
						ps.setTimestamp(n, toTimestamp(value));
					} else if (typeName.equals("VARCHAR2")) {
						if (value == null) {
							value = "";
						}
						ps.setString(n, value);
					} else if (typeName.equals("NUMBER")) {
						if (StringUtils.isBlank(value)) {
							value = "0";
						}
						ps.setFloat(n, new Float(value));
					} else if (typeName.equals("int2") || typeName.equals("int4")) {
						if (StringUtils.isBlank(value)) {
							value = "0";
						}
						ps.setInt(n, new Integer(value));
					} else if (typeName.equals("CLOB")) {

						StringReader reader = new StringReader(value);
						ps.setCharacterStream(n, reader, value.length());

					}

					n++;
				}

				ps.addBatch();
				deletePs.setLong(1, new Long(col[0]));
				deletePs.addBatch();
				logger.info("=======插入第" + (i + 1) + "行=====");

			}
			if (data.size() > 0) {

				deletePs.executeBatch();
			}

			ps.executeBatch();
			con.commit();
		} catch (Exception e) {
			logger.error(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage());
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {

				logger.error(e);
				throw new RuntimeException(e.getMessage());
			}

		}
	}

	@Override
	public Integer getColumnCount(String gptableName) {

		Connection con = getConnection();

		String tableName = gptableName;
		try {
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, "%", tableName, "%");

			int n = 0;
			while (columns.next()) {
				n++;
			}
			return n;

		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		} finally {
			try {

				con.close();
			} catch (SQLException e) {

				logger.error(e);
				throw new RuntimeException(e.getMessage());
			}
		}

	}

	/**
	 * 
	 * @return
	 */
	private Connection getConnection() {

		String url = PropertiesUtils.getProperty("jdbc.url");
		String username = PropertiesUtils.getProperty("jdbc.username");
		String password = PropertiesUtils.getProperty("jdbc.password");
		String driverName = PropertiesUtils.getProperty("jdbc.driverClassName");

		Connection con = null;

		try {
			// 加载MySql的驱动类
			Class.forName(driverName).newInstance();

			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private StringBuffer getInsertSQl(String gptablename, ResultSet columns) {

		StringBuffer sb = new StringBuffer("INSERT INTO " + gptablename + " (");
		StringBuffer cols = new StringBuffer();
		StringBuffer vals = new StringBuffer();
		try {
			// columns.beforeFirst();

			while (columns.next()) {
				String columnName = columns.getString("COLUMN_NAME");

				if (cols.length() == 0) {

					cols.append(columnName);
					vals.append(" ? ");
				} else {
					cols.append(",").append(columnName);
					vals.append(",").append(" ? ");
				}
			}

			sb = sb.append(cols).append(") values (").append(vals).append(")");
			logger.info("getSQl=" + sb.toString());
			return sb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

	}

	private StringBuffer getDeleteSQl(String gptablename) {

		StringBuffer sb = new StringBuffer();
		sb.append("delete from " + gptablename + " where id= ? ");
		logger.info(sb);
		return sb;

	}

	private Timestamp toTimestamp(String value) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
		Date parse;
		try {
			parse = simpleDateFormat.parse(value);
			long time = parse.getTime();
			return new Timestamp(time);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Object[]> selectData(String gptablename) {

		Connection con = getConnection();
		String tableName = gptablename;
		List<Object[]> resultList = new ArrayList<Object[]>();
		StringBuffer selectSQl = new StringBuffer("select * from ").append(gptablename);
		PreparedStatement ps = null;
		Integer columnCount = getColumnCount(gptablename);
		Object[] objects = new Object[columnCount];
		String[] typeNameS = new String[columnCount];
		int n = 0;

		try {
			ps = con.prepareStatement(selectSQl.toString());
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, "%", tableName, "%");

			while (columns.next()) {

				String columnName = columns.getString("COLUMN_NAME");// 列名
				objects[n] = columnName;
				typeNameS[n] = columns.getString("TYPE_NAME");
				n++;
			}
			resultList.add(objects);

			ResultSet executeQuery = ps.executeQuery();

			while (executeQuery.next()) {

				int h = 0;
				Object[] object1 = new Object[columnCount];
				while (h < columnCount) {
					String typeName = typeNameS[h];
					if (typeName.equals("CLOB")) {
						Clob clob = executeQuery.getClob(h + 1);// java.sql.Clob
						
						if (clob != null) {
							//String detailinfo = clobToString(clob);
							String detailinfo =clob.getSubString((long) 1, (int) clob.length());
						
							object1[h] = detailinfo;
						}
						
					} else {
						object1[h] = executeQuery.getObject(h + 1);
					}
					h++;
				}
				resultList.add(object1);
			}
			return resultList;

		} catch (Exception e) {
			logger.error(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage());
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {

				logger.error(e);
				throw new RuntimeException(e.getMessage());
			}

		}
	}
	/**
	 * 将clob转为String
	 * 
	 * @param clobPar
	 * @return
	 * @throws Exception
	 */
	 public static String clobToString(Object clobPar) throws Exception {
		String valueStr = "";
		if (clobPar instanceof java.sql.Clob) {
			java.sql.Clob clob = (java.sql.Clob) clobPar;
			StringBuffer strOut = new StringBuffer();
			String aux;
			BufferedReader br = new BufferedReader(clob.getCharacterStream());
			while ((aux = br.readLine()) != null) {
				strOut.append(aux);
				strOut.append("\n");
			}
			if (strOut.length() > 0) {
				valueStr = strOut.substring(0, strOut.length() - 1);
			}
		}
		return valueStr;
	 }
	
}
