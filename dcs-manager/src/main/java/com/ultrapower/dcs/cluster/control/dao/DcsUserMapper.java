package com.ultrapower.dcs.cluster.control.dao;

import com.ultrapower.dcs.cluster.control.model.DcsUser;

import java.util.List;

/* *
 * @Title    
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/7/12  9:51
 **/
public interface DcsUserMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(DcsUser record);

    int insertSelective(DcsUser record);

    DcsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcsUser record);

    int updateByPrimaryKey(DcsUser record);

    List<DcsUser> selectAllUsers();

    /* *
     * @Title    根据条件查找某用户
     * @Description  
     * @Param     [loginname]
     * @Return   com.ultrapower.dcs.cluster.control.model.DcsUser
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:55
     **/
    List<DcsUser> selectUserByloginname(DcsUser record);

    /* *
     * @Title    
     * @Description  
     * @Param     [record]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsUser>
     * @throws      
     * @author   jinyi
     * @Date   2018/8/7  15:40
     **/
    List<DcsUser> selectUserWithNoByloginname (DcsUser record);
}