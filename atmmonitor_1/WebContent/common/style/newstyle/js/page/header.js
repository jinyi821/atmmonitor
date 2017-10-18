/*window.onload=function(){
	    		$("#headerNav li").mouseover(function(){
	    			var that=$(this);
	    			that.find("a div[name='userIcon']").addClass("userHover");
	    			that.find("a div[name='username']").addClass("color16");
					var targetTop = that.offset().top + that.height();
					targetTop=targetTop-16;
					var targetLeft = that.offset().left;
					$(that.find("ul")).css("display","");
					$(that.find("ul")).offset({top:targetTop,left:targetLeft});
				});
				$("#headerNav li").mouseout(function(){
					var _this=$(this);
					_this.find("a div[name='userIcon']").removeClass("userHover");
					_this.find("a div[name='username']").removeClass("color16");
					$(_this.find("ul")).css("display","none");
					$(_this.find("ul")).mouseover(function(){
						$(this).css("display","");
					});
				});
				$(".firstUL_Li").mouseover(function(){
					$(this).find("li div").addClass("wxHover");
				});
				$(".firstUL_Li").mouseout(function(){
					$(this).find("li div").removeClass("wxHover");
				});
};*/
$(function() {
	if (menuId != "")
		changeClass(menuId);
		
	$("#headerNav li").mouseover(function() {
		var that = $(this);
		that.find("a div[name='userIcon']").addClass("userHover");
		that.find("a div[name='username']").addClass("color16");
		var targetTop = that.offset().top + that.height();
		targetTop = targetTop - 16;
		var targetLeft = that.offset().left;
		$(that.find("ul")).css("display", "");
		$(that.find("ul")).offset({
			top : targetTop,
			left : targetLeft
		});
	});
	$("#headerNav li").mouseout(function() {
		var _this = $(this);
		_this.find("a div[name='userIcon']").removeClass("userHover");
		_this.find("a div[name='username']").removeClass("color16");
		$(_this.find("ul")).css("display", "none");
		$(_this.find("ul")).mouseover(function() {
			$(this).css("display", "");
		});
	});
	
	
	$("#wxLi").mouseover(function() {
		$(this).find("div").addClass("wxHover");
	});
	$("#wxLi").mouseout(function() {
		$(this).find("div").removeClass("wxHover");
	});
});

function changeClass(id) {
	
	$("input[name='menubutton']").each(function() {
		$(this).attr("class", "h_btn");
	});
	$("#menubutton_" + id).attr("class", "h_btn h_btnClick");
};

function openMenu(menuurl, menuid) {

	if (!menuurl) {
		alert('该栏目正在建设中，敬请关注!');
		return;
	}
	var url = $ctx + "/" + menuurl + "?menuId=" + menuid;
	window.parent.location.href = url;
}
function exitLogin() {

	if (confirm("是否退出登录？")) {
		var url = $ctx + "/portal/reloadLogin.action";
		window.parent.location.href = url;
	}

}
function closeSession() {

	var url = $ctx + "/portal/reloadLogin.action";
	$.post(url);
}

function doSign(loginname,signDate){
	var signExistFlag=false;
	var doSignExsitUrl=$ctx+"/usermanager/bsusersignrecord/bsUserSignRecordDoExist.action";
	var doSignSaveUrl=$ctx+"/usermanager/bsusersignrecord/bsUserSignDoSave.action";
	$.ajaxSetup({
		async : false
	});	
	$.post(doSignExsitUrl, {"loginname":loginname,"signDate":signDate}, function(result) {
		signExistFlag=result;
	 });
	if(!signExistFlag){
		$.ajaxSetup({
			async : false
		});	
		$.post(doSignSaveUrl, {"loginname":loginname,"sign_date":signDate}, function(result) {
			var  obj=eval("("+result+")");
			if(obj.doSignFlag){
			  alert("今日签到成功，获得签到积分"+obj.signScore+"分。");
			  doSignFlag=true;
			  //$("#dosign").addClass("dosignin");
			 /* $("#dosign").prop("value","已签到");	*/
			}else{
			  alert("今日签到失败!");	
			}		 
		 });		
	}else{
		alert("今日已签到，无需再次签到！");		
	}	
}

function showWx() {
	layer.open({
		type : 2,// 设定弹窗为iframe嵌套页面
		title : [ '二维码  &nbsp;&nbsp;&nbsp;&nbsp; 扫码关注IT聚友会，接收最新IT动态！',
				'font-size:18px;color:#333333;' ],// 弹窗标题的内容及对应样式
		area : [ '500px', '500px' ],// 弹窗的宽度和高度
		content : [ $ctx + '/portal/wx.jsp', 'no' ]
	// 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com',
	// 'no']
	});
}
function updatePassword(loginname) {
	layer
			.open({
				type : 2,// 设定弹窗为iframe嵌套页面
				title : [ '修改密码', 'font-size:18px;color:#333333;' ],// 弹窗标题的内容及对应样式
				area : [ '500px', '300px' ],// 弹窗的宽度和高度
				content : [
						$ctx
								+ '/usermanager/bsuserinfo/bsUserinfoUpdatePwdLoad.action?loginname='
								+ loginname, 'no' ]
			// 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
			// ['http://sentsin.com', 'no']
			});
}