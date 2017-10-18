package com.usermanager.manager;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SQLDaoImpl<T>
{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
  
    @SuppressWarnings("unchecked")
    public List<T> getListBySQL(String sql, Map<String, Object> parameterMap,Class<T> entityClass)
    {
       
        Session currentSession = getSessionFactory().openSession();
        SQLQuery createSQLQuery = currentSession.createSQLQuery(sql);
        
        if (entityClass!=null) {
            createSQLQuery.addEntity(entityClass);
        }
        
        if (parameterMap!=null&&!parameterMap.isEmpty())
        {
            Set<Entry<String, Object>> entrySet = parameterMap.entrySet();
            Iterator<Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext())
            {
                Entry<String, Object> next = iterator.next();
                createSQLQuery.setParameter(next.getKey(), next.getValue());

            }
        }
        List<T> list = (List<T>) createSQLQuery.list();

        if (list != null && list.size() > 0)
        {
            return list;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 
     * Created on 2016-3-28 
     * <p>Discription:[方法功能中文描述]</p>
     * @param sql
     * @param parameterMap
     * @param entityClass
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public Object getUniqueResultBySQL(String sql, Map<String, Object> parameterMap)
    {
       
        Session currentSession = getSessionFactory().openSession();
        SQLQuery createSQLQuery = currentSession.createSQLQuery(sql);

        if (parameterMap!=null&&!parameterMap.isEmpty())
        {
            Set<Entry<String, Object>> entrySet = parameterMap.entrySet();
            Iterator<Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext())
            {
                Entry<String, Object> next = iterator.next();
                createSQLQuery.setParameter(next.getKey(), next.getValue());

            }
        }
        return  createSQLQuery.uniqueResult();

    }
    
    /**
     * 
     * Created on 2016-4-22 
     * <p>Discription:[执行增删改语句]</p>
     * @param sql
     * @param parameterMap
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public int excuteSQl(String sql,Map<String, Object> parameterMap ){
        
        Session currentSession = getSessionFactory().openSession();
        SQLQuery createSQLQuery = currentSession.createSQLQuery(sql);

        if (parameterMap!=null&&!parameterMap.isEmpty())
        {
            Set<Entry<String, Object>> entrySet = parameterMap.entrySet();
            Iterator<Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext())
            {
                Entry<String, Object> next = iterator.next();
                createSQLQuery.setParameter(next.getKey(), next.getValue());

            }
        }
        return  createSQLQuery.executeUpdate();
    }

}