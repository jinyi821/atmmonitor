package com.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PageNoUtil {
	/**
     * @param             session :一个会话
     * @param            hql:是需要执行的hql语句，
     * @param            offset 设置开始位置
     * @param              length:读取记录条数
     * return             返回结果集List<?>表示一个泛型的List
     */
    public static List<?> getListLimit( Session session , String hql , int offset, int length ,final Object... values)
    {
       Query q = session.createQuery(hql);
       q.setFirstResult(offset);
       q.setMaxResults(length);
       if (values != null) {
       	for ( int i = 0; i < values.length; i++) {
       		q.setParameter(i, values[i]);
       	}       
       }
       List<?> list = q.list();
       return list;
    }
    /**
     *  按分页的方式查询
     * @param session
     * @param hql
     * @param pageBean
     * @param values
     * @return
     */
    public static List<?> getListForPage( Session session , String hql , PageBean pageBean ,final Object... values)
    { 	
    		int offset=0;
    		int length=0;
    		if(pageBean!=null)
    		{
	    		if(pageBean.getPage()>0 && pageBean.getPagesize()>0)
	    		{
	    			if(pageBean.getPage()==1)
	    			{
	    				offset=0;
	    			}
	    			else
	    			{
	    				offset=(pageBean.getPage()-1)*pageBean.getPagesize();
	    			}
	    			length=pageBean.getPagesize();
	    		}
    		}
    		return getListLimit(session,hql,offset,length,values);
    }

}
