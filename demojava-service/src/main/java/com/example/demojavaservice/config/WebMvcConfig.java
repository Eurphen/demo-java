package com.example.demojavaservice.config;

import com.example.demojavaservice.filter.HeaderFilter;
import jakarta.annotation.Resource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
    @Resource
    private HeaderFilter headerFilter;
 
    @Bean
    public FilterRegistrationBean<HeaderFilter> initFilterRegistrationBean(){
        FilterRegistrationBean<HeaderFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(headerFilter);
        registrationBean.addUrlPatterns("/");
        registrationBean.setOrder(0);
 
        return registrationBean;
    }
}
