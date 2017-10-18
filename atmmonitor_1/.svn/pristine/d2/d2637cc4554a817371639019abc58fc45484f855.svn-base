package com.usermanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.constants.Constants;
import com.portal.model.UserLoginInfo;
import com.usermanager.model.BsDep;
import com.usermanager.model.BsRole;
import com.usermanager.model.BsUserinfo;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsMapUserTypeService;
import com.usermanager.services.BsRoleService;
import com.usermanager.services.BsUserDepService;
import com.usermanager.services.BsUserTypeService;
import com.usermanager.services.BsUserinfoService;

@Controller
@RequestMapping(value = "usermanager/bsuserinfo")
public class BsUserinfoController
{
    private BsUserinfo bsUserinfo;
    @Resource
    private BsUserinfoService bsUserinfoService;
    @Resource
    private BsRoleService bsRoleService;    
    private BsUserTypeService bsUserTypeService;
    @Resource
    private BsMapUserTypeService  bsMapUserTypeService;
    @Resource
	private BsUserDepService  bsUserDepService; 
    @Resource
	private BsDepService bsDepService;

	public BsUserTypeService getBsUserTypeService() {
		return bsUserTypeService;
	}

	public void setBsUserTypeService(BsUserTypeService bsUserTypeService) {
		this.bsUserTypeService = bsUserTypeService;
	}

	@RequestMapping(value = "bsUserinfoLoad.action")
    public String bsUserinfoLoad(Map<String, Object> map, String loginname)
    {
        List<BsRole> roleList = bsRoleService.findAllRole();        
       // Set<BsRole> roleSet = new HashSet<BsRole>(); 
        List<BsRole> userRoleList=bsRoleService.selectUserRoleList(loginname);             
        //List<BsUserType> userTypeList=bsUserTypeService.findAllUserType();
        //Set<BsUserType>  userTypeSet=new HashSet<BsUserType>();
        //List<BsUserType> myuserTypeList=bsUserTypeService.selectUserTypeListByLoginname(loginname);
        List<BsDep> userDepList=bsDepService.selectUserDepList(loginname);  
        int userDepLen=userDepList.size();
        if (loginname != null)
        {
           // bsUserinfo = this.bsUserinfoService.getBsUserinfoByLoginname(loginname);
        	bsUserinfo = this.bsUserinfoService.getBsUserinfoById(loginname);
          //  roleSet = bsUserinfo.getUserRoles();
          // userTypeSet=bsUserinfo.getUserTypes();
          // userDepSet=bsUserinfo.getUserDeps();
            map.put("bsUserinfo", bsUserinfo);
        }
        map.put("roleList", roleList);
        //map.put("roleSet", roleSet);
        map.put("userRoleList", userRoleList);
       //map.put("userTypeList", userTypeList);
        //map.put("userTypeSet", userTypeSet);
       //map.put("myuserTypeList", myuserTypeList); 
        map.put("userDepList", userDepList);
        map.put("userDepLen", userDepLen);        
        return "bsUserinfoSave.jsp";
    }

    @RequestMapping(value = "loginnnameExist.action")
    @ResponseBody
    public String loginnnameExist(String loginname)
    {
        String result = "";
        boolean flag = false;
        if (bsUserinfoService.loginnameExist(loginname))
        {
            flag = true;
        }
        JSONObject json = new JSONObject();
        json.put("flag", String.valueOf(flag));
        result = json.toString();
        return result;
    }
    @RequestMapping(value = "bsUserDepTree.action")
    public String bsUserDepTree(Map<String, Object> map, String loginname){
    	  //String depTreeString=bsDepService.getUseDepTreeNode();
          // Set<BsDep>  userDepSet=new HashSet<BsDep>();
         List<BsDep> userDepList=bsDepService.selectUserDepList(loginname);
         //map.put("depTreeString", depTreeString);
         // map.put("userDepSet", userDepSet);
          map.put("userDepList", userDepList);
    	return "bsUserDepTree.jsp";
    }
    
       
    @RequestMapping(value = "bsUserinfoSave.action")
    @ResponseBody
    public String bsUserinfoSave(HttpServletRequest request,Map<String, Object> map, BsUserinfo bsUserinfo, String loginname1, String[] roleids,Integer[] usertypeids)
    {
        String result = "";
        int operation;
        boolean flag = false;
        UserLoginInfo userlogin=(UserLoginInfo) request.getSession().getAttribute(Constants.USERSESSION);
       
//        Set<BsRole> roleSet = new HashSet<BsRole>();
//        for (int i = 0; i < roleids.length; i++)
//        {
//            BsRole role = new BsRole();
//            role.setRoleid(roleids[i]);
//            roleSet.add(role);
//        }             
//        Set<BsUserType> userTypeSet=new HashSet<BsUserType>();
//        for(int i=0;i<usertypeids.length;i++){
//        	BsUserType userType=new BsUserType();
//        	userType.setPid(Long.valueOf(usertypeids[i]));
//        	userTypeSet.add(userType);        	
//        }                
//        if (loginname1 == null || loginname1 == "")
//        {   
//        	operation=0;
//            bsUserinfo.setUserRoles(roleSet);           
//            flag = bsUserinfoService.addBsUserinfo(bsUserinfo);
//        }
//        else
//        {
//          bsUserinfo.setUserRoles(roleSet);          
//            bsUserinfo.setLoginname(loginname1);
//            operation=1;
//            flag = bsUserinfoService.saveOrUpdateBsUserinfo(bsUserinfo);
//        }        
//       for(int i=0;i<usertypeids.length;i++){
//        	BsMapUserType bsMapUserType=new BsMapUserType();
//        	bsMapUserType.setLoginname(bsUserinfo.getLoginname());
//        	bsMapUserType.setUsertypeid(usertypeids[i]);
//        	bsMapUserType.setCreatetime(System.currentTimeMillis()/1000); 
//        	bsMapUserTypeService.addBsMapUserType(bsMapUserType);
//        }
//        String[] userdepids=checkDepId.split(",");
//       for(int i=0;i<userdepids.length;i++){    	
//    		BsUserDep userdep=new BsUserDep();
//    		userdep.setLoginname(bsUserinfo.getLoginname());
//    		userdep.setDepid(userdepids[i]);
//    		userdep.setRelatetype("1");
//    		userdep.setCreater(userlogin.getLoginname());
//    		userdep.setCreatetime(System.currentTimeMillis()/1000);
//    		bsUserDepService.addBsUserDep(userdep);
//       }
        
        if (loginname1 == null || loginname1.equals(""))
        {   
        	operation=0;
        }
        else
        {        
            bsUserinfo.setLoginname(loginname1);
            operation=1;
        } 
        String checkDepId=bsUserinfo.getDepid().trim();
        String[] userdepids;
        if(checkDepId.equals("")){
        	userdepids=new String[0];
        }else{
        	userdepids=checkDepId.split(",");
        }       
        flag=bsUserinfoService.operateBsUserinfo(operation, bsUserinfo, roleids, usertypeids, userdepids, userlogin.getLoginname());
        //String  returnMessage="操作成功！";
        //boolean parafresh=true;
        //map.put("returnMessage", returnMessage);
        //map.put("parafresh", parafresh);
        //return  "../../common/jsp/freshParent.jsp";
        
        
        JSONObject json = new JSONObject();
        json.put("flag", String.valueOf(flag));
        result = json.toString();
        return result;
    }

    @RequestMapping(value = "bsUserinfoDel.action")
    @ResponseBody
    public String bsUserinfoDel(String loginname)
    {
        String result = "";
        boolean flag = false;
        if (loginname != null)
        {       	
            flag = bsUserinfoService.deleteBsUserinfoById(loginname);
        }
        JSONObject json = new JSONObject();
        json.put("flag", String.valueOf(flag));
        result = json.toString();
        return result;
    }

    @RequestMapping(value = "bsUserinfoList.action")
    public String bsUserinfoList()
    {
        return "bsUserinfoList.jsp";
    }

    @RequestMapping(value = "bsUserinfoUpdatePwdLoad.action")
    public String bsUserinfoUpdatePwdLoad(Map<String, Object> map, String loginname)
    {
 
        if (loginname != null)
        {
          bsUserinfo = this.bsUserinfoService.getBsUserinfoById(loginname);         
          map.put("bsUserinfo", bsUserinfo);
        }
               
        return "bsUserinfoUpdatePwd.jsp";
    }
    @RequestMapping(value = "bsUserinfoUpdatePwd.action")
    @ResponseBody
    public String bsUserinfoUpdatePwd(Map<String, Object> map, String loginname,String newpwd)
    {
     boolean flag=false;
     flag=bsUserinfoService.updateBsUserinfoPwd(loginname,newpwd);                    
     return String.valueOf(flag);
    } 
    
    
    /**
     * 
     * Created on 2016-4-9 
     * <p>Discription:[返回多个用户信息测试]</p>
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "bsManyUserinfoList.action")
    @ResponseBody
    public String bsManyUserinfoList()
    {

        Map<String, Object> condition = new HashMap<String, Object>();
        Object[] object = { "admin", "jiujiu1" };
        condition.put("loginname", object);
        List<BsUserinfo> bsUserinfoByCondition = bsUserinfoService.getBsUserinfoByCondition(condition);
        System.out.println("bsUserinfoByCondition");
        
        return "OK";
    }
}
