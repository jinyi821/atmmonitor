<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
		<%@ include file="/common/taglibs.jsp"%>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>应用统计页面</title>
		<meta http-equiv="keywords" content="">
	    <meta http-equiv="description" content="">
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />	   
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
<!-- 	    <link rel="stylesheet" type="text/css" href="${ctx}/statistics/equipment/style/css/MyReset.css"> -->
<!-- 		<link rel="stylesheet" type="text/css" href="${ctx}/statistics/equipment/style/css/common.css"> -->
<!-- 		<link rel="stylesheet" type="text/css" href="${ctx}/statistics/equipment/style/css/main.css"> -->
		<link rel="stylesheet" type="text/css" href="${ctx}/statistics/equipment/style/css/tj.css">
		
		<script type="text/javascript" src="${ctx}/common/js/echart-3.1.5/echarts.common.min.js"></script>
		
		<script type="text/javascript" src="${ctx}/statistics/equipment/js/apply.js"></script>

  </head>
  
  <body>
     <%@ include file="/portal/header.jsp"%> 
    
     <div class="bgColor1 contentDiv divsection" style="boder:1px solid #dddddd">    
	   <div class="Ct">
   			<div id="AppTj"><%--class="paddingTop2"--%>
           		<div>
           		    
           		 
                      <div class="BlockDiv userTjLeftBlock" style="margin-top: 10px">
			              	<p>
			                	<label class="fontSize5">支行ATM设备统计</label>
			                </p>
			                <div class="marginTop">
			                	<div id="container" style="height:326px" ></div>
			                </div>
			            </div>
			            <div class="BlockDiv userTjRightBlock" style="margin-top: 10px">
			                <p>
			                	<label class="fontSize5">支行ATM设备故障统计</label>
			                </p>
			                <div class="marginTop">
			                	<div id="container1" style="height:326px"></div>
			                </div>
			            </div>
           			<div class="ClearFloat"></div>
           		</div>
	            
	     </div>
  </body>
</html>
