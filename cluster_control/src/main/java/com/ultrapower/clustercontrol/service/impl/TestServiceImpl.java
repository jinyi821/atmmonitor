package com.ultrapower.clustercontrol.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.clustercontrol.dao.ItemDao;
import com.ultrapower.clustercontrol.model.Item;
import com.ultrapower.clustercontrol.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private ItemDao itemDao;//这里会报错，但是并不会影响

    @Override
    public int addUser(Item user) {

        return itemDao.insert(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public PageInfo<Item> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Item> userDomains = itemDao.selectAllItem();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}