package com.ultrapower.dcs.cluster.control.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @ClassName com.ultrapower.dcs.cluster.control.web.SessionConfiguration
 * @Title 创建配置类，拦截器添加到SpringBoot的配置中，让SpringBoot项目有这么一个拦截器存在
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-13 10:44
 */
@Configuration
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration logininterceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        logininterceptorRegistration.order(0);
        logininterceptorRegistration.excludePathPatterns("/");
        logininterceptorRegistration.excludePathPatterns("/login");
        logininterceptorRegistration.excludePathPatterns("/logout");
        logininterceptorRegistration.addPathPatterns("/**") ;
        
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
    }


}
