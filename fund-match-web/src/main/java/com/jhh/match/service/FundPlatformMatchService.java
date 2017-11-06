package com.jhh.match.service;


import com.jhh.match.params.req.FundPlatformMatchReq;
import com.jhh.match.params.req.MatchPlatformCreateParam;
import com.jhh.match.params.result.TResult;

/**
 * 资金平台配对
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
public interface FundPlatformMatchService {

    /**
     * 创建资金平台配对
     */
    TResult createFundPlatformMatch(MatchPlatformCreateParam matchPlatformCreateParam);

    /**
     * 获取平台配对列表
     */
    TResult fundPlatformMatchList(FundPlatformMatchReq fundPlatformMatchReq);
    /**
     * 获取平台配对通过id
     */
    TResult queryMatchManagementById(Long id);

    /**
     * 开闭平台配对
     */
    TResult onOrOffFundPlatformMatch(Long id, Boolean enabled, String requestMethod);

    /**
     * 配对单查询
     */
    TResult queryMatchOrders(String no);

    /**
     * 获取平台配对通过srcAppId
     */
    TResult queryMatchManagementBySrcAppId(Long srcAppId);
}
