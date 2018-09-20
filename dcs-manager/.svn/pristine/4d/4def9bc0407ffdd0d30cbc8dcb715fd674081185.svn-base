package com.ultrapower.rmi;

import com.ultrapower.bean.FtpServerBean;
import com.ultrapower.dcs.cluster.control.tools.IRmiTest;
import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @ClassName com.ultrapower.rmi.RmiServerInterfaceClient
 * @Title dcs_server rmi辅助调用接口客户端调用操作方法
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-07 9:42
 */
public class RmiServerInterfaceClient {

/* *
 * @Title  检查dcs_server服务活跃性
 * @Description  
 * @Param     []
 * @Return   boolean
 * @throws      
 * @author   fanjianfeng
 * @Date   2018/6/7  10:14
 **/
public static boolean  checkDcsServerActive(){
    boolean  flag=false;
    ServerInterface iRremote =null;
    try {
        //PropertiesUtils.init();
        String rmiClientUrl = PropertiesUtils.getProperty("dcs_server_client_rmiurl");
        System.out.println("rmiClientUrl:"+rmiClientUrl);
       iRremote = (ServerInterface) Naming.lookup(rmiClientUrl);
       List<FtpServerBean> checkServerActiveRes=iRremote.getServerList();
       if(checkServerActiveRes!=null){
           flag=true;
           System.out.println("checkDcsServerActiveRes:"+iRremote.getServerList());
       }
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (NotBoundException e) {
        e.printStackTrace();
    }
    return flag;
}

public static  void main(String [] args){
   /* ServerInterface iRremote =null;
    try {
        iRremote = (ServerInterface) Naming.lookup("//192.168.3.2:9999/IRmiTest");
        System.out.println(iRremote.getServerList());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (NotBoundException e) {
        e.printStackTrace();
    }*/
    boolean checkDcsServerActiveFlag=checkDcsServerActive();
    System.out.println("checkDcsServerActiveFlag:"+checkDcsServerActiveFlag);
}

}
