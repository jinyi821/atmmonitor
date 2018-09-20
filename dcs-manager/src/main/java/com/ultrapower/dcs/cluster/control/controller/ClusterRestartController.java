package com.ultrapower.dcs.cluster.control.controller;

import com.ultrapower.dcs.cluster.control.tools.SshBatchShellExecResBody;
import com.ultrapower.dcs.cluster.control.tools.SshShellExecBody;
import com.ultrapower.dcs.cluster.control.utils.JsonUtils;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
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
 * @Title 集群重启管理
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-02 9:37
 */

@Controller
@RequestMapping("/restartManage/clusterRestart")
public class ClusterRestartController {

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
    public String  clusterRestartIndex(Model model){
        return "restart_manage/cluster_restart" ;
     }

    /* *
        * @Title  cluster停止前预处理，判断停止条件是否具备,cluster主要判断主机通达性
        * @Description
        * @Param     [model]
        * @Return   java.lang.String
        * @throws
        * @author   fanjianfeng
        * @Date   2018/7/2  9:46
        **/
    @RequestMapping(value = "/clusterStopPreValidateProcess")
    @ResponseBody
    public String  clusterStopPreValidateProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
            for (int i = 0; i < clusterStopArray.length; i++) {
                SshShellExecBody hostShellExecBody = new SshShellExecBody();
                boolean hostActiveFlag = checkRemoteServerActiveAlive(clusterStopArray[i]);
                String showServer=clusterStopArray[i].equals("master")?"server":clusterStopArray[i];
                hostShellExecBody.setShellUses("停止前校验主机");
                hostShellExecBody.setShellSubUses("检查"+showServer+"主机连通性");
                if (!hostActiveFlag) {
                    hostShellExecBody.setResResultLevel("error");
                    hostShellExecBody.setResConclusion(showServer+ "主机远程检测不能被连接，请核对主机网络及端口通达性！");
                    batchShellExecList.add(hostShellExecBody);
                    //batchExecResultFlag = hostActiveFlag;
                    //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
                    execFullFlag = false;
                    break;
                } else {
                    hostShellExecBody.setResResultLevel("common");
                    hostShellExecBody.setResConclusion(showServer + "主机远程检测可以被连接。");
                    batchShellExecList.add(hostShellExecBody);
                    //batchExecResultFlag = hostActiveFlag;
                    //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
                }
            }
            if(execFullFlag){
                batchExecResultFlag=true;
            }
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        batchShellExecResBody.setShellExecList(batchShellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return  jsonStr;
    }




    /* *
     * @Title    cluster停止处理，正在使用中
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/7/2  9:52
     **/
    @RequestMapping(value = "/clusterStopProcess")
    @ResponseBody
    public String clusterStopProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
       // List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        for(int i=0;i<clusterStopArray.length;i++){
          SshBatchShellExecResBody shellExecResBody=queryBathStopServerShell(clusterStopArray[i]);
          Boolean shellExecResFlag=shellExecResBody.getBatchExecResultFlag();
          batchShellExecList.addAll(shellExecResBody.getShellExecList());
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
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }

    /* *
     * @Title  cluster重启前预处理，判断停止条件是否具备，cluster启动前需判断集群主机通达性
     * @Description
     * @Param     [model]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/7/2  9:46
     **/
    @RequestMapping(value = "/clusterStartPreValidateProcess")
    @ResponseBody
    public String  clusterStartPreValidateProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
        for (int i = 0; i < clusterStartArray.length; i++) {
            SshShellExecBody hostShellExecBody = new SshShellExecBody();
            boolean hostActiveFlag = checkRemoteServerActiveAlive(clusterStartArray[i]);
            String showServer=clusterStartArray[i].equals("master")?"server":clusterStartArray[i];
            hostShellExecBody.setShellUses("启动前校验主机");
            hostShellExecBody.setShellSubUses("检查"+showServer+"主机连通性");
            if (!hostActiveFlag) {
                hostShellExecBody.setResResultLevel("error");
                hostShellExecBody.setResConclusion(showServer+"主机远程检测不能被连接，请核对主机网络及端口通达性！");
                batchShellExecList.add(hostShellExecBody);
                //batchExecResultFlag = hostActiveFlag;
                //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
                execFullFlag = false;
                break;
            } else {
                hostShellExecBody.setResResultLevel("common");
                hostShellExecBody.setResConclusion(showServer+"主机远程检测可以被连接。");
                batchShellExecList.add(hostShellExecBody);
                //batchExecResultFlag = hostActiveFlag;
                //batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
            }
        }
        if(execFullFlag){
            batchExecResultFlag=true;
        }
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        batchShellExecResBody.setShellExecList(batchShellExecList);
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return  jsonStr;
    }

    /* *
    * @Title    cluster启动处理,正在使用中
    * @Description
    * @Param     []
    * @Return   java.lang.String
    * @throws
    * @author   fanjianfeng
    * @Date   2018/7/2  9:52
    **/
    @RequestMapping(value = "/clusterStartProcess")
    @ResponseBody
    public String clusterStartProcess(){
        SshBatchShellExecResBody batchShellExecResBody=new  SshBatchShellExecResBody();
        List<SshShellExecBody> batchShellExecList=new ArrayList<SshShellExecBody>();
        boolean batchExecResultFlag=false;
        boolean execFullFlag=true;
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        for(int i=0;i<clusterStartArray.length;i++){
            SshBatchShellExecResBody shellExecResBody=queryBathStartServerShell(clusterStartArray[i]);
            Boolean shellExecResFlag=shellExecResBody.getBatchExecResultFlag();
            batchShellExecList.addAll(shellExecResBody.getShellExecList());
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
        String jsonStr = JsonUtils.convertObjectToJsonStr(batchShellExecResBody);
        return jsonStr;
    }







    /* *
       * @Title    cluster重启动处理，正在使用中(最新调整不用)
       * @Description
       * @Param     []
       * @Return   java.lang.String
       * @throws
       * @author   fanjianfeng
       * @Date   2018/7/2  9:52
       **/
    @RequestMapping(value = "/clusterRestartProcess")
    @ResponseBody
    public String clusterRestartProcess(){

       /* List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        for(int i=0;i<clusterStopArray.length;i++){
            List<SshShellExecBody> stopShellExecList=queryBathStopServerShell(clusterStopArray[i]);
            shellExecList.addAll(stopShellExecList);
        }
        for(int i=0;i<clusterStartArray.length;i++){
            List<SshShellExecBody> startShellExecList=queryBathStartServerShell(clusterStartArray[i]);
            shellExecList.addAll(startShellExecList);
        }
        String jsonStr= JsonUtils.convertListToJsonStr(shellExecList);*/
        String jsonStr="";
        return jsonStr;
    }
}