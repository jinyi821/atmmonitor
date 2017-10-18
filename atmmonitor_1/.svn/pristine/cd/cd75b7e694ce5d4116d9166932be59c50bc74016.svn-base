/**
 * $("#"+domid).pages({rowCount:500,pageSize:5,pageNumber:8,clickPageCallBack:function(number,data){},data:undefined,align:"center"});
 */
(function($){
	$.PageObj = $.PageObj || {};
    $.extend($.PageObj, {
        extend: function (methods) {
            $.extend($.fn.simplePages, methods);
            $.fn.extend(methods);
        }
    });
	
	$.fn.pages = function(pin){
		var p = $.extend(true, {
            rowCount:0,
			pageSize:10,
			pageNumber:0,
			clicknumber:7,
			data:undefined,
			align:undefined,
			clickPageCallBack:undefined
        }, $.PageObj.defaults, pin || {});
	
		this.p = p;
		var ts = this;
		var data = p.data;
		p.pageCount = Math.ceil(p.rowCount/p.pageSize);
		if(p.pageCount == 0) p.pageNumber = 0;
		
		var next = 2;
		var middle = Math.ceil(p.clicknumber/2);
		
		if(p.pageNumber>p.pageCount){
			p.pageNumber=p.pageCount;
		}else if(p.pageNumber<=0){
			p.pageNumber=1;
		}
			
		
		if(p.pageNumber>p.pageCount-middle && p.pageCount>p.clicknumber){
			next = p.pageCount-p.clicknumber+2;
		}else if(p.pageNumber>middle && p.pageCount>p.clicknumber){
			var upnumber = Math.ceil((p.clicknumber-2-1)/2);
			next = p.pageNumber - upnumber;
		}
		
		ts.empty();
		
		if(p.align == undefined || p.align=="right"){
			ts.css("float","right");
		}else if(p.align=="left"){
			ts.css("float","left");
		}
		
		ts.append('<div class="pagePrev"></div>');
		if(p.pageCount>0){
			if(p.pageCount>1){
				if(p.pageNumber!=1)
					ts.append('<div class="pageNum">1</div>');
				else
					ts.append('<div class="pageNum pageNumClick">1</div>');
	
				for(var i=2;i<p.clicknumber;i++){
					if(p.pageCount<=2 || next >= p.pageCount){
						break;
					}else if(i==2 && next!=2){
						ts.append('<div id="prev" class="pageNum">...</div>');
					}else if(i==p.clicknumber-1 && p.pageNumber<p.pageCount-middle){
						ts.append('<div id="next" class="pageNum">...</div>');
					}else{
						if(p.pageNumber!=next)
							ts.append('<div class="pageNum">'+next+'</div>');
						else
							ts.append('<div class="pageNum pageNumClick">'+next+'</div>')
					}
					next++;
				}
			}
			if(p.pageNumber!=p.pageCount)
				ts.append('<div class="pageNum">'+p.pageCount+'</div>');
			else
				ts.append('<div class="pageNum pageNumClick">'+p.pageCount+'</div>');
		}
		
		ts.append('<div class="pageNext"></div>');
		
		if(p.align == undefined || p.align=="right" || p.align=="left"){
			ts.append('<label class="base2_label2" style="margin:5px;">第</label><input id="go_page" class="Numberinput" style="margin:5px;" type="text"><label style="margin:5px;" class="base2_label2 ml5">页</label><div class="img_go"></div>');
			ts.children().css("float","left");
		}else{
			ts.append('<label class="base2_label2" style="margin:5px;">第</label><input id="go_page" class="Numberinput" style="margin:5px;" type="text"><label class="base2_label2" style="margin:5px;">页</label><div class="img_go"></div>');
		}
		
		ts.after('<div style="clear:both;"></div>');
		
		var onclick = function(){
			if(p.clickPageCallBack == undefined || 
				typeof(p.clickPageCallBack)!="function")
				return;
				
			if($(this).hasClass("pagePrev")){
				if(p.pageNumber>1)
					p.clickPageCallBack(--p.pageNumber,p.data);
			}else if($(this).hasClass("pageNext")){
				if(p.pageNumber<p.pageCount)
					p.clickPageCallBack(++p.pageNumber,p.data);
			}else if(this.id=='prev'){
				p.clickPageCallBack($(this).next().html()-1,p.data);
			}else if(this.id=="next"){
				p.clickPageCallBack(parseInt($(this).prev().html())+1,p.data);
			}else if($(this).hasClass("img_go")){
				var n = ts.find("#go_page").val();
				if(n>p.pageCount || n<=0 || isNaN(Number(n))){
					alert("输入超出分页范围!");
					ts.find("#go_page").val("");
				}else if(n!='')
					p.clickPageCallBack(n,p.data);
			}else{
				p.clickPageCallBack($(this).html(),p.data);
			}
		};
		
		ts.find('.pageNum').bind("click",onclick);
		ts.find('.pagePrev').bind("click",onclick);
		ts.find('.pageNext').bind("click",onclick);
		ts.find('.img_go').bind("click",onclick);
		ts.find('#go_page').bind('keypress', function () {
			 return (event.keyCode >= 48 && event.keyCode <= 57 || event.keyCode == 8);
        });
	};
})(jQuery)