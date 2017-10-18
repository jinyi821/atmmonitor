package com.common.core.util;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class CacheUtils<T>
{

    public static String CACHE_BS_LINK ="cache_bs_link"; //链接配置信息cache
    public static String CACHE_BS_MENU ="cache_bs_Menu"; //用户菜单cache
    
    public static String CACHE_BS_ALL_LINK ="cache_bs_all_link"; //所有链接配置信息cache
    
    public static String CACHE_BS_MENU_CONTROL ="cache_bs_Menu_Control"; //受限制菜单cache
    
    public static String CACHE_USER_VALIDATECODE ="cache_user_validatecode"; //用户手机验证码
   
    private static CacheManager create = CacheManager.create();
    
    /**
     * 
     * Created on 2016-3-25 
     * <p>Discription:[对ehcache进行读操作]</p>
     * 举例   BsLink value=new CacheUtils<BsLink>().getCacheValue(CacheUtils.CACHE_BS_LINK,key); //读操作
     * @param cacheName 缓存名称
     * @param key  缓存里key
     * @return  返回某个对象
     * @author:<a href=####@neusoft.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public T getCacheValue(String cacheName, String key)
    {

        Cache cache = create.getCache(cacheName);
        Element element = cache.get(key);
        if (element != null)
        {
            
            Serializable value = element.getValue();
            return (T) value;
        }
        else
        {
            return null;
        }
       
    }
    
    /**
     * 
     * Created on 2016-3-25 
     * <p>Discription:[对ehcache进行写操作]</p>
     *  CacheUtils.putCacheValue(CacheUtils.CACHE_BS_LINK, key, bsLink);  //写操作
     * @param cacheName 缓存名称
     * @param key  缓存Key
     * @param Object 缓存里 对象
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public static void putCacheValue(String cacheName, String key,Object Object)
    {
       
        Cache cache = create.getCache(cacheName);
        cache.put(new Element(key, Object));
    }
}
