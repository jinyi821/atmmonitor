package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsFailureFile;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.DcsFailureFileService
 * @Title DCS失败文件列表服务接口
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-25 15:28
 */
public interface DcsFailureFileService {

    /* *
      * @Title  查询DCS失败文件列表
      * @Description
      * @Param     []
      * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFailureFile>
      * @throws
      * @author   fanjianfeng
      * @Date   2018/6/25  15:27
      **/
    public List<DcsFailureFile> findDcsFailureFileList(Integer probe_id,Integer ftp_id,Integer data_type_id,Integer fileStatus,String fileName);

}
