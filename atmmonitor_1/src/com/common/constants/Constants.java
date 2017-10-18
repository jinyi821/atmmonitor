﻿package com.common.constants;

public class Constants {

	public static String DATABASE_ALIAS = PropertiesUtils.getProperty("jdbc.alias");
	public static String SYS_REAL_PATH = "";// 系统实际物理路径
	public static String USERSESSION = "userSession"; // 用户登录session信息
	public static String REDIRECT_URL="redirectUrl"; //用户重定向目录
	   
	public final static String NEWLINE = System.getProperty("line.separator");//系统换行符号
    public static final String PROJECTCHINESENAME="数据共享平台";//项目中文名字    
    public static final String PROJECTURL="http://10.204.193.50:83/metadata";//项目正式url
	public static final String STATUS_RUNNING = "1"; //任务运行中
    public static final String STATUS_NOT_RUNNING = "0"; //任务停止    
    public static String EOMSSERVICEURL="http://10.204.14.51:8001/bpp/services/WorkflowEngine";  //emosWebService接口serviceUrl
    public static String EOMSTARGETNAMESPACE="http://10.204.14.51:8001/bpp/services/WorkflowEngine"; //emosWebService接口targetNamespace

    public static String EMOSINFORMATICASERVICEURL="http://10.204.14.37:58076/interface/services/EOMSDataQualitySheet";//emosWebService接口数据质量serviceUrl
    public static String EMOSINFORMATICATARGETNAMESPACE="http://server.eoms.com"; ////emosWebService接口数据质量targetNamespace
    
    public static String KYLINSERVICEURL="http://10.204.210.139:7200/";//kylin环境接口url
    
    public static String APPROVER_ROLE="3"; //审批角色
    public static String MAINTAINR_ROLR="2"; //修理ATM角色
    
	/**
	 * Tableau管理员帐号
	 * 
	 * @author zhangyu
	 */
	public static String TABLEAU_ADMINNAME = "admin";

	/**
	 * Tableau管理员密码
	 * 
	 * @author zhangyu
	 */
	public static String TABLEAU_ADMINPASSWORD = "admin";

	/**
	 * Tableau服务器地址
	 * 
	 * @author zhangyu
	 */
	public static String TABLEAU_SERVICE = "10.204.210.4";//10.204.210.130 10.204.193.199
	
	/**
	 * tableau工作薄预览图相对路径
	 * 
	 * @author liufeng
	 */
	public static String TABLEAU_WORKBOOKVIEWIMAGE_PATH = "/tableau/WorkbookViewImage";
	public static String OASYNCH_ADD="ADD"; 
	public static String OASYNCH_UPDATE="UPDATE"; 
	public static String OASYNCH_DEL="DEL"; 
}