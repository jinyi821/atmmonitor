<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/common/taglibs.jsp"%>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>选择用户部门</title>
       <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/kf.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	<!-- <link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_new.css"/>--> <!--引入以后每个树节点下有下划线 -->
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommonnew.js"></script>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtreenew.js"></script>
	<style type="text/css">
	.divfulltitle{
	font-family: "微软雅黑";
	font-size: 14px;
	background-color: #f8f8f8;	
	height:35px;
	line-height:35px;
	border-bottom: 1px solid #dddddd;
	padding-left:10px;
   }
   .AccessUl{	
	width: 585px;
	position:relative;
   }
   tr{
   height:24px;
   }	
	</style>
</head>
<body>
	
	               <div class="mxContent DivHeight" style="margin-left:1px;margin-right:1px;min-height:512px;width:99.5%;" >
	                         <div class="divfulltitle">当前已选用户：<input value="<%=request.getParameter("loginname")%>" name="loginname" id="loginname" type="hidden"/><%=request.getParameter("loginname")%></div>	    	
	                        <div>
                				<div style="float:left;width:35%;">
	                			<div id="treeDiv" style="height:450px;overflow-x:hidden;overflow-y:auto;"></div>	 
                					</div>                					
                					<div style="float:right;width:65%;"> 
                					    <ul class="AccessUl" style="height:450px;overflow-y:auto;">
									    		<li class="AccessUl_li_head">已选择部门列表</li>									    	
									    	</ul>
									   </div> 
                					<div class="ClearFloat"></div>
                					<div align="center">
		                        			<input type="button" value="保存" class="base3_btn1" onclick="returnUserSave()"/>
		                        			<input type="button" value="取消" class="base3_btn1" onclick="clearMessage();"/>
		                        	</div>
                				</div>
	                        </div>
                			
      
</body>
  <script type="text/javascript"> 
     var tree;
	//var xml='${depTreeString}';
	//var treeDiv=document.getElementById("treeDiv");
    //tree=new dhtmlXTreeObject(treeDiv,"100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串	
	   tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
	   tree.setSkin("dhx_new");//样式名称 dhx_skyblue
	   tree.setImagePath("${ctx}/common/plugin/dhxtree/codebase/imgs/dhxtree_new/");//设置树所使用的图片目录地址
	   tree.enableCheckBoxes(1);//1-带选择框的模式 (非1)-不带选择框的模式
	  //tree.enableRadioButtons(true);  //对整棵树进行设置支持单选按钮，同级节点只能选一个,不好使
	  //tree.enableRadioButtons(9,true); //(itemId,mode) 
	   tree.enableSmartXMLParsing(true);
	   tree.enableTreeLines(true);//是否显示结点间的连线,默认false	   
	   tree.setXMLAutoLoading("${ctx}/usermanager/bsdep/getUseDepChildNode.action");
	   tree.loadXML("${ctx}/usermanager/bsdep/getUseDepChildNode.action?id=0",afterTreeLoadXml);	
		//tree.loadXMLString(xml);	   
	   tree.enableHighlighting(1);
	   tree.enableDragAndDrop(0);	
	   tree.setOnClickHandler(onClickHandler);//点击
	   tree.setOnCheckHandler(onCheckHandler);//选中
	   function afterTreeLoadXml(){
			var firstkey=tree.getChildItemIdByIndex(0,0);//根据父节点id获取对应索引的子节点的id
			//alert("test2:"+tree.getItemIdByIndex(0,0));//获取加载后的第一个节点
			tree.load("${ctx}/usermanager/bsdep/getUseDepChildNode.action?id="+firstkey+"&&type=depuser"); //已替换loadXml方法
		}
	   
	   function onClickHandler(key){
		   tree.setCheck(key,1);
		   var value=tree.getItemText(key);
		   //alert("key1:"+key+"/value1:"+value); 
		   addChooseDep(key,value); 
	   }
	   function onCheckHandler(key){
		   var flag=tree.isItemChecked(key);
		   var value=tree.getItemText(key);
			if(flag==1){		    
		  //alert("key2:"+key+"/value2:"+value);		   
		   addChooseDep(key,value);
			}else{
				var locationIndex=$.inArray(key,chooseDepIdArray);//-1 指最后一个元素，-2 指倒数第二个元素
				chooseDepIdArray.splice(locationIndex,1);
				chooseDepNameArray.splice(locationIndex,1);		
				$("#"+key+"").parent().remove();				
			}
	   }	   
	  var chooseDepIdArray=new Array(); //[]
	   var chooseDepNameArray=new Array(); // []	   
	    function addChooseDep(key,value){
	    	//判断已选部门是否存在			    		
			if(chooseDepIdArray!=""){
				var positionIndex=$.inArray(key,chooseDepIdArray); //-1 指最后一个元素，-2 指倒数第二个元素   			
    			   if(positionIndex!=-1){	
      					alert("选择的部门已存在已选部门列表中！");
    					return;
    				}    			   				 
			}	
	    	var loginname=$("#loginname").val();
	    	var result1=checkUserDepExist(loginname,key);
	    	if(result1==false){
	    		alert("已存在该用户部门信息！");
	    		tree.setCheck(key,0);
	    		return;
	    	}
	    	var  depfullname=tree.getUserData(key,"depfullname");
	    	var depparentname="";
	    	if(depfullname!=""&&depfullname!=null){
	    	depparentname=depfullname.substring(0,depfullname.lastIndexOf("·")+1);		    		
	    	}else{
	    		var chooseParentDepNameArray=new Array(); // []
				getChooseParentDep(key,chooseParentDepNameArray);				
				var len=chooseParentDepNameArray.length; 
				if(chooseParentDepNameArray.length>0){
					depparentname=chooseParentDepNameArray.reverse().join("·")+"·"				
				}
				chooseParentDepNameArray.push(value);	
				depfullname=chooseParentDepNameArray.join("·");
	    	}
			var tagHtml="<li class=\"AccessUl_li\">";
			tagHtml+="<label>"+depparentname+"</label>";
			tagHtml+="<label class=\"color17\">"+value+"</label>";
			tagHtml+="<div class=\"deleteIcon\" id=\""+key+"\" onclick=\"delChooseDep(this)\"></div></li>";
			chooseDepIdArray.push(key);			
			chooseDepNameArray.push(depfullname);
			$(".AccessUl").append(tagHtml); 			
	   }
	    function getChooseParentDep(id,chooseParentDepNameArray){	    	
	    	var parentid=tree.getParentId(id);	    	
	    	var parentvalue=tree.getItemText(parentid);	    	
	    	if(parentid!=0){
	    		//cooseParentDepNameArray.push(parentvalue); //这个不行
	    		var len=chooseParentDepNameArray.length; //递归增加数组内容
	    		chooseParentDepNameArray[len]=parentvalue;
	    		getChooseParentDep(parentid,chooseParentDepNameArray);
	    	}	    		    	
	    }
	    function delChooseDep(key){	
			var depid=$(key).attr("id");
			var locationIndex=$.inArray(depid,chooseDepIdArray);
			chooseDepIdArray.splice(locationIndex,1);	
			chooseDepNameArray.splice(locationIndex,1);		
			$(key).parent().remove();
			tree.setCheck(depid,0);
		}
		function checkUserDepExist(loginname,depid){
			var result1=true;
			  $.ajaxSetup({async:false});
			     $.post("${ctx}/usermanager/bsuserdep/userDepExist.action",{
					"loginname":loginname,"depid":depid	},
					function(result) {
						var obj2 = eval("("+ result+ ")");
						if (obj2.flag == "true") {
							//alert("已存在该用户部门信息！");	
							result1=false;						
						}
					});
			     return result1;		
		}
	   function  returnUserSave(){		 
		   //var chooseDepNameArrayStr=chooseDepNameArray.join(" ");//join(),数组不提供分隔符,分隔符是“,”号,join(".")分隔符换成点;;	
	   		//alert(choosedepid+"/"+choosedepname);
	   		parent.closeDepTree(chooseDepIdArray,chooseDepNameArray); //,chooseDepNameArrayStr
	   		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		    parent.layer.close(index);
	   }	 
	function clearMessage() {
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
	window.onload=function(){
		$("#treeDiv").css("overflow-x","hidden");
		$("#treeDiv").css("overflow-y","auto");			
	}
</script>
</html>
</html>