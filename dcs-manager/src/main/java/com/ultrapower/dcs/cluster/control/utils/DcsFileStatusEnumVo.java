package com.ultrapower.dcs.cluster.control.utils;

import java.io.Serializable;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.utils.DcsFileStatusEnumVo
 * @Title 枚举实体类
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-08-09 10:22
 */
public class DcsFileStatusEnumVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String context;

    public DcsFileStatusEnumVo() {
    }

    public DcsFileStatusEnumVo(Integer code, String context) {
        this.code = code;
        this.context = context;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}