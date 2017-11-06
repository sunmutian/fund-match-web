package com.jhh.match.params.req;

import com.jhh.match.params.result.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * 资金平台信息列表请求参数
 *
 * @author tianweichang
 * @create 2017-10-24 14:20
 **/
public class FundPlatformQueryReq extends Page{
    private static final long serialVersionUID = 8092706838187260107L;
    /**
     * 平台类型
     */
    private Integer type;
    /**
     * 平台名称关键字
     */
    private String name;
    /**
     * 创建开始时间 2017-10-24T02:47:07.939Z
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
