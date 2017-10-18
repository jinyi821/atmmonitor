<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="/common/taglibs.jsp"%>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>新增用户部门信息</title> 
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
	<!--<link rel="stylesheet" type="text/css" href="${ctx}/common/plugin/dhxtree/codebase/skins/dhtmlxtree_dhx_skyblue.css"/>-->
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/codebase/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="${ctx}/common/plugin/dhxtree/dhtmlxtree.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>    	    
</head>
<body>
	<div class="divsection">
	    	<form action="${ctx}/usermanager/bsuserdep/bsUserDepSave.action" method="post" name="myform" id="myform">
	    		<div class="bgColor1 ">
	               <div class="mxContent DivHeight " style="margin-left:0px;width:798px;" >
	                        <div>
                				<div style="float: left;margin-right: 5px; border: 1px;width:49.5%">
                				        <input type="hidden" name="loginname" id="loginname"/>
                						<div class="wh_modal_head borderBottom Reposition">
                						<input type="button" value="选择用户" class="blueBtn"/>
		                					<div class="searchInfo">
		                						<input type="text" class="searchInput"  id="par_condition" name="par_condition"/>
		                						<div class="searchIcon"></div>
		                						<input type="button" value="搜索" class="base3_btn1" onclick="query()" />
		                					</div>
                						</div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable" width="100%" >
	                						<thead class="table_head fontSize3">
	                							<td width="20%"></td>
	                							<td width="40%">登录名</td>
	                							<td width="40%">用户名</td>	                							
	                						</thead>
	                						<tbody class="table_body" >
	                							<tr>
	                								<td>
	                									<input type="radio" name="checkbox1" value="@@{loginname}" onclick="checkRadio(this);" />
	                								</td>
	                								<td>
	                									<label>@@{loginname}</label>
	                								</td>
	                								<td>
	                									<label>@@{fullname}</label>
	                								</td>
	                							</tr>
	                						</tbody>
	                					</table>
                					</div>                					
                					<div style="float: left;border: 1px;width:49.5%">
                					<input type="hidden" name="checkDepId" id="checkDepId"/>
                					<div class="wh_modal_head borderBottom Reposition">
		                					<input type="button" value="选择部门" class="blueBtn"/>
                						</div>
                						<div id="treeDiv" style="height:475px;overflow-y:auto;"></div>	                					
                					</div>
                					<div class="ClearFloat"></div>
                					<div align="center">
		                        			<input type="button" value="保存" class="base3_btn1" onclick="checkSubmitForm()"/>
		                        			<input type="button" value="取消" class="base3_btn1" onclick="clearMessage();"/>
		                        	</div>
                				</div>
	                        </div>
                			<div class="ClearFloat"></div>
              </div>
	    	</form>
	   </div>
</body>
  <script type="text/javascript">
  function preFunc(paraStr)
	{
		paraStr.isCount = 2;
		paraStr.par_condition=$("#par_condition").val();
	}
	function dataFunc(dataRow)
	{
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserinfo.bsUserinfoUseList"]],preFunc,dataFunc,tableBoot);
	function query()
	{
	 table.submit();
	}
	//var xml='${depTreeString}';
	tree=new dhtmlXTreeObject("treeDiv","100%","100%",0);//参数一是树所在页面组件的id,参数四是根结点id,可是是任意值或者字符串
	tree.setSkin('dhx_skyblue');//样式名称
	tree.setImagePath("/metadata/common/plugin/dhxtree/codebase/imgs/dhxtree_skyblue/");//设置树所使用的图片目录地址
	tree.enableCheckBoxes(1);//1-带选择框的模式 (非1)-不带选择框的模式
	tree.enableTreeLines(true);//是否显示结点间的连线,默认false
	tree.setXMLAutoLoading("${ctx}/usermanager/bsdep/getUseDepChildNode.action");
	tree.loadXML("${ctx}/usermanager/bsdep/getUseDepChildNode.action?id=0");
	//tree.loadXMLString(xml);
	
	tree.enableHighlighting(1);
	tree.setOnCheckHandler(onCheckHandler);	
	function onCheckHandler(key){
		var flag=tree.isItemChecked(key);	
		if(flag==1){			
			checkBoxUserDepExist(key);
		}
		if(flag==0){
			//tree.setSubChecked(key,false);//改变该节点及子节点选中状态		
		}
	}
	
	function checkRadio(obj) {
		var check = obj.checked;
		var loginname = obj.value;
		var ck1 = $("input[name='checkbox1']")
		$.each(ck1, function() {
			var val = $(this).val();
			if (val != loginname) {
				$(this).attr("disabled", true);
			}
		});
	}
	function checkBoxUserDepExist(depid){		
		var loginname = $("input[name='checkbox1']:checked").val();			
		 if(loginname==null){
			 alert("请选择用户！");
			 tree.setCheck(depid,0);	
			 return ;
		 };	
		 $.post("${ctx}/usermanager/bsuserdep/userDepExist.action",{
				"loginname":loginname,"depid":depid	},function(result) {
					var obj2 = eval("("+ result+ ")");
					if (obj2.flag == "true") {
						alert("已存在该用户部门信息！");	
						tree.setCheck(depid,0);	//改变该节点的选中状态
			}
		});		   		
	}	
	function checkUserDepExist(loginname,depid){
		var result1=true;
		  $.ajaxSetup({async:false});
		     $.post("${ctx}/usermanager/bsuserdep/userDepExist.action",{
				"loginname":loginname,"depid":depid	},
				function(result) {
					var obj2 = eval("("+ result+ ")");
					if (obj2.flag == "true") {
						alert("已存在该用户部门信息！");	
						result1=false;						
					}
				});
		     return result1;		
	}	
	function checkSubmitForm(){
		var loginname = $("input[name='checkbox1']:checked").val();
		 if(loginname==null||list==''){
			 alert("请选择用户和部门！");
			 return ;
		 };
		var list=tree.getAllChecked();				
		var depids=list.split(",");
		var result1=true;
		for(var i=0;i<depids.length;i++){				
		    var	depid=depids[i];		    
		    result1=checkUserDepExist(loginname,depid);
		     if(result1==false){		    	 
		    	 return;
		     }
		};
		  $("#loginname").val(loginname);
		 $("#checkDepId").val(list);	 
		 $.post("${ctx}/usermanager/bsuserdep/bsUserDepSave.action",
		            $(myform).serialize(),
		            function(result){					 
				 var obj = eval("("+result+")"); 					 
				 if(obj.flag=="true"){	
					 alert("新增用户部门信息成功!");
					 window.parent.location.reload();
					 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                 parent.layer.close(index);					
				 }else{
					 alert("新增用户部门信息失败!");	
				 }
			    }
		       );	 
		}
	function clearMessage() {
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    parent.layer.close(index);
	}
</script>
</html>