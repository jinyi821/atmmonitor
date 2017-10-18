$(document).ready(function(){
	calculateHeight();		
	/**下拉选择***/
	$(".js-example-basic-hide-search").select2({
	  minimumResultsForSearch: Infinity
  	});
  	
  	/**隔行变色**/
  	$(".changeTrColor").find("tbody tr:odd").addClass("specialTrColor");
  	$(".changeTrColor").find("tbody tr:even").addClass("specialTrColor1");
  	
  	$(".wh_set").on("click",function(){
  		$(this).find(".setInfo").toggle();
  	});
  	
  	$(".setInfoUl li").on("click",function(){
  		$(this).find(".checkIcon").toggle();
  	});
  	
  	$(".hideTreeBtn").on("click",function(){
  		var state=$(this).next().css("display");
  		if(state!="none"){
  			$(this).next().hide();
  			$(this).removeClass("hideTreeBtn").addClass("showTreeBtn");
  			$(".rightContent").addClass("rightContentBig");
  		}else{
  			$(this).next().show();
  			$(this).removeClass("showTreeBtn").addClass("hideTreeBtn");
  			$(".rightContent").removeClass("rightContentBig");
  		}
  		
  	});
});

window.onload=function(){
	//设置等高
	//setHeight("DivHeight");
};

function setHeight(class1){
	var $columns = $('.'+class1);
	var height = 0;
	$columns.each(function () {  
		if ($(this).height() > height) {    
			height = $(this).height();  
		}
	});
	$columns.height(height);
}

function calculateHeight(){
	var height1=$(window).height();
	var height2=document.documentElement.scrollHeight;
	var pageHeight=Math.max(height1,height2);
	var frameHeight=$(".headerIframe").height();
	//var whHeight=$(".wh_head").height();
	var footHeight=$(".bodyFoot").height();
	var h=pageHeight-frameHeight-footHeight-20;
	$(".wh_contentDiv").css("height",h);
	//$(".treeDiv").css("height",h*0.99);
	//$(".wh_modal").css("height",h*0.8);
}

/**2016-3-24 ***/
function showSearch(){
	var _search=$(".wh_searchDiv");
	var obj=$(".slideIcon");
	var s=_search.css("display");
	if(s!="none"){
		_search.slideUp();
		obj.addClass("slideIconClick");
	}else{
		_search.slideDown();
		obj.removeClass("slideIconClick");
	}
}

/**左侧菜单树***/
function showList(obj,name){
	$(obj).next().toggle();
	var state=$(obj).next().css("display");
	if(state=="none"){
		$(obj).find("div[name='mark']").removeClass("showicon").addClass("showiconClick");
	}else{
		$(obj).find("div[name='mark']").removeClass("showiconClick").addClass("showicon");
	}		
}
