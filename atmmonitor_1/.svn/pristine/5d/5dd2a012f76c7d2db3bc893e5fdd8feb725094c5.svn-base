package com.usermanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.common.core.util.CryptUrlUtils;

@Entity
@Table(name = "bs_userinfo")
public class BsUserinfo implements java.io.Serializable {
	private String loginname;
	private String fullname;
	private String pwd;
	private String sex;
	private String email;
	private String mobile;
	private String depid;
	private String depname;
	private Integer isdepleader;
	private Integer status;//1 正常 0 停用 2 冻结
	private Integer isanalyzer;
	private Integer isdeveloper;
	private Long createtime;
	private String encodePwd;
	private String decodePwd;	
	private Long activeorlocktime;//激活或冻结时间

	// private Set<BsRole> userRoles=new HashSet<BsRole>();
	// private Set<BsUserType> userTypes=new HashSet<BsUserType>();
	// private Set<BsDep> userDeps=new HashSet<BsDep>();

	private List<BsRole> userRoleList = new ArrayList<BsRole>();
	private List<BsUserType> userTypeList = new ArrayList<BsUserType>();
	private List<BsDep> userDepList = new ArrayList<BsDep>();

	@Id
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPwd() {
		// String newPwd=CryptUrlUtils.decode(this.pwd);
		return this.pwd;
	}

	public void setPwd(String pwd) {
		// String newPwd=CryptUrlUtils.encode(pwd);
		this.pwd = pwd;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Integer getIsdepleader() {
		return isdepleader;
	}

	public void setIsdepleader(Integer isdepleader) {
		this.isdepleader = isdepleader;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsanalyzer() {
		return isanalyzer;
	}

	public void setIsanalyzer(Integer isanalyzer) {
		this.isanalyzer = isanalyzer;
	}

	public Integer getIsdeveloper() {
		return isdeveloper;
	}

	public void setIsdeveloper(Integer isdeveloper) {
		this.isdeveloper = isdeveloper;
	}

	public Long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	@Transient
	public List<BsRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<BsRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	@Transient
	public List<BsUserType> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<BsUserType> userTypeList) {
		this.userTypeList = userTypeList;
	}

	@Transient
	public List<BsDep> getUserDepList() {
		return userDepList;
	}

	public void setUserDepList(List<BsDep> userDepList) {
		this.userDepList = userDepList;
	}

	@Transient
	public String getEncodePwd() {
		String encodenewpwd;
		try {
			encodenewpwd = CryptUrlUtils.encode(this.pwd);
		} catch (Exception e) {
			encodenewpwd = this.pwd;
		}
		return encodenewpwd;
	}

	public void setEncodePwd(String encodePwd) {
		this.encodePwd = encodePwd;
	}

	@Transient
	public String getDecodePwd() {
		String decodenewpwd = CryptUrlUtils.decode(this.pwd);
		if (decodenewpwd == null) {
			decodenewpwd = this.pwd;
		}
		return decodenewpwd;
	}

	public void setDecodePwd(String decodePwd) {
		this.decodePwd = decodePwd;
	}
	public Long getActiveorlocktime() {
		return activeorlocktime;
	}

	public void setActiveorlocktime(Long activeorlocktime) {
		this.activeorlocktime = activeorlocktime;
	}

	

	// @ManyToMany(targetEntity = BsRole.class, fetch = FetchType.EAGER)
	// @JoinTable(name = "bs_userinfo_role", joinColumns = @JoinColumn(name =
	// "loginname"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	// public Set<BsRole> getUserRoles() {
	// return userRoles;
	// }
	// public void setUserRoles(Set<BsRole> userRoles) {
	// this.userRoles = userRoles;
	// }
	// @ManyToMany(targetEntity = BsUserType.class, fetch = FetchType.EAGER)
	// @JoinTable(name = "bs_map_usertype", joinColumns = @JoinColumn(name =
	// "loginname"), inverseJoinColumns = @JoinColumn(name = "usertypeid"))
	// public Set<BsUserType> getUserTypes() {
	// return userTypes;
	// }
	// public void setUserTypes(Set<BsUserType> userTypes) {
	// this.userTypes = userTypes;
	// }
	// @ManyToMany(targetEntity = BsDep.class, fetch = FetchType.EAGER)
	// @JoinTable(name = "bs_userdep", joinColumns = @JoinColumn(name =
	// "loginname"), inverseJoinColumns = @JoinColumn(name = "depid"))
	// public Set<BsDep> getUserDeps() {
	// return userDeps;
	// }
	// public void setUserDeps(Set<BsDep> userDeps) {
	// this.userDeps = userDeps;
	// }

}
