<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <%@ include file="/common/taglibs.jsp"%> 	  
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>数据共享平台用户管理</title>
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
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/common/layer/layer.js" ></script>
	    <script type="text/javascript" src="${ctx}/common/style/newstyle/js/page/wh.js" ></script>
       <script type="text/javascript" src="${ctx}/common/js/listview_new.js"></script>
       <!--<link href="${ctx}/common/style/default/css/popup.css" rel="stylesheet" />
 		<script type="text/javascript" src="${ctx}/common/js/popuputil.js"></script>-->
       <script type="text/javascript" src="${ctx}/common/js/timeutil.js"></script>
  </head>
  <body>
  <div class="divsection">	    	
                <div class="bgColor1 wh_contentDiv">	               
                	<div  id="mx">
                		<div class="wh_content">
                		<div class="rightDiv">
                        <div class="mxContent DivHeight marginBottom marginTop" style="width:98%;">
		                        	<div class="wh_modal_head borderBottom Reposition">
		                        		<input type="button" value="新增用户" class="blueBtn"
									onclick="add()" />
								<div class="searchInfo">
									<input type="text" class="searchInput" id="par_condition"
										name="par_condition" />
									<div class="searchIcon"></div>
									<input type="button" value="搜索" class="base3_btn1"
										onclick="query()" />
								</div>	                				
	                				</div>	                			
	                				<div>
	                					<table class="base_table base_align_center changeTrColor" id="listtable">
	                						<thead class="table_head fontSize3">
	                							<td>登录名</td>
		                                     <td>用户名</td>		                                 
		                                     <td>性别</td>
		                                     <td>email</td>
		                                     <td>手机号</td>

		                                      <td>状态</td>
		                                      <td>创建时间</td>
		                                      <td>操作</td>
	                						</thead>
	                						<tbody class="table_body">
	                							<tr>
										<td align="center">@@{loginname}</td>
		                                <td align="center">@@{fullname}</td>		                              
		                                <td align="center">@@{sex}</td>
		                                <td align="center">@@{email}</td>
		                                <td align="center">@@{mobile}</td>
		                             		   
		                                <td align="center">@@{status[ENUM 1=正常;0=停用;2=冻结;]}</td>
		                                <td align="center">@@{createtime[TIME]}</td>		    	    		    
		                              <td align="center">
		                              <input type="button" class="transparentBtn" onclick="openBsUserinfo('@@{loginname}')"	value="编辑" />
		                              <input type="button" class="transparentBtn" onclick="deleteBsUserinfo('@@{loginname}')" value="删除" />
		    	                      </td>
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
	}
	function dataFunc(dataRow)
	{
		//if(dataRow.username=="lisi")
		//dataRow.username=dataRow.username+"【自定义】";
	}
	var table = new ListTable("listtable", "${ctx}/commonQuery/query.action",10, [["sqlname", "SQL_BsUserinfo.bsUserinfoList"]],preFunc,dataFunc,tableBoot,parentiFrameHeight);
	function query()
	{
		table.submit();
	}
	function add()
	{  	//PopupUtil.show(0,0,700, '${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action');
		//window.open("${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action"); 打开一个新窗口
		 //layer.open({           
	     //       type: 2,//设定弹窗为iframe嵌套页面
	     //       title: ['新增用户', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	     //       area: ['700px', '670px'], 
	     //      content: "${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action"
	           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	    //    });		
		window.location.href="${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action";		
	}
	function openBsUserinfo(loginname)
	{  
		//PopupUtil.show(0,0,700, '${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action?loginname='+loginname);
		//window.open("${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action?loginname="+loginname);		
		 //layer.open({           
	            //type: 2,//设定弹窗为iframe嵌套页面
	            //title: ['修改用户', 'font-size:14px;color:#333333;text-align:left;'],//弹窗标题的内容及对应样式
	            //area: ['700px', '670px'], 
	            //content: '${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action?loginname='+loginname
	           //content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	        //});
		window.location.href="${ctx}/usermanager/bsuserinfo/bsUserinfoLoad.action?loginname="+loginname;		
	}
	function deleteBsUserinfo(loginname){
		if(confirm("确定删除该用户？")){
			$.post("${ctx}/usermanager/bsuserinfo/bsUserinfoDel.action",
					{"loginname":loginname},function(result)
					{
						 var obj = eval("("+result+")"); 
						 
						 if(obj.flag=="true"){
							 
							 alert("删除成功！");							
							 table.submit();
						 }else{
							 alert("删除失败！");	
						 }
						 
					}
			);				
		}	
	}
	function parentiFrameHeight(){
				window.parent.iFrameHeight("rightFrame2");
			}
</script>	
</html>