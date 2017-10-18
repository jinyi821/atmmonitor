package com.common.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.core.component.rquery.RQuery;
@Controller
@RequestMapping("commonQuery")   
public class CommQueryAction {

   @RequestMapping("query.action")  
   @ResponseBody  
	public String query(String sqlname,Integer pageIndex,Integer pageSize,Integer isCount)
	{
		RQuery rquery =new RQuery(sqlname,null);
		//pageIndex=1;
		pageIndex=pageIndex==null?0:pageIndex;
		pageSize=pageSize==null?0:pageSize;
		isCount=isCount==null?0:isCount;
		
		rquery.setPage(pageIndex.intValue());
		//rquery.setPageCount(pageCount);
		//pageSize=5;
		rquery.setPageSize(pageSize.intValue());
		isCount=2;
		rquery.setIsCount(isCount.intValue());
		String data=rquery.getJsonString();
		int pageCount=rquery.getPageCount();
		int dataCount=rquery.getQueryResultSetCount();
		StringBuffer json=new StringBuffer();
		json.append("{");
		json.append("\"pageCount\":");
		json.append("\"");
		json.append(rquery.getPageCount());
		json.append("\"");
		json.append(",\"dataCount\":");
		json.append("\"");
		json.append(dataCount);
		json.append("\"");
		json.append(",\"pageData\":");
		if(!"".equals(data))
		{
			json.append(data);
		}
		else
		{
			json.append("[]");
		}
		json.append("}");
		return json.toString();
	}
}
