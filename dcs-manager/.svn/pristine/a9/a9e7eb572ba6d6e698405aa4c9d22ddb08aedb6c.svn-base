package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.tools.SshBatchShellExecResBody;
import com.ultrapower.dcs.cluster.control.tools.SshShellExecBody;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.ultrapower.dcs.cluster.control.tools.SshShellServerRestartProcess.*;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.restartManageController
 * @Title 集群重启管理之scanner重启
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-02 9:37
 */

@Controller
@RequestMapping("/restartManage/scannerRestart")
public class ScannerRestartController {

    /* *
     * @Title    scanner重启管理
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:42
     **/
    @RequestMapping(value = "/")
    public String  scannerRestartIndex(){
        return "restart_manage/scanner_restart" ;
     }

    /* *
     * @Title   scanner停止前预处理，判断停止条件是否具备，scanner停止不用考虑其它server情况
     * @Description  
     * @Param     [model]
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/scannerStopPreValidateProcess")
    @ResponseBody
    public String  scannerStopPreValidateProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new SshBatchShellExecResBody();
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        Boolean batchExecResultFlag=false;
        SshShellExecBody  hostShellExecBody=new SshShellExecBody();
        hostShellExecBody.setShellUses("停止前校验主机");
        hostShellExecBody.setShellSubUses("检查主机连通性");
        boolean hostActiveFlag=checkRemoteServerActiveAlive("scanner");
        if(!hostActiveFlag){
            hostShellExecBody.setResResultLevel("error");
            hostShellExecBody.setResConclusion("scanner主机远程检测不能被连接，请核对主机网络及端口通达性！");
        }else{
            hostShellExecBody.setResResultLevel("common");
            hostShellExecBody.setResConclusion("scanner主机远程检测可以被连接。");
        }
        shellExecList.add(hostShellExecBody);
        batchShellExecResBody.setShellExecList(shellExecList);
        batchExecResultFlag=hostActiveFlag;
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr ;
    }

    /* *
     * @Title    scanner停止处理,正在使用中
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:52
     **/
    @RequestMapping(value = "/scannerStopProcess")
    @ResponseBody
    public String scannerStopProcess(){
        SshBatchShellExecResBody batchShellExecResBody=queryBathStopServerShell("scanner");
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }
    /* *
     * @Title  scanner重启前预处理，判断停止条件是否具备，scanner启动前需判断masterServer已经启动
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/scannerStartPreValidateProcess")
    @ResponseBody
    public String  scannerStartPreValidateProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new SshBatchShellExecResBody();
        List<SshShellExecBody>  shellExecList= new ArrayList<SshShellExecBody>();
        Boolean batchExecResultFlag=false;
        SshShellExecBody  hostShellExecBody=new SshShellExecBody();
        Boolean hostActiveFlag=checkRemoteServerActiveAlive("scanner");
        hostShellExecBody.setShellUses("启动前校验主机");
        hostShellExecBody.setShellSubUses("检测主机连通性");
        if(!hostActiveFlag){
            hostShellExecBody.setResResultLevel("error");
            hostShellExecBody.setResConclusion("scanner主机远程检测不能被连接，请核对主机网络及端口通达性！");
            shellExecList.add(hostShellExecBody);
            batchShellExecResBody.setBatchExecResultFlag(hostActiveFlag);
        }else{
            hostShellExecBody.setResResultLevel("common");
            hostShellExecBody.setResConclusion("scanner主机远程检测可以被连接。");
            shellExecList.add(hostShellExecBody);

            SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
            activeShellExecBody.setShellUses("启动前校验server");//validateStartServer
            activeShellExecBody.setShellSubUses("启动前校验server");//beforeStartValidateServer
            String resResult=activeShellExecBody.getResResult().trim();
            boolean  execResultFlag=resResult.equals("")?false:true;
            String resLevel=activeShellExecBody.getResResultLevel();
            System.out.println("resLevel:"+resLevel);
            if(!resLevel.equals("error")){
            if(execResultFlag){
                activeShellExecBody.setResResultLevel("common");
            }else{
                activeShellExecBody.setResResultLevel("warn");
                activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
            }
            }else{
                execResultFlag=false;
            }
            shellExecList.add(activeShellExecBody);
            batchExecResultFlag=execResultFlag;
            batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        }
        batchShellExecResBody.setShellExecList(shellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return  jsonStr ;
    }

    /* *
    * @Title    scanner启动处理，正在使用中
    * @Description
    * @Param     []
    * @Return   java.lang.String
    * @throws
    * @author   fanjianfeng
    * @Date   2018/7/2  9:52
    **/
    @RequestMapping(value = "/scannerStartProcess")
    @ResponseBody
    public String scannerStartProcess(){
       /* List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
        String resResult=activeShellExecBody.getResResult().trim();
        activeShellExecBody.setShellUses("startServer");
        activeShellExecBody.setShellSubUses("beforeStartValidateServer");
        boolean  flag=resResult.equals("")?false:true;
        if(flag){
            activeShellExecBody.setResResultLevel("common");
            shellExecList.add(activeShellExecBody);
            List<SshShellExecBody> startShellExecList=queryBathStartServerShell("scanner");
            shellExecList.addAll(startShellExecList);
        }else{
            activeShellExecBody.setResResultLevel("warn");
            activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
            shellExecList.add(activeShellExecBody);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        SshBatchShellExecResBody batchShellExecResBody=queryBathStartServerShell("scanner");
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
     * @Title scanner重启处理，正在使用中(调整暂时不用)
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/6  11:48
     **/
    @RequestMapping(value = "/scannerRestartProcess")
    @ResponseBody
    public String scannerRestartProcess(){
   /*
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        List<SshShellExecBody> stopShellExecList=queryBathStopServerShell("scanner");
        shellExecList.addAll(stopShellExecList);

        SshShellExecBody activeShellExecBody=judgeServerActiveAlive("master");
        activeShellExecBody.setShellUses("startServer");
        activeShellExecBody.setShellSubUses("beforeStartValidateServer");
        String resResult=activeShellExecBody.getResResult().trim();
        boolean  flag=resResult.equals("")?false:true;
        if(flag){
            activeShellExecBody.setResResultLevel("common");
            shellExecList.add(activeShellExecBody);
            List<SshShellExecBody> startShellExecList=queryBathStartServerShell("scanner");
            shellExecList.addAll(startShellExecList);

        }else{
            activeShellExecBody.setResResultLevel("warn");
            activeShellExecBody.setResConclusion(activeShellExecBody.getResConclusion().concat(" 您需要启动该Server以进行后续操作！"));
            shellExecList.add(activeShellExecBody);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        String jsonstr="";
        return jsonstr;
    }

}
