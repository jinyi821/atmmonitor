package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "dcsDataTypeMapper")
public interface DcsDataTypeMapper {
    
    int deleteByPrimaryKey(Integer dataTypeId);

    int insert(DcsDataType record);

    int insertSelective(DcsDataType record);

    DcsDataType selectByPrimaryKey(Integer dataTypeId);

    int updateByPrimaryKeySelective(DcsDataType record);

    int updateByPrimaryKey(DcsDataType record);

    /* *
     * @Title   查询所有数据类型配置
     * @Description
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsDataType>
     * @throws
     * @author   jinyi
     * @Date   2018/6/27  10:09
     **/
    List<DcsDataType> getDcsDataTypeList();

    List<DcsDataType> getDcsDataTypeListForRest(Integer ftpId);
}