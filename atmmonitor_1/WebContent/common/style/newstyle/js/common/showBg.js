//显示遮罩层js
function showBg(id){
	var newMask = document.createElement("div");
	newMask.id=(id?id:"zzc");//遮罩层ID，若未传入ID值，遮罩层id默认为zzc
	newMask.style.position = "absolute"; 
	newMask.style.zIndex = "10"; 
	newMask.setAttribute("name","Bgmask");//添加属性，作为标记
	_scrollWidth = Math.max(document.body.scrollWidth, document.documentElement.scrollWidth); 
	_scrollHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight); 
	newMask.style.width = _scrollWidth + "px"; 
	newMask.style.height = _scrollHeight + "px"; 
	newMask.style.top = "0px"; 
	newMask.style.left = "0px"; 
	newMask.style.background = "#666";
	newMask.style.filter = "alpha(opacity=40)";//IE兼容
	newMask.style.opacity = "0.40"; 
	document.body.appendChild(newMask); 
	newMask.onclick = function(){ 
		
		}; 
}