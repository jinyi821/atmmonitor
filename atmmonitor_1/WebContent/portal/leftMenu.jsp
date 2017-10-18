<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>数据共享平台头部</title>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta name="renderer" content="webkit">
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/common.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/main.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/page/wh.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/rightMenuTree.css" />
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/select2.js"></script><%--必须加，否则一级菜单切换不正常 --%>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/changeTab.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/checkboxModal.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/wh.js"></script>
<link rel="stylesheet" type="text/css"href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css" />
</head>
<body>
	<div id="leftMenuTree" class="leftMenuTree">
	    <c:forEach items="${secondMenu}" var="menu"  varStatus="status">
	        <div class="leftMenuTree_part">
				<div class="leftMenuTree_partDiv" onclick="showList(this,'mark1')">
					<div  class=
					      <c:if test="${menu.menuname=='银行基本信息管理'}">"menuIcon1"</c:if>
					      <c:if test="${menu.menuname=='仓库'}">"menuIcon5"</c:if>
					      <c:if test="${menu.menuname=='人员信息和权限管理'}">"menuIcon2"</c:if>
					      <c:if test="${menu.menuname=='指标'}">"menuIcon3"</c:if>
					      <c:if test="${menu.menuname=='tableau'}">"menuIcon4"</c:if>
					      <c:if test="${menu.menuname=='看图'}">"menuIcon6"</c:if>
					       <c:if test="${menu.menuname=='日志'}">"menuIcon7"</c:if>
					       <c:if test="${menu.menuname=='信息发布'}">"menuIcon8"</c:if>
					       <c:if test="${menu.menuname=='字典维护'}">"menuIcon9"</c:if>  
					       <c:if test="${menu.menuname=='服务与培训'}">"menuIcon10"</c:if>
					       <c:if test="${menu.menuname=='监控'}">"menuIcon11"</c:if>
					       <c:if test="${menu.menuname=='任务调度'}">"menuIcon12"</c:if>
					       <c:if test="${menu.menuname=='统计'}">"menuIcon13"</c:if>
					        <c:if test="${menu.menuname=='业务流程处理'}">"menuIcon14"</c:if>
					        <c:if test="${menu.menuname=='数据超市'}">"menuIcon15"</c:if>
					        <c:if test="${menu.menuname=='Kylin维护'}">"menuIcon16"</c:if>
					        <c:if test="${menu.menuname=='平台工具'}">"menuIcon17"</c:if>	
					 >
					</div>
					<label class="menuLabel">${menu.menuname}</label>
					<c:if test="${processApprovalFlag=='false'}">
					<c:choose>
					   <c:when test="${status.index>0}">
							<div name="mark" class="showiconClick"></div>
						</c:when>
						<c:otherwise>
							<div name="mark" class="showicon"></div>
						</c:otherwise>
					</c:choose>	
					</c:if>
					<c:if test="${processApprovalFlag=='true'}">
					  <c:choose>
					   <c:when test="${menu.menuname=='业务流程处理'}">
					        <div name="mark" class="showicon"></div>
						</c:when>
						<c:otherwise>							
							<div name="mark" class="showiconClick"></div>
						</c:otherwise>
						</c:choose>	
					 </c:if>											
				</div>
				<c:if test="${processApprovalFlag=='false'}">
				<div name="mark1" <c:if test="${status.index>0}">style="display: none;"</c:if>>
				   <c:forEach items="${menu.childList}" var="childmenu"> 
						<ul class="menu_ul">
							<li onclick="gotoUrl('${ctx}/${childmenu.menuurl}',this)">${childmenu.menuname}</li>
						</ul>
					</c:forEach>	
				</div>
				</c:if>
			    <c:if test="${processApprovalFlag=='true'}">
			    <div name="mark1" <c:if test="${menu.menuname !='业务流程处理'}">style="display:none;"</c:if>>
				   <c:forEach items="${menu.childList}" var="childmenu"> 
						<ul class="menu_ul">
							<li id="<c:if test="${childmenu.menuname =='待审批业务流程'}">unApproval</c:if>" title="${ctx}/${childmenu.menuurl}" onclick="gotoUrl('${ctx}/${childmenu.menuurl}',this)">${childmenu.menuname}</li>
						</ul>
					</c:forEach>	
				</div>
			   </c:if>
		    </div>	    						 
	   </c:forEach>

	</div>
</body>
</html>
