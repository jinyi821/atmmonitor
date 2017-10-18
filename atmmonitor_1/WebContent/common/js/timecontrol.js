document.write('<script type="text/javascript" src="'+$ctx+'/common/js/datepicker/wdatepicker.js"></script>');
//document.write('<script type="text/javascript" src="'+$ctx+'/common/js/datepicker/wquarterpicker.js"></script>');

/**
 * timid 时间输入框ID
 * showtimtyp {Hour:true,Day:true,Month:true,Quarter:true}
 * tim 初始化时间值
 * tim_typ 初始化时间值的类型
 */
timecontrol={
	init:function(timid, showtimtyp,tim,tim_typ){
		showtimtyp = $.extend(true, {Hour:true,Day:true,Week:true,Month:true,Quarter:true}, showtimtyp);
		
			    var actQuery = function () {
				var id = this.id;
				var other = $(this).siblings('input');

				var tregs = { startDate: '%y-%M-{%d-1}', dateFmt: 'yyyy年MM月dd日', readOnly: true, isShowClear: false,
					firstDayOfWeek: 1, isShowToday: false, maxDate: '%y-%M-{%d-1}'
				};
				
				var timTyp =  $(this).prev().val();
				switch(timTyp){
					case "Hour":
						tregs.maxDate='%y-%M-%d %{H-1)';
						tregs.startDate='%y-%M-%d %{H-1)';
						tregs.dateFmt='yyyy年MM月dd日HH时';
					break;
					case "Day":						
						tregs.maxDate='%y-%M-{%d-1}';
						tregs.startDate='%y-%M-{%d-1}';
						tregs.dateFmt='yyyy年MM月dd日';
						break;
					case "Month":
						tregs.dateFmt='yyyy年MM月';
						tregs.maxDate='%y-{%M-1}-01';
						tregs.startDate='%y-{%M-1}-01';
						break;
				}
				
				return WdatePicker(tregs);
			};
			
			var timechange = function () {
				if (this.realValue && this.realValue != $(this).attr("hidValue")) {
					var val = this.realValue;
					var ttype = $(this).prev().val();
					if(ttype=='Hour')
						val = val.split(':')[0];
					else if(ttype=="Week"){
						var c_t = timecontrol.timByTypeConvert(ttype,val);
						val = c_t.value;
						$(this).val(c_t.text);
					}
						
					$(this).attr('hidValue',val);
				}
			};
			
			var timequarterchange = function(tim,showtim){
					$(this).prev().attr('hidValue',tim).val(showtim);
			};
			
			var timtypechange = function(){
				var timObj = {};
				var timtype = $(this).val();
				var timvalue = $(this).next().attr('hidValue');
				
				$(this).siblings('input[id="_act_quarter"]').addClass('hide')
							.siblings(".date_timeinp").removeClass('hide');
				
				switch(timtype){
					case "Hour":
					case "Day":
					case "Week":
					case "Month":
						timObj = timecontrol.timByTypeConvert(timtype,timvalue);
						break;
					case "Quarter":
						timObj = timecontrol.timByTypeConvert(timtype,timvalue);
						$(this).siblings('input[id="_act_quarter"]').val(timObj.text).removeClass('hide')
							.siblings(".date_timeinp").addClass('hide');
						break;
				}
				$(this).next().val(timObj.text).attr('hidValue',timObj.value);
			}
			
			var d = new Date();
			var day = d.getDate();
			d.setDate(day-1);
			
			var select_typ = $("<select class='fl radius border_ccc' style='width:60px'></select>");
			$("#"+timid).before(select_typ);
			
			if(showtimtyp.Hour)
				select_typ.append("<option value='Hour'>小时</option>");
			if(showtimtyp.Day)
				select_typ.append("<option value='Day'>天</option>");
			if(showtimtyp.Week)
				select_typ.append("<option value='Week'>周</option>");
			if(showtimtyp.Month)
				select_typ.append("<option value='Month'>月</option>");
			if(showtimtyp.Quarter)
				select_typ.append("<option value='Quarter'>季</option>");
			
			var init_timtyp = $("#"+timid).prev().val();
			
			if($("#"+timid).prev().find('option[value="'+tim_typ+'"]').length>0){
				init_timtyp = tim_typ;
				$("#"+timid).prev().val(tim_typ);
			}
			
			var init_tim = timecontrol.timByTypeConvert(init_timtyp,d.pattern('yyyy-MM-dd HH'));
			if(tim!= undefined && tim!= '') init_tim = timecontrol.timByTypeConvert(init_timtyp,tim);
			
			$("#"+timid).bind("focus", actQuery)
				.bind("focus", timechange)
				.val(init_tim.text)
				.attr('hidValue',init_tim.value)
				.prev().bind('change',timtypechange); 
			
			var fl = "";
			var ml4 = "";
			if($("#"+timid)[0].style.float = 'left'){
				fl = "fl";
				ml4 = 'style="margin-left:4px"';
			}
			
			$("#"+timid).after("<input type='date_timeinp text' class='hide text date_timeinp "+fl+"' "+ml4+" id='_act_quarter'/>")
				.next().bind("focus",function(){WquarterPicker({callback:timequarterchange})});
				
			if(init_timtyp == "Quarter"){
				$("#"+timid).addClass('hide').siblings('.date_timeinp').removeClass('hide').val(init_tim.text);
			}
		},
		
		timByTypeConvert: function(timtype,tim){
			var timshow = undefined;
			var day_tim = tim.split(' ');
			var arryvalue = day_tim[0].split('-');
			
			var c_d = new Date();
			var convert_d = new Date();
			convert_d.setDate(arryvalue[2]);
			convert_d.setYear(arryvalue[0]);
			convert_d.setMonth(arryvalue[1] - 1);
			
			switch(timtype){
				case "Hour":
					timshow = (arryvalue[0]+'年'+arryvalue[1]+'月'+arryvalue[2]+'日') + (day_tim.length==2?day_tim[1]:"00")+"时";
					break;
				case "Day":
					timshow = arryvalue[0]+'年'+arryvalue[1]+'月'+arryvalue[2]+'日';
					break;
				case "Week":
					convert_d.setDate(convert_d.getDate() - (convert_d.getDay() + 6) % 7);
	                month = convert_d.getMonth() + 1;
	                if (month < 10) {
	                    month = "0" + String(month);
	                }
	                var day = convert_d.getDate();
	                if (day < 10) {
	                    day = "0" + String(day);
	                }
	                tim = convert_d.getFullYear() + "-" + month + "-" + day;
	                timshow = convert_d.getFullYear() + "年" + month + "月" + day + "日";
					break;
				case "Month":
					if(c_d.pattern('yyyyMM') <= convert_d.pattern('yyyyMM')){
						convert_d.setMonth(arryvalue[1]-2);
					}
					timshow = convert_d.getFullYear()+'年'+(convert_d.getMonth()+1)+'月';
					tim = convert_d.getFullYear()+'-'+convert_d.pattern("MM")+'-01';
					break;
				case "Quarter":
					var quarter = '一';
					tim = arryvalue[0]+'-01-01';
					var month = c_d.getMonth()+1;
					month = month - (month + 2) % 3;
					if(convert_d.getFullYear() >= c_d.getFullYear() && 
					convert_d.getMonth()+1 >= month){
						convert_d.setMonth(arryvalue[1]-4);
					}
					
					if(convert_d.getMonth()>2 && convert_d.getMonth()<=5){
						quarter = '二';
						tim = convert_d.getFullYear()+'-04-01';
					}else if(convert_d.getMonth()>5 && convert_d.getMonth()<=8){
						quarter = '三';
						tim = convert_d.getFullYear()+'-07-01';
					}else if(convert_d.getMonth()>8 && convert_d.getMonth()<=11){
						quarter = '四';
						tim = convert_d.getFullYear()+'-10-01';
					}
					timshow = convert_d.getFullYear()+'年第'+quarter+'季度';
					break;
			}
			return {value:tim,text:timshow};
		}			
}

function  addpagemenu(user,menuId)
{
	if($("#pagemneu").length>0)
		{
		  $("#pagemneu").remove();
		}
     $("#content").before("<div class ='mt10 fl' id ='pagemneu'></div>");
     var herf="";
     var atext="";
     
     if(user=="admin")
  	{
      herf =$ctx+"/statistics/dataquality/grouptask.action?menuId="+menuId;
      atext="<div><a href ="+herf+">任务分组</a></div>";
      $("#pagemneu").append(atext);
   }
     
     herf =$ctx+"/statistics/dataquality/overall.action?menuId="+menuId;
     atext="<div><a href ="+herf+">系统整体数据质量日报</a></div>";
	 $("#pagemneu").append(atext);
	 
	 herf =$ctx+"/statistics/dataquality/focusPerfor.action?menuId="+menuId+"&groupid=1";
	 atext="<div><a href ="+herf+">集中性能数据质量日报</a></div>";
	 $("#pagemneu").append(atext);
	 
	 herf =$ctx+"/statistics/dataquality/focusPerfor.action?menuId="+menuId+"&groupid=2";
	 atext="<div><a href ="+herf+">集中网优数据质量日报</a></div>";
	 $("#pagemneu").append(atext);
 }