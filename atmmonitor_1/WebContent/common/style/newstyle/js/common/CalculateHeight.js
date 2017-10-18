function calculateHeight(){
	var height1=$(window).height();
	var height2=document.documentElement.scrollHeight;
	var pageHeight=Math.max(height1,height2);
	var frameHeight=$(".headerIframe").height();
	//var whHeight=$(".wh_head").height();
	var footHeight=$(".bodyFoot").height();
	var h=pageHeight-frameHeight-footHeight-20;
	$(".contentDiv").css("height",h);
	//$(".treeDiv").css("height",h*0.99);
	//$(".wh_modal").css("height",h*0.8);
}