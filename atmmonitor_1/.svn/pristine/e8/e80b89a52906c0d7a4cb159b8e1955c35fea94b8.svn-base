$(document).ready(function(){	
	/**下拉选择***/
	$(".js-example-basic-hide-search").select2({
	  minimumResultsForSearch: Infinity
  	});
  	$("#popModal").on("click",function(){
  		layer.open({
		 	type: 2,//设定弹窗为iframe嵌套页面
		 	title: ['弹出窗', 'font-size:18px;color:#333333;'],//弹窗标题的内容及对应样式
		 	area: ['720px', '500px'],//弹窗的宽度和高度
		  	content: ['baseStylePopModal.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		});
  	});
});