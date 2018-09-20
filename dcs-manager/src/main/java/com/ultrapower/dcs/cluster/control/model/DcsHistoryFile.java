package com.ultrapower.dcs.cluster.control.model;

import java.util.Date;

public class DcsHistoryFile implements java.io.Serializable{
//DCS历史数据文件表
private static final long serialVersionUID = 1L;
/*private Integer file_id; //FileId
private Integer ftp_id; //FTPId
private Integer data_type_id; //dcs_data_type表id
private String path_and_name; //全路径文件
private String rename_file_name; //改名后文件名
private datetime file_insert_time; //文件插入时间
private Integer status; //0：已经下发到probe但没有下载完成。1：下载完成但没有执行上传hdfs。2：上传hdfs成功。3：上传hdfs失败。4：正在执行hdfs上传但没有上传完毕。
private Integer probe_id; //ProbeId
private Long file_size; //文件大小   单位字节
private String ftp_path_and_name; //文件在ftp端的路径和名称
private Long download_duration; //下载时长（ms）
private Long to_hdfs_duration; //上传hdfs时长（ms）
private Integer event_time_day_int; //
private String hdfs_path; //文件存储HDFS路径*/

    private Integer fileId;

    private Integer ftpId;

    private Integer dataTypeId;

    private String pathAndName;

    private String renameFileName;

    private Date fileInsertTime;

    private Integer status;

    private Integer probeId;

    private Long fileSize;

    private String ftpPathAndName;

    private Long downloadDuration;

    private Long toHdfsDuration;

    private Integer eventTimeDayInt;

    private String hdfsPath;
    private  String ftpIp;
    private String dataTypeName;
    private String probeName;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFtpId() {
        return ftpId;
    }

    public void setFtpId(Integer ftpId) {
        this.ftpId = ftpId;
    }

    public Integer getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public String getPathAndName() {
        return pathAndName;
    }

    public void setPathAndName(String pathAndName) {
        this.pathAndName = pathAndName == null ? null : pathAndName.trim();
    }

    public String getRenameFileName() {
        return renameFileName;
    }

    public void setRenameFileName(String renameFileName) {
        this.renameFileName = renameFileName == null ? null : renameFileName.trim();
    }

    public Date getFileInsertTime() {
        return fileInsertTime;
    }

    public void setFileInsertTime(Date fileInsertTime) {
        this.fileInsertTime = fileInsertTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProbeId() {
        return probeId;
    }

    public void setProbeId(Integer probeId) {
        this.probeId = probeId;
    }

    public Long getFileSize() {

        
        return new Long(Math.round(fileSize/1024*1024*1024));
    }

    public void setFileSize(Long fileSize) {

        this.fileSize = fileSize;
    }

    public String getFtpPathAndName() {
        return ftpPathAndName;
    }

    public void setFtpPathAndName(String ftpPathAndName) {
        this.ftpPathAndName = ftpPathAndName == null ? null : ftpPathAndName.trim();
    }

    public Long getDownloadDuration() {
        return downloadDuration;
    }

    public void setDownloadDuration(Long downloadDuration) {
        this.downloadDuration = downloadDuration;
    }

    public Long getToHdfsDuration() {
        return toHdfsDuration;
    }

    public void setToHdfsDuration(Long toHdfsDuration) {
        this.toHdfsDuration = toHdfsDuration;
    }

    public Integer getEventTimeDayInt() {
        return eventTimeDayInt;
    }

    public void setEventTimeDayInt(Integer eventTimeDayInt) {
        this.eventTimeDayInt = eventTimeDayInt;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath == null ? null : hdfsPath.trim();
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public String getProbeName() {
        return probeName;
    }

    public void setProbeName(String probeName) {
        this.probeName = probeName;
    }
}