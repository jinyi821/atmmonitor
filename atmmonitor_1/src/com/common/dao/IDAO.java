package com.common.dao;

import java.util.List;
import java.util.Map;

public interface IDAO <T, PK>{
	
	 // 根据主键获取实体。如果没有相应的实体，返回 null。  
    public T get(PK id); 
    public void save(T entity); 
    // 增加或更新实体  
    public void saveOrUpdate(T entity);
    // 删除指定的实体  
    public void delete(T entity); 
    // 根据主键删除指定实体  
    public void deleteByKey(PK id);
    // 使用带参数的HSQL语句增加、更新、删除实体  
    public int bulkUpdate(String queryString, Object... values);  
    
    // 使用带参数的HSQL语句检索数据  
    public List<T> find(final String hql, final Object... values) throws Exception;
    
    public List<T> findPage(final String hql, PageBean pageBean,final Object... values);  
  
    public int getAllRowCount(String hql) throws Exception;
    
    public List<Object[]> query(final String hql, final PageBean pageBean,final Object... values);
    //新增实体  并返回实体的ID
    public Object add(T entity);
    /**
     * 根据sql查询
     * @param sql
     * @param values
     * @return
     */
    public List<Object[]> queryBySql(final String sql,final Object... values);
    public List<Object []> findBySql(final String sql,final Object... values);
    
    /**
     * 
     * Created on 2016-4-9 
     * <p>Discription:[根据条件map查询集合]</p>
     * @param sql
     * @param map
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    List<T> findBySql(String sql, Map<String, Object> map);
    
    /**
     * 
     * @param sql
     * @param map
     * @param firstResult 第几条记录开始
     * @param maxResults  总共取多少记录
     * @return
     */
	List<T> findBySql(String sql, Map<String, Object> map, Integer firstResult,
			Integer maxResults);
    /**
     * 获得统计count返回值
     * @param hql 
     * @return
     * @throws Exception
     */
    public Long getSumCount(String hql) throws Exception;
    /**
     * 不指定查询后结果封装类型
     * @param hql sql语句
     * @param values 参数
     * @return
     * @throws Exception
     */    
    public List findList(final String hql, final Object... values) throws Exception;
    /**
     * hiberante 调用sql自定义函数    
     * @param sql sql语句
     * @param values 参数
     * @return
     */
    public List queryBySqlFunction(final String sql,final Object... values);
    /**
     * hibernate 批量保存
     * @param list 集合参数
     */
    public void batchSave(List<T> list);
    
}
