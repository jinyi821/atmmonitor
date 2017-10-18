<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="nowTime" class="java.util.Date" /> 
<fmt:formatDate value="${nowTime}" type="both" dateStyle="long" pattern="yyyyMMdd" var="nowDate"/>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/slideMenu.css" />
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/header.js" ></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
<div class="header0">
	<div class="Ct sContent">
		<table class="base_table">
			<tr>
				<td>
					<div class="logo"></div>
				</td>
				<td>
					<c:forEach items="${navigatorMenu}" var="menu" varStatus="status">
						<input type="button" value="${menu.menuname}" name="menubutton" id="menubutton_${menu.menuid}"
							class="<c:if test="${status.index==0}">h_btn h_btnClick</c:if><c:if test="${status.index>0}">h_btn</c:if>"
							onclick="openMenu('${menu.menuurl}','${menu.menuid}')" />
					</c:forEach>
				</td>
				<td>
					<ul id="headerNav">
						<li class="firstLi">													
								<div class="user" style="margin-bottom: 29px;" id="userIcon"></div>
								<div class="overflowDiv">
									<label class="font colortext_alignLeft" id="username">
										<c:choose>  
											<c:when test="${sessionScope.userSession.fullname!=null&&sessionScope.userSession.fullname!=''}"> 
											        ${sessionScope.userSession.fullname}
											</c:when>  
											<c:otherwise>
											       ${sessionScope.userSession.loginname}
											</c:otherwise>  
										</c:choose>
									</label>
								</div>
								<div class="arrow2 marginBottom4"></div>						
							<ul style="display:none">
							<%--  <li class="Reposition">	
								<div class="headArrow"></div>	
								<a href="javascript:updatePassword('${sessionScope.userSession.loginname}');">修改密码</a></li>
								<li> 					
								<a href="javascript:exitLogin();">退出</a></li> --%>
				        	 

							    <li class="Reposition">	
								<a href="javascript:exitLogin();">退出</a></li>								
							</ul>							
							</li>				
							</ul>
							
					  <div class="ClearFloat"></div> 
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	var menuId = "${menuId}";
	
</script>
