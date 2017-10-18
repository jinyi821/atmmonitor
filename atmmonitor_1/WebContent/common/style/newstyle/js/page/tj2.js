$(function(){
	$(".excelIcon").mouseover(function(){
		$(this).next(".excelTip").css("display","");
	});
	$(".excelIcon").mouseout(function(){
		$(this).next(".excelTip").css("display","none");
	});
});