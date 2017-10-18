<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/taglibs.jsp"%> 	  
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>数据共享平台资源管理</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />	   
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
<script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
<!--<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>-->
<script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
</head>
<body>
<div class="rightContent DivHeight  " style="width:97%;margin-top: 10px;">
	<div class="wh_modal_head borderBottom Reposition ">
		<div class="searchInfo">
			<input type="text" class="searchInput" id="par_condition" name="par_condition" />
			<div class="searchIcon"></div>
			<input type="button" value="搜索" class="base3_btn1" onclick="query()" />
		</div>
	</div>
	<div>
		<table class="base_table base_align_center changeTrColor" id="listtable">
			<thead class="table_head fontSize3">
				<td></td>
				<td>审批人登录名</td>
				<td>用户名</td>		                                     
			</thead>
			<tbody class="table_body">
				<tr>
					<td><input type="radio" name="checkbox1" value="@@{loginname},@@{fullname}" /></td>
					<td align="center">@@{loginname}</td>
					<td align="center">@@{fullname}</td>
				</tr>
			</tbody>
		</table>
		<div class="ClearFloat"></div>
	</div>
</div>
<div  style="text-align: center;">
	<input type="button" value="确定" class="base3_btn1" onclick="submitForm()" style="margin-top: 10px;" />
</div>
</body>
<script type="text/javascript">
  var index = parent.layer.getFrameIndex(window.name); 
	function preFunc(paraStr)
	{
		paraStr.isCount = 2;
		paraStr.par_condition=$("#par_condition").val();
	}
	function dataFunc(dataRow)
	{
		//if(dataRow.username=="lisi")
		//dataRow.username=dataRow.username+"【自定义】";
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserinfo.bsUserinfoUseList"]],preFunc,dataFunc,tableBoot);
	function query()
	{
		table.submit();
	}
		function submitForm(){
			var userinfo=$("#listtable input[name='checkbox1']:checked").val();
			if(userinfo){
				loginname = userinfo.split(",")[0];
				fullname = userinfo.split(",")[1];
				window.parent.closeResource(loginname,fullname);
			}
			parent.layer.close(index);
		}
	function parentiFrameHeight(){
				window.parent.iFrameHeight("rightFrame2");
			}
</script>
</html>