package com.ultrapower.dcs.cluster.control;

import com.ultrapower.dcs.cluster.control.utils.PropertiesUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.PropertiesInitConfig
 * @Title 配置初始化加载运行器
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-07 11:14
 */
@Component
@Order(value=1)//有多个CommandLineRunner接口时可以指定执行顺序（小的先执行）
public class PropertiesInitConfig implements CommandLineRunner {  //CommandLineRunner表示在所有的bean以及applicationCOntenxt完成后的操作

    @Override
    public void run(String... args) throws Exception {
        PropertiesUtils.init();
    }




}
