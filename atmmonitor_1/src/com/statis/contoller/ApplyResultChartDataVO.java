package com.statis.contoller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Created on 2016-4-21
 * <p>Title:       [数据共享平台_统计_应用统计_分析结果发布统计VO]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     </p>
 * @author         <a href=21990173@qq.com>jinyi</a>
 * @version        1.0
 */
public class ApplyResultChartDataVO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> deptList=new ArrayList<String>();
	private List<DeptStatisVO> deptEquipValueList =new ArrayList<DeptStatisVO>();
	
	private List<String> equipChangeList=new ArrayList<String>();
	private List<String>  dateList = new ArrayList<String>();

	public List<String> getDateList() {
		return dateList;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	public List<String> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<String> deptList) {
		this.deptList = deptList;
	}

	public List<DeptStatisVO> getDeptEquipValueList() {
		return deptEquipValueList;
	}

	public void setDeptEquipValueList(List<DeptStatisVO> deptEquipValueList) {
		this.deptEquipValueList = deptEquipValueList;
	}

	public List<String> getEquipChangeList() {
		return equipChangeList;
	}

	public void setEquipChangeList(List<String> equipChangeList) {
		this.equipChangeList = equipChangeList;
	}

	
	
	
	
	
	
	//'直接访问','邮件营销','联盟广告','视频广告','搜索引擎'
    
    
    
}
