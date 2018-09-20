package com.ultrapower.dcs.cluster.control.service.impl;

import com.ultrapower.dcs.cluster.control.dao.DcsFtpServerMapper;
import com.ultrapower.dcs.cluster.control.dao.DcsScannerMapper;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;
import com.ultrapower.dcs.cluster.control.service.DcsScannerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by TMP246 on 2018/6/4.
 */
@Service(value = "dcsScannerServer")
@Transactional
public class DcsScannerServerImpl implements DcsScannerServer {
   

    @Autowired
    private DcsScannerMapper dcsScannerMapper;

    @Override
    public List<DcsScanner> selectAllDcsScanner() {
        return dcsScannerMapper.selectAllDcsScanner();
    }

    @Override
    public DcsScanner selectByPrimaryKey(Integer scannerId) {
        return dcsScannerMapper.selectByPrimaryKey(scannerId);
    }
}
