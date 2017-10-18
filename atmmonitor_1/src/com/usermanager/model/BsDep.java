package com.usermanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_dep")

public class BsDep implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private String pid;
	private String depname;
	private String deptype;
	private String grouptype;
	private String parentid;
	private String depfullname;
	private String depdns;
	private String depdn;
	private Integer ordernum;
	private String depassginee;
	private String depphone;
	private String depfax;
	private String depemail;
	private Integer status;
	private String locationzone;
	private String depimage;
	private String creater;
	private Long createtime;
	private String lastmodifier;
	private Long lastmodifytime;
	private String remark;
	public BsDep() {	
	}	
	public BsDep(String pid, String depname,String depfullname) {		
		this.pid = pid;
		this.depname = depname;
		this.depfullname=depfullname;
	}
	@Id
	public String getPid() 
	{
		return this.pid;
	}
	public void setPid(String pid) 
	{
		this.pid=pid;
	}
	public String getDepname() 
	{
		return this.depname;
	}
	public void setDepname(String depname) 
	{
		this.depname=depname;
	}
	public String getDeptype() 
	{
		return this.deptype;
	}
	public void setDeptype(String deptype) 
	{
		this.deptype=deptype;
	}
	public String getGrouptype() 
	{
		return this.grouptype;
	}
	public void setGrouptype(String grouptype) 
	{
		this.grouptype=grouptype;
	}
	public String getParentid() 
	{
		return this.parentid;
	}
	public void setParentid(String parentid) 
	{
		this.parentid=parentid;
	}
	public String getDepfullname() 
	{
		return this.depfullname;
	}
	public void setDepfullname(String depfullname) 
	{
		this.depfullname=depfullname;
	}
	public String getDepdns() 
	{
		return this.depdns;
	}
	public void setDepdns(String depdns) 
	{
		this.depdns=depdns;
	}
	public String getDepdn() 
	{
		return this.depdn;
	}
	public void setDepdn(String depdn) 
	{
		this.depdn=depdn;
	}
	public Integer getOrdernum() 
	{
		return this.ordernum;
	}
	public void setOrdernum(Integer ordernum) 
	{
		this.ordernum=ordernum;
	}
	public String getDepassginee() 
	{
		return this.depassginee;
	}
	public void setDepassginee(String depassginee) 
	{
		this.depassginee=depassginee;
	}
	public String getDepphone() 
	{
		return this.depphone;
	}
	public void setDepphone(String depphone) 
	{
		this.depphone=depphone;
	}
	public String getDepfax() 
	{
		return this.depfax;
	}
	public void setDepfax(String depfax) 
	{
		this.depfax=depfax;
	}
	public String getDepemail() 
	{
		return this.depemail;
	}
	public void setDepemail(String depemail) 
	{
		this.depemail=depemail;
	}
	public Integer getStatus() 
	{
		return this.status;
	}
	public void setStatus(Integer status) 
	{
		this.status=status;
	}
	public String getLocationzone() 
	{
		return this.locationzone;
	}
	public void setLocationzone(String locationzone) 
	{
		this.locationzone=locationzone;
	}
	public String getDepimage() 
	{
		return this.depimage;
	}
	public void setDepimage(String depimage) 
	{
		this.depimage=depimage;
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
	public String getRemark() 
	{
		return this.remark;
	}
	public void setRemark(String remark) 
	{
		this.remark=remark;
	}

}
