package com.ultrapower.dcs.cluster.control.tools;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.tools.SshBatchShellExecResBody
 * @Title ssh批量脚本执行相应体对象
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-24 10:46
 */
public class SshBatchShellExecResBody {

    public List<SshShellExecBody> shellExecList; //shell脚本执行集合对象
    public Boolean  batchExecResultFlag; //批量执行结果flag,是批量执行成功还是执行失败啦

    public SshBatchShellExecResBody() {
    }

    public SshBatchShellExecResBody(Boolean batchExecResultFlag, List<SshShellExecBody> shellExecList) {
        this.batchExecResultFlag = batchExecResultFlag;
        this.shellExecList = shellExecList;
    }

    public List<SshShellExecBody> getShellExecList() {
        return shellExecList;
    }

    public void setShellExecList(List<SshShellExecBody> shellExecList) {
        this.shellExecList = shellExecList;
    }

    public Boolean getBatchExecResultFlag() {
        return batchExecResultFlag;
    }

    public void setBatchExecResultFlag(Boolean batchExecResultFlag) {
        this.batchExecResultFlag = batchExecResultFlag;
    }
}
