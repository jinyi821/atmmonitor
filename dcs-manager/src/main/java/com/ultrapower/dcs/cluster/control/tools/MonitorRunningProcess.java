package com.ultrapower.dcs.cluster.control.tools;

import com.ultrapower.dcs.cluster.control.utils.*;

import static com.ultrapower.dcs.cluster.control.tools.SshShellBasicTools.queryServerShell;

/**
 * @author fanjianfeng
 * @title 监控运行进程
 * @desc
 * @Created by   2018-06-06 14:28
 */
public class MonitorRunningProcess {

    /* *
  * @Title 检查监控dcs_scan进程服务活跃性
  * @Description  
  * @Param     []
  * @Return   boolean
  * @throws      
  * @author   fanjianfeng
  * @Date   2018/6/7  10:34
  **/
  public static boolean  checkDcsScanProcessServerActive(){
      boolean  flag=false;
      PropertiesUtils.init();
      String host=PropertiesUtils.getProperty("dcs_scanner_server_ssh_host");  // "192.168.131.135";
      Integer port=Integer.valueOf(PropertiesUtils.getProperty("dcs_scanner_server_ssh_port"));  //22;
      String  username=PropertiesUtils.getProperty("dcs_scanner_server_ssh_username");   //"root";
      String  password=PropertiesUtils.getProperty("dcs_scanner_server_ssh_password");   //"cloudera";
      String cmd =PropertiesUtils.getProperty("dcs_scanner_server_ssh_active_cmd");   //"ps -ef|grep DcsRmiTest";  //"ps -ef|grep DcsRmiTest";
      System.out.println("host:"+host+"//port:"+port+"//username:"+username+"//password:"+password+"//cmd:"+cmd);
     try{
         String[]  resArray=queryServerShell(host,port,username,password,cmd);
         Integer  resStatus=Integer.valueOf(resArray[0]);
         String[] reCmdArray=resArray[1].split(Constants.LINESEPARATOR);
         if(resStatus==0&&reCmdArray.length>0){
             flag=true;
             System.out.println("resStatus:"+resStatus);
             System.out.println("reCmdArray:"+resArray[1]);
         }
     }catch(Exception e){
       //e.printStackTrace();
         flag=false;
     }
    return flag;
  }



public static  void main(String[] args){
   /*
   监控运行进程，限本地单机使用
   try {
        InputStream in = Runtime.getRuntime().exec("jps").getInputStream();
        BufferedReader b = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = b.readLine()) != null) {
            System.out.println("line:" + line);
        }
    }catch(Exception e) {
      e.printStackTrace();
    }*/

    boolean  checkDcsScanProcessServerActiveFlag=checkDcsScanProcessServerActive();
    System.out.println("checkDcsScanProcessServerActiveFlag:"+checkDcsScanProcessServerActiveFlag);
}
}
