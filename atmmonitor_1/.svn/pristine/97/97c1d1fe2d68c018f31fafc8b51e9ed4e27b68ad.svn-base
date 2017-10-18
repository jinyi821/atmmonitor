package com.usermanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_userlongin_record")
public class BsUserloginRecord implements java.io.Serializable 
{
	private Long pid;
	private String logingname;
	private Long logindate;
	private Integer hour;
	private Integer year;
	private Integer month;
	private Integer week;
	private Integer issuccess;
	private Long createtime;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPid() 
	{
		return this.pid;
	}
	public void setPid(Long pid) 
	{
		this.pid=pid;
	}
	public String getLogingname() 
	{
		return this.logingname;
	}
	public void setLogingname(String logingname) 
	{
		this.logingname=logingname;
	}
	public Long getLogindate() 
	{
		return this.logindate;
	}
	public void setLogindate(Long logindate) 
	{
		this.logindate=logindate;
	}
	public Integer getHour() 
	{
		return this.hour;
	}
	public void setHour(Integer hour) 
	{
		this.hour=hour;
	}
	public Integer getIssuccess() 
	{
		return this.issuccess;
	}
	public void setIssuccess(Integer issuccess) 
	{
		this.issuccess=issuccess;
	}
	public Long getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(Long createtime) 
	{
		this.createtime=createtime;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
}
