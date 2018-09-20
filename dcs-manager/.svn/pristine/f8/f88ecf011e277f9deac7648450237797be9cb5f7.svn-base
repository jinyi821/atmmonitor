package com.ultrapower.dcs.cluster.control.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Created on 2016年9月26日
 * <p>
 * Title: [项目名称_一级模块名称_模块名称]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 北京神州泰岳
 * </p>
 * 
 * @author <a href=jinyi@ultrapower.com.cn>jinyi</a>
 * @version 1.0
 */
public class FTPUtils {

	private static Log logger = LogFactory.getLog(FTPUtils.class);

	public static List<Map<String, Object>> getFtpFileList(String url, int port, String username, String password,String remotePath,String regEx) {

		logger.debug("getFtpFile url=" + url + " port=" + port + " username=" + username + " password=" + password);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			logger.debug("url=" + url + "登录");
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			logger.info("remotePath=" + remotePath);
			logger.info("开始读取文件");

			ftp.listFiles(remotePath, new FTPFileFilter() {

				@Override
				public boolean accept(FTPFile ff) {
					// logger.info("遍历文件");
					// logger.info("文件名：=" + ff.getName());
					Map<String, Object> map = new HashMap<String, Object>();
					try {
						if (ff.getType() == 0 && FTPUtils.isMatch(ff.getName(), regEx)){
							map.put("fileName",ff.getName()) ;
							map.put("fileSize",ff.getSize());
							DateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
							String currentDate = f.format(ff.getTimestamp().getTime());
							map.put("timestamp",currentDate) ;
							list.add(map) ;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return false;
				}

			});

			logger.info("结束读取文件");
			ftp.logout();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					logger.info("url=" + url + "完成操作");
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return list;
		
		
	}



	private static Boolean isMatch(String fileName, String regEx) {

		// 要验证的字符�?
		// String str = "service@xsoftlab.net";
		// // 邮箱验证规则
		// String regEx =
		// "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		// 编译正则表达�?
		Pattern pattern = Pattern.compile(regEx);   
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(fileName);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}

	/**
	 * 
	 * Created on 2016-4-16
	 * <p>
	 * Discription:[方法功能中文描述]
	 * </p>
	 * 
	 * @param date
	 * @param _format
	 * @return
	 * @author:<a href=21990173@qq.com>jinyi</a>
	 * @update:[日期YYYY-MM-DD] [更改人姓名]
	 */
	private static String formatDate(Date date, String _format) {

		SimpleDateFormat format = new SimpleDateFormat(_format, Locale.getDefault());
		try {
			String format2 = format.format(date);
			return format2;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// String aa1 = "DR_PS_Gn_DNS_Event_20160922184117_609_120.txt";
		// String aa = "DR_PS_Gn_DNS_Event_20160922.txt";
		// logger.debug(isMatch(aa,
		// "DR_PS_Gn_DNS_Event[a-zA-Z0-9_]{0,}_20160922[a-zA-Z0-9_]{0,}.txt"));
		// String value = new FTPNewUtils().getProperties("jdbc.url");
		// logger.debug(value);

		String reportDates = null;
		if (args.length > 0) {
			reportDates = args[0];
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Date reportDate = calendar.getTime();
			reportDates = formatDate(reportDate, "yyyyMMdd");
		}

		
		
		//insertTab(ftpFileCount, reportDates);
		logger.debug("保存到表中");

	}

}
