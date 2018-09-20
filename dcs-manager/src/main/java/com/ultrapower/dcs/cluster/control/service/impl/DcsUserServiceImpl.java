package com.ultrapower.dcs.cluster.control.service.impl;/**
 * Created by TMP246 on 2018/7/11.
 */

import com.ultrapower.dcs.cluster.control.dao.DcsUserMapper;
import com.ultrapower.dcs.cluster.control.model.DcsUser;
import com.ultrapower.dcs.cluster.control.service.DcsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.service.impl.DcsUserServiceImpl
 * @Title 用户信息维护
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-07-11 12:01
 */
@Service(value = "dcsUserService")
@Transactional
public class DcsUserServiceImpl implements DcsUserService {
     
    @Autowired
    private DcsUserMapper dcsUserMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dcsUserMapper.deleteByPrimaryKey(id);
    }

    /* *
     * @Title    
     * @Description  
     * @Param     [record]
     * @Return   int
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:55
     **/
    @Override
    public int insert(DcsUser record) {
        return dcsUserMapper.insert(record);
    }

    /* *
     * @Title    
     * @Description  
     * @Param     [id]
     * @Return   com.ultrapower.dcs.cluster.control.model.DcsUser
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:52
     **/
    @Override
    public DcsUser selectByPrimaryKey(Integer id) {
        return dcsUserMapper.selectByPrimaryKey(id);
    }

    /* *
     * @Title    
     * @Description  
     * @Param     [record]
     * @Return   int
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:52
     **/
    @Override
    public int updateByPrimaryKey(DcsUser record) {
        return dcsUserMapper.updateByPrimaryKey(record);
    }

    /* *
     * @Title    
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsUser>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:52
     **/
    @Override
    public List<DcsUser> selectAllUsers() {
        return dcsUserMapper.selectAllUsers();
    }

    /* *
     * @Title    
     * @Description  
     * @Param     [loginname]
     * @Return   com.ultrapower.dcs.cluster.control.model.DcsUser
     * @throws      
     * @author   jinyi
     * @Date   2018/7/13  10:51
     **/
    @Override
    public List<DcsUser> selectUserByloginname(DcsUser record){
        return dcsUserMapper.selectUserByloginname(record);
    }

    @Override
    public List<DcsUser> selectUserWithNoByloginname(DcsUser record) {
        return dcsUserMapper.selectUserWithNoByloginname(record);
    }
}
