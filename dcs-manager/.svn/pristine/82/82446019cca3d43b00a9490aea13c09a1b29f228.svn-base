package com.ultrapower.dcs.cluster.control.model;

import java.util.Date;

public class DcsFile {
    private Long fileId;

    private Integer ftpId;

    private Integer dataTypeId;

    private String pathAndName;

    private String renameFileName;

    private Date fileIntime;

    private Long fileSize;

    private Integer source;

    private String hdfsPath;
    private String  dataTypeName;
    private DcsDataType dcsDataType;
    private DcsFtpServer dcsFtpServer;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
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

    public Date getFileIntime() {
        return fileIntime;
    }

    public void setFileIntime(Date fileIntime) {
        this.fileIntime = fileIntime;
    }

    public Long getFileSize() {
        if (fileSize!=null)
            fileSize =new Long(Math.round(fileSize/(1024*1024*1024)));
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public DcsDataType getDcsDataType() {
        return dcsDataType;
    }

    public void setDcsDataType(DcsDataType dcsDataType) {
        this.dcsDataType = dcsDataType;
    }

    public DcsFtpServer getDcsFtpServer() {
        return dcsFtpServer;
    }

    public void setDcsFtpServer(DcsFtpServer dcsFtpServer) {
        this.dcsFtpServer = dcsFtpServer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DcsFile{");
        sb.append("fileId=").append(fileId);
        sb.append(", ftpId=").append(ftpId);
        sb.append(", dataTypeId=").append(dataTypeId);
        sb.append(", pathAndName='").append(pathAndName).append('\'');
        sb.append(", renameFileName='").append(renameFileName).append('\'');
        sb.append(", fileIntime=").append(fileIntime);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", source=").append(source);
        sb.append(", hdfsPath='").append(hdfsPath).append('\'');
        sb.append(", dataTypeName='").append(dataTypeName).append('\'');
        sb.append(", dcsDataType=").append(dcsDataType);
        sb.append(", dcsFtpServer=").append(dcsFtpServer);
        sb.append('}');
        return sb.toString();
    }
}