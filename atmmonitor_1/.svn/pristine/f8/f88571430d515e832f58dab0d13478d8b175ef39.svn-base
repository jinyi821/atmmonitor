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
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/kf.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	     <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
	    <style type="text/css">
	    .AccessUl{	
        position:relative;  
        }    
	    </style>
</head>
<body>
 <div class="divsection">	    	
                <div class="bgColor1 wh_contentDiv">	               
                	<div  id="mx">
                		<div class="wh_content">
                		<div class="rightDiv"> <!-- 以上div增加底层高度 -->
   	 <div class="mxContent  marginBottom marginTop">
   	  	<div class="wh_modal_head borderBottom Reposition">
		   <span style="margin-left:50px;font-size: 18px;" id="functiontitle">新增用户部门信息</span>							                				
	   </div>	
		<form action="${ctx}/usermanager/bsuserdep/bsUserDepSave.action" method="post" name="myform" id="myform">			    
			<table class="base_table">
			<tr style="height:40px;line-height:40px;">
				   <td width="10%" class="text_alignRight"><label
						class="fontSize3">选择用户</label></td>
					<td>
					<input id="loginname" name="loginname" type="text" class="inputSy" readonly="readonly"  onclick="openUser();" />	
		           </td>
				</tr>	
					<tr>
					<td width="10%" class="text_alignRight"><label
						class="fontSize3">用户部门</label></td>
					<td>
					<input id="chooosedepids" name="chooosedepids" type="hidden" class="inputSy" readonly="readonly" />
					<input id="chooosedepnames" name="chooosedepnames" type="text" class="inputSy" readonly="readonly" onclick="openDepTree();" />					
					</td>
				</tr>
				<tr  style="height:40px;line-height:40px;">
				<td width="10%" class="text_alignRight" style="vertical-align:top;"> <!-- style="vertical-align:top;" 让td中的内容竖直居顶 -->
				<label	class="fontSize3">已选部门</label></td>
				<td>										
				<ul class="AccessUl" style="width:90.8%;overflow-y:auto;">
					<!--<li class="AccessUl_li_head">已选部门列表</li>-->	
					<li class="AccessUl_li">
				<label></label>
			    <label class="color17"></label>
				<div></div></li>						    	
				 </ul>				 
				</td>					    	
				</tr>							
			</table>						
		   <div class="base3">
		      <input type="button" value="保存" class="base3_btn1" onclick="checkSubmitForm()"/>
		      <input type="button" value="取消" class="base3_btn1" onclick="history.go(-1);"/> <!-- clearMessage(); -->
		   </div>
		</form>
 </div>
</div>
 </div>
 </div>
 </div>
 </div>
</body>
  <script type="text/javascript"> 
	 function openUser(){
			layer.open({           
	        type: 2,//设定弹窗为iframe嵌套页面
	        title: ['选择用户', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	        area: ['800px', '525px'], 
	        content: "${ctx}/usermanager/bsuserdep/bsUserDepUserList.jsp"
	         //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	      });   	   
	   }
	 function openDepTree(){
		   var loginname=$("#loginname").val();	   
		   if(loginname == null||loginname == ""){
			   alert("请选择用户!");
			   return;
		   }
			layer.open({           
		        type: 2,//设定弹窗为iframe嵌套页面
		        title: ['选择用户部门', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
		        area: ['900px', '560px'], 
		        content: "${ctx}/usermanager/bsuserdep/bsUserDepTreeList.jsp?loginname="+loginname
		         //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		      }); 
	   } 
	function closeDepTree(choosedepids,choosedepfullnames){
		$("#chooosedepids").val(choosedepids);
		$("#chooosedepnames").val(choosedepfullnames.join(" "));
		chooseDepIdArray=new Array();
		chooseDepNameArray=new Array();	
		$(".AccessUl").html(null);
		//$(".AccessUl").append("<li class=\"AccessUl_li_head\">已选部门列表</li>");			
		var choosedeplen=choosedepids.length;
		if(choosedeplen>0){			
		for(var j=0;j<choosedeplen;j++){
		var depid=choosedepids[j];
		var depparentname=choosedepfullnames[j].substring(0,choosedepfullnames[j].lastIndexOf("·")+1);	
		var depname=choosedepfullnames[j].substring(choosedepfullnames[j].lastIndexOf("·")+1);	
		 var tagHtml="<li class=\"AccessUl_li\">";
			tagHtml+="<label>"+depparentname+"</label>";
			tagHtml+="<label class=\"color17\">"+depname+"</label>";
			tagHtml+="<div class=\"deleteIcon\" id=\""+depid+"\" onclick=\"delChooseDep(this)\"></div></li>";						
			$(".AccessUl").append(tagHtml);		
		}
		}else{
			var tagHtml="<li class=\"AccessUl_li\">";
			tagHtml+="<label></label>";
			tagHtml+="<label class=\"color17\"></label>";
			tagHtml+="<div></div></li>";			
			$(".AccessUl").append(tagHtml);	
		}			
		chooseDepIdArray=new Array().concat(choosedepids) ;   //[].concat(a)把一个数组赋值给另一个数组
		chooseDepNameArray=new Array().concat(choosedepfullnames);
		//alert(chooseDepIdArray+"\\"+chooseDepNameArray);
		window.parent.iFrameHeight("rightFrame2");	
	}	
	function delChooseDep(key){	
		var depid=$(key).attr("id");
		var locationIndex=$.inArray(depid,chooseDepIdArray); //如locationIndex=-1,删最后一个
		chooseDepIdArray.splice(locationIndex,1);	
		chooseDepNameArray.splice(locationIndex,1);		
		$(key).parent().remove();
		var chooseDepLen=chooseDepIdArray.length;
		if(chooseDepLen==0){
			 var tagHtml="<li class=\"AccessUl_li\">";
				tagHtml+="<label></label>";
				tagHtml+="<label class=\"color17\"></label>";
				tagHtml+="</div></li>";			
				$(".AccessUl").append(tagHtml);			
		}		
		$("#chooosedepids").val(chooseDepIdArray);
		$("#chooosedepnames").val(chooseDepNameArray.join(" "));		
	}	
	 function clearChooseDep(){
	     $("#chooosedepids").val(null);
		 $("#chooosedepnames").val(null);	
		 chooseDepIdArray=new Array();
		 chooseDepNameArray=new Array();		
		 $(".AccessUl").html(null);
		 var tagHtml="<li class=\"AccessUl_li\">";
			tagHtml+="<label></label>";
			tagHtml+="<label class=\"color17\"></label>";
			tagHtml+="</div></li>";			
		$(".AccessUl").append(tagHtml);	
   }	
	function checkSubmitForm(){
		var loginname = $("#loginname").val();
		var chooosedepids=$("#chooosedepids").val();		
		 if(loginname==null||chooosedepids==''){
			 alert("请选择用户和部门！");
			 return ;
		 };	
		 // $("#loginname").val(loginname);
		 //$("#chooosedepids").val(chooseDepIdArray);	 
		 $.post("${ctx}/usermanager/bsuserdep/bsUserDepSave.action",
		            $(myform).serialize(),
		            function(result){					 
				 var obj = eval("("+result+")"); 					 
				 if(obj.flag=="true"){	
					 alert("新增用户部门信息成功!");
					 window.location.href="${ctx}/usermanager/bsuserdep/bsUserDepList.action";
					 //window.parent.location.reload();
					 //var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                 //parent.layer.close(index);					
				 }else{
					 alert("新增用户部门信息失败!");	
				 }
			    }
		       );	 
		}
	function clearMessage() {
		//var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    //parent.layer.close(index);
	}
</script>
</html>