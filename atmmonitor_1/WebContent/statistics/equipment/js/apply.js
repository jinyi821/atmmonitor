
$(function(){
	$.ajax({
		  type: 'POST',
		  url: $ctx+"/equipmentstatis/initDeptEquipmentResultChart.action",
		  success: function(data,status){
			    initDeptEquipmentResultChart(data);
			    initApplyResultChart(data);
			  }
           ,
		  dataType: 'json'
		});
	
	


	$(".excelIcon").mouseover(function(){
		$(this).next(".excelTip").css("display","");
	});
	$(".excelIcon").mouseout(function(){
		$(this).next(".excelTip").css("display","none");
	});	
});

function initDeptEquipmentResultChart(data){

var dom = document.getElementById("container");
var myChart = echarts.init(dom);
myChart.clear();
myChart.showLoading({
    text: '正在努力的读取数据中...',    
});

myChart.hideLoading();
option = null;

option = {
	    title : {
	        text: '',
	        
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient : 'vertical',
	        x : 'left',
	        data:data["deptList"]
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {
	                show: true, 
	                type: ['pie', 'funnel'],
	                option: {
	                    funnel: {
	                        x: '25%',
	                        width: '50%',
	                        funnelAlign: 'left',
	                        max: 1548
	                    }
	                }
	            },
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    series : [
	        {
	            name:'部门设备比例',
	            type:'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:data["deptEquipValueList"]
	        }
	    ]
	};
                

	if (option && typeof option === "object") {
		//alert(1);
	    var startTime = +new Date();
	    myChart.setOption(option);
	    var endTime = +new Date();
	    var updateTime = endTime - startTime;
	    //console.log("Time used:", updateTime);
	}
}

//应用开发发布统计
function initApplyResultChart(data){
	 //console.log("monthList:", monthList);
	 //console.log("publishNumList:", publishNumList1);
var dom = document.getElementById("container1");
var myChart = echarts.init(dom);
myChart.clear();
myChart.showLoading({
   text: '正在努力的读取数据中...',    
});
//equipChangeValueList
myChart.hideLoading();
option = null;
 

option = {
		color:['#B6A2DE','#FFc658'],
	   
	    tooltip: {
	        trigger: 'axis',
	        axisPointer:{
	        	type:'line',
	        	lineStyle:{
	        		color:'#9DFCFF',
	        		width:2,
	        		shadowColor:'#F8FDFF',
	        		shadowBlur:0,
	        		shadowOffsetY:0
	        	},
	        	crossStyle:{
	        		color:'#EBCAD4',
	        		type:'solid'
	        	},
	        	shadowStyle:{
	        		shadowOffsetX:0,
	        		shadowOffsetY:0,
	        		color:'#F8FDFF',
//	        		shadowColor:'##F8FDFF',
	        		shadowBlur:1,
	        		opacity:0.8
	        	}
	        },
	        formatter: function (params,ticket,callback) {
	            //console.log(params)
	            var res =  data["dateList"][params[0].dataIndex]  ;
	            for (var i = 0, l = params.length; i < l; i++) {
	                res += '<br/>' + params[i].seriesName + ' : ' + params[i].value;
	            }
	            setTimeout(function (){
	                // 仅为了模拟异步回调
	                callback(ticket, res);
	            }, 1)
	            return 'loading';
	        }
	    },
	    legend: {
	        data:['设备故障数'],
	    	right:'6%',
	    	top:'9%'
	    	
	    },
	    grid: {
	    	show:false,
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true,
	        height:260
	       
	    },
	    toolbox: {
//	        feature: {
//	            saveAsImage: {}
//	        }
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: data["dateList"],
	        axisLine:{
	        	lineStyle:{
	        		color:'#dddddd'
	        	}
	        },
	        axisTick:{
	        	show:false
	        },
	        splitLine:{
	        	lineStyle:{
	        		color:'#F6F6F6'
	        	}
	        },
	        axisLabel:{
	           formatter:'{value}',
	           textStyle:{
	        	   fontSize:'14'
	           }
	           
	        }
	        	
	    },
	    yAxis: {
	        type: 'value',
	        axisLine:{
	        	lineStyle:{
	        		color:'#dddddd',
	        		width:1
	        	}
	        },
	        scale:true,
	        splitNumber:4,
	        axisTick:{
	        	show:false
	        },
	        splitLine:{
	        	lineStyle:{
	        		color:'#F6F6F6'
	        	}
	        },
	        axisLabel:{
	            
	            textStyle:{
	         	   fontSize:'14'
	            }
	            
	         }
	    },
	    series: [
	        {
	            name:'设备故障数',
	            type:'line',
	           /* stack: '总量',*/
	            data: data["equipChangeList"],
	            symbol:'emptyCircle',
	            symbolSize:7
	        }
	       
	    ]
	};
  
  


	if (option && typeof option === "object") {
		//alert(1);
	    var startTime = +new Date();
	    myChart.setOption(option);
	    var endTime = +new Date();
	    var updateTime = endTime - startTime;
	    console.log("Time used:", updateTime);
	}
}

function exportRankData(){
	var url=$ctx+"/statistics/apply/exportRankData.action";
	var form=$('<form/>',{action:url,method:"post",style:"display:none"}).appendTo("body");
	form.submit();
	
}

function exportApplyRankData(){
	var url=$ctx+"/statistics/apply/exportApplyRankData.action";
	var form=$('<form/>',{action:url,method:"post",style:"display:none"}).appendTo("body");
	form.submit();
	
}

function getDetail(book_id){
	var url=$ctx+"/tableau/digenv/digenvview.action?workbookid="+book_id;
	window.open(url);
}

function getApplyDetail(book_id){
	var httpstr = book_id.substr(0, 4);
	if(httpstr == "http"){
		 window.open(book_id);	
	} else {
		 window.open("http://"+book_id);	
	}	
}