$(function(){
	$(".excelIcon").mouseover(function(){
		$(this).next(".excelTip").css("display","");
	});
	$(".excelIcon").mouseout(function(){
		$(this).next(".excelTip").css("display","none");
	});
	changeTrColor("changeTrColorTable");
	returnTrColor("changeTrColorTable");
});

window.onload=function(){
	//弹出框
	$("#tjClick1").on("click",function(){
		layer.open({
		 	type: 2,
		 	shadeClose: true,
		 	title: ['数据分析师排名详情', 'font-size:18px;color:#333333;'],
		 	area: ['650px', '570px'],
		  	content: ['tjModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		}); 
	});
};