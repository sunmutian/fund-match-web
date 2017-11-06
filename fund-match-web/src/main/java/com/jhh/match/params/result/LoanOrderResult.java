package com.jhh.match.params.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 出借人信息
 *
 * @author tianweichang
 * @create 2017-10-23 19:01
 **/
public class LoanOrderResult implements Serializable{

    private static final long serialVersionUID = 6135058203067713824L;
    /**
     * 平台id
     */
    private Integer appId;
    /**
     * 平台名称
     */
    private String appNme;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 失败原因
     */
    private String failCause;
    /**
     * 失败处理
     */
    private String failProcess;
    /**
     * 记录id
     */
    private Long id;
    /**
     * 期限
     */
    private Integer limits;
    /**
     * 主订单id
     */
    private Long mId;
    /**
     * 主订单号
     */
    private String mNo;
    /**
     * 已匹配单数
     */
    private Long matcheds;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 关联原单号
     */
    private String orderNo;
    /**
     *
     */
    private String orderTime;
    /**
     *
     */
    private String orginalNo;
    /**
     *
     */
    private String personalName;
    /**
     * 提交时间
     */
    private String postTime;
    /**
     * 其他属性
     */
    private String properties;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 剩余未匹配金额
     */
    private BigDecimal surplus;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppNme() {
        return appNme;
    }

    public void setAppNme(String appNme) {
        this.appNme = appNme;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFailCause() {
        return failCause;
    }

    public void setFailCause(String failCause) {
        this.failCause = failCause;
    }

    public String getFailProcess() {
        return failProcess;
    }

    public void setFailProcess(String failProcess) {
        this.failProcess = failProcess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmNo() {
        return mNo;
    }

    public void setmNo(String mNo) {
        this.mNo = mNo;
    }

    public Long getMatcheds() {
        return matcheds;
    }

    public void setMatcheds(Long matcheds) {
        this.matcheds = matcheds;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrginalNo() {
        return orginalNo;
    }

    public void setOrginalNo(String orginalNo) {
        this.orginalNo = orginalNo;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }
}
