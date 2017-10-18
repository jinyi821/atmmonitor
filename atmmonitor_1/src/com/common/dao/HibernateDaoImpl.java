package com.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public class HibernateDaoImpl<T extends Serializable, PK extends Serializable> implements IDAO<T, PK>
{

    protected Class<T> entityClass;

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate()
    {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Class<T> getEntityClass()
    {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    @Override
    public T get(final Serializable id)
    {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public void save(T entity)
    {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity)
    {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity)
    {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteByKey(PK id)
    {
        this.delete(get(id));

    }

    @Override
    public int bulkUpdate(String queryString, Object... values)
    {
        return getHibernateTemplate().bulkUpdate(queryString, values);
    }

    @Override
    public List<T> find(final String hql, final Object... values) throws Exception
    {
        return (List<T>) getHibernateTemplate().find(hql, values);
    }

    @Override
    public List<T> findPage(final String hql, final PageBean pageBean, final Object... values)
    {

        List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                return PageNoUtil.getListForPage(session, hql, pageBean, values);
            }
        });
        return list;
    }

    public List<Object[]> query(final String hql, final PageBean pageBean, final Object... values)
    {
        List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                return PageNoUtil.getListForPage(session, hql, pageBean, values);
            }
        });
        return list;
    }

    @Override
    public int getAllRowCount(String hql) throws Exception
    {
        // TODO Auto-generated method stub
        Integer count = (Integer) this.hibernateTemplate.find(hql).listIterator().next();
        return count.intValue();
    }

    @Override
    public Object add(T entity)
    {
        return this.getHibernateTemplate().save(entity);
    }

    @Override
    public List<Object[]> queryBySql(final String sql, final Object... values)
    {
        List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                Query q = session.createQuery(sql);
                if (values != null)
                {
                    for (int i = 0; i < values.length; i++)
                    {
                        q.setParameter(i, values[i]);
                    }
                }
                List<Object[]> list = q.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public List<Object[]> findBySql(final String sql, final Object... values)
    {
        List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                Query q = session.createSQLQuery(sql);
                if (values != null)
                {
                    for (int i = 0; i < values.length; i++)
                    {
                        q.setParameter(i, values[i]);
                    }
                }
                List<Object[]> list = q.list();
                return list;
            }
        });
        return list;
    }
    
    /**
     * 
     * Created on 2016-4-9 
     * <p>Discription:[根据条件map查询集合]</p>
     * @param sql :select * from t_user where user_name=:username and age=:age
     * @param map :map里 有Key=username 和key =age 对应上面占位符 
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List<T> findBySql(final String sql, final Map<String, Object> map)
    {
        List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                Query q = session.createSQLQuery(sql).addEntity(entityClass);
                
                q= setParameter(q,map);
                List<T> list = q.list();
                return list;
            }
        });
        return list;
    }
    
    /**
     * 
     * Created on 2016-4-9 
     * <p>Discription:[根据条件map查询集合]</p>
     * @param sql :select * from t_user where user_name=:username and age=:age
     * @param map :map里 有Key=username 和key =age 对应上面占位符 
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List<T> findBySql(final String sql, final Map<String, Object> map,final Integer firstResult ,final Integer maxResults)
    {
        List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                Query q = session.createSQLQuery(sql).addEntity(entityClass);
                
                q= setParameter(q,map);
                q.setFirstResult(firstResult);
                q.setMaxResults(maxResults);
                List<T> list = q.list();
                return list;
            }
        });
        return list;
    }
    /**
     * 
     * Created on 2016-4-9 
     * <p>Discription:[构造查询条件]</p>
     * @param query
     * @param map
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    private Query setParameter(Query query, Map<String, Object> map)
    {
        if (map != null)
        {
            Set<String> keySet = map.keySet();
            for (String string : keySet)
            {
                Object obj = map.get(string);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
                if (obj instanceof Collection<?>)
                {
                    query.setParameterList(string, (Collection<?>) obj);
                }
                else if (obj instanceof Object[])
                {
                    query.setParameterList(string, (Object[]) obj);
                }
                else
                {
                    query.setParameter(string, obj);
                }
            }
        }
        return query;
    }

	@Override
	public Long getSumCount(String hql) throws Exception {
		Long count = (Long) this.hibernateTemplate.find(hql).listIterator().next();
	    return count;
	}

	@Override
	public List findList(String hql, Object... values) throws Exception {	
		return getHibernateTemplate().find(hql, values);
	}

	@Override
	public List queryBySqlFunction(final String sql, final Object... values) {
		List list = this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                Query q = session.createSQLQuery(sql);
                if (values != null)
                {
                    for (int i = 0; i < values.length; i++)
                    {
                        q.setParameter(i, values[i]);
                    }
                }
                List list = q.list();
                return list;
            }
        });
        return list;
	}

	@Override
	public void batchSave(final List<T> list) {
		 this.getHibernateTemplate().execute(new HibernateCallback()
        {
            public Object doInHibernate(Session session)
            {
                  int size=list.size();
                  for (int i = 0; i<size;i++)
                    {
                	  T entity=list.get(i);
                	  session.save(entity);
                	//将数据刷入数据库并清空session 
                	  if (i/50 == 0) { //30到50hibernate缓存值
                		    session.flush();
                		    session.clear();
                		}
                    }
                    session.flush();
             		session.clear();                    
                  return null;
                }
        });		
	}
}
