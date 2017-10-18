$(document).ready(function(){
	$(".xq_dz").on("click",function(){
		var dznum=$(".dzNum").text();
		dznum=Number(dznum)+Number(1);
		$(".dzNum").text(dznum);
		$(this).css("display","none");
		$(".xq_dzh").css("display","");
	});
	$(".xq_dzh").on("click",function(){
		$(".dztext").css("visibility","visible");
		setTimeout(function(){
			$(".dztext").css("visibility","hidden");
		},3000);
	});
	
	$(".pl_dzh").on("click",function(){
		var clickParentNode=$(this).parent();
		var dznum=$(clickParentNode.find(".pl_text")).text();
		dznum=Number(dznum)-Number(1);
		$(clickParentNode.find(".pl_text")).text(dznum);
		$(this).css("display","none");
		$(clickParentNode.find(".pl_dz")).css("display","");
	});
	
	$(".pl_dz").on("click",function(){
		var clickParentNode1=$(this).parent();
		var dznum=$(clickParentNode1.find(".pl_text")).text();
		dznum=Number(dznum)+Number(1);
		$(clickParentNode1.find(".pl_text")).text(dznum);
		$(this).css("display","none");
		$(clickParentNode1.find(".pl_dzh")).css("display","");
	});
	
	$(".hfDiv").on("click",function(){
		$(this).next().toggle();
		
	});
	
	$(".cancle_hf").on("click",function(){
		var p=$(this).parent();
		$(p.prev()).val("");
		$(this).parent().parent().hide(100);
	});
	
	//回复功能
	$(".hfBtn").on("click",function(){
		var p=$(this).parent();
		var p1=p.parent();
		var p2=p1.parent();
		var p3=p2.parent();
		var hfContent=$(p.prev()).val();
		var hfHTML="<div class=\"spHeight\">";
		hfHTML+="<div class=\"floatLeft\">";
		hfHTML+="<div class=\"user marginRight\"></div>";
		hfHTML+="<label class=\"fontSize3 color7\">me</label>&nbsp;&nbsp;";//假设当前用户名是me
		hfHTML+="<label class=\"font1 color\">1小时前</label></div>";
		hfHTML+="<div class=\"plFloorNum\">";
		hfHTML+="<label class=\"color\">121楼</label></div><div class=\"ClearFloat\"></div>";
		hfHTML+="</div>";
		hfHTML+="<div class=\"ClearFloat\"></div>";
		hfHTML+="<div class=\"marginBottom2\">";
		hfHTML+="<label class=\"font1 fontSize3\">"+hfContent+"</label></div>";
		var prevPlcontent=$(p3.find(".prev_pl").find(".prev_plContent")).text();
		var prevPluser=$(p3.find(".prev_pl").find(".prev_user")).text();
		var prevPltime=$(p3.find(".prev_pl").find(".prev_time")).text();
		$(p3.find(".prev_pl")).html("");
		$(p3.find(".prev_pl")).html(hfHTML);
		
		//先前评论内容
		var plHtml="<div class=\"plhf_arrow\"></div>";
		plHtml+="<div class=\"spHeight\">";
		plHtml+="<div class=\"user marginRight\"></div>";
		plHtml+="<label class=\"fontSize3 color7\">"+prevPluser+"</label>&nbsp;&nbsp;";
		plHtml+="<label class=\"font1 color\">"+prevPltime+"</label></div>";
		plHtml+="<div class=\"ClearFloat\"></div>";
		plHtml+="<div class=\"marginBottom2\">";
		plHtml+="<label class=\"font1 fontSize3\">"+prevPlcontent+"</label></div>";
		
		$(p3.find(".plhf_content")).css("display","");
		$(p3.find(".plhf_content")).html(plHtml);
		$(p1).remove();
	});
});
