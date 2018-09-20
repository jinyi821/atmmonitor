package com.ultrapower.dcs.cluster.control.service.impl;/**
 * Created by TMP246 on 2018/6/19.
 */

import com.ultrapower.dcs.cluster.control.dao.DcsHistoryFileMapper;
import com.ultrapower.dcs.cluster.control.model.DcsHistoryFile;
import com.ultrapower.dcs.cluster.control.service.DcsHistoryFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsHistoryFileServiceImpl
 * @Title 采集历史文件列表
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-19 16:26
 */
@Service(value = "dcsHistoryFileService")
public class DcsHistoryFileServiceImpl implements DcsHistoryFileService {

    @Autowired
    private DcsHistoryFileMapper dcsHistoryFileMapper ;
    @Override
    public List<DcsHistoryFile> getDcsHistoryFileList(Integer beginTime, Integer endTime) {
        return dcsHistoryFileMapper.getDcsHistoryFileList(beginTime, endTime);
    }

    /* *
     * @Title    按条件查询历史采集文件
     * @Description  
     * @Param     [condition]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsHistoryFile>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/26  11:03
     **/
    @Override
    public List<DcsHistoryFile> getDcsHistoryFileList(Map condition) {
        return dcsHistoryFileMapper.getDcsHistoryFileListForConditin(condition);
    }
}
