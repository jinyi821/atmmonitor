<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%> 	     
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台用户登入月份统计管理</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	    <meta http-equiv="description" content="this is my page">
	    <%--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">--%>
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
	    <meta name="renderer" content="webkit">
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/base/MyReset.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/common.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/main.css" />	
	     <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.css" />
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/common/select2.min.css" />  
	    <link rel="stylesheet" href="${ctx}/common/style/newstyle/css/page/wh.css" />
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/base/jquery-1.9.1.min.js" ></script>	    
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/select2.js" ></script>
	 <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
	   <script type="text/javascript" src="${ctx}/common/js/public.js"></script>
       <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
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
								          账号姓名
								   <input id="par_condition" type="text" class="inputSy1" style="width: 150px"/>
								          统计月份								       
								   <input type="text" id="par_month"  name="par_month" class="searchInput"  style="width: 100px" onClick="WdatePicker({dateFmt:'yyyyMM',readOnly:true,isShowDay:false,minDate:'2016-12-01',startDate:'2016-12-01',maxDate:'%y-#{%M-1}-1d'})" />
									是否合规
								   <select id="par_compliance" name="par_compliance" style="width:150px;" class="js-example-basic-hide-search"> 
													<option value="">全部</option>
													<option value="0">不合规</option>
													<option value="1">合规</option>
 									</select>
									<input type="button" value="搜索" class="base3_btn1"	onclick="query()" />
									<input type="button" value="统计 " class="base3_btn1" onclick="statistics()" />
		                            <input type="button" value="导出 " class="base3_btn1" onclick="exportData()" />
								      </div>           				
	                				</div>
	                				<div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                						<td>统计月份</td>
	                						 <td>账号</td>
		                                     <td>姓名</td>
		                                     <td>部门</td>
		                                     <td>状态</td>
		                                     <td>最后登录时间</td>
		                                     <td>是否合规</td>		                                    		                                     
		                                     <td>统计时间</td>	                                     
	                						</thead>
	                					  <tbody class="table_body">
	                					<tr>
										<td align="center">@@{statistics_login_month}</td>
		                                <td align="center">@@{loginname}</td>
		                                <td align="center">@@{fullname}</td>
		                                <td align="center">@@{depname}</td>
		                                <td align="center">@@{current_account_status[ENUM 0=停用;1=正常;2=冻结;null=;]}</td>		                                
		                                <td align="center">@@{last_logintime[TIME]}</td>
		                                <td align="center">@@{compliance_flag}</td>		                               	   
		                                <td align="center">@@{statisticstime[TIME]}</td>		    	    		    
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
		paraStr.par_month=$("#par_month").val();
		paraStr.par_compliance=$("#par_compliance").val();
	}
	function dataFunc(dataRow)
	{
		if(dataRow.compliance_flag=="true"){
			dataRow.compliance_flag="合规";	
		}else{
			dataRow.compliance_flag="不合规";
		}				
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserloginMonthStatistics.bsUserloginMonthStatisticsList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	function parentiFrameHeight(){
		window.parent.iFrameHeight("rightFrame2");
	}
	
	function statistics(){
	var par_month=$("#par_month").val();
	if(par_month==""){
		alert("请选择统计月份!");
		return;
	}
	var confrimflag=confirm("请确认统计"+par_month+"月份平台中所有的用户登入情况？");
	if(confrimflag){
		openMask(null,null,true);
		$.post("${ctx}/usermanager/bsuserloginmonthstatistics/bsUserloginMonthStatistics.action?par_month="+par_month,
				function(result){					 				 
					 if(result=="isExistTrue"){	
					 	 closeMask();					 
						 alert(par_month+"月份已经统计过台用户登入情况。");	
					 }else if(result=="processTrue"){
					     closeMask();
						 alert(par_month+"月份统计平台用户登入情况成功。");	
						 query();
					 }else if(result=="processFalse"){
						  closeMask();
					      alert(par_month+"月份统计平台用户登入情况失败！");	
					 }
				}
		);		
	}
	}	
	function exportData(){
		var par_month=$("#par_month").val();
		if(par_month==""){
			alert("请选择统计月份!");
			return;
		}
		var par_compliance=$("#par_compliance").val();
		var par_compliance_text=$("select[name=par_compliance] option[value="+par_compliance+"]").text();
		var confrimflag=confirm("请确认导出"+par_month+"月份平台中"+par_compliance_text+"用户登入统计数据？");
		if(confrimflag){
			openMask(null,null,true);			
			var url="${ctx}/usermanager/bsuserloginmonthstatistics/bsUserloginMonthStatisticsExportData.action?par_month="+par_month+"&&par_compliance="+par_compliance;
			var form=$('<form/>',{action:url,method:"post",style:"display:none"}).appendTo("body");
			form.submit();
		    closeMask();			
		}
		}	
	
	
</script>
</html>