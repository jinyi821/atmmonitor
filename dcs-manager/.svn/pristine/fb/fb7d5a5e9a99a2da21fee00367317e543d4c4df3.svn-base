package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;

import java.util.List;
import java.util.Map;

/**
 * Created by TMP246 on 2018/7/6.
 */
public interface DcsFtpTypeRelService {

    int insert(DcsFtpTypeRel record);

    List<DcsFtpTypeRel> getDcsFtpTypeRelList();
    
    List<DcsFtpTypeRel>  getDcsFtpRelListByCondition(Map condition);

    int deleteDcsFtpTypeRel(DcsFtpTypeRel record);

    int updateDcsFtpTypeRel(DcsFtpTypeRel record);

    List<DcsDataType> getDcsDataTypeListForRest(Integer ftpId);

    List<DcsFtpTypeRel>  getFtpServerWithSelect(Map condition);

}
