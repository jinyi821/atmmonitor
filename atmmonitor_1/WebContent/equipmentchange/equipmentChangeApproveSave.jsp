<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据共享平台数据超市数据商品发布</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta name="renderer" content="webkit">
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/common.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/select2.min.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/common/main.css" />
<link rel="stylesheet"	href="${ctx}/common/style/newstyle/css/page/wh.css" />
<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/kf.css" />
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/common/select2.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/baseStyleJS.js"></script>
<script type="text/javascript"	src="${ctx}/common/style/newstyle/js/page/wh.js"></script>
<script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
<script type="text/javascript" src="${ctx}/common/js/validate.js"></script>
<style type="text/css">
.textAreaSy{
margin-top:5px;
}
.table_body td{
	border-right: 1px solid #dddddd;
}
</style>
</head>
<body>
 <div class="divsection">             
   	 	<div class="mxContent DivHeight marginBottom marginTop">
   	  	<div class="wh_modal_head borderBottom Reposition">
		   <span style="margin-left:50px;font-size: 18px;" id="functiontitle"></span>							                				
	   </div>
	<form action="${ctx}/equipmentchange/saveEquipmentApprove.action" method="post"   name="myform" id="myform" target="_parent">
        <input type="hidden" name="id" id="id" value="${equipmentChange.id}" />
        <input type="hidden" name="createtime" id="createtime" value="${equipmentChange.createtime}" />
         <input type="hidden" name="isupdate" id="isupdate"  value="0" />
         <table class="base_table fontSize3 ContentTable">
          <tbody class="table_body">
			<tr>
				<td width="15%" class="text_alignRight bgColor4">
				<label class="fontSize3">设备编码</label></td>				
				<td width="35%">
				${equipmentChange.equipmentid}
				 
               </td>
               <td width="10%" class="text_alignRight bgColor4">
				 <label class="fontSize3">设备名称</label></td>
				<td width="40%" style="border-right:none;">
				${equipmentChange.equipmentname}
				</td>
            </tr>
            <tr>
                <td width="15%" class="text_alignRight bgColor4">
				<label class="fontSize3">申请人</label></td>				
				<td width="35%">
				${equipmentChange.creater}
				 
               </td>
				<td width="10%" class="text_alignRight bgColor4">
				  <label class="fontSize3">申请时间</label></td>
				<td width="40%" style="border-right:none;">
                     ${equipmentChange.createtimeStr} 
					
                </td>
			</tr>
			
			<tr>
    			<td class="text_alignRight table_td1Align fontSize3 bgColor4">    							
			        <label>申请说明</label>
			    </td>
				<td colspan="3">
			        ${equipmentChange.applyremark}
			    </td>			     
		   </tr>
		   <tr>
                <td width="15%" class="text_alignRight bgColor4">
				<label class="fontSize3">审核意见</label></td>				
				<td width="35%">
				<select id="status" name="status" class="js-example-basic-hide-search"  style="width:90%;"  >
							     
								<option  value="2">审批通过</option>
								<option  value="3">审批不通过</option>
							
				 </select>
				 
               </td>
				<td width="10%" class="text_alignRight bgColor4">
				  <label class="fontSize3">维修负责人</label></td>
				<td width="40%" style="border-right:none;">
                      <select id="maintainer" name="maintainer" class="js-example-basic-hide-search" style="width:90%;"  >
							<c:forEach items="${userList}"  var="belong">
							   
								<option  value="${belong.loginname}"
								<c:if test="${equipmentChange.maintainer==belong.loginname}">selected</c:if>
								
								>${belong.loginname}</option>
							</c:forEach>
				       </select>  
                </td>
                <tr>
    			<td class="text_alignRight table_td1Align fontSize3 bgColor4">    							
			        <label>审核说明</label>
			    </td>
				<td colspan="3">
			        <textarea id="approverremark" name="approverremark"  class="textAreaSy" style="width:95%;" placeholder="建议不要超过100字">${equipmentChange.approverremark}</textarea>
			    </td>			     
		   </tr>
		     
			</tbody>						
		</table>
		<div class="base3">
		    <c:if test="${equipmentChange.status ==1 }">
			<input type="button" value="保存" class="base3_btn1"	onclick="checkSubmit();" /> 
			</c:if>
			<input type="button" value="返回" class="base3_btn2" onclick="closewindow();" /> <%--onclick="closewindow();"  --%>
		</div>
	</form>
	<%--<iframe src="" height="10" id="iframe1" name="iframe1" width="20px" style="display:none"> </iframe>--%>
	</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var  productid="${equipmentChange.id}" ;	
		if(productid!=null&&productid!=""){
			$("#isupdate").val(1);
			$("#functiontitle").text("审核设备维修单"); 		
		}else{
			$("#functiontitle").text("新增设备维修单"); 	
		}
		//$('#description').text('${sjcsProduct.description}');
		 var type='${sjcsProduct.datatype}';
		if (type==2){
		   //$('#tableauRow').hide();
		   $('#textRow').show();
		}else {
		    $('#textRow').hide();
		   //$('#tableauRow').show();
		}	
		window.parent.iFrameHeight("rightFrame2");
	})

    function isNumber(obj) {
    	return typeof obj === 'number' && !isNaN(obj);
	}
	
	function changeDateType(){
		var checkValue=$("#datatype").val(); //获取Select选择的Value 
		if (checkValue==2){
		   //$('#tableauRow').hide();
		   $('#textRow').show();
		}else {
		    $('#textRow').hide();
		  //$('#tableauRow').show();
		}
	}
	function openTableauList(){
	      
		 layer.open({           
	            type: 2,//设定弹窗为iframe嵌套页面
	            title: ['选择tableau数据源', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	            area: ['600px', '495px'], 
	            content: ["${ctx}/datamap/datasupermarket/tableauDataSourceList.jsp","no"]
	           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	        });
	}
	function openClassTypeTree(){ 
	
	     layer.open({           
	            type: 2,//设定弹窗为iframe嵌套页面
	            title: ['选择商品分类', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	            area: ['600px', '430px'], 
	            content: ["${ctx}/datamap/datasupermarket/selectproductClassTypeTree.jsp","no"]
	           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	        });
	}
	function select(value,id){
	     $('#relationdatasourcename').val(value);
	     $('#relationdatasourceid').val(id);
	}
	function selectProduct(id,name){
	     $('#classtypename').val(name);
	     $('#classtype').val(id);
	}
	function checkSubmit() {
		   
		if (Validator.Validate(document.myform, 2)) {
		   	  if ($("#status").val()==3){
		   	  
		   	  	if ($("#maintainer").val()){
		   	  	   alert("审批不通过状态时，不能选维修负责人。");
		   	  	   
		   	  	}
		   	  }
		      document.getElementById("myform").submit();

		}
	}	
	function closewindow() {
		//document.myform.reset();
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);
	}
	
</script>
</body>
</html>
