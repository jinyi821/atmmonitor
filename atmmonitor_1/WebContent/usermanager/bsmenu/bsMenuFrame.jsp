<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
      	 <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台菜单管理管理</title>
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
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>    
		<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
		<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
</head>
<body>
<div class="divsection">
		<form>		
			<div class="bgColor1 wh_contentDiv borderTop">
				<div class="wh_content">
					<div class="rightDiv">
						<div id="ljb" class="Reposition">
							<!--
                                    	时间：2016-03-28
                                    	描述：收缩按钮
                                -->
							<div class="hideTreeBtn"></div>
							<!--
			                    	时间：2016-03-23
			                    	描述：树形区域
			                    -->
							<div class="treeDiv DivHeight" id="treeDiv" style="height:602px;"></div>
							<!--
		                        	时间：2016-03-23
		                        	描述：右侧内容区域
		                        -->
							<div class="rightContent DivHeight marginTop" id="rightContent">
							  <iframe src="" frameBorder="0"  id="rightFrame3" width="100%" style="min-height:586px " name="rightFrame3" scrolling="no"></iframe>
							</div>
							<div class="ClearFloat"></div>
						</div>						
					</div>
					<div class="ClearFloat"></div>
				</div>
			</div>		
		</form>
	</div>
 <script type="text/javascript"> 			
			tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
			tree.setSkin('dhx_skyblue');//样式名称
			tree.setImagePath("${ctx}/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
			tree.enableCheckBoxes(2);//1-带选择框的模式 (非1)-不带选择框的模式
			tree.enableTreeLines(true);//是否显示结点间的连线,默认false
			tree.setXMLAutoLoading("${ctx}/usermanager/bsmenu/getChildNode.action");
			tree.loadXML("${ctx}/usermanager/bsmenu/getChildNode.action?id=0");
			tree.enableHighlighting(1);
			tree.enableDragAndDrop(0);
			tree.setOnClickHandler(doHandler);			
			function doHandler(key){
		    	var id = tree.getSelectedItemId();
		        window.document.getElementById("rightFrame3").src="${ctx}/usermanager/bsmenu/bsMenuRight.action?id="+id;
			}
			//刷新节点
			function refreshItem(itemId){
				tree.refreshItem(itemId);
			}
			//刷新父节点
			function refreshParentItem(itemId){
				var menuid=tree.getParentId(itemId);
				if(menuid==999999){			
				tree.refreshItem(0);	
				}else{
				tree.refreshItem(tree.getParentId(itemId));
				}
			}
						
			window.onload=function(){
				$("#treeDiv").css("overflow","auto");
				window.parent.iFrameHeight("rightFrame2");
			};
			
		</script>  	
</body>
</html>