$(function(){
	var mySwiper = new Swiper ('.swiper-container', {
	    loop: true,
	    autoplay: 10000,//可选选项，自动滑动
	    paginationClickable :true,
	    autoplayDisableOnInteraction:false,
	    // 如果需要分页器
	    /*pagination: '.swiper-pagination',*/
	   pagination : '.pagination',
	   /* onSlidePrev:function(swiper){
		   changeLoopClass(swiper);
        },
        onSlideNext:function(swiper){
        	changeLoopClass(swiper);
        },*/
       onSlideChangeStart:function(swiper){
        	changeLoopClass(swiper);
        	/*this.startAutoplay();*/
        }
       /* onSlideReset:function(swiper){
        	mySwiper.onSlideReset();
        }*/
	  });
});
function changeLoopClass(swiper){	
	var  slide=swiper.slides[swiper.activeIndex];
	var slidehtml=slide.html();	
	var dom=parseDom(slidehtml);
	var bgcolor=dom[3].value;	
	$("#loopDiv").css("background-color",bgcolor);	
	/*if(swiper.activeLoopIndex==0){
   	   $("#loopDiv").css("background-color","#12679d");
   	}else if(swiper.activeLoopIndex==1){
   		$("#loopDiv").css("background-color","#0e1932");
   	}else{
   		$("#loopDiv").css("background-color","#111d37");
   	}*/
};	

//html字符串转化为dom对象
function parseDom(arg) {
	var objE = document.createElement("div");
	objE.innerHTML = arg;
	return objE.childNodes;	
	};