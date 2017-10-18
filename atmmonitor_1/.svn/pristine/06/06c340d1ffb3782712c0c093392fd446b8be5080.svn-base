package com.common.core.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver
{
	
	private static Log logger = LogFactory.getLog(MyExceptionHandler.class);
   
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex.toString());
        ex.printStackTrace();
        logger.error(ex);
        ModelAndView mv=new ModelAndView("/portal/exception.jsp");
        //return new ModelAndView("redirect:/portal/exception.jsp");
        return mv;
    }
}
