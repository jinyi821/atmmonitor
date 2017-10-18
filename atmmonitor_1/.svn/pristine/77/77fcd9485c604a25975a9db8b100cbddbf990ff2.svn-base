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
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	<!--<link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css"/>-->  <!--引入以后每个树节点下有下划线 -->
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
	<style>
	.tagArrow{
	width: 12px;
	height: 30px;
	display: inline-block;
	vertical-align: middle;
	background: url(${ctx}/common/style/newstyle/images/tagArrow.png) no-repeat;
	margin-bottom: 3px;
}
.tagRec{
	display: inline-block;
	min-width: 279px;
	width: auto;
	border: 1px solid #eeeeee;
	-webkit-border-top-right-radius: 2px;
	-webkit-border-bottom-right-radius: 2px;
	-moz-border-top-right-radius: 2px;
	-moz-border-bottom-right-radius: 2px;
	border-top-right-radius: 2px;
	border-bottom-right-radius: 2px;
	border-left:none;
	height: 28px;
	line-height: 28px;
	text-align: left;
	padding-left: 8px;
	padding-right: 18px;
	background: #f3fbff;
	margin-left: -3px;
	color: #999999;
}
.delCover{
	width: 6px;
	height: 6px;
	display: inline-block;
	background: url(${ctx}/common/style/newstyle/images/delCover.png) no-repeat;
	z-index: 10;
	cursor: pointer;
	position: absolute;
	right: 7px;
    top: 17px;
}
	</style>		
</head>
<body>
	<div class="divsection">	    	
	    		<div class="bgColor1 ">
	               <div class="mxContent DivHeight " style="margin-left:1px;margin-right:1px;width:645px;" >
	                        <div>
                				<div style="float: left;border-right:1px solid #dddddd; width:49.8%">                				       
                						<div class="wh_modal_head borderBottom Reposition">
                						<input type="button" value="部门列表" class="blueBtn"/>		                					
                						</div>
	                					<div id="treeDiv" style="height:520px;overflow-y:auto;"></div>	 
                					</div>                					
                					<div style="float: left;width:50%">                					
                					<div class="wh_modal_head borderBottom Reposition">
		                					<input type="button" value="已选部门列表" class="blueBtn"/>
                						</div>
                					    <div id="chooseDepDiv">	
                					    </div>          					
                					</div>
                					<div class="ClearFloat"></div>
                					<div align="center">
		                        			<input type="button" value="保存" class="base3_btn1" onclick="returnUserSave()"/>
		                        			<input type="button" value="取消" class="base3_btn1" onclick="clearMessage();"/>
		                        	</div>
                				</div>
	                        </div>
                			<div class="ClearFloat"></div>
              </div>	    	
	   </div>
</body>
  <script type="text/javascript"> 
     var tree;
	//var xml='${depTreeString}';
		tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
	   tree.setSkin('dhx_skyblue');//样式名称
	   tree.setImagePath("${ctx}/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
	   //tree.enableCheckBoxes(1);//1-带选择框的模式 (非1)-不带选择框的模式
	   tree.enableRadioButtons(true);  //对整棵树进行设置支持单选按钮，同级节点只能选一个,不好使
	  //tree.enableRadioButtons(9,true); //(itemId,mode) 
	   tree.enableSmartXMLParsing(true);
	   tree.enableTreeLines(true);//是否显示结点间的连线,默认false	   
	   tree.setXMLAutoLoading("${ctx}/usermanager/bsdep/getUseDepChildNode.action");
	   tree.loadXML("${ctx}/usermanager/bsdep/getUseDepChildNode.action?id=0");	
		//tree.loadXMLString(xml);	   
	   tree.enableHighlighting(1);
	   tree.enableDragAndDrop(0);	
	   tree.setOnClickHandler(onClickHandler);
	   tree.setOnCheckHandler(onCheckHandler);
	   
	   function onClickHandler(key){		  
		  var value=tree.getItemText(key);
		 // alert("key1:"+key+"/value2:"+value); 
		    addChooseDep(key,value); 
	   }
	   function onCheckHandler(key){
		   var value=tree.getItemText(key); 
		 // alert("key2:"+key+"/value1:"+value);		   
		   addChooseDep(key,value);
	   }	   
	   Array.prototype.indexOf  = function(val) { //定义数组索引功能
		   for (var i = 0; i < this.length; i++) {
		   if (this[i] == val) return i;
		   }
		   return -1;
		   };	   
	   Array.prototype.remove = function(val) {//定义数组删除功能
		   var index = this.indexOf(val);
		   if (index > -1) {
		   this.splice(index, 1);
		   }
		   };
	   var chooseDepIdArray=[];
	   var chooseDepNameArray=[];
	    function addChooseDep(key,value){
	    	//判断已选部门是否存在
			//var chooseDepIdArray=getChooseDepIdArray();    		
			if(chooseDepIdArray!=""){
    			for(var i=0,len=chooseDepIdArray.length;i<len;i++){
    				if(chooseDepIdArray[i]==key){
      					alert("选择的部门已存在已选部门列表中！");
    					return;
    				}
    			}    				 
			}
			var tagHtml="<div class=\"Reposition marginLeft\">";
			tagHtml+="<div class=\"tagArrow\"></div>";
			tagHtml+="<div class=\"tagRec\" id=\""+key+"\">"+value+"</div>";
			tagHtml+="<div class=\"delCover\" onclick=\"delChooseDep(this);\"></div></div>";
			chooseDepIdArray.push(key);
			chooseDepNameArray.push(value);
			$("#chooseDepDiv").append(tagHtml); 			
	   }
		/**function getChooseDepIdArray()
		{
			var chooseDepIdArray=[];
			$(".tagRec").each(function(){				
				chooseDepIdArray.push($(this).attr("id"));
			})
			return chooseDepIdArray;
		}	
		function getChooseDepNameArray()
		{
			var chooseDepNameArray=[];
			$(".tagRec").each(function(){				
				chooseDepNameArray.push($(this).text());
			})
			return chooseDepNameArray;
		}*/
		function delChooseDep(key){
			var prediv=$(key).prev();
			var depid=prediv.attr("id");
			var depname=prediv.text();
			//chooseDepIdArray.remove(depid);
			//chooseDepNameArray.remove(depname);
			chooseDepIdArray.splice($.inArray(depid,chooseDepIdArray),1);
			chooseDepNameArray.splice($.inArray(depname,chooseDepNameArray),1);		
			$(key).parent().remove();		  
		}		
	   function  returnUserSave(){
		  /** var choosedepid=null;
		   var choosedepname=null;
		   alert(chooseDepIdArray+"/"+chooseDepNameArray);*/
		  /**var chooseDepIdArray=getChooseDepIdArray(); 		  
			if(chooseDepIdArray!=""){
   			for(var i=0,len=chooseDepIdArray.length;i<len;i++){
   				if(i<len-1){
   					choosedepid=choosedepid+chooseDepIdArray[i]+",";   					
   				}else{
   					choosedepid=choosedepid+chooseDepIdArray[i];    					
   				}
   			}    				 
			}*/
			//var chooseDepNameArray=getChooseDepNameArray();    		
			/**if(chooseDepNameArray!=""){
	   		for(var i=0,len=chooseDepNameArray.length;i<len;i++){
	   			if(i<len-1){
	   				choosedepname=choosedepname+chooseDepNameArray[i]+" ";   					
   				}else{
   					choosedepname=choosedepname+chooseDepNameArray[i];    					
   				}
	   	   }
		}*/
		   var chooseDepNameArrayStr=chooseDepNameArray.join(" ");//join(),数组不提供分隔符,分隔符是“,”号,join(".")分隔符换成点;;	
	   		//alert(choosedepid+"/"+choosedepname);
	   		parent.closeUserDepTree(chooseDepIdArray,chooseDepNameArrayStr);
	   		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		    parent.layer.close(index);
	   		
		      
	   }	 
	function clearMessage() {
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
	window.onload=function(){	
		 <c:forEach items="${userDepList}" var="userdep"> 
		   var tagHtml="<div class=\"Reposition marginLeft\">";
			tagHtml+="<div class=\"tagArrow\"></div>";
			tagHtml+="<div class=\"tagRec\" id=\"${userdep.pid}\">${userdep.depname}</div>";
			tagHtml+="<div class=\"delCover\" onclick=\"delChooseDep(this);\"></div></div>";			
			$("#chooseDepDiv").append(tagHtml); 
		 </c:forEach> 
	}  
</script>
</html>