<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	String root_openfile = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +  "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<%@ include file="/common/taglibs.jsp"%> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台</title>
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />	  
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/mycss.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/idangerous.swiper.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/idangerous.swiper.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/myjs.js" ></script>
	    <script type="text/javascript" src="${ctx}/portal/js/index.js" ></script>
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/slideMenu.css" />
	    <style type="text/css">
	     .swiper-container {        
         	height: 1460px; 
         } 
         .chart1 {
		 	background: url(${ctx}/common/style/newstyle/images/chart8.jpg) no-repeat; background-size:250px 160px;
		 }
	    </style>	  	    	
</head>
<body>
 	<div class="divsection">
	    	<form>
	    		<%@ include file="/portal/header.jsp"%> 
	    		<%-- <%@ portal/header.jsp%> --%>
	    		<!--
                	时间：2016-03-17
                	描述：banner轮播区域
                -->
                <c:forEach var="event" items="${eventList }" varStatus="status" end="0">
                <c:set var="bgcolor" value="${event.pic_bgcolor}"/>
                </c:forEach>                
	    		<div class="bannerDiv bgColor Reposition" id = "loopDiv" style="background-color:${bgcolor}">
                      <div class="Ct sContent">
	    				<div class="swiper-container">
						  <div class="swiper-wrapper">
						 <c:forEach var="event" items="${eventList }" varStatus="status">
						   <div class="swiper-slide" >						  
		                     <img src="../../upload/eventimgfile/${event.event_pic}" style="width: 1200px;height: 330px;cursor:pointer;" onclick="showEventDetail(${event.pid})" />
		                     <input type="hidden" name="backgroundcolor" id="backgroundcolor_${event.pid}" value="${event.pic_bgcolor}" />
		                   </div>						  
						   </c:forEach>		 
						<!--<div class="swiper-slide">
						    	<div class="bannerIcon1"></div>
						    </div>
						    <div class="swiper-slide">
						    	<div class="bannerIcon2 img_cursor"></div>
						    </div>
						    <div class="swiper-slide">
						    	<div class="bannerIcon1"></div>
						    </div>-->						   
						 </div>
						
						  <!--<div class="swiper-pagination"></div>-->
						  <div class="pagination"></div>
						</div>
	    			</div>	    	
	    			<div class="TgContent"></div>
	    			<div class="TgContent1">
	    				<div class="Ct sContent tgMask">
	    					<table class="base_table font1 color1">
	    						<tr>
	    							<td width="17%">
	    								<div class="tgIcon"></div>
	    							</td>
	    					<c:forEach var="notice" items="${noticeList }" varStatus="status" end="3">
							<c:set var="index" value="${status.index+1}" />
							<c:if test="${index<4}">
							<td width="30%">
	    					     <a class="tgA" href="${ctx }/information/bsnotice/bsNoticeDetail.action?pid=${notice.pid}" target="_blank">·[${notice.publishdate}]${notice.notice_title}</a>
	    					</td>	    					
	    					</c:if>	
	    					<c:if test="${index==4}">
	    					<c:set var="exitId" value="0"></c:set>	    					
	    					</c:if>	    													
							</c:forEach> 		
	    					<c:if test="${exitId==0}">
	    					<td width="11%">
	    						<input type="button" value="更多>>" class="more" onclick="window.open('${ctx }/information/bsnotice/bsNoticeIndexList.action');"/>
	    					</td>
	    					</c:if>		    							
	    					<!-- <td width="24%">
	    								<a class="tgA">·[3-10] 辽宁移动数据共享平台上线！</a>
	    							</td>
	    							<td width="24%">
	    								<a class="tgA">·[3-11] 辽宁移动数据共享平台上线！</a>
	    							</td>
	    							<td width="24%">
	    								<a class="tgA">·[3-11] 辽宁移动数据共享平台上线！</a>
	    							</td>
	    							<td width="11%">
	    								<input type="button" value="更多>>" class="more"/>
	    							</td>	-->
	    						</tr>
	    					</table>
	    				</div>
	    			</div>
	    		</div>
	    		<!--
                	时间：2016-03-17
                	描述：正文主体部分
                -->
                <div class="content_part1">
                	<div class="Ct sContent contentIcon">
                		<!--<div class="contentIcon"></div>-->
                		<div class="Reposition">
                			<div class="content_part1_Content base_align_center color2">
                				<p class="pHeight1">
                					<label class="fontSize">掘金者俱乐部</label>
                				</p>
                				<p class="pHeight marginTop">
                					<label class="fontSize1">闪闪发光的大数据金矿，等待着每一位掘金者去挖掘。</label>
                				</p>
                				<p class="pHeight">
                					<label class="fontSize1">在这里，土豪们，请尽情的炫富吧~</label>
                				</p>
                				<p class="marginTop">
                					<input type="button" value="查看更多" class="showmoreBtn" onclick="window.open('${ctx}/digenvlist/showall.action');"/>
                				</p>
                			</div>
                		</div>
                	</div>
                </div>
                <div class="content_part2">
                	<div class="Ct sContent">
		               	<div id="tableauWorkbook">
		               	</div>
                		<div class="block2" style="z-index: 30">
                			<div class="block_head">
                				<div class="dataIcon"></div>
                				<label class="fontSize2 color3">数据分析排行</label>
                			</div>
                			<div >
                				<table class="base_table blockTable" id="tableauWorkbookRank" >
                					<c:forEach items="${rankList }" var="rank" varStatus="status">
                						<tr>
	                						<td onclick="getDetail('${rank[2]}')" style=" cursor:pointer;">
	                							<c:choose>
	                								<c:when test="${rank[0]<=3 }">
	                									<input type="button" value="${rank[0] }" class="numBtn" style=" cursor:pointer;"/>
	                								</c:when>
	                								<c:otherwise>
	                									<input type="button" value="${rank[0] }" class="numBtn1" style=" cursor:pointer;"/>
	                								</c:otherwise>
	                							</c:choose>
		                						<label class="font1 color2"  style=" cursor:pointer;">
		                							<c:choose>
		                								<c:when test="${fn:length(rank[3]) >14}">
		                									${fn:substring(rank[3],0,14) }...
		                								</c:when>
		                								<c:otherwise>
		                									${rank[3]}
		                								</c:otherwise>
		                							</c:choose> 
		                						</label>
		                						<div class="floatRight" style=" cursor:pointer;">
		                							<c:set value="${rank[1]==null ? rank[0] : rank[1]}" var="yestoday"></c:set>
			                						<c:choose>
		                								<c:when test="${rank[0]<=3 }">
		                									<%-- <label class="font color4">${rank[0]-yestoday>=0? rank[0]-yestoday:yestoday-rank[0]}</label> --%>
		                									<label class="font color4">${rank[4]}</label> 
		                								</c:when>
		                								<c:otherwise>
		                									<%-- <label class="font color">${rank[0]-yestoday>=0? rank[0]-yestoday:yestoday-rank[0]}</label> --%>
		                									<label class="font color">${rank[4]}</label>
		                								</c:otherwise>
		                							</c:choose>
		                							<c:choose>
		                								<c:when test="${rank[0]-yestoday==0 }">
		                									<div class="middleIcon"></div>
		                								</c:when>
		                								<c:when test="${rank[0]-yestoday>0 }">
		                									<div class="downIcon"></div>
		                								</c:when>
		                								<c:otherwise>
		                									<div class="top"></div>
		                								</c:otherwise>
		                							</c:choose>
		                						</div>
		                						<div class="ClearFloat"></div>
	                						</td>
	                					</tr>
                					</c:forEach> 
                				</table>
                			</div>
                		</div>
                		<div class="ClearFloat"></div>
                	</div>
                </div>
                <div class="content_part3">
                	<div class="Ct sContent contentIcon1">
                		<!--<div class="contentIcon"></div>-->
                		<div class="Reposition">
                			<div class="content_part3_Content base_align_center color2">
                				<p class="pHeight1">
                					<label class="fontSize">开发者大舞台</label>
                				</p>
                				<p class="pHeight marginTop">
                					<label class="fontSize1">光荣的IT民工们，这里是捞取成就感的舞台……</label>
                				</p>
                				<p class="pHeight">
                					<label class="fontSize1">聚光灯已经准备好，就等你闪亮登场！</label>
                				</p>
                				<p class="marginTop">
                					<input type="button" value="查看更多" class="showmoreBtn" onclick="window.open('${ctx}/developenvironment/appbaseinfo/showallappbaseinfo.action');"/>
                				</p>
                			</div>
                		</div>
                	</div>
                </div>
                <div class="content_part4">
                	<div class="Ct sContent">
                		<div id="appbaseinfo">
		               	</div>
		               	<!--  -->
                		<div class="block2" style="float: right;">
                			<div class="block_head">
                				<div class="dataIcon1"></div>
                				<label class="fontSize2 color3">应用排行</label>
                			</div>
                			<div>
                				<table class="base_table blockTable" id="appBaseinfoRank" >
                					<c:forEach items="${appList }" var="appList" varStatus="status">
                						<tr>
	                						<td onclick="openurl('${appList[5]}','${appList[2]}','${appList[6]}');" style=" cursor:pointer;">
	                							<c:choose>
	                								<c:when test="${appList[0]<=3 }">
	                									<input type="button" value="${appList[0] }" class="numBtn" style=" cursor:pointer;"/>
	                								</c:when>
	                								<c:otherwise>
	                									<input type="button" value="${appList[0] }" class="numBtn1" style=" cursor:pointer;"/>
	                								</c:otherwise>
	                							</c:choose>
		                						<label class="font1 color2"  style=" cursor:pointer;">
		                							<c:choose>
		                								<c:when test="${fn:length(appList[3]) >14}">
		                									${fn:substring(appList[3],0,14) }...
		                								</c:when>
		                								<c:otherwise>
		                									${appList[3]}
		                								</c:otherwise>
		                							</c:choose> 
		                						</label>
		                						<div class="floatRight" style=" cursor:pointer;">
		                							<c:set value="${appList[1]==null ? appList[0] : appList[1]}" var="yestoday"></c:set>
			                						<c:choose>
		                								<c:when test="${appList[0]<=3 }">
		                									<%-- <label class="font color4">${appList[0]-yestoday>=0? appList[0]-yestoday:yestoday-appList[0]}</label> --%>
		                									<label class="font color4">${appList[4]}</label> 
		                								</c:when>
		                								<c:otherwise>
		                									<%-- <label class="font color">${appList[0]-yestoday>=0? appList[0]-yestoday:yestoday-appList[0]}</label> --%>
		                									<label class="font color">${appList[4]}</label>
		                								</c:otherwise>
		                							</c:choose>
		                							<c:choose>
		                								<c:when test="${appList[0]-yestoday==0 }">
		                									<div class="middleIcon"></div>
		                								</c:when>
		                								<c:when test="${appList[0]-yestoday>0 }">
		                									<div class="downIcon"></div>
		                								</c:when>
		                								<c:otherwise>
		                									<div class="top"></div>
		                								</c:otherwise>
		                							</c:choose>
		                						</div>
		                						<div class="ClearFloat"></div>
	                						</td>
	                					</tr>
                					</c:forEach> 
                				</table>
                			</div>
                		</div>
                		<div class="ClearFloat"></div>
                	</div>
                </div>
                              
	    	</form>
	    </div>	
	    <script type="text/javascript">
	    var root = "<%=root_openfile%>";
	    
	    function showEventDetail(pid){
	    	window.open('${ctx}/information/bsevent/bsEventDetail.action?pid='+pid);	    	
	    }	
	    
	    function openurl(pid,appid,appurl){
	    	//window.open("${ctx}/developenvironment/appvistrecorder/appurlopen.action?appurl="+appurl+"&appid="+appid+"&pid="+pid);
	    	$.post("${ctx}/developenvironment/appvistrecorder/appVistRecorderSave.action",{"ppid":pid,"appid":appid,"appurl":appurl},function(result){
	    		if(result=="noPrivilege"){
	    			alert("无权限访问该应用！");
	    		}else{
	    			var httpstr = appurl.substr(0, 4);
	    			if(httpstr == "http"){
	    				 window.open(appurl);	
	    			} else {
	    				 window.open("http://"+appurl);	
	    			}
	    		}
	    	});	
	    } 
	    </script> 
</body>
</html>