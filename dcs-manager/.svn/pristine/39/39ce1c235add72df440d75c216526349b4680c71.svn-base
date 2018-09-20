package com.ultrapower.dcs.cluster.control.web;

/*import entity.iframe.annotation.OperationLog;
import framework.core.SystemHelper;*/

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/* *
 * @Title 登录拦截
 * @Description  
 * @Param     
 * @Return   
 * @throws      
 * @author   jinyi
 * @Date   2018/7/13  15:01
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

        String load = request.getParameter("loadAjax");
        //System.out.println("=====" + load + "=====");
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            if (load == null) {
                response.sendRedirect(request.getContextPath() + "/");
            } else {

                PrintWriter writer = null;
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=utf-8");
                try {
                    writer = response.getWriter();
                    String flag = "nologinUser";
                    writer.print(flag);

                } catch (IOException e) {

                } finally {
                    if (writer != null)
                        writer.close();
                    return false;
                }
            }

        }
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
        
        modelAndView.addObject("BASE_PATH", request.getContextPath());
    }

}
