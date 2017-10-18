$(document).ready(function(){
  	window.setInterval("reinitIframe('iframe1')", 200);
  	window.setInterval("reinitIframe('iframe2')", 200);
  	window.setInterval("reinitIframe('iframe3')", 200);
  	window.setInterval("reinitIframe('iframe4')", 200);
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