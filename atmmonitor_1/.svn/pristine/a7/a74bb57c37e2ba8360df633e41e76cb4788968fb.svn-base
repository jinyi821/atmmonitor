package com.common.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.common.constants.PropertiesUtils;


public class FTPUtils {
	
	public static String username = PropertiesUtils.getProperty("ftp.username");
	public static String password = PropertiesUtils.getProperty("ftp.password");
	public static String url = PropertiesUtils.getProperty("ftp.url");
	public static String localPath = System.getProperty("java.io.tmpdir");
	public static int port = new Integer(PropertiesUtils.getProperty("ftp.port"));
	public static String remotePath = PropertiesUtils.getProperty("ftp.remotePath");
	public static String fileName = PropertiesUtils.getProperty("ftp.fileName");
	
	private static Log logger = LogFactory.getLog(FTPUtils.class);

	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static boolean downFile(String url, int port, String username,
			String password, String remotePath, String fileName,
			String localPath) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());

					OutputStream is = new FileOutputStream(localFile);
					ftp.retrieveFile(ff.getName(), is);
					is.close();
					success = true;
				}
			}

			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	
	/**
	 * Description: 从FTP服务器读取文件总计
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径

	 * @return
	 */
	public static Map<String,Object> getFtpFile(String url, int port, String username,
			String password, FtpProcessor ftpProcessor) {
		
		logger.info("getFtpFile url="+url);
		logger.info("getFtpFile port="+port);
		logger.info("getFtpFile username="+username);
		logger.info("getFtpFile password="+password);
		
		Map<String,Object> map=new HashMap<String,Object>();
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			logger.info("url="+url+"登录");
			map=ftpProcessor.process(ftp);
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					logger.info("url="+url+"完成操作退出");
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return map;
	}
	
	public static Map<String,Object> getFtpFile(String url, int port, String username,
			String password, String remotePath,String regEx) {
		Map<String,Object> map=new HashMap<String,Object>();
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			int count=0;
			long size=0;
			for (FTPFile ff : fs) {
				System.out.println(ff.getName());
				if(ff.getType()==0 && isMatch(ff.getName(),regEx)){
					count++;
					size=size+ff.getSize();
				}
			}
			map.put("fileCount", count);
			map.put("fileSize", size);
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		
		return map;
	}
	public static Boolean  isMatch(String fileName, String regEx){
		
		  // 要验证的字符串
//	    String str = "service@xsoftlab.net";
//	    // 邮箱验证规则
//	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(fileName);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    return rs;
	}
	public static void main(String[] args){
		String username="ftpcup";
		String password="ultra@ftp123";
		String url="10.204.210.103";
		Integer port=21;
		String remotePath="/bs";
		Map<String, Object> ftpFile = getFtpFile(url, port, username, password, remotePath,"DR_GSM_[a-zA-Z0-9]{1,}_20160919_[a-zA-Z0-9]{1,}.dat");
		System.out.println(ftpFile);
//		
//		Boolean match = isMatch("DR_WLAN_L_20160919_0120160919161208678.dat", "DR_WLAN_L_20160919_[0-9]+.dat");
//		Boolean match1 = isMatch("DR_WLAN_L_20160919_0120160919161208678.dat", "DR_WLAN_L_20160919_\\d{1,}.dat");
		Boolean match2 = isMatch("DR_PS_Gn_HTTP_Event_20160919212156_853_74.txt", "DR_PS_Gn_HTTP_Event"+"[0-9]{0,}_"+20160919+"[a-zA-Z0-9_]{1,}.txt");
		String  regEx="DR_:type_[a-zA-Z0-9]{1,}_${reportdates}_[a-zA-Z0-9]{1,}.dat";
		String regEx1=regEx.replaceAll(":type", "11").replaceAll("$\\{reportdates\\}", "20100912");
		
//		System.out.println(match);
//		System.out.println(match1);
		System.out.println(match2);
		System.out.println(regEx1);
		
	}
}
