package com.jhh.match.params.req;

import java.io.Serializable;

/**
 * 资金平台修改请求参数
 *
 * @author tianweichang
 * @create 2017-10-23 17:57
 **/
public class FundPlatformModifyReq implements Serializable{
    private static final long serialVersionUID = 35166988821208843L;
    /**
     * 平台id
     */
    private Long id;
    /**
     * 平台名称
     */
    private String name;
    /**
     * 企业名称
     */
    private String enterprise;
    /**
     * 通信队列名(不填则保留原有)
     */
    private String queue_name;
    /**
     * 队列路由名(不填则保留原有)
     */
    private String routing_key;
    /**
     * 通知地址(不填则保留原有)
     */
    private String notification_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
