package com.usermanager.manager;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.core.util.StringUtils;
import com.common.core.util.TimeUtils;
import com.common.dao.IDAO;
import com.usermanager.model.BsVistRecorde;
import com.usermanager.services.BsVistRecordeService;

/**
 * 
 * Created on 2016-3-23
 * <p>Title:       [访问链接业务操作类]</p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     </p>
 * @author         <a href=21990173@qq.com>jinyi</a>
 * @version        1.0
 */
@Transactional
@Service(value = "bsVistRecordeService")
public class BsVistRecordeImpl implements BsVistRecordeService
{

    private static Log logger = LogFactory.getLog(BsVistRecordeImpl.class);

    @Autowired
    private IDAO<BsVistRecorde, Long> bsVistRecordeDao;



    public IDAO<BsVistRecorde, Long> getBsVistRecordeDao()
    {
        return bsVistRecordeDao;
    }

    public void setBsVistRecordeDao(IDAO<BsVistRecorde, Long> bsVistRecordeDao)
    {
        this.bsVistRecordeDao = bsVistRecordeDao;
    }

   

    public boolean addBsVistRecorde(BsVistRecorde bsVistRecorde)
    {
        boolean result = false;
        if (bsVistRecorde != null)
        {
            bsVistRecordeDao.save(bsVistRecorde);
            result = true;
        }
        return result;
    }

    public boolean deleteBsVistRecordeById(Long pid)
    {
        boolean result = false;
        bsVistRecordeDao.deleteByKey(pid);
        result = true;
        return result;
    }

    public boolean deleteBsVistRecordeByIds(List<Long> dList)
    {
        int lstLen = dList == null ? 0 : dList.size();
        for (int i = 0; i < lstLen; i++)
        {
            if (!this.deleteBsVistRecordeById(dList.get(i)))
                return false;
        }
        return true;
    }

    public boolean saveOrUpdateBsVistRecorde(BsVistRecorde bsVistRecorde)
    {
        boolean result = false;
        if (bsVistRecorde != null)
        {
            String pid = StringUtils.checkNullString(bsVistRecorde.getPid()).trim();
            if (pid.equals(""))
            {
                result = this.addBsVistRecorde(bsVistRecorde);
            }
            else
            {
                bsVistRecordeDao.saveOrUpdate(bsVistRecorde);
                result = true;
            }
        }
        return result;
    }

    public BsVistRecorde getBsVistRecordeById(Long pid)
    {
        return bsVistRecordeDao.get(pid);
    }

    /**
     * 
     * Created on 2016-3-24 
     * <p>Discription:[插入访问记录]</p>
     * @param url 地址
     * @param loginname 登录名
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    @Override
    public void addBsVistRecorde(String url, String loginname)
    {
        
        logger.debug("addBsVistRecorde begin：url=" + url + "loginname=" + loginname);
        if (!url.endsWith("action")){
            return ;
        }
        
        BsVistRecorde bsVistRecorde = new BsVistRecorde();
        bsVistRecorde.setLoginname(loginname);
        
        Calendar instance = Calendar.getInstance();
        long createtime=instance.getTimeInMillis();
        int visthour = instance.get(Calendar.HOUR_OF_DAY);
        String formatIntToDateString = TimeUtils.formatIntToDateString(createtime/1000, "yyyyMMdd");
        
        logger.debug("formatIntToDateString= "+formatIntToDateString);
        Long  vistdate = new Long(formatIntToDateString);
        
        bsVistRecorde.setCreatetime(createtime/1000);
        bsVistRecorde.setVisthour(visthour);
        bsVistRecorde.setVistdate(vistdate);
        bsVistRecorde.setLinkurl(url);
       
        
        logger.debug("生成bsVistRecorde= "+bsVistRecorde);
        addBsVistRecorde(bsVistRecorde);
        logger.debug("addBsVistRecorde end");
    }

}
