package com.ultrapower.dcs.cluster.control.service.impl;/**
 * Created by TMP246 on 2018/6/27.
 */

import com.ultrapower.dcs.cluster.control.dao.DcsDataTypeMapper;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsDataTypeServiceImpl
 * @Title 数据类型配置Service实现类
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-27 10:15
 */
@Service(value = "DcsDataTypeService")
@Transactional
public class DcsDataTypeServiceImpl implements DcsDataTypeService {

    @Autowired
    private DcsDataTypeMapper dcsDataTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer dataTypeId) {
        return dcsDataTypeMapper.deleteByPrimaryKey(dataTypeId);
    }

    @Override
    public int insert(DcsDataType record) {
        return dcsDataTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(DcsDataType record) {
        return dcsDataTypeMapper.insertSelective(record);
    }

    @Override
    public DcsDataType selectByPrimaryKey(Integer dataTypeId) {
        return dcsDataTypeMapper.selectByPrimaryKey(dataTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(DcsDataType record) {
        return dcsDataTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DcsDataType record) {
        return dcsDataTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<DcsDataType> getDcsDataTypeList() {
        return dcsDataTypeMapper.getDcsDataTypeList();
    }
}
