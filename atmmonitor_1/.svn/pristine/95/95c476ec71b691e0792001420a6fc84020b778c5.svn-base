/**
 * 
 */


function ajax(url,args,successback,completeback,datatype){
	$.ajax({
		url: url,
		type: "post",
		cache: false,
		async: true,
		data: args,
		dataType: datatype==undefined?"json":datatype,
		cache:false,
		success: function (json) {
			if (typeof (successback) == "function")
				successback(json);
		},
		complete: function (XHR) {
			if (typeof (completeback) == "function")
				completeback(XHR);
		},
		beforeSend: function () {
		},
		error: function (e, o) {
		}
	});
}

function closeMask(maskId, showId) {
	var maskId = maskId == null ? "" : maskId;
	var loadingid = showId == null ? maskId + '_loadingid' : showId;

	var mask = $('#' + maskId + "_newMaskDiv");
	var loading = $('#' + loadingid);

	if (loading && !showId) {
		loading.remove();
	}
	else if (loading) {
		loading.addClass('hide');
	}

	if (mask) {
		mask.remove();
	}
}


function openMask(maskId, showId, fixed, textRight) {
	if ($("#" + (maskId == null ? "" : maskId) + "_newMaskDiv").length > 0) {// 判断是否有同名的mask图层
		return;
	}
	else if ($("#_newMaskDiv").length > 0 || $("table[id='helpGuide']").length > 0) {// 判断是否有全屏的mask图层或操作指导
		return;
	}

	var objMask = $("#" + maskId);
	var loadingid = maskId + '_loadingid';
	if (!maskId) {
		objMask = $("body");
		loadingid = '_loadingid';
	}
	else {
		objMask.addClass("rela");
	}

	var w = document.documentElement.clientWidth;
	var h = document.documentElement.clientHeight;
	if (objMask[0] != undefined) {
		if (objMask[0].offsetWidth) {
			w = objMask[0].offsetWidth;
			h = objMask[0].offsetHeight;
		}
	}

	if (!maskId) {
		w = document.documentElement.clientWidth;
		h = document.documentElement.clientHeight;
	}
	
	var position = "absolute";
	
	if (fixed)
		position = "fixed";

	if (!showId) {
		var imgsrc = "http://" + document.location.host + $ctx + "/common/style/default/images/loading.gif";
		objMask.append("<div style='left:" + (w - 35) / 2 + "px;top:" + (h - 35) / 2 + "px;background:url("+$ctx+"/common/style/default/images/loading.gif) no-repeat;height:34px;width:34px;position:"+position+";z-index:2600px;' id='" + loadingid + "'></div>");
	}
	else {
		var objshow = $("#" + showId);
		var leftvalue = (w - objshow.width()) / 2;

		if (textRight)
			leftvalue = w - objshow.width();

		objshow.css("left", +leftvalue).css("top", (h - objshow.height()) / 2).css("position", position).css("z-index", "2600").removeClass("hide");
	}


	// mask图层
	var newMask = document.createElement("div");
	newMask.id = (maskId == null ? "" : maskId) + "_newMaskDiv";
	newMask.style.position = "absolute";
	newMask.style.zIndex = "2500";
	newMask.style.width = w + "px";
	newMask.style.height = h + "px";
	newMask.style.top = "0px";
	newMask.style.left = "0px";
	//newMask.style.background='transparent';
	newMask.style.background = '#000'; //"#000";
	newMask.style.filter = "alpha(opacity=5)";
	newMask.style.opacity = "0.05";
	objMask.append(newMask);

	if (fixed == true) {
		$(newMask).css("position", "fixed");
	}
}

function showNoneDataMsg(divid) {
	var div = $("#" + divid);
	div.empty();
	div.append("<div style='line-height:" + div.height() + "px;width:100%;height:100%;text-align:center'><span style='font-size:30px' class='c999'>没有数据</span></div>");
}

//正则替换
String.prototype.RegexpString = function (oldstrinng, newstring) {
    var reg = new RegExp("\\" + oldstrinng, "g");
    return this.replace(reg, newstring);
}


String.prototype.Trim = function () {	
	if( this==undefined || this==null ||this==""){
		return "";
	}
    return this.replace(/(^\s*)|(\s*$)/g, "");
}


Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份         
        "d+": this.getDate(), //日         
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时         
        "H+": this.getHours(), //小时         
        "m+": this.getMinutes(), //分         
        "s+": this.getSeconds(), //秒         
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度         
        "S": this.getMilliseconds() //毫秒         
    };
    var week = {
        "0": "\u65e5",
        "1": "\u4e00",
        "2": "\u4e8c",
        "3": "\u4e09",
        "4": "\u56db",
        "5": "\u4e94",
        "6": "\u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

//比冒泡法好的排序方法，性能循环次数减少一半
Array.prototype.sorting = function (filed, desc) {
	var loopCount = 0;
	var data = this;
	var end_i = data.length - 1;
	var start_i = 0;

	if (data.length == 0) return;

	do {
		var t1 = t2 = start_i;
		for (var i = start_i + 1; i <= end_i; i++) {
			if (filed != undefined) {
				if (!desc) {
					if (data[t1][filed] > data[i][filed]) t1 = i;
					if (data[t2][filed] < data[i][filed]) t2 = i;
				}
				else {
					if (data[t1][filed] < data[i][filed]) t1 = i;
					if (data[t2][filed] > data[i][filed]) t2 = i;
				}
			} else {
				if (!desc) {
					if (data[t1] > data[i]) t1 = i;
					if (data[t2] < data[i]) t2 = i;
				}
				else {
					if (data[t1] < data[i]) t1 = i;
					if (data[t2] > data[i]) t2 = i;
				}
			}
		}

		if (t2 == start_i)  t2 = t1;

		var p = data[start_i];
		data[start_i] = data[t1];
		data[t1] = p;

		p = data[end_i];
		data[end_i] = data[t2];
		data[t2] = p;
	} while (++start_i < --end_i);

}

newGuid = function () {

    var g = "";

    var i = 32;

    while (i--) {

        g += Math.floor(Math.random() * 16.0).toString(16);

    }

    return g;
}

function expCsv(param, btnid, url) {
    var d = new Date();
    var host = location.host;
    var expid = 'key_' + d.getHours() + d.getMinutes() + d.getSeconds() + d.getMilliseconds() + "_" + String(Math.random() * 1000000000);
    var form = $("<form id='form111' action='" + url + "'  method='post'></form>");
    var expCSV = $("<input name='expid' type='text'></input>");
    expCSV[0].value = expid;

    form.append(expCSV);
    for (var i = 0; i < param.length; i++) {
        form.append(param[i]);
    }
    $("body").append(form);
    form.submit();
    form.remove();

    var btnExp = $("#"+btnid);
    var expmsg = btnExp.siblings("div[id='msg']");
    btnExp.attr("disabled", "disabled");
    //var imgsrc = webroot + "/Resources/Default/img/imgs/loading.gif";
  //  expmsg.html("<img style='height:20px;width:20px;vertical-align:-6px;' class='ml mr' src='" + imgsrc + "' />正在导出，请等待...");
   /* var ExpCSVState = function () {
        ajax(webroot+"/getStatus", {expid: expid }, function (obj) {
            if (obj != "complete") {
                setTimeout(ExpCSVState, 1000);
            }
            else {
                expmsg.html("");
                btnExp.removeAttr("disabled");
            }
        }, null, 'text');
    }*/

   // ExpCSVState();

}
//长字符串简化
function substrTitle(title,num){
	 var reStr='';
	 if(title.length>num){
		 reStr=title.substr(0,num)+"...";
	 }else{
		 reStr=title;
	 }		
	 	return reStr;
	 }

/**
 * 验证正整数
 * @param obj
 */
function checkInputInteger(obj,length){
	$("#"+obj).keypress(function(event) { 
         var keyCode = event.which;   
	         var tmpV = $(this).val();
	         if(length>0 && tmpV.length>=length){
	        	 return false;
	         }
	        if(tmpV=="" && keyCode > 48 && keyCode <=57){
	        	return true;
	        }else if( tmpV==0){
	        	return false;
	        }else if(keyCode >= 48 && keyCode <=57){
	         	return true;
	         }else if((keyCode >= 48 && keyCode <=57)&& (tmpV==""||/^(([1-9](\d)))$/.test(tmpV))){//当整数时，可输入数字
	        		return true;
	        	}else if(((keyCode >=48 && keyCode <=57))&& /(\.|(\.\d)){1}$/.test(tmpV)){//当已经有小数点或者小数点1位时，可以输入1位数字
	            	return true;  
	        	}else if(keyCode == 8||keyCode == 37 ||keyCode == 39){//退格键，del，左右键
	        		return true;
	        	} else {
	        		return false;
	        	}
	     }).focus(function() {  
	         this.style.imeMode='disabled';  
	     });
}
