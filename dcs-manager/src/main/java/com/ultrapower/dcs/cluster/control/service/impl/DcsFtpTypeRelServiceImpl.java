package com.ultrapower.dcs.cluster.control.service.impl;/**
 * Created by TMP246 on 2018/7/6.
 */

import com.ultrapower.dcs.cluster.control.dao.DcsDataTypeMapper;
import com.ultrapower.dcs.cluster.control.dao.DcsFtpTypeRelMapper;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;
import com.ultrapower.dcs.cluster.control.service.DcsFtpTypeRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsFtpTypeRelServiceImpl
 * @Title 对dcs_ftp_type_rel操作实现类
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-07-06 15:02
 */
@Service(value = "dcsFtpTypeRelService")
@Transactional
public class DcsFtpTypeRelServiceImpl implements DcsFtpTypeRelService {

    @Autowired
    private DcsFtpTypeRelMapper dcsFtpTypeRelMapper;

    @Autowired
    private DcsDataTypeMapper dcsDataTypeMapper;
    @Override
    public int insert(DcsFtpTypeRel record) {
        return dcsFtpTypeRelMapper.insert(record);
    }

    @Override
    public List<DcsFtpTypeRel> getDcsFtpTypeRelList() {
        return dcsFtpTypeRelMapper.getDcsFtpTypeRelList();
    }

    @Override
    public List<DcsFtpTypeRel> getDcsFtpRelListByCondition(Map condition) {
        return dcsFtpTypeRelMapper.getDcsFtpTypeRelListByCondition(condition);
    }

    @Override
    public int deleteDcsFtpTypeRel(DcsFtpTypeRel record) {
        return dcsFtpTypeRelMapper.deleteDcsFtpTypeRel(record);
    }

    @Override
    public int updateDcsFtpTypeRel(DcsFtpTypeRel record) {
        return dcsFtpTypeRelMapper.updateDcsFtpTypeRel(record);
    }

    @Override
    public List<DcsDataType> getDcsDataTypeListForRest(Integer ftpId) {
        return dcsDataTypeMapper.getDcsDataTypeListForRest(ftpId);
    }

    @Override
    public List<DcsFtpTypeRel> getFtpServerWithSelect(Map condition) {
        return dcsFtpTypeRelMapper.getFtpServerWithSelect(condition);
    }

}
