package com.ultrapower.dcs.cluster.control.service.impl;

import com.ultrapower.dcs.cluster.control.dao.DcsFailureFileMapper;
import com.ultrapower.dcs.cluster.control.model.DcsFailureFile;
import com.ultrapower.dcs.cluster.control.service.DcsFailureFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsFailureFileServiceImpl
 * @Title DCS失败文件服务接口实现类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-25 15:38
 */
@Service("dcsFailureFileService")
public class DcsFailureFileServiceImpl implements DcsFailureFileService {
    @Autowired
    private DcsFailureFileMapper  dcsFailureFileMapper;
    /* *
     * @Title  查询DCS失败文件列表
     * @Description
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFailureFile>
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/25  15:27
     **/
    public List<DcsFailureFile> findDcsFailureFileList(Integer probe_id,Integer ftp_id,Integer data_type_id,Integer fileStatus,String fileName){
        List<DcsFailureFile>   dcsFailureFileList=dcsFailureFileMapper.findDcsFailureFileList(probe_id,ftp_id,data_type_id,fileStatus,fileName);
        return dcsFailureFileList;
    }

}
