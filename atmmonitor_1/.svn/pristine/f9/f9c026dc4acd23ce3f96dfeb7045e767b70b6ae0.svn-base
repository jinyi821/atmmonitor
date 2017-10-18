function showDialog(obj,id1){
	if(checkedTest()){
		$("#"+id1).css("display","");	
		var targetTop = $(window).height() / 4 + $(window).scrollTop();
		var targetLeft = $(window).width() / 3;	
		$("#"+id1).offset({top:targetTop,left:targetLeft});
		showBg("mask");
	}else{
		alert("您还没有同意遵守规定条约，请选择后再申请！");
	}
}

function checkedTest(){
    var nocheckCount = 0;
    var checkArry = document.getElementsByName("cc");
    for (var i=0,l=checkArry.length; i < l; i++) { 
        if(checkArry[i].checked == false){
            //未选中的操作
            nocheckCount++; 
        }
    }
    if( nocheckCount !=0 ){
        return false;
    }else{
    	return true;
    }
}

function hideDialog(id1,id2){
	$("#"+id1).css("display","none");
	$("#"+id2).remove();
	
}

function isCheck(id1,id2){
	var check=$("#"+id1).prop("checked");
	if(check){
		$("#"+id2).css("display","");
		$(".sqBtn").removeClass("sqBtnDisabled");
		$(".sqBtn").prop("disabled","");
	}else{
		$("#"+id2).css("display","none");
		$(".sqBtn").addClass("sqBtnDisabled");
		$(".sqBtn").prop("disabled","disabled");
	}
}
