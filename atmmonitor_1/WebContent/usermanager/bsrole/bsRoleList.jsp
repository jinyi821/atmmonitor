<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head> 
        <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台角色管理</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	    <meta http-equiv="description" content="this is my page">
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />	   
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	   <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
	    <!--<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>-->
         <script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
  </head>
  <body>
    	 	<div class="divsection">
	    	<div class="bgColor1 wh_contentDiv">
	             <div  id="mx">
                		<div class="wh_content">
                			<div class="rightDiv">	                			
		        				 <div class="mxContent DivHeight marginBottom marginTop">
		                        	<div class="wh_modal_head borderBottom Reposition">
		                        	<input type="button" value="新增角色" class="blueBtn" id="addrole" onclick="add()"  /> 
								<div class="searchInfo">
									<input type="text" class="searchInput" id="par_condition"
										name="par_condition" />
									<div class="searchIcon"></div>
									<input type="button" value="搜索" class="base3_btn1"
										onclick="query()" />
								</div>	                				
	                				</div>	                			
	                				<div>
	                				<c:set var="roleid" value="0"/>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                							<td>角色id</td>
		                                        <td>角色名称</td>
		                                        <td>创建时间</td>
		                                        <td>操作</td>
	                						</thead>
	                						<tbody class="table_body">
	                						<tr>
										<td>@@{roleid}</td>
		                                <td>@@{rolename}</td>
		                                <td align="center">@@{createtime[TIME]}</td>		    		    
		                                <td align="center">
		    		                 <input type="button" class="transparentBtn" id="popModal"  onclick="OpenRoleMenu('@@{roleid}')" value="分菜单" />
		                             <input type="button" class="transparentBtn" onclick="openBsRole('@@{roleid}')" value="编辑" />
		                            <!--<c:set var="roleid" value="@@{roleid}"/>-->
		                            <!--<c:if test="${roleid != '0'}">--><!-- 判断无效 ${roleid}-->
                                       <input type="button" id="@@{roleid}" name="roledelete" class="transparentBtn" onclick="deleteBsRole('@@{roleid}')" value="删除" /> 
　　                                                                                        <!--</c:if>-->
		                             </td>		    
		                               </tr>	
	                						</tbody>
	                					</table>	                				
	                				</div>
		                        </div>
		                        
                 		</div>                 		
                	</div>
                </div>                	
            </div>	    	
	   </div>	
 	</body>
  <script type="text/javascript">
  
	function preFunc(paraStr)
	{
		paraStr.isCount = 2;
		paraStr.par_condition=$("#par_condition").val();
	}
	function dataFunc(dataRow)
	{
	
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsRole.bsRoleList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	function add()
	{
		//PopupUtil.show(0,170,500, '${ctx}/usermanager/bsrole/bsRoleLoad.action');
		//window.open("${ctx}/usermanager/bsrole/bsRoleLoad.action");
		 layer.open({           
	            type: 2,//设定弹窗为iframe嵌套页面
	            title: ['新增角色', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	            area: ['500px', '200px'], 
	            content: "${ctx}/usermanager/bsrole/bsRoleLoad.action"
	           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	        });
	}
	  //$("#addrole").on("click",function(){
  		//layer.open({
  	       // type: 2,//设定弹窗为iframe嵌套页面
            //title: ['角色', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
            //area: ['500px', '200px'], 
            //content: "${ctx}/usermanager/bsrole/bsRoleLoad.action"
           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		//});
  	//}); 
    
	
	function OpenRoleMenu(roleid)
	{
	    //window.open("${ctx}/usermanager/bsrole/roleMenuLoad.action?roleid="+roleid);
	    //window.open("${ctx}/usermanager/bsrole/roleMenuLoad.action?roleid="+roleid, "newwindow", "height=500, width=400, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no")
		layer.open({           
            type: 2,//设定弹窗为iframe嵌套页面
            title: ['角色分配菜单', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
            area: ['500px','500px'], 
            content: "${ctx}/usermanager/bsrole/roleMenuLoad.action?roleid="+roleid
           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
	}	
	function openBsRole(roleid)
	{ 
		//PopupUtil.show(0,170,500, '${ctx}/usermanager/bsrole/bsRoleLoad.action?roleid='+roleid);
	    //window.open("${ctx}/usermanager/bsrole/bsRoleLoad.action?roleid="+roleid);
		layer.open({           
            type: 2,//设定弹窗为iframe嵌套页面
            title: ['修改角色', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
            area: ['500px', '200px'], 
            content: '${ctx}/usermanager/bsrole/bsRoleLoad.action?roleid='+roleid
           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
	}
	function deleteBsRole(roleid){
		if(confirm("确定删除该角色？")){
			if(roleid=='0'||roleid=='1'||roleid=='3'||roleid=='4'){
			 alert("该角色为平台运行必需角色，禁止删除!");	
			 return;
			}
			$.post("${ctx}/usermanager/bsrole/bsRoleDel.action",
					{"roleid":roleid},function(result)
					{
						 var obj = eval("("+result+")"); 
						 
						 if(obj.flag=="true"){
							 
							 alert("删除成功！");							
							 table.submit();
						 }else{
							 alert("删除失败！");	
						 }
						 
					}
			);	
		}
	}
	function parentiFrameHeight(){
		$("input[name='roledelete']").each(function(i, o){ 
		  var roleid= $(o).attr("id"); 
		  if(roleid=='0'||roleid=='1'||roleid=='3'||roleid=='4'){
			  $(o).prev().hide();
			  $(o).hide(); 
		  }		
		})
		window.parent.iFrameHeight("rightFrame2");
	}
</script>	
</html>