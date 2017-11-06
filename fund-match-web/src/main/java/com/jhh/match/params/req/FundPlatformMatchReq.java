package com.jhh.match.params.req;

import java.io.Serializable;
import java.util.Date;

/**
 * 资金平台配对查询请求参数
 *
 * @author tianweichang
 * @create 2017-10-24 11:46
 **/
public class FundPlatformMatchReq implements Serializable {
    private static final long serialVersionUID = -5852071769629175861L;
    /**
     * 平台名称关键字
     */
    private String srcName;
    /**
     * 创建开始时间
     */
    private Date startTime;
    /**
     * 创建结束时间
     */
    private Date endTime;
    /**
     * 状态
     */
    private Integer enabled;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
