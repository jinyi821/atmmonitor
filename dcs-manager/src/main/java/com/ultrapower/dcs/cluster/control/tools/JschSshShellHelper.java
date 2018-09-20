package com.ultrapower.dcs.cluster.control.tools;

import static java.lang.String.format;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
//import com.nsm.hermes.wand.Wand;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.JschSshShellUtils
 * @Title JschSshShell基本工具
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-28 17:11
 */
public class JschSshShellHelper {
    //private static Properties config = [StrictHostKeyChecking: 'no'] ;//jsch配置文件
    public static int sessionTimeout = 20000; //回话连接超时时间20秒
    public static int threadWaitSleep = 500; //进程等待睡眠时间，0.5秒

    public static int checkTimeout=3000; //检查超时3钞
    /**
     * 创建session
     * @param host 主机名称/ip地址
     * @param user 登陆用户名
     * @param psw  密码
     * @param port 端口
     * @return
     */
    public static Session getSession(String host, String user, String psw, int port) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(user, host, port);
            if (null != session) {
                session.setTimeout(sessionTimeout);
                java.util.Properties config = new java.util.Properties();
                //session.timeout = timeout
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);
                session.setPassword(psw);
                session.connect();
                System.out.println("SessionStatus:"+session.isConnected());
            }

        } catch (JSchException e) {
            //e.printStackTrace();
            System.err.println("com.jcraft.jsch.JSchException: timeout: socket is not established");
            session.disconnect();
            session = null;
        }
        return session;
    }

    /**
     * 得到可以执行命令的连接
     *
     * @param session 连接session
     * @return 可以执行命令的ChannelExec
     */
    public static ChannelExec getChanel(Session session) {
        ChannelExec openChannel = null;
        try {
            if (null != session) {
                openChannel = (ChannelExec) session.openChannel("exec");
                System.out.println("openChannelStatus:"+openChannel.getExitStatus());
            }
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return openChannel;
    }

    public static void disConnect(Session session, ChannelExec openChannel) {
        if (session != null && !openChannel.isClosed()) {
            openChannel.disconnect();
        }
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }

    public static String[] getExecCmdRes(Session session, String cmd) {
        String[] resArray = new String[2];
        ChannelExec channelExec = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(cmd);
            int exitStatus = channelExec.getExitStatus();

            System.out.println("exitStatus:" + exitStatus);
            resArray[0] = String.valueOf(exitStatus);

            //channelExec.setInputStream(null);
            //channelExec.setErrStream(System.err);
            in = channelExec.getInputStream();
            channelExec.connect();
            reader = new BufferedReader(new InputStreamReader(in));
            //有坑，最后不换行符号，不结束阻塞中
            //long start = System.currentTimeMillis();
            //long end = start;
            String lineText = reader.readLine();
            while (lineText != null) { //(end - start) < 5000 &&
                System.out.println("lineText:" + lineText);
                result.append(lineText + "\r\n");
                //result.append(new String(buf.getBytes("gbk"),"UTF-8")+"<br>\r\n");
                lineText = reader.readLine(); //下一行
                //System.out.println("nextLineText:"+lineText);
                //end = System.currentTimeMillis();
            }
            //有坑，最后不换行符号，不结束阻塞中
            /*byte[] buf = new byte[1024];
            int len = 0;
            while ((len=in.read(buf)) != -1) {
                String tmp=new String(buf, 0, len,"UTF-8");
                System.out.println("tmp:"+tmp);
                result.append(tmp);
                if(tmp.trim().equals("")){
                    break;
                }
            }*/
            resArray[1] = result.toString();
           /*try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
           }*/
        } catch (IOException e) {
            result.append(e.getMessage());
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
                channelExec.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resArray;
    }

    /**
     * 读取回显
     *
     * @throws IOException
     */
    /*public void execCommand() throws IOException {
        service.submit(new Runnable() {
            // BufferedReader stdout1 = new BufferedReader(new InputStreamReader(new
            @Override
            public void run() {
                String line;
                try {
                    while ((line = dis.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }*/

    //检查远程主机活跃性
    public static Boolean checkRemoteHostActive(String hostIp) {

        boolean   status = false;
        try {
            status = InetAddress.getByName(hostIp).isReachable(checkTimeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
}




    public static void main(String[] args) {
        Session session=getSession("192.168.131.135", "root", "cloudera", 22);
        /* ChannelExec chanel2=getChanel(session);
        String ss=getExcRes(chanel2, "ls;");*/
        //System.out.println(ss);
        String[] res1=getExecCmdRes(session, "sh /opt/examples/dcs-scan-rmi-test-start.sh");
        System.out.println(res1[1]);
        /*String[] res2=getExecCmdRes(session, "ps -ef | grep dcs-probe-rmi-test");
        System.out.println(res2);*/
    }

}