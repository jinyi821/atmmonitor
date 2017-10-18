$(function(){
	/**下拉选择***/
	$(".js-example-basic-hide-search").select2({
	  minimumResultsForSearch: Infinity
  	});
});

window.onload=function(){
	var myfunction=document.getElementById("Docbtn");
    myfunction.onchange=function(){
        document.getElementById("DocfileUploadText").value= myfunction.value;
        $("#DocshowUploadTr").slideDown();
        $("#DocuploadFileName").text(myfunction.value);
	}
    
    $("#DocuploadCancle").on("click",function(){
    	$("#DocfileUploadText").val("");
    	$("#DocshowUploadTr").slideUp();
    });
    
    /**删除标签***/
    $(".delCover").on("click",function(){
    	$(this).parent().remove();
    });
    
    /**添加标签***/
   	var tagArray=[];
    $(".addTagIcon").on("click",function(){
    	var state=$("#DoctgInput").css("display");
    	if(state=="none"){
    		$("#DoctgInput").css("display","")
    	}else{
    		var tagValue=$("#DoctgInput").val();
    		var tagHtml="<div class=\"blockInverse Reposition marginLeft\">";
    		tagHtml+="<div class=\"tagArrow\"></div>";
    		tagHtml+="<div class=\"tagRec\">"+tagValue+"</div>";
    		tagHtml+="<div class=\"delCover\"></div></div>";    		
    		if(tagValue!=""){
    			for(var i=0,len=tagArray.length;i<len;i++){
    				if(tagArray[i]==tagValue){
      					$("#DocTipHave").css("display","");
    					return;
    				}
    			}
    			$("#DoctgInput").before(tagHtml);
    			console.log(tagArray);
				/**重新添加事件***/
				$(".delCover").on("click",function(){
				    $(this).parent().remove();
				});
				$("#DoctgInput").val("");
				$("#DoctgInput").css("display","none");
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
