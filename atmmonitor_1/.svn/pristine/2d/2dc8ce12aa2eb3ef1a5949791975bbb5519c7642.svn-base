<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta name="renderer" content="webkit">
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/common.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/main.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/page/wh.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/kf.css" />
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/select2.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/checkboxModal.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/wh.js"></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
</head>
<body>
   	 <div style="width:inherit;height:inherit;">   
		<form action="${ctx}/usermanager/bsuserinfo/bsUserinfoUpdatePwd.action"
			method="post" name="myform" id="myform">
			<input type="hidden" name="loginname" id="loginname"	value="${bsUserinfo.loginname}" />
			<input type="hidden" name="oldpwd" id="oldpwd"	value="${bsUserinfo.decodePwd}" />	    
			<table class="base_table">
				<tr style="height:40px;line-height:40px;">
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">登录名</label></td>
					<td colspan="3">	     
		                  ${bsUserinfo.loginname}
		                </td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">用户名</label></td>
					<td colspan="3">${bsUserinfo.fullname}</td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">旧密码</label></td>
					<td colspan="3"><input id="pwd" name="pwd" type="password" class="inputSy" onblur="checkOldPwd(this);"/> 
					<validation id="pwdV" dataType="Require" msg="旧密码必须填写！" /></td>
				</tr>
				
				<tr style="height:40px;line-height:40px;">
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">新密码</label></td>
					<td colspan="3"><input id="newpwd" name="newpwd" type="password" class="inputSy"/> 
					<validation id="newpwdV" dataType="Require"  msg="新密码必须填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">确认密码</label></td>
					<td colspan="3"><input id="confirmpwd" name="confirmpwd" type="password"
						class="inputSy" onblur="checkConfirmPwd(this);"/> 
				   <validation	id="confirmpwdV" dataType="Require" msg="确认密码必须填写！" />
					</td>
				</tr>				
			</table>
			<div class="base3">
				<input type="button" value="保存" class="base3_btn1"
					onclick="checkSubmit();" /> <input type="button" value="取消"
					class="base3_btn2" onclick="clearMessage();" />
			</div>
		</form>
 </div>
<script type="text/javascript">	
function checkOldPwd(obj){
	var inputOldPwd=$(obj).val();
	var oldPwd=$("#oldpwd").val();
	if(inputOldPwd!=oldPwd){
		alert("输入旧密码有误，请重新输入！");
		//$(obj).focus();
	}	
}

function checkConfirmPwd(obj){
	var newpwd=$("#newpwd").val();
	var confirmpwd=$(obj).val();
	if(confirmpwd!=newpwd){
		alert("确认密码与新密码不相符，请重新输入！");	
	}	
}
function checkSubmit() {		
		if (Validator.Validate(document.myform, 2)) {
			var inputOldPwd=$("#pwd").val();
			var oldPwd=$("#oldpwd").val();
			if(inputOldPwd!=oldPwd){
				alert("输入旧密码有误，请重新输入！");
				return;				
			}
			var newpwd=$("#newpwd").val();
			var confirmpwd=$("#confirmpwd").val();
			if(confirmpwd!=newpwd){
				alert("确认密码与新密码不相符，请重新输入！");
				return;
			}
			$.post("${ctx}/usermanager/bsuserinfo/bsUserinfoUpdatePwd.action",
						 $(myform).serialize(),
					            function(result){					
							 if(result=="true"){	
								alert("密码修改成功，请重新登录！");
								exitLogin();
								//document.myform.reset();
							  // var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							   //parent.layer.close(index);							   								
							 }else{
								 alert("密码修改失败！");
							 }
						    }
					       );					
			
			}
		}

	 function clearMessage() {
			document.myform.reset();
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		   parent.layer.close(index);
			
	 }	
		function exitLogin(){
			
		    if(confirm("是否退出登录？"))
		{
		       var url=$ctx+"/portal/reloadLogin.action";
		       window.parent.location.href=url;
		}
		
	}
</script>	
</body>	
	</html>