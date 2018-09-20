package com.ultrapower.dcs.cluster.control.model;

/* *
 * @Title    
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/6/14  11:24
 **/
public class DcsFtpServer {
    private Integer ftpId;

    private String ftpIp;

    private Integer ftpPort;

    private String ftpUserName;

    private String ftpPassword;

    private String ftpWorkDirectory;

    private Long ftpLastScanTime;

    private Integer ftpPeriod;

    private Integer ftpScannerId;

    private String scannerIp;

    private Long ftpLastServerTime;

    private String pathFtp;

    private String pathReg;

    public Integer getFtpId() {
        return ftpId;
    }

    public void setFtpId(Integer ftpId) {
        this.ftpId = ftpId;
    }

    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp == null ? null : ftpIp.trim();
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName == null ? null : ftpUserName.trim();
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword == null ? null : ftpPassword.trim();
    }

    public String getFtpWorkDirectory() {
        return ftpWorkDirectory;
    }

    public void setFtpWorkDirectory(String ftpWorkDirectory) {
        this.ftpWorkDirectory = ftpWorkDirectory == null ? null : ftpWorkDirectory.trim();
    }

    public Long getFtpLastScanTime() {
        return ftpLastScanTime;
    }

    public void setFtpLastScanTime(Long ftpLastScanTime) {
        this.ftpLastScanTime = ftpLastScanTime;
    }

    public Integer getFtpPeriod() {
        return ftpPeriod;
    }

    public void setFtpPeriod(Integer ftpPeriod) {
        this.ftpPeriod = ftpPeriod;
    }

    public Integer getFtpScannerId() {
        return ftpScannerId;
    }

    public void setFtpScannerId(Integer ftpScannerId) {
        this.ftpScannerId = ftpScannerId;
    }

    public Long getFtpLastServerTime() {
        return ftpLastServerTime;
    }

    public void setFtpLastServerTime(Long ftpLastServerTime) {
        this.ftpLastServerTime = ftpLastServerTime;
    }

    public String getPathFtp() {
        return pathFtp;
    }

    public void setPathFtp(String pathFtp) {
        this.pathFtp = pathFtp;
    }

    public String getScannerIp() {
        return scannerIp;
    }

    public void setScannerIp(String scannerIp) {
        this.scannerIp = scannerIp;
    }

    public String getPathReg() {
        return pathReg;
    }

    public void setPathReg(String pathReg) {
        this.pathReg = pathReg;
    }


}