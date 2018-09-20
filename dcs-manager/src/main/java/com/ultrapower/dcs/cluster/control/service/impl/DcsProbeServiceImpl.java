package com.ultrapower.dcs.cluster.control.service.impl;

import com.ultrapower.dcs.cluster.control.dao.DcsProbeMapper;
import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.model.TestModel;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsProbeServiceImpl
 * @Title DcsProbe服务方法接口实现类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-08 17:30
 */
@Service("dcsProbeService")
public class DcsProbeServiceImpl implements DcsProbeService {
    @Autowired
    public DcsProbeMapper dcsProbeMapper;
    @Override
    public List<DcsProbe> findAllDcsProbeList() {
        List<DcsProbe> dcsProbeList=dcsProbeMapper.findAllDcsProbeList();
        return dcsProbeList;
    }



}
