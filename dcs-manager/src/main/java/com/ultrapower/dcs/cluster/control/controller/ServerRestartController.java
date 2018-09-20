package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.tools.SshBatchShellExecResBody;
import com.ultrapower.dcs.cluster.control.tools.SshShellExecBody;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.ultrapower.dcs.cluster.control.tools.SshShellServerRestartProcess.*;
import static java.awt.SystemColor.control;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.restartManageController
 * @Title 集群重启管理之server重启
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-02 9:37
 */

@Controller
@RequestMapping("/restartManage/serverRestart")
public class ServerRestartController {

    private String[] masterPreServerArray= PropertiesUtils.getProperty("serverPreValidateArray").split(",");


    /* *
     * @Title    server重启管理,正在使用中
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:42
     **/
    @RequestMapping(value = "/")
    public String  serverRestartIndex(Model model){
        return "restart_manage/server_restart" ;
     }

    /* *
     * @Title   server停止前预处理，判断停止条件是否具备，server停止需要判断scanner和Probe是否已停止，否则无法进行停止操作
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/serverStopPreValidateProcess")
    @ResponseBody
    public String  serverStopPreValidateProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        Boolean batchExecResultFlag = false;
        SshShellExecBody  hostShellExecBody=new SshShellExecBody();
        boolean hostActiveFlag=checkRemoteServerActiveAlive("master");
        hostShellExecBody.setShellUses("停止前校验主机");
        hostShellExecBody.setShellSubUses("检查主机连通性");
        if(!hostActiveFlag){
            hostShellExecBody.setResResultLevel("error");
            hostShellExecBody.setResConclusion("server主机远程检测不能被连接，请核对主机网络及端口通达性！");
            batchShellExecList.add(hostShellExecBody);
            batchShellExecResBody.setBatchExecResultFlag(hostActiveFlag);
        }else {
            hostShellExecBody.setResResultLevel("common");
            hostShellExecBody.setResConclusion("server主机远程检测可以被连接。");
            batchShellExecList.add(hostShellExecBody);
            //String[] masterPreServerArray = {"scanner", "probe30", "probe31", "probe33", "probe34"};
            Integer activePreServerSize = 0;
            for (int i = 0; i < masterPreServerArray.length; i++) {
                SshShellExecBody activeShellExecBody = judgeServerActiveAlive(masterPreServerArray[i]);
                activeShellExecBody.setShellUses("停止前校验Server");//validateStopServer
                activeShellExecBody.setShellSubUses("停止前校验" + masterPreServerArray[i]);//"beforeStopValidate"+masterPreServerArray[i]+"Server"
                String resResult = activeShellExecBody.getResResult().trim();
                boolean aliveFlag = resResult.equals("") ? false : true;
                String resLevel=activeShellExecBody.getResResultLevel();
                if(!resLevel.equals("error")) {
                    if (aliveFlag) {
                        activePreServerSize = activePreServerSize + 1;
                        activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要停止该Server以进行后续操作！"));
                        activeShellExecBody.setResResultLevel("warn");
                    }else{
                        activeShellExecBody.setResResultLevel("common");
                    }
                    batchShellExecList.add(activeShellExecBody);
                    if (aliveFlag) {
                        break;
                    }
                }else{
                    activePreServerSize = activePreServerSize + 1;
                    batchShellExecList.add(activeShellExecBody);
                    break;
                }
            }
            if (activePreServerSize == 0) {
                batchExecResultFlag = true;
            }
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        batchShellExecResBody.setShellExecList(batchShellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
       return jsonStr;
    }

    /* *
     * @Title  server停止处理,正在使用中
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:52
     **/
    @RequestMapping(value = "/serverStopProcess")
    @ResponseBody
    public String serverStopProcess(){
        /*List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        String[] masterPreServerArray={"scanner","probe30","probe31","probe33","probe34"};
        Integer activePreServerSize=0;
       for(int i=0;i<masterPreServerArray.length;i++){
           SshShellExecBody activeShellExecBody=judgeServerActiveAlive(masterPreServerArray[i]);
           activeShellExecBody.setShellUses("stopServer");
           activeShellExecBody.setShellSubUses("beforeStopValidate"+masterPreServerArray[i]+"Server");
           String resResult=activeShellExecBody.getResResult().trim();
           boolean  aliveFlag=resResult.equals("")?false:true;
          if(aliveFlag){
              activePreServerSize=activePreServerSize+1;
              activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" you need to stop the server for later operation！"));
              activeShellExecBody.setResResultLevel("warn");
          }
           shellExecList.add(activeShellExecBody);
           if(aliveFlag){
               break;
           }
       }
        if(activePreServerSize==0){
        List<SshShellExecBody> stopShellExecList=queryBathStopServerShell("master");
        shellExecList.addAll(stopShellExecList);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        SshBatchShellExecResBody batchShellExecResBody=queryBathStopServerShell("master");
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
     * @Title  server重启前预处理，判断停止条件是否具备，server启动前需判断scanner和probe是否处于停止状态
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/serverStartPreValidateProcess")
    @ResponseBody
    public String  serverStartPreValidateProcess(){
        //String[] masterPreServerArray={"scanner","probe30","probe31","probe33","probe34"};
        SshBatchShellExecResBody batchShellExecResBody=new SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        Boolean batchExecResultFlag = false;
        SshShellExecBody  hostShellExecBody=new SshShellExecBody();
        boolean hostActiveFlag=checkRemoteServerActiveAlive("master");
        hostShellExecBody.setShellUses("启动前校验主机");
        hostShellExecBody.setShellSubUses("检查主机连通性");
        if(!hostActiveFlag){
            hostShellExecBody.setResResultLevel("error");
            hostShellExecBody.setResConclusion("server主机远程检测不能被连接，请核对主机网络及端口通达性！");
            batchShellExecList.add(hostShellExecBody);
            batchShellExecResBody.setBatchExecResultFlag(hostActiveFlag);
        }else {
            hostShellExecBody.setResResultLevel("common");
            hostShellExecBody.setResConclusion("server主机远程检测可以被连接。");
            batchShellExecList.add(hostShellExecBody);
            Integer activePreServerSize = 0;
            for (int i = 0; i < masterPreServerArray.length; i++) {
                SshShellExecBody activeShellExecBody = judgeServerActiveAlive(masterPreServerArray[i]);
                activeShellExecBody.setShellUses("启动前校验server"); //validateStopServer
                activeShellExecBody.setShellSubUses("启动前校验" + masterPreServerArray[i]);//beforeStopValidate
                String resResult = activeShellExecBody.getResResult().trim();
                boolean aliveFlag = resResult.equals("") ? false : true;
                String resLevel=activeShellExecBody.getResResultLevel();
                if(!resLevel.equals("error")){
                    if (aliveFlag) {
                        activePreServerSize = activePreServerSize + 1;
                        activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要停止该Server以进行后续操作！"));
                        activeShellExecBody.setResResultLevel("warn");
                    }else{
                        activeShellExecBody.setResResultLevel("common");
                    }
                    batchShellExecList.add(activeShellExecBody);
                    if (aliveFlag) {
                        break;
                    }
                }else{
                    activePreServerSize = activePreServerSize + 1;
                    batchShellExecList.add(activeShellExecBody);
                    break;
                }
            }
            if (activePreServerSize == 0) {
                batchExecResultFlag = true;
            }
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        batchShellExecResBody.setShellExecList(batchShellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
    * @Title  server启动处理，正在使用中
    * @Description
    * @Param  []
    * @Return java.lang.String
    * @throws
    * @author fanjianfeng
    * @Date   2018/7/2  9:52
    **/
    @RequestMapping(value = "/serverStartProcess")
    @ResponseBody
    public String serverStartProcess(){
     /*   List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        String[] masterPreServerArray={"scanner","probe30","probe31","probe33","probe34"};
        Integer activePreServerSize=0;
        for(int i=0;i<masterPreServerArray.length;i++){
            SshShellExecBody activeShellExecBody=judgeServerActiveAlive(masterPreServerArray[i]);
            activeShellExecBody.setShellUses("startServer");
            activeShellExecBody.setShellSubUses("beforeStartValidate"+masterPreServerArray[i]+"Server");
            String resResult=activeShellExecBody.getResResult().trim();
            boolean  aliveFlag=resResult.equals("")?false:true;
            if(aliveFlag){
                activePreServerSize=activePreServerSize+1;
                activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
                activeShellExecBody.setResResultLevel("warn");
            }
            shellExecList.add(activeShellExecBody);
            if(aliveFlag){
                break;
            }
        }
        if(activePreServerSize==0){
            List<SshShellExecBody> startShellExecList=queryBathStartServerShell("master");
            shellExecList.addAll(startShellExecList);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        SshBatchShellExecResBody batchShellExecResBody=queryBathStartServerShell("master");
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }
    /* *
       * @Title  server重启动处理，正在使用中(调整暂时不用)
       * @Description
       * @Param  []
       * @Return java.lang.String
       * @throws
       * @author fanjianfeng
       * @Date   2018/7/2  9:52
       **/
    @RequestMapping(value = "/serverRestartProcess")
    @ResponseBody
    public String serverRestartProcess(){
       /* List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        String[] masterPreServerArray={"scanner","probe30","probe31","probe33","probe34"};
        Integer activePreServerSize=0;
        for(int i=0;i<masterPreServerArray.length;i++){
            SshShellExecBody activeShellExecBody=judgeServerActiveAlive("scanner");
            activeShellExecBody.setShellUses("validateServer");
            activeShellExecBody.setShellSubUses("beforeRestartValidate"+masterPreServerArray[i]+"Server");
            String resResult=activeShellExecBody.getResResult().trim();
            boolean  aliveFlag=resResult.equals("")?false:true;
            if(aliveFlag){
                activePreServerSize=activePreServerSize+1;
                activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
                activeShellExecBody.setResResultLevel("warn");
            }
            shellExecList.add(activeShellExecBody);
            if(aliveFlag){
                break;
            }
        }
        if(activePreServerSize==0){
            List<SshShellExecBody> stopShellExecList=queryBathStopServerShell("master");
            shellExecList.addAll(stopShellExecList);
            List<SshShellExecBody> startShellExecList=queryBathStartServerShell("master");
            shellExecList.addAll(startShellExecList);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        String jsonStr="";
        return jsonStr;
    }



}