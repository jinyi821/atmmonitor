package com.ultrapower.dcs.cluster.control.tools;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.IRmiTest
 * @Title RMI接口服务客户端调用辅助类，必须与RMI接口服务端接口包名、类名、方法名完全一致，否则无法转化成功。
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-06 15:45
 */

public interface IRmiTest extends Remote{
     /* *
     * @Title   远程调用dcs-rmi-test中的SayHello方法
     * @Description  
     * @Param     []
     * @Return   java.lang.String
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/6/6  16:44
     **/
    public String SayHello() throws RemoteException;

}
