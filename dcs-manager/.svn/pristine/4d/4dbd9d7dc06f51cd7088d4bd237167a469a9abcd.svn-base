package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/26.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpTypeRelService;
import org.apache.commons.lang3.StringUtils;
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

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.DcsDataTypeController
 * @Title DCS数据文件类型配置
 * @Description
 * @Author jinyi
 * @Version v1.0
 * @Created by   2018-06-26 17:18
 */
@Controller
public class DcsDataTypeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsDataTypeService dcsDataTypeService;

    @Autowired
    private DcsFtpTypeRelService dcsFtpTypeRelService ;

    /* *
    * @Title  数据文件类型配置列表
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/dcsDataType/")
    public String dcsDataType (@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
    @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
    @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
    ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===dcsDataType begin!! ===");
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsDataTypeList, 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        map.put("pageInfo", pageInfo);
//        map.put("queryftl", "/dcs_dataType/dcs_datatype_query.ftl");
//        map.put("scriptftl", "/dcs_dataType/dcs_datatype_script.ftl");
//        map.put("tableftl", "/dcs_dataType/dcs_datatype_table.ftl");
        map.put("formcontenturl", "/dcs_dataType/dcs_datatype_modal_edit.ftl");
        map.put("isHasSaveButton", "true");
        map.put("pageSize",pageSize);
        return "dcs_dataType/dcs_dataType";
                
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "dcs_dataType/dcs_dataType_table";
//        }
        
    }

    /* *
     * @Title       根据id查询某个数据类型
     * @Description  
     * @Param     [id, map]
     * @Return   java.lang.String
     * @throws      
     * @author   jinyi
     * @Date   2018/6/27  10:44
     **/
    @RequestMapping(value = "/dcsDataType/select")
    public String selectDcsDataType(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

        logger.info("===selectDcsDataType begin!! ===");
        DcsDataType dcsDataType = dcsDataTypeService.selectByPrimaryKey(id);
        map.put("dcsDataType", dcsDataType);
        return "dcsDataType/dcs_data_type";
    }
    /* *
     * @Title    取选中的FTP server 信息
     * @Description  
     * @Param     [dataTypeId]
     * @Return   java.util.List<com.ultrapower.dcs.cluster.control.model.DcsFtpTypeRel>
     * @throws      
     * @author   jinyi
     * @Date   2018/8/17  16:30
     **/
    @RequestMapping(value = "/dcsDataType/selectFtpServerByDataType")
    @ResponseBody
    public List<DcsFtpTypeRel> selectFtpServerByDataType(@RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId) {

        logger.info("===selectFtpServerByDataType begin!! ===");
        Map condition = new HashMap();
        condition.put("dataTypeId",dataTypeId) ;
        List<DcsFtpTypeRel> ftpServerWithSelectList = dcsFtpTypeRelService.getFtpServerWithSelect(condition);
        return ftpServerWithSelectList;
    }
    
    /* *
     * @Title    插入某个类型
     * @Description  
     * @Param     [dcsDataType]
     * @Return   java.lang.String
     * @throws      
     * @author   jinyi
     * @Date   2018/6/28  17:02
     **/
    @RequestMapping(value = "/dcsDataType/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDcsDataType(DcsDataType dcsDataType) {

        logger.info("===addDcsDataType begin!! ===");
        int i=0;
        if (dcsDataType.getDataTypeId()==-1) {
            dcsDataType.setDataTypeId(null);
             i = dcsDataTypeService.insert(dcsDataType);
        } else {
            i = dcsDataTypeService.updateByPrimaryKey(dcsDataType);
        }
        DcsFtpTypeRel record=new  DcsFtpTypeRel();
        record.setDataTypeId(dcsDataType.getDataTypeId());
        dcsFtpTypeRelService.deleteDcsFtpTypeRel(record) ;
        
        String ftpIds = dcsDataType.getFtpIds();
        if (StringUtils.isNotBlank(ftpIds)){
            String[] ftpIdArray = ftpIds.split(",");
            for(int n=0;n<ftpIdArray.length;n++){
                
                DcsFtpTypeRel record1 =new  DcsFtpTypeRel();
                record1.setDataTypeId(dcsDataType.getDataTypeId());
                record1.setFtpId(new Integer(ftpIdArray[n]));
                record1.setEnabled(1);
                dcsFtpTypeRelService.insert(record1) ;
            }
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
    @RequestMapping(value = "/dcsDataType/update")
    public String updateDcsDataType(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

        logger.info("===updateDcsDataType begin!! ===");
        DcsDataType dcsDataType = dcsDataTypeService.selectByPrimaryKey(id);
        int i = dcsDataTypeService.updateByPrimaryKey(dcsDataType);
        DcsFtpTypeRel record=new  DcsFtpTypeRel();
        record.setDataTypeId(dcsDataType.getDataTypeId());
        dcsFtpTypeRelService.deleteDcsFtpTypeRel(record) ;
        map.put("success", i);
        return "dcsDataType/dcs_data_type";
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
    @RequestMapping(value = "/dcsDataType/delete")
    @ResponseBody
    public String deleteDcsDataType(@RequestParam(required = false, defaultValue = "1", value = "id") Integer id, ModelMap map) {

        logger.info("===deleteDcsDataType begin!! ===");
        int i = dcsDataTypeService.deleteByPrimaryKey(id);
        map.put("success", i);
        return "true";
    }
}
