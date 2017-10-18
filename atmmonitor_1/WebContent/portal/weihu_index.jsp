<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
	<%@ include file="/common/taglibs.jsp"%> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台</title>
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
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/rightMenuTree.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/mycss.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/setIframeHeight.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	    <script type="text/javascript" src="${ctx}/portal/js/Sys.js" ></script>
</head>
<body>
 	<div class="divsection">
	    	<form>
	    		<%@ include file="/portal/header.jsp"%> 
	    		<!--
                	时间：2016-03-23
                	描述：维护页面
                -->
                <div class="bgColor1 wh_contentDiv borderTop" id="wh_contentDiv">
                	<div class="wh_content" >
                		<!--
                    	时间：2016-03-28
                    	描述：左侧菜单
	                    -->
	  				<%@include  file="leftMenu.jsp"  %>	
                		<div class="rightDiv">
			                <!--
		                    	时间：2016-03-24
		                    	描述：模型
		                    -->
	                		<div  id="mx">			
		        				<!-- <iframe  style="width:100%"></iframe> -->
		        				<iframe src="" frameBorder="0" id="rightFrame2" width="100%"  name="rightFrame2" scrolling="no" style="min-height: 605px;"></iframe>
	                			<div class="ClearFloat"></div>
	                		</div>
	                	</div>
	                	<div class="ClearFloat"></div>
                	</div>
                </div>
                
	    	</form>
	   </div>
	   <script type="text/javascript">
	        var processApprovalFlag="${processApprovalFlag}";
	   		window.onload=function(){
	   			if(processApprovalFlag=="true"){
	   				var obj=$("#unApproval")[0];	   			
	   				var url=$("#unApproval").attr("title");
	   				gotoUrl(url,obj);	   				
	   			}else{
	   			 $("#leftMenuTree li:first").each(function(){
	       		  		var onclick= $(this).attr("onclick");
	       		  		eval(onclick);
	       		 });
	   			}
	   		};
   			function gotoUrl(url,obj){
   				$("#leftMenuTree li").each(function(){
   					$(this).attr("class","");
   				});
   				$(obj).attr("class","liClick");
				document.getElementById("rightFrame2").src=url;
	   		}
	   		function iFrameHeight(id) {
		      	var height; 
		      	var ifm= document.getElementById(id);
		     	if(Sys.chrome||Sys.safari){
			     	height=ifm.contentWindow.document.documentElement.scrollHeight;
		     	}else {  //Sys.ie||Sys.firefox||Sys.opera
		     		height = ifm.contentWindow.document.body.scrollHeight; 
		     	}
		     	ifm.height = height;
		      	$("#wh_contentDiv").css("height",height+"px"); 
			      	 	/*  $("#treeDiv").css("height",subWeb.body.scrollHeight+20+"px"); */
			}
	   </script>
</body>
</html>