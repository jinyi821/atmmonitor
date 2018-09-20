package com.ultrapower.dcs.cluster.control.tools;

import java.util.Date;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.execShellResponse
 * @Title ssh、shell脚本执行体
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-27 10:25
 */
public class SshShellExecBody implements java.io.Serializable
{
   private static final long serialVersionUID = 1L;
   private String shellName;//shell名称
   private String shellCmd;//shell命令
   private String shellUses; //shell大用途大阶段
   private String shellSubUses; //shell小用途小阶段（属shell大用途大阶段中的子应用阶段），若shell大用途大阶段中就一个阶段，此内容与shellUses内容相同。
   private  Date shellExecTime; //shell执行时间
   private  Integer  resStatus; //响应状态，0正常，其它异常
   private  String resResult; //响应结果
   private  String resConclusion; //响应结论
   private  String resResultLevel="common"; //响应结果级别 success（green）、common（no）、warn(yellow、purple )、error(red)，根据业务页面区分显示设置

    //default
    public SshShellExecBody() {

    }

    //sshShell脚本执行请求体
    public SshShellExecBody(String shellName, String shellCmd, String shellUses, Date shellExecTime) {
        this.shellName = shellName;
        this.shellCmd = shellCmd;
        this.shellUses = shellUses;
        this.shellExecTime = shellExecTime;
    }

    //sshShell脚本执行响应体
    public SshShellExecBody(String shellName, String shellCmd, String shellUses, Date shellExecTime, Integer resStatus, String resResult, String resConclusion, String resResultLevel) {
        this.shellName = shellName;
        this.shellCmd = shellCmd;
        this.shellUses = shellUses;
        this.shellExecTime = shellExecTime;
        this.resStatus = resStatus;
        this.resResult = resResult;
        this.resConclusion = resConclusion;
        this.resResultLevel = resResultLevel;
    }

    public String getShellName() {
        return shellName;
    }

    public void setShellName(String shellName) {
        this.shellName = shellName;
    }

    public String getShellCmd() {
        return shellCmd;
    }

    public void setShellCmd(String shellCmd) {
        this.shellCmd = shellCmd;
    }

    public String getShellUses() {
        return shellUses;
    }

    public void setShellUses(String shellUses) {
        this.shellUses = shellUses;
    }

    public String getShellSubUses() {
        return shellSubUses;
    }

    public void setShellSubUses(String shellSubUses) {
        this.shellSubUses = shellSubUses;
    }

    public Date getShellExecTime() {
        return shellExecTime;
    }

    public void setShellExecTime(Date shellExecTime) {
        this.shellExecTime = shellExecTime;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public String getResResult() {
        return resResult;
    }

    public void setResResult(String resResult) {
        this.resResult = resResult;
    }

    public String getResConclusion() {
        return resConclusion;
    }

    public void setResConclusion(String resConclusion) {
        this.resConclusion = resConclusion;
    }

    public String getResResultLevel() {
        return resResultLevel;
    }

    public void setResResultLevel(String resResultLevel) {
        this.resResultLevel = resResultLevel;
    }
}