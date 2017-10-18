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
.AccessUl{	
  position:relative;  
}	
</style>
</head>
<body>
  <div class="divsection">	    	
                <div class="bgColor1 wh_contentDiv">	               
                	<div  id="mx">
                		<div class="wh_content">
                		<div class="rightDiv"> <!-- 以上div增加底层高度 -->
   	 <div class="mxContent  marginTop">
   	  	<div class="wh_modal_head borderBottom Reposition">
		   <span style="margin-left:50px;font-size: 18px;" id="functiontitle"></span>							                				
	   </div>	
		<form action="${ctx}/usermanager/bsuserinfo/bsUserinfoSave.action"
			method="post" name="myform" id="myform">
			<input type="hidden" name="loginname1" id="loginname1"	value="${bsUserinfo.loginname}" />
			<input type="hidden" name="createtime" id="createtime"	value="${bsUserinfo.createtime}" />
		    <input type="hidden" name="isupdate" id="isupdate"  value="0" />	
		    <input type="hidden" name="checkDepId" id="checkDepId" />		    
			<table class="base_table">
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">登录名</label></td>
					<td colspan="3"><c:if test="${bsUserinfo.loginname==null}">
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
					<td colspan="3"><input type="text" class="inputSy" id="fullname"
						name="fullname" type="text" value="${bsUserinfo.fullname}" autocomplete="off" /> <validation
							id="fullnameV" dataType="Require" msg="用户名必须填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">密码</label></td>
					<td colspan="3"><input id="pwd" name="pwd" type="password" class="inputSy"
						value="${bsUserinfo.decodePwd}" autocomplete="off" /> <validation id="pwdV"
							dataType="Require" msg="密码必须填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">性别</label></td>
					<td colspan="3" class="base_padding_style4" ><select id="sex" name="sex"
						style="width: 90.8%;" class="js-example-basic-hide-search">
							<option value="男"
								<c:if test="${bsUserinfo.sex=='男'}">selected</c:if>>男</option>
							<option value="女"
								<c:if test="${bsUserinfo.sex=='女'}">selected</c:if>>女</option>
					</select></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">email</label></td>
					<td colspan="3"><input id="email" name="email" type="text" class="inputSy"
						value="${bsUserinfo.email}" /> <validation id="emailV"
							dataType="Email" require=false msg="email必须正确填写！" /></td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">手机号</label></td>
					<td colspan="3"><input id="mobile" name="mobile" type="text"
						class="inputSy" value="${bsUserinfo.mobile}" /> <validation
							id="mobileV" dataType="Custom" require="false"  regexp="^1[3|4|5|7|8]\d{9}$" msg="手机号必须正确填写！" />
					</td>
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">状态</label></td>
					<td colspan="3" class="base_padding_style4"><select id="status"
						name="status" style="width: 90.8%;"
						class="js-example-basic-hide-search">
							<option value="1"
								<c:if test="${bsUserinfo.status==1}">selected</c:if>>正常</option>
							<option value="0"
								<c:if test="${bsUserinfo.status==0}">selected</c:if>>停用</option>
							<option value="2"
								<c:if test="${bsUserinfo.status==2}">selected</c:if>>冻结</option>	
					</select></td>
				</tr>				
					<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">数据分析师</label></td>
					<td  class="base_padding_style4"><select id="isanalyzer"
						name="isanalyzer" style="width:317px;"
						class="js-example-basic-hide-search">
							<option value="0"
								<c:if test="${bsUserinfo.isanalyzer==0}">selected</c:if>>否</option>
							<option value="1"
								<c:if test="${bsUserinfo.isanalyzer==1}">selected</c:if>>是</option>
						    <option value="2"
								<c:if test="${bsUserinfo.isanalyzer==2}">selected</c:if>>申请中</option>
					</select></td>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">开发者</label></td>
					<td class="base_padding_style4"><select id="isdeveloper"
						name="isdeveloper" style="width:317px;"
						class="js-example-basic-hide-search">
							<option value="0"
								<c:if test="${bsUserinfo.isdeveloper==0}">selected</c:if>>否</option>
							<option value="1"
								<c:if test="${bsUserinfo.isdeveloper==1}">selected</c:if>>是</option>
							<option value="2"
								<c:if test="${bsUserinfo.isdeveloper==2}">selected</c:if>>申请中</option>	
					</select></td>
				</tr>				
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">角色</label></td>
					<td colspan="3">
					<table>	
					<tbody>
					<tr>
			        <c:set var="userRoleListLen" value="${userRoleList.size()}"/> <!--取得后台穿过list的长度 -->				        	
					<c:forEach var="role1" items="${roleList }"
							varStatus="status">
							<c:set var="index" value="${status.index+1}" />
								<c:if test="${index%5==0}">
							<td>
								<div class="base2_checked1">
									<input type="checkbox" name="roleids"
										class="checkboxclass1 input checkbox_input1"
										onclick="checkbox_check1(event)" id="role_${role1.roleid}"
										value="${role1.roleid}">
										<c:if test="${bsUserinfo.loginname==null}">
									    <c:if test="${role1.roleid=='0'}">
											<script>
												var roleid = "role_${role1.roleid}";
												$("#" + roleid + "").attr(
														"checked", "checked");
												$("#" + roleid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>
									</c:if>	
									<c:if test="${bsUserinfo.loginname!=null}">
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
									</c:if></div>										
									</td>
									<td>
									${role1.rolename}&nbsp;&nbsp;&nbsp;</td>
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
										<c:if test="${bsUserinfo.loginname==null}">
									    <c:if test="${role1.roleid=='0'}">
											<script>
												var roleid = "role_${role1.roleid}";
												$("#" + roleid + "").attr(
														"checked", "checked");
												$("#" + roleid + "").parent()
														.addClass("on_check1");
											</script>
										</c:if>
									</c:if>	
									<c:if test="${bsUserinfo.loginname!=null}">
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
									</c:if></div>										
									</td>
									<td>
									${role1.rolename}&nbsp;&nbsp;&nbsp;</td>								
							</c:if>
						</c:forEach>
						</tr>
						</tbody>
						</table>
						</td>
						</tr>
					<!--<tr style="height:40px;line-height:40px;">
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
									<c:forEach var="usertype2" items="${myuserTypeList}">
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
									<c:forEach var="usertype2" items="${myuserTypeList}">								
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
				</tr>-->
				<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">用户部门</label></td>
					<td colspan="3">
					<input id="depid" name="depid" type="hidden" class="inputSy" readonly="readonly"  value="${bsUserinfo.depid}" />
					<input id="depname" name="depname" type="text" class="inputSy" readonly="readonly" value="${bsUserinfo.depname}"  onclick="openUserDepTree('${bsUserinfo.loginname}')" />					
					</td>
				</tr>
				<tr  style="height:40px;line-height:40px;">
				<td width="10%" class="text_alignRight" style="vertical-align:top;"> <!-- style="vertical-align:top;" 让td中的内容竖直居顶 -->
				<label	class="fontSize3">已选部门</label></td>
				<td colspan="3">										
				<ul class="AccessUl" style="width:90.8%;overflow-y:auto;">
					<!--<li class="AccessUl_li_head">已选部门列表</li>-->									    	
				 </ul>				 
				</td>					    	
				</tr>
				<tr style="height:40px;line-height:40px;">
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">是否部门领导</label></td>
					<td colspan="3" class="base_padding_style4"><select id="isdepleader"
						name="isdepleader" style="width: 90.8%;"
						class="js-example-basic-hide-search">
						   <option value="0"
								<c:if test="${bsUserinfo.isdepleader==0}">selected</c:if>>否</option>
							<option value="1"
								<c:if test="${bsUserinfo.isdepleader==1}">selected</c:if>>是</option>							
					</select></td>
				</tr>		
			</table>
			<div class="base3">
				<input type="button" value="保存" class="base3_btn1"
					onclick="checkSubmit();" /> <input type="button" value="取消"
					class="base3_btn2" onclick="history.go(-1);" />
			</div>
		</form>
 </div>
 </div>
 </div>
 </div>
 </div>
 </div>
<script type="text/javascript">
var chooseDepIdArray=new Array();
var chooseDepNameArray=new Array();
   window.onload=function(){
	var  loginname="${bsUserinfo.loginname}" ;	
	if(loginname!=null&&loginname!=""){
		$("#isupdate").val(1);
		$("#functiontitle").text("编辑用户"); 	
		$("#isanalyzer option:not(:selected)").remove(); //除选中的项获得保留
		$("#isdeveloper option:not(:selected)").remove();
		//$("#isdepleader option:not(:selected)").remove();		
	}else{
		$("#functiontitle").text("新增用户"); 	
		$("#isanalyzer option:not(:first)").remove(); //除第一项获得保留
		$("#isdeveloper option:not(:first)").remove();
		//$("#isdepleader option:not(:selected)").remove();
	}
	$("#isanalyzer").attr("disabled",true); //设置form表单中标签禁用
	$("#isdeveloper").attr("disabled",true);
	$("#isdepleader").attr("disabled",true);	
	var userDepLen="${userDepLen}";
	if(userDepLen>0){
	<c:forEach items="${userDepList}"  varStatus="status" var="userdep">
	 var depfulname="${userdep.depfullname}";
	 var depparentname=depfulname.substring(0,depfulname.lastIndexOf("·")+1);
	 var tagHtml="<li class=\"AccessUl_li\">";
		tagHtml+="<label>"+depparentname+"</label>";
		tagHtml+="<label class=\"color17\">${userdep.depname}</label>";
		tagHtml+="<div class=\"deleteIcon\" id=\"${userdep.pid}\" onclick=\"delChooseDep(this)\"></div></li>";						
		chooseDepIdArray.push("${userdep.pid}");			
		chooseDepNameArray.push("${userdep.depfullname}");
		$(".AccessUl").append(tagHtml);
	</c:forEach>
	}else{
		 var tagHtml="<li class=\"AccessUl_li\">";
			tagHtml+="<label></label>";
			tagHtml+="<label class=\"color17\"></label>";
			tagHtml+="<div></div></li>";			
			$(".AccessUl").append(tagHtml);	
	}
    window.parent.iFrameHeight("rightFrame2"); 
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
	
	function  openUserDepTree(loginname){
		 layer.open({           
	     type: 2,//设定弹窗为iframe嵌套页面
	     title: ['用户选择部门', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	     area: ['900px', '560px'], 
	     content: "${ctx}/usermanager/bsuserinfo/bsUserDepTree.action?loginname="+loginname
	     //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	     });
	}	
	function closeUserDepTree(choosedepids,choosedepfullnames){
			$("#depid").val(choosedepids);
			$("#depname").val(choosedepfullnames.join(" "));
			chooseDepIdArray=new Array();
			chooseDepNameArray=new Array();	
			$(".AccessUl").html(null);
			//$(".AccessUl").append("<li class=\"AccessUl_li_head\">已选部门列表</li>");			
			var choosedeplen=choosedepids.length;
			if(choosedeplen>0){			
			for(var j=0;j<choosedeplen;j++){
			var depid=choosedepids[j];
			var depparentname=choosedepfullnames[j].substring(0,choosedepfullnames[j].lastIndexOf("·")+1);	
			var depname=choosedepfullnames[j].substring(choosedepfullnames[j].lastIndexOf("·")+1);	
			 var tagHtml="<li class=\"AccessUl_li\">";
				tagHtml+="<label>"+depparentname+"</label>";
				tagHtml+="<label class=\"color17\">"+depname+"</label>";
				tagHtml+="<div class=\"deleteIcon\" id=\""+depid+"\" onclick=\"delChooseDep(this)\"></div></li>";						
				$(".AccessUl").append(tagHtml);		
			}
			}else{
				var tagHtml="<li class=\"AccessUl_li\">";
				tagHtml+="<label></label>";
				tagHtml+="<label class=\"color17\"></label>";
				tagHtml+="<div></div></li>";			
				$(".AccessUl").append(tagHtml);	
			}			
			chooseDepIdArray=new Array().concat(choosedepids) ;   //[].concat(a)把一个数组赋值给另一个数组
			chooseDepNameArray=new Array().concat(choosedepfullnames);
			//alert(chooseDepIdArray+"\\"+chooseDepNameArray);
			window.parent.iFrameHeight("rightFrame2"); 			
	}
	function delChooseDep(key){	
		var depid=$(key).attr("id");
		var locationIndex=$.inArray(depid,chooseDepIdArray); //如locationIndex=-1,-1 指最后一个元素，-2 指倒数第二个元素
		chooseDepIdArray.splice(locationIndex,1);	
		chooseDepNameArray.splice(locationIndex,1);		
		$(key).parent().remove();
		var chooseDepLen=chooseDepIdArray.length;
		if(chooseDepLen==0){
			 var tagHtml="<li class=\"AccessUl_li\">";
				tagHtml+="<label></label>";
				tagHtml+="<label class=\"color17\"></label>";
				tagHtml+="<div></div></li>";			
				$(".AccessUl").append(tagHtml);			
		}		
		$("#depid").val(chooseDepIdArray);
		$("#depname").val(chooseDepNameArray.join(" "));		
	}	
	
	function checkSubmit() {		
		if (Validator.Validate(document.myform, 2)) {
			var flag = validateLoginname();
			var roleids = $("input[name='roleids']:checked");
			//var roleidsArray= $(roleids).map(function() {return this.value; }).get(); //选中的checkbox值的数组
			//var roleidsStr= $(roleids).map(function() {return this.value; }).get().join(",");//选中checkbox值的字符串
			//var defaultIndex=$.inArray("0",roleidsArray);//是否选中默认角色			
			if (flag) {
				if (roleids.length == 0) {
					alert("角色必须选择！");
					return;
				} 
				/**else if(defaultIndex==-1){
					alert("默认角色必须选择！");
					return;
				}*/
				  $("#isanalyzer").removeAttr("disabled"); //如果form里的表单标签被disabled掉了就取不到 ,disabled状态下是不能传值的
					$("#isdeveloper").removeAttr("disabled"); //只能在取值的瞬间将他们的disabled属性remove掉,取完后再还原 
					$("#isdepleader").removeAttr("disabled");
					var myformdata= $(myform).serialize(); //form取值
					 $("#isanalyzer").attr("disabled",true);//from取完值后还原
					 $("#isdeveloper").attr("disabled",true);
					 $("#isdepleader").attr("disabled",true);
					 $.post("${ctx}/usermanager/bsuserinfo/bsUserinfoSave.action",
							   myformdata,
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
								 //window.parent.location.reload();
								 //var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			                     //parent.layer.close(index);
								 window.location.href="${ctx}/usermanager/bsuserinfo/bsUserinfoList.action";
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
				}
			}
		}

	 function clearMessage() {
			//document.myform.reset();
			//var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		   //parent.layer.close(index);
			
	 }	
	function checkbox_check1(event) {
		var ev = event || window.event;
		var target = ev.target || ev.srcElement;
		var checkvalue=$(target).prop("value");		
		var checkflag=$(target).prop("checked");		
		if (checkflag) {
			$(target).attr("checked", "checked");
			$(target).parent().addClass("on_check1");
		}
		/**else if(checkvalue=='0') {
			$(target).prop("checked","true");
			alert("默认角色必须选择！");
		}*/		
		else{
			$(target)[0].removeAttribute("checked");
			$(target).parent().removeClass("on_check1");
		}
	}
</script>	
</body>	
	</html>