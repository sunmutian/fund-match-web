package com.jhh.match.params.req;

import java.io.Serializable;

/**
 * 资金平台创建请求参数
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
public class FundPlatformCreateReq implements Serializable{
    private static final long serialVersionUID = -3585587079290785368L;
    /**
     * 平台名称
     */
    private String name;
    /**
     * 平台类型
     */
    private String type;
    /**
     * 企业名称
     */
    private String enterprise;
    /**
     * 通信队列名
     */
    private String queue_name;
    /**
     * 队列路由名
     */
    private String routing_key;
    /**
     * 通知地址
     */
    private String notification_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getQueue_name() {
        return queue_name;
    }

    public void setQueue_name(String queue_name) {
        this.queue_name = queue_name;
    }

    public String getRouting_key() {
        return routing_key;
    }

    public void setRouting_key(String routing_key) {
        this.routing_key = routing_key;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }
}
