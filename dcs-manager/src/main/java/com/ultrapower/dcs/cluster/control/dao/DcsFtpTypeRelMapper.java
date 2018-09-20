package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/* *
 * @Title  对dcs_ftp_type_rel 增删改查
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/7/6  14:52
 **/
@Repository(value = "dcsFtpTypeRelMapper")
public interface DcsFtpTypeRelMapper {
    int insert(DcsFtpTypeRel record);

    int insertSelective(DcsFtpTypeRel record);

    List<DcsFtpTypeRel> getDcsFtpTypeRelList();

    int deleteDcsFtpTypeRel(DcsFtpTypeRel record);

    int updateDcsFtpTypeRel(DcsFtpTypeRel record);

    List<DcsFtpTypeRel>  getDcsFtpTypeRelListByCondition(Map condition);
    List<DcsFtpTypeRel>  getFtpServerWithSelect(Map condition);
    
   
    
}