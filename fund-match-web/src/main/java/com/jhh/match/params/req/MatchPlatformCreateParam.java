package com.jhh.match.params.req;

import java.io.Serializable;

/**
 * 创建匹配请求参数
 *
 * @author tianweichang
 * @create 2017-10-31 17:22
 **/
public class MatchPlatformCreateParam implements Serializable {
    private static final long serialVersionUID = 8321353549690805121L;
    /**
     * 出借人平台id
     */
    private Long srcAppId;
    /**
     * 借款平台id(单个)
     */
    private Long tarAppId;
    /**
     * 借款平台id(多个)
     */
    private String[] tarAppIds;

    public String[] getTarAppIds() {
        return tarAppIds;
    }

    public void setTarAppIds(String[] tarAppIds) {
        this.tarAppIds = tarAppIds;
    }

    public Long getSrcAppId() {
        return srcAppId;
    }

    public void setSrcAppId(Long srcAppId) {
        this.srcAppId = srcAppId;
    }

    public Long getTarAppId() {
        return tarAppId;
    }

    public void setTarAppId(Long tarAppId) {
        this.tarAppId = tarAppId;
    }
}
