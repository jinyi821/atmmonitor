<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head> 
 		<%@ include file="/common/taglibs.jsp"%> 
 		<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
</head>

<body>
	<div id="listContent0" class="mxContent marginTop">
		<form name="myform" id="myform" >
	       	<div class="Right_content_div">
	       		<input type="hidden" name="pid" id="pid" value="${bsApporvePerson.pid}"/>
				<input type="hidden" name="createtime" id="createtime" value="${bsApporvePerson.createtime}" />
	       		<table class="base_table ContentTable">
	       			<tr>
	       				<td width="25%" class="text_alignRight">
	       					<label class="fontSize3">审批人登录名：</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id = "loginname" name="loginname" value="${bsApporvePerson.loginname}" onclick="openUserinfo()" readonly="readonly" />
	       					<validation id="resnameV" dataType="Require"  msg="资源名称必须填写！" />
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="25%" class="text_alignRight">
	       					<label class="fontSize3">用户名：</label>
	       				</td>
	       				<td>
		    				<input type="text" class="inputSy" id = "fullname" name="fullname" value="${bsApporvePerson.fullname}"  readonly="readonly"/>
<!-- 		    				<validation id="opnameV" dataType="Require"  msg="操作名称必须填写！" /> -->
	       				</td>
	       			</tr>
					<tr>
						<td width="10%" class="text_alignRight">
							<label class="fontSize3">审批权限：</label>
						</td>
						<td class="base_padding_style4">
							<select id="approve_type" name="approve_type" style="width: 91%;" class="js-example-basic-hide-search">
								<option value="1"
									<c:if test="${bsApporvePerson.approve_type=='1'}">selected</c:if>>开发者、分析师</option>
								<option value="2"
									<c:if test="${bsApporvePerson.approve_type=='2'}">selected</c:if>>tableau发布审批</option>
							</select>
						</td>
					</tr>
	       		</table>
	       		<div class="base3">
	       			<input type="button" value="保存" class="base3_btn1" onclick="submitForm();"/>
	       			<input type="button" value="取消" class="base3_btn1" onclick="history.go(-1);"/>
	       		</div>
	       	</div>
       	</form>
    </div>
<script type="text/javascript">
$(function() {
	var pid = $("#pid").val();
	if(pid != null && pid != ""){
		document.getElementById("loginname").disabled="disabled";
	}
});

window.onload=function(){
	window.parent.iFrameHeight("rightFrame2");
};
function submitForm(){
	if(!Validator.Validate(document.forms[0],2)){
		return;
	}
	document.getElementById("loginname").disabled="";
	var loginname = $("#loginname").val();
	if(loginname == null || loginname == ""){
		alert("审批人不能为空，请输入！");
		return false;
	}
	
	$.post("${ctx}/usermanager/bsapporveperson/bsApporvePersonSave.action", $(myform).serialize(), function(result){					 
		 if(result == "succeed"){	
			 alert("保存成功！"); 
			 window.location.href="${ctx}/usermanager/bsapporveperson/bsApporvePersonList.action";
		 } else if(result == "fail"){
			 alert("保存失败：该审批人的权限设置已存在，不能重复添加！");
		 }
   });	
	
}
function openUserinfo(){
	layer.open({
		type: 2,//设定弹窗为iframe嵌套页面
	 	title: ['选择用户', 'font-size:18px;color:#333333;'],//弹窗标题的内容及对应样式
	 	area: ['800px', '600px'],//弹窗的宽度和高度
	  	content: ['${ctx}/usermanager/bsapporveperson/bsUserinfoLoad.action', 'yes'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	});
}

function closeResource(loginname,fullname){
	$("#loginname").val(loginname);
	$("#fullname").val(fullname);
}

</script>
</body>
</html>