window.onload=function(){
	//videojs.options.flash.swf = "style/video/video-js1.swf";
};
function showVideo(obj,num){
	$(obj).addClass("videoListContentLiActive").siblings().removeClass("videoListContentLiActive");
	if(window.addEventListener){
		$("#example_video_1_html5_api").prop("src","style/video/other"+num+".mp4")
		$("#example_video_1 source").prop("src","style/video/other"+num+".mp4");
		var myPlayer = videojs('example_video_1');
	    videojs("example_video_1").ready(function(){
	        var myPlayer = this;
	        myPlayer.play();//自动播放
	    });
	}
    if(window.attachEvent){
    	videojs.options.flash.swf = "style/video/video-js"+num+".swf";
    	//$("#example_video_1_flash_api").prop("data","style/video/video-js"+num+".swf");
    	$("#example_video_1 object").prop("data","style/video/video-js"+num+".swf");
    	$("#example_video_1_flash_api").find("param[name='movie']").prop("value","style/video/video-js"+num+".swf");
    }
}
