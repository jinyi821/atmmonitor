package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsHistoryFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/* *
 * @Title    采集历史文件
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/6/20  11:43
 **/
@Repository(value = "dcsHistoryFileMapper")
public interface DcsHistoryFileMapper {
    int insert(DcsHistoryFile record);

    int insertSelective(DcsHistoryFile record);

    /* *
     * @Title  得到采集历史文件列表
     * @Description
     * @Param     [beginTime, endTime]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsHistoryFile>
     * @throws
     * @author   jinyi
     * @Date   2018/6/20  11:43
     **/
    List<DcsHistoryFile> getDcsHistoryFileList(@Param("beginTime") Integer beginTime, @Param("endTime") Integer endTime);

    /* *
    * @Title  得到采集历史文件列表
    * @Description
    * @Param     [beginTime, endTime]
    * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsHistoryFile>
    * @throws
    * @author   jinyi
    * @Date   2018/6/20  11:43
    **/
    List<DcsHistoryFile> getDcsHistoryFileListForConditin(Map condition);
}