package com.ultrapower.dcs.cluster.control.utils;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.utils.codeEnumTools
 * @Title code枚举工具类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-13 14:38
 */
public class CodeEnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        // 遍历枚举类的值，返回与code匹配的实例
        for (T each : enumClass.getEnumConstants()) {
            if (each.getCode().equals(code)) {
                return each;
            }
        }
        return null;
    }



}
