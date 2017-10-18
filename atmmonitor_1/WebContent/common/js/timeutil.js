function TimeUtil() {}
TimeUtil.formatDate8ToDateString = function(date8)
{
    var dateString = "";
    if(date8 != undefined && date8.length == 8)
    {
        var year = 0;
        var month = 0;
        var day = 0;
        year = parseInt(date8.substr(0, 4), 10);
        month = parseInt(date8.substr(4, 2), 10);
        day = parseInt(date8.substr(6, 2), 10);
        dateString = year + "-" + month + "-" + day;
    }

    return dateString;
}
TimeUtil.formatTimeToDateString = function(time10)
{
    var dateString = "";
    if(time10 != undefined && time10.length == 10)
    {
        var time = new Date(parseInt(time10) * 1000);
        var year = time.getFullYear();
        var month = time.getMonth() + 1;
        var day = time.getDate();
        dateString = year+"-"+(month<10?"0"+month:month+"")+"-"+(day<10?"0"+day:day+"");
    }

    return dateString;
}
TimeUtil.formatTimeToTimeString = function(time10)
{
    var timeString = "";
    if(time10 != undefined && time10.length == 10)
    {
        var time = new Date(parseInt(time10) * 1000);
        var year = time.getFullYear();
        var month = time.getMonth() + 1;
        var day = time.getDate();
        var hour = time.getHours();
        var minute = time.getMinutes();
        var second = time.getSeconds();
        timeString = year+"-"+(month<10?"0"+month:month+"")+"-"+(day<10?"0"+day:day+"")+" "+(hour<10?"0"+hour:hour+"")+":"+(minute<10?"0"+minute:minute+"")+":"+(second<10?"0"+second:second+"");
    }
    return timeString;
}
TimeUtil.formatTimeToTimeFormat = function(time10, format)
{
    var time = new Date(parseInt(time10) * 1000);
    var values =
    {
        "M+": time.getMonth() + 1, //月份
        "d+": time.getDate(), //日
        "h+": time.getHours(), //小时
        "m+": time.getMinutes(), //分
        "s+": time.getSeconds() //秒
    };
    if(/(y+)/.test(format))
    {
        format = format.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for(var i in values)
    {
        if(new RegExp("(" + i + ")").test(format))
        {
            format = format.replace(RegExp.$1, (RegExp.$1.length == 1) ? (values[i]) : (("00" + values[i]).substr(("" + values[i]).length)));
        }
    }
    return format;
}
TimeUtil.formatTime14ToTimeString = function(time14)  //yyyyMMddHHmmss
{
    var timeString = "";
    if(time14 != undefined && time14.length == 14)
    {
        var year = 0;
        var month = 0;
        var day = 0;
        var hour =0;
        var minute =0;
        var second =0;
        year = time14.substr(0, 4);
        month = time14.substr(4, 2);
        day = time14.substr(6, 2);
        hour = time14.substr(8, 2);
        minute =time14.substr(10, 2);
        second =time14.substr(12, 2);
        timeString = year + "-" + month + "-" + day+" "+hour+":"+minute+":"+second;
    }
    return timeString;
}



//时间格式化为字符串
TimeUtil.Format = function (time,fmt) { //author: meizz 
    var o = {
        "M+": time.getMonth() + 1, //月份 
        "d+": time.getDate(), //日 
        "h+": time.getHours(), //小时 
        "m+": time.getMinutes(), //分 
        "s+": time.getSeconds(), //秒 
        "q+": Math.floor((time.getMonth() + 3) / 3), //季度 
        "S": time.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


TimeUtil.formatMinuteToString = function(minutes){
	  return (Math.floor(minutes/60) + "小时" + (minutes%60) + "分" );
	}

TimeUtil.formatDateToString = function(date)
{
    var dateString = "";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        dateString = year+(month<10?"0"+month:month+"")+(day<10?"0"+day:day+"");

    return dateString;
}
	//