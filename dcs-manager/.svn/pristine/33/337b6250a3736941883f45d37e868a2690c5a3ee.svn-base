package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "dcsFtpServerMapper")
public interface DcsFtpServerMapper {
    int deleteByPrimaryKey(Integer ftpId);

    int insert(DcsFtpServer record);

    int insertSelective(DcsFtpServer record);

    DcsFtpServer selectByPrimaryKey(Integer ftpId);

    int updateByPrimaryKeySelective(DcsFtpServer record);

    int updateByPrimaryKey(DcsFtpServer record);

    List<DcsFtpServer> getFTPserverList();
    List<DcsFtpServer> getFTPserverListForOne();
    List<DcsFtpServer> getFTPserverListForNone();
   
}