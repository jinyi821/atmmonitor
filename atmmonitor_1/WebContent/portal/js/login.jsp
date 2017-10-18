	<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
	<%
 String flag =(String)request.getAttribute("flag");
 %>
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head> 
 		<%@ include file="/common/taglibs.jsp"%> 
 		<script type="text/javascript" src="${ctx}/common/js/listview.js"></script>
 		<script type="text/javascript" src="${ctx}/common/js/main.js"></script>
 		<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
 		 
	   <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/login.css" />
	    <title>
	    	数据共享平台
	    </title> 		
</head>

<body onkeydown="onenterdown()">
		<div class="divsection">
	    	<form method="post" action="${ctx}/portal/userValidateCodeLogin.action" name="myform" id="myform" >
	    		<div class="Ct loginLogo">
		    		<div class="logo" style="margin-top: 13px"></div>
	    		</div>
	    		<div class="loginbg">
		    		<div class="login Reposition">
		    			<div class="loginTableDiv">
			    			<table class="inner loginTable">
			    				<tr class="loginTableTr1">
			    					<td class="base_align_left">
			    						<label class="fontSize3">用户名</label>
			    					</td>
			    				</tr>
			    				<tr class="loginTableTr2">
			    					<td>
			    						<input id = "loginname" class="loginInput"  name="loginname"/>
			    						<validation id="loginnameV" dataType="Require"  msg="请输入用户名" />
			    					</td>
			    				</tr>
<!-- 			    				<tr class="loginTableTr1"> -->
<!-- 			    					<td class="base_align_left"> -->
<!-- 			    						<label class="fontSize3">密码</label> -->
<!-- 			    					</td> -->
<!-- 			    				</tr> -->
<!-- 			    				<tr class="loginTableTr2"> -->
<!-- 			    					<td> -->
<!-- 						    				<input id = "pwd" name="pwd" type="password" class="loginInput"/> -->
<!-- 			    							<validation id="pwdV" dataType="Require"  msg="请输入密码" />			    						 -->
<!-- 			    					</td> -->
<!-- 			    				</tr> -->
			    				<tr class="loginTableTr1">
			    					<td class="base_align_left">
			    						<label class="fontSize3">短信验证码</label>
			    					</td>
			    				</tr>
			    				<tr class="loginTableTr2" style="text-align: left">
			    					<td>
						    				<input id = "validateCode" name="validateCode" type="text" style="width:100px;" class="loginInput"/>
			    							<validation id="validateCodeV" dataType="Require"  msg="请输入验证码" />
			    							
			    							<input type="button" value="发送短信验证码"  onclick="sendValidateCode()"
			    							style="width:123px"
			    							class="base3_btn1 loginBtn"/>			    						
			    					</td>
			    				</tr>
			    			</table>
			    			<div class="loginxq">
<!-- 			    				<input type="checkbox" class="loginCheck" id="forgerP" name="forgerP"/> -->
<!-- 			    				<label for="forgerP" class="img_cursor">记住密码</label> -->
			    				<label for="forgerP" class="img_cursor">&nbsp;</label>
<!-- 			    				<a class="forgetA">忘记密码</a> -->
			    			</div>
			    			<input type="button" value="登录"  onclick='submitForm()'  class="base3_btn1 loginBtn"/>
		    			</div>
		    		</div>
	    		</div>
	    	</form>
	   	</div>
	<script type="text/javascript">
	function onenterdown(){
		if(window.event.keyCode == 13){
			submitForm();
		}
	  }
	
	  window.onload=function(){		  
		   if('<%=flag%>'=="error1"){
			  alert("用户名错误！");
		  }else if('<%=flag%>'=="error2"){
			  alert("密码错误！");
		  }else if('<%=flag%>'=="error3"){
			  alert("用户状态禁用，请联系管理员！");
		  }else if('<%=flag%>'=="error"){
			  alert("用户名密码错误！");
		  }else if('<%=flag%>'=="error-210"){
		      alert("校验码错误！");
		  }
		   var forgerP="${cookie['forgerP'].value}";
			  var loginname="${cookie['loginname'].value}";
			  var pwd="${cookie['pwd'].value}";
			  if(forgerP=='on'){
				  $("#forgerP").prop("checked",true);  
				  $("#loginname").val(loginname);
				  $("#pwd").val(pwd);
			  }
		   
	  };
 		function submitForm(){
 			if(!Validator.Validate(document.forms[0],2)){
				return;
			}
			$("#myform").submit();
 		}
 		function sendValidateCode(){
 		
//  			if(!Validator.Validate(document.forms[0],2)){
// 				return;
// 			}
            var loginname=$("#loginname").val();
            if (!loginname){
               alert("请输入用户名！");
               return;
            }
			$.post($ctx+"/portal/sendValidateCode.action",
			  {
				"loginname":$("#loginname").val()
			  },
			  function(data,status){
			    alert(data);
			    //var data=eval(data);
			   
			  }
			);
			
			
 		}
 		$(document).ready(function(){
 		   if(top != window)
 		   {
 				top.location.href = window.location.href;
 		   }
 		});
	</script>
</body>
</html>