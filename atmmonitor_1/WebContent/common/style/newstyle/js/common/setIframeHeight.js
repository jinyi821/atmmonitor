//设置iframe高度
function setIframeHeight(id1){
	$(window.parent.document).find("#"+id1).load(function(){
		var main = $(window.parent.document).find("#"+id1);
		var thisheight = $(document).height()-150;
		main.height(thisheight);
	}); 
}