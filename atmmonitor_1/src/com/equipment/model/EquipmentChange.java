package com.equipment.model;

import com.common.core.util.TimeUtils;

public class EquipmentChange {
	private Integer id;

	private Integer equipmentid;

	private String equipmentname;

	private String applydept;

	private Integer status = 0;

	private String creater;

	private Integer createtime;
	private String createtimeStr;

	private String maintainer;

	private Integer maintaintime;
	private String maintaintimeStr;

	private String approver;

	private Integer approvetime;
	private String approvetimeStr;

	private String applyremark;

	private String maintainremark;

	private String approverremark;
	
	private String statusName;
	
	public String getStatusName() {
		
		if (status==0){
			statusName="新建";
		}
		if (status==1){
			statusName="待审批";
		}
		if (status==2){
			statusName="审批通过";
		}
		if (status==3){
			statusName="审批不通过";
		}
		if (status==4){
			statusName="已维修";
		}
		if (status==5){
			statusName="不能维修";
		}
		return statusName;
	}

	public void setStatusName(String statusName) {
		
		this.statusName = statusName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getEquipmentname() {
		return equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname == null ? null : equipmentname.trim();
	}

	public String getApplydept() {
		return applydept;
	}

	public void setApplydept(String applydept) {
		this.applydept = applydept == null ? null : applydept.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	public String getMaintainer() {
		return maintainer;
	}

	public void setMaintainer(String maintainer) {
		this.maintainer = maintainer == null ? null : maintainer.trim();
	}

	public Integer getMaintaintime() {
		return maintaintime;
	}

	public void setMaintaintime(Integer maintaintime) {
		this.maintaintime = maintaintime;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver == null ? null : approver.trim();
	}

	public Integer getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(Integer approvetime) {
		this.approvetime = approvetime;
	}

	public String getApplyremark() {
		return applyremark;
	}

	public void setApplyremark(String applyremark) {
		this.applyremark = applyremark == null ? null : applyremark.trim();
	}

	public String getMaintainremark() {
		return maintainremark;
	}

	public void setMaintainremark(String maintainremark) {
		this.maintainremark = maintainremark == null ? null : maintainremark.trim();
	}

	public String getApproverremark() {
		return approverremark;
	}

	public void setApproverremark(String approverremark) {
		this.approverremark = approverremark == null ? null : approverremark.trim();
	}

	public String getCreatetimeStr() {

		if (createtime != null) {
			createtimeStr = TimeUtils.formatIntToDateString(createtime);
		}
		return createtimeStr;
	}

	public void setCreatetimeStr(String createtimeStr) {
		this.createtimeStr = createtimeStr;
	}

	public String getMaintaintimeStr() {

		if (maintaintime != null) {
			maintaintimeStr = TimeUtils.formatIntToDateString(maintaintime);
		}
		return maintaintimeStr;
	}

	public void setMaintaintimeStr(String maintaintimeStr) {
		this.maintaintimeStr = maintaintimeStr;
	}

	public String getApprovetimeStr() {
		
		if (approvetime != null) {
			approvetimeStr = TimeUtils.formatIntToDateString(approvetime);
		}
		return approvetimeStr;
	}

	public void setApprovetimeStr(String approvetimeStr) {
		this.approvetimeStr = approvetimeStr;
	}

}