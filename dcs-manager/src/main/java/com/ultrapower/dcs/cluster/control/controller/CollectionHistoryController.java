package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/20.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsHistoryFile;
import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsHistoryFileService;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.CollectionHistoryController
 * @Title 采集历史信息
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-20 14:25
 */
@Controller
public class CollectionHistoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsHistoryFileService dcsHistoryFileService;
    
    @Autowired
    private DcsFtpServerServer dcsFtpServerServer;
    @Autowired
    private DcsDataTypeService dcsDataTypeService;
    @Autowired
    private DcsProbeService  dcsProbeService;

   /* *
    * @Title    
    * @Description  
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws      
    * @author   jinyi
    * @Date   2018/6/20  15:53
    **/
    @RequestMapping(value = "/currentDayCollectionFiles/")
    public String collectionHistory(
            @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
            @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
            @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
            @RequestParam(required = false, defaultValue = "-1", value = "probeId") Integer probeId,
            @RequestParam(required = false, defaultValue = "", value = "pathAndName") String pathAndName,
            ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===collection_history begin!! ===");
        Map condition = new HashMap();

        if (ftpId != -1) {
            condition.put("ftpId", ftpId);
        }
        if (dataTypeId != -1) {
            condition.put("dataTypeId", dataTypeId);
        }
        if (probeId != -1) {
            condition.put("probeId", probeId);
        }
        if (StringUtils.isNotBlank(pathAndName)) {
            condition.put("pathAndName", pathAndName);
        }
        DateFormat f=new SimpleDateFormat("yyyyMMdd") ;
        String currentDate = f.format(new Date());
        //TODO 
        //currentDate="20180605";
        condition.put("beginTime", new Integer(currentDate));
        condition.put("endTime", new Integer(currentDate));
        List<DcsHistoryFile> dcsHistoryFileList = dcsHistoryFileService.getDcsHistoryFileList(condition);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsHistoryFileList, 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo", pageInfo);
        List<DcsFtpServer> ftPserverList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        List<DcsProbe> allDcsProbeList = dcsProbeService.findAllDcsProbeList();
        
        map.put("allDcsProbeList", allDcsProbeList);
        map.put("ftPserverList", ftPserverList);
        map.put("dcsDataTypeList", dcsDataTypeList);
        
//        map.put("queryftl", "/collection_history/collection_history_query.ftl");
//        map.put("scriptftl", "/collection_history/collection_history_script.ftl");
//        map.put("tableftl", "/collection_history/collection_history_table.ftl");
        map.put("formcontenturl", "/collection_history/collection_history_modal_detail.ftl");
        map.put("isHasSaveButton", "false");
        map.put("pageSize", pageSize);
        map.put("ftpId", ftpId);
        map.put("dataTypeId", dataTypeId);
        map.put("probeId", probeId);
        map.put("pathAndName", pathAndName);
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "collection_history/collection_history_table";
//        }
        return  "collection_history/collection_history";
    }

    /* *
    * @Title
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/20  15:53
    **/
    @RequestMapping(value = "/historyFiles/")
    public String collectionHistoryForTimeRange(
            @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
            @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
            @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
            @RequestParam(required = false, defaultValue = "-1", value = "probeId") Integer probeId,
            @RequestParam(required = false, defaultValue = "", value = "pathAndName") String pathAndName,
            String  beginTime,String  endTime,ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===historyFiles begin!! ===");
        Map condition = new HashMap();

        if (ftpId != -1) {
            condition.put("ftpId", ftpId);
        }
        if (dataTypeId != -1) {
            condition.put("dataTypeId", dataTypeId);
        }
        if (probeId != -1) {
            condition.put("probeId", probeId);
        }
        if (StringUtils.isNotBlank(pathAndName)) {
            condition.put("pathAndName", pathAndName);
        }


        if (StringUtils.isBlank(beginTime)) {
            DateFormat f=new SimpleDateFormat("yyyyMMdd") ;
            beginTime = f.format(new Date());


        }
        if (StringUtils.isBlank(endTime)) {
            DateFormat f=new SimpleDateFormat("yyyyMMdd") ;
            endTime = f.format(new Date());
        }
        //TODO 下面两行为测试
       // beginTime="20180605";
        //endTime= "20180605";
        DateFormat f=new SimpleDateFormat("yyyyMMdd") ;
        DateFormat f1=new SimpleDateFormat("yyyy-MM-dd") ;
        String beginTime1 = null;
        String endTime1 = null;
        try {
            beginTime1 = f1.format(f.parse(beginTime));
            endTime1 = f1.format(f.parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("beginTime", beginTime1);
        map.put("endTime", endTime1);
        condition.put("beginTime", new Integer(beginTime));
        condition.put("endTime", new Integer(endTime));
        
        
        List<DcsHistoryFile> dcsHistoryFileList = dcsHistoryFileService.getDcsHistoryFileList(condition);

        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsHistoryFileList, 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        map.put("pageInfo", pageInfo);
        List<DcsFtpServer> ftPserverList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        List<DcsProbe> allDcsProbeList = dcsProbeService.findAllDcsProbeList();

        map.put("allDcsProbeList", allDcsProbeList);
        map.put("ftPserverList", ftPserverList);
        map.put("dcsDataTypeList", dcsDataTypeList);

//        map.put("queryftl", "/collection_history/collection_history_time_query.ftl");
//        map.put("scriptftl", "/collection_history/collection_history_time_script.ftl");
//        map.put("tableftl", "/collection_history/collection_history_table.ftl");
        map.put("formcontenturl", "/collection_history/collection_history_modal_detail.ftl");
        map.put("isHasSaveButton", "false");
        map.put("pageSize", pageSize);
        map.put("ftpId", ftpId);
        map.put("dataTypeId", dataTypeId);
        map.put("probeId", probeId);
        map.put("pathAndName", pathAndName);
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "collection_history/collection_history_table";
//        }
        return "collection_history/collection_history_time";

    }
}
