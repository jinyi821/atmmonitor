<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/common/taglibs.jsp"%>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台看数</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	    <meta http-equiv="description" content="this is my page">
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/ks.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/CalculateHeight.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/ks.js" ></script>
	</head>
	<body>
		<div class="divsection">
	    	<form>
	    		<%@ include file="/portal/header.jsp"%> 
	    		<!--
                	时间：2016-03-28
                	描述：看数页面
                -->
                <div class="TabHead">
                	<div class="Ct">                	   
                	<c:forEach items="${secondMenu}" var="menu"  varStatus="status">
                	<input type="button" value="${menu.menuname}" class="Tabbtn  
                	<c:if test="${status.index==0}">Tabbtn_active</c:if>
                	" onclick="showInfo1(event,'Tabbtn_active','${menu.menuid}')"/>
                	</c:forEach>
                	<!--<input type="button" value="数据地图" class="Tabbtn  Tabbtn_active" onclick="showInfo1(event,'Tabbtn_active','dtMap')"/>
                		<input type="button" value="查询与订阅" class="Tabbtn " onclick="showInfo1(event,'Tabbtn_active','searchAndSubs')"/>
                	-->
                	</div>
                </div>
                <div class="bgColor1 contentDiv">
                	<div class="Ct">                	
                	<c:forEach items="${secondMenu}" var="menu"  varStatus="status">
                	 <div id="${menu.menuid}"   <c:if test="${status.index>0}">style="display: none;"</c:if>>
		                	<div class="ks_leftMenu">
		                	<c:forEach items="${menu.childList}" var="childmenu1" varStatus="status1" >
		                	 <div class="ks_leftMenu_part">
					    			<div class="ks_leftMenu_partDiv" onclick="showMenuLi(this)">
					    				<div class=
					    				  <c:if test="${childmenu1.menuname=='平台地图'}">"ks_menuIcon1"</c:if>
					                      <c:if test="${childmenu1.menuname=='仓库地图'}">"ks_menuIcon2"</c:if>
					                       <c:if test="${childmenu1.menuname=='通用查询'}">"ks_menuIcon4"</c:if>
					                      <c:if test="${childmenu1.menuname=='我的订阅'}">"ks_menuIcon3"</c:if>
					                   ></div>
					    				<label class="ks_menuLabel">${childmenu1.menuname}</label>
					    			</div>
					    			<div name="mark1">
					    				<ul class="ks_menu_ul">	
					    				  <c:if test="${childmenu1.menuname=='平台地图'}">
					    				      <c:forEach items="${childmenu1.childList}" var="childmenu2" varStatus="status2">
					    				    	<li  name="dataMapLi" onclick="gotoUrl('lookNumberFrame','ks_liClick','${ctx}/${childmenu2.menuurl}',this)">${childmenu2.menuname}</li>
					    				    </c:forEach>					    				   
					    				   </c:if>						    				    				
					    				   <c:if test="${childmenu1.menuname=='仓库地图'}">
					    				   <c:forEach items="${domains }" var="domain">
											  <li  name="dataMapLi"  onclick="gotoUrl('lookNumberFrame','ks_liClick','${ctx}/datamap/dataview/metadaWarehouseMap.action?domainId=${domain. domain_id}&domainName=${domain. domain_name}',this)">${domain. domain_name}</li>
										    </c:forEach>					    				   
					    				   </c:if>
					    				    <c:if test="${childmenu1.menuname=='通用查询'}">
					    				      <c:forEach items="${childmenu1.childList}" var="childmenu2" varStatus="status2">
					    				    	<li class="ks_liClick" name="searchAndSubsLi"   onclick="gotoUrl('searchAndSubsFrame','ks_liClick','${ctx}/${childmenu2.menuurl}',this)")">${childmenu2.menuname}</li>
					    				    </c:forEach>					    				   
					    				   </c:if> 
					    				      <c:if test="${childmenu1.menuname=='我的订阅'}">
					    				      <c:forEach items="${childmenu1.childList}" var="childmenu2" varStatus="status2">
					    				      <li  name="searchAndSubsLi"  onclick="showInfo1(event,'ks_liClick','')">${childmenu2.menuname}</li>
					    				      	</c:forEach>
					    				      </c:if>		    				   					    				 					    					
					    				</ul>
					    			</div>
					    		</div>
		                	</c:forEach>		                	
		                	</div>
		                	<c:if test="${menu.menuname=='数据地图'}">
		                	<div class="dtMap_rightContent">		                		
		                		<iframe src="" frameBorder="0" style="min-height:586px "  id="lookNumberFrame" width="100%"  name="lookNumberFrame" scrolling="no"></iframe>
		                	</div>         	
		                	</c:if>
		                	<c:if test="${menu.menuname=='查询与订阅'}">
		                	<div class="rss_rightContent">
                            	<iframe src="" frameBorder="0" style="min-height:586px "  id="searchAndSubsFrame" width="100%"  name="searchAndSubsFrame" scrolling="no"></iframe>
		                	</div>
		                	</c:if>
		                	<div class="ClearFloat"></div>
		                </div>                	
                	</c:forEach>
                		   <!--<div id="dtMap">
		                	<div class="ks_leftMenu">
		                		<div class="ks_leftMenu_part">
					    			<div class="ks_leftMenu_partDiv" onclick="showMenuLi(this)">
					    				<div class="ks_menuIcon1"></div>
					    				<label class="ks_menuLabel">平台地图</label>
					    			</div>
					    			<div name="mark1">
					    				<ul class="ks_menu_ul">-->
					    				<!-- //showInfo1(event,'ks_liClick','') -->
					    					<!-- <li name="dataMapLi"  onclick="gotoUrl('lookNumberFrame','ks_liClick','${ctx}/datamap/dataview/metadatamap.action',this)">全部数据索引</li>
					    					<li name="dataMapLi"  onclick="gotoUrl('lookNumberFrame','ks_liClick','${ctx}/datamap/dataview/metadaRectangleTreeMap.action',this)">数据热度图</li>
					    				</ul>
					    			</div>
					    		</div>
					    		<div class="ks_leftMenu_part">
					    			<div class="ks_leftMenu_partDiv" onclick="showMenuLi(this)">
					    				<div class="ks_menuIcon2"></div>
					    				<label class="ks_menuLabel">仓库地图</label>
					    			</div>
					    			<div name="mark2">
					    				<ul class="ks_menu_ul">
					    					<c:forEach items="${domains }" var="domain">
											   <%-- 	<div class="project_block">
											   	 	<div class="project_name"><a href="javascript:getcolumnsetTypes('${domain. domain_id}','${domain. domain_name}')">${domain. domain_name}</a></div>
											        <div class="clear"></div>
											    </div> --%>
											    <li name="dataMapLi" onclick="gotoUrl('lookNumberFrame','ks_liClick','${ctx}/datamap/dataview/metadaWarehouseMap.action?domainId=${domain. domain_id}&domainName=${domain. domain_name}',this)">${domain. domain_name}</li>
										    </c:forEach>
					    				</ul>
					    			</div>
					    		</div>
		                	</div>
		                	<div class="dtMap_rightContent" style="width: 980px;"> -->
		                		<!-- //<div class="ks_shili"></div> -->
		                		<!--<iframe src="" frameBorder="0" style="min-height:586px "  id="lookNumberFrame" width="100%"  name="lookNumberFrame" scrolling="no"></iframe>
		                	</div>
		                	<div class="ClearFloat"></div>
		                </div> -->
		                <!--
                        	时间：2016-03-28
                        	描述：查询与订阅
                        -->
		               <!-- <div id="searchAndSubs" style="display: none;">
		                	<div class="ks_leftMenu">
		                		<div class="ks_leftMenu_part">
					    			<div class="ks_leftMenu_partDiv" onclick="showMenuLi(this)">
					    				<div class="ks_menuIcon4"></div>
					    				<label class="ks_menuLabel">通用查询</label>
					    			</div>
					    			<div name="mark3">
					    				<ul class="ks_menu_ul">
					    					<li class="ks_liClick" name="searchAndSubsLi" onclick="gotoUrl('searchAndSubsFrame','ks_liClick','${ctx}/indicator/indexSearchList.jsp',this)")">指标检索</li>
					    				</ul>
					    			</div>
					    		</div>
					    		<div class="ks_leftMenu_part">
					    			<div class="ks_leftMenu_partDiv" onclick="showMenuLi(this)">
					    				<div class="ks_menuIcon3"></div>
					    				<label class="ks_menuLabel">我的订阅</label>
					    			</div>
					    			<div name="mark4">
					    				<ul class="ks_menu_ul">
					    					<li name="searchAndSubsLi" onclick="showInfo1(event,'ks_liClick','')">订阅结果1</li>
					    					<li name="searchAndSubsLi" onclick="showInfo1(event,'ks_liClick','')">订阅结果2</li>
					    				</ul>
					    			</div>
					    		</div>
		                	</div>-->
		                	<!--
                            	时间：2016-03-29
                            	描述：右侧内容
                            -->
                            <!--<div class="rss_rightContent">
                            	<iframe src="" frameBorder="0" style="min-height:586px "  id="searchAndSubsFrame" width="100%"  name="searchAndSubsFrame" scrolling="no"></iframe>
		                	</div>
		                	<div class="ClearFloat"></div>
		                </div>
		               -->
		                
		                
	               </div>
                </div>
                <div class="bodyFoot">
                	<label class="font1 color3">Copyright2016 辽宁移动</label>
                </div>
            </form>
       	</div>
       	<script type="text/javascript">
       		function gotoUrl(iframeId,className,url,obj){
       			var name = $(obj).attr("name");
       			$("[name='"+name+"']").each(function(){
       				$(this).attr("class","");
       			});
       			$(obj).attr("class",className);
       			$("#"+iframeId).attr("src",url);
       		}
       		function iFrameHeight(id) {
			      var ifm= document.getElementById(id);
			      var subWeb = document.frames ? document.frames[id].document :ifm.contentDocument;
			      if(ifm != null && subWeb != null) {
			      	ifm.height = subWeb.body.scrollHeight+20;
			      	 $("#rightContent").css("height",subWeb.body.scrollHeight+20+"px");
			      	$("#wh_contentDiv").css("height",subWeb.body.scrollHeight+30+"px"); 
			      	 	/*  $("#treeDiv").css("height",subWeb.body.scrollHeight+20+"px"); */
			      }
			}
       		
       	</script>
	</body>
</html>
