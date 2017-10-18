<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%> 	  
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>数据共享平台用户管理</title>
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
<script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
</head>  
<body>
<div class="divsection">	    	
	<div class="bgColor1 wh_contentDiv">	               
		<div  id="mx">
			<div class="wh_content">
				<div class="rightDiv">
					<div class="mxContent DivHeight marginBottom marginTop" style="width:98%;">
						<div class="wh_modal_head borderBottom Reposition">
							<input type="button" value="新增" class="blueBtn" onclick="add()" />
							<div class="searchInfo">
								<input type="text" class="searchInput" id="par_condition" name="par_condition" />
								<div class="searchIcon"></div>
								<input type="button" value="搜索" class="base3_btn1" onclick="query()" />
							</div>	                				
						</div>	                			
						<div>
							<table class="base_table base_align_center changeTrColor" id="listtable">
       							<thead class="table_head fontSize3">
									<td>审批权限</td>
									<td>审批人登录名</td>
									<td>用户名</td>
									<td>创建时间</td>
									<td>操作</td>
								</thead>
								<tbody class="table_body">
									<tr>
										<td align="center">@@{approve_type[ENUM 1=开发者、分析师;2=tableau发布审批;]}</td>
		                                <td align="center">@@{loginname}</td>
		                                <td align="center">@@{fullname}</td>
		                                <td align="center">@@{createtime[TIME]}</td>
										<td align="center">
											<input type="button" class="transparentBtn" onclick="updateBsResourceUrl('@@{pid}')"	value="编辑" />
											<input type="button" class="transparentBtn" onclick="deleteBsResourceUrl('@@{pid}')" value="删除" />
										</td>
									</tr>	
								</tbody>
							</table>	                				
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> 
</body>
<script type="text/javascript">
window.onload = function() {
	if ('${flag}' == 'success') {
		alert("保存成功");
	} else if ('${flag}' == 'del') {
		alert("删除成功");
	} else if ('${flag}' == 'error') {
		alert("操作失败");
	}else if ('${flag}' == 'saveError') {
		alert("操作失败,资源已存在!");
	}
};
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
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsApporvePerson.bsApporvePersonList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	function add() {
		window.location.href = "${ctx}/usermanager/bsapporveperson/bsApporvePersonLoad.action";
	}
	function updateBsResourceUrl(pid) {
		window.location.href = "${ctx}/usermanager/bsapporveperson/bsApporvePersonLoad.action?pid=" + pid;
	}
	function deleteBsResourceUrl(pid) {
		var name = confirm("确定删除该条审批权限信息？");
		if (name) {
			$.post("${ctx}/usermanager/bsapporveperson/bsApporvePersonDel.action", {"pid":pid}, function(result){					 
				 if(result == "del"){	
					 alert("删除成功！"); 
					 window.location.href = "${ctx}/usermanager/bsapporveperson/bsApporvePersonList.action";
				 }
		   });	
		}
	}
	function parentiFrameHeight(){
				window.parent.iFrameHeight("rightFrame2");
			}
</script>
</html>