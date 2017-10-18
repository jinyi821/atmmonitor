<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>OA部门用户初始化</title>
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
	   	<script type="text/javascript" src="${ctx}/common/js/public.js"></script>
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
		                        <input type="button" value="部门初始化" class="blueBtn" onclick="depsync()"/>
		                        <input type="button" value="用户初始化" class="blueBtn" onclick="usersync()"/>
	                				</div>	                			
		                        </div>
</div>
 </div>
 </div>
 </div>
 </div>		                                   
</body>
  <script type="text/javascript">
	function depsync()
	{
		openMask(null,null,true);
		$.post("${ctx}/usermanager/userdepsynch/depSynch.action",
				function(result){
					 var obj = eval("("+result+")");					 
					 if(obj.flag=="true"){
					     closeMask();						 
						 alert("部门初始化完成！");	
					 }else{
					     closeMask();
						 alert("部门初始化失败！");	
					 }
					 
				}
		);				
	}	
	function usersync()
	{
		openMask(null,null,true);
		$.post("${ctx}/usermanager/userdepsynch/userSynch.action",
				function(result){
					 var obj = eval("("+result+")");					 
					 if(obj.flag=="true"){	
					 	 closeMask();					 
						 alert("用户初始化完成！");	
					 }else{
					     closeMask();
						 alert("用户初始化失败！");	
					 }
					 
				}
		);				
	}
	function parentiFrameHeight(){
				window.parent.iFrameHeight("rightFrame2");
			}
</script>
</html>