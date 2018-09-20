package com.ultrapower.dcs.cluster.control.service.impl;

import com.ultrapower.dcs.cluster.control.dao.DcsFtpServerMapper;
import com.ultrapower.dcs.cluster.control.dao.DcsScannerMapper;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by TMP246 on 2018/6/4.
 */
@Service(value = "dcsFtpServerServer")
@Transactional
public class DcsFtpServerServerImpl implements DcsFtpServerServer {

    @Autowired
    private DcsFtpServerMapper dcsFtpServerMapper;

    @Autowired
    private DcsScannerMapper dcsScannerMapper;

    /* *
     * @Title    
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpServer>
     * @throws      
     * @author   jinyi
     * @Date   2018/6/12  17:48
     **/
    @Override
    public List<DcsFtpServer> getFTPserverList() {


        List<DcsFtpServer> list = dcsFtpServerMapper.getFTPserverList();

        return list;

    }
    /* *
     * @Title
     * @Description
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpServer>
     * @throws
     * @author   jinyi
     * @Date   2018/6/12  17:48
     **/
    @Override
    public List<DcsFtpServer> getFTPserverListForNone() {


        List<DcsFtpServer> list = dcsFtpServerMapper.getFTPserverListForNone();

        return list;

    }

    @Override
    public int updateByPrimaryKey(DcsFtpServer record) {
        return dcsFtpServerMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer ftpId) {
        return dcsFtpServerMapper.deleteByPrimaryKey(ftpId);
    }

    @Override                     
    public int insert(DcsFtpServer record) {
        return dcsFtpServerMapper.insert(record);
    }

    @Override
    public DcsFtpServer selectByPrimaryKey(Integer id) {
        return dcsFtpServerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DcsFtpServer> getFTPserverListForOne() {
        return dcsFtpServerMapper.getFTPserverListForOne();
    }

    @Override
    public List<DcsScanner> selectAllDcsScanner() {
        return dcsScannerMapper.selectAllDcsScanner();
    }
}
