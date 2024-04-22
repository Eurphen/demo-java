package com.example.demojavaservice.pojo;

public class HttpResult {
    public int code;
    public String msg;
    public Object data = null;

    public HttpResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static HttpResult success() {
        return new HttpResult(1, "success", null);
    }

    public static HttpResult success(Object data) {
        return new HttpResult(1, "success", data);
    }

    public static HttpResult error(int code, String msg) {
        return new HttpResult(code, msg, null);
    }
}
