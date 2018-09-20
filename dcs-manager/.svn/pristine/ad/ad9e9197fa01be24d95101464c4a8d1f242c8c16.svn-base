package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsScanner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "dcsScannerMapper")
public interface DcsScannerMapper {
    int deleteByPrimaryKey(Integer scannerId);

    int insert(DcsScanner record);

    int insertSelective(DcsScanner record);

    DcsScanner selectByPrimaryKey(Integer scannerId);

    int updateByPrimaryKeySelective(DcsScanner record);

    int updateByPrimaryKey(DcsScanner record);
    List<DcsScanner> selectAllDcsScanner();
}