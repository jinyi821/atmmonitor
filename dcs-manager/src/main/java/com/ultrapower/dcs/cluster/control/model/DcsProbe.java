package com.ultrapower.dcs.cluster.control.model;

import java.util.Date;

public class DcsProbe implements java.io.Serializable
        {
//DcsProbe表
private static final long serialVersionUID = 1L;
private Integer probe_id; //probeId
private String probe_name; //probe名称
private String probe_ip; //probe所在主机IP
private String hard_disk; //数据分配的硬盘
private String total_space; //硬盘的总空间
private String free_space; //硬盘的剩余空间
private String use_space; //硬盘的已用空间
private Integer heart_interval; //心跳间隔时间
private Date update_time; //最后一次修改时间

    public Integer getProbe_id() {
        return probe_id;
    }

    public void setProbe_id(Integer probe_id) {
        this.probe_id = probe_id;
    }

    public String getProbe_name() {
        return probe_name;
    }

    public void setProbe_name(String probe_name) {
        this.probe_name = probe_name == null ? null : probe_name.trim();
    }

    public String getProbe_ip() {
        return probe_ip;
    }

    public void setProbe_ip(String probe_ip) {
        this.probe_ip = probe_ip == null ? null : probe_ip.trim();
    }

    public String getHard_disk() {
        return hard_disk;
    }

    public void setHard_disk(String hard_disk) {
        this.hard_disk = hard_disk == null ? null : hard_disk.trim();
    }

    public String getTotal_space() {
        return total_space;
    }

    public void setTotal_space(String total_space) {
        this.total_space = total_space == null ? null : total_space.trim();
    }

    public String getFree_space() {
        return free_space;
    }

    public void setFree_space(String free_space) {
        this.free_space = free_space == null ? null : free_space.trim();
    }

    public String getUse_space() {
        return use_space;
    }

    public void setUse_space(String use_space) {
        this.use_space = use_space == null ? null : use_space.trim();
    }

    public Integer getHeart_interval() {
        return heart_interval;
    }

    public void setHeart_interval(Integer heart_interval) {
        this.heart_interval = heart_interval;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    private String runningStatus; //运行中状态，1、正常 2、挂掉
    public String getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(String runningStatus) {
        this.runningStatus = runningStatus;
    }
}