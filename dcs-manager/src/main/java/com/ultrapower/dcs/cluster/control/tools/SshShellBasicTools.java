package com.ultrapower.dcs.cluster.control.tools;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.ultrapower.dcs.cluster.control.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;

/**
 * sshshell脚本调用类
 * Created by Administrator on 2018/6/5.
 */
public class SshShellBasicTools {
    private static Integer time_out=10000; //10秒

    //连接，登陆
     public static  Connection login(String hostname,int port,String username,String password){
     //获取连接
       Connection conn =null;
        try {
           //连接
            conn=new Connection(hostname, port);
            if(null!=conn){
                conn.connect(null,time_out,time_out); //connect(ServerHostKeyVerifier verifier, int connectTimeout, int kexTimeout)
                //输入账号密码登陆
                boolean isAuthenticated = conn.authenticateWithPassword(username, password);
                //登陆失败，返回错误
                if(isAuthenticated == false){
                    throw new IOException("isAuthentication failed.");
                }
            }
         }catch (IOException e) {
            //e.printStackTrace();
            System.err.println("java.net.ConnectException: Connection timed out: connect!");
            conn.close();
            conn = null;
        }
            return conn;
     }

    //获取Session
    public static Session getSession(Connection conn){
          Session sess = null;
            try {
               if(conn!=null){
                   sess = conn.openSession();
               }
             } catch (IOException e) {
              //e.printStackTrace();
                System.err.println("java.net.SessionException: Invalid Session!");
                sess.close();
                sess = null;

               }
            return sess;
    }

    //获取控制台打印信息
    public static String printCmd(Connection conn,Session sess, String cmd) {
        String txt = "";
        try {
            if(sess!=null){
                // 开启后睡眠2秒
                Thread.sleep(2000);
                sess.execCommand(cmd);
                //打印控制台信息
                InputStream stdout = new StreamGobbler(sess.getStdout());
                //打印控制台错误
                InputStream stderr = new StreamGobbler(sess.getStderr());
                BufferedReader brout = new BufferedReader(new InputStreamReader(stdout,"UTF-8"));
                BufferedReader brerr = new BufferedReader(new InputStreamReader(stderr,"UTF-8"));
                while(true){
                    String line = brout.readLine();
                    if(line==null){
                        break;
                    }
                    txt += line+ Constants.LINESEPARATOR;
                    //System.out.println(line);
                }
                while(true){
                    String line = brerr.readLine();
                    if(line==null){
                        break;
                    }
                    txt += line+Constants.LINESEPARATOR;
                    //System.out.println(line);
                }
            }
            } catch (IOException e) {
             e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return txt;
     }


    public static String[] queryServerShell(String host,int port,String username,String password, String cmd){
        String[]  resArray=new  String[2];
         //连接并登陆
        Connection conn = login(host,port,username,password);
         //获取Session
        Session sess = getSession(conn);
        //获取控制台信息
        String reCmd=printCmd(conn,sess,cmd);
        //System.out.println("recmd:"+reCmd);
        //System.out.println("--->"+sess);
        //判断会话是否成功
        int result = sess.getExitStatus();//如果成功返回0
        //System.out.println("result:"+result);
        sess.close();
        conn.close();
        resArray[0]=String.valueOf(result);
        resArray[1]=reCmd;
        return resArray;
    }

    //
     public static void main(String[] args){
         String host="192.168.131.135";
         Integer port=22;
         String  username="root";
         String  password="cloudera";
         String cmd ="ifconfig"; //"ps -ef|grep DcsRmiTest";
         String[]  resArray=queryServerShell(host,port,username,password,cmd);
         Integer  resStatus=Integer.valueOf(resArray[0]);
         if(resStatus==0){
         System.out.println("resStatus:"+resStatus);
         String[] reCmdArray=resArray[1].split(Constants.LINESEPARATOR);
          for(int i=0;i<reCmdArray.length;i++){
              System.out.println(reCmdArray[i]);
          }
         }

    }

}
