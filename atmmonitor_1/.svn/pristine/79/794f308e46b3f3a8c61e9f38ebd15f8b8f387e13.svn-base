package com.usermanager.services;

import java.util.List;

import com.usermanager.model.BsMenu;
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
public interface BsUserMenuService
{
    /**
     * 
     * Created on 2016-3-25 
     * <p>Discription:[把用菜单放在缓存]</p>
     * @author:<a href=####@neusoft.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public void  putUserMenuCache(String loginname);
    
    
    /**
     * 
     * Created on 2016-3-24 
     * <p>Discription:[根据某个用户取得对应菜单下子菜单]</p>
     * @param loginname 登录名
     * @param menuid  菜单ID
     * @param isRecursive 是否递归查子菜单
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    List<BsMenu> getMenuListByUser(String loginname, Integer menuid, Boolean isRecursive);
    
    /**
     * 
     * Created on 2016-3-29 
     * <p>Discription:[根据Url 找到对应的menu]</p>
     * @param loginname
     * @param url
     * @return
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public BsMenu getMenuByurl(String loginname,String url);

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
    public Boolean IsControlMenu(String loginname, String url);
    
   
    
}
