package com.jhh.match.controller;

import com.jhh.match.params.req.FundPlatformMatchReq;
import com.jhh.match.params.req.LoanPlatformQueryReq;
import com.jhh.match.params.req.MatchPlatformCreateParam;
import com.jhh.match.params.result.PageList;
import com.jhh.match.params.result.TResult;
import com.jhh.match.service.FundPlatformMatchService;
import com.jhh.match.service.FundPlatformService;
import com.jhh.match.utils.DateUtil;
import com.jhh.match.utils.JsonUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 资金平台配对管理
 *
 * @author tianweichang
 * @create 2017-10-24 13:35
 **/
@RestController
public class FundPlatformMatchManagementController {

    @Resource
    private FundPlatformMatchService fundPlatformMatchService;
    @Resource
    private FundPlatformService fundPlatformService;

    /**
     * 获取匹配列表
     *
     * @param tarName   出借人名称
     * @param srcName   借款人名称
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param enabled   是否可用
     * @param page      页码
     */
    @RequestMapping(value = "/v1/app_ref/list", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public TResult queryMatchManagementList(String tarName, String srcName, String startTime, String endTime, Integer enabled, Integer page) {
        FundPlatformMatchReq fundPlatformMatchReq = new FundPlatformMatchReq();
        if (!StringUtils.isEmpty(srcName)) {
            fundPlatformMatchReq.setSrcName(srcName);
        }
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            Date ds = DateUtil.convertStrToDate(startTime);
            Date de = DateUtil.convertStrToDate(endTime);
            if (ds.getTime() >= de.getTime()) {
                return new TResult("unknown", "请正确选择查询时间");
            }
            fundPlatformMatchReq.setStartTime(ds);
            fundPlatformMatchReq.setEndTime(de);
        }
        if ((!StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) || (StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime))) {
            return new TResult("unknown", "请正确选择查询时间");
        }
        fundPlatformMatchReq.setEnabled(enabled);

        return fundPlatformMatchService.fundPlatformMatchList(fundPlatformMatchReq);
    }

    //暂时无用
    @RequestMapping(value = "/v1/app_ref/list/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public TResult queryMatchManagementById(@PathVariable("id") Long id) {
        return fundPlatformMatchService.queryMatchManagementById(id);
    }

    /**
     * 借出匹配
     *
     * @param name      出借人名字
     * @param cardNo    身份证号码
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param orderNo   流水号
     * @param state     状态
     */
    @RequestMapping(value = "/v1/loan/search", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public TResult loanMatchWait(String name, String cardNo, String startTime, String endTime, String orderNo, Integer state, Integer page, Long appId) {
        if (page == null) {
            page = 1;
        }
        LoanPlatformQueryReq loanPlatformQueryReq = new LoanPlatformQueryReq();
        loanPlatformQueryReq.setCardNo(cardNo);
        TResult<PageList> result = fundPlatformService.searchLoan(loanPlatformQueryReq);
        result.setCurrentPage(page);//当前页码
        // TODO: 2017/11/6  分页查询  待与后台联调
        result.setPageCount(10);//总页数
        result.setTatol(100l);//总条数
        return result;
    }

    /**
     * 创建匹配
     */
    @RequestMapping(value = "/match", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public TResult createPlatformMatch(@RequestBody String json) {
        MatchPlatformCreateParam matchPlatformCreateParam = JsonUtil.convert2Object(json, MatchPlatformCreateParam.class);
        return fundPlatformMatchService.createFundPlatformMatch(matchPlatformCreateParam);
    }

    /**
     * 删除匹配
     */
    @RequestMapping(value = "/deleteMatch", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public TResult deleteMatch(@RequestBody String json) {
        LoanPlatformQueryReq loanPlatform = JsonUtil.convert2Object(json, LoanPlatformQueryReq.class);
        return fundPlatformMatchService.onOrOffFundPlatformMatch(loanPlatform.getAppId(), false, RequestMethod.DELETE.name());
    }

    /**
     * 匹配开关
     */
    @RequestMapping(value = "/onOff", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public TResult onOff(@RequestBody String json) {
        LoanPlatformQueryReq loanPlatform = JsonUtil.convert2Object(json, LoanPlatformQueryReq.class);
        return fundPlatformMatchService.onOrOffFundPlatformMatch(loanPlatform.getAppId(), loanPlatform.getEnabled(), RequestMethod.PUT.name());
    }

    /**
     * 修改匹配
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public TResult modifyPlatformMatch(@RequestBody String json) {
        MatchPlatformCreateParam matchPlatformCreateParam = JsonUtil.convert2Object(json, MatchPlatformCreateParam.class);
        return fundPlatformMatchService.createFundPlatformMatch(matchPlatformCreateParam);
    }

    /**
     * 修改匹配--页面显示
     *
     * @param srcAppId 借款人id
     */
    @RequestMapping(value = "/modify/{srcAppId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public TResult modifyPlatformMatchView(@PathVariable("srcAppId") Long srcAppId) {
        return fundPlatformMatchService.queryMatchManagementBySrcAppId(srcAppId);
    }
}
