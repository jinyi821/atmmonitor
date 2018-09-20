package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.DcsProbeService
 * @Title DcsProbe服务方法接口
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-08 17:27
 */
public interface DcsProbeService {
     /* *
     * @Title  查询所有DcsProbe列表
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsProbe>
     * @throws      
     * @author   fanjianfeng
     * @Date   2018/6/8  17:28
     **/
    public    List<DcsProbe> findAllDcsProbeList();

}
