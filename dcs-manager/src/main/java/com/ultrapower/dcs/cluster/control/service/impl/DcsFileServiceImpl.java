package com.ultrapower.dcs.cluster.control.service.impl;/**
 * Created by TMP246 on 2018/7/16.
 */

import com.ultrapower.dcs.cluster.control.dao.DcsFileMapper;
import com.ultrapower.dcs.cluster.control.model.DcsFile;
import com.ultrapower.dcs.cluster.control.service.DcsFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsFileServiceImpl
 * @Title 对FTP文件相关操作
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-07-16 9:46
 */
@Service("dcsFileService")
public class DcsFileServiceImpl implements DcsFileService {
    
    @Autowired
    private DcsFileMapper  dcsFileMappercs;
    @Override
    public List<DcsFile> selectListByFTPId(Integer ftpId) {
        return dcsFileMappercs.selectListByFTPId(ftpId);
    }

    /* *
     * @Title   按 查询条件 查询数据文件
     * @Description
     * @Param     [condition]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFile>
     * @throws
     * @author   jinyi
     * @Date   2018/7/19  15:26
     **/
    public List<DcsFile> selectListByFTPAndDataType(Map condition){
        return  dcsFileMappercs.selectListByFTPAndDataType(condition);
    }
}
