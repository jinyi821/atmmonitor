$(document).ready(function(){
	//calculateHeight();
});


/**左侧菜单树***/
function showMenuLi(obj){
	$(obj).next().toggle();		
}

window.onload=function(){
	showTip("ct1_storePos","ct1_storePosTip");
};

//显示tip
function showTip(id1,id2){
	$("#"+id1).mouseover(function(){
		var targetTop = $(this).offset().top + $(this).height();
		var targetLeft = $(this).offset().left;
		$("#"+id2).css("display","");
		$("#"+id2).offset({top:targetTop,left:targetLeft});
	});
	$("#"+id1).mouseout(function(){
		$("#"+id2).css("display","none");
		$("#"+id2).mouseover(function(){
			$(this).css("display","");
		});
	});
	$("#"+id2).mouseover(function(e){
		e = e || window.event;
		e.stopPropagation();
		$("body").mouseover(function(e){
			$("#"+id2).hide(1);
			$("body").unbind("mouseover");
		});
	});
}