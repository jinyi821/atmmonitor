<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据共享平台人员登录账号解冻申请页面</title>
	   <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/videoUpload.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/kf_iframe.css" />
	   <%-- <script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script> --%>       
		<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/placeholder.js"></script>
        <script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
        <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/showBg.js"></script>
        <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/kf3.js" ></script>
   </head>
	<body>
			<div class="divsection">
	    	<form action="${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeApplySave.action" method="post" name="myform" id="myform">
	    		<div class="bgColor1 borderTop">
	        		<div class="Ct contentDiv" style="width:600px;padding-bottom:0px;">
	        			<%-- <div class="up_head">
	        				<label class="color2 fontSize2">用户登录账号解冻申请</label>
	        			</div> --%>
	        			<div class="up_content" style="padding-top:20px;">
	        				<div class="up_contentTableDiv" style="padding-left:5px;padding-right:20px;">
		        				<table class="base_table ContentTable">			        					
		        					<tr>
		        						<td class="text_alignRight fontSize3" width="25%">
		        							<label class="color14">*</label>
		        							<label>申请人登录名</label>
		        						</td>
		        						<td  width="75%">
		        							<input type="text" id="apply_loginname" name="apply_loginname" class="inputSy1" value="${apply_loginname}" readonly onblur="validateLoginname(this.value);"/><%-- onblur="validateLoginname(this);" --%>
		        							<validation id="apply_loginnameV"dataType="Require" msg="申请人登录名必须填写！" /> 
		        						</td>
		        					</tr>
		        					<tr>
		        						<td class="text_alignRight fontSize3"  width="25%">
		        							<label class="color14">*</label>
		        							<label>申请人姓名</label>
		        						</td>
		        						<td width="75%">
		        							<input type="text" id="apply_fulllname" name="apply_fulllname" class="inputSy1" readonly value="${apply_fulllname}"/>
		        							<validation id="apply_fulllnameV"dataType="Require" msg="申请人姓名必须填写！" /> 		        							
		        						</td>
		        					</tr>		        					
		        					<tr>
		        						<td class="text_alignRight table_td1Align fontSize3" width="25%">
		        							<label class="color14">*</label>
									        <label>长期未登录缘由</label>
									    </td>
										<td width="75%">
									        <textarea class="textAreaSy uploadTextArea" id="frozen_reason" name="frozen_reason" placeholder="建议不要超过50字"></textarea>
									        <validation id="frozen_reasonV"dataType="Require" msg="长期未登录缘由必须填写！"/> 
									    </td>
		        					</tr>
		        					<tr>
		        						<td class="text_alignRight table_td1Align fontSize3" width="25%">
		        							<label class="color14">*</label>
									        <label>申请解冻缘由</label>
									    </td>
										<td width="75%">
									        <textarea class="textAreaSy uploadTextArea" id="apply_unfreeze_note" name="apply_unfreeze_note" placeholder="建议不要超过50字"></textarea>
									        <validation id="apply_unfreeze_noteV"dataType="Require" msg="申请解冻缘由必须填写！"/> 
									    </td>
		        					</tr>		        					
		        				</table>		        			
		        			</div>
		        			<div class="base3 borderTop uploadBtnBlock" style="margin-top:0px;">
								<input type="button" value="提交" class="base3_btn3 fontSize3" onclick="checkSubmit();"/>
							<%--<input type="button" value="取消" class="base3_btn2 fontSize3"/> --%>
							</div>
	        			</div>
	        		</div>
	       		</div>	       		
	       	</form>
	   </div>       
          <div class="model_dialog" style="display: none;width:auto;height:auto;" id="model1">
			      <div class="model_tip">
			            		<label>温馨提示！</label>
			            	</div>
			            	<div class="marginBottom2">
		            		<label class="fontSize3 color3">此流程将提交到系统管理员审批。</label>
		            	  </div>			            
			              <div class="modelBtnDiv">
					    		<input type="button" value="确定" class="base3_btn3 modelBtn1" id="shureApply" onclick="shureSubmit();"/>
					    		<input type="button" value="取消" class="base3_btn2 modelBtn2" onclick="hideDialog('model1','mask');"/>
				         </div>
		 </div>
	</body>
	<script type="text/javascript">
	var validateCheckResult="";
	var apply_user="${apply_loginname}";
	$(function(){
		validateLoginname(apply_user);		
	});	
    function validateLoginname(obj) {
			//新增验证登录名是否存在   	    	
			var loginname =obj;//$(obj).val();
			if(loginname!=null&&loginname!=""){
				$.ajaxSetup({
					async : false
				});
				$.post("${ctx}/usermanager/bsuserinfo/loginnnameExist.action",{"loginname":loginname},function(result) {
					var dataobj = eval("(" + result + ")");
					if (dataobj.flag == "false") {
						validateCheckResult="不存在的账号登录名！";
						alert(validateCheckResult);
						//$(obj).focus();//获得焦点
						//return;
					}else{
						judgeWhetherTriggerApply(obj);						
					} 

				});
			}
		    else{
				removeAttrFocus();		
			}
			}
	  
	  function judgeWhetherTriggerApply(obj){		 
		  var loginname =obj;// $(obj).val(); 
		  $.ajaxSetup({
				async : false
			});
		  var url = "${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeJudgeWhetherTriggerApply.action";
			$.post(url,{"loginname":loginname},function(result){
				validateCheckResult=result;
	 			if(result!=""){	 			 	
	 			 alert(validateCheckResult);	
	 			//$(obj).focus();//获得焦点
				//return;
	       	    }				
         });		  
	  }
	  function removeAttrFocus(){  //移除申请人登录名焦点事件
		  //$("#apply_loginname").removeAttr("onblur");离开焦点事件 
		  $("#apply_loginname").removeAttr("onfocus");//移除焦点事件
		  
	  }
	   function checkSubmit(){
			if(!Validator.Validate(document.myform, 2)){
				return;
			}
			if(validateCheckResult!=""){
				alert(validateCheckResult);
				return;
			}
			$("#model1").css("display","");	
			var targetTop = $(window).height()/4;
			var targetLeft = $(window).width()/4;		
			$("#model1").offset({top:targetTop,left:targetLeft});
			showBg("mask");
		}	  
	function shureSubmit(){
		    $("#shureApply").prop("disabled","disabled");
			$("#shureApply").removeClass("base3_btn3");
			$("#shureApply").removeClass("modelBtn1");       			
			$("#shureApply").addClass("base3_btn2");
			$("#shureApply").addClass("modelBtn2"); 			
			var myformdata= $(myform).serialize(); //form取值
			var url = "${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeApplySave.action";
			$.post(url,myformdata,function(result){
	 			if(result){
	 				$("#shureApply").removeProp("disabled");
	 				$("#shureApply").removeClass("base3_btn2");
	       			$("#shureApply").removeClass("modelBtn2");       			
	       			$("#shureApply").addClass("base3_btn3");
	       			$("#shureApply").addClass("modelBtn1"); 
	 				hideDialog('model1','mask');	 				
	 				//$("#model1").css("display","none");	
	 				alert("申请成功。");
	 				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	 			    parent.layer.close(index);	 				
	       	}else{
					alert("申请失败！");
					$("#shureApply").removeProp("disabled");
	 				$("#shureApply").removeClass("base3_btn2");
	       			$("#shureApply").removeClass("modelBtn2");       			
	       			$("#shureApply").addClass("base3_btn3");
	       			$("#shureApply").addClass("modelBtn1"); 
					hideDialog('model1','mask');					
	 				//$("#model1").css("display","none");	
           }
		});		
	}	
	</script>
</html>