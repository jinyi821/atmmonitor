function ListTable(tableID, urlStr, size, hiddenParameters,preFunc, dataFunc)
{
	this.tableID = tableID;
	 this.url = urlStr;
	this.pageSize = size;
	 this.hiddens = hiddenParameters;
    this.cells = [];
    if(this.cells == null) this.cells = [];	
    this.preCommitFunc =null;
    if(preFunc != undefined && preFunc != null) this.preCommitFunc = preFunc;
    this.dataFunc = null;
    if(dataFunc != undefined && dataFunc != null) this.dataFunc = dataFunc;
    this.postFunc = null;
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

	        this.submit();
	    },
	    //提交查询
	    submit : function()
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
	        var tableObj = this;
	        $.post(this.url, paraStr, function(data)
	        {
	            return function(table)
	            {
	                var json = JSON.parse(data);
	                table.refreshTable(json);
	            }(tableObj);
	        });
	    },
	    refreshTable : function(data)
	    {
	        //清空表格
	        $("#" + this.tableID + " tr:gt(0)").remove();
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
	            $("#" + this.tableID + " tr:last").after(cell);
	            if(this.postFunc != null)
	            {
	                this.postFunc($("#" + this.tableID + " tr:last"), row);
	            }
	        }
	    }
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
                value = TimeUtil.formatTimeToTimeString(value);
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