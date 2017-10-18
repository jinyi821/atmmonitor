<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/common/taglibs.jsp"%> 
		<title>数据共享平台维护页面</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"></meta>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"></meta>
	    <meta http-equiv="description" content="this is my page"></meta>
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit"></meta>
		<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
		<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
		<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
	    <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
	    <link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>
 		<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>
 		<script type="text/javascript" src="${ctx}/portal/js/Sys.js" ></script>
	</head>
	<body>
		<div class="divsection">
	    	<form>
	    		<!--
                	时间：2016-03-23
                	描述：维护页面
                -->
                <div class="bgColor1 wh_contentDiv " >
                	<div class="wh_content" id="wh_contentDiv">
                		<!-- 
                			左侧菜单
                		 -->
                		 <div class="rightDiv" >
	                    	<div id="ljb" class="Reposition">
	                    		<div class="hideTreeBtn" ></div>
			                	<!--
			                    	时间：2016-03-23
			                    	描述：树形区域
			                    -->
		                		<div class="treeDiv DivHeight" id="treeDiv" style="overflow:scroll;height: 602px"></div>
		                		<!--
		                        	时间：2016-03-23
		                        	描述：右侧内容区域
		                        -->
		                        <div class="rightContent DivHeight marginTop" id="rightContent" style="min-height: 590px;">
		                       		<iframe src="" frameBorder="0" id="rightFrame2" width="100%" height="100%" name="rightFrame2" scrolling="no"></iframe>
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
			tree=new dhtmlXTreeObject("treeDiv","100%","100%",-1);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
			tree.setSkin('dhx_skyblue');//样式名称
			tree.setImagePath("${ctx}/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
			tree.enableCheckBoxes(2);//1-带选择框的模式 (非1)-不带选择框的模式
			tree.enableTreeLines(true);//是否显示结点间的连线,默认false
			tree.setXMLAutoLoading("${ctx}/usermanager/bsdep/getChildNode.action");
			tree.loadXML("${ctx}/usermanager/bsdep/getChildNode.action?id=-1");
			tree.enableHighlighting(1);
			 tree.enableDragAndDrop(0);
			tree.setOnClickHandler(doHandler);
			tree.setOnLoadingEnd(onLoadingEnd);
			function doHandler(key){
		    	var id = tree.getSelectedItemId();
		    		tbEnname = tree.getSelectedItemId();
		    		document.getElementById("rightFrame2").src="${ctx}/usermanager/bsdep/bsDepLoad.action?pid="+id;
			}
			
			//刷新节点
			function refreshItem(itemId){
				tree.refreshItem(itemId);
				tree.openItem(itemId);
			}
			window.onload=function(){
				$("#treeDiv").css("overflow","auto");
				window.parent.iFrameHeight("rightFrame2");
			};
			function onLoadingEnd(){
				window.parent.iFrameHeight("rightFrame2");
			}
			//刷新父节点
			function refreshParentItem(itemId){
				tree.refreshItem(tree.getParentId(itemId));
				tree.openItem(itemId);
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
			     window.parent.iFrameHeight("rightFrame2");
			}
			
		</script>
	</body>
</html>
