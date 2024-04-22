package com.example.demojavaservice.pojo;

public class Result {
    public int code;
    public String msg;
    public Object data = null;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result(1, "success", null);
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result error(String msg) {
        return new Result(1, msg, null);
    }
}
