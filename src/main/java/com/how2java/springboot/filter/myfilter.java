package com.how2java.springboot.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
@WebFilter(urlPatterns = "/*")
public class myfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        System.out.println("进入了我的过滤器"+httpRequest.getRequestURI()+"..."+request.getLocalAddr());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
