<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <%@ include file="/common/taglibs.jsp"%> 
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台人员登录账号解冻申请审批记录</title>
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
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
       <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
       <script type="text/javascript" src="${ctx}/common/js/datepicker/wdatepicker.js"></script>
        <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>	    
       <script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
      <style type="text/css">
    .searchInfoNew{
	position: relative;
	display: inline-block;
    }   
    .searchIconNew{
	width: 13px;
	height: 13px;
	display: inline-block;
	cursor: pointer;
	background: url(${ctx}/common/style/newstyle/images/tcircle.png) no-repeat;
	position:absolute;
	left: 8px;
	top:8px;	
  }
   .mxContent{
   z-index:12001;
   }
 </style>
</head>
<body>
	<div class="mxContent  DivHeight marginBottom marginTop">			
			        <div class="wh_modal_head borderBottom Reposition">	                				
	                					<div class="searchInfo">	                						
	                						<input  type="hidden" id="userLoginname" name="userLoginname" value="${userSession.loginname}">
					                        <input  type="hidden" id="isAdminRole" name="isAdminRole" value="${userSession.isAdminRole}">
	                					    <%-- <input type="text" class="searchInput"  readonly style="width:13px"/> --%>
	                						<div class="searchIcon" style="position:relative;left:0px;top:0px;"></div> <%-- style="position:relative;left:0px;top:0px;" --%>
	                						<div class="slideIcon" onclick="showSearchNew()"></div>
	                					</div>
	                				</div>
	                				<div class="wh_searchDiv specialTrColor1 borderBottom"  id="searchdiv" style="padding-bottom:20px;display:none;">
	                				<table class="base_table">
	                						<tr>
	                						   <td width="10%" class="text_alignRight">
	                								<label class="font1 color">申请人</label>	
	                							</td>
	                							<td width="20%">
	                								<div class="searchInfoNew">	                								
	                								<input type="text" class="searchInput" style="width:200px;" id="apply_user" name="apply_user" />
	                								<div class="searchIconNew"></div>
	                								</div>
	                							</td>	                						
	                							 <td width="10%" class="text_alignRight">
	                								<label class="font1 color">申请日期</label>	
	                							</td>
	                							<td width="20%">
	                								<div class="searchInfoNew">
	                							    <input type='text'  class='searchInput' style="width:200px;" id='bg_date' name="bg_date"  onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})"/>
	       				                            <div class="searchIconNew"></div>
	       				                            </div>
	                							</td>	                						
	                							<td width="10%" class="text_alignRight">
	                								<%-- &nbsp;&nbsp;<div class="intervalIcon"></div>&nbsp;&nbsp; --%>
	                								<label class="font1 color">&nbsp;&nbsp;至&nbsp;&nbsp;</label>	
	                							</td>
	                							<td width="20%">
	                								<div class="searchInfoNew">	                								
	                								<input type="text" class="searchInput" style="width:150px;"id="ed_date" name="ed_date" onClick="WdatePicker({dateFmt:'yyyyMMdd',readOnly:true,minDate:'%y%M%d'})"/>
	                								<div class="searchIconNew"></div>
	                								</div>
	                							</td>	                								                							
	                						<td width="10%" rowspan="3" valign="middle">
	       				                     <input type="button" value="搜索" class="base3_btn1" onclick="query()" />
	       				                    </td>
	                						</tr>	                						
	                					</table>	                				          						                						
	       				              </div>
	       			<div>
				<table class="base_table base_align_center" id="listtable">
					<thead class="table_Head5">	
						<td>申请人登录名</td>						
						<td>申请人姓名</td>
					    <td>申请时间</td>
						<td>审批状态</td>
						<td>审批时间</td>					
						<td>操作</td>
					</thead>
					<tbody class="table_body8">
						<tr>
						<td>@@{apply_loginname}</td>
						<td>@@{apply_fulllname}</td>
						<td>@@{createtime[TIME]}</td>
						<td>@@{impower_status[ENUM 0=无需审批;1=审批中;2=审批通过;3=审批不通过;]}</td>
						<td>@@{impowertime[TIME]}</td>
						<td>
							   <input type="button" class="transparentBtn" style="width:100px;" onclick="openApplyDetail('@@{id}')"value="明细" />	
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
       <script type="text/javascript">
       function preFunc(paraStr)
   	{
   		paraStr.isCount = 2;
   		paraStr.userLoginname=$("#userLoginname").val();
		paraStr.isAdminRole=$("#isAdminRole").val();
		paraStr.par_condition=$("#par_condition").val();
		paraStr.apply_user=$("#apply_user").val();	
		paraStr.bg_date=$("#bg_date").val();
		paraStr.ed_date=$("#ed_date").val();   		
   	}
   	function dataFunc(dataRow)
   	{
   	
   	}
   	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserUnfreezeImpower.bsUserUnfreezeImpowerList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
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
 	function openApplyDetail(id){      	
	    layer.open({
	 	type: 2,
	 	title: ['登录账号解冻申请审批明细', 'font-size:14px;color:#666666;'],
	 	area:['602px','300px'],
	  	content: ['${ctx}/usermanager/bsuserunfreezeimpower/bsUserUnfreezeApplyLoad.action?loadType=view&&id='+id, 'no']
	 });   		
    }
   </script>
</body>
</html>