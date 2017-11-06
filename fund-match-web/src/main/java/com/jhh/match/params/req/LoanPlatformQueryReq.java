package com.jhh.match.params.req;

import com.jhh.match.params.result.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * 出借平台查询请求参数
 *
 * @author tianweichang
 * @create 2017-10-24 14:12
 **/
public class LoanPlatformQueryReq extends Page {
    private static final long serialVersionUID = 3106111251701738723L;
    /**
     * app_id
     */
    private Long appId;
    /**
     * 是否启用
     */
    private Boolean enabled ;
    /**
     * order_no
     */
    private String orderNo;
    /**
     * 姓名
     */
    private String personalName;
    /**
     * 流水号开始时间
     */
    private Date startTime;
    /**
     * 流水号结束时间
     */
    private Date endTime;
    /**
     * 身份证号码
     */
    private String cardNo;



    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

}
