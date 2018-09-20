package com.ultrapower.dcs.cluster.control.tools;

import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author fanjianfeng
 * @title RMI接口服务客户端调用工具
 * @desc
 * @Created by   2018-06-06 14:28
 */
public class RmiTestClientTools {
   /* *
    * @Title   检查IRmiTestRMI接口服务活跃性
    * @Description  
    * @Param     []
    * @Return   boolean
    * @throws      
    * @author   fanjianfeng
    * @Date   2018/6/7  9:49
    **/
   public static  boolean checkIRmiTestServerActive(){
       boolean flag=false;
       IRmiTest iRremote =null;
       try {
           //PropertiesUtils.init();
           String rmiClientUrl = PropertiesUtils.getProperty("dcs_master_server_client_rmiurl");
           //System.setProperty("java.rmi.server.hostname", "192.168.131.135");
           //LocateRegistry.getRegistry(1099);
           System.out.println("rmiClientUrl:"+rmiClientUrl);
           iRremote = (IRmiTest) Naming.lookup(rmiClientUrl);
           String checkServerActiveRes=iRremote.SayHello();
           System.out.println("checkServerActiveRes:"+checkServerActiveRes);
           if(checkServerActiveRes!=null){
               flag=true;
            System.out.println("checkServerActiveRes:"+iRremote.SayHello());
           }

       } catch (MalformedURLException e) {
           //e.printStackTrace();
       } catch (RemoteException e) {
           //e.printStackTrace();
       } catch (NotBoundException e) {
          //e.printStackTrace();
       }
       return flag;
     }

    public static void main(String[] args){
  /*      IRmiTest iRremote =null;
        try {
            iRremote = (IRmiTest) Naming.lookup("//192.168.3.2:9999/IRmiTest");
            System.out.println(iRremote.SayHello());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }*/
       boolean  checkIRmiTestServerActiveFlag=checkIRmiTestServerActive();
       System.out.println("checkIRmiTestServerActiveFlag:"+checkIRmiTestServerActiveFlag);
    }
}
