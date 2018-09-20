package com.ultrapower.dcs.cluster.control.utils;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static javafx.scene.input.KeyCode.O;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.utils.DcsFileStatusEnum
 * @Title Dcs文件状态枚举值
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-07-13 10:41
 */
public enum DcsFileStatusEnum implements CodeEnum{
    PunDload(0,"已经下发到Probe但没有下载完成","P<span class='glyphicon glyphicon-arrow-down' style='color:yellow;'></span>"),
    HunUload(1," 已下载未上传HDFS","H<span class='glyphicon glyphicon-arrow-up' style='color:yellow;' ></span>"),
    HsDoUload(2,"已成功上传HDFS","H<span class='glyphicon glyphicon-arrow-up' style='color:red;' ></span>"),
    HfDoUload(3,"上传HDFS失败","H<span class='glyphicon glyphicon-cloud-upload' style='color:red;' ></span>"),
    HdoUload(4,"正上传HDFS上传进行中"," H<span class='glyphicon glyphicon-arrow-up' style='color:green;' ></span>");

    private Integer code;
    private String titleContext;
    private String htmlContent;

    private DcsFileStatusEnum(Integer code,String titleContext,String htmlContent){  //构造方法，只能是private或者friendly修饰
        this.code = code;
        this.titleContext = titleContext;
        this.htmlContent = htmlContent;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitleContext() {
        return titleContext;
    }

    public void setTitleContext(String titleContext) {
        this.titleContext = titleContext;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
