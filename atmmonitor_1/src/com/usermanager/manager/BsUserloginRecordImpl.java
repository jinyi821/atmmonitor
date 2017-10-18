package com.usermanager.manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.core.util.TimeUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsUserinfo;
import com.usermanager.model.BsUserloginRecord;
import com.usermanager.services.BsUserinfoService;
import com.usermanager.services.BsUserloginRecordService;

/**
 * 
 * Created on 2016年12月28日
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
@Transactional
@Service("bsUserloginRecordService")
public class BsUserloginRecordImpl implements BsUserloginRecordService {
	
	private static Log logger = LogFactory.getLog(BsUserloginRecordImpl.class);

	@Resource
	private BsUserinfoService bsUserinfoService;


    @Autowired
	private IDAO<BsUserloginRecord, Long> bsUserloginRecordDao;

	public IDAO<BsUserloginRecord, Long> getBsUserloginRecordDao() {
		return bsUserloginRecordDao;
	}

	public void setBsUserloginRecordDao(IDAO<BsUserloginRecord, Long> bsUserloginRecordDao) {
		this.bsUserloginRecordDao = bsUserloginRecordDao;
	}

	public boolean addBsUserloginRecord(BsUserloginRecord bsUserloginRecord) {
		boolean result = false;
		if (bsUserloginRecord != null) {
			bsUserloginRecord.setCreatetime(System.currentTimeMillis() / 1000);
			bsUserloginRecordDao.save(bsUserloginRecord);
			result = true;
		}
		return result;
	}

	public boolean saveOrUpdateBsUserloginRecord(BsUserloginRecord bsUserloginRecord) {
		boolean result = false;
		if (bsUserloginRecord != null) {
			String pid = StringUtils.checkNullString(bsUserloginRecord.getPid()).trim();
			if (pid.equals("")) {
				result = this.addBsUserloginRecord(bsUserloginRecord);
			} else {
				bsUserloginRecordDao.saveOrUpdate(bsUserloginRecord);
				result = true;
			}
		}
		return result;
	}

	public boolean deleteBsUserloginRecordById(Long bsUserloginRecordId) {
		boolean result = false;
		bsUserloginRecordDao.deleteByKey(bsUserloginRecordId);
		result = true;
		return result;
	}

	public BsUserloginRecord getBsUserloginRecordById(Long pid) {
		return bsUserloginRecordDao.get(pid);
	}

	public boolean deleteBsUserloginRecordByIds(List<Long> bsUserloginRecordIdList) {
		int lstLen = bsUserloginRecordIdList == null ? 0 : bsUserloginRecordIdList.size();
		for (int i = 0; i < lstLen; i++) {
			if (!this.deleteBsUserloginRecordById(bsUserloginRecordIdList.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public void addBsUserloginRecord(String loginname, Integer issuccess) {
		BsUserloginRecord userloginRecord = new BsUserloginRecord();
		userloginRecord.setLogingname(loginname);
		userloginRecord.setIssuccess(issuccess);
		Calendar instance = Calendar.getInstance();
		long createtime = instance.getTimeInMillis();
		int loginhour = instance.get(Calendar.HOUR_OF_DAY);
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH) + 1;
		int week = instance.get(Calendar.WEEK_OF_YEAR);
		String formatIntToDateString = TimeUtils.formatIntToDateString(createtime / 1000, "yyyyMMdd");
		Long logindate = new Long(formatIntToDateString);
		userloginRecord.setCreatetime(createtime / 1000);
		userloginRecord.setLogindate(logindate);
		userloginRecord.setHour(loginhour);
		userloginRecord.setYear(year);
		userloginRecord.setMonth(month);
		userloginRecord.setWeek(week);
		bsUserloginRecordDao.save(userloginRecord);
	}

	/**
	 * 
	 */
	@Override
	public List<BsUserloginRecord> getLastBsUserloginRecordByloginname(String loginname) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("logingname", loginname);
		List<BsUserloginRecord> list = bsUserloginRecordDao.findBySql("SELECT * FROM bs_userlongin_record  where logingname= :logingname  and issuccess=1 order by  createtime desc limit 2 ", map);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 判断当前已经登录用户是否有几个月没有登录，当前本次登录不算统计 超过三个月 删除最后一次登录日志 ，冻结用户访问
	 * 
	 * @param month
	 * @param loginname
	 * @return
	 */
	public Boolean isOverMonthLogin(Integer month, BsUserinfo bsUserinfoByLoginname) {

		Calendar calndar = Calendar.getInstance();
		// 当前时间
		Long nowtime = Calendar.getInstance().getTimeInMillis() / 1000;

		calndar.add(Calendar.MONTH, -month);
		// 前三个月时间
		Date time1 = calndar.getTime();

		Boolean isOverMonthLogin = false;
		String loginname = bsUserinfoByLoginname.getLoginname();
		List<BsUserloginRecord> lastBsUserloginRecordList = getLastBsUserloginRecordByloginname(loginname);

		if (bsUserinfoByLoginname.getStatus().equals(2)) {

			isOverMonthLogin = true;
		} else {

			Long userTime = 0L;
			if (bsUserinfoByLoginname.getActiveorlocktime() != null) {
				userTime = bsUserinfoByLoginname.getActiveorlocktime();

			} else {

				if (bsUserinfoByLoginname.getCreatetime() == null) {

					bsUserinfoByLoginname.setCreatetime(nowtime);
					bsUserinfoByLoginname.setPwd(bsUserinfoByLoginname.getDecodePwd());
					bsUserinfoService.saveOrUpdateBsUserinfo(bsUserinfoByLoginname);
				}
				userTime = bsUserinfoByLoginname.getCreatetime();
			}

			Calendar instance = Calendar.getInstance();
			instance.setTimeInMillis(userTime * 1000);
			Date createtime = instance.getTime(); // 取生成日期

			if (lastBsUserloginRecordList == null || lastBsUserloginRecordList.size() < 2) {
				// 没有登录，把生成日期和当前前几个月日期比较
				isOverMonthLogin = createtime.before(time1);

			} else {
				// 取倒数第二次登录
				Long logindate_i = lastBsUserloginRecordList.get(1).getLogindate();
				Date logindate = TimeUtils.formatStringToDate(logindate_i + "", "yyyyMMdd");

				if (logindate.after(createtime)) {

					isOverMonthLogin = logindate.before(time1);

				} else {
					// 审批激活后把生成时间改成当前日期，所有激活时间有可能在现有最大登录日期之后
					isOverMonthLogin = createtime.before(time1);
				}
			}
		}
		if (isOverMonthLogin) {

			// 超过三个月 没访问，修改最后一次登录日志状态为不成功 ，冻结用户访问
			BsUserloginRecord bsUserloginRecord = lastBsUserloginRecordList.get(0);
			bsUserloginRecord.setIssuccess(0);
			saveOrUpdateBsUserloginRecord(bsUserloginRecord);
			
			if (bsUserinfoByLoginname.getStatus().equals(1)) {
				
				bsUserinfoByLoginname.setStatus(2);
				bsUserinfoByLoginname.setPwd(bsUserinfoByLoginname.getDecodePwd());
				bsUserinfoByLoginname.setActiveorlocktime(nowtime);
				bsUserinfoService.saveOrUpdateBsUserinfo(bsUserinfoByLoginname);
			}
		}
		return isOverMonthLogin;
	}
	
	/**
	 * 判断当前状态为在用登录用户是否有几个月没有登录
	 * 
	 * @param month
	 * @param loginname
	 * @return
	 */
	private void processOverMonthLogin(Integer month, BsUserinfo bsUserinfoByLoginname) {

		Calendar calndar = Calendar.getInstance();
		// 当前时间
		Long nowtime = Calendar.getInstance().getTimeInMillis() / 1000;

		calndar.add(Calendar.MONTH, -month);
		// 前三个月时间
		Date time1 = calndar.getTime();

		Boolean isOverMonthLogin = false;
		String loginname = bsUserinfoByLoginname.getLoginname();
		List<BsUserloginRecord> lastBsUserloginRecordList = getLastBsUserloginRecordByloginname(loginname);

		if (bsUserinfoByLoginname.getStatus().equals(2)) {

			isOverMonthLogin = true;
		} else {

			Long userTime = 0L;
			if (bsUserinfoByLoginname.getActiveorlocktime() != null) {
				userTime = bsUserinfoByLoginname.getActiveorlocktime();

			} else {

				if (bsUserinfoByLoginname.getCreatetime() == null) {

					bsUserinfoByLoginname.setCreatetime(nowtime);
					bsUserinfoByLoginname.setPwd(bsUserinfoByLoginname.getDecodePwd());
					bsUserinfoService.saveOrUpdateBsUserinfo(bsUserinfoByLoginname);
				}
				userTime = bsUserinfoByLoginname.getCreatetime();
			}
			
			
			Calendar instance = Calendar.getInstance();
			instance.setTimeInMillis(userTime * 1000);
			Date createtime = instance.getTime(); // 取生成日期
			
			//String aa=getDateTime(createtime); //TODO
			if (lastBsUserloginRecordList == null || lastBsUserloginRecordList.size() ==0) {
				
				// 没有登录，把生成日期和当前前几个月日期比较
				isOverMonthLogin = createtime.before(time1);
				//TODO  20161202 最近导入时间
//				if (aa.equals("20161202")){
//					isOverMonthLogin=true;
//				}

			} else {
				// 取最后第一次登录
				Long logindate_i = lastBsUserloginRecordList.get(0).getLogindate();
				Date logindate = TimeUtils.formatStringToDate(logindate_i + "", "yyyyMMdd");

				if (logindate.after(createtime)) {

					isOverMonthLogin = logindate.before(time1);

				} else {
					// 审批激活后把生成时间改成当前日期，所有激活时间有可能在现有最大登录日期之后
					isOverMonthLogin = createtime.before(time1);
				}
			}
		}
		if (isOverMonthLogin) {
			
			if (bsUserinfoByLoginname.getStatus().equals(1)) {
				
				logger.info("bsUserinfoByLoginname="+bsUserinfoByLoginname.getLoginname()+"三个月未登录被冻结！");
				
				bsUserinfoByLoginname.setStatus(2);
				bsUserinfoByLoginname.setPwd(bsUserinfoByLoginname.getDecodePwd());
				bsUserinfoByLoginname.setActiveorlocktime(nowtime);
				bsUserinfoService.saveOrUpdateBsUserinfo(bsUserinfoByLoginname);
			}
		}
	}
	/**
	 * 提前处理三个月未登录用户
	 */
	@Override
	public void process() {
		
		Map<String,Object> condition =new HashMap<String,Object>();
		condition.put("status", 1);
		List<BsUserinfo> bsUserinfoByCondition = bsUserinfoService.getBsUserinfoByCondition(condition);
		
		for (BsUserinfo bsUserinfo : bsUserinfoByCondition) {
			
			processOverMonthLogin(3,bsUserinfo);
		}
		
	}
	/**
	 * 得到某个日期对应的秒数
	 * 
	 * @param date
	 * @return
	 */
	private static String getDateTime(Date date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
		
		try {
			String a = simpleDateFormat.format(date);
			return a;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public static void main(String args[]) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(1480676614L);
		Date createtime = instance.getTime();
		String dateTime = getDateTime(createtime);
		Calendar calndar = Calendar.getInstance();

		calndar.add(Calendar.MONTH, -5);
		System.out.println(calndar.getTimeInMillis() / 1000);
	}
}
