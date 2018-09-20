package com.ultrapower.dcs.cluster.control.model;

public class DcsDataType {
    private Integer dataTypeId;

    private String dataTypeName;

    private String dataTypePathReg;

    private Integer isFtpDelete;

    private Integer isFileDelete;

    private String hdfsPath;

    private String pathFtp;

    private String ftpIds;

    public Integer getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName == null ? null : dataTypeName.trim();
    }

    public String getDataTypePathReg() {
        return dataTypePathReg;
    }

    public void setDataTypePathReg(String dataTypePathReg) {
        this.dataTypePathReg = dataTypePathReg == null ? null : dataTypePathReg.trim();
    }

    public Integer getIsFtpDelete() {
        return isFtpDelete;
    }

    public void setIsFtpDelete(Integer isFtpDelete) {
        this.isFtpDelete = isFtpDelete;
    }

    public Integer getIsFileDelete() {
        return isFileDelete;
    }

    public void setIsFileDelete(Integer isFileDelete) {
        this.isFileDelete = isFileDelete;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath == null ? null : hdfsPath.trim();
    }

    public String getPathFtp() {
        return pathFtp;
    }

    public void setPathFtp(String pathFtp) {
        this.pathFtp = pathFtp == null ? null : pathFtp.trim();
    }

    public String getFtpIds() {
        return ftpIds;
    }

    public void setFtpIds(String ftpIds) {
        this.ftpIds = ftpIds;
    }
}