function showInfo(event,id,className1,className2){
			var classname1=(className1?className1:"special_color");
			var classname2=(className2?className2:"special_color3");
			if(event.target){
				$(event.target).addClass(classname1);
				$(event.target).siblings().removeClass(classname1);
				$(event.target).siblings().addClass(classname2);
				if(id && id !=""){
					$("#"+id).css("display","");
					$("#"+id).siblings().css("display","none");	
				}
			}else if(event.srcElement){
					$(event.srcElement).addClass(classname1);
					$(event.srcElement).siblings().removeClass(classname1);
					$(event.srcElement).siblings().addClass(classname2);
					if(id && id!=""){
						$("#"+id).css("display","");
						$("#"+id).siblings().css("display","none");
					}
			}
}

function showInfo1(event,className1,id1){
	alert(1);
//	var ev = event || window.event;
//    var target = ev.target || ev.srcElement;
//	if(target){
//		$(target).addClass(className1);
//		$(target).siblings().removeClass(className1);
//		$("#"+id1).show();
//		$("#"+id1).siblings().hide();
//	}
}

function changeli(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("li1_" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'tab_show';
		}else
		 {
			divName.className = 'tab_hidden';

		}
		
		
	}
}

function changediv(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("div1_" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'red_flower';
		}else
		 {
			divName.className = 'grey_flower';

		}
		
		
	}
}
function setclass(div_id){
	var div1 = document.getElementById(div_id);
	if(div1.className=='config_off'){
		div1.className='config_on';
	}else{
		div1.className='config_off';
	}
}

function changeRow_color(obj) {
	if (document.getElementById(obj) != null) {
		var Ptr=document.getElementById(obj).getElementsByTagName("tr");
		
			for (var i=1;i<Ptr.length+1;i++) 
			{ 
			if(i%2>0)
			 { Ptr[i-1].className = "t2";}
			else
			 {Ptr[i-1].className = "t1";}
			}
		for(var i=0;i<Ptr.length;i++) {
			Ptr[i].onmouseover=function(){
			this.tmpClass=this.className;
			this.className = "t3";    
			};
			Ptr[i].onmouseout=function(){
			this.className=this.tmpClass;
			};
		}
	}
}


$(document).ready(function(){
    $(".add_file_blue").click(function(){
		$(this).css('display','none');
		$(".add_remarks").css('display','block');
		});
	/*$(".base10_btn10").click(function(){
		$(".add_remarks").css('display','none');
		$(".add_file_blue").css('display','block');
		});*/
		
});
function close_tips(){
	$(".black_bg").hide();
	$(".bomb_box5").hide();
}
function show_tips(){
	$(".black_bg").show();
	$(".bomb_box5").show();
}