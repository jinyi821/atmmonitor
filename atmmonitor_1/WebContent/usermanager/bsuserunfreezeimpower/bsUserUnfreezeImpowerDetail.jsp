<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据共享平台人员登录账号解冻申请详细页面</title>
	   <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/videoUpload.css" />
	   <%-- <script type="text/javascript"	src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js"></script> --%>       
	</head>
	<body>
			<div class="divsection">	    	
	    		<div class="bgColor1 borderTop">
	        		<div class="Ct contentDiv" style="width:600px;padding-bottom:0px;">
	        			<%-- <div class="up_head">
	        				<label class="color2 fontSize2">用户登录账号解冻申请</label>
	        			</div> --%>
	        			<div class="up_content" style="padding-top:20px;">
	        				<div class="up_contentTableDiv" style="padding-left:5px;padding-right:20px;">
		        				<table class="base_table ContentTable">			        					
		        					<tr>
		        						<td class="text_alignRight fontSize3" width="20%">		        						
		        							<label>申请人登录名</label>
		        						</td>
		        						<td  width="80%">
		        						    ${bsUserUnfreezeImpower.apply_loginname}		        							
		        						</td>
		        					</tr>
		        					<tr>
		        						<td class="text_alignRight fontSize3"  width="20%">		        						
		        							<label>申请人姓名</label>
		        						</td>
		        						<td width="80%">
		        						     ${bsUserUnfreezeImpower.apply_fulllname}
		        						</td>
		        					</tr>		        					
		        					<tr>
		        						<td class="text_alignRight  fontSize3" width="20%">		        							
									        <label>长期未登录缘由</label>
									    </td>
										<td width="80%">
										   ${bsUserUnfreezeImpower.frozen_reason}									       
									    </td>
		        					</tr>
		        					<tr>
		        						<td class="text_alignRight  fontSize3" width="20%">
		        							<label>申请解冻缘由</label>
									    </td>
										<td width="80%">
										   ${bsUserUnfreezeImpower.apply_unfreeze_note}	
									    </td>
		        					</tr>		        					
		        				</table>		        			
		        			</div>
		        			<div class="base3 borderTop uploadBtnBlock" style="margin-top:0px;padding-top:10px;padding-bottom:10px;">
								<input type="button" value="关闭窗口" class="base3_btn2 fontSize3" onclick="closeWindow();"/>
							</div>
	        			</div>
	        		</div>
	       		</div>
	   </div> 
	</body>
	<script type="text/javascript">
	function closeWindow(){
	var index=parent.layer.getFrameIndex(window.name); //获取窗口索引
	parent.layer.close(index);	 
	}		
	</script>
</html>