package com.jhh.match.params.result;

import java.io.Serializable;

/**
 *
 * @author tianweichang
 * @create 2017-11-2 9:19
 **/
public class AppMatches implements Serializable {
    private static final long serialVersionUID = 8963628570712871833L;
    private Integer srcAppId;
    private String srcName;
    private String tarNames;
    private String createTime;
    private String enabled;
    private Integer enableData;
    private Integer[] tarAppIds;

    public Integer[] getTarAppIds() {
        return tarAppIds;
    }

    public void setTarAppIds(Integer[] tarAppIds) {
        this.tarAppIds = tarAppIds;
    }

    public Integer getSrcAppId() {
        return srcAppId;
    }

    public void setSrcAppId(Integer srcAppId) {
        this.srcAppId = srcAppId;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getTarNames() {
        return tarNames;
    }

    public void setTarNames(String tarNames) {
        this.tarNames = tarNames;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Integer getEnableData() {
        return enableData;
    }

    public void setEnableData(Integer enableData) {
        this.enableData = enableData;
    }
}
