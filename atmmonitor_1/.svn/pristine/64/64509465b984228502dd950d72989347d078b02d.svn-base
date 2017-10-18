<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>用户访问记录列表</title> 
 		 <%@ include file="/common/taglibs.jsp"%> 
        <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
<!-- 	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" /> -->
<!-- 	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" /> -->
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/datepicker/wdatepicker.js"></script>
  </head>
  <body>
 <div class="mxContent  DivHeight marginBottom marginTop">
		<div class="wh_modal_head borderBottom Reposition">
			
			<div class="searchInfo">
<!-- 			    <lable>登录名：</lable> -->
<!-- 				<input type="text" class="searchInput" id="par_condition" -->
<!-- 					name="par_condition" /> -->
				<div class="searchIcon1"></div>
				&nbsp;
				<div class="slideIcon" onclick="showSearch()"></div> 
				
<!-- 				<input type="button" value="搜索" class="base3_btn1" onclick="query()" /> -->
<!-- 				<div class="slideIcon" onclick="showSearch()"></div> -->
			</div>
		</div>
		<div id="searchDiv" class="wh_searchDiv specialTrColor1 borderBottom" style="display: none;">
	          <table class="base_table info1">
	               <tr>
     							<td width="4%" class="text_alignRight">
     								<label class="font1 color">登录名:</label>
     							</td>
       							<td width="10%">
       								<input id="par_condition1" type="text" class="inputSy1"/>
       							</td>
       							<td width="4%" class="text_alignRight">
       								<label  class="font1 color">访问日期：</label>
       							</td>
       							<td width="10%" class="base_padding_style2">
 
								<input type="text" id="par_vistdate_condition_begin"  class="inputSy1"  size="20" style="width: 100px" onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})" /><label>-</label>
								<input type="text" id="par_vistdate_condition_end" class="inputSy1" style="width: 100px" onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})" />
       							</td>
       							<td width="4%" class="text_alignRight">
       								<label class="font1 color">模块名称：</label>
       							</td>
       							<td width="8%">
       								<input id="par_modulename_condition" type="text" class="inputSy1" style="width: 100px"/>
       							</td>
	                							
  							
  						</tr>
  					</table>
  					<div class="base3">
            			<input type="button" value="搜索" class="base3_btn1" onclick="query1()"/>
            		</div>
  		</div>

							<!--
                                	时间：2016-03-25
                                	描述：列表区域
                                -->
		<div>
			<table class="base_table base_align_center changeTrColor"
				id="listtable">
				<thead class="table_head fontSize3">
					<td scope="col">编号</td>
			    	<td scope="col">登录名 </td>
			    	<td scope="col">访问日期</td>
			    	<td scope="col">小时</td>
			     	<td scope="col">访问编号</td>
			      	<td scope="col" width="20%">链接地址</td>
			       	<td scope="col">应用类型</td>
<!-- 			        <td scope="col">模块ID</td> -->
			        <td scope="col">模块名称</td>
			        <td scope="col">生成时间</td>
				</thead>
				<tbody class="table_body">
					<tr>
						<td align="center">@@{pid}</td>
			  			<td align="center">@@{loginname}</td>
			  			<td align="center">@@{vistdate}</td>
			  			<td align="center">@@{visthour}</td>
			  			<td align="center">@@{linkid}</td>
			  			<td align="center">@@{linkurl}</td>
			  			<td align="center">@@{apptype[ENUM 0=其它;1=tableau应用;2=app;]}</td>
<!-- 			  			<td align="center">@@{moduleid}</td> -->
			  			<td align="center">@@{modulename}</td>
			  			<td align="center">@@{createtime[TIME]}</td>
              
					</tr>
				</tbody>
			</table>
			
		</div>
	</div>
			
  	</body>
    <script type="text/javascript">
	
	function showSearch(){
		
		$("#searchDiv").toggle();
	}
	var i=0;
	function preFunc(paraStr) {
		/*
		if($("#strstdate").val()>"1")
		{
			paraStr.stdate=$("#strstdate").val()+" 00:00:00";
		}		
		if($("#streddate").val()>"1")
		{
			paraStr.eddate=$("#streddate").val()+" 23:59:59";
		}*/
// 		paraStr.pageIndex = $("#pageIndex").val();
		if (i==0){
			paraStr.par_condition=$("#par_condition").val();
		} else {
		    paraStr.par_condition=$("#par_condition1").val();
		    paraStr.par_vistdate_condition_begin=$("#par_vistdate_condition_begin").val();
		    paraStr.par_vistdate_condition_end=$("#par_vistdate_condition_end").val();
		    paraStr.par_modulename_condition=$("#par_modulename_condition").val();
		}
		
		
	}
	function dataFunc(dataRow) {
		
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",
			10, [ [ "sqlname", "SQL_bsvistrecorde.list" ] ], preFunc, dataFunc,tableBoot);
	function query() {
	    i=0;
		table.submit();
	}
	
	function query1(){
		i=1;
		table.submit();
		
	}
	window.parent.iFrameHeight("rightFrame2");
</script>
</html>
