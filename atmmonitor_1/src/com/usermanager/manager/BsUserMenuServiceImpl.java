package com.usermanager.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.core.util.CacheUtils;
import com.usermanager.model.BsMenu;
import com.usermanager.services.BsUserMenuService;

/**
 * 
 * Created on 2016-3-25
 * <p>Title:       [用户管理]</p>
 * <p>Description: [对用户对应菜单进行缓存和读操作]</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     </p>
 * @author         <a href=21990173@qq.com>jinyi</a>
 * @version        1.0
 */
@Service("bsUserMenuService")
public class BsUserMenuServiceImpl implements BsUserMenuService
{
   
    private static Log logger = LogFactory.getLog(BsUserMenuServiceImpl.class);

    @Autowired
    private SQLDaoImpl<BsMenu> dao;
    
    /**
     * 
     * Created on 2016-3-28 
     * <p>Discription:[用户登录时，把用户菜单信息放置缓存]</p>
     * @param loginname
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @Override
    public void putUserMenuCache(String loginname)
    {
        logger.debug("putUserMenuCache begin" );
        logger.debug("loginame="+loginname);
        
        String sql = " select distinct c.* from bs_userinfo_role a ,bs_role_menu b,bs_menu c " +
        		"where a.roleid=b.roleid and b.menuid=c.menuid  and c.status=1 and a.loginname=:loginname order by b.menuid ";
        
        String sql0 = " select distinct c.menuid from bs_userinfo_role a ,bs_role_menu b,bs_menu c " +
                "where a.roleid=b.roleid and b.menuid=c.menuid  and c.status=1 and a.loginname=:loginname ";
        
        String sql1 =" select d.* from bs_menu d where d.menuid not in ( "+sql0 +" )";
        
        Map<String,Object> parameterMap=new HashMap<String,Object>();
        parameterMap.put("loginname", loginname);
        //用户有操作权限菜单列表放在缓存
        List<BsMenu> menuList = dao.getListBySQL(sql,parameterMap,BsMenu.class);
        if (menuList != null)
        {
            //授权访问菜单放到缓存
            logger.debug("授权访问菜单放到缓存");
            CacheUtils.putCacheValue(CacheUtils.CACHE_BS_MENU, loginname, menuList);
        }

        //用户没有操作权限菜单列表放在缓存
        List<BsMenu> menuList1 = dao.getListBySQL(sql1,parameterMap,BsMenu.class);
        if (menuList1 != null)
        {
            //受限访问菜单放到缓存
            logger.debug("受限访问菜单放到缓存");
            CacheUtils.putCacheValue(CacheUtils.CACHE_BS_MENU_CONTROL, loginname, menuList1);
        }
        
        logger.debug("putUserMenuCache end" );
    }

    /**
     * Created on 2016-3-24 
     * 
     * <p>Discription:[根据某个用户取得对应菜单下子菜单]</p>
     * @param loginname 登录名
     * @param menuid  菜单ID （menuid为空时，取一级菜单）
     * @param isRecursive 是否递归查子菜单
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @Override
    public List<BsMenu> getMenuListByUser(String loginname, Integer menuid, Boolean isRecursive)
    {
        logger.debug("getMenuListByUser begin" );
        logger.debug("loginame="+loginname);
        logger.debug("menuid="+menuid);
        logger.debug("isRecursive="+isRecursive);
        
        List<BsMenu> resultList=new ArrayList<BsMenu>();
        //从缓存取所有用户对应菜单
        List<BsMenu> list = new CacheUtils<List<BsMenu>>().getCacheValue(CacheUtils.CACHE_BS_MENU, loginname);
        if (list == null || list.size() == 0)
        {

            logger.debug("没有缓存");
            logger.debug("getMenuListByUser end");
            return null;
        }
        //取根节点菜单下属直接子菜单
        for (BsMenu bsMenu : list)
        {
         if (bsMenu.getParentid() == menuid||((bsMenu.getParentid()!=null&&menuid!=null&&bsMenu.getParentid().equals(menuid))))

            {
                if(isRecursive)
                {
                    logger.debug("getMenuListByUser 递归查询子菜单" );
                    bsMenu.setChildList(getMenuListByUser(loginname,bsMenu.getMenuid(),isRecursive));
                }
                resultList.add(bsMenu);
            }
        }
        logger.debug("getMenuListByUser end" );
        return resultList;        
    }
    
    /**
     * 
     * Created on 2016-3-29 
     * <p>Discription:[用户授权菜单]</p>
     * @param loginname
     * @param url
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @Override
    public BsMenu getMenuByurl(String loginname, String url)
    {
        List<BsMenu> list = new CacheUtils<List<BsMenu>>().getCacheValue(CacheUtils.CACHE_BS_MENU, loginname);
        if (list==null||list.size()==0){
            return null;
        } else {
            for (BsMenu bsMenu : list)
            {
                if (bsMenu.getMenuurl()!=null&&bsMenu.getMenuurl().indexOf(url)>-1){
                    return   bsMenu;
                }
            }
        }
        return null;
    }
    
    /**
     * 
     * Created on 2016-3-29 
     * <p>Discription:[是否用户受限菜单]</p>
     * @param loginname
     * @param url
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @Override
    public Boolean IsControlMenu(String loginname, String url)
    {
        List<BsMenu> list = new CacheUtils<List<BsMenu>>().getCacheValue(CacheUtils.CACHE_BS_MENU_CONTROL, loginname);
        if (list==null||list.size()==0){
            return false;
        } else {
            for (BsMenu bsMenu : list)
            {
                if (bsMenu.getMenuurl()!=null&&bsMenu.getMenuurl().indexOf(url)>-1){
                    return   true;
                }
            }
        }
        return false;
    }

}
