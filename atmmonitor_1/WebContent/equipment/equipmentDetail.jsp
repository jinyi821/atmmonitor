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
<script type="text/javascript">
	$(function(){		
		var type='${sjcsProduct.datatype}';
		if (type==2){
		  // $('#tableauRow').hide();
		   $('#textRow').show();
		}else {
		    $('#textRow').hide();
		    //$('#tableauRow').show();
		}	
		window.parent.iFrameHeight("rightFrame2");
	})
	/* function closewindow() {
		//document.myform.reset();
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);
	}*/
</script>
<style type="text/css">
.table_body td{
	border-right: 1px solid #dddddd;
}
</style>
</head>
<body>
<div class="divsection"> 
	<div class="mxContent DivHeight marginBottom marginTop">
	   	<div class="wh_modal_head borderBottom Reposition">
		   <span style="margin-left:50px;font-size: 18px;" id="functiontitle">数据商品详细</span>							                				
	   </div>
          <table class="base_table ContentTable">
             <tbody class="table_body">
			<tr >
				<td width="15%" class="text_alignRight bgColor4">
				<label class="fontSize3">商品名称</label></td>				
				<td width="35%">${sjcsProduct.productname}
				</td>
				<td width="10%" class="text_alignRight bgColor4">
				     <label class="fontSize3">商品分类</label></td>
				<td width="40%" style="border-right:none;">					
						<c:forEach items="${data_class}"  var="classtype">
							   <c:if test="${sjcsProduct.classtype==classtype.id}">${classtype.name}</c:if>
						</c:forEach>
    			</td>
			</tr>
			<tr>
					<td  class="text_alignRight bgColor4">
					     <label class="fontSize3">数据格式</label></td>
					<td>
						<c:forEach items="${data_class_datatype}"  var="datatype">
								<c:if test="${sjcsProduct.datatype==datatype.id}">${datatype.name}</c:if>
						</c:forEach>
	               </td>
					<td class="text_alignRight bgColor4">
					     <label class="fontSize3">数据源</label></td>
					<td>
						<c:forEach items="${data_class_datasource}"  var="datasource">
								<c:if test="${sjcsProduct.datasource==datasource.id}">${datasource.name}</c:if>
							</c:forEach> 
					</td>
			</tr>
			<tr>
    			<td class="text_alignRight fontSize3 bgColor4">    							
			        <label>商品描述</label>
			    </td>
				<td colspan="3">
			       ${sjcsProduct.description}			      
			    </td>			     
		   </tr>
		   <tr >
				<td  class="text_alignRight bgColor4"><label
					class="fontSize3">商品价格</label></td>				
				<td>
				  <c:if test="${sjcsProduct.productprice==0}">
				      免费
				  </c:if>
				   <c:if test="${sjcsProduct.productprice>0}">
				       ${sjcsProduct.productprice}&nbsp;&nbsp;金币
				  </c:if>				 
				</td>
				<td class="text_alignRight bgColor4">
				     <label class="fontSize3">商品大小</label></td>
				<td>
					${sjcsProduct.productsize}&nbsp;&nbsp;M
				</td>
			</tr>
			 <tr>
 						<td class="text_alignRight bgColor4">
				     		<label class="fontSize3">路径</label></td>
						<td colspan="3" >
							${sjcsProduct.path}	
						</td> 						
		     </tr>		        					
			 <tr id="tableauRow" >	
				<td class="text_alignRight bgColor4">
				     <label class="fontSize3">相关Tableau数据源</label></td>
				<td colspan="3">
					${sjcsProduct.relationdatasourcename}					
				</td>
			</tr>
			 <tr id="textRow" style="display: none">	
				<td  class="text_alignRight bgColor4" >
				     <label class="fontSize3">相关文本数据样例</label></td>
				<td colspan="3">
					${sjcsProduct.textsamplename}
				</td>
			</tr>
			 <tr>	
				<td class="text_alignRight bgColor4">
				     <label class="fontSize3">原始数据源</label></td>
				<td colspan="3">
				   ${sjcsProduct.originaldatasource}					
				</td>
			</tr>
			<tr>
				<td width="160" class="text_alignRight bgColor4"><label
					class="fontSize3">数据粒度</label></td>				
				<td width="165">${sjcsProduct.datagranularity}
               </td>
				<td width="75" class="text_alignRight bgColor4">
				     <label class="fontSize3">保留时长</label></td>
				<td width="55">
				${sjcsProduct.retentiontime}
				</td>
			</tr>
			<tr>
    			<td class="text_alignRight fontSize3 bgColor4">    							
			        <label>详细字段</label>
			    </td>
				<td colspan="3">
			       ${sjcsProduct.detailfield}
			    </td>			     
		   </tr>
			<tr>
    			<td class="text_alignRight fontSize3 bgColor4">    							
			        <label>数据脱敏项</label>
			    </td>
				<td>
				  ${sjcsProduct.datadesensitization}			       
			    </td>	
			    <td class="text_alignRight fontSize3 bgColor4">    							
			        <label>脱敏操作</label>
			    </td>
				<td>
				  ${sjcsProduct.desensitizationoperation}			     
			    </td>			    		     
		   </tr>
				<tr>
    			<td class="text_alignRight fontSize3 bgColor4">    							
			        <label>试用场景</label>
			    </td>
				<td colspan="3">
				  ${sjcsProduct.suitablescene}			      
			    </td>			     
		   </tr>	
		   </tbody>		
		</table>
			<div class="base3">			
			<input type="button" value="返回" class="base3_btn2" onclick="history.go(-1);" /> <%--onclick="closewindow();"  --%>
		</div>
	</div>
	</div>
</body>
</html>
