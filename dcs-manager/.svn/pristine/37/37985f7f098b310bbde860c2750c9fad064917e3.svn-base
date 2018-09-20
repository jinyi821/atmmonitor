package com.ultrapower.dcs.cluster.control.service;

import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;

import java.util.List;

/**
 * Created by TMP246 on 2018/6/4.
 */
public interface DcsFtpServerServer {

    /* *
     * @Title    查询服务器配置列表
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpServer>
     * @throws      
     * @author   jinyi
     * @Date   2018/6/12  17:47
     **/
    List<DcsFtpServer> getFTPserverListForNone();

    /* *
     * @Title    查询服务器配置列表
     * @Description
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpServer>
     * @throws
     * @author   jinyi
     * @Date   2018/6/12  17:47
     **/
    List<DcsFtpServer> getFTPserverList();

    /* *
     * @Title   修改服务器配置
     * @Description  
     * @Param     [record]
     * @Return   int
     * @throws      
     * @author   jinyi
     * @Date   2018/7/2  11:35
     **/
    int updateByPrimaryKey(DcsFtpServer record);

    /* *
     * @Title    删除服务器配置
     * @Description  
     * @Param     [ftpId]
     * @Return   int
     * @throws      
     * @author   jinyi
     * @Date   2018/7/2  11:37
     **/
    int deleteByPrimaryKey(Integer ftpId);

    /* *
     * @Title    
     * @Description  
     * @Param     [record]
     * @Return   int
     * @throws      
     * @author   jinyi
     * @Date   2018/7/2  11:49
     **/
    int insert(DcsFtpServer record);
    
    /* *
     * @Title    
     * @Description  
     * @Param     [dataTypeId]
     * @Return   com.ultrapower.dcs.cluster.control.model.DcsDataType
     * @throws      
     * @author   jinyi
     * @Date   2018/7/2  14:07
     **/
    DcsFtpServer selectByPrimaryKey(Integer id);

    /* *
     * @Title    
     * @Description  
     * @Param     []
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpServer>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/2  15:38
     **/
    List<DcsFtpServer> getFTPserverListForOne();

    List<DcsScanner> selectAllDcsScanner();
}
