$(function(){
	/**下拉选择***/
	$(".js-example-basic-hide-search").select2({
	  minimumResultsForSearch: Infinity
  	});
});

window.onload=function(){
	var myfunction=document.getElementById("btn");
    myfunction.onchange=function(){
        document.getElementById("fileUploadText").value= myfunction.value;
        $("#showUploadTr").slideDown();
        $("#uploadFileName").text(myfunction.value);
	}
    
    var myfunction1=document.getElementById("coverbtn");
    myfunction1.onchange=function(){
        document.getElementById("coverfileUploadText").value= myfunction1.value;
	}
    
    $("#uploadCancle").on("click",function(){
    	$("#fileUploadText").val("");
    	$("#showUploadTr").slideUp();
    });
    
    /**删除标签***/
    $(".delCover").on("click",function(){
    	$(this).parent().remove();
    });
    
    /**添加标签***/
   	var tagArray=[];
    $(".addTagIcon").on("click",function(){
    	var state=$("#tgInput").css("display");
    	if(state=="none"){
    		$("#tgInput").css("display","")
    	}else{
    		var tagValue=$("#tgInput").val();
    		var tagHtml="<div class=\"blockInverse Reposition marginLeft\">";
    		tagHtml+="<div class=\"tagArrow\"></div>";
    		tagHtml+="<div class=\"tagRec\">"+tagValue+"</div>";
    		tagHtml+="<div class=\"delCover\"></div></div>";    		
    		if(tagValue!=""){
    			for(var i=0,len=tagArray.length;i<len;i++){
    				if(tagArray[i]==tagValue){
      					$("#tipHave").css("display","");
    					return;
    				}
    			}
    			$("#tgInput").before(tagHtml);
				/**重新添加事件***/
				$(".delCover").on("click",function(){
				    $(this).parent().remove();
				});
				$("#tgInput").val("");
				$("#tgInput").css("display","none");
				$(".addTagIcon").next().css("display","none");
    			tagArray.push(tagValue);
    		}
    	}
    });
    
    /**清除封面**/
	    $(".cancleCover").on("click",function(){
	    	$(this).parent().parent().parent().css("display","none").prev().css("display","");
	    });
};
