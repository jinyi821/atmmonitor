package com.ultrapower.dcs.cluster.control.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.dcs.cluster.control.model.TestItem;


/**
 * Created by TMP246 on 2018/5/25.
 */
public interface TestService {

    int addUser(TestItem user);

    PageInfo<TestItem> findAllUser(int pageNum, int pageSize);
}
