package com.usermanager.controller;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usermanager.model.BsMenu;
import com.usermanager.model.BsRole;
import com.usermanager.model.BsRoleMenu;
import com.usermanager.services.BsMenuService;
import com.usermanager.services.BsRoleMenuService;
import com.usermanager.services.BsRoleService;
@Controller
@RequestMapping(value = "usermanager/bsrole")
public class BsRoleController {
	private BsRole  bsRole;
	private BsRoleService  bsRoleService;
	private BsMenuService  bsMenuService;
	private BsRoleMenuService bsRoleMenuService;
	
	//通过此来拼接xml文件，这里注意选取StringBuilder，效率更高  
    private StringBuilder treeString;
    public  BsRoleService getBsRoleService()
	{
		return bsRoleService;
	}
	public  void setBsRoleService(BsRoleService bsRoleService)
	{
	 	this.bsRoleService=bsRoleService;
	}
    public BsMenuService getBsMenuService() {
		return bsMenuService;
	}
	public void setBsMenuService(BsMenuService bsMenuService) {
		this.bsMenuService = bsMenuService;
	}
	
public BsRoleMenuService getBsRoleMenuService() {
		return bsRoleMenuService;
	}
	public void setBsRoleMenuService(BsRoleMenuService bsRoleMenuService) {
		this.bsRoleMenuService = bsRoleMenuService;
	}
@RequestMapping(value = "bsRoleLoad.action")
	public  String bsRoleLoad(Map<String,Object> map,String roleid)
	{
		if (roleid!=null&&!roleid.equals(""))
		{
			bsRole=this.bsRoleService.getBsRoleByRoleId(roleid);
			map.put("bsRole",bsRole);
		}
		return "bsRoleSave.jsp";
	}
@RequestMapping(value = "roleIdExist.action")
@ResponseBody
public  String roleIdExist(String  roleid)
{
	String result = "";	
	boolean flag = false;
	if(bsRoleService.roleIdExist(roleid))
	{
		flag=true;
	}		
	JSONObject json=new JSONObject();  
	json.put("flag",String.valueOf(flag));  
	result = json.toString();		
	return result;				
}
@RequestMapping(value = "bsRoleSave.action")
@ResponseBody
	public  String bsRoleSave(Map<String,Object> map,BsRole bsRole,String roleid1)
	{
	  String result = "";	
	  boolean flag;
	  bsRole.setCreatetime(System.currentTimeMillis()/1000);
	  if(roleid1.equals("")){		  
		  flag=bsRoleService.addBsRole(bsRole);
	  }else{
		  bsRole.setRoleid(roleid1);
		  BsRole  bsOldRole=this.bsRoleService.getBsRoleByRoleId(roleid1);
		  bsRole.setMenuSet(bsOldRole.getMenuSet());
		 flag=bsRoleService.saveOrUpdateBsRole(bsRole);
	  }  
	     //String  returnMessage="操作成功！";
		 //boolean parafresh=true;
		 //map.put("returnMessage", returnMessage);
		 //map.put("parafresh", parafresh);
	     //return  "../../common/jsp/freshParent.jsp";
	     JSONObject json=new JSONObject();  
	 	json.put("flag", String.valueOf(flag));  
	 	result = json.toString();		
	 	return result;	     
	 }
@RequestMapping(value = "bsRoleDel.action")
@ResponseBody
public String deleteUserTestById(String roleid){
	
	String result = "";		
	boolean flag = false;
	if(roleid != null){
		flag = bsRoleService.deleteBsRoleByRoleId(roleid);
	}		
	JSONObject json=new JSONObject();  
	json.put("flag", String.valueOf(flag));  
	result = json.toString();		
	return result;
}

@RequestMapping(value ="roleMenuLoad.action")
public  String roleMenuLoad(Map<String,Object> map,String roleid)
{
	if (roleid!=null&&!roleid.equals(""))
	{
		//bsRole=this.bsRoleService.getBsRoleByRoleId(roleid);
		List<BsRoleMenu> roleMenuList=bsRoleMenuService.findBsRoleMenuByRoleId(roleid);
		//xml的表头  
		treeString = new StringBuilder(128);
		treeString.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  
		 treeString.append("<tree id=\"0\">");  
		 List<BsMenu> bsList=bsMenuService.findUseChlidMenuByParentId(null);
		 for(int i=0;i<bsList.size();i++){
			 BsMenu menu=bsList.get(i);
			 //调用构建子节点的函数  
			 buildMenu(menu); 
		 }
		 treeString.append("</tree>"); 		 
		//map.put("bsRole",bsRole);
		 map.put("roleid",roleid);		 
		map.put("treeString", treeString.toString());
		map.put("roleMenuList", roleMenuList);
	}
	return "roleMenuSave.jsp";
}
/** 
 * 构建树形节点的内容 
 */  
private void buildMenu(BsMenu menu ) {  
   //注意拼接字符串一些特殊符号的处理  
    treeString.append("<item text=\"");  
    treeString.append(menu.getMenuname());  
    treeString.append("\" open=\"1\" id=\"");  
    treeString.append(menu.getMenuid());  
    treeString.append("\">");  
      
   //查看此节点的子节点  
    List<BsMenu> bsList=bsMenuService.findUseChlidMenuByParentId(menu.getMenuid());  
    //如果有子节点，进行递归调用，调用自己这个函数  
   for (int j=0;j<bsList.size();j++) {  
	   BsMenu childmenu=bsList.get(j);
		 //调用构建子节点的函数  
		 buildMenu(childmenu); 
    }            
    treeString.append("</item>");  
} 
@RequestMapping(value ="roleMenuSave.action")
@ResponseBody
public  String roleMenuSave(Map<String,Object> map,String roleid,String checkMenuId){
	bsRoleMenuService.deleteBsRoleMenuByRoleId(roleid);
	String result="";
	boolean flag=true;
	if(checkMenuId!=""){
		String[] menuids=checkMenuId.split(",");
		for(int i=0;i<menuids.length;i++){
		Integer menuid=Integer.parseInt(menuids[i]);
		BsRoleMenu rolemenu=new BsRoleMenu();
		rolemenu.setRoleid(roleid);
		rolemenu.setMenuid(menuid);
		flag=bsRoleMenuService.addBsRoleMenu(rolemenu);
		if(flag==false){
			break;
		 }
		}		
	}		
	     //String  returnMessage="分配菜单成功！";
		 //boolean parafresh=true;
		 //map.put("returnMessage", returnMessage);
		 //map.put("parafresh", parafresh);
	     //return  "../../common/jsp/freshParent.jsp";
	JSONObject json=new JSONObject();  
	json.put("flag", String.valueOf(flag));  
	result = json.toString();		
	return result;
}
 
@RequestMapping(value = "bsRoleList.action")
	public  String bsRoleList()
	{
		return "bsRoleList.jsp";
	}
}
