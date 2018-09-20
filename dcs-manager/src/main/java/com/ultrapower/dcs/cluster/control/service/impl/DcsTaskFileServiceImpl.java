package com.ultrapower.dcs.cluster.control.service.impl;

import com.ultrapower.dcs.cluster.control.dao.DcsTaskFileMapper;
import com.ultrapower.dcs.cluster.control.dao.TestModelDaoMapper;
import com.ultrapower.dcs.cluster.control.model.DcsTaskFile;
import com.ultrapower.dcs.cluster.control.service.DcsTaskFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsTaskFileServiceImpl
 * @Title DCS任务文件服务接口实现类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-25 9:30
 */
@Service("dcsTaskFileService")
public class DcsTaskFileServiceImpl implements DcsTaskFileService {
    @Autowired
    private DcsTaskFileMapper dcsTaskFileMapper;

    @Override
    public List<DcsTaskFile> findDcsProbeRelCurrentTaskList(Integer probe_id,Integer ftp_id,Integer data_type_id,Integer fileStatus,String fileName) {
        List<DcsTaskFile>  dcsProbeCurrentTaskList=dcsTaskFileMapper.findDcsProbeRelCurrentTaskList(probe_id,ftp_id,data_type_id,fileStatus,fileName);
        return dcsProbeCurrentTaskList;
    }
}
