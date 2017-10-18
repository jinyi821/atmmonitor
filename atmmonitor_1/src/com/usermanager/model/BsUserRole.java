package com.usermanager.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bs_userinfo_role")


public class BsUserRole implements java.io.Serializable 
{
	/**
     * <p>Discription:[字段功能描述]</p>
     */
    private static final long serialVersionUID = 1L;
    private Long pid;
    private String loginname;
	private String roleid;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPid() 
	{
		return this.pid;
	}


    public String getLoginname()
    {
        return loginname;
    }


    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }


    public String getRoleid()
    {
        return roleid;
    }


    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }


    public void setPid(Long pid)
    {
        this.pid = pid;
    }
	
    
	

}
