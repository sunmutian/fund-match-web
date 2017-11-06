package com.jhh.match.params.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 借贷信息
 *
 * @author tianweichang
 * @create 2017-10-23 19:20
 **/
public class DebitOrderResult implements Serializable{
    private static final long serialVersionUID = -8224683790710195067L;
    /**
     * 平台id
     */
    private Integer appId;
    /**
     * 平台名称
     */
    private String appName;
    /**
     * 银行
     */
    private String bank;
    /**
     * 银行支行
     */
    private String bankBrance;
    /**
     * 卡号
     */
    private String bankCardNo;
    /**
     * 银行预留手机
     */
    private String bankMobile;
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
    private String id;
    /**
     * 期限
     */
    private Integer limits;
    /**
     * 匹配流水号
     */
    private String matchedOrderNo;
    /**
     * 匹配时间
     */
    private String matchedTime;
    /**
     * 借贷金额
     */
    private String moeny;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单时间
     */
    private String orderTime;
    /**
     * 姓名
     */
    private String personalName;
    /**
     * 其他属性
     */
    private String properties;
    /**
     * 利率
     */
    private BigDecimal rate;
    /**
     * 订单状态
     */
    private Integer state;
    /**
     * 出借信息
     */
    private LoanOrderResult loanOrder;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankBrance() {
        return bankBrance;
    }

    public void setBankBrance(String bankBrance) {
        this.bankBrance = bankBrance;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankMobile() {
        return bankMobile;
    }

    public void setBankMobile(String bankMobile) {
        this.bankMobile = bankMobile;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    public String getMatchedOrderNo() {
        return matchedOrderNo;
    }

    public void setMatchedOrderNo(String matchedOrderNo) {
        this.matchedOrderNo = matchedOrderNo;
    }

    public String getMatchedTime() {
        return matchedTime;
    }

    public void setMatchedTime(String matchedTime) {
        this.matchedTime = matchedTime;
    }

    public String getMoeny() {
        return moeny;
    }

    public void setMoeny(String moeny) {
        this.moeny = moeny;
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

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LoanOrderResult getLoanOrder() {
        return loanOrder;
    }

    public void setLoanOrder(LoanOrderResult loanOrder) {
        this.loanOrder = loanOrder;
    }
}
