package com.ultrapower.dcs.cluster.control.tools;

/*import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;*/
import ch.ethz.ssh2.Connection;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.ultrapower.dcs.cluster.control.tools.SshShellBasicTools;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static com.ultrapower.dcs.cluster.control.tools.JschSshShellHelper.getChanel;
import static com.ultrapower.dcs.cluster.control.tools.JschSshShellHelper.getExecCmdRes;
import static com.ultrapower.dcs.cluster.control.tools.SshShellBasicTools.getSession;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.SshShellRestartToos
 * @Title sshShell脚本服务重启处理
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-28 10:52
 */
public class SshShellServerRestartProcess {
    public static int threadWaitSleep = 2000; //进程等待睡眠时间，0.5秒


 /* //执行server批量脚本停止服务器,serverType为scan、probe30、probe31、probe33、probe34、master几种
    public static  List<SshShellExecBody> queryBathStopServerShell(String serverType) {

        List<SshShellExecBody> shellExecList = new ArrayList<SshShellExecBody>();
        PropertiesUtils.init();
        String host = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_host");
        int port = Integer.valueOf(PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_port"));
        String username = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_username");
        String password = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_password");
        String activeCmd = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_active_cmd");
        String killCmd = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_kill_cmd");
        System.out.println("host:" + host + "/port:" + port + "/username:" + username + "/password:" + password + "/activeCmd:" + activeCmd + "/killCmd:" + killCmd);
       //连接并登陆
        Connection conn = SshShellBasicTools.login(host, port, username, password);
        //获取Session
        Session sess = null;

        try {
            sess = conn.openSession();

            //判断会话是否成功
            //int activeStatus = sess.getExitStatus();//如果成功返回0

            //执行activeCmd命令
            SshShellExecBody activeSshShell = new SshShellExecBody();
            //获取控制台信息
            String activeResult = SshShellBasicTools.printCmd(conn, sess, activeCmd);
            activeSshShell.setShellName("activeCmd");
            activeSshShell.setShellCmd(activeCmd);
            //activeSshShell.setResStatus(activeStatus);
            activeSshShell.setResResult(activeResult);
            shellExecList.add(activeSshShell);
            //activeStatus==0 &&
            if (activeResult.trim().length() > 0) { //当前正活跃，可进行下一项
                sess.close();//会话关闭，一次会话只能执行一个命令
                sess = conn.openSession();//回话再次开启
                //执行killCmd命令
                SshShellExecBody killSshShell = new SshShellExecBody();
                //判断会话是否成功
                //int killStatus = sess.getExitStatus();//如果成功返回0
                //获取控制台信息
                String killResult = SshShellBasicTools.printCmd(conn, sess, killCmd);
                activeSshShell.setShellName("stopCmd");
                activeSshShell.setShellCmd(killCmd);
                //activeSshShell.setResStatus(killStatus);
                activeSshShell.setResResult(killResult.trim().equals("") ? serverType.concat(" server is aleady stoped!") : "error!");
                shellExecList.add(killSshShell);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            sess.close();
            conn.close();
        }
        return shellExecList;
    }
        //执行server批量脚本启动服务器,serverType为scan、probe30、probe31、probe33、probe34、master几种
   public static List<SshShellExecBody>  queryBathStartServerShell(String serverType){
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        PropertiesUtils.init();
        String host=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_host");
        int port=Integer.valueOf(PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_port"));
        String username=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_username");
        String password=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_password");
        String startCmd=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_start_cmd");
        String activeCmd=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_active_cmd");
        System.out.println("host:"+host+"/port:"+port+"/username:"+username+"/password:"+password+"/startCmd:"+startCmd+"/activeCmd:"+activeCmd);
        //连接并登陆
        Connection conn =SshShellBasicTools.login(host,port,username,password);
        //获取Session
        Session sess =null
            try{
           //获取Session
            sess = conn.openSession();
           //这句非常重要，开启远程的客户端
           //sess.requestPTY("vt100", 80, 24, 640, 480, null);
           //执行startCmd命令
           SshShellExecBody startSshShell=new SshShellExecBody();
           //判断会话是否成功
           // int startStatus = sess.getExitStatus();//如果成功返回0
           //获取控制台信息
           String startResult= SshShellBasicTools.printCmd(conn,sess,activeCmd);
           startSshShell.setShellName("startCmd");
           startSshShell.setShellCmd(startCmd);
           //startSshShell.setResStatus(startStatus);
           startSshShell.setResResult(startResult);
           shellExecList.add(startSshShell);

           //执行activeCmd命令
           SshShellExecBody activeSshShell=new SshShellExecBody();
           //判断会话是否成功
           //int activeStatus = sess.getExitStatus();//如果成功返回0
           //获取控制台信息
           String activeResult= SshShellBasicTools.printCmd(conn,sess,activeCmd);
           activeSshShell.setShellName("activeCmd");
           activeSshShell.setShellCmd(activeCmd);
           //activeSshShell.setResStatus(activeStatus);
           activeSshShell.setResResult(activeResult);
           shellExecList.add(activeSshShell);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
           sess.close();
           conn.close();
        }
        return shellExecList;
    }*/

    //执行server批量脚本启动服务器,serverType为scan、probe30、probe31、probe33、probe34、master几种
    public static  SshShellExecBody  judgeServerActiveAlive(String serverType) {
        PropertiesUtils.init();
        String host = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_host");
        int port = Integer.valueOf(PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_port"));
        String username = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_username");
        String password = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_password");
        String activeCmd = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_active_cmd");
        System.out.println("host:" + host + "/port:" + port + "/username:" + username + "/password:" + password + "/activeCmd:" + activeCmd);
        String showServer = serverType.equals("master") ? "server" : serverType;
        //连接并登陆
        Session session = JschSshShellHelper.getSession(host, username, password, port);
        System.out.println("SessionStatus:" + session.isConnected());
        SshShellExecBody shellExecBody = new SshShellExecBody();
        //获取控制台信息
        Date activeShellExecTime = new Date(System.currentTimeMillis()); //当前命令时间
        shellExecBody.setShellName("activeCmd");
        shellExecBody.setShellCmd("exec " + activeCmd);
        shellExecBody.setShellExecTime(activeShellExecTime);
        if (session != null) {
        //判断会话是否成功
            //int activeStatus = sess.getExitStatus();//如果成功返回0
            String[] activeRes = JschSshShellHelper.getExecCmdRes(session, activeCmd);
            String activeResult = activeRes[1];
            String resStatus = activeRes[0];
            shellExecBody.setResResult(activeResult);
            shellExecBody.setResStatus(Integer.valueOf(resStatus));

            String resConclusion = showServer;
            if (activeResult.trim().equals("")) {
                resConclusion = resConclusion.concat(" 已经处于停止状态！");
            } else {
                resConclusion = resConclusion.concat(" 正在运行中！");
            }
            shellExecBody.setResConclusion(resConclusion);
            session.disconnect();
        }else{
            String resConclusion =showServer.concat(" 主机远程检测不能被连接，请核对主机网络、端口通达性及账号、密码认证可行性！");
            shellExecBody.setResConclusion(resConclusion);
            shellExecBody.setResResultLevel("error");
        }
        return shellExecBody;
    }

    //执行server批量脚本停止服务器,serverType为scan、probe30、probe31、probe33、probe34、master几种
    public static SshBatchShellExecResBody queryBathStopServerShell(String serverType) {
        SshBatchShellExecResBody  batchShellExecResBody=new SshBatchShellExecResBody();
        Boolean  batchExecResultFlag=false;
        List<SshShellExecBody> shellExecList = new ArrayList<SshShellExecBody>();
        PropertiesUtils.init();
        String host = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_host");
        int port = Integer.valueOf(PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_port"));
        String username = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_username");
        String password = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_password");
        String activeCmd = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_active_cmd");
        String killCmd = PropertiesUtils.getProperty("dcs_" + serverType + "_server_ssh_kill_cmd");
        System.out.println("host:" + host + "/port:" + port + "/username:" + username + "/password:" + password + "/activeCmd:" + activeCmd + "/killCmd:" + killCmd);
        //连接并登陆
        Session session=JschSshShellHelper.getSession(host,username,password,port);
        System.out.println("SessionStatus:"+session.isConnected());

        //执行activeCmd命令
        Date  activeShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
        String[] activeCmdRes=JschSshShellHelper.getExecCmdRes(session,activeCmd);
        SshShellExecBody activeSshShell = new SshShellExecBody();
        //获取控制台信息
        String activeResult =activeCmdRes[1];
        activeSshShell.setShellName("activeCmd");
        activeSshShell.setShellCmd("exec "+activeCmd);
        activeSshShell.setShellUses("停止Server");//stopServer
        String showServer=serverType.equals("master")?"server":serverType;
        activeSshShell.setShellSubUses("停止前校验".concat("("+showServer+")"));//beforeStopValidateServer
        activeSshShell.setShellExecTime(activeShellExecTime);
        //activeSshShell.setResStatus(activeStatus);
        activeSshShell.setResResult(activeResult);
        activeSshShell.setResConclusion(activeResult.trim().equals("") ? showServer.concat(" 已处于停止状态！"):"");
        activeSshShell.setResResultLevel("common");
        shellExecList.add(activeSshShell);
       if(activeResult.trim().equals("")){
           batchExecResultFlag=true;
       }
        //activeStatus==0 &&
        if (activeResult.trim().length() > 0) { //当前正活跃，可进行下一项
            //执行killCmd命令
            Date  killShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
            String[] killCmdRes = JschSshShellHelper.getExecCmdRes(session, killCmd);
            SshShellExecBody killSshShell = new SshShellExecBody();
            //判断会话是否成功
            //int killStatus = sess.getExitStatus();//如果成功返回0
            //获取控制台信息
            String killResult =killCmdRes[1];
            killSshShell.setShellName("stopCmd");
            killSshShell.setShellCmd("exec "+killCmd);
            killSshShell.setShellUses("停止Server"); //stopServer
            killSshShell.setShellSubUses("杀死进程停止".concat("("+showServer+")"));//killStopServer
            killSshShell.setShellExecTime(killShellExecTime);
            //activeSshShell.setResStatus(killStatus);
            killSshShell.setResResult(killResult.trim().equals("") ? showServer.concat(" 已经被杀死进程停止！") : serverType.concat(" 不存在,您无需进行停止!"));
            killSshShell.setResConclusion("");
            killSshShell.setResResultLevel(killResult.trim().equals("") ? "success":"warn");
            shellExecList.add(killSshShell);

            try {
                Thread.currentThread().sleep(threadWaitSleep); //休息两秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Date  validateShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
            String[] validateCmdRes=JschSshShellHelper.getExecCmdRes(session,activeCmd);
            SshShellExecBody validateSshShell = new SshShellExecBody();
            //获取控制台信息
            String validateResult =validateCmdRes[1];
            validateSshShell.setShellName("validateCmd");
            validateSshShell.setShellCmd("exec "+activeCmd);
            validateSshShell.setShellUses("停止Server");//stopServer
            validateSshShell.setShellSubUses("停止后校验".concat("("+showServer+")"));//afterStopValidateServer
            validateSshShell.setShellExecTime(validateShellExecTime);
            //activeSshShell.setResStatus(activeStatus);
            validateSshShell.setResResult(validateResult);
            validateSshShell.setResConclusion(validateResult.trim().equals("") ? showServer.concat(" 不存在！"):validateResult.trim());
            validateSshShell.setResResultLevel(validateResult.trim().equals("") ?"success":"error");
            shellExecList.add(validateSshShell);
            if(validateResult.trim().equals("")){
                batchExecResultFlag=true;
            }
        }
        session.disconnect();
        batchShellExecResBody.setShellExecList(shellExecList);
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        return batchShellExecResBody;
    }


    //执行server批量脚本启动服务器,serverType为scan、probe30、probe31、probe33、probe34、master几种
    public static SshBatchShellExecResBody  queryBathStartServerShell(String serverType){
        SshBatchShellExecResBody  batchShellExecResBody=new SshBatchShellExecResBody();
        Boolean  batchExecResultFlag=false;
        List<SshShellExecBody> shellExecList=new ArrayList<SshShellExecBody>();
        PropertiesUtils.init();
        String host=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_host");
        int port=Integer.valueOf(PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_port"));
        String username=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_username");
        String password=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_password");
        String startCmd=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_start_cmd");
        String activeCmd=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_active_cmd");
        System.out.println("host:"+host+"/port:"+port+"/username:"+username+"/password:"+password+"/startCmd:"+startCmd+"/activeCmd:"+activeCmd);
        //连接并登陆
        Session session=JschSshShellHelper.getSession(host,username,password,port);
        System.out.println("SessionStatus:"+session.isConnected());
        //执行启动前判断是否已运行状态
        Date  validateShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
        String[] validateCmdRes=JschSshShellHelper.getExecCmdRes(session,activeCmd);
        SshShellExecBody validateSshShell = new SshShellExecBody();
        //获取控制台信息
        String validateResult =validateCmdRes[1];
        validateSshShell.setShellName("validateCmd");
        validateSshShell.setShellCmd("exec "+activeCmd);
        validateSshShell.setShellUses("启动Server");//startServer
        String showServer=serverType.equals("master")?"server":serverType;
        validateSshShell.setShellSubUses("启动前校验".concat("("+showServer+")"));//beforeStartValidateServer
        validateSshShell.setShellExecTime(validateShellExecTime);
        //activeSshShell.setResStatus(activeStatus);
        validateSshShell.setResResult(validateResult);
        validateSshShell.setResConclusion(validateResult.trim().equals("") ? showServer.concat(" 不存在！"):serverType.concat(" 正在运行中，您无需进行启动！"));
        validateSshShell.setResResultLevel("common");
        shellExecList.add(validateSshShell);
       if(!validateResult.trim().equals("")){
           batchExecResultFlag=true;
       }
        if(validateResult.trim().equals("") ){     //server不存在，进行启动操作
            //执行startCmd命令
            Date  startShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
            String[] startCmdRes=JschSshShellHelper.getExecCmdRes(session,startCmd);
            //执行startCmd命令
            SshShellExecBody startSshShell=new SshShellExecBody();
            //判断会话是否成功
            //int startStatus = sess.getExitStatus();//如果成功返回0
            //获取控制台信息
            String startResult=startCmdRes[1];
            startSshShell.setShellName("startCmd");
            startSshShell.setShellCmd("exec "+ startCmd);
            //startSshShell.setResStatus(startStatus);
            startSshShell.setShellUses("启动Server");//startServer
            startSshShell.setShellSubUses("shell脚本启动".concat("("+showServer+")"));//shStartupServer
            startSshShell.setShellExecTime(startShellExecTime);
            startSshShell.setResResult(startResult);
            try {
                Thread.currentThread().sleep(threadWaitSleep); //休息两秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //执行activeCmd命令
            SshShellExecBody activeSshShell=new SshShellExecBody();
            //判断会话是否成功
            //int activeStatus = sess.getExitStatus();//如果成功返回0
            //获取控制台信息
            Date  activeShellExecTime=new Date(System.currentTimeMillis()); //当前命令时间
            String[] activeRes=JschSshShellHelper.getExecCmdRes(session,activeCmd);
            String activeResult=activeRes[1];
            activeSshShell.setShellName("activeCmd");
            activeSshShell.setShellCmd("exec "+activeCmd);
            activeSshShell.setShellUses("启动Server");//startServer
            activeSshShell.setShellSubUses("启动后校验".concat("("+showServer+")"));//validateStartServer
            activeSshShell.setShellExecTime(activeShellExecTime);
            activeSshShell.setResConclusion("");
            //activeSshShell.setResStatus(activeStatus);
            activeSshShell.setResResult(activeResult);
            if(!activeResult.trim().equals("")){
                activeSshShell.setResResultLevel("success");
                startSshShell.setResConclusion(showServer.concat(" 启动成功！"));
                startSshShell.setResResultLevel("success");
                batchExecResultFlag=true;

            }else{
                activeSshShell.setResConclusion(showServer.concat(" 不存在！"));
                activeSshShell.setResResultLevel("warn");
                startSshShell.setResConclusion(showServer.concat(" 启动失败！"));
                startSshShell.setResResultLevel("error");
            }
            shellExecList.add(startSshShell);
            shellExecList.add(activeSshShell);
        }
        session.disconnect();
        batchShellExecResBody.setShellExecList(shellExecList);
        batchShellExecResBody.setBatchExecResultFlag(batchExecResultFlag);
        return batchShellExecResBody;
    }


    //判断远程Server主机活跃性可行性
    public static  boolean  checkRemoteServerActiveAlive(String serverType){
        String host=PropertiesUtils.getProperty("dcs_"+serverType+"_server_ssh_host");
        boolean flag=JschSshShellHelper.checkRemoteHostActive(host);
        return flag;
    }


    public static void main(String[] args){
         List<SshShellExecBody> restartShellExecList=new ArrayList<SshShellExecBody>();
         //List<SshShellExecBody> stopShellExecList=queryBathStopServerShell("scan");
         List<SshShellExecBody> startShellExecList=queryBathStartServerShell("scan").shellExecList;
         //restartShellExecList.addAll(stopShellExecList);
         restartShellExecList.addAll(startShellExecList);
         for(int i=0;i<restartShellExecList.size();i++){
             SshShellExecBody shell=restartShellExecList.get(i);
             System.out.println("excute:"+shell.getShellCmd());
             System.out.println("result:"+shell.getResResult());
         }
     }

}
