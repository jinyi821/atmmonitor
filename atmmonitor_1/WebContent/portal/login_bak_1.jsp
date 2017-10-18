	<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
	<%
 String flag =(String)request.getAttribute("flag");
 String loginname =(String)request.getAttribute("loginname");
 %>
	
<!DOCTYPE HTML>
<html>
  <head> 
 		<%@ include file="/common/taglibs.jsp"%> 
 		<script type="text/javascript" src="${ctx}/common/js/listview.js"></script>
 		<script type="text/javascript" src="${ctx}/common/js/main.js"></script>
 		<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
 		<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
 		 
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

			    			</div>
			    			<br>
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
		  }else if('<%=flag%>'=="error-310"){
		      alert("当前登入账号近三个月没有登入数据共享平台，登入账号已被锁定，需进行审批申请解锁！");
		      var  validateTriggerFlag=judgeWhetherTriggerApplyFree();
		      if(validateTriggerFlag){
		    	  freeUser();  
		      }		    
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
 		
 		function freeUser()
		{
		  var loginname='<%=loginname%>';
		  layer.open({  
			    id: 'applyform',//便于右上角关闭按钮回调子页面方法，不管用
	            type: 2,//设定弹窗为iframe嵌套页面
	            title: ['用户登录账号解冻申请', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	            area: ['602px', '390px'], 
	            content: ['${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeApplyLoad.action?loadType=apply&loginname='+loginname,'no']
                 //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	            //cancel:function(index){//右上角关闭按钮回调方法	            
	            //freeUserOperation(); 
	           //} 
		 });
	    }
 		function judgeWhetherTriggerApplyFree(){
 			var loginname='<%=loginname%>';
 			var validateTriggerFlag=true;
 			  $.ajaxSetup({
 					async : false
 				});
 			  var url = "${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeJudgeWhetherTriggerApply.action";
 				$.post(url,{"loginname":loginname},function(result){
 		 			if(result!=""){	 
 		 			 validateTriggerFlag=false;	
 		 			 alert(result);
 		       	}				
 	         });
 			return validateTriggerFlag;
 		  }
 		
 		
 		function freeUserOperation(){//操作layer子页面对象方法
 			 var frameId=document.getElementsByTagName("iframe")[0].id;
 			 $('#'+frameId)[0].contentWindow.removeAttrFocus();
 		}
	</script>
</body>
</html>