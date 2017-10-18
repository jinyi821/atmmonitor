function ListTable(tableID, urlStr, size, hiddenParameters,preFunc, dataFunc,afterFunc,iframeFunc)
{
	this.tableID = tableID;
	this.url = urlStr;
	this.pageSize = size;
	this.hiddens = hiddenParameters;
    this.cells = [];
    if(this.cells == null) this.cells = [];	
    this.preCommitFunc =null;
    if(preFunc != undefined && preFunc != null) this.preCommitFunc = preFunc;
    this.afterCommitFunc =null;
    if(afterFunc != undefined && afterFunc != null) this.afterCommitFunc = afterFunc;
    this.uprateIframeFunc =null;
    if(iframeFunc != undefined && iframeFunc != null) this.uprateIframeFunc = iframeFunc;
    this.dataFunc = null;
    if(dataFunc != undefined && dataFunc != null) this.dataFunc = dataFunc;
    this.postFunc = null;
    this.pageNo=1;
    this.pageCount=1;
    this.init();
}

ListTable.prototype =
{
	    init : function()
	    {
	        //读取标题行下的第一行数据tr，获取行列模板
	        var templateTDs = $("#" + this.tableID + " tr:last td");
	        for(var i = 0; i < templateTDs.length; i++)
	        {
	            this.cells.push(templateTDs[i].outerHTML);
	        }
	        $("#" + this.tableID + " tr:gt(0)").remove();

	        this.query();
	    },
	    //点击搜索按钮时    页码赋值1
	    submit: function(){
	    	this.pageNo=1;
	    	this.query();
	    },
	    //提交查询
	    query : function()
	    {
	        //此处的提交为json格式，返回也为json格式
	    	var paraStr = {};
	        var extParas = [];
	        extParas.push(["pageIndex", 1]);
	        extParas.push(["pageSize", this.pageSize]);	    		
	         //拼接隐藏参数
	         for(var i = 0; i < this.hiddens.length; i++)
	         {
	              extParas.push(this.hiddens[i]);
	         }	    	 	
	         for(var i = 0; i < extParas.length; i++)
	         {
	             eval("paraStr." + extParas[i][0] + " = extParas[i][1]");
	         }	         
	         if(this.preCommitFunc != null)
	         {
	             this.preCommitFunc(paraStr);
	         }	         
	         paraStr.pageIndex = parseInt(this.pageNo);
	        var tableObj = this;
	        $.post(this.url, paraStr, function(data)
	        {
	            return function(table)
	            {
	            	debugger;
	                var json = JSON.parse(data);
	                table.refreshTable(json);
	                if( tableObj.afterCommitFunc !=null){
	                	tableObj.afterCommitFunc(json,tableObj);
	                }
	                if( tableObj.uprateIframeFunc !=null){
	                	tableObj.uprateIframeFunc();
	                }
	            }(tableObj);
	        });
	    },
	    refreshTable : function(data)
	    {
	        //清空表格
	        //$("#" + this.tableID + " tr:gt(0)").remove();
	        $("#" + this.tableID + " tbody").html("");
	        //填充数据
	        var rows = data.pageData;
	        for(var i = 0; i < rows.length; i++)
	        {
	            var row = rows[i];
	            if(this.dataFunc != null)
	            {
	                this.dataFunc(row);
	            }
	            var cell = "<tr>";
	            for(var j = 0; j < this.cells.length; j++)
	            {
	                var content = this.cells[j];
	                //替换关键字
	                cell += ListViewUtil.fileTemplate(content, row);
	            }
	            cell += "</tr>";
	            if(i==0)
	            	{
	            		$("#" + this.tableID + " tbody").append(cell);
	            	}
	            else
	            	{
	            		$("#" + this.tableID + " tr:last").after(cell);
	            	}
	            if(this.postFunc != null)
	            {
	                this.postFunc($("#" + this.tableID + "  tr:last"), row);
	            }
	        }
	    },
	    gotoPage:function(page){
	    	page = parseInt(page);
	    	if(page<1){
	    		return;
	    	}else 	if(page>this.pageCount){
	    		return;
	    	}else if(this.pageNo == page){
	    		return;
	    	}
	    	
	    	this.pageNo = page;
	    	this.query();
	    }
	    
};

function tableBoot(data,table){
	var countPage = data.pageCount;
	table.pageCount = countPage;
	var currentPage = parseInt(table.pageNo);
	$("#"+table.tableID+"_tableBoot").remove();
	var tableBoot = $("<div class=\"base3\" id="+table.tableID+"_tableBoot></div>");
	tableBoot.append($("<label class=\"base2_label3\" style=\"margin-left:5px;\">总共"+data.dataCount+"条记录     </label>"));
	if(countPage>1){
		var last = $("<div class=\"pagePrev\" ></div>");
		last.click(function(){
			table.gotoPage(currentPage-1);
		});
		tableBoot.append(last);
	}
	
	if(countPage<11){
		for(var i=1;i<=countPage;i++){
			appenTableBoot(currentPage, i,countPage,table,tableBoot);
		}
	}else{
		if(currentPage<3){
			for(var i=1;i<=currentPage+2;i++){
				appenTableBoot(currentPage, i,countPage,table,tableBoot);
			}
			tableBoot.append($("<label>...</label>"));
			appenTableBoot(currentPage, countPage-1,countPage,table,tableBoot);
			appenTableBoot(currentPage, countPage,countPage,table,tableBoot);
			
		}else if(currentPage<countPage-3&&currentPage-1<=3){
			for(var i=1;i<=currentPage+2;i++){
				appenTableBoot(currentPage, i,countPage,table,tableBoot);
			}
			tableBoot.append($("<label>...</label>"));
			appenTableBoot(currentPage, countPage-1,countPage,table,tableBoot);
			appenTableBoot(currentPage, countPage,countPage,table,tableBoot);
		}else if(currentPage==countPage-3){
			appenTableBoot(currentPage, 1,countPage,table,tableBoot);
			tableBoot.append($("<label>...</label>"));
			for(var i=currentPage-2;i<=currentPage+3;i++){
				appenTableBoot(currentPage, i,countPage,table,tableBoot);
			}
//			appenTableBoot(currentPage, countPage, countPage,table,tableBoot);
		}else if(currentPage<countPage-3 && currentPage-1>3){
			appenTableBoot(currentPage, 1,countPage,table,tableBoot);
			tableBoot.append($("<label>...</label>"));
			for(var i=currentPage-2;i<=currentPage+2;i++){
				appenTableBoot(currentPage, i,countPage,table,tableBoot);
			}
			if(currentPage!=countPage-4)
			tableBoot.append($("<label>...</label>"));
			appenTableBoot(currentPage, countPage-1,countPage,table,tableBoot);
			appenTableBoot(currentPage, countPage,countPage,table,tableBoot);
		}else{
			appenTableBoot(currentPage, 1,countPage,table,tableBoot);
			tableBoot.append($("<label>...</label>"));
			for(i=currentPage-2;i<=countPage;i++){
				appenTableBoot(currentPage, i,countPage,table,tableBoot);
			}
		}
	}
	if(countPage>1){
		var nextpage= parseInt(currentPage)+1;
		var next = $("<div class=\"pageNext\"></div>");
		next.click(function(){
			table.gotoPage(nextpage);
		});
	
		tableBoot.append(next);
		//tableBoot.append($("<div class=\"pageNext\"  onclick=\"gotoPage("+nextpage+","+countPage+")\"></div>"));
		tableBoot.append($("<label class=\"base2_label2\" style=\"margin-left:5px;\">第</label>"));
		tableBoot.append($("<input type=\"text\" class=\"Numberinput\" style=\"margin-left:5px;\" id=\""+table.tableID+"_inputPageNumber\">"));
		tableBoot.append($("<label class=\"base2_label2\" style=\"margin-left:5px;\">页</label>"));
		var button = $("<div class=\"img_go\" ></div>");
		button.click(function(){
			nextpage =  $("#"+table.tableID+"_inputPageNumber").val();
			table.gotoPage(nextpage);
		});
		tableBoot.append(button);
	}
	$("#" + table.tableID).after(tableBoot);
//	var isfame = $("#isframe").val();
//	if(isfame=="0"){
////		window.parent.iFrameHeight("rightFrame2");
//		parentiFrameHeight();
//	}
}
function  appenTableBoot(currentPage,number,count,table,tableBoot){
	var className = "pageNum";
	if(number>=100){
		className = "pageNumBig";
	}
	if(number == currentPage){   //当前页
		className = className+" pageNumClick";
		if(number>=100){
	     className = className+" pageNumBigClick";			
		}
	}
	var divNum = $("<div class=\""+className+"\" style=\"cursor:pointer;margin-left:5px; \">"+number+"</div>");
	divNum.click(function(){
		table.gotoPage(number);
	});
	tableBoot.append(divNum);
}

function ListViewUtil() {}
ListViewUtil.fileTemplate = function(content, row)
{
    //替换关键字
    while(content.indexOf("@@{") > -1)
    {
        var srcStr = content.substring(content.indexOf("@@{") + 3, content.indexOf("}"));
//        if(srcStr.indexOf("@#{") > -1){//内容中还存在@#{
//        	srcStr = content.substring(content.indexOf(srcStr)+1, content.indexOf("}"));
//        }
        
        var keyStr = srcStr;
        var key = keyStr;
        if(keyStr.indexOf("[") > -1)
        {
            key = keyStr.substring(0, keyStr.indexOf("["));
            keyStr = keyStr.substring(keyStr.indexOf("[") + 1, keyStr.indexOf("]"));
        }
        else
        {
            keyStr = "";
        }
        var value = eval("row." + key);
        if(!value) value = "";

        if(keyStr != "" && value != "")
        {
            if(keyStr == "DATE")
            {
                if(value.length == 10)
                {
                    value = TimeUtil.formatTimeToDateString(value);
                }
                else
                {
                    value = TimeUtil.formatDate8ToDateString(value);
                }
            }
            else if(keyStr == "TIME")
            {
            	if(value.length == 14){
            		value=TimeUtil.formatTime14ToTimeString(value);
            	}else{
            		 value = TimeUtil.formatTimeToTimeString(value);	
            	}
            }
            else if(keyStr == "MINUTE")
            {
                value = TimeUtil.formatTimeToTimeFormat(value, "hh:mm");
            }
            else if(keyStr.indexOf("ENUM") > -1)
            {
                var params = keyStr.substr(5).split(";");
                for(var k = 0; k < params.length; k++)
                {
                    if(params[k].indexOf("=") > 0)
                    {
                        var enumKey = params[k].split("=")[0];
                        //需要修改截取
                        var enumVal = params[k].substring(params[k].indexOf(enumKey)+2);
                        //var enumVal = params[k].split("=")[1];
                        if(value == enumKey)
                        {
                            value = enumVal;
                            break;
                        }
                    }
                }
            }
        }
        content = content.replace("@@{" + srcStr + "}", value);
    }
    return content;
}