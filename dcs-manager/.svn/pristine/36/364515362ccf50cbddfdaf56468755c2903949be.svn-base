package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.tools.SshBatchShellExecResBody;
import com.ultrapower.dcs.cluster.control.tools.SshShellExecBody;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.ultrapower.dcs.cluster.control.tools.SshShellServerRestartProcess.*;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.restartManageController
 * @Title 集群重启管理之probe重启
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-02 9:37
 */

@Controller
@RequestMapping("/restartManage/probeRestart")
public class ProbeRestartController {

    private  String[] probeArray=PropertiesUtils.getProperty("probeArray").split(",");

    /* *
     * @Title    probe重启管理
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:42
     **/
    @RequestMapping(value = "/")
    public String  probeRestartIndex(Model model){
        return "restart_manage/probe_restart";
     }

    /* *
     * @Title   probe停止前预处理，判断停止条件是否具备，probe停止不用考虑其它server情况
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/probeStopPreValidateProcess")
    @ResponseBody
    public String  probeStopPreValidateProcess(@RequestParam(required =true,value = "probeName")String probeName){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
        if(!probeName.equals("probeFull")){
            SshShellExecBody  hostShellExecBody=new SshShellExecBody();
            boolean hostActiveFlag=checkRemoteServerActiveAlive(probeName);
            hostShellExecBody.setShellUses("停止前校验主机");
            hostShellExecBody.setShellSubUses("检查"+probeName+"主机连通性");
            if(!hostActiveFlag){
                hostShellExecBody.setResResultLevel("error");
                hostShellExecBody.setResConclusion(probeName+"主机远程检测不能被连接，请核对主机网络及端口通达性！");
                batchShellExecList.add(hostShellExecBody);
                batchExecResultFlag=hostActiveFlag;
                batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
            }else {
                hostShellExecBody.setResResultLevel("common");
                hostShellExecBody.setResConclusion(probeName+"主机远程检测可以被连接。");
                batchShellExecList.add(hostShellExecBody);
                batchExecResultFlag=hostActiveFlag;
                batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
            }
        }else {
            for (int i = 0; i < probeArray.length; i++) {
                SshShellExecBody hostShellExecBody = new SshShellExecBody();
                boolean hostActiveFlag = checkRemoteServerActiveAlive(probeArray[i]);
                hostShellExecBody.setShellUses("停止前校验主机");
                hostShellExecBody.setShellSubUses("检查"+probeArray[i] +"主机连通性");
                if (!hostActiveFlag) {
                    hostShellExecBody.setResResultLevel("error");
                    hostShellExecBody.setResConclusion(probeArray[i] + "主机远程检测不能被连接，请核对主机网络及端口通达性！");
                    batchShellExecList.add(hostShellExecBody);
                    //batchExecResultFlag = hostActiveFlag;
                    //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
                    execFullFlag = false;
                    break;
                } else {
                    hostShellExecBody.setResResultLevel("common");
                    hostShellExecBody.setResConclusion(probeArray[i] + "主机远程检测可以被连接。");
                    batchShellExecList.add(hostShellExecBody);
                    //batchExecResultFlag = hostActiveFlag;
                    //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
                }
            }
             if(execFullFlag){
                    batchExecResultFlag=true;
              }
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        batchShellExecResBody.setShellExecList(batchShellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr ;
    }

    /* *
     * @Title    probe停止处理，正在使用中
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:52
     **/
    @RequestMapping(value = "/probeStopProcess")
    @ResponseBody
    public String probeStopProcess(@RequestParam(required =true,value = "probeName")String probeName){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
       //List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        if(!probeName.equals("probeFull")){
            batchShellExecResBody=queryBathStopServerShell(probeName);
        }else{
            for(int i=0;i<probeArray.length;i++){
                SshBatchShellExecResBody shellExecResBody=queryBathStopServerShell(probeArray[i]);
                batchShellExecList.addAll(shellExecResBody.getShellExecList());
                Boolean shellExecResFlag=shellExecResBody.getBatchExecResultFlag();
                if(!shellExecResFlag){
                    execFullFlag=false;
                    break;
                }
            }
            if(execFullFlag){
                batchExecResultFlag=true;
            }
            batchShellExecResBody.setShellExecList(batchShellExecList);
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        String jsonStr= JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
         return jsonStr;
    }
    /* *
     * @Title  probe重启前预处理，判断停止条件是否具备，probe启动前需判断masterServer已经启动
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/probeStartPreValidateProcess")
    @ResponseBody
    public String  probeStartPreValidateProcess(@RequestParam(required =true,value = "probeName")String probeName){
        SshBatchShellExecResBody batchShellExecResBody=new SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean batchHostActiveFlag=false;
        boolean execFullFlag=true;
        if(!probeName.equals("probeFull")){
            SshShellExecBody  hostShellExecBody=new SshShellExecBody();
            boolean hostActiveFlag=checkRemoteServerActiveAlive(probeName);
            hostShellExecBody.setShellUses("停止前校验主机");
            hostShellExecBody.setShellSubUses("检查"+probeName+"主机连通性");
            if(!hostActiveFlag){
                hostShellExecBody.setResResultLevel("error");
                hostShellExecBody.setResConclusion(probeName+"主机远程检测不能被连接，请检查主机网络及端口通达性！");
                batchShellExecList.add(hostShellExecBody);
                batchHostActiveFlag=hostActiveFlag;
                batchExecResultFlag=hostActiveFlag;
                batchShellExecResBody.setBatchExecResultFlag(batchHostActiveFlag);
            }else {
                hostShellExecBody.setResResultLevel("common");
                hostShellExecBody.setResConclusion(probeName+"主机远程检测可以被连接。");
                batchShellExecList.add(hostShellExecBody);
                batchHostActiveFlag=hostActiveFlag;
                //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
            }
        }else {
            for (int i = 0; i < probeArray.length; i++) {
                SshShellExecBody hostShellExecBody = new SshShellExecBody();
                boolean hostActiveFlag = checkRemoteServerActiveAlive(probeArray[i]);
                hostShellExecBody.setShellUses("停止前校验主机");
                hostShellExecBody.setShellSubUses("检查"+probeArray[i]+"主机连通性");
                if (!hostActiveFlag) {
                    hostShellExecBody.setResResultLevel("error");
                    hostShellExecBody.setResConclusion(probeArray[i] + "主机远程检测不能被连接，请检查主机网络及端口通达性！");
                    batchShellExecList.add(hostShellExecBody);
                    batchExecResultFlag=hostActiveFlag;
                    batchShellExecResBody.setBatchExecResultFlag(batchHostActiveFlag);
                    execFullFlag = false;
                    break;
                } else {
                    hostShellExecBody.setResResultLevel("common");
                    hostShellExecBody.setResConclusion(probeArray[i] + "主机远程检测可以被连接。");
                    batchShellExecList.add(hostShellExecBody);
                }
            }
            if(execFullFlag){
                batchHostActiveFlag=true;
            }
            //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
      if(batchHostActiveFlag){
          SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
          activeShellExecBody.setShellUses("启动前校验server");//validateStartServer
          activeShellExecBody.setShellSubUses("启动前校验server");//beforeStartValidateServer
          String resResult=activeShellExecBody.getResResult().trim();
          boolean  execResultFlag=resResult.equals("")?false:true;
          String resLevel=activeShellExecBody.getResResultLevel();
          if(!resLevel.equals("error")) {
              if (execResultFlag) {
                  activeShellExecBody.setResResultLevel("common");
                  batchExecResultFlag = true;
              } else {
                  activeShellExecBody.setResResultLevel("warn");
                  activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
                  batchExecResultFlag = false;
              }
          }else{
              batchExecResultFlag = false;
          }
          batchShellExecList.add(activeShellExecBody);
      }
        batchShellExecResBody.setShellExecList(batchShellExecList);
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
    * @Title    probe启动处理,正在使用中
    * @Description
    * @Param     []
    * @Return   java.lang.String
    * @throws
    * @author   fanjianfeng
    * @Date   2018/7/2  9:52
    **/
    @RequestMapping(value = "/probeStartProcess")
    @ResponseBody
    public String probeStartProcess(@RequestParam(required =true,value = "probeName")String probeName){
          /*List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
        String resResult=activeShellExecBody.getResResult().trim();
        activeShellExecBody.setShellUses("startServer");
        activeShellExecBody.setShellSubUses("beforeStartValidateServer");
        boolean flag=resResult.equals("")?false:true;
       if(flag){
           shellExecList.add(activeShellExecBody);
           if(!probeName.equals("probeFull")){
               List<SshShellExecBody> startShellExecList=queryBathStartServerShell(probeName);
               shellExecList.addAll(startShellExecList);
           }else{
               for(int i=0;i<probeArray.length;i++){
                   List<SshShellExecBody> startShellExecList=queryBathStartServerShell(probeArray[i]);
                   shellExecList.addAll(startShellExecList);
               }
           }
       }else{
           activeShellExecBody.setResResultLevel("warn");
           activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
           shellExecList.add(activeShellExecBody);
       }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/

        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
        if(!probeName.equals("probeFull")){
            batchShellExecResBody=queryBathStartServerShell(probeName);
        }else{
            for(int i=0;i<probeArray.length;i++){
                SshBatchShellExecResBody shellExecResBody=queryBathStartServerShell(probeArray[i]);
                batchShellExecList.addAll(shellExecResBody.getShellExecList());
                Boolean shellExecResFlag=shellExecResBody.getBatchExecResultFlag();
                if(!shellExecResFlag){
                    execFullFlag=false;
                    break;
                }
            }
            if(execFullFlag){
                batchExecResultFlag=true;
            }
            batchShellExecResBody.setShellExecList(batchShellExecList);
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        String jsonStr= JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
       * @Title    probe重启动处理，正在使用中（调整暂停不用）
       * @Description
       * @Param     []
       * @Return   java.lang.String
       * @throws
       * @author   fanjianfeng
       * @Date   2018/7/2  9:52
       **/
    @RequestMapping(value = "/probeRestartProcess")
    @ResponseBody
    public String probeRestartProcess(@RequestParam(required =true,value = "probeName")String probeName){
/*
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        if(!probeName.equals("probeFull")){
            List<SshShellExecBody> startShellExecList=queryBathStopServerShell(probeName);
            shellExecList.addAll(startShellExecList);
        }else{
            for(int i=0;i<probeArray.length;i++){
                List<SshShellExecBody> startShellExecList=queryBathStopServerShell(probeArray[i]);
                shellExecList.addAll(startShellExecList);
            }
        }
        SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
        String resResult=activeShellExecBody.getResResult().trim();
        activeShellExecBody.setShellUses("startServer");
        activeShellExecBody.setShellSubUses("beforeStartValidateServer");
        boolean flag=resResult.equals("")?false:true;
        if(flag){
            shellExecList.add(activeShellExecBody);
            if(!probeName.equals("probeFull")){
                List<SshShellExecBody> startShellExecList=queryBathStartServerShell(probeName);
                shellExecList.addAll(startShellExecList);
            }else{
                for(int i=0;i<probeArray.length;i++){
                    List<SshShellExecBody> startShellExecList=queryBathStartServerShell(probeArray[i]);
                    shellExecList.addAll(startShellExecList);
                }
            }
        }else{
            activeShellExecBody.setResResultLevel("warn");
            activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
            shellExecList.add(activeShellExecBody);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        String jsonStr="";
        return jsonStr;
    }
}