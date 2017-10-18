<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增编辑资源</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta name="renderer" content="webkit">
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/common.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/main.css" />
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/select2.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/checkboxModal.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js"></script>
<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
</head>
<body>
		<form action="${ctx}/usermanager/bsresource/bsResourceSave.action"
			method="post" name="myform" id="myform">
			<input type="hidden" name="pid" id="pid" value="${bsResource.pid}" />
			<input type="hidden" name="creater" id="creater" value="${bsResource.creater}" />
			<input type="hidden" name="createtime" id="createtime" value="${bsResource.createtime}" />
		    <input type="hidden" name="isupdate" id="isupdate"  value="0" />	
			<table class="base_table ContentTable">
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">资源名称</label></td>
					<td>
					<input type="text" class="inputSy" name="resname" id="resname"  value="${bsResource.resname}"/>
					<validation id="resnameV" dataType="Require" msg="资源名称必须填写！" />					
				</td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">父资源ID</label></td>
					<td><input type="text" class="inputSy" id="parentid"
						name="parentid" type="text" value="${bsResource.parentid}" /> <validation
							id="parentidV" require=false msg="父资源id必须填写！" /></td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">系统分类</label></td>
					<td><input id="systemtype" name="systemtype" type="text" class="inputSy"
						value="${bsResource.systemtype}" /> <validation id="systemtypeV"
							require=false  msg="系统分类必须填写！" /></td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">自定义分类</label></td>
					<td><input id="definetype" name="definetype" type="text" class="inputSy"
						value="${bsResource.definetype}" /> <validation id="definetypeV"
							require=false  msg="自定义分类必须填写！" /></td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">状态</label></td>
					<td class="base_padding_style4"><select id="status" name="status"
						style="width: 91%;" class="js-example-basic-hide-search">
							<option value="1"
								<c:if test="${bsResource.status==1}">selected</c:if>>启用</option>
							<option value="0"
								<c:if test="${bsResource.status==0}">selected</c:if>>停用</option>
					</select></td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">排序值</label></td>
					<td><input id="ordernum" name="ordernum" type="text" class="inputSy"
						value="${bsResource.ordernum}" /> <validation id="ordernumV"
							 dataType="Custom"  regexp="^\d+$" msg="排序值必填为非负整数类型！"/></td>
				</tr>
				<tr>
					<td width="15%" class="text_alignRight"><label
						class="fontSize3">备注</label></td>
					<td>
					<textarea class="textAreaSy" maxlength="255" id="remark" name="remark" >${bsResource.remark}</textarea>
					</td>
				</tr>								
			</table>
			<div class="base3">
				<input type="button" value="保存" class="base3_btn1"	onclick="checkSubmit();" /> 
				<input type="button" value="取消"class="base3_btn2" onclick="clearMessage();" />
			</div>
		</form>
<script type="text/javascript">
    window.onload=function(){
	var  pid="${bsResource.pid}" ;
	if(pid!=null&&pid!=""){
		$("#isupdate").val(1);
	}
    }
	function clearMessage() {
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
	function checkSubmit() {
		if (Validator.Validate(document.myform, 2)) {						
					 $.post("${ctx}/usermanager/bsresource/bsResourceSave.action",
					            $(myform).serialize(),
					            function(result){					 
							 var obj = eval("("+result+")"); 
							 if(obj.flag=="true"){	
								 var isupdate=$("#isupdate").val();
								 if(isupdate==0){
									 alert("新增资源成功！"); 
								 }
								 if(isupdate==1){
									 alert("修改资源成功！"); 
								 }
								 window.parent.location.reload();
								 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			                     parent.layer.close(index);
							 }else{
								 var isupdate=$("#isupdate").val();
								 if(isupdate==0){
									 alert("新增资源失败！"); 
								 }
								 if(isupdate==1){
									 alert("修改资源失败！"); 
								 }	
							 }
						    }
					       );					
				}	
	}	
</script>	
</body>
</html>