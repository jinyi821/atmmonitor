<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台用户登录日志管理</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	    <meta http-equiv="description" content="this is my page">
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	   <%--<link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" /> --%>
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />	   
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>
	  <%--   <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script> --%>
	  <%--  <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/changeTab.js" ></script> --%>
	   <%--  <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/checkboxModal.js" ></script> --%>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
	 <%-- <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script> --%>
       <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
       <!--<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>-->
       <script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
       	<script type="text/javascript" src="${ctx}/common/js/datepicker/wdatepicker.js"></script>
  </head>
  <body>
  <div class="divsection">	    	
                <div class="bgColor1 wh_contentDiv">	               
                	<div  id="mx">
                		<div class="wh_content">
                		<div class="rightDiv">
                         <div class="mxContent DivHeight marginBottom marginTop" style="width:98%;">
                        	<div class="wh_modal_head borderBottom Reposition">			
			         <div class="searchInfo">
				    <div class="searchIcon1"></div>				
				<div class="slideIcon" onclick="showSearchNew()"></div>				
			</div>
		</div>
		<div id="searchDiv" class="wh_searchDiv specialTrColor1 borderBottom" style="display: none;">
	          <table class="base_table info1">
	               <tr>
     							<td width="10%" class="text_alignRight">
     								<label class="font1 color">登录名:</label>
     							</td>
       							<td width="20%">
       								<input id="par_condition" type="text" class="inputSy1" style="width: 250px"/>
       							</td>
       							<td width="10%" class="text_alignRight">
       								<label  class="font1 color">登录日期：</label>
       							</td>
       							<td width="40%" class="base_padding_style2"> 
								<input type="text" id="bg_date"  class="inputSy1"  style="width: 150px" onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})" /><label>&nbsp;&nbsp;至&nbsp;&nbsp;</label>
								<input type="text" id="ed_date" class="inputSy1" style="width: 150px" onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})" />
       							</td>
       							<td width="20%" style="margin-right:30px;">
       							<%-- <div class="base3"> --%>
            			        <input type="button" value="搜索" class="base3_btn1" onclick="query()"/>
            		            <%-- </div> --%>
       							</td>
  						</tr>
  						<tr style="height:20px;line-height:20px;">
  						</tr>
  					</table>  					
  	            	</div>		               			
	                				<div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                							<td>登录名</td>
		                                     <td>登录日期</td>
		                                     <td>小时</td>
		                                     <td>年</td>
		                                     <td>月</td>
		                                     <td>周</td>
		                                     <td>是否成功</td>		                                     
		                                      <td>创建时间</td>	                                     
	                						</thead>
	                						<tbody class="table_body">
	                							<tr>
										<td align="center">@@{logingname}</td>
		                                <td align="center">@@{logindate[DATE]}</td>
		                                <td align="center">@@{hour}</td>
		                                <td align="center">@@{year}</td>
		                                <td align="center">@@{month}</td>
		                                <td align="center">@@{week}</td>		                               	   
		                                <td align="center">@@{issuccess[ENUM 1=成功;0=失败;]}</td>
		                                <td align="center">@@{createtime[TIME]}</td>		    	    		    
		                             </tr>	
	                						</tbody>
	                					</table>	                				
	                				</div>
		                        </div>
</div>
 </div>
 </div>
 </div>
 </div>                  
	</body>
  <script type="text/javascript">
	function preFunc(paraStr)
	{
		paraStr.isCount = 2;
		paraStr.par_condition=$("#par_condition").val();
		paraStr.bg_date=$("#bg_date").val();
		paraStr.ed_date=$("#ed_date").val(); 
	}
	function dataFunc(dataRow)
	{
		//if(dataRow.username=="lisi")
		//dataRow.username=dataRow.username+"【自定义】";		
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserloginRecord.bsUserloginRecordList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	  	function parentiFrameHeight(){
   		var searchDivCss=$(".wh_searchDiv").css("display");
		$(".wh_searchDiv").css("display","block");
		window.parent.iFrameHeight("rightFrame2");
		$(".wh_searchDiv").css("display",searchDivCss);
	}
	
	function showSearchNew(){
		var _search=$(".wh_searchDiv");
		var obj=$(".slideIcon");
		var s=_search.css("display");
		if(s!="none"){
			_search.slideUp();
			//window.parent.iFrameHeight("rightFrame2");
			obj.addClass("slideIconClick");				
		}else{
			_search.slideDown();
			//window.parent.iFrameHeight("rightFrame2");
			obj.removeClass("slideIconClick");			
		}				
	}
	
	
</script>
</body>
</html>