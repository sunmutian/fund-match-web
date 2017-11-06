package com.jhh.match.params.result;

import java.io.Serializable;
import java.util.List;

/**
 * 所有平台列表
 *
 * @author tianweichang
 * @create 2017-10-31 17:50
 **/
public class PlatformList implements Serializable{
    private static final long serialVersionUID = -5368227331197623620L;
    public final static String SUCCESS = "success";

    private String code="unknown";
    private String msg;
    /**
     * 借出平台列表
     */
    private List<AppResult> srcAppList;
    /**
     * 借款平台列表
     */
    private List<AppResult> tarAppList;

    public PlatformList(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public List<AppResult> getSrcAppList() {
        return srcAppList;
    }

    public void setSrcAppList(List<AppResult> srcAppList) {
        this.srcAppList = srcAppList;
    }

    public List<AppResult> getTarAppList() {
        return tarAppList;
    }

    public void setTarAppList(List<AppResult> tarAppList) {
        this.tarAppList = tarAppList;
    }

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
}
