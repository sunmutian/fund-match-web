package com.jhh.match.params.result;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取平台信息列表请求参数
 *
 * @author tianweichang
 * @create 2017-10-23 18:03
 **/
public class FundPlatformListReq implements Serializable{

    private static final long serialVersionUID = -3025881730189972594L;
    /**
     * 平台类型
     */
    private Integer type;
    /**
     * 平台名称关键字
     */
    private String name;
    /**
     * 创建开始时间
     */
    private Date startTime;
    /**
     * 创建结束时间
     */
    private Date endTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
