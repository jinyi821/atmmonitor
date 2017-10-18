$(function(){
	/**下拉选择***/
	$(".js-example-basic-hide-search").select2({
	  minimumResultsForSearch: Infinity
  	});
});
/**左侧菜单树***/
function showList(obj,name){
	$(obj).next().toggle();
	var state=$(obj).next().css("display");
	if(state=="none"){
		$(obj).find("div[name='mark']").removeClass("showicon").addClass("showiconClick");
	}else{
		$(obj).find("div[name='mark']").removeClass("showiconClick").addClass("showicon");
	}		
}