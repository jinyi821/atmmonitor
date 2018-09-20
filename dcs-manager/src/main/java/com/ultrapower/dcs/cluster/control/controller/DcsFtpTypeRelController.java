package com.ultrapower.dcs.cluster.control.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsFtpTypeRelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 * @Title 对dcs_ftp_type_re 增删改查
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/7/6  15:20
 **/
@Controller
public class DcsFtpTypeRelController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsFtpTypeRelService dcsFtpTypeRelService ;
    @Autowired
    private DcsFtpServerServer  dcsFtpServerServer;

    @Autowired
    private DcsDataTypeService dcsDataTypeService;

    /* *
    * @Title  配置列表
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/dcsFtpTypeRel/")
    public String dcsFtpTypeRel(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
                                @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
                                @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
                                @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
                                @RequestParam(required = false, defaultValue = "-1", value = "enabled") Integer enabled,
    ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===dcsFtpTypeRel begin!! ===");
        Map condition = new HashMap();

        if (ftpId != -1) {
            condition.put("ftpId", ftpId);
        }
        if (dataTypeId != -1) {
            condition.put("dataTypeId", dataTypeId);
        }
        if (enabled != -1) {
            condition.put("enabled", enabled);
        }

        List<DcsFtpTypeRel> dcsFtpTypeRelList = dcsFtpTypeRelService.getDcsFtpRelListByCondition(condition);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsFtpTypeRelList, 10);

        List<DcsFtpServer> ftPserverList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();

        map.put("pageInfo", pageInfo);
        map.put("ftPserverList", ftPserverList);
        map.put("dcsDataTypeList", dcsDataTypeList);
        map.put("queryftl", "/dcs_ftp_typerel/dcs_ftp_typerel_query.ftl");
        map.put("scriptftl", "/dcs_ftp_typerel/dcs_ftp_typerel_script.ftl");
        map.put("tableftl", "/dcs_ftp_typerel/dcs_ftp_typerel_table.ftl");
        map.put("formcontenturl", "/dcs_ftp_typerel/dcs_ftp_typerel_detail.ftl");
        map.put("isHasSaveButton", "true");
        map.put("messageModaltitle", "确定要删除该配置？删除后不可恢复！");

        if (refreshPart == 0) {
            return "common";
        } else {
            return "dcs_ftp_typerel/dcs_ftp_typerel_table";
        }

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
    @RequestMapping(value = "/dcsFtpTypeRel/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDcsFtpTypeRel(DcsFtpTypeRel dcsFtpTypeRel) {

        logger.info("===addDcsFtpTypeRel begin!! ===");
        int i=0;
        if (dcsFtpTypeRel.getId()==-1) {
            
             i = dcsFtpTypeRelService.insert(dcsFtpTypeRel);
        } else {
            i = dcsFtpTypeRelService.updateDcsFtpTypeRel(dcsFtpTypeRel);
        }
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
    @RequestMapping(value = "/dcsFtpTypeRel/delete")
    @ResponseBody
    public String deleteDcsFtpTypeRel(DcsFtpTypeRel record, ModelMap map) {

        logger.info("===deleteDcsDataType begin!! ===");
        int i = dcsFtpTypeRelService.deleteDcsFtpTypeRel(record);
        map.put("success", i);
        return String.valueOf(i);
    }

    /* *
     * @Title    
     * @Description  
     * @Param     [ftpId]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsDataType>
     * @throws      
     * @author   jinyi
     * @Date   2018/7/9  16:14
     **/
    @RequestMapping(value = "/dcsFtpTypeRel/getDcsDataTypeListForRest")
    @ResponseBody
    public  List<DcsDataType> getDcsDataTypeListForRest(Integer ftpId) {

        logger.info("===getDcsDataTypeListForRest begin!! ===");
        List<DcsDataType> dcsDataTypeListForRest = dcsFtpTypeRelService.getDcsDataTypeListForRest(ftpId);
        return dcsDataTypeListForRest;
    }

}
