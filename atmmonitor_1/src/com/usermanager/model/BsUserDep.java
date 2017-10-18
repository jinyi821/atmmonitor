package com.usermanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bs_userdep")
public class BsUserDep implements java.io.Serializable 
{
	private Integer pid;
	private String loginname;
	private String depid;
	private String relatetype;
	private String creater;
	private Long createtime;
	private String lastmodifier;
	private Long lastmodifytime;
	private BsUserinfo userinfo;
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
	public String getDepid() 
	{
		return this.depid;
	}
	public void setDepid(String depid) 
	{
		this.depid=depid;
	}
	public String getRelatetype() 
	{
		return this.relatetype;
	}
	public void setRelatetype(String relatetype) 
	{
		this.relatetype=relatetype;
	}
	public String getCreater() 
	{
		return this.creater;
	}
	public void setCreater(String creater) 
	{
		this.creater=creater;
	}
	public Long getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(Long createtime) 
	{
		this.createtime=createtime;
	}
	public String getLastmodifier() 
	{
		return this.lastmodifier;
	}
	public void setLastmodifier(String lastmodifier) 
	{
		this.lastmodifier=lastmodifier;
	}
	public Long getLastmodifytime() 
	{
		return this.lastmodifytime;
	}
	public void setLastmodifytime(Long lastmodifytime) 
	{
		this.lastmodifytime=lastmodifytime;
	}
	@OneToOne(cascade=CascadeType.REFRESH)      
    @JoinColumn(name="loginname",insertable = false, updatable = false )
	public BsUserinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(BsUserinfo userinfo) {
		this.userinfo = userinfo;
	}
}