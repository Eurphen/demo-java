package com.example.demojavaservice.filter;
 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StringUtils;
 

import java.util.HashMap;
import java.util.Map;

public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
    private final Map<String, String> headerMap = new HashMap<>();
 
    public HeaderMapRequestWrapper(HttpServletRequest request) {
        super(request);
    }
 
    public void addHeader(String name,String value){
        headerMap.put(name,value);
    }
 
    @Override
    public String getHeader(String name){
        String header = super.getHeader(name);
        String value = this.headerMap.get(name);
        if(!StringUtils.isEmpty(value)){
            return value;
        }
        return header;
    }
 
}

