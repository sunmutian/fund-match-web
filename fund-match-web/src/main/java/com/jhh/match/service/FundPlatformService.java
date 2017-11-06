package com.jhh.match.service;


import com.jhh.match.params.req.FundPlatformModifyReq;
import com.jhh.match.params.req.FundPlatformQueryReq;
import com.jhh.match.params.req.LoanPlatformQueryReq;
import com.jhh.match.params.result.PageList;
import com.jhh.match.params.result.PlatformList;
import com.jhh.match.params.result.TResult;

/**
 * 资金平台
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
public interface FundPlatformService {
    /**
     * 创建平台
     */
    TResult createPlatform(String json);

    /**
     * 更新平台
     */
    TResult modifyPlatform(FundPlatformModifyReq fundPlatformModifyReq);

    /**
     * 获取平台信息列表
     */
    TResult platformList(FundPlatformQueryReq fundPlatformQueryReq);

    /**
     * 获取平台信息
     */
    TResult getPlatform(Long id);

    /**
     * 借贷平台查询
     */
    TResult searchDebit();

    /**
     * 出借平台查询
     */
    TResult<PageList> searchLoan(LoanPlatformQueryReq loanPlatformQueryReq);

    PlatformList allList();
}
