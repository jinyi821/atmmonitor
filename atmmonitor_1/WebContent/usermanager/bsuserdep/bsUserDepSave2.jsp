<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ include file="/common/taglibs.jsp"%>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>编辑用户部门信息</title>
         <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>	
	     <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script> 
</head>
<body>
<form action="${ctx}/usermanager/bsuserdep/bsUserDepSave2.action" method="post" name="myform" id="myform">
                           <div class="wh_modal_head borderBottom Reposition">
		                       	<div style="float:left;margin-left: 10px;">
		                       	<input type="hidden" name="pid" id="pid" value="${bsUserDep.pid}" />
		                       	<input type="hidden" name="loginname" id="loginname" value="${bsUserDep.loginname}" />  
		                       	<input type="hidden" name="depid" id="depid" value="${bsUserDep.depid}" /> 
		                       	<input type="hidden" name="creater" id="creater" value="${bsUserDep.creater}" /> 
		                       	<input type="hidden" name="createtime" id="createtime" value="${bsUserDep.createtime}" /> 		                       	
		                       	登录名： ${bsUserDep.loginname}&nbsp;&nbsp;&nbsp;用户名：${bsUserDep.userinfo.fullname}&nbsp;&nbsp;&nbsp;
		                       	相关类型:
		                       	  <select id="relatetype" name="relatetype" class="js-example-basic-hide-search" style="width:100px;" >
							<option value="1"
								<c:if test="${bsUserDep.relatetype=='1'}">selected</c:if>>所属组</option>
							<option value="2"
								<c:if test="${bsUserDep.relatetype=='2'}">selected</c:if>>兼职部门</option>
					      </select>
		                       	</div>	                		
                					<div class="searchInfo">
                						<input type="text" class="searchInput"  id="par_condition" name="par_condition"/>
                						<div class="searchIcon"></div>
                						<input type="button" value="搜索" class="base3_btn1" onclick="query()" />
                					</div>	                				
	                				</div>	                			
	                				<div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                						<td></td>                							
                							<td>部门名称</td>                							
                							<td>部门类型</td> 
                							<td>上级机构名称</td>
	                						</thead>
	                						<tbody class="table_body">
	                						<tr>
										     <td><input type="radio" name="checkbox2" value="@@{pid}" id="@@{pid}_radio" onclick="checkBox(this);" /></td>
					                      <td>@@{depname}</td>
					                      <td>@@{deptype}</td>	
					                      <td>@@{depfullname}</td>		    
		                               </tr>	
	                			</tbody>
	                		</table>
	                		<div align="center">
			              <input type="button" value="保存" class="base3_btn1"  onclick="submitForm();"/>
			            </div>
	                 </div>	
   </form>	                 	   
	<script type="text/javascript"> 
	function preFunc(paraStr)
	{			
		paraStr.isCount = 2;	
	    paraStr.par_condition=$("#par_condition").val();
	}
	function dataFunc(dataRow)
	{
	dataRow.depfullname=dataRow.depfullname.substring(0,dataRow.depfullname.lastIndexOf("·"));				
	}	
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsDep.bsDepList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	function parentiFrameHeight(){ //isfame=="0"计算页面高度及后续操作
		var depid="${bsUserDep.depid}";
		var ck=$("input[name='checkbox2']");    		  
		  $.each(ck,function(){
			  var depid1=$(this).val();
			  if(depid1==depid){
				  $(this).attr("checked",true); 			   
			  }    				    		
	    	}); 
	}
    function checkBox(objn){    	
   	 var loginname=$("#loginname").val();
   	 var depid="${bsUserDep.depid}";
   	 var depid1=objn.value;
   	 if(depid!=depid1){   			    
	 $.post("${ctx}/usermanager/bsuserdep/userDepExist.action",{
			"loginname":loginname,"depid":depid1},
			function(result) {
				var obj2 = eval("("+ result+ ")");
				if (obj2.flag == "true") {
					alert("已存在该用户部门信息！");	
					objn.checked=false;						
				}
	 });		       
   	 }	
   	 }	
        function submitForm(){
         var depid=$("input[name='checkbox2']:checked").val(); 
       	 if(depid==null) {        		       		
       	 }else{
       	 $("#depid").val(depid);  
       	 }     		
       		$.post("${ctx}/usermanager/bsuserdep/bsUserDepSave2.action",
		            $(myform).serialize(),
		            function(result){					 
				 var obj = eval("("+result+")"); 					 
				 if(obj.flag=="true"){	
					 alert("编辑用户部门信息成功!");
					 window.parent.location.reload();
					 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                 parent.layer.close(index);					
				 }else{
					 alert("编辑用户部门信息失败!");	
				 }
			    }
		       );       	
 }		
</script>		
</body>
</html>