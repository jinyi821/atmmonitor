package com.equipment.model;

import java.io.Serializable;

import com.common.core.util.TimeUtils;

/**
 * 
 * Created on 2017年6月3日
 * <p>Title:       [项目名称_一级模块名称_模块名称]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>

 * @version        1.0
 */
public class Equipment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String type;

    private String factory;

    private String owndept;
    
    private String depname;

    private Integer status;

    private String creater;

    private Integer createtime;

    private String lastmodifier;

    private Integer lastmodifytime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getOwndept() {
        return owndept;
    }

    public void setOwndept(String owndept) {
        this.owndept = owndept == null ? null : owndept.trim();
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

    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier == null ? null : lastmodifier.trim();
    }

    public Integer getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Integer lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}
    
    
}