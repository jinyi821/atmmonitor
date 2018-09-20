package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/7.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFile;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFileService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsScannerServer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.scannermonitor.ScannerMonitorController
 * @Title FTP文件扫描
 * @Description FTP文件扫描
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-07 15:38
 */
@Controller
@RequestMapping("/scannerMonitor")
public class ScannerMonitorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsFtpServerServer dcsFtpServerServer;
    @Autowired
    private DcsFileService dcsFileService;
    @Autowired
    private DcsDataTypeService dcsDataTypeService;

    @Autowired
    private DcsScannerServer dcsScannerServer;


    /* *
    * @Title
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/")
    public String scannerMonitor(
            @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
            @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
            @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
            @RequestParam(required = false, defaultValue = "", value = "pathAndName") String pathAndName,
            ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===scannerMonitor begin!! ===");
        Map condition = new HashMap();
        if (ftpId != -1) {
            condition.put("ftpId", ftpId);
        }
        if (dataTypeId != -1) {
            condition.put("dataTypeId", dataTypeId);
        }
        if (StringUtils.isNotBlank(pathAndName)) {
            condition.put("pathAndName", pathAndName);
        }
        List<DcsFile> dcsFiles = dcsFileService.selectListByFTPAndDataType(condition);
        
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(processList(dcsFiles), 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        List<DcsFtpServer> ftPserverList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        map.put("ftpId",ftpId);
        map.put("dataTypeId",dataTypeId);
        map.put("pageSize",pageSize);
        map.put("pathAndName",pathAndName);
        
        map.put("pageInfo", pageInfo);
        map.put("ftPserverList", ftPserverList);
        map.put("dcsDataTypeList", dcsDataTypeList);

//        map.put("queryftl", "/scanner_monitor/scanner_monitor_query.ftl");
//        map.put("scriptftl", "/scanner_monitor/scanner_monitor_script.ftl");
//        map.put("tableftl", "/scanner_monitor/scanner_monitor_table.ftl");
        map.put("formcontenturl", "/scanner_monitor/scanner_monitor_modal_detail.ftl");
        map.put("isHasSaveButton", "false");
        if (refreshPart == 0) {
           // return "common";
            return "scanner_monitor/scanner_monitor";
        } else {
            return "scanner_monitor/scanner_monitor_table";
        }

    }
    
    /* *
     * @Title    按需求重新包装
     * @Description  
     * @Param     [dcsFiles]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFile>
     * @throws      
     * @author   jinyi
     * @Date   2018/8/2  10:38
     **/
    private List<DcsFile> processList(List<DcsFile> dcsFiles){
        
        for (int i=0;i<dcsFiles.size();i++){

            DcsFtpServer dcsFtpServer = dcsFiles.get(i).getDcsFtpServer();
            Integer ftpScannerId = dcsFtpServer.getFtpScannerId();
            DcsScanner dcsScanner = dcsScannerServer.selectByPrimaryKey(ftpScannerId);
            dcsFtpServer.setScannerIp(dcsScanner.getScannerIp());
        }
        return  dcsFiles;
    }

}
