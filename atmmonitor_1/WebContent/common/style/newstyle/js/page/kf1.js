$(document).ready(function(){
  	window.setInterval("reinitIframe('zwkf_iframe1')", 200);
  	window.setInterval("reinitIframe('zwkf_iframe2')", 200);
  	/*window.setInterval("reinitIframe('zwkf_iframe3')", 200);
  	window.setInterval("reinitIframe('zwkf_iframe4')", 200);*/
});

//设置iframe高度
function reinitIframe(id1){
	var iframe = document.getElementById(id1);
	try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height =  height;
	}catch (ex){}
}

/**左侧菜单数***/
function showList1(obj,className,id1){
	$(obj).addClass(className);
	$(obj).parent().siblings().find("div[name='menu_Mark']").removeClass("leftMenuTree1_partDiv_active");
	$(obj).parent().siblings().find("div[name='mark1'] ul li").removeClass("menu1_ul_liClick");
	if(id1){
		$("#"+id1).show();
		$("#"+id1).siblings("iframe").hide();
	}
}

function changeMenu(event,className1,id1){
	var ev = event || window.event;
    var target = ev.target || ev.srcElement;
	if(target){
		$(target).addClass(className1);
		$(target).siblings().removeClass(className1);
		var p1=$(target).parent().parent().parent().siblings();
		p1.find("div[name='menu_Mark']").removeClass("leftMenuTree1_partDiv_active");
		p1.find("div[name='mark1'] ul li").removeClass("menu1_ul_liClick");
		$("#"+id1).show();
		$("#"+id1).siblings("iframe").hide();
	}
}

function delList(obj){
	$(obj).parent().remove();
}
