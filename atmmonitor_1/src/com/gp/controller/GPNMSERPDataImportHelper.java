package com.gp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.constants.PropertiesUtils;
import com.common.core.util.ExcelUtil;


public class GPNMSERPDataImportHelper {

	private static Log logger = LogFactory.getLog(GPNMSERPDataImportHelper.class);


	/**
	 * 对01004 类型的数据进行处理
	 * 
	 * @param uploadfile
	 * @param map
	 * @param dataList
	 * @return
	 */
	public static String processExcelData(String uploadfile, Map<String, Object> map, List<List<String[]>> dataLists, String[] sheetNameList) {

		for (int i = 0; i < sheetNameList.length; i++) {

			
			Integer columnCount = 0;
			try {
				columnCount = ExcelUtil.getColumnNum(uploadfile, sheetNameList[i], 0) - 1;
			} catch (Exception e) {
				map.put("error", "读取excel失败， 可能上传数据不正确！");
				return "/gp/reponse.jsp";
			}
			// 得到上传数值
			List<String[]> data = null;
			try {

				data = ExcelUtil.readDataFromExcelNew(uploadfile, sheetNameList[i], (short) 1, (short) 0, columnCount.shortValue());
				dataLists.add(data);

			} catch (Exception e) {

				map.put("error", "读取excel失败， 可能你的excel正在编辑中，请关闭你所上传的excel再试!");
				return "/gp/reponse.jsp";
			}
			
			
		}
		
		return null;
	}

	/**
	 * 得到当前服务器时间
	 * 
	 * @return
	 */
	private static String getCurrentTime() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
		try {
			return simpleDateFormat.format(Calendar.getInstance().getTime());

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 判断数组是否有空白
	 * 
	 * @param tips
	 */
	private static Boolean isArrayBlank(String[] tips) {

		StringBuffer tip = new StringBuffer();

		for (int i = 0; i < tips.length; i++) {
			tip.append(tips[i] == null ? "" : tips[i]);
		}
		return tip.length() > 0;

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static HashMap<String, String> uploadfile(final HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("error", "0");
		try {
			String savePath = PropertiesUtils.getProperty("upload.address");
			logger.info(" savePath : " + savePath);
			mkfloder(savePath);

			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setHeaderEncoding("UTF-8");
			if (!ServletFileUpload.isMultipartContent(request)) {
				return dataMap;
			}
			// 使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，
			// 每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				String fieldname = item.getFieldName();
				if (item.isFormField()) {
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8").trim();
					dataMap.put(fieldname, value);
					System.out.println(fieldname + "=" + value);
				} else {
					// 得到上传的文件名称，
					String filename = item.getName().trim();
					filename = filename.substring(filename.lastIndexOf("\\") + 1).trim();
					dataMap.put("excelName", filename);
					if (filename == null || filename.trim().equals("")) {
						dataMap.put("error", "没有上传xls类型文件！");
						continue;
					}

					mkfloder(savePath + "\\gp");
					filename = String.format("%s/%s/%s", savePath, "\\gp", filename);
					dataMap.put(fieldname, filename);

					InputStream in = item.getInputStream();
					File targetfile = new File(filename);
					FileUtils.copyInputStreamToFile(in, targetfile);
					item.write(targetfile);
					// 删除处理文件上传时生成的临时文件
					item.delete();

				}
			}

		} catch (Exception e) {
			String message_error = "文件上传失败！" + e.toString();
			dataMap.put("gpfile", message_error);
			logger.error(message_error);
		}

		return dataMap;
	}

	/**
	 * 
	 * @param path
	 */
	private static void mkfloder(String path) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(path + "目录不存在，需要创建");
			file.mkdir();
		}
	}

	/**
	 * 校验文件名有效性
	 * 
	 * @param filename
	 * @return
	 */
	public static HashMap<String, String> validateFileName(String filename, Integer reportType) {

		HashMap<String, String> dataMap = new HashMap<String, String>();
		String suffix = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase().trim();
		String fileNameBefore = filename.substring(0, filename.lastIndexOf("."));

		if (!("xls".contains(suffix) || "xlsx".contains(suffix))) {
			dataMap.put("error", "没有上传xls或者xlsx类型文件！");
			return dataMap;
		}

		String[] split = fileNameBefore.split("_");
		if (split.length != 7) {
			dataMap.put("error", "上传文件名有误！");
			return dataMap;
		}
		if (!("s".equals(split[0]) || "a".equals(split[0]) || "i".equals(split[0]))) {
			dataMap.put("error", "上传文件名第一部分应为[a,i,s]！");
			return dataMap;
		}
		if (!"12400".equals(split[1])) {
			dataMap.put("error", "上传文件名第二部分应为[12400]！");
			return dataMap;
		}
		if (!"STAT".equals(split[2])) {
			dataMap.put("error", "上传文件名第三部分应为[STAT]！");
			return dataMap;
		}
		if (!((reportType == 1 && "01004".equals(split[3])) || (reportType == 2 && "01005".equals(split[3])) || (reportType == 3 && "01006".equals(split[3])))) {
			dataMap.put("error", "上传文件名第四部分错误！");
			return dataMap;
		}
		try {
			if (split[4].length() != 6) {

				dataMap.put("error", "上传文件名中第五部分长度应为6位！");
				return dataMap;
			}
			getDateTime(split[4].substring(0, 3) + "0101");
		} catch (Exception e) {
			dataMap.put("error", "上传文件名第五部分有误！");
			return dataMap;
		}

		if (!split[5].equals("00")) {
			dataMap.put("error", "上传文件名第六部分有误！");
			return dataMap;
		}

		if (!split[6].equals("001")) {
			dataMap.put("error", "上传文件名第七部分有误！");
			return dataMap;
		}
		return dataMap;
	}

	/**
	 * 判断小写
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isUpperCase(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 得到某个日期对应的秒数
	 * 
	 * @param date
	 * @return
	 */
	private static Long getDateTime(String date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
		Date parse;
		try {
			parse = simpleDateFormat.parse(date);
			long time = parse.getTime();
			return time / 1000;
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	private Timestamp toTimestamp(String value) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date parse;
		try {
			parse = simpleDateFormat.parse(value);
			long time = parse.getTime();
			return new Timestamp(time);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static List<String[]> readExcel(String uploadfile) throws IOException, BiffException {
		List<String[]> data = new ArrayList<String[]>();
		// 创建输入流
		InputStream stream = new FileInputStream(uploadfile);
		// 获取Excel文件对象
		Workbook rwb = Workbook.getWorkbook(stream);
		// 获取文件的指定工作表 默认的第一个
		Sheet sheet = rwb.getSheet(0);
		// 行数(表头的目录不需要，从1开始)
		for (int i = 0; i < sheet.getRows(); i++) {
			// 创建一个数组 用来存储每一列的值
			String[] str = new String[sheet.getColumns()];
			Cell cell = null;
			// 列数
			for (int j = 0; j < sheet.getColumns(); j++) {
				// 获取第i行，第j列的值
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
			}
			// 把刚获取的列存入list
			data.add(str);
		}
		return data;
	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param realPath
	 * @param excelName
	 */
	public static void exportWorkBook(HttpServletResponse response, String realPath, String fileName) {

		File file = new File(realPath); // 要下载的文件绝对路径
		InputStream ins;
		byte[] buffer;
		try {
			ins = new BufferedInputStream(new FileInputStream(file));
			buffer = new byte[ins.available()];
			ins.read(buffer);
			ins.close();

			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			ous.write(buffer);
			ous.flush();
			ous.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 使用 Map按key进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<Integer, List<String[]>> sortMapByKey(Map<Integer, List<String[]>> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<Integer, List<String[]>> sortMap = new TreeMap<Integer, List<String[]>>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		sortMap.putAll(map);

		return sortMap;
	}

	/**
	 * 取当前所在月份和季度
	 * 
	 * @param reportType
	 * @return
	 */
	public static String getYearMonth(String reportType) {
		Calendar instance = Calendar.getInstance();
		String yyyymm = "";
		if (reportType.equals("01004")) {

			instance.add(Calendar.MONTH, -1);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM", Locale.getDefault());

			try {
				yyyymm = simpleDateFormat.format(instance.getTime());
				return yyyymm;
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		if (reportType.equals("01006")) {

			int i = instance.get(Calendar.MONTH) + 1; // 当前所在月份
			int lastMonth = i - 1;

			if (lastMonth > 9) {
				return instance.get(Calendar.YEAR) + "J4";
			}
			if (lastMonth > 6 && lastMonth < 10) {
				return instance.get(Calendar.YEAR) + "J3";
			}
			if (lastMonth > 3 && lastMonth < 7) {
				return instance.get(Calendar.YEAR) + "J2";
			}
			if (lastMonth > 0 && lastMonth < 4) {
				return instance.get(Calendar.YEAR) + "J1";
			}
			if (lastMonth == 0) {
				return instance.get(Calendar.YEAR) - 1 + "J4";
			}

		}
		return yyyymm;
	}

	/**
	 * 执行JAR包
	 * 
	 * @param request
	 * @param businessType
	 * @param period
	 * @param reportType
	 */
	public static void execJAR(HttpServletRequest request, String businessType, String period, String reportType) {

		logger.info("====执行JAR开始=====");
		// String realPath =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/lib/report-nms-upload.jar");
		// try {
		// String path =
		// "\""+System.getProperty("sun.boot.library.path")+"\\java\"";
		// StringBuffer cmdSB = new
		// StringBuffer("cmd /c "+path+" -jar ").append(realPath).append(" " +
		// businessType + " " + period + " " + reportType);
		// String ls_str;
		// logger.info("====执行JAR命令=" + cmdSB.toString());
		// Process ls_proc = Runtime.getRuntime().exec(cmdSB.toString());
		// DataInputStream ls_in = new
		// DataInputStream(ls_proc.getInputStream());
		//
		// try {
		// while ((ls_str = ls_in.readLine()) != null) {
		// logger.info(ls_str);
		// }
		// } catch (IOException e) {
		// }
		// } catch (Exception e1) {
		// logger.error(e1);
		// }
		// logger.info("====执行JAR结束=====");
		String[] args = new String[] { businessType, period, reportType };
		com.ultrapower.pg.main.DoMain.main(args);
		logger.info("====执行JAR结束=====");
	}

	@SuppressWarnings("deprecation")
	public static void main(String Argv[]) {

		try {
			String ls_str;
			String path = "\"" + System.getProperty("sun.boot.library.path") + "\\java\"";
			StringBuffer cmdSB = new StringBuffer("cmd /c " + path);

			Process ls_proc = Runtime.getRuntime().exec(cmdSB + "-jar D:/report-nms-upload.jar  mis 201702 01004");
			// get its output (your input) stream

			DataInputStream ls_in = new DataInputStream(ls_proc.getInputStream());
			try {
				while ((ls_str = ls_in.readLine()) != null) {
					logger.info(ls_str);
				}
			} catch (IOException e) {
				System.exit(0);
			}
		} catch (IOException e1) {
			System.err.println(e1);
			System.exit(1);
		}

		System.exit(0);
	}

}
