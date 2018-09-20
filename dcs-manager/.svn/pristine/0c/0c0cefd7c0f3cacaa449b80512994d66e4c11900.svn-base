package com.ultrapower.dcs.cluster.control.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import com.ultrapower.dcs.cluster.control.tools.MonitorDbProcess;
import com.ultrapower.dcs.cluster.control.tools.MonitorRunningProcess;
import com.ultrapower.dcs.cluster.control.tools.MonitorSysTimeProcess;
import com.ultrapower.dcs.cluster.control.tools.RmiTestClientTools;
import com.ultrapower.dcs.cluster.control.utils.DateTimeUtils;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import com.ultrapower.rmi.RmiServerInterfaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlFormatName.JSON;
import static com.ultrapower.dcs.cluster.control.utils.DateTimeUtils.minuteBetween;
import static java.awt.SystemColor.control;
import static org.springframework.boot.configurationprocessor.json.JSONArray.*;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.RunOverviewController
 * @Title 集群情况中运行概览控制类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-08 17:45
 */
@Controller
@RequestMapping("/runOverview")
public class RunOverviewController {
    @Autowired
    private DcsProbeService dcsProbeService;

    private Long check_heart_interval_minutes=Long.valueOf(PropertiesUtils.getProperty("dcs_probe_server_check_heart_interval_minutes"));

    @RequestMapping(value = "/")
    public String runOverview(ModelMap map, HttpServletRequest request){
        //String contextPath = request.getContextPath();
        //map.addAttribute("BASE_PATH", contextPath);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        System.out.println("-----runOverview------");
        return "run_overview/run_overview";
    }




    /* *
     * @Title  集群情况/运行概览/scanner运行情况中检查scanner进程运行活跃状态
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/11  14:26
     **/
    @RequestMapping(value = "/checkDcsScanProcessServerActiveStatus")
    @ResponseBody
    public String  checkDcsScanProcessServerActiveStatus(){
      boolean flag= MonitorRunningProcess.checkDcsScanProcessServerActive();
      return String.valueOf(flag);
    }

    /* *
     * @Title  集群情况/运行概览/server运行情况中检查serverRmi接口运行活跃状态
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/11  14:32
     **/
    @RequestMapping(value = "/checkDcsServerRmiInterfaceActiveStatus")
    @ResponseBody
    public String checkDcsServerRmiInterfaceActiveStatus(){
    boolean flag= RmiTestClientTools.checkIRmiTestServerActive();   //RmiServerInterfaceClient.checkDcsServerActive();
    return String.valueOf(flag);
    }

    /* *
     * @Title  集群情况/运行概览/probe运行情况中检查probe运行状态列表
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/11  14:18
     **/
    @RequestMapping(value = "/checkDcsProbeRunStatusList")
    @ResponseBody
    public String  checkDcsProbesRunStatusList(){
     List<DcsProbe> dcsProbeList=dcsProbeService.findAllDcsProbeList();
     String currentDcsProbeServerDateTime= MonitorSysTimeProcess.getDcsProbeServerSysTime();
     Date currentProbeServerDateTime=null;
     if(currentDcsProbeServerDateTime!=null){
         currentProbeServerDateTime=DateTimeUtils.formatStringToDate(currentDcsProbeServerDateTime);
     }
     for(int i=0;i<dcsProbeList.size();i++){
         DcsProbe  probe=dcsProbeList.get(i);
         Date probeDateTime=probe.getUpdate_time();
         System.out.println("probeTime:"+probeDateTime+"//currentDcsProbeServerDateTime:"+currentDcsProbeServerDateTime+"//check_heart_interval_minutes:"+check_heart_interval_minutes);
         Long betweenMinutes=null;
         if(currentProbeServerDateTime!=null){
             betweenMinutes=DateTimeUtils.minuteBetween(probeDateTime,currentProbeServerDateTime);
         }
         if(betweenMinutes!=null && betweenMinutes>check_heart_interval_minutes){
             probe.setRunningStatus("2");
         }else if(betweenMinutes!=null && betweenMinutes<=check_heart_interval_minutes){
             probe.setRunningStatus("1");
         }else{
             probe.setRunningStatus("2");
         }
         //probe.setRunningStatus("1");
         dcsProbeList.set(i,probe);//变更probe对象属性
     }
        String jsonStr= JsonUtils.convertListToJsonStr(dcsProbeList);
        return jsonStr; //"findAllDcsProbeRunStautList";
    }

    /* *
     * @Title  集群情况/运行概览/元数据库运行情况中检查元数据库进程服务运行活跃状态
     * @Description
     * @Param     []
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/11  14:21
     **/
    @RequestMapping(value = "/checkDcsMetadataServiceActiveStatus")
    @ResponseBody
    public String checkDcsMetadataServiceActiveStatus(){
        boolean flag= MonitorDbProcess.checkDbProcessServiceActive();
        return String.valueOf(flag);
    }

}