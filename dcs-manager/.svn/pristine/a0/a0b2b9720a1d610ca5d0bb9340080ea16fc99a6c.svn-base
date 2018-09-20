package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsTaskFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.DcsTaskFileService
 * @Title DCS任务文件服务接口
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-25 9:28
 */
public interface DcsTaskFileService {

    /* *
   * @Title   查询DcsProbe相关当前任务列表
   * @Description
   * @Param     [probe_id]
   * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsTaskFile>
   * @throws
   * @author   fanjianfeng
   * @Date   2018/6/25  9:26s
   **/
    public List<DcsTaskFile> findDcsProbeRelCurrentTaskList(Integer probe_id, Integer ftp_id, Integer data_type_id,Integer fileStatus,String fileName);

}
