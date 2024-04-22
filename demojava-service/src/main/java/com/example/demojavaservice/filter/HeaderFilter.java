package com.example.demojavaservice.filter;

import com.example.demojavaservice.utils.Base64Utils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter
@Component
public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(req);
        String userId = req.getHeader("userId");
        String accountName = req.getHeader("accountName");
        String role = req.getHeader("role");
        if(!StringUtils.isEmpty(userId)){
            headerMapRequestWrapper.addHeader("userId",Base64Utils.decodeBase64(userId));
        }
        if(!StringUtils.isEmpty(accountName)){
            headerMapRequestWrapper.addHeader("accountName",Base64Utils.decodeBase64(accountName));
        }
        if(!StringUtils.isEmpty(role)){
            headerMapRequestWrapper.addHeader("role",Base64Utils.decodeBase64(role));
        }

        filterChain.doFilter(headerMapRequestWrapper, servletResponse);
    }
 
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

