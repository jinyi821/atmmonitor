package com.common.core.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 跨网站漏洞、拦截防止sql注入
 * 
 * @author fanjiafeng
 * 
 */
public class XssFilter implements Filter {
	FilterConfig filterConfig = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		chain.doFilter(new XssHttpServletRequestWrapperNew((HttpServletRequest) request, request.getParameterMap()),
				response);
	
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}
}
