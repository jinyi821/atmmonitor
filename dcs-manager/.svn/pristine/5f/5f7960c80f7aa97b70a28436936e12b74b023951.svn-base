package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/26.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsScannerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.DcsDataTypeController
 * @Title DCS服务器配置
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-26 17:18
 */
@Controller
public class DcsFtpServerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsFtpServerServer  dcsFtpServerServer;
    @Autowired
    private DcsScannerServer  dcsScannerServer;
    /* *
    * @Title  配置列表
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/dcsFtpServer/")
    public String dcsFtpServer(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
                               @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
                               @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
                               ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===dcsDataType begin!! ===");
        List<DcsFtpServer> ftPserverList = dcsFtpServerServer.getFTPserverListForOne();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(ftPserverList, 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        List<DcsScanner> dcsScanners = dcsScannerServer.selectAllDcsScanner();
        map.put("pageInfo", pageInfo);
        map.put("dcsScanners", dcsScanners);
                                           
//        map.put("queryftl", "/dcs_ftp_Server/dcs_ftp_server_query.ftl");
//        map.put("scriptftl", "/dcs_ftp_Server/dcs_ftp_server_script.ftl");
//        map.put("tableftl", "/dcs_ftp_Server/dcs_ftp_server_table.ftl");
        map.put("formcontenturl", "/dcs_ftp_Server/dcs_ftp_server_modal_edit.ftl");
        map.put("isHasSaveButton", "true");
        map.put("pageSize",pageSize);
        return "dcs_ftp_Server/dcs_ftp_server";
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "dcs_ftp_Server/dcs_ftp_server_table";
//        }
        
    }

    /* *
     * @Title       安装id查询某个数据类型
     * @Description  
     * @Param     [id, map]
     * @Return   java.lang.String
     * @throws      
     * @author   jinyi
     * @Date   2018/6/27  10:44
     **/
    @RequestMapping(value = "/dcsFtpServer/select")
    public String selectDcsDataType(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

        logger.info("===selectDcsDataType begin!! ===");
        DcsFtpServer dcsFtpServer = dcsFtpServerServer.selectByPrimaryKey(id);
        map.put("dcsFtpServer", dcsFtpServer);
        return "dcsFtpServer/dcs_ftp_server";
    }
    
    /* *
     * @Title    插入某个FTP服务配置
     * @Description  
     * @Param     [dcsDataType]
     * @Return   java.lang.String
     * @throws      
     * @author   jinyi
     * @Date   2018/6/28  17:02
     **/
    @RequestMapping(value = "/dcsFtpServer/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDcsFtpServer(DcsFtpServer dcsFtpServer) {

        logger.info("===addDcsFtpServer begin!! ===");
        int i=0;
        if (dcsFtpServer.getFtpId()==-1) {
            dcsFtpServer.setFtpId(null);
             i = dcsFtpServerServer.insert(dcsFtpServer);
        } else {
            i = dcsFtpServerServer.updateByPrimaryKey(dcsFtpServer);
        }
        return String.valueOf(i);
    }
    /* *
     * @Title 按照ID 修改某个类型
     * @Description
     * @Param     [id, map]
     * @Return   java.lang.String
     * @throws
     * @author   jinyi
     * @Date   2018/6/27  10:44
     **/
    @RequestMapping(value = "/dcsFtpServer/update")
    @ResponseBody
        public String updateDcsFtpServer(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

            logger.info("===updateDcsDadcsFtpServertaType begin!! ===");
            DcsFtpServer dcsFtpServer = dcsFtpServerServer.selectByPrimaryKey(id);
            int i = dcsFtpServerServer.updateByPrimaryKey(dcsFtpServer);
            return String.valueOf(i);
        }

    /* *
     * @Title 按照ID 删除某个类型
     * @Description
     * @Param     [id, map]
     * @Return   java.lang.String
     * @throws
     * @author   jinyi
     * @Date   2018/6/27  10:44
     **/
    @RequestMapping(value = "/dcsFtpServer/delete")
    @ResponseBody
    public String deleteFtpServer(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

        logger.info("===deleteDcsDataType begin!! ===");
        int i = dcsFtpServerServer.deleteByPrimaryKey(id);
        map.put("success", i);
        return String.valueOf(i);
    }
}
