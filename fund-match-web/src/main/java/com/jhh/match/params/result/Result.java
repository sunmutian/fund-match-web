package com.jhh.match.params.result;

import javax.servlet.http.HttpServletRequest;

public class Result extends TResult<Object> {
    public Result(String code, String msg) {
        super(code, msg);
    }

    public Result(String code, String msg, HttpServletRequest request) {
        super(code, msg, request);
    }

    public Result(String code, String msg, HttpServletRequest request, Object result) {
        super(code, msg, request, result);
    }
}
