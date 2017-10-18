<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <%@ include file="/common/taglibs.jsp"%>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>角色新增页面</title>
         <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <!--<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>-->
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>	    
       <script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
       <script language="javascript" type="text/javascript">
       window.onload=function(){
    	var  roleid="${bsRole.roleid}" ;
    	if(roleid!=null&&roleid!=""){
    		$("#isupdate").val(1);
    	}
    	   
       }
	function clearMessage() {
		//document.myform.reset();
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
	function validateRoleId() {
		var flagStr;
		var roleid1 = $("#roleid1").val();
		if (roleid1 == '' || roleid1 == null) {
			//新增验证角色id是否存在   	    	
			var roleid = $("#roleid").val();
			$.ajaxSetup({
				async : false
			});
			$.post("${ctx}/usermanager/bsrole/roleIdExist.action", {
				"roleid" : roleid
			}, function(result) {
				var obj = eval("(" + result + ")");
				if (obj.flag == "true") {
					alert("角色id已被占用！");
					flagStr = false;
					//$("#roleid")[0].focus();								
				} else {
					//alert("角色id可以使用！");
					flagStr = true;
				}

			});
		} else {
			//修改不验证用户名是否存在   
			flagStr = true;
		}
		return flagStr;
	}
	function checkSubmit() {	
		if (Validator.Validate(document.myform, 2)) {
			if (validateRoleId()) {
				//document.myform.submit();
				//window.parent.PopupUtil.hide();
				//window.parent.query();
				
			
				//window.parent.table.submit();
				//window.parent.location.reload();
				//var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			    //parent.layer.close(index);
				//parent.layer.closeAll('iframe');				
				 $.post("${ctx}/usermanager/bsrole/bsRoleSave.action",
			            $(myform).serialize(),
			            function(result){					 
					 var obj = eval("("+result+")"); 					 
					 if(obj.flag=="true"){	
						 var isupdate=$("#isupdate").val();
						 if(isupdate==0){
							 alert("新增角色成功！"); 
						 }
						 if(isupdate==1){
							 alert("修改角色成功！"); 
						 }
						 window.parent.location.reload();
						 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                     parent.layer.close(index);
					 }else{
						 var isupdate=$("#isupdate").val();
						 if(isupdate==0){
							 alert("新增角色失败！"); 
						 }
						 if(isupdate==1){
							 alert("修改角色失败！"); 
						 }	
					 }
				    }
			       );				
			}
		}
	}
</script>
</head>
<body>
<!--<div class="mxContent DivHeight marginBottom marginTop" style="min-height:150px;width:95%;">-->
	                        <form action="${ctx}/usermanager/bsrole/bsRoleSave.action"
									method="post" name="myform" id="myform">									
										<input type="hidden" name="roleid1" id="roleid1"
											value="${bsRole.roleid}" />
										<input type="hidden" name="isupdate" id="isupdate"  value="0" />	
										<table class="base_table ContentTable">
                                           <tr>
												<td width="15%" class="text_alignRight"><label
													class="fontSize3">角色id</label></td>
												<td><c:if test="${bsRole.roleid==null}">
														<input id="roleid" name="roleid" class="inputSy" 
															type="text" value="${bsRole.roleid}" />
														<validation id="roleidV" dataType="Require"
															msg="角色id必须填写！" />
														<!--onblur="validateRoleId()"-->
													</c:if> <c:if test="${bsRole.roleid!=''}">${bsRole.roleid}</c:if>
												</td>
											</tr>
											<tr>
												<td width="15%" class="text_alignRight"><label
													class="fontSize3">角色名称</label></td>
												<td><input id="rolename" name="rolename" type="text" maxlength="50"
													class="inputSy" value="${bsRole.rolename}" /> <validation
														id="rolenameV" dataType="Require" msg="角色名称必须填写！" /></td>
											</tr>
										</table>
										<div class="base3">
			                             <input type="button" value="保存" class="base3_btn1"  onclick="checkSubmit();"/>
			                              <input type="button" value="取消" class="base3_btn2" onclick="clearMessage();"/>
		                               </div>										
								</form>
								<!--</div>-->
</body>
</html>
