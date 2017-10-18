<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <%@ include file="/common/taglibs.jsp"%>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>角色分配菜单</title> 
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
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css"/>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
	<style type="text/css">
	.mxContent1{
	width: 100%;	
	height: auto;
	margin-left:0px ;
	margin-top:0px;
	border: 1px solid #dddddd;
	background: #fdfdfd;
	display: inline-block;
	float: left;
}
	</style>
</head>
<body> 
   <!-- <div class="mxContent1 DivHeight marginBottom marginTop"> -->    
	<form action="${ctx}/usermanager/bsrole/roleMenuSave.action" method="post" name="myform" id="myform">
       <div id="treeDiv"></div>
      <input type="hidden" value="${roleid}"  id="roleid"  name="roleid"/>
     <input type="hidden" name="checkMenuId" id="checkMenuId"/> 
      <div class="base3">
	<input type="button" value="保存" class="base3_btn1"  onclick="checkSubmitForm();"/>
	</div>    
</form>  
<!--</div> -->
  	<script type="text/javascript"> 
  	var xml='${treeString}';
	tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
	tree.setSkin('dhx_skyblue');//样式名称
	tree.setImagePath("${ctx}/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
	tree.enableCheckBoxes(1);//1-带选择框的模式 (非1)-不带选择框的模式
	tree.enableTreeLines(true);//是否显示结点间的连线,默认false
	tree.showItemSign(tree.getSelectedItemId(), true);
	//tree.setXMLAutoLoading("${ctx}/baseconfig/cfgcolumnset/getMenuTreeXml.action");
	//tree.loadXML("${ctx}/baseconfig/cfgcolumnset/getMenuTreeXml.action");
	tree.loadXMLString(xml);
	tree.enableHighlighting(1); 
	
	tree.setOnCheckHandler(onCheckHandler);	
	function onCheckHandler(key){
		var flag=tree.isItemChecked(key);	
		if(flag==1){
			//var parentid=tree.getParentId(key);	
			//if(parentid!=0){
			//tree.setCheck(parentid,true);}
			setParentCheck(key);
		}
		if(flag==0){
			tree.setSubChecked(key,false);		
		}
		}
		function setParentCheck(id){
			var parentid=tree.getParentId(id);	
			 if(parentid!=0){
				   tree.setCheck(parentid,true);
				   setParentCheck(parentid);
			}
			 
		  }		
	//tree.setSubChecked(6,true);	
	//tree.setSubChecked(21,true);
	//tree.setCheck(6,true)//勾选节点
	//tree.setCheck(21,true)//勾选节点
 <c:forEach items="${roleMenuList}" var="rolemenu"> 
tree.setCheck("${rolemenu.menuid}",true);//勾选节点
</c:forEach> 
	function checkSubmitForm(){
	 var list=tree.getAllChecked();	
	 $("#checkMenuId").val(list);	 
	 //document.myform.submit();
	 //var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	 // parent.layer.close(index); 
	 $.post("${ctx}/usermanager/bsrole/roleMenuSave.action",
	            $(myform).serialize(),
	            function(result){					 
			 var obj = eval("("+result+")"); 					 
			 if(obj.flag=="true"){	
				 alert("分配菜单成功!");				
				 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                 parent.layer.close(index);
			 }else{
				 alert("分配菜单失败!");	
			 }
		    }
	       );	 
	}
	</script>
</body>
</html>