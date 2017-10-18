package com.usermanager.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bs_role_menu")
public class BsRoleMenu implements java.io.Serializable 
{
	private Long pid;
	private String roleid;
	private Integer menuid;
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
	public String getRoleid() 
	{
		return this.roleid;
	}
	public void setRoleid(String roleid) 
	{
		this.roleid=roleid;
	}
	public Integer getMenuid() 
	{
		return this.menuid;
	}
	public void setMenuid(Integer menuid) 
	{
		this.menuid=menuid;
	}

}
