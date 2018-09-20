package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import com.ultrapower.dcs.cluster.control.tools.SshShellExecBody;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;
import static com.ultrapower.dcs.cluster.control.tools.SshShellServerRestartProcess.queryBathStartServerShell;
import static com.ultrapower.dcs.cluster.control.tools.SshShellServerRestartProcess.queryBathStopServerShell;
import static javafx.scene.input.KeyCode.R;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.restartManageController
 * @Title 集群重启总管理
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-02 9:37
 */

@Controller
@RequestMapping("/restartManage/clusterRestartManage")
public class ClusterRestartManageController {
    @Autowired
    private DcsProbeService dcsProbeService;

    private String[] clusterStopArray=PropertiesUtils.getProperty("clusterStopArray").split(",");
    private String[] clusterStartArray=PropertiesUtils.getProperty("clusterStartArray").split(",");

    /* *
     * @Title    Cluster重启管理
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:42
     **/
    @RequestMapping(value = "/")
    public String  clusterRestartIndex(ModelMap map){
        List<DcsProbe> dcsProbeList=dcsProbeService.findAllDcsProbeList();
        map.put("dcsProbeList",dcsProbeList);
        return "restart_manage/cluster_restart_manage" ;
     }

    /* *
     * @Title    获取Server重启流程图
     * @Description  
     * @Param     [serverChooseVal, operateChooseVal]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/31  10:54
     **/
    @RequestMapping(value = "/getServerRestartSteps")
    @ResponseBody
    public String  getServerRestartSteps(@RequestParam(required =true,value = "serverChooseVal")String serverChooseVal,@RequestParam(required =true,value = "operateChooseVal")String operateChooseVal){
      String steps=null;
       String stepsPropertiesName=null;
       if(!operateChooseVal.equals("none")){
       String operateChooseStepVal=operateChooseVal.substring(0,1).toUpperCase().concat(operateChooseVal.substring(1));//首字母大写

        if(serverChooseVal.equals("cluster")){
             stepsPropertiesName=serverChooseVal.concat("Service").concat(operateChooseStepVal).concat("StepArray");
          }else{
             stepsPropertiesName="commonServer".concat(operateChooseStepVal).concat("StepArray");
         }
           System.out.println("stepsPropertiesName:"+stepsPropertiesName);
           steps=PropertiesUtils.getProperty(stepsPropertiesName);
       }
        String jsonStr= JsonUtils.convertObjectToJsonStr(steps);
        System.out.println("steps:"+jsonStr);
        return jsonStr ;
    }
}