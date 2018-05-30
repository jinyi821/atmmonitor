package com.ultrapower.clustercontrol.controll;

import com.ultrapower.clustercontrol.model.Item;
import com.ultrapower.clustercontrol.service.TestService;
import com.ultrapower.clustercontrol.utils.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public int addUser(Item user){
        return testService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return testService.findAllUser(pageNum,pageSize);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");

        // return模板文件的名称，对应src/main/resources/templates/index.html
        System.out.println("-----");
        logger.info("==index=");
        return "index";
    }
    @RequestMapping("/testexception")
    public String error() throws Exception {
        throw new Exception("发生错误");
    }
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}