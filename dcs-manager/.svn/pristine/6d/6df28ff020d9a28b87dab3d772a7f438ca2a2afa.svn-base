package com.ultrapower.dcs.cluster.control.tools;

import com.jcraft.jsch.Session;
import com.ultrapower.dcs.cluster.control.utils.Constants;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;

import java.util.Date;

import static com.ultrapower.dcs.cluster.control.tools.SshShellBasicTools.queryServerShell;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.MonitorSysTimeProcess
 * @Title 监控dcs部署机器系统日期时间处理
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-08 10:56
 */
public class MonitorSysTimeProcess {

    public static String  getDcsProbeServerSysTime(){
        String resDateTime=null;
        //PropertiesUtils.init();
        String cmd=PropertiesUtils.getProperty("dcs_master_server_ssh_datetime_cmd");
        String user=PropertiesUtils.getProperty("dcs_master_server_ssh_username");
        String host=PropertiesUtils.getProperty("dcs_master_server_ssh_host");
        String password=PropertiesUtils.getProperty("dcs_master_server_ssh_password");
        Integer port=Integer.valueOf(PropertiesUtils.getProperty("dcs_master_server_ssh_port"));
        System.out.println("cmd:"+cmd+"//user:"+user+"//host:"+host+"//password:"+password+"//port:"+port);
        try{
            //String[]  resArray=queryServerShell(host,port,user,password,cmd);
            //连接并登陆
            Session session = JschSshShellHelper.getSession(host, user, password, port);
            if(null!=session){
                //获取控制台信息
                String[] resArray = JschSshShellHelper.getExecCmdRes(session, cmd);
                Integer resStatus = Integer.valueOf(resArray[0]);
                resDateTime = resArray[1].replace(Constants.LINESEPARATOR, "");
                session.disconnect();
                System.out.println("resStatus:" + resStatus + "//resDateTime:" + resDateTime);
            }
        }catch(Exception e){
            //e.printStackTrace();
            resDateTime=null;
        }
        return  resDateTime;
    }

    public static void main(String[] args){
        getDcsProbeServerSysTime();
    }
}
