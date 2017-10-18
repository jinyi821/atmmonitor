package com.usermanager.model ;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="bs_menu")
public class BsMenu implements java.io.Serializable 
{
	/**
     * <p>Discription:[字段功能描述]</p>
     */
    private static final long serialVersionUID = -270155255978326829L;
    private Integer menuid;
	private String menuname;
	private String menuurl;
	private Integer menutype;
	private Integer parentid;
	private Integer status;
	private Long createtime;
	@Transient
	private List<BsMenu> childList=new ArrayList<BsMenu>();	
	private BsMenu parentBsMenu;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMenuid() 
	{
		return this.menuid;
	}
	public void setMenuid(Integer menuid) 
	{
		this.menuid=menuid;
	}
	public String getMenuname() 
	{
		return this.menuname;
	}
	public void setMenuname(String menuname) 
	{
		this.menuname=menuname;
	}
	public String getMenuurl() 
	{
		return this.menuurl;
	}
	public void setMenuurl(String menuurl) 
	{
		this.menuurl=menuurl;
	}
	public Integer getMenutype() 
	{
		return this.menutype;
	}
	public void setMenutype(Integer menutype) 
	{
		this.menutype=menutype;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getStatus() 
	{
		return this.status;
	}
	public void setStatus(Integer status) 
	{
		this.status=status;
	}
	public Long getCreatetime() 
	{
		return this.createtime;
	}
	public void setCreatetime(Long createtime) 
	{
		this.createtime=createtime;
	}
	//@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "parentBsMenu")
	//public Set<BsMenu> getChildSet() {
	//	return childSet;
	//}
	//public void setChildSet(Set<BsMenu> childSet) {
	//	this.childSet = childSet;
	//}
	
	@ManyToOne(cascade = { CascadeType.REFRESH}) 
	@JoinColumn(name = "parentid",insertable = false, updatable = false )
	public BsMenu getParentBsMenu() {
		return parentBsMenu;
	}
	public void setParentBsMenu(BsMenu parentBsMenu) {
		this.parentBsMenu = parentBsMenu;
	}
	@Transient
    public List<BsMenu> getChildList()
    {
        return childList;
    }
	@Transient
    public void setChildList(List<BsMenu> childList)
    {
        this.childList = childList;
    }
  
}
