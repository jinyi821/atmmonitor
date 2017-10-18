<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台菜单新增修改页面</title>
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
	    <script type="text/javascript" src="${ctx}/common/js/validate.js"></script>   
</head>
<body onload="checksave();">
		<form action="${ctx}/usermanager/bsmenu/bsMenuSave.action" method="post" name="myform" id="myform">
			                       <div class="headHeight Reposition borderBottom" id="toolDiv">
									 <input type="button" value="新建子菜单" class="blueBtn" onclick="oppenSaveMenu();" />
			                             <c:if test="${id!=999999}">
					                 <input type="button" value="删除该菜单" class="deleteBtn" onclick="deleteData();"/>
				                     </c:if>
									</div>
									<div class="Right_content_div">
									<input type="hidden" name="menuid" id="menuid" value="${bsMenu.menuid}"/>
	       		                     <input type="hidden" name="parentid" id="parentid" value="${bsMenu.parentBsMenu.menuid}"/>
				                      <input type="hidden" name="isupdate" id="isupdate"  value="1" />
										<table class="base_table ContentTable">
										<tr>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">菜单名称</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id = "menuname" name="menuname" value="${bsMenu.menuname}" />
	       					<validation id="menunameV" dataType="Require"  msg="菜单名称必须填写！" />
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">菜单连接</label>
	       				</td>
	       				<td>
	       					<input type="text" class="inputSy" id="menuurl" name="menuurl" value="${bsMenu.menuurl}">
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">菜单类型</label>
	       				</td>
	       				<td class="base_padding_style4">	       				   
	       				   <select id="menutype" name="menutype" style="width: 91%;" class="js-example-basic-hide-search">							
								<option value="1"  <c:if test="${bsMenu.menutype==1}">selected</c:if>>普通菜单</option>	
								<option value="0" <c:if test="${bsMenu.menutype==0}">selected</c:if> >导航栏菜单</option>													
							</select>	       				
	       				</td>
	       			</tr>
	       			<tr>
	       				<td width="10%" class="text_alignRight">
	       					<label class="fontSize3">菜单状态</label>
	       				</td>
	       				<td class="base_padding_style4">
	       				<select id="status" name="status" style="width: 91%;" class="js-example-basic-hide-search">							
								<option value="1"<c:if test="${bsMenu.status==1}">selected</c:if> >可用</option>
								<option value="0" <c:if test="${bsMenu.status==0}">selected</c:if> >不可用</option>														
							</select>
						</td>
	       			</tr>	       			
					</table>
					<div class="base3">
			         <input type="button" value="保存" onclick="checkSubmitForm();" id="save" name="save"  class="base3_btn1"/>
		             </div>
			   </div>
	  </form>
    <script type="text/javascript">  
    $(".deleteBtn").mouseover(function(){ //当鼠标指针位于元素上方时，会发生 mouseover 事件
    	  $(".deleteBtn").css("color","#0085d0");
    });
    $(".deleteBtn").mouseout(function(){ //当鼠标指针从元素上移开时，发生 mouseout 事件
  	  $(".deleteBtn").css("color","#bbbbbb");
  });
    function checksave(){
    var id="${id}";   
    if(id==999999){
    	$("#save").hide();    	
    }    	
    }    
	function oppenSaveMenu(){		
		$("#menuid").val(null);
		$("#menuname").val(null);
		$("#menuurl").val(null);
		$("#parentid").val("${bsMenu.menuid}");
		$("#isupdate").val(0);
		$("#toolDiv").hide();
		$("#save").show();
		
		
		//window.open("${ctx}/usermanager/bsmenu/toBsMenuSave.action?parentid=${bsMenu.menuid}","rightFrame3");
	}
	
	function checkSubmitForm(){
		if(Validator.Validate(document.myform,2)){	
			submitForm();			
		}		
	}
		function submitForm(){			
			$.ajax({
	                cache: true,
	                type: "POST",
	                url:"${ctx}/usermanager/bsmenu/bsMenuSave.action",
	                data:$('#myform').serialize(),// 你的formid
	                async: false,
	                error: function(request) {
	                    alert("操作失败!");
	                },
	                success: function(data) {
	                	if(data=="ok"){
	                		alert("操作成功");		                		
	                		var menuid=$("#menuid").val();
	                		var parentid=$("#parentid").val();
	                		if(menuid==null||menuid==""){	                			                			
	                			window.parent.refreshItem(parentid);		                			
	                		}else{
	                			window.parent.refreshParentItem(menuid);	                			
	                		}
	                }
	                }  	
	            });
		}		    
	function deletevalidate(menuid){  
		//var menuid="${bsMenu.menuid}";
		 //定义一个全局变量来接受$.ajax的返回值，$.post、$.get函数无法返回全局变量
		 var result;
		 //用ajax的“同步方式”调用一般处理程序
		   $.ajax({
		        url: "${ctx}/usermanager/bsmenu/bsMenuChildExist.action",
		        async: false,//改为同步方式
		        type: "POST",
		        dataType: "text", //默认text类型，返回村文本字符串
		        data: {"menuid":menuid },
		        success: function (data) {
		        	var obj = eval("("+data+")");		        	
					 if(obj.flag=="true"){								 
						 alert("该菜单下含有子菜单，禁止删除！");	
						 result=false;
					 }else{
						 //alert("该菜单可以删除！");
						 result=true;
						
					 }
		     }
		 });
		 
		//在全局或某个需要的函数内设置Ajax异步为false，也就是同步
		//$.ajaxSetup({ async :false});
		 //附加说明：$.ajax()的所有的选项都可以通过$.ajaxSetup()函数来全局设置。 
		//然后再进行你的Ajax操作 
		/**$.post("${ctx}/usermanager/bsmenu/bsMenuChildExist.action",
						{"menuid":menuid},function(result)
						{
							 var obj = eval("("+result+")"); 
							 if(obj.flag=="true"){	
								 result=false;//赋值给全局变量   
								 alert("该菜单下含有子菜单，禁止删除！");															
							 }else{
								 result=true;//赋值给全局变量   
								 alert("该菜单可以删除！");	
							 }
							 
						}
				);*/ 
	return result;		 	
   }	
	 function  deleteData()
	{
		 var menuid="${bsMenu.menuid}";
		 if(confirm("确定删除该菜单？")){			 
			 var flag=deletevalidate(menuid);
			 //alert(flag);
			if(flag){			 
				 var url="${ctx}/usermanager/bsmenu/bsMenuDel.action";
					$.post(url,{"menuid":menuid},function(result){
			 			if(result=="ok"){
			 				alert("删除成功!");
			 				window.parent.refreshParentItem('${bsMenu.menuid}');
			 				window.parent.document.getElementById("rightFrame3").src="";
			 			}else{
			 				alert("删除失败!");
			 			}
					}); 
			 }	 
		 }	 
	}
		
</script>
</body>
</html>