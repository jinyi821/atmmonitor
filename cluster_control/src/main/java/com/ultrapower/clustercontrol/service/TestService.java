package com.ultrapower.clustercontrol.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.clustercontrol.model.Item;


/**
 * Created by TMP246 on 2018/5/25.
 */
public interface TestService {

    int addUser(Item user);

    PageInfo<Item> findAllUser(int pageNum, int pageSize);
}
