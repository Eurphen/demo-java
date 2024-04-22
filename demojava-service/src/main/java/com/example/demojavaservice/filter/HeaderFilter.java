package com.example.demojavaservice.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter
public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(req);
        String token = req.getHeader("token");
        if(!StringUtils.isEmpty(token)){
            headerMapRequestWrapper.addHeader("token",token);
        }
    }
 
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

