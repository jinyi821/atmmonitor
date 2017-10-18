package com.common.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	/**
	 * 
	 * Created on 2016年8月30日
	 * <p>
	 * Discription:[Excel处理模板]
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param sourceFileName
	 * @param excelName
	 * @param excelProcessor
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static void exportToExcel(HttpServletRequest request, HttpServletResponse response, String sourceFileName, String excelName, ExcelProcessor excelProcessor) {

		Workbook getworkBook = new HSSFWorkbook();
		if (StringUtils.isNotBlank(sourceFileName)) {
			// 读取模板文件
			getworkBook = getworkBookNew(sourceFileName);
		}
		getworkBook = excelProcessor.processExcel(getworkBook);

		new ExcelUtil().exportWorkBook(request, response, getworkBook, excelName);
	}

	/**
	 * 
	 * Created on 2016-4-29
	 * <p>
	 * Discription:[写数据到Excel，然后从response返回]
	 * </p>
	 * 
	 * @param data
	 * @param request
	 * @param response
	 * @param excelName
	 * @param sheetName
	 * @param TransFormat
	 *            转换类
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static void exportToExcelFromOB(List<Object[]> data, HttpServletRequest request, HttpServletResponse response, String sourceFileName, String excelName, String sheetName,
			TransFormat formatClass,int rowBegin) {

		List<String[]> objectsListToStringsList = objectsListToStringsList(data, formatClass);
		exportToExcel(objectsListToStringsList, request, response, sourceFileName, excelName, sheetName,rowBegin);
	}

	/**
	 * 写数据到Excel，然后从response返回
	 * 
	 * @param data
	 *            数据列表
	 * @param request
	 * @param response
	 * @param excelName
	 *            要导出Excel命名
	 */
	public static void exportToExcel(List<String[]> data, HttpServletRequest request, HttpServletResponse response, String sourceFileName, String excelName, String sheetName,int rowBegin) {
		Workbook getworkBook = new XSSFWorkbook();
		if (StringUtils.isNotBlank(sourceFileName)) {
			// 读取模板文件
			getworkBook = getworkBookNew(sourceFileName);
		}
		Workbook workBook = setExcelData(data, getworkBook, sheetName,rowBegin);
		new ExcelUtil().exportWorkBook(request, response, workBook, excelName);
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件读取数据
	 * </p>
	 * 
	 * @param excelName
	 * @param sheet
	 * @param rowBegin
	 *            行开始
	 * @param colBegin
	 *            列开始
	 * @param colEnd
	 *            列结束
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static List<String[]> readDataFromExcel(final String excelName, final short sheet, final short rowBegin, final short colBegin, final short colEnd) {

		List<String[]> dataArray = new ArrayList<String[]>();
		HSSFWorkbook workBook = getworkBook(excelName);
		HSSFSheet sheetGrid = workBook.getSheetAt((short) sheet);

		int lastRowNum = sheetGrid.getLastRowNum();

		for (int row = rowBegin; row < lastRowNum + 1; row++) {
			String[] colData = new String[(short) colEnd - colBegin + 1];
			for (int col = colBegin, i = 0; col < colEnd + 1; col++, i++) {
				String cellData = readDataFromExcel(workBook, sheet, (short) row, (short) col);
				colData[i] = cellData;
			}
			dataArray.add(colData);
		}
		return dataArray;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件读取数据
	 * </p>
	 * 
	 * @param excelName
	 * @param sheet
	 * @param rowBegin
	 *            行开始
	 * @param colBegin
	 *            列开始
	 * @param colEnd
	 *            列结束
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static List<String[]> readDataFromExcelNew(final String excelName, final short sheet, final short rowBegin, final short colBegin, final short colEnd) {

		List<String[]> dataArray = new ArrayList<String[]>();
		Workbook workBook = getworkBookNew(excelName);
		Sheet sheetGrid = workBook.getSheetAt((short) sheet);

		int lastRowNum = sheetGrid.getLastRowNum();

		for (int row = rowBegin; row < lastRowNum + 1; row++) {
			String[] colData = new String[(short) colEnd - colBegin + 1];
			for (int col = colBegin, i = 0; col < colEnd + 1; col++, i++) {
				if (row == 5) {
					System.out.println("");
				}
				String cellData = readDataFromExcelNew(workBook, sheet, (short) row, (short) col);
				colData[i] = cellData;
			}
			dataArray.add(colData);
		}
		return dataArray;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件读取数据
	 * </p>
	 * 
	 * @param excelName
	 * @param sheet
	 * @param rowBegin
	 *            行开始
	 * @param colBegin
	 *            列开始
	 * @param colEnd
	 *            列结束
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static List<String[]> readDataFromExcelNew(final String excelName, final String sheetName, final short rowBegin, final short colBegin, final short colEnd) {

		List<String[]> dataArray = new ArrayList<String[]>();
		Workbook workBook = getworkBookNew(excelName);
		Sheet sheetGrid = workBook.getSheet(sheetName);

		int lastRowNum = sheetGrid.getLastRowNum();

		for (int row = rowBegin; row < lastRowNum + 1; row++) {
			String[] colData = new String[(short) colEnd - colBegin + 1];
			for (int col = colBegin, i = 0; col < colEnd + 1; col++, i++) {

				String cellData = readDataFromExcelNew(workBook, sheetName, (short) row, (short) col);
				if (StringUtils.isNotBlank(cellData)) {
					cellData = cellData.trim();
				}
				colData[i] = cellData;
			}
			dataArray.add(colData);
		}
		return dataArray;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel 读取到HSSFWorkbook
	 * </p>
	 * 
	 * @param sourceFileName
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static HSSFWorkbook getworkBook(final String sourceFileName) {

		HSSFWorkbook workBook = null;
		try {
			// 打开数据源文件
			FileInputStream sourceFile = new FileInputStream(sourceFileName);
			POIFSFileSystem poiFileSystem = new POIFSFileSystem(sourceFile);
			// 生成workbook
			workBook = new HSSFWorkbook(poiFileSystem, true);
			// 关闭文件
			sourceFile.close();
			// // 删除用户上传的文件
			// File file = new File(sourceFileName);
			// if (file.isFile() && file.exists()) {
			// file.delete();
			// }
		} catch (IOException e) {

			throw new RuntimeException("该Excel文件不是97-2003版本，请另存转化！");
		}
		return workBook;
	}

	/**
	 * 
	 * @param sourceFileName
	 * @return
	 */
	@SuppressWarnings("resource")
	public static Workbook getworkBookNew(final String sourceFileName) {

		Workbook workBook = null;
		try {
			// 打开数据源文件
			FileInputStream sourceFile = new FileInputStream(sourceFileName);

			if (sourceFileName.endsWith(".xls")) {
				POIFSFileSystem poiFileSystem = new POIFSFileSystem(sourceFile);
				workBook = new HSSFWorkbook(poiFileSystem, true);

			} else if (sourceFileName.endsWith("xlsx")) {
				workBook = new XSSFWorkbook(sourceFile);

			} else {
				throw new RuntimeException("不是Excel文件");
			}
			sourceFile.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return workBook;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件某行某列读取数据
	 * </p>
	 * 
	 * @param workBook
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@SuppressWarnings({ "deprecation" })
	public static String readDataFromExcel(HSSFWorkbook workBook, short sheet, short row, short col) {
		if (sheet == -1 || row == -1 || col == -1) {
			throw new RuntimeException("参数有误");
		}
		HSSFCell cell = null;
		try {
			cell = workBook.getSheetAt(sheet).getRow((short) row).getCell((short) col);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		if (cell == null) {
			return null;
		}
		String cellvalue = "";
		switch (cell.getCellType()) {
		// 如果当前Cell的Type为NUMERIC
		case HSSFCell.CELL_TYPE_NUMERIC: {
			// 判断当前的cell是否为Date
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是Date类型则，取得该Cell的Date值
				// 把Date转换成本地格式的字符串
				cellvalue = cell.getDateCellValue().toLocaleString();
			}
			// 如果是纯数字
			else {
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// Double numericCellValue = cell.getNumericCellValue();
				cellvalue = cell.getStringCellValue();
				// Long num = Long.valueOf(numericCellValue.longValue());

				// cellvalue = String.valueOf(numericCellValue);
			}
			break;
		}
		// 如果当前Cell的Type为STRIN
		case HSSFCell.CELL_TYPE_STRING:
			// 取得当前的Cell字符串
			cellvalue = cell.getStringCellValue().replaceAll("'", "''");
			break;
		// 默认的Cell值
		default:
			cellvalue = " ";
		}
		return cellvalue;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件某行某列读取数据
	 * </p>
	 * 
	 * @param workBook
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */

	public static String readDataFromExcel(Workbook workBook, short sheet, short row, short col) {
		if (sheet == -1 || row == -1 || col == -1) {
			throw new RuntimeException("参数有误");
		}
		Cell cell = null;
		try {
			cell = workBook.getSheetAt(sheet).getRow((short) row).getCell((short) col);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		if (cell == null) {
			return null;
		}
		String cellvalue = "";
		switch (cell.getCellType()) {
		// 如果当前Cell的Type为NUMERIC
		case HSSFCell.CELL_TYPE_NUMERIC: {
			// 判断当前的cell是否为Date
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是Date类型则，取得该Cell的Date值
				// 把Date转换成本地格式的字符串
				cellvalue = cell.getDateCellValue().toLocaleString();
			}
			// 如果是纯数字
			else {
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// Double numericCellValue = cell.getNumericCellValue();
				cellvalue = cell.getStringCellValue();
				// Long num = Long.valueOf(numericCellValue.longValue());

				// cellvalue = String.valueOf(numericCellValue);
			}
			break;
		}
		// 如果当前Cell的Type为STRIN
		case HSSFCell.CELL_TYPE_STRING:
			// 取得当前的Cell字符串
			cellvalue = cell.getStringCellValue().replaceAll("'", "''");
			break;
		// 默认的Cell值
		default:
			cellvalue = " ";
		}
		return cellvalue;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件某行某列读取数据
	 * </p>
	 * 
	 * @param workBook
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */

	public static String readDataFromExcelNew(Workbook workBook, short sheet, short row, short col) {
		if (sheet == -1 || row == -1 || col == -1) {
			throw new RuntimeException("参数有误");
		}
		Cell cell = null;
		try {
			cell = workBook.getSheetAt(sheet).getRow(row).getCell(col);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		if (cell == null) {
			return null;
		}
		String cellvalue = "";
		switch (cell.getCellType()) {
		// 如果当前Cell的Type为NUMERIC
		case HSSFCell.CELL_TYPE_NUMERIC: {
			// 判断当前的cell是否为Date
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是Date类型则，取得该Cell的Date值
				// 把Date转换成本地格式的字符串
				cellvalue = cell.getDateCellValue().toLocaleString();
			}
			// 如果是纯数字
			else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// Double numericCellValue = cell.getNumericCellValue();
				cellvalue = cell.getStringCellValue();
				// Long num = Long.valueOf(numericCellValue.longValue());

				// cellvalue = String.valueOf(numericCellValue);
			}
			break;
		}
		// 如果当前Cell的Type为STRIN
		case HSSFCell.CELL_TYPE_STRING:
			// 取得当前的Cell字符串
			cellvalue = cell.getStringCellValue().replaceAll("'", "''");
			break;
		// 默认的Cell值
		default:
			cellvalue = " ";
		}
		return cellvalue;
	}

	/**
	 * 
	 * Created on 2014年6月13日
	 * <p>
	 * Discription:从Excel文件某行某列读取数据
	 * </p>
	 * 
	 * @param workBook
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */

	public static String readDataFromExcelNew(Workbook workBook, String sheetName, short row, short col) {
		if (row == -1 || col == -1) {
			throw new RuntimeException("参数有误");
		}
		Cell cell = null;
		try {
			cell = workBook.getSheet(sheetName).getRow(row).getCell(col);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		if (cell == null) {
			return null;
		}
		String cellvalue = "";
		boolean isMerge = isMergedRegion(workBook.getSheet(sheetName), new Integer(String.valueOf(row)), cell.getColumnIndex());
		// 判断是否具有合并单元格
		if (isMerge) {
			cellvalue = getMergedRegionValue(workBook.getSheet(sheetName), new Integer(String.valueOf(row)), cell.getColumnIndex());
			return cellvalue;
		}

		switch (cell.getCellType()) {
		// 如果当前Cell的Type为NUMERIC
		case HSSFCell.CELL_TYPE_NUMERIC: {
			// 判断当前的cell是否为Date
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是Date类型则，取得该Cell的Date值
				// 把Date转换成本地格式的字符串
				cellvalue = cell.getDateCellValue().toLocaleString();
			}
			// 如果是纯数字
			else {

				cell.setCellType(Cell.CELL_TYPE_STRING);
				// Double numericCellValue = cell.getNumericCellValue();
				cellvalue = cell.getStringCellValue();

				if (StringUtils.isNotBlank(cellvalue)) {
					String[] split = cellvalue.split("\\.");
					if (split.length == 2 && split[1].length() > 8) {
						cellvalue = split[0];
					}
				}
			}
			break;
		}
		// 如果当前Cell的Type为STRIN
		case HSSFCell.CELL_TYPE_STRING:
			// 取得当前的Cell字符串
			cellvalue = cell.getStringCellValue().replaceAll("'", "''");
			break;
		case HSSFCell.CELL_TYPE_FORMULA:

			try {
				/*
				 * 此处判断使用公式生成的字符串有问题，因为HSSFDateUtil.isCellDateFormatted(cell)
				 * 判断过程中cell
				 * .getNumericCellValue();方法会抛出java.lang.NumberFormatException异常
				 */
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					cellvalue = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
					break;
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					// Double numericCellValue = cell.getNumericCellValue();
					cellvalue = cell.getStringCellValue();
					if (StringUtils.isNotBlank(cellvalue)) {
						String[] split = cellvalue.split("\\.");
						if (split.length == 2 && split[1].length() > 8) {
							cellvalue = split[0];
						}
					}
				}
			} catch (IllegalStateException e) {
				cellvalue = String.valueOf(cell.getRichStringCellValue());
			}
			break;
		// 默认的Cell值
		default:
			cellvalue = " ";
		}
		return cellvalue;
	}

	/**
	 * 
	 * Created on 2014年6月12日
	 * <p>
	 * Discription:往Excelsh设置数据
	 * </p>
	 * 
	 * @param list
	 * @param excelName
	 * @param sheetName
	 * @return
	 * @author:<a href=jinyi@neusoft.com>金翊</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@SuppressWarnings("deprecation")
	public static Workbook setExcelData(List<String[]> list, Workbook workbook, String sheetName,int rowBegin) {
		if (list == null) {
			return workbook;
		}
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		workbook.createSheet();
		// workbook.setSheetName(0, sheetName, HSSFCell.ENCODING_UTF_16);
		workbook.setSheetName(0, sheetName);
		Sheet sheet = workbook.getSheetAt(0);

		int[] width = null;
		//Integer rowNum = (Integer) sheet.getLastRowNum();

		for (int i = 0; i < list.size(); i++) {
			String[] objects = list.get(i);
			if (i == 0) {
				width = new int[objects.length];
			}

			Row row = sheet.createRow(i + rowBegin);
			row.setHeight((short) 600);
			for (int n = 0; n < objects.length; n++) {
				String o = objects[n] == null ? "" : objects[n];

				Cell createCell = row.createCell((short) n);
				// createCell.setEncoding(HSSFCell.ENCODING_UTF_16);
				createCell.setCellStyle(style);
				createCell.setCellValue(o);

				try {
					if (width[n] < o.getBytes("GBK").length) {
						width[n] = o.getBytes("GBK").length;
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		return workbook;
	}

	public static HSSFWorkbook setExcelData(List<String[]> list, HSSFWorkbook workbook, Integer sheetId, String sheetName) {

		HSSFCellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		workbook.createSheet();
		// workbook.setSheetName(0, sheetName, HSSFCell.ENCODING_UTF_16);
		workbook.setSheetName(sheetId, sheetName);
		HSSFSheet sheet = workbook.getSheetAt(sheetId);

		int[] width = null;
		Integer rowNum = (Integer) sheet.getLastRowNum();

		for (int i = 0; i < list.size(); i++) {
			String[] objects = list.get(i);
			if (i == 0) {
				width = new int[objects.length];
			}

			HSSFRow row = sheet.createRow(i + rowNum + 1);
			row.setHeight((short) 600);
			for (int n = 0; n < objects.length; n++) {
				String o = objects[n] == null ? "" : objects[n];

				HSSFCell createCell = row.createCell((short) n);
				// createCell.setEncoding(HSSFCell.ENCODING_UTF_16);
				createCell.setCellStyle(style);
				createCell.setCellValue(o);

				try {
					if (width[n] < o.getBytes("GBK").length) {
						width[n] = o.getBytes("GBK").length;
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		return workbook;
	}

	@SuppressWarnings("deprecation")
	public HSSFWorkbook setData(List<String[]> list, String excelName, String year) {

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFCellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		workbook.createSheet();
		if (StringUtils.isNotBlank(year)) {
			if (year.length() <= 4) {
				workbook.setSheetName(0, excelName + "(" + year + "年)");
			} else {
				workbook.setSheetName(0, excelName + "(" + year.substring(0, 4) + "年" + year.substring(4) + "月)");
			}
		} else {
			workbook.setSheetName(0, excelName);
			// workbook.setSheetName(0, excelName, HSSFCell.ENCODING_UTF_16);
		}

		HSSFSheet sheet = workbook.getSheetAt(0);

		int[] width = null;

		for (int i = 0; i < list.size(); i++) {
			String[] objects = list.get(i);
			if (i == 0) {
				width = new int[objects.length];
			}
			HSSFRow row = sheet.createRow(i);
			for (int n = 0; n < objects.length; n++) {
				String o = objects[n] == null ? "" : objects[n];

				HSSFCell createCell = row.createCell((short) n);
				// createCell.setEncoding(HSSFCell.ENCODING_UTF_16);
				createCell.setCellStyle(style);
				createCell.setCellValue(o);

				try {
					if (width[n] < o.getBytes("GBK").length) {
						width[n] = o.getBytes("GBK").length;
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < width.length; i++) {
			if (width[i] > 9) {
				// sheet.setColumnWidth((short) i, (short) (width[i] * 256));
				sheet.setColumnWidth((short) i, (short) (width[i] * 280));
			} else {
				sheet.setColumnWidth((short) i, (short) (width[i] * 280));
			}
		}
		return workbook;
	}

	/**
	 * 
	 * Created on 2011-2-24
	 * <p>
	 * Discription:把Excel放到response响应
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param workbook
	 * @param excelName
	 * @author:<a href=jinyi@neusoft.com>姓名</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public void exportWorkBook(HttpServletRequest request, HttpServletResponse response, Workbook workbook, String excelName) {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream bis = new ByteArrayInputStream(outputStream.toByteArray());

		writeStreamToResponse(excelName, request.getSession().getServletContext(), response, bis);
	}

	/**
	 * 
	 * Created on 2011-2-14
	 * <p>
	 * Discription:[方法功能中文描述]
	 * </p>
	 * 
	 * @param fileName
	 * @param servletContext
	 * @param response
	 * @param bis
	 * @author:<a href=jinyi@neusoft.com>姓名</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static void writeStreamToResponse(String fileName, ServletContext servletContext, HttpServletResponse response, InputStream bis) {
		try {
			String extendName = null;

			String mimeType = null;
			int pos = fileName.lastIndexOf(".");
			if (pos >= 0 && (pos + 1) < fileName.length()) {
				extendName = fileName.substring(pos + 1);
			}
			if (extendName != null) {
				mimeType = servletContext.getMimeType(extendName);
			}
			if (mimeType == null)
				// 八进制数据流
				// mimeType = "APPLICATION/OCTET-STREAM";
				mimeType = "application/x-msdownload";
			// TODO
			response.setCharacterEncoding("utf-8");

			response.setContentType(mimeType);
			// 设置响应头部
			response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
			// 设置内容
			int length;
			byte[] data = new byte[1024];
			OutputStream out = response.getOutputStream();
			do {
				length = bis.read(data);
				if (length != -1) {
					out.write(data, 0, length);
				}
			} while (length > 0);
			out.flush();
			out.close();
			data = null;
			// 设置状态
			response.setStatus(HttpServletResponse.SC_OK);
			response.flushBuffer();
		} catch (IOException ex) {

			response.setContentType("text/html");
			response.setHeader("Content-Disposition", "");
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * 
	 * Created on 2016-4-29
	 * <p>
	 * Discription:[Object数组List转化String数组List]
	 * </p>
	 * 
	 * @param objectsList
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	public static List<String[]> objectsListToStringsList(List<Object[]> objectsList, TransFormat formatClass) {

		List<String[]> list = new ArrayList<String[]>();
		if (objectsList != null) {
			for (Object[] objects : objectsList) {
				String[] temp = new String[objects.length];
				for (int i = 0; i < objects.length; i++) {
					{
						Object object = objects[i];
						if (object == null) {
							temp[i] = "";
						} else {
							if (formatClass == null) {
								temp[i] = object.toString();
							} else {
								temp[i] = formatClass.objectToString(i, object);
							}
						}
					}
				}
				list.add(temp);
			}
		}
		return list;
	}

	public static class Test {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String args[]) {

			ExcelUtil util = new ExcelUtil();

			List<String[]> data = new ArrayList();
			data.add(new String[] { "姓名", "身高", "体重" });
			data.add(new String[] { "jinyi", "170", "140" });
			String excelName = "1";
			String date = "2014";
			HSSFWorkbook workbook = util.setData(data, excelName, date);
			try {
				OutputStream outputStream = new FileOutputStream("d://test.xls");
				workbook.write(outputStream);
				List<String[]> readDataFromExcel = readDataFromExcel("d://test.xls", (short) 0, (short) 0, (short) 0, (short) 2);
				for (String[] strings : readDataFromExcel) {
					for (String string : strings) {
						System.out.print(string);
					}
					System.out.println("");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean isExist(String path) {
		File file = new File(path);
		return file.exists();
	}

	public static InputStream getFileInputStream(String path) {
		try {
			if (isExist(path)) {
				InputStream is = new FileInputStream(path);
				return is;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取Excel表格的列数
	 * 
	 * @param excelName
	 * @param sheet
	 * @return
	 */
	public static Integer getColumnNum(String excelName, short sheet) {

		Workbook workBook = getworkBookNew(excelName);
		Sheet sheetGrid = workBook.getSheetAt((short) sheet);
		Row row2 = sheetGrid.getRow(0);
		return row2.getPhysicalNumberOfCells();
	}

	/**
	 * 取Excel表格的列数
	 * 
	 * @param excelName
	 * @param sheet
	 * @return
	 */
	public static Integer getColumnNum(String excelName, String sheetName) {

		Workbook workBook = getworkBookNew(excelName);
		Sheet sheetGrid = workBook.getSheet(sheetName);
		Row row2 = sheetGrid.getRow(0);
		short lastCellNum = row2.getLastCellNum();
		return new Integer(String.valueOf(lastCellNum));
		// row2.getPhysicalNumberOfCells();
	}

	/**
	 * 取Excel表格的列数
	 * 
	 * @param excelName
	 * @param sheet
	 * @return
	 */
	public static Integer getColumnNum(String excelName, String sheetName, int beginRow) {

		Workbook workBook = getworkBookNew(excelName);
		Sheet sheetGrid = workBook.getSheet(sheetName);
		Row row2 = sheetGrid.getRow(beginRow);
		short lastCellNum = row2.getLastCellNum();
		return new Integer(String.valueOf(lastCellNum));
		// row2.getPhysicalNumberOfCells();
	}

	/**
	 * 判断指定的单元格是否是合并单元格
	 * 
	 * @param sheet
	 * @param row
	 *            行下标
	 * @param column
	 *            列下标
	 * @return
	 */
	private static boolean isMergedRegion(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	private static String getMergedRegionValue(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();

		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {

				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					Cell fCell = fRow.getCell(firstColumn);
					return getCellValue(fCell);
				}
			}
		}

		return null;
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCellValue(Cell cell) {

		if (cell == null)
			return "";

		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

			return cell.getStringCellValue();

		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {

			return String.valueOf(cell.getBooleanCellValue());

		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

			return cell.getCellFormula();

		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

			return String.valueOf(cell.getNumericCellValue());

		}
		return "";
	}

}
