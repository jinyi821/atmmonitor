package com.ultrapower.dcs.cluster.control.controller;/**
 * Created by TMP246 on 2018/6/26.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.DcsDataType;
import com.ultrapower.dcs.cluster.control.model.DcsUser;
import com.ultrapower.dcs.cluster.control.service.DcsUserService;
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

/* *
 * @Title  用户管理
 * @Description
 * @Param
 * @Return
 * @throws
 * @author   jinyi
 * @Date   2018/7/11  14:37
 **/
@Controller
public class DcsUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DcsUserService dcsUserService;

    /* *
    * @Title  数据文件类型配置列表
    * @Description
    * @Param     [pn, map]
    * @Return   java.lang.String
    * @throws
    * @author   jinyi
    * @Date   2018/6/12  11:13
    **/
    @RequestMapping(value = "/dcsUserManager/")
    public String dcsUserManager(
            @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(required = false, defaultValue = "0", value = "refreshPart") Integer refreshPart,
            ModelMap map) {

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        logger.info("===dcsUserManager begin!! ===");

        List<DcsUser> dcsUsersList = dcsUserService.selectAllUsers();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(dcsUsersList, 10);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        map.put("pageInfo", pageInfo);

        //map.put("queryftl", "/dcs_user_manager/dcs_user_manager_query.ftl");
        //map.put("scriptftl", "/dcs_user_manager/dcs_user_manager_script.ftl");
        //map.put("tableftl", "/dcs_user_manager/dcs_user_manager_table.ftl");
        map.put("formcontenturl", "/dcs_user_manager/dcs_user_manager_modal_edit.ftl");
        map.put("isHasSaveButton", "true");
        map.put("pageSize",pageSize);
        return "dcs_user_manager/dcs_user_manager";
//        if (refreshPart == 0) {
//            return "common";
//        } else {
//            return "dcs_user_manager/dcs_user_manager_table";
//        }

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
    @RequestMapping(value = "/dcsUserManager/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDcsUserManager(DcsUser dcsUser) {

        logger.info("===addDcsUserManager begin!! ===");
        int i=0;
        if (dcsUser.getId()==-1) {
            dcsUser.setId(null);
             i = dcsUserService.insert(dcsUser);
        } else {
            i = dcsUserService.updateByPrimaryKey(dcsUser);
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
    @RequestMapping(value = "/dcsUserManager/delete")
    @ResponseBody
    public Integer deleteDcsUser(@RequestParam(required = false, value = "id") Integer  id) {

        logger.info("===deleteDcsUser begin!! ===");
        int i = dcsUserService.deleteByPrimaryKey(id);
        return i;
    }

    /* *
     * @Title    校验用户是否存在
     * @Description
     * @Param     [dcsDataType]
     * @Return   java.lang.String
     * @throws
     * @author   jinyi
     * @Date   2018/6/28  17:02
     **/
    @RequestMapping(value = "/dcsUserManager/checkUser" ,method = RequestMethod.POST)
    @ResponseBody
    public DcsUser checkUser(DcsUser dcsUser) {

        logger.info("===checkUser begin!! ===");
        List<DcsUser> dcsUsers = dcsUserService.selectUserWithNoByloginname(dcsUser);

        if (dcsUser.getId()==-1) {
            if (dcsUsers==null || dcsUsers.size()==0){
                dcsUser.setValid(true);
            } else {
                dcsUser.setValid(false);
            }

        } else {
            if (dcsUsers!=null && dcsUsers.size()>0){
                dcsUser.setValid(true);
            } else {
                dcsUser.setValid(false);
            }

        }
        return dcsUser;
    }
}
