package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsProbe;

import java.util.List;

public interface DcsProbeMapper {
    int deleteByPrimaryKey(Integer probe_id);

    int insert(DcsProbe record);

    int insertSelective(DcsProbe record);

    DcsProbe selectByPrimaryKey(Integer probe_id);

    int updateByPrimaryKeySelective(DcsProbe record);

    int updateByPrimaryKey(DcsProbe record);

    /* *
* @Title  查询所有DcsProbe列表
* @Description
* @Param     []
* @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsProbe>
* @throws
* @author   fanjianfeng
* @Date   2018/6/8  17:28
**/
    public List<DcsProbe> findAllDcsProbeList();
}