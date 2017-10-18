<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/taglibs.jsp"%> 
	<link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css"/>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
<style >
 	.page_choose{
	border-bottom:1px solid #e7e7e7;
	margin:20px 20px 0 20px;
	height:26px;
	}	
.page_choose ul li{
	float:left;
	margin:0 30px 0 0;
	cursor:pointer;
	}
.page_choose ul li a{
	color:#333;
	}
.page_choose ul li a:hover{
	text-decoration:none;
	color:#0090ff;
	}
	.clear{ clear:both} 
 	</style>
</head>
<body>
	<div class="content">
		<div class="" id="treeboxbox_tree"></div>
  	</div>
  	<script type="text/javascript"> 			
			tree=new dhtmlXTreeObject("treeboxbox_tree","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
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
		        window.parent.document.getElementById("rightFrame3").src="${ctx}/usermanager/bsmenu/bsMenuRight.action?id="+id;
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
			
		</script>  	
</body>
</html>