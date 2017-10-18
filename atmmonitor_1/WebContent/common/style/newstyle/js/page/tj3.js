window.onload=function(){
	//左右箭头切换
	//滚动
	//展示列表长度
	var headScroll=$("#content_head1_scroll");
	var len=headScroll.children().length;
	if(len>4){		
		$("#scrollSec").mouseover(function(){
			$("#leftArrow").css("display","");
			$("#rightArrow").css("display","");
		});
		$("#scrollSec").mouseout(function(){
			$("#leftArrow").css("display","none");
			$("#rightArrow").css("display","none");
		});
		//循环滚动
		//headScroll.find("div").eq(0).addClass("content_head1Margin");
		var scrollPic = new ScrollPic();
		scrollPic.scrollContId   = "content_head1_scroll"; //内容容器ID
		scrollPic.arrRightId      = "leftArrow";//左箭头ID
		scrollPic.arrLeftId      = "rightArrow";//右箭头ID
		scrollPic.frameWidth     = 1138;//显示框宽度
		scrollPic.pageWidth      = 292; //翻页宽度
	
		scrollPic.speed          = 10; //移动速度(单位毫秒，越小越快)
		scrollPic.space          = 5; //每次移动像素(单位px，越大越快)
		scrollPic.autoPlay       = true; //自动播放
		scrollPic.autoPlayTime   = 3; //自动播放间隔时间(秒)
		scrollPic.circularly     = false;//循环播放
		scrollPic.initialize(); //初始化
	}
};

function showArrowTab(obj,id1){
	$(obj).children("div:last-child").css("display","");
	$(obj).siblings("div").children("div:last-child").css("display","none");
	if(id1){
		$("#"+id1).css("display","");
		$("#"+id1).siblings().css("display","none");
	}
}