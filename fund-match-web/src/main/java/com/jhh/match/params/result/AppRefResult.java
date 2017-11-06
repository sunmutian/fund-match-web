package com.jhh.match.params.result;

import com.jhh.match.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台配对信息
 *
 * @author tianweichang
 * @create 2017-10-24 11:56
 **/
public class AppRefResult implements Serializable {
    private static final long serialVersionUID = 6845526818106510167L;
    /**
     * 创建时间
     */
    private Date createTime;
    private String createTimeStr;

    /**
     * 关闭时间点
     */
    private Date disabledTime;
    /**
     * 是否启用
     */
    private Boolean enabled;
    private Integer enabledData;
    private String enabledStr;

    /**
     * 记录id
     */
    private Integer id;

    /**
     * 提交人
     */
    private String postTser;

    /**
     * 借贷平台id
     */
    private Integer tarAppId;
    /**
     * 出借平台id
     */
    private Integer srcAppId;
    /**
     * 出借平台信息
     */
    private AppResult srcApp;
    /**
     * 借款平台信息
     */
    private AppResult tarApp;

    public Integer getEnabledData() {
        return this.enabled == true ? 0 : 1;
    }

    public void setEnabledData(Integer enabledData) {
        this.enabledData = enabledData;
    }

    public String getCreateTimeStr() {
        if (this.createTime == null) {
            return "";
        }
        return DateUtil.convertDateToString(this.createTime, DateUtil.DEFAULT_FORMAT);
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getEnabledStr() {
        return this.enabled == true ? "启用" : "未启用";
    }

    public void setEnabledStr(String enabledStr) {
        this.enabledStr = enabledStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDisabledTime() {
        return disabledTime;
    }

    public void setDisabledTime(Date disabledTime) {
        this.disabledTime = disabledTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostTser() {
        return postTser;
    }

    public void setPostTser(String postTser) {
        this.postTser = postTser;
    }

    public Integer getTarAppId() {
        return tarAppId;
    }

    public void setTarAppId(Integer tarAppId) {
        this.tarAppId = tarAppId;
    }

    public Integer getSrcAppId() {
        return srcAppId;
    }

    public void setSrcAppId(Integer srcAppId) {
        this.srcAppId = srcAppId;
    }

    public AppResult getSrcApp() {
        return srcApp;
    }

    public void setSrcApp(AppResult srcApp) {
        this.srcApp = srcApp;
    }

    public AppResult getTarApp() {
        return tarApp;
    }

    public void setTarApp(AppResult tarApp) {
        this.tarApp = tarApp;
    }
}
