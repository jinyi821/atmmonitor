<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <%@ include file="/common/taglibs.jsp"%>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>查看有用用户列表</title>
         <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>	
	     <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>  
<style type="text/css">
.divContent{
	width: 99.4%;	
	margin-left:1px;	
	border: 1px solid #dddddd;
	background: #fdfdfd;
	display: inline-block;
	float: left;
	height:480px;
}
.base3{
	text-align: center;
	margin-top:0px ;
	margin-bottom:0px;
}
.table_head,.table_body tr{
	height: 30px;
	line-height: 30px;
}
</style>
</head>
<body>
 <div class="divContent">
 <div class="wh_modal_head borderBottom Reposition">
		                       <input type="button" value="选择用户" class="blueBtn"/>
								<div class="searchInfo">
									<input type="text" class="searchInput"  id="par_condition"
										name="par_condition" />
									<div class="searchIcon"></div>
									<input type="button" value="搜索" class="base3_btn1"
										onclick="query()" />
								</div>	                				
	                				</div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable1">
	                						<thead class="table_head fontSize3">
	                						<td></td>
										    <td>登录名</td>
										     <td>用户名</td>
										      <td>性别</td>
		                                     <td>email</td>
		                                     <td>手机号</td>
		                                      <td>状态</td>
	                						</thead>
	                						<tbody class="table_body">
	                						<tr>
										     	<td><input type="radio" name="checkbox" value="@@{loginname}"/>  <!--onclick="checkRadio(this);"--></td>
											<td align="center"><label>@@{loginname}</label></td>
											<td align="center"><label>@@{fullname}</label></td>	
										   <td align="center">@@{sex}</td>
		                                   <td align="center">@@{email}</td>
		                                  <td align="center">@@{mobile}</td>		   
		                                   <td align="center">@@{status[ENUM 1=正常;0=停用;]}</td>	    
		                               </tr>	
	                						</tbody>
	                					</table>	                				
	                				 
	                		<div align="center">
				<input type="button" value="保存" class="base3_btn1"
					onclick="checkSubmit();" /> <input type="button" value="取消"
					class="base3_btn2" onclick="checkReturn();" />
			</div>		
 </div>
</body>
<script type="text/javascript">
function preFunc(paraStr) {
	paraStr.isCount = 2;
	paraStr.par_condition = $("#par_condition").val();
}
function dataFunc(dataRow) {
	//dataRow.username=dataRow.username+"【自定义】";
}
var table = new ListTable("listtable1", "${ctx}/commonQuery/query.action",
		10, [ [ "sqlname", "SQL_BsUserinfo.bsUserinfoUseList" ] ], preFunc,
		dataFunc,tableBoot);
function query() {	
	table.submit();		
}

function checkRadio(obj) {
	var check = obj.checked;	
	var loginname = obj.value;
	var ck1 = $("input[name='checkbox']")
	$.each(ck1, function() {
		var val = $(this).val();
		if (val != loginname) {
			$(this).attr("disabled", true);
		}
	});
}
function checkSubmit(){
	var chooseloginname = $("input[name='checkbox']:checked").val();
	if (chooseloginname == null) {
		alert("请选择用户!");
		return;			
	}
	//parent.window.document.getElementById("loginname").value=chooseloginname; //layer子窗口向父窗口传值
	//parent.$("#loginname").val(chooseloginname); //layer子窗口向父窗口传值	
	var loginname=parent.$("#loginname").val();
	if(chooseloginname!=loginname){
		parent.$("#loginname").val(chooseloginname); //layer子窗口向父窗口传值	
		parent.clearChooseDep();
	}
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index); 	
}
function checkReturn(){	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);	
}
</script>
</html>