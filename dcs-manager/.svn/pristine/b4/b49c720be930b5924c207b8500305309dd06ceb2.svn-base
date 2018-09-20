package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsFailureFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import static javafx.scene.input.KeyCode.L;

public interface DcsFailureFileMapper {
    int insert(DcsFailureFile record);
    int insertSelctive(DcsFailureFile record);

    /* *
     * @Title  查询DCS失败文件列表
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFailureFile>
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/6/25  15:27
     **/
    public List<DcsFailureFile> findDcsFailureFileList(@Param("probe_id")Integer probe_id,@Param("ftp_id")Integer ftp_id,@Param("data_type_id")Integer data_type_id,@Param("fileStatus")Integer fileStatus,@Param("fileName")String fileName);



}