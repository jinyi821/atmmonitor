package com.ultrapower.dcs.cluster.control.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.utils.JsonUtils
 * @Title json对象转化处理组件
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-11 11:38
 */
public class JsonUtils {

 /* *
  * @Title 把list集合转化为Json字符串
  * @Description
  * @Param     [list]
  * @Return   java.lang.String
  * @throws
  * @author   fanjianfeng
  * @Date   2018/6/11  11:41
  **/
   public static  String convertListToJsonStr(List list) {
       String jsonStr="";
       // 1. 导入jar包
       // 2. 创建 ObjectMapper 对象
       try {
           ObjectMapper mapper = new ObjectMapper();
           jsonStr = mapper.writeValueAsString(list);
       }catch (JsonProcessingException e) {
           e.printStackTrace();
       }
      return jsonStr;
   }
/* *
 * @Title  将Object对象转化为Json字符串
 * @Description  
 * @Param     [obj]
 * @Return   java.lang.String
 * @throws      
 * @author   fanjianfeng
 * @Date   2018/7/24  16:04
 **/
public static String convertObjectToJsonStr(Object obj){
    String jsonStr="";
    // 1. 导入jar包
    // 2. 创建 ObjectMapper 对象
    try {
        ObjectMapper mapper = new ObjectMapper();
        jsonStr = mapper.writeValueAsString(obj);
    }catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return jsonStr;
}

}
