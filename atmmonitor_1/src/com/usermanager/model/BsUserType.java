package com.usermanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BS_USERTYPE")

public class BsUserType implements java.io.Serializable 
{
	private static final long serialVersionUID = -536062367607572641L;
	private Long pid;
	private String usertype;
	private Long createtime;
    
	public BsUserType() {
		
	}	
	public BsUserType(Long pid, String usertype) {		
		this.pid = pid;
		this.usertype = usertype;
	}

	@Id
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
}
