package com.jhh.match.params.result;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class TResult<T> implements Serializable {
    public final static String SUCCESS = "success";

    private String code = "unknown"; //未知错误
    private String msg = "";
    private String url = "";
    private Integer pageCount;
    private Integer currentPage;
    private Long tatol;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public TResult(){

    }

    public TResult(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public TResult(String code, String msg, HttpServletRequest request) {
        this.code = code;
        this.msg = msg;
        this.url = requestUrl(request);
    }

    public TResult(String code, String msg, HttpServletRequest request, T result)  {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    private String requestUrl(HttpServletRequest request) {
        if(request == null) return "";
        return String.format("%s://%s:%d%s", request.getScheme(), request.getServerName(),request.getServerPort(),request.getRequestURI());
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTatol() {
        return tatol;
    }

    public void setTatol(Long tatol) {
        this.tatol = tatol;
    }
}
