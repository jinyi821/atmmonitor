// JavaScript Document

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



function changediv(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("div1_" + id_num + i);
		var divObj = document.getElementById("div" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'tab_show';
			divObj.style.display = '';
		}else
		 {
			divName.className = ' tab_hidden';
			divObj.style.display = 'none';
		}		
	}
}


function changeli(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("li1_" + id_num + i);
		var divObj = document.getElementById("li" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'li_show';
			divObj.style.display = '';
		}else
		 {
			divName.className = 'li_hide';
			divObj.style.display = 'none';
		}
		
		
	}
}

function changetab(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("tab1_" + id_num + i);
		var divObj = document.getElementById("tab" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'change_show';
			divObj.style.display = '';
		}else
		 {
			divName.className = 'change_hide';
			divObj.style.display = 'none';
		}
		
		
	}
}

function changedata(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("data1_" + id_num + i);
		var divObj = document.getElementById("data" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'data_show';
			divObj.style.display = '';
		}else
		 {
			divName.className = 'data_hide';
			divObj.style.display = 'none';
		}
		
		
	}
}



function changejoin(id_num, id, n)
 {
	for (var i = 1; i <= n; i++)
	 {
		var divName = document.getElementById("join1_" + id_num + i);
		
		 if (i == id)
		 {
			divName.className = 'join_show';
		}else
		 {
			divName.className = 'join_hide';
		}
		
		
	}
}



function showpro(num){
    var classname= $("#showselect"+num).attr("class");
	if(classname=='btn'){
	     $("#showselect"+num).attr("class","btn_select");
		 $("#angle_icon"+num).attr("class","show_icon");
		  $("#show_ul"+num).slideDown();
	}else{
	     $("#showselect"+num).attr("class","btn");
		 $("#angle_icon"+num).attr("class","hidden_icon");
		 $("#show_ul"+num).slideUp();
		
	}
}



function showwin(num){
    var classname= $("#showwin"+num).attr("class");
	if(classname=='btn_win'){
	     $("#showwin"+num).attr("class","btn_select_win");
		 $("#angle_iconwin"+num).attr("class","show_iconwin");
		  $("#show_ulwin"+num).slideDown();
	}else{
	     $("#showwin"+num).attr("class","btn_win");
		 $("#angle_iconwin"+num).attr("class","hidden_iconwin");
		 $("#show_ulwin"+num).slideUp();
		
	}
}

function showlogic(num){
    var classname= $("#showlogic"+num).attr("class");
	if(classname=='btn_logic'){
	     $("#showlogic"+num).attr("class","btn_select_logic");
		 $("#logic_icon"+num).attr("class","show_icon");
		  $("#show_logic"+num).slideDown();
	}else{
	     $("#showlogic"+num).attr("class","btn_logic");
		 $("#logic_icon"+num).attr("class","hidden_icon");
		 $("#show_logic"+num).slideUp();
		
	}
}


function showsmall(num){
    var classname= $("#showsmall"+num).attr("class");
	if(classname=='btn_small'){
	     $("#showsmall"+num).attr("class","btn_select_small");
		 $("#small_icon"+num).attr("class","show_icon");
		  $("#show_small"+num).slideDown();
	}else{
	     $("#showsmall"+num).attr("class","btn_small");
		 $("#small_icon"+num).attr("class","hidden_icon");
		 $("#show_small"+num).slideUp();
		
	}
}

function showbig(num){
    var classname= $("#showbig"+num).attr("class");
	if(classname=='btn_big'){
	     $("#showbig"+num).attr("class","btn_select_big");
		 $("#big_icon"+num).attr("class","show_icon");
		  $("#show_big"+num).slideDown();
	}else{
	     $("#showbig"+num).attr("class","btn_big");
		 $("#big_icon"+num).attr("class","hidden_icon");
		 $("#show_big"+num).slideUp();
		
	}
}




$(document).ready(function(){
	$(".close_show").mouseover(function(){
		$(this).find(".closebtn_show").show();
		
		});
	$(".close_show").mouseleave(function(){
		$(this).find(".closebtn_show").hide();

		});	
		});
		
		
function showchage(num){
    var classname= $("#showchage"+num).attr("class");
	if(classname=='input_hide'){
	     $("#showchage"+num).attr("class","input_show");
		  $("#windowdata"+num).slideDown();
	}else{
	     $("#showchage"+num).attr("class","input_hide");
		 $("#windowdata"+num).slideUp();
		
	}
}

function showmore(num){
    var classname= $("#searchmore"+num).attr("class");
	if(classname=='more_hide'){
	     $("#searchmore"+num).attr("class","more_show");
		  $("#field_show"+num).slideDown();
	}else{
	     $("#searchmore"+num).attr("class","more_hide");
		 $("#field_show"+num).slideUp();
		
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
