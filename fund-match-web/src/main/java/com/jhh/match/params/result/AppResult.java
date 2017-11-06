package com.jhh.match.params.result;


import com.jhh.match.utils.DateUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 平台信息
 *
 * @author tianweichang
 * @create 2017-10-23 19:12
 **/
public class AppResult implements Serializable {
    private static final long serialVersionUID = 766194554815617319L;
    /**
     * 平台类型
     */
    private Integer appType;

    private String appTypeStr;
    /**
     * 企业名称
     */
    private String enterprise;

    /**
     * 平台id
     */
    private Long id;
    /**
     * 已匹配金额
     */
    private BigDecimal matchedMoney;
    /**
     * 平台名称
     */
    private String name;
    /**
     * 通知url
     */
    private String notificationUrl;
    /**
     * 最后操作时间
     */
    private Long postTime;

    private String postTimeStr;
    /**
     * 操作人
     */
    private String postUser;
    /**
     * 通知队列名
     */
    private String queueName;
    /**
     * 通知路由key
     */
    private String routingKey;
    /**
     * 匹配总金额
     */
    private BigDecimal totalMoney;
    /**
     * 匹配总数
     */
    private Long totals;
    /**
     * 未匹配金额
     */
    private BigDecimal unmatchMoney;
    /**
     * 匹配总人数
     */
    private Long users;
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAppTypeStr() {
        if(this.appType==null){
            return "";
        }
        return this.appType == 1 ? "出借" : "借款";
    }

    public void setAppTypeStr(String appTypeStr) {
        this.appTypeStr = appTypeStr;
    }

    public String getPostTimeStr() {
        if (this.postTime == null || this.postTime == 0) {
            return null;
        }
        return DateUtil.convertDateToStr(this.postTime);
    }

    public void setPostTimeStr(String postTimeStr) {
        this.postTimeStr = postTimeStr;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMatchedMoney() {
        return matchedMoney;
    }

    public void setMatchedMoney(BigDecimal matchedMoney) {
        this.matchedMoney = matchedMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }

    public BigDecimal getUnmatchMoney() {
        return unmatchMoney;
    }

    public void setUnmatchMoney(BigDecimal unmatchMoney) {
        this.unmatchMoney = unmatchMoney;
    }

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }
}
