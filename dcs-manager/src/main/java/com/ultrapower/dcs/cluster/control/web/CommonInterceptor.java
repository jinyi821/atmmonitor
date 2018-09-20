package com.ultrapower.dcs.cluster.control.web;

/*import entity.iframe.annotation.OperationLog;
import framework.core.SystemHelper;*/
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chj on 2017/4/6.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

       /*if(request.getServletPath().isEmpty() || request.getServletPath().equals("/")){
            response.sendRedirect(request.getContextPath()+SystemHelper.getSession(String.class, "homeIndex"));
            return false;
        }*/

       

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }

        boolean isRedirectView = modelAndView.getView() instanceof RedirectView;
        if (isRedirectView) {
            return;
        }

        //对非Losd调用采用模板方式
        String viewName = modelAndView.getViewName();
        String load = request.getParameter("loadAjax");
        
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();
        String aa=requestURL.substring(requestURL.indexOf(contextPath));
        aa=aa.substring(1,aa.length()-1);
        String[] split = aa.split("/");

        if (!viewName.equals("login")&&load==null&&!viewName.equals("index")){
            modelAndView.addObject("contentftl", "/"+ modelAndView.getViewName()+".ftl");
            modelAndView.addObject("function",split[split.length-1]);
            modelAndView.setViewName("dcs_common/common");
            
        }
        modelAndView.addObject("BASE_PATH", request.getContextPath());
    }

}
