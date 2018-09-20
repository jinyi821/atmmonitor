package com.ultrapower.dcs.cluster.control.tools;

import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;

import java.io.IOException;
import java.io.InputStream;

import static com.ultrapower.dcs.cluster.control.tools.MonitorRunningProcess.checkDcsScanProcessServerActive;
import static com.ultrapower.dcs.cluster.control.tools.SshShellBasicTools.queryServerShell;

/**
 * @author fanjianfeng
 * @title 监控DB数据库运行服务
 * @desc
 * @Created by   2018-06-06 14:28
 */
public class MonitorDbProcess {

/* *
 * @Title 检查DB数据库进程服务活跃性
 * @Description  
 * @Param     []
 * @Return   boolean
 * @throws      
 * @author   fanjianfeng
 * @Date   2018/6/7  15:15
 **/    
public  static boolean checkDbProcessServiceActive(){
 boolean flag=false;
 //PropertiesUtils.init();
  String cmd=PropertiesUtils.getProperty("dcs_db_server_cmd_param");
  String user=PropertiesUtils.getProperty("dcs_db_server_useer_param");
  String host=PropertiesUtils.getProperty("dcs_db_server_host_param");
  String password=PropertiesUtils.getProperty("dcs_db_server_password_param");
  String port=PropertiesUtils.getProperty("dcs_db_server_port_param");
  String ping=PropertiesUtils.getProperty("dcs_db_server_ping_param");
  System.out.println("cmd:"+cmd+"//user:"+user+"//host:"+host+"//password:"+password+"//port:"+port+"//ping:"+ping);
  Process p = null;
 try{
  //访问运程服务器上的mysql
  p = new ProcessBuilder(cmd,user,host,password,port,ping).start();
  //访问本地的mysql
  //p = new ProcessBuilder(cmd,user,password,ping).start();
  byte[] b = new byte[1024];
  int readbytes = -1;
  StringBuffer sb = new StringBuffer();
  //读取进程输出值
  //在JAVA IO中,输入输出是针对JVM而言,读写是针对外部数据源而言
  InputStream in = p.getInputStream();
   try{
   while((readbytes = in.read(b)) != -1){
    sb.append(new String(b,0,readbytes));
   }
    String checkDbProcessServiceActiveRes=sb.toString();
    System.out.println("checkDbProcessServiceActiveRes:"+checkDbProcessServiceActiveRes);
    if(checkDbProcessServiceActiveRes.contains("mysqld is alive")){
    flag=true;
    }
  }catch(IOException e1){
   return flag;
  }finally {
   try{
    in.close();
   }catch (IOException e2){
    return flag;
   }
  }
  return flag;
 }catch (IOException e){
  return flag;
 }
}



public static  void main(String[] args){

    boolean  checkDbProcessServiceActiveFlag=checkDbProcessServiceActive();
    System.out.println("checkDbProcessServiceActiveFlag:"+checkDbProcessServiceActiveFlag);

}
}
