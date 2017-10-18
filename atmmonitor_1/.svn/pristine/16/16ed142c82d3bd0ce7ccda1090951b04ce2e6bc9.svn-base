
$(function(){
	getTableauWorkbookTop(3);
	//getTableauWorkbookRank();
	
	getAppBaseinfoTop(3);
	//getAppBaseinfoRank();
});


function getTableauWorkbookTop(num){
	var url = $ctx+"/portal/getTableauWorkbookTopNum.action"; 
	$.post(url,{"num":num},function(result){
		var books=eval(result);
		var TableauWorkbook=$("#tableauWorkbook");
		var block;
		var html;
		var tabhtml;
		var loginnames = [];
		var hasLoginname = {};
		$.each(books,function(){
			if(hasLoginname[this.loginname]== undefined){
				hasLoginname[this.loginname] = 1;
				loginnames[loginnames.length] = this.loginname;
			}
		});
		if(loginnames.length>0){
		$.post($ctx + "/digenvlist/getUserName.action", {loginnamesStr:JSON.stringify(loginnames)}, function(userJson) {
			var userData =JSON.parse(userJson);
			for (var i = 0; i < books.length; i++) {
				books[i].username=userData[books[i].loginname];
			};
			for (var int = 0; int < books.length; int++) {
				block=$('<div class="block2"></div>');
				if(int==0){
					block=$('<div class="block1"></div>');
				}
				
				var workbook_title = "";
				if(books[int].workbook_title.length>15){
					workbook_title = books[int].workbook_title.substring(0,15)+'...';
				}else{
					workbook_title = books[int].workbook_title;
				}
				
				var content="";
				if(books[int].workbook_desc.length>55){
					content=books[int].workbook_desc.substring(0,55)+'...';
				}else{
					content=books[int].workbook_desc;
				}
				var times=""+books[int].publish_date;
				var date=times.substring(0,4)+"-"+times.substring(4,6)+"-"+times.substring(6,8);
				var book_id=""+books[int].workbook_id;
				var img_url=$ctx+books[int].workbook_preview_image+"?"+new Date().getMilliseconds();
				var names=books[int].username==undefined?books[int].loginname:books[int].username;
				html='<div class="blockClick"><div class="chart1" onclick="getDetail(\''+book_id+'\')"  style="background: url('+img_url+') no-repeat;"></div><div class="blockContent"><p><label class="color2 fontSize2">'+workbook_title+'</label></p><p class="marginTop"><label class="font1 color3">概要说明：'+content+'</label></p></div></div>';
				tabhtml='<div class="blockFoot"><table class="base_table"><tr><td class="userWidth"><div class="user"></div><label class="font color" style="margin-left:3px;">'+names+'</label></td><td><div class="time"></div><label class="font color" style="margin-left:2px;">'+date+'</label></td></tr></table></div>';
				block.append(html);
				block.append(tabhtml);
				TableauWorkbook.append(block);
			};
		});
		}
		
	});
}

function getDetail(book_id){
	var url=$ctx+"/tableau/digenv/digenvview.action?workbookid="+book_id;
	window.open(url);
}

function getTableauWorkbookRank(){
	var url = $ctx+"/portal/getTableauWorkbookRankTopNum.action"; 
	$.post(url,function(result){
			var ranks = eval(result);
			var table = $("#tableauWorkbookRank");
			var tr;
			var td;
			var div;
			var value;
			var classStyle ;
			var classButton ;
			var classFontColor;
			var name;
			for(var i=0;i<ranks.length;i++){
				tr = $("<tr></tr>");
				td = $("<td></td>");
				value = ranks[i][0]- ranks[i][1];
				if(value==0){
					classStyle = "middleIcon";
				}else if(value>0){
					classStyle = "downIcon";
				}else{
					classStyle = "top";
					value = -value;
				}
				if(ranks[i].today<=3){
					classButton="numBtn";
					classFontColor="font color4";
				}else{
					classFontColor="font color";
					classButton="numBtn1";
				}
				name = ranks[i][3];
			/*	if(name.length>15){
					name = name.substring(0,15)+"...";
				}*/
				td.append($("<input type=\"button\" value=\""+(ranks[i][0])+"\" class=\""+classButton+" float-left\"/>"));
				td.append($("<label class=\"font1 color2 text-overflow float-left\" style=\"\">"+name+"</label>"));
				div = $("<div class=\"floatRight\"> </div>");
				div.append($("<label class=\""+classFontColor+" \" style=\"margin-right: 3px;\">"+value+"</label>"));
				div.append($("<div class=\""+classStyle+"\"></div>"));
				td.append(div);
				td.append($("<div class=\"ClearFloat\"></div>"));
				tr.append(td);
				table.append(tr);
			}
	});
} 

function getAppBaseinfoTop(num){
	var url = $ctx+"/portal/getAppBaseinfoTopNum.action"; 
	var image_null_url = $ctx+"/portal/images/app_null.png"; 
	$.post(url,{"num":num},function(result){
		if(result == null || result == ""){
			return false;
		}
		var apps=eval(result);
		var TableauWorkbook=$("#appbaseinfo");
		var block;
		var html;
		var tabhtml;
		//return false;
		//apps.length=2;
		if(apps.length == 3){
			for (var int = 0; int < apps.length; int++) {
				block=$('<div class="block2"></div>');
				if(int==0){
					block=$('<div class="block1"></div>');
				}
				
				var appname = "";
				if(apps[int].appname.length > 15){
					appname = apps[int].appname.substring(0,15)+'...';
				}else{
					appname = apps[int].appname;
				}
				
				
				var content="";
				if(apps[int].appdesc.length>55){
					content=apps[int].appdesc.substring(0,55)+'...';
				}else{
					content=apps[int].appdesc;
				}
				var times=""+apps[int].publishdate;
				var date=times.substring(0,4)+"-"+times.substring(4,6)+"-"+times.substring(6,8);
				var pid = apps[int].pid;
				var app_id=""+apps[int].appid;
				var app_url = apps[int].appurl;
				var appheadpic = apps[int].appheadpic;
				appheadpic = appheadpic.replace('\\','/').replace('\\','/');
				var img_url=root+appheadpic; // style="background: url('+img_url+'); background-size:250px 160px; background-repeat: no-repeat;"
				var imgsrc = root + apps[int].appheadpic;
				var names=apps[int].fullname;
				html='<div class="blockClick"><div class="chart1" onclick="openurl(\''+pid+'\',\''+app_id+'\',\''+app_url+'\')"><img src="'+imgsrc+'" style="width:250px; height:160px;"/></div><div class="blockContent"><p><label class="color2 fontSize2">'+appname+'</label></p><p class="marginTop"><label class="font1 color3">应用描述：'+content+'</label></p></div></div>';
				tabhtml='<div class="blockFoot"><table class="base_table"><tr><td class="userWidth"><div class="user"></div><label class="font color" style="margin-left:3px;">'+names+'</label></td><td><div class="time"></div><label class="font color" style="margin-left:2px;">'+date+'</label></td></tr></table></div>';
				block.append(html);
				block.append(tabhtml);
				TableauWorkbook.append(block);
			}
		} else if(apps.length < 3 && apps.length > 0){
			for (var int = 0; int < apps.length; int++) {
				block=$('<div class="block2"></div>');
				if(int==0){
					block=$('<div class="block1"></div>');
				}
				var content="";
				if(apps[int].appdesc.length>55){
					content=apps[int].appdesc.substring(0,55)+'...';
				}else{
					content=apps[int].appdesc;
				}
				var times=""+apps[int].publishdate;
				var date=times.substring(0,4)+"-"+times.substring(4,6)+"-"+times.substring(6,8);
				var pid = apps[int].pid;
				var app_id=""+apps[int].appid;
				var app_url = apps[int].appurl;
				var appheadpic = apps[int].appheadpic;
				appheadpic = appheadpic.replace('\\','/').replace('\\','/');
				var img_url=root+appheadpic; // style="background: url('+img_url+'); background-size:250px 160px; background-repeat: no-repeat;"
				var imgsrc = root + apps[int].appheadpic;
				var names=apps[int].fullname;
				html='<div class="blockClick"><div class="chart1" onclick="openurl(\''+pid+'\',\''+app_id+'\',\''+app_url+'\')"><img src="'+imgsrc+'" style="width:250px; height:160px;"/></div><div class="blockContent"><p><label class="color2 fontSize2">'+apps[int].appname+'</label></p><p class="marginTop"><label class="font1 color3">应用信息：'+content+'</label></p></div></div>';
				tabhtml='<div class="blockFoot"><table class="base_table"><tr><td class="userWidth"><div class="user"></div><label class="font color" style="margin-left:3px;">'+names+'</label></td><td><div class="time"></div><label class="font color" style="margin-left:2px;">'+date+'</label></td></tr></table></div>';
				block.append(html);
				block.append(tabhtml);
				TableauWorkbook.append(block);
			}
			for (var int = 0; int < (3 - apps.length); int++) {
				block=$('<div class="block2"></div>');
				
				html='<div class="blockClick"><div class="chart1"><img src="'+image_null_url+ '" style="width:250px; height:160px;"/></div><div class="blockContent"><p><label class="color2 fontSize2">暂无应用</label></p><p class="marginTop"><label class="font1 color3">应用信息：无应用信息。</label></p></div></div>';
				tabhtml='<div class="blockFoot"><table class="base_table"><tr><td class="userWidth"><div class="user"></div><label class="font color" style="margin-left:3px;">暂无</label></td><td><div class="time"></div><label class="font color" style="margin-left:2px;">0000-00-00</label></td></tr></table></div>';
				block.append(html);
				block.append(tabhtml);
				TableauWorkbook.append(block);
			}
		} else if(apps.length == 0){
			for (var int = 0; int < (3 - apps.length); int++) {
				block=$('<div class="block2"></div>');
				if(int==0){
					block=$('<div class="block1"></div>');
				}
				
				html='<div class="blockClick"><div class="chart1"><img src="'+image_null_url+'" style="width:250px; height:160px;"/></div><div class="blockContent"><p><label class="color2 fontSize2">暂无应用</label></p><p class="marginTop"><label class="font1 color3">应用信息：无应用信息。</label></p></div></div>';
				tabhtml='<div class="blockFoot"><table class="base_table"><tr><td class="userWidth"><div class="user"></div><label class="font color" style="margin-left:3px;">暂无</label></td><td><div class="time"></div><label class="font color" style="margin-left:2px;">0000-00-00</label></td></tr></table></div>';
				block.append(html);
				block.append(tabhtml);
				TableauWorkbook.append(block);
			}
		}
		
	});
}

function getAppBaseinfoRank(){
	var url = $ctx+"/portal/getTableauWorkbookRankTopNum.action"; 
	$.post(url,function(result){
			var ranks = eval(result);
			var table = $("#appBaseinfoRank");
			var tr;
			var td;
			var div;
			var value;
			var classStyle ;
			var classButton ;
			var classFontColor;
			var name;
			for(var i=0;i<ranks.length;i++){
				tr = $("<tr></tr>");
				td = $("<td></td>");
				value = ranks[i][0]- ranks[i][1];
				if(value==0){
					classStyle = "middleIcon";
				}else if(value>0){
					classStyle = "downIcon";
				}else{
					classStyle = "top";
					value = -value;
				}
				if(ranks[i].today<=3){
					classButton="numBtn";
					classFontColor="font color4";
				}else{
					classFontColor="font color";
					classButton="numBtn1";
				}
				name = ranks[i][3];
			/*	if(name.length>15){
					name = name.substring(0,15)+"...";
				}*/
				td.append($("<input type=\"button\" value=\""+(ranks[i][0])+"\" class=\""+classButton+" float-left\"/>"));
				td.append($("<label class=\"font1 color2 text-overflow float-left\" style=\"\">"+name+"</label>"));
				div = $("<div class=\"floatRight\"> </div>");
				div.append($("<label class=\""+classFontColor+" \" style=\"margin-right: 3px;\">"+value+"</label>"));
				div.append($("<div class=\""+classStyle+"\"></div>"));
				td.append(div);
				td.append($("<div class=\"ClearFloat\"></div>"));
				tr.append(td);
				table.append(tr);
			}
	});
} 

