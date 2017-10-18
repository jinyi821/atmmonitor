package com.gp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.core.util.ExcelUtil;
import com.common.core.util.TransFormat;
import com.gp.service.GPDataImportService;


@Controller
@RequestMapping(value = "gpdata/import/")
public class GPNMSERPDataImportControll {

	private static Log logger = LogFactory.getLog(GPNMSERPDataImportControll.class);

	@Resource
	private GPDataImportService gpDataImportService;

	/**
	 * 进入上传页面
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "enter.action")
	public String erpEnter(HttpServletRequest req, Map<String, Object> map) {


		return "/gp/importAndExport.jsp";
	}

	/**
	 * 上传ERP数据
	 * 
	 * @param sjcsProduct
	 * @param req
	 * @param res
	 * @param map
	 * @return
	 */
	@RequestMapping("importGPData.action")
	public String importGPData(HttpServletRequest req, HttpServletResponse res, Map<String, Object> map) {

		logger.info("ImportGPData");
		HashMap<String, String> formData =GPNMSERPDataImportHelper.uploadfile(req, res);

		if (formData.get("error").endsWith("0")) {

		} else {
			map.put("error", formData.get("error"));
			return "/gp/reponse.jsp";
		}

		String uploadfile = formData.get("uploadFile");
		String gptablename = formData.get("tableSelect");
	
	
		String processRsult = "";

		List<List<String[]>> dataList = new ArrayList<List<String[]>>();

		String[] sheetNameList = new String[] { "sheet1"};
		
		processRsult = GPNMSERPDataImportHelper.processExcelData(uploadfile, map, dataList, sheetNameList);

		if (processRsult != null) {
			return processRsult;
		} 

		try {

			gpDataImportService.insertData(dataList.get(0), gptablename);
			map.put("error", 0);
			map.put("count", dataList.get(0).size());

		} catch (Exception e) {
			map.put("error", e.getMessage());
			logger.error(e);

		}
		return "/gp/reponse.jsp";

	}
	
	/**
	 * 
	 * Created on 2016-4-20
	 * <p>
	 * Discription:[导出Excel]
	 * </p>
	 * 
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "exportBaseData.action", method = RequestMethod.POST)
	public void exportBaseData(HttpServletRequest request, HttpServletResponse response) {

		logger.info("exportBaseData");
		
		String tableName = request.getParameter("tableSelect");;

		List<Object[]> list = gpDataImportService.selectData(tableName);

		logger.info("======进入 =======");

		logger.info("ExcelUtil.exportToExcelFromOB");
		ExcelUtil.exportToExcelFromOB(list, request, response, null, tableName + ".xlsx", "sheet1", new TransFormat() {
			// 数据转化
			@Override
			public String objectToString(int i, Object o) {
				
				return o.toString();
			}

		},0);
		logger.info("finish ExcelUtil.exportToExcelFromOB end ");
	}

	
	
	
}
