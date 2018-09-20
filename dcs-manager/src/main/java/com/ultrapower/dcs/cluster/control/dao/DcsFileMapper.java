package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsFile;

import java.util.List;
import java.util.Map;

public interface DcsFileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(DcsFile record);

    int insertSelective(DcsFile record);

    DcsFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(DcsFile record);

    int updateByPrimaryKey(DcsFile record);

    List<DcsFile> selectListByFTPId(Integer ftpId);
   
    /* *
     * @Title   按 查询条件 查询数据文件
     * @Description  
     * @Param     [condition]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFile>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/19  15:26
     **/
    List<DcsFile> selectListByFTPAndDataType(Map condition);
    
}