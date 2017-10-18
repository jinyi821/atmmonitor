//显示tip
function showSqTip(id1,id2){
	$("#"+id1).mouseover(function(){
		var targetTop = $(this).offset().top + $(this).height();
		var targetLeft = $(this).offset().left;
		targetTop=Number(targetTop)+Number(10);
		targetLeft=Number(targetLeft)-Number(145);
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