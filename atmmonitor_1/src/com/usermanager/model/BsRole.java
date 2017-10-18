package com.usermanager.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
@Table(name="bs_role")
public class BsRole implements java.io.Serializable 
{
	private String roleid;
	private String rolename;
	private Long createtime;
	private Set<BsMenu> menuSet=new HashSet<BsMenu>();	
	public BsRole() {		
	}
	public BsRole(String roleid, String rolename) {		
		this.roleid = roleid;
		this.rolename = rolename;
	}
	@Id	
	public String getRoleid() 
	{
		return this.roleid;
	}
	public void setRoleid(String roleid) 
	{
		this.roleid=roleid;
	}
	public String getRolename() 
	{
		return this.rolename;
	}
	public void setRolename(String rolename) 
	{
		this.rolename=rolename;
	}
	public Long getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(Long createtime) 
	{
		this.createtime=createtime;
	}
	@ManyToMany(targetEntity = BsMenu.class, fetch = FetchType.LAZY)  
    @JoinTable(name = "bs_role_menu", joinColumns = @JoinColumn(name = "roleid"), inverseJoinColumns = @JoinColumn(name = "menuid")) 
	public Set<BsMenu> getMenuSet() {
		return menuSet;
	}
	public void setMenuSet(Set<BsMenu> menuSet) {
		this.menuSet = menuSet;
	}	
}