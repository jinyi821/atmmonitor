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
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/select2.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/checkboxModal.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/wh.js"></script>
<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css"/>
<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
<style type="text/css">
.base2_checked1 {
	width: 20px;
	height: 20px;
	float: left;
	cursor: pointer;
	margin-left: 0;
	text-align: center;
	background-image: url(${ctx}/common/style/newstyle/images/checkbox.png);
	background-repeat: no-repeat;
	background-position: 0 0;
}

.on_check1 {
	background-position: 0 -19px;
}

.checkboxclass1 {
	opacity: 0;
	cursor: pointer;
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
}

.checkbox_input1 {
	width: 20px;
	height: 30px;
}
</style>
</head>
<body>
	<!--<div class="mxContent DivHeight marginBottom marginTop"
		style="min-height: 420px; width: 95%;">-->
		<form action="${ctx}/usermanager/bsuserinfo/bsUserinfoSave.action"
			method="post" name="myform" id="myform">
			<input type="hidden" name="loginname1" id="loginname1"	value="${bsUserinfo.loginname}" />
		    <input type="hidden" name="isupdate" id="isupdate"  value="0" />	
		    <input type="hidden" name="checkDepId" id="checkDepId" />		    
			<table class="base_table">
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">登录名</label></td>
					<td><c:if test="${bsUserinfo.loginname==null}">
							<input type="text" class="inputSy" name="loginname"
								id="loginname" />
							<validation id="loginnameV" dataType="Require" msg="登录名必须填写！" />
							<!-- onblur="validateLoginname()" -->
						</c:if> <c:if test="${bsUserinfo.loginname!=null}">		     
		                  ${bsUserinfo.loginname}
		                  </c:if></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">用户名</label></td>
					<td><input type="text" class="inputSy" id="fullname"
						name="fullname" type="text" value="${bsUserinfo.fullname}" /> <validation
							id="fullnameV" dataType="Require" msg="用户名必须填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">密码</label></td>
					<td><input id="pwd" name="pwd" type="text" class="inputSy"
						value="${bsUserinfo.pwd}" /> <validation id="pwdV"
							dataType="Require" msg="密码必须填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">性别</label></td>
					<td class="base_padding_style4"><select id="sex" name="sex"
						style="width: 91%;" class="js-example-basic-hide-search">
							<option value="男"
								<c:if test="${bsUserinfo.sex=='男'}">selected</c:if>>男</option>
							<option value="女"
								<c:if test="${bsUserinfo.sex=='女'}">selected</c:if>>女</option>
					</select></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">email</label></td>
					<td><input id="email" name="email" type="text" class="inputSy"
						value="${bsUserinfo.email}" /> <validation id="emailV"
							dataType="Email" require=false msg="email必须正确填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">手机号</label></td>
					<td><input id="mobile" name="mobile" type="text"
						class="inputSy" value="${bsUserinfo.mobile}" /> <validation
							id="mobileV" dataType="Mobile" require=false msg="手机号必须正确填写！" />
					</td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">状态</label></td>
					<td class="base_padding_style4"><select id="status"
						name="status" style="width: 91%;"
						class="js-example-basic-hide-search">
							<option value="1"
								<c:if test="${bsUserinfo.status=='1'}">selected</c:if>>正常</option>
							<option value="0"
								<c:if test="${bsUserinfo.status=='0'}">selected</c:if>>停用</option>
					</select></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">角色</label></td>
					<td>
					<table>	
					<tbody>
					<tr>				
					<c:forEach var="role1" items="${roleList }"
							varStatus="status">
							<c:set var="index" value="${status.index+1}" />
							<c:if test="${index%5==0}">
							<td>
								<div class="base2_checked1">
									<input type="checkbox" name="roleids "
										class="checkboxclass1 input checkbox_input1"
										onclick="checkbox_check1(event)" id="role_${role1.roleid}"
										value="${role1.roleid}">
									<c:forEach var="role2" items="${userRoleList}">
										<c:if test="${role1.roleid==role2.roleid}">
											<script>
												var roleid = "role_${role1.roleid}";
												$("#" + roleid + "").attr(
														"checked", "checked");
												$("#" + roleid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>
									</c:forEach></div><td>
									<td>${role1.rolename} &nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr>
							</c:if>
							<c:if test="${index%5!=0}">
							<td>
								<div class="base2_checked1">
									<input type="checkbox" name="roleids"
										class="checkboxclass1 input checkbox_input1"
										onclick="checkbox_check1(event)" id="role_${role1.roleid}"
										value="${role1.roleid}">
									<c:forEach var="role2" items="${userRoleList}">									
										<c:if test="${role1.roleid==role2.roleid}">
											<script>
												var roleid = "role_${role1.roleid}";
												$("#" + roleid + "").attr(
														"checked", "checked");
												$("#" + roleid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>										
									</c:forEach>
									</td>
									<td>
									${role1.rolename}&nbsp;&nbsp;&nbsp;</td>
								</div>
							</c:if>
						</c:forEach>
						</tr>
						</tbody>
						</table>
						</td>
						</tr>					
						<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">用户类型</label></td>
					<td>
					<table>	
					<tbody>
					<tr>				
					<c:forEach var="usertype1" items="${userTypeList}" varStatus="status">
							<c:set var="index" value="${status.index+1}" />
							<c:if test="${index%5==0}">
							<td>
								<div class="base2_checked1">
									<input type="checkbox" name="usertypeids"class="checkboxclass1 input checkbox_input1"
										onclick="checkbox_check1(event)" id="usertype_${usertype1.pid}"
										value="${usertype1.pid}">
									<c:forEach var="usertype2" items="${myUuserTypeList}">
										<c:if test="${usertype1.pid==usertype2.pid}">
											<script>
												var usertypeid = "usertype_${usertype1.pid}";
												$("#" + usertypeid + "").attr(
														"checked", "checked");
												$("#" + usertypeid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>
									</c:forEach></div><td>
									<td>${usertype1.usertype} &nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr>
							</c:if>
							<c:if test="${index%5!=0}">
							<td>
								<div class="base2_checked1">
									<input type="checkbox" name="usertypeids"
										class="checkboxclass1 input checkbox_input1"
										onclick="checkbox_check1(event)" id="usertype_${usertype1.pid}"
										value="${usertype1.pid}">
									<c:forEach var="usertype2" items="${myUuserTypeList}">								
                                         <c:if test="${usertype1.pid==usertype2.pid}">
											<script>
												var usertypeid = "usertype_${usertype1.pid}";
												$("#" + usertypeid + "").attr(
														"checked", "checked");
												$("#" + usertypeid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>									
									</c:forEach></div><td>
									<td>${usertype1.usertype} &nbsp;&nbsp;&nbsp;</td>
								</div>
							</c:if>
						</c:forEach>
						</tr>						
						</tbody>
					</table>	
					</td>
				</tr>
				<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">用户部门</label></td>
					<td>
					<div id="treeDiv" style="height:220px;"></div>
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="button" value="保存" class="base3_btn1"
					onclick="checkSubmit();" /> <input type="button" value="取消"
					class="base3_btn2" onclick="clearMessage();" />
			</div>
		</form>
	<!-- </div> -->	
<script type="text/javascript">
   window.onload=function(){
	var  loginname="${bsUserinfo.loginname}" ;
	if(loginname!=null&&loginname!=""){
		$("#isupdate").val(1);
	}	   
   }  
	var xml='${depTreeString}';
	tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
	tree.setSkin('dhx_skyblue');//样式名称
	tree.setImagePath("/metadata/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
	tree.enableCheckBoxes(1);//1-带选择框的模式 (非1)-不带选择框的模式
	tree.enableTreeLines(true);//是否显示结点间的连线,默认false
	tree.showItemSign(tree.getSelectedItemId(), true);
	//tree.setXMLAutoLoading("/metadata/baseconfig/cfgcolumnset/getMenuTreeXml.action");
	//tree.loadXML("/metadata/baseconfig/cfgcolumnset/getMenuTreeXml.action");
	tree.loadXMLString(xml);
	tree.enableHighlighting(1);
	<c:forEach items="${userDepList}" var="dep"> 
	tree.setCheck("${dep.pid}",true);//勾选节点
	</c:forEach> 
	
	function clearMessage() {
		//document.myform.reset();
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
	function validateLoginname() {
		var flagStr;
		var loginname1 = $("#loginname1").val();
		if (loginname1 == '' || loginname1 == null) {
			//新增验证登录名是否存在   	    	
			var loginname = $("#loginname").val();
			$.ajaxSetup({
				async : false
			});
			$.post("${ctx}/usermanager/bsuserinfo/loginnnameExist.action", {
				"loginname" : loginname
			}, function(result) {
				var obj = eval("(" + result + ")");
				if (obj.flag == "true") {
					alert("登录名已被占用！");
					flagStr = false;
					$("#loginname")[0].focus();
				} else {
					flagStr = true;
					//alert("登录名可以使用！");	
				}

			});
		} else {
			//修改不验证登录名是否存在    
			flagStr = true;
		}
		return flagStr;
	}
	function checkSubmit() {
		if (Validator.Validate(document.myform, 2)) {
			var flag = validateLoginname();
			var roleids = $("input[name='roleids']:checked");			
			var checkDepId=tree.getAllChecked();	
			if (flag) {
				/**if (roleids.length == 0) {
					alert("角色必须选择！");
				} else {*/					
					$("#checkDepId").val(checkDepId);
					 $.post("${ctx}/usermanager/bsuserinfo/bsUserinfoSave.action",
					            $(myform).serialize(),
					            function(result){					 
							 var obj = eval("("+result+")"); 
							 if(obj.flag=="true"){	
								 var isupdate=$("#isupdate").val();
								 if(isupdate==0){
									 alert("新增用户成功！"); 
								 }
								 if(isupdate==1){
									 alert("修改用户成功！"); 
								 }
								 window.parent.location.reload();
								 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			                     parent.layer.close(index);
							 }else{
								 var isupdate=$("#isupdate").val();
								 if(isupdate==0){
									 alert("新增用户失败！"); 
								 }
								 if(isupdate==1){
									 alert("修改用户失败！"); 
								 }	
							 }
						    }
					       );					
				/**}*/
			}
		}
	}
	function checkbox_check1(event) {
		var ev = event || window.event;
		var target = ev.target || ev.srcElement;
		if ($(target).prop("checked")) {
			$(target).attr("checked", "checked");
			$(target).parent().addClass("on_check1");
		} else {
			$(target)[0].removeAttribute("checked");
			$(target).parent().removeClass("on_check1");
		}
	}
</script>	
</body>	
	</html>