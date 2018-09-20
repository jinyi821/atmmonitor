package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/26.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsFtpServer;
import com.ultrapower.dcs.cluster.control.model.DcsScanner;
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
public class DcsScannerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsScannerServer dcsScannerServer;

    /* *
    * @Title  scanner列表
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/dcsScanner/")
    @ResponseBody
    public List<DcsScanner> dcsScanner(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, ModelMap map) {


        logger.info("===dcsDataType begin!! ===");
        List<DcsScanner> dcsScanners = dcsScannerServer.selectAllDcsScanner();
        return dcsScanners;
    }

}
