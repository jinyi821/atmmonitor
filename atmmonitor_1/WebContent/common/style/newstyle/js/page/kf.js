window.onload=function(){
	$(".editBtn").on("click",function(){
		layer.open({
		 	type: 2,
		 	title: ['编辑内容', 'font-size:18px;color:#333333;'],
		 	area: ['720px', '500px'],
		  	content: ['wzModal1.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		}); 
	});
	
	$(".pubBtn").on("click",function(){
		layer.open({
		 	type: 2,
		 	title: ['新增发布', 'font-size:18px;color:#333333;'],
		 	area: ['720px', '500px'],
		  	content: ['wzModal2.html', 'no'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		}); 
	});
};