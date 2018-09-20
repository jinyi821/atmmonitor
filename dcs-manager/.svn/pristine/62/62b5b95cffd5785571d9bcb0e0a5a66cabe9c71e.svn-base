package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsTaskFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DcsTaskFileMapper {
    int deleteByPrimaryKey(Integer file_id);

    int insert(DcsTaskFile record);

    int insertSelective(DcsTaskFile record);

    DcsTaskFile selectByPrimaryKey(Integer file_id);

    int updateByPrimaryKeySelective(DcsTaskFile record);

    int updateByPrimaryKey(DcsTaskFile record);

   /* *
  * @Title   查询DcsProbe相关当前任务列表
  * @Description
  * @Param     [probe_id]
  * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsTaskFile>
  * @throws
  * @author   fanjianfeng
  * @Date   2018/6/25  9:26
  **/
    public List<DcsTaskFile>  findDcsProbeRelCurrentTaskList(@Param("probe_id")Integer probe_id, @Param("ftp_id")Integer ftp_id, @Param("data_type_id")Integer data_type_id,@Param("fileStatus")Integer fileStatus, @Param("fileName")String fileName);
}