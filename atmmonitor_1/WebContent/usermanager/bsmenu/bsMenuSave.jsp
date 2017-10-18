<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
      <%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/common/style/default/css/main.css" rel="stylesheet" />
<link href="${ctx}/common/style/default/css/reset-1.0.css" rel="stylesheet" />
<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
 		<script type="text/javascript">
 		   function clearMessage(){
 		   	document.myform.reset();
 		   }
 		</script>
  </head>  
  <body>  		
	<form action="${ctx}/usermanager/bsmenu/bsMenuSave.action" method="post" name="myform" id="myform">
		<input type="hidden" name="parentid" value="${parentid}"/>				
		<div class="edit_algorithm"></div>
		<div class="title_line">
			<div class="titile_ico">新建菜单</div>
		</div> 
		<!-- project begin  -->
		<div class="field_block">
		    <div class="field_name" style="width: 100px">菜单名称：</div>
		    <div class="algorithm_input"><input name="menuname" id="menuname" type="text"/>
		    <validation id="menunameV" dataType="Require" required="true"  msg="菜单名称必须输入" />	
		    <div class="edit_algorithm">
		    </div></div>
		</div>
		<div class="field_block">
		    <div class="field_name" style="width: 100px">菜单连接:</div>
		    <div class="algorithm_input">
		    	<input name="menuurl" id="menuurl" type="text"/><div class="edit_algorithm"></div>
		    </div>
		</div>
		<div class="field_block">
		    <div class="field_name" style="width: 100px">菜单类型：</div>
		    <div class="algorithm_input">
		    <select id="menutype" name="menutype" class="algorithm_input">							
								<option value="1">普通菜单</option>	
								<option value="0">导航栏菜单</option>													
							</select>		    
		    <div class="edit_algorithm">
		    </div></div>
		</div>
		<div class="field_block">
		    <div class="field_name" style="width: 100px">菜单状态:</div>
		    <div class="algorithm_input">
		    	<select id="status" name="status" class="algorithm_input">							
								<option value="1">可用</option>
								<option value="0">不可用</option>														
							</select>		    	
		    </div>
		</div>
		<div class="save_div">
		<input type="button" class="savebg" value="保&nbsp;&nbsp;存" onclick="checkSubmitForm();"/>
		<input type="button" class="savebg" value="取&nbsp;&nbsp;消" onclick="clearMessage();"/>
		</div>
	</form>
	<script type="text/javascript">	
	function checkSubmitForm(){
		if(Validator.Validate(document.myform,2)){	
			submitForm();			
		}		
	}
		function submitForm(){			
			$.ajax({
	                cache: true,
	                type: "POST",
	                url:"${ctx}/usermanager/bsmenu/bsMenuSave.action",
	                data:$('#myform').serialize(),// 你的formid
	                async: false,
	                error: function(request) {
	                    alert("新增菜单失败!");
	                },
	                success: function(data) {
	                	if(data=="ok"){
	                		alert("新增菜单成功");	                		
	                		window.parent.document.getElementById("rightFrame3").src="";
	                		window.parent.refreshItem('${parentid}');
	                		
	                	}
	                }
	            });
		}		
	</script>
  </body>
</html>