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
		<form method="post" action="${ctx}/usermanager/bsresourceurl/bsResourceUrlSave.action" name="myform" id="myform" >
	       	<div class="Right_content_div">
	       		<input type="hidden" name="pid" id="pid" value="${bsResourceUrl.pid}"/>
				<input type="hidden" name="resid" id="resid" value="${bsResourceUrl.resid}"/>
<!-- 				<input type="hidden" name="opid" id="opid" value="${bsResourceUrl.opid}"/> -->
				<input type="hidden" name="creater" id="creater" value="${bsResourceUrl.creater}" />
				<input type="hidden" name="createtime" id="createtime" value="${bsResourceUrl.createtime}" />
	       		<table class="base_table ContentTable">
	       			<tr>
	       				<td width="25%" class="text_alignRight">
	       					<label class="fontSize3">资源名称：</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id = "resname" name="resname" value="${bsResourceUrl.resname}" onclick="openResource()" readonly="readonly" />
	       					<validation id="resnameV" dataType="Require"  msg="资源名称必须填写！" />
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="25%" class="text_alignRight">
	       					<label class="fontSize3">操作名称：</label>
	       				</td>
	       				<td>
		    				<input type="text" class="inputSy" id = "opname" name="opname" value="${bsResourceUrl.opname}"  readonly="readonly"/>
<!-- 		    				<validation id="opnameV" dataType="Require"  msg="操作名称必须填写！" /> -->
	       				</td>
	       			</tr>
	       		<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">URL</label></td>
					<td><input id="url" name="url" type="text" class="inputSy"
						value="${bsResourceUrl.url}" /> <validation id="urlV"
							dataType="Require" msg="url必须正确填写！" /></td>
				</tr>
				<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">描述</label></td>
					<td>
					<textarea class="textAreaSy" maxlength="255" id="remark" name="remark" >${bsResourceUrl.remark}</textarea>
					</td>
				</tr>
				<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">状态</label></td>
					<td class="base_padding_style4"><select id="status"
						name="status" style="width: 91%;"
						class="js-example-basic-hide-search">
							<option value="1"
								<c:if test="${bsResourceUrl.status=='1'}">selected</c:if>>启用</option>
							<option value="0"
								<c:if test="${bsResourceUrl.status=='0'}">selected</c:if>>停用</option>
					</select></td>
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
		window.onload=function(){
			window.parent.iFrameHeight("rightFrame2");
		};
 		function submitForm(){
 			if(!Validator.Validate(document.forms[0],2)){
				return;
			}
			$("#myform").submit();
 		}
 		function openResource(){
 			layer.open({
		 		type: 2,//设定弹窗为iframe嵌套页面
			 	title: ['选择资源', 'font-size:18px;color:#333333;'],//弹窗标题的内容及对应样式
			 	area: ['1000px', '600px'],//弹窗的宽度和高度
			  	content: ['${ctx}/usermanager/bsresourceurl/bsResourceLoad.action', 'yes'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			});
 		}
//  		function openOperate(){
//  			layer.open({
// 		 		type: 2,//设定弹窗为iframe嵌套页面
// 			 	title: ['选择操作', 'font-size:18px;color:#333333;'],//弹窗标题的内容及对应样式
// 			 	area: ['1000px', '600px'],//弹窗的宽度和高度
// 			  	content: ['${ctx}/usermanager/bsresourceurl/bsResourceLoad.action', 'yes'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
// 			});
//  		}
 		function closeResource(id,name){
 			$("#resid").val(id);
 			$("#resname").val(name);
 		}
//  		function closeOperate(id,name){
//  			$("#opid").val(id);
//  			$("#opname").val(name);
//  		}
	</script>
</body>
</html>