package com.usermanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_map_usertype")

public class BsMapUserType implements java.io.Serializable 
{
	private Integer pid;
	private String loginname;
	private Integer usertypeid;
	private Long createtime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPid() 
	{
		return this.pid;
	}
	public void setPid(Integer pid) 
	{
		this.pid=pid;
	}
	public String getLoginname() 
	{
		return this.loginname;
	}
	public void setLoginname(String loginname) 
	{
		this.loginname=loginname;
	}
	public Integer getUsertypeid() 
	{
		return this.usertypeid;
	}
	public void setUsertypeid(Integer usertypeid) 
	{
		this.usertypeid=usertypeid;
	}
	public Long getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(Long createtime) 
	{
		this.createtime=createtime;
	}

}
