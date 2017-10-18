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
</head>

<body>
	<div id="listContent0" >
		<form action="baseconfig/dicmodelcategory/dicModelCategorySave.action" method="post" name="myform" id="myform">
			<c:if test="${pid!='0'}" >
				<div class="headHeight Reposition borderBottom" id="toolDiv">
					<input type="button" value="新建下级部门" class="blueBtn" onclick="oppenSaveModelCategory();" />
					<input type="button" value="删除此部门" class="deleteBtn" onclick="deleteData();"/>
	           	</div>
           	</c:if>
	       	<div class="Right_content_div">
	       		<input type="hidden" name="pid" id ="pid" value="${bsDep.pid}"/>
	       		<input type="hidden" name="creater" id ="creater" value="${bsDep.creater}"/>
	       		<input type="hidden" name="depdn" id ="depdn" value="${bsDep.depdn}"/>
	       		<input type="hidden" name="depdns" id ="depdns" value="${bsDep.depdns}"/>
				<input type="hidden" name="parentid" id="parentid" value="${bsDep.parentid}"/>
	       		<table class="base_table ContentTable">
	       			<tr >
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">部门名称</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id="depname" name="depname" value="${bsDep.depname}" />
	       					<validation id="depnameV"  dataType="Custom" regexp="^.{1,20}$"  msg="部门名称：必须填写,且长度不能超过20！" />
	       				</td>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">部门全名</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id="depfullname" name="depfullname" readonly="readonly" value="${bsDep.depfullname}"/>
	       				</td>
       				</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">部门类型</label>
	       				</td>
	       				<td>
	       					<select class="js-example-basic-hide-search" style="width: 92%;" id="deptype" name="deptype">
								<option value="公司" <c:if test="${bsDep.deptype=='公司' }">selected="selected"</c:if>>公司</option>
								<option value="子公司" <c:if test="${bsDep.deptype=='子公司' }">selected="selected"</c:if>>子公司</option>
								<option value="部门" <c:if test="${bsDep.deptype=='部门' }">selected="selected"</c:if>>部门</option>
								<option value="组" <c:if test="${bsDep.deptype=='组' }">selected="selected"</c:if>>组</option>
								<option value="虚拟组" <c:if test="${bsDep.deptype=='虚拟组' }">selected="selected"</c:if>>虚拟组</option>
								
							</select>
	       				</td>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">负责人</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id="depassginee" name="depassginee" value="${bsDep.depassginee}"/>
	       					<validation id="model_category_descV"  dataType="Custom" regexp="^.{1,100}$"  msg="部门负责人：必须填写且长度不能超过50！" />
	       				</td>
       				</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">联系电话</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id="depphone" name="depphone" value="${bsDep.depphone}"/>
	       					<validation id="depphoneV"  dataType="Phone"msg="联系电话：格式不正确" />
	       				</td>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">传真</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" class="textAreaSy" id="depfax" name="depfax" value ="${bsDep.depfax}"/>
	       					<validation id="depfaxV"  dataType="Custom" regexp="^.{0,100}$"  msg="传真：长度不能超过100！" />
	       				</td>
       				</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">email</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy"  id="depemail" name="depemail" value="${bsDep.depemail}"/>
	       					<validation id="depemailV"  dataType="Email" regexp="^.{0,100}$"  msg="email：格式不正确！" />
	       				</td>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">片区</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy"  id="locationzone" name="locationzone" value="${bsDep.locationzone}"/>
	       					<validation id="locationzone"  dataType="Limit"  max="100"   msg="片区：长度不能超过100！" />
	       				</td>
       				</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">状态</label>
	       				</td>
	       				<td>
	       					<select class="js-example-basic-hide-search" style="width: 92%;" id="status" name="status" >
								
									<option value="1" <c:if test="${bsDep.status==1 }">selected="selected"</c:if>>启用</option>
									<option value="0"  <c:if test="${bsDep.status==0 }">selected="selected"</c:if>>停用</option>
							</select>
	       				</td>
	       				<td width="10%" class="text_alignRight ">
	       					<label class="fontSize3">显示顺序</label>
	       				</td>
	       				<td >
	       					<input type="text" class="inputSy" id="ordernum" name="ordernum" value="${bsDep.ordernum}"/>
	       					<validation id="ordernumV" dataType="Custom" regexp="\d{1,11}$"  msg="请输入显示顺序,长度不能超过11" />
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight table_td1Align">
	       					<label class="fontSize3">备注</label>
	       				</td>
	       				<td colspan="3">
	       					<textarea class="textAreaSy" id="remark" name="remark" style="width: 95.5%">${bsDep.remark}</textarea>
	       					<validation id="remarkV"  dataType="Custom" regexp="^.{0,100}$"  msg="备注：长度不能超过150！" />
	       				</td>
	       			</tr>
	       		</table>
	       		<div class="base3">
	       			<input type="button" value="保存" class="base3_btn1" onclick="submitForm();"/>
	       		</div>
	       	</div>
       	</form>
    </div>
	<script type="text/javascript">
		var isUpdate=1;
		window.onload=function(){
			window.parent.iFrameHeight("rightFrame2");
		};
		
/* 		function clearMessage(){
 		   	document.myform.reset();
 		   	isUpdate=1;
 		   	$("#parentid").val("${bsDep.parentid }");
			$("#pid").val("${bsDep.pid }");
		 }
 */		function oppenSaveModelCategory(){
			/* if(isUpdate ==0){
				document.myform.reset();
			}else{ */
			$(":hidden").val(null);
			$("#parentid").val("${bsDep.pid}");
			$(":text").val(null);
			$("#remark").empty();
			isUpdate=0;
			$("#toolDiv").hide();
			/* } */
		}
		function  deleteData(){
			if(!confirm("确定删除吗?")){
					return ;
			}
			var id = "${bsDep.pid }";
			var url="${ctx}/usermanager/bsdep/bsDepDel.action";
			$.post(url,{"pid":id},function(result){
	 			if(result=="ok"){
	 				alert("删除成功!");
	 				window.parent.refreshParentItem('${pid}');
	 				window.parent.document.getElementById("rightFrame2").src="";
	 			}else{
	 				alert("删除失败!原因：此节点存在子节点。");
	 			}
			});
		}
		function submitForm(){
			if(!Validator.Validate(document.forms[0],2)){
				return;
			}
			var data =  $('#myform').serialize();
			$.ajax({
	                cache: true,
	                type: "POST",
	                url:"${ctx}/usermanager/bsdep/bsDepSave.action",
	                data:data,// 你的formid
	                async: false,
	                error: function(request) {
	                    alert("新增失败,请重新保存!");
	                },
	                success: function(data) {
	                	if(data=="ok"){
	                		alert("保存成功");
	                		window.parent.document.getElementById("rightFrame2").src="";
	                		if(isUpdate==1){
	                			window.parent.refreshParentItem('${pid}');
	                		}else{
	                			window.parent.refreshItem('${pid}');
	                		}
	                	}else if(data=="false"){
	                		alert("保存失败,请重新保存!!");
	                	}
	                }
	            });
		}
 
	</script>
</body>
</html>