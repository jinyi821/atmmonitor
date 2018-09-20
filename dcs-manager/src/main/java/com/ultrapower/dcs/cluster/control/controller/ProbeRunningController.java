package com.ultrapower.dcs.cluster.control.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.*;
import com.ultrapower.dcs.cluster.control.service.DcsDataTypeService;
import com.ultrapower.dcs.cluster.control.service.DcsFtpServerServer;
import com.ultrapower.dcs.cluster.control.service.DcsProbeService;
import com.ultrapower.dcs.cluster.control.service.DcsTaskFileService;
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

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.controller.ProbeRunningController
 * @Title Probe运行情况控制类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-21 16:06
 */

@Controller
@RequestMapping("/probeRunning")
public class ProbeRunningController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsProbeService dcsProbeService;

    @Autowired
    private DcsTaskFileService  dcsTaskFileService;

    @Autowired
    private DcsFtpServerServer dcsFtpServerServer;
    @Autowired
    private DcsDataTypeService dcsDataTypeService;


    /* *
     * @Title 当前probe任务列表
     * @Description  
     * @Param     [pn, map]
     * @Return   java.lang.String
     * @throws
     * @author   fanjianfeng
     * @Date   2018/6/21  16:23
     **/
    @RequestMapping(value = "/currentProbeTaskList/")
    public String currentProbeTaskList(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,@RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize, ModelMap map) {
        //logger.info("进入currentProbeTaskList控制模块！");
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        System.out.println("pageSize:"+pageSize);
        PageHelper.startPage(pn,pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<DcsProbe> dcsProbeList=dcsProbeService.findAllDcsProbeList();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsProbeList,pageSize);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo", pageInfo);
        
        return "probe_running/current_probe_task/current_probe_list";
        
    }

   /* *
    * @Title   probe当前相关任务文件列表
    * @Description  
    * @Param     [probe_id]
    * @Return   java.lang.String
    * @throws      
    * @author   fanjianfeng
    * @Date   2018/6/25  9:39
    **/
    @RequestMapping(value = "/findDcsProbeRelCurrentTaskList/")
    public String findDcsProbeRelCurrentTaskList(@RequestParam(required =true,value = "probe_id")Integer probe_id,
                                                 @RequestParam(required = false, defaultValue = "-1", value = "ftpId") Integer ftpId,
                                                 @RequestParam(required = false, defaultValue = "-1", value = "dataTypeId") Integer dataTypeId,
                                                 @RequestParam(required = false, value = "fileName")String  fileName,
                                                 @RequestParam(required = false, defaultValue = "-1", value = "fileStatus") Integer fileStatus,
                                                 @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
                                                 @RequestParam(required = false, defaultValue = "5", value = "childPageSize") Integer childPageSize,
                                                 ModelMap map){
       ///System.out.println("current_probe_id:"+probe_id);
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, childPageSize);
        System.out.println(ftpId+"//"+dataTypeId+"//"+fileName+"//"+fileStatus);
        map.put("ftpId", ftpId);
        map.put("dataTypeId", dataTypeId);
        map.put("fileName",fileName);
        map.put("fileStatus",fileStatus);
        if(null==ftpId ||ftpId==-1){
            ftpId=null;
        }
        if(null==dataTypeId || dataTypeId==-1) {
            dataTypeId=null;
        }
        if(null==fileStatus||fileStatus==-1){
            fileStatus=null;
        }


        List<DcsTaskFile> dcsProbeCurrentTaskList= dcsTaskFileService.findDcsProbeRelCurrentTaskList(probe_id,ftpId,dataTypeId,fileStatus,fileName);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsProbeCurrentTaskList, childPageSize);
        List<DcsFtpServer> ftpServerList = dcsFtpServerServer.getFTPserverListForNone();
        List<DcsDataType> dcsDataTypeList = dcsDataTypeService.getDcsDataTypeList();
        List<DcsFileStatusEnumVo>  fileStatusEnumList=getFileStatusEnumList();

        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("childPageInfo", pageInfo);
        map.put("currentProbeId", probe_id);
        map.put("ftpServerList", ftpServerList);
        map.put("dcsDataTypeList", dcsDataTypeList);
        map.put("fileStatusEnumList",fileStatusEnumList);

        return "probe_running/current_probe_task/current_probe_rel_task_list";
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
