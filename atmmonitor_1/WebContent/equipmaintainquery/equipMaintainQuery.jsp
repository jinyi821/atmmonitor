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
    	 	<%@ include file="/portal/header.jsp"%> 
    	 	<div class="divsection" >
	    	<div class="bgColor1 wh_contentDiv">
	             <div  id="mx">
                		<div class="wh_content">
                			<div class="rightDiv" style="margin: 0 auto; width:100%;">	                			
		        				 <div class="mxContent DivHeight marginBottom marginTop">
		                        	<div class="wh_modal_head borderBottom Reposition">
		                        	 
								<div class="searchInfo">
									<input type="text" class="searchInput" id="name_condition"
										name="name_condition" />
									<div class="searchIcon"></div>
									<input type="button" value="搜索" class="base3_btn1"
										onclick="query()" />
								</div>	                				
	                				</div>	                			
	                				<div>
	                				
	                				<c:set var="roleid" value="0"/>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                						    <td>维修单ID</td>
	                							<td>设备编码ID</td>
		                                        <td>ATM名称</td>
		                                        <td>所属部门</td>
		                                        <td>状态</td>
		                                        <td>申请人</td>
		                                        <td>申请时间</td>
		                                        <td>审批人</td>
		                                        <td>审批时间</td>
		                                        <td>维修人</td>
		                                        <td>维修时间</td>
		                                        <td>操作</td>
	                						</thead>
	                					<tbody class="table_body">
	                					<tr>
										<td>@@{id}</td>
		                                <td>@@{equipmentid}</td>
		                                <td>@@{equipmentname}</td>
		                                <td>@@{applydept}</td>
		                                <td>@@{status[ENUM 1=待审批;2=审批通过;3=审批不通过;4=已维修;0=新建;5=不能维修]}</td>
		                                <td>@@{creater}</td>
		                                <td align="center">@@{createtime[TIME]}</td>
		                                 <td>@@{approver}</td>
		                                <td align="center">@@{approvetime[TIME]}</td>
		                                 <td>@@{maintainer}</td>
		                                <td align="center">@@{maintainTIME[TIME]}</td>
		                                	    		    
		                                <td align="center">
		                               
		                             <input type="button" class="transparentBtn" onclick="openBsRole('@@{id}','@@{status}')" value="明细" />
		                            
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
    var  loginname="${loginname}";
    var isAdmin="${isAdmin}";
	function preFunc(paraStr)
	{
		paraStr.isCount = 2;
		paraStr.name_condition=$("#name_condition").val();
		if (isAdmin==true){
			paraStr.loginname_condition=loginname;
		}
		
		
	}
	function dataFunc(dataRow)
	{
	
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_Equipment_CHANGE_DETAIL.list"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	  
    
	
	
	function openBsRole(roleid)
	{ 
		//PopupUtil.show(0,170,500, '${ctx}/usermanager/bsrole/bsRoleLoad.action?roleid='+roleid);
	    //window.open("${ctx}/usermanager/bsrole/bsRoleLoad.action?roleid="+roleid);
		layer.open({           
            type: 2,//设定弹窗为iframe嵌套页面
            title: ['审核设备维修', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
            area: ['900px', '550px'], 
            content: '${ctx}/equipmaintain/equipmentChangeQueryDetail.action?pid='+roleid
           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
	}
	
	function activeBsRole(roleid,status){
		if(confirm("确定启用设备维修单？")){
			if(status!='0'){
			 alert("该设备维修单已启用!");	
			 return;
			}
			$.post("${ctx}/equipmentchange/activeEquipmentChange.action",
					{"pid":roleid},function(result)
					{
						 var obj =result; 
						 
						 if(obj=="true"){
							 
							 alert("启动成功！");							
							 table.submit();
						 }else{
							 alert("启动失败！");	
						 }
						 
					}
			);	
		}
	}
	function deleteBsRole(roleid,status){
		if(confirm("确定删除该设备维修单？")){
			if(status!='0'){
			 alert("该设备维修单已启用，禁止删除!");	
			 return;
			}
			$.post("${ctx}/equipmentchange/equipmentChangeDel.action",
					{"pid":roleid},function(result)
					{
						 var obj =result; 
						 
						 if(obj=="true"){
							 
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
