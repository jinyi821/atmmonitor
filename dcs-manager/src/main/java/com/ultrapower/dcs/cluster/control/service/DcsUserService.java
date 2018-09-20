package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsUser;

import java.util.List;

/**
 * Created by TMP246 on 2018/7/11.
 */
public interface DcsUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(DcsUser record);

    DcsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DcsUser record);

    List<DcsUser> selectAllUsers();

    List<DcsUser> selectUserByloginname(DcsUser record);

    List<DcsUser> selectUserWithNoByloginname (DcsUser record);
}
