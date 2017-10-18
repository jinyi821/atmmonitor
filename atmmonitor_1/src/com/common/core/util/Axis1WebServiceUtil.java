package com.common.core.util;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Axis1WebServiceUtil {
	/**
	 * axis1.4调用客户端,并返回结果
	 * @param url
	 * @param methodName
	 * @param paramValues
	 * @return
	 */
	public static String executeWithResult(String url,String methodName, Object[] paramValues) {		 
		    String endPoint =url;
		    String operation =methodName;//要执行的方法
		    Service service = new Service();
		    String result = "";		
		    Call call;
			try {
				call = (Call) service.createCall();
				call.setTargetEndpointAddress(new java.net.URL(endPoint));
				 // 超时时间设置
		        call.setProperty(Call.CONNECTION_TIMEOUT_PROPERTY, new Integer(60 * 60000));
		        call.setTimeout(new Integer(60 * 60000));

			    call.setOperationName(operation);
			    //执行方法并带上参数
			    result = (String) call.invoke(paramValues);
			    System.out.println(result);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return result;
	}
	
}
