package com.usermanager.services;

import java.util.List;

import com.usermanager.model.BsVistRecorde;

/**
 * 
 * Created on 2016-3-28
 * <p>Title:       [用户管理_用户访问日志]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     </p>
 * @author         <a href=21990173@qq.com>jinyi</a>
 * @version        1.0
 */
public interface BsVistRecordeService
{
    public boolean addBsVistRecorde(BsVistRecorde bsVistRecorde);

    public boolean deleteBsVistRecordeById(Long pid);

    public boolean deleteBsVistRecordeByIds(List<Long> dList);

    public boolean saveOrUpdateBsVistRecorde(BsVistRecorde bsvistrecorde);

    public BsVistRecorde getBsVistRecordeById(Long pid);

    /**
     * 
     * Created on 2016-3-23 
     * <p>Discription:[插入访问记录]</p>
     * @param loginname  登录名
     * @param linkurl    访问链接
     * @author:<a href=####@neusoft.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    public void addBsVistRecorde(String url, String loginname);

}
