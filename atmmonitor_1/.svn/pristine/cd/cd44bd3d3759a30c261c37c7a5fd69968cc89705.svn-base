package com.usermanager.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_vist_recorde")
public class BsVistRecorde implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long pid; 
	private String   loginname;
	private Long  linkid ;
	private String  linkurl;
	private Long  vistdate;
	private Integer  visthour;
	private Long   moduleid;
	private String  modulename;
	private Long  createtime;
	private Integer apptype;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Long getLinkid()
    {
        return linkid;
    }
    public void setLinkid(Long linkid)
    {
        this.linkid = linkid;
    }
    public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public Long getVistdate() {
		return vistdate;
	}
	public void setVistdate(Long vistdate) {
		this.vistdate = vistdate;
	}
	public Integer getVisthour() {
		return visthour;
	}
	public void setVisthour(Integer visthour) {
		this.visthour = visthour;
	}
	
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
    public Long getModuleid()
    {
        return moduleid;
    }
    public void setModuleid(Long moduleid)
    {
        this.moduleid = moduleid;
    }
    public Long getCreatetime()
    {
        return createtime;
    }
    public void setCreatetime(Long createtime)
    {
        this.createtime = createtime;
    }
    
    public Integer getApptype()
    {
        return apptype;
    }
    public void setApptype(Integer apptype)
    {
        this.apptype = apptype;
    }
    @Override
    public String toString()
    {
        return "BsVistRecorde [pid=" + pid + ", loginname=" + loginname + ", linkid=" + linkid + ", linkurl=" + linkurl
                + ", vistdate=" + vistdate + ", visthour=" + visthour + ", moduleid=" + moduleid + ", modulename="
                + modulename + ", createtime=" + createtime + ", apptype=" + apptype + "]";
    }
    


}
