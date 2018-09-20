package com.ultrapower.dcs.cluster.control.model;

import com.ultrapower.dcs.cluster.control.utils.CodeEnumUtil;
import com.ultrapower.dcs.cluster.control.utils.DcsFileStatusEnum;

import java.util.Date;

public class DcsTaskFile implements java.io.Serializable
{
    //DCS任务文件
    private static final long serialVersionUID = 1L;

    private Integer file_id; //文件ID
    private Integer ftp_id; //FtpId
    private Integer data_type_id; // 文件数据类别ID
    private String path_and_name; //本地文件路径及名称
    private String rename_file_name; //本地文件更改后的名称
    private Date file_insert_time; //文件插入时间
    private Integer status; //0：已经下发到probe但没有下载完成。1：下载完成但没有执行上传hdfs。2：上传hdfs成功。3：上传hdfs失败。4：正在执行hdfs上传但没有上传完毕。
    private Integer probe_id; //probeID
    private Long file_size; //文件大小 单位字节
    private String ftp_path_and_name; //文件在ftp端的路径和名称
    private Long download_duration; //下载时长(ms)
    private String hdfs_path; //文件存储HDFS路径

    //以下查询扩展属性字段
    private String ftp_ip; //ftp服务器IP
    private String data_type_name;//文件数据类型名称
    private String probe_name; //probe名称


    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    public Integer getFtp_id() {
        return ftp_id;
    }

    public void setFtp_id(Integer ftp_id) {
        this.ftp_id = ftp_id;
    }

    public Integer getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(Integer data_type_id) {
        this.data_type_id = data_type_id;
    }

    public String getPath_and_name() {
        return path_and_name;
    }

    public void setPath_and_name(String path_and_name) {
        this.path_and_name = path_and_name == null ? null : path_and_name.trim();
    }

    public String getRename_file_name() {
        return rename_file_name;
    }

    public void setRename_file_name(String rename_file_name) {
        this.rename_file_name = rename_file_name == null ? null : rename_file_name.trim();
    }

    public Date getFile_insert_time() {
        return file_insert_time;
    }

    public void setFile_insert_time(Date file_insert_time) {
        this.file_insert_time = file_insert_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProbe_id() {
        return probe_id;
    }

    public void setProbe_id(Integer probe_id) {
        this.probe_id = probe_id;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public String getFtp_path_and_name() {
        return ftp_path_and_name;
    }

    public void setFtp_path_and_name(String ftp_path_and_name) {
        this.ftp_path_and_name = ftp_path_and_name == null ? null : ftp_path_and_name.trim();
    }

    public Long getDownload_duration() {
        return download_duration;
    }

    public void setDownload_duration(Long download_duration) {
        this.download_duration = download_duration;
    }

    public String getHdfs_path() {
        return hdfs_path;
    }

    public void setHdfs_path(String hdfs_path) {
        this.hdfs_path = hdfs_path == null ? null : hdfs_path.trim();
    }

    public String getFtp_ip() {
        return ftp_ip;
    }

    public void setFtp_ip(String ftp_ip) {
        this.ftp_ip = ftp_ip;
    }

    public String getData_type_name() {
        return data_type_name;
    }

    public void setData_type_name(String data_type_name) {
        this.data_type_name = data_type_name;
    }

    public String getProbe_name() {
        return probe_name;
    }

    public void setProbe_name(String probe_name) {
        this.probe_name = probe_name;
    }

    public DcsFileStatusEnum getDcsFileStatusEnum(){
        return CodeEnumUtil.getByCode(status,DcsFileStatusEnum.class);
    }

}