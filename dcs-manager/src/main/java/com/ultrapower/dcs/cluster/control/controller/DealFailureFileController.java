package com.ultrapower.dcs.cluster.control.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.dao.DcsFailureFileMapper;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsFailureFile;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsProbe;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFailureFileService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import com.ultrapower.dcs.cluster.control.utils.DcsFileStatusEnum;
import com.ultrapower.dcs.cluster.control.utils.DcsFileStatusEnumVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.DcsFailureFileController
 * @Title Dcs失败文件处理控制类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-25 15:46
 */

@Controller
@RequestMapping("/probeRunning/dealFailureFile")
public class DealFailureFileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsFailureFileService dcsFailureFileService;
    @Autowired
    private DcsProbeService dcsProbeService;
    @Autowired
    private DcsFtpServerServer dcsFtpServerServer;
    @Autowired
    private DcsDataTypeService dcsDataTypeService;






    @RequestMapping(value = "/")
    public String  dealFailureFileList(@RequestParam(required =false,defaultValue = "-1",value = "probeId")Integer probeId,
                                       @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
                                       @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
                                       @RequestParam(required = false, value = "fileName")String  fileName,
                                       @RequestParam(required = false, defaultValue = "-1", value = "fileStatus") Integer fileStatus,
                                       @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
                                       @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
                                       @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
                                       ModelMap map){
        map.put("probeId",probeId);
        map.put("ftpId", ftpId);
        map.put("dataTypeId", dataTypeId);
        map.put("fileName",fileName);
        map.put("fileStatus",fileStatus);
        map.put("pageSize",pageSize);
        
        if(null==probeId ||probeId==-1){
            probeId=null;
        }
        if(null==ftpId ||ftpId==-1){
            ftpId=null;
        }
        if(null==dataTypeId || dataTypeId==-1) {
            dataTypeId = null;
        }
        if(null==fileStatus||fileStatus==-1){
            fileStatus=null;
        }
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<DcsFailureFile> dcsFailureFileList=dcsFailureFileService.findDcsFailureFileList(probeId,ftpId,dataTypeId,fileStatus,fileName);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsFailureFileList,pageSize);
        List<DcsProbe> dcsProbeList=dcsProbeService.findAllDcsProbeList();
        List<DcsFtpServer> ftpServerList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        List<DcsFileStatusEnumVo>  fileStatusEnumList=getFileStatusEnumList();

        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo", pageInfo);
        map.put("dcsProbeList",dcsProbeList);
        map.put("ftpServerList",ftpServerList);
        map.put("dcsDataTypeList",dcsDataTypeList);
        map.put("fileStatusEnumList",fileStatusEnumList);
        //map.put("fileStatusEnum", DcsFileStatusEnum.values()); //枚举类型，values()返回数组

//        map.put("queryftl", "/probe_running/deal_failure_file/dcs_failure_file_query.ftl");
//        map.put("scriptftl", "/probe_running/deal_failure_file/dcs_faliure_file_script.ftl");
//        map.put("tableftl", "/probe_running/deal_failure_file/dcs_failure_file_table.ftl");
//
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "probe_running/deal_failure_file/dcs_failure_file_table";
//        }
        return  "probe_running/deal_failure_file/dcs_failure_file";
    }

    //获得文件状态枚举列表
    public List<DcsFileStatusEnumVo> getFileStatusEnumList(){
        ArrayList<DcsFileStatusEnumVo> list = new ArrayList<DcsFileStatusEnumVo>();
        for(DcsFileStatusEnum status : DcsFileStatusEnum.values()){
            DcsFileStatusEnumVo vo = new DcsFileStatusEnumVo();
            vo.setCode(status.getCode());
            vo.setContext(status.getTitleContext());
            list.add(vo);
        }
        return list;
    }


}