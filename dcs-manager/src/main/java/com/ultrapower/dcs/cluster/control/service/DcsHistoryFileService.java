package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsHistoryFile;

import java.util.List;
import java.util.Map;

/* *
 * @Title    
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/6/19  16:25
 **/
public interface DcsHistoryFileService {

    /* *
     * @Title    
     * @Description  
     * @Param     [beginTime, endTime]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsHistoryFile>
     * @throws      
     * @author   jinyi
     * @Date   2018/6/20  14:41
     **/
    List<DcsHistoryFile> getDcsHistoryFileList(Integer beginTime, Integer endTime);
    
    /* *
     * @Title    
     * @Description  
     * @Param     [condition]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsHistoryFile>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/26  11:01
     **/
    List<DcsHistoryFile> getDcsHistoryFileList(Map condition);
    
}
