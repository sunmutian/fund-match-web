package com.jhh.match.controller;

import com.jhh.match.params.req.FundPlatformModifyReq;
import com.jhh.match.params.req.FundPlatformQueryReq;
import com.jhh.match.params.req.LoanPlatformQueryReq;
import com.jhh.match.params.result.*;
import com.jhh.match.service.FundPlatformService;
import com.jhh.match.utils.DateUtil;
import com.jhh.match.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 资金平台信息
 *
 * @author tianweichang
 * @create 2017-10-24 9:56
 **/
@RestController
public class FundPlatformController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private FundPlatformService fundPlatformService;

    /**
     * 创建平台
     */
    @RequestMapping(value = "/v1/app", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public TResult creaete(@RequestBody String json) {
        try {
            return fundPlatformService.createPlatform(json);
        } catch (Exception ex) {
            logger.error("exception:{}", ex);
            return new Result("failed", "系统繁忙，请稍后重试");
        }
    }


    /**
     * 修改平台信息
     */
    @RequestMapping(value = "/v1/app/modify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public TResult modify(@RequestBody String json) {
        FundPlatformModifyReq fundPlatformModifyReq = JsonUtil.convert2Object(json, FundPlatformModifyReq.class);
        return fundPlatformService.modifyPlatform(fundPlatformModifyReq);
    }

    /**
     * 获取平台信息列表
     *
     * @param type      1:出借平台，2:借款平台
     * @param name      平台名称
     * @param startTime 开始时间
     * @param endTime   结束时间
     */
    @RequestMapping(value = "/v1/app/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public TResult appList(Integer type, String name, String startTime, String endTime) {
        FundPlatformQueryReq fundPlatformQueryReq = new FundPlatformQueryReq();
        fundPlatformQueryReq.setType(type);
        if (!StringUtils.isEmpty(name)) {
            fundPlatformQueryReq.setName(name);
        }
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            fundPlatformQueryReq.setStartTime(DateUtil.convertStrToDate(startTime, DateUtil.DEFAULT_FORMAT));
            fundPlatformQueryReq.setEndTime(DateUtil.convertStrToDate(endTime, DateUtil.DEFAULT_FORMAT));
        }
        return fundPlatformService.platformList(fundPlatformQueryReq);
    }

    /**
     * 获取平台信息
     */
    @RequestMapping(value = "/v1/app", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public TResult get(Long id) {
        return fundPlatformService.getPlatform(id);
    }

    /**
     * 借贷平台查询
     */
    @RequestMapping(value = "/v1/debit", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public TResult searchDebit(HttpServletRequest request) {
        return fundPlatformService.searchDebit();
    }

    /**
     * 出借平台查询
     */
    @RequestMapping(value = "/v1/loan", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public TResult searchLoan(HttpServletRequest request) {
        LoanPlatformQueryReq loanPlatformQueryReq = new LoanPlatformQueryReq();
        return fundPlatformService.searchLoan(loanPlatformQueryReq);
    }

    /**
     * 查询所有出借人和借款人
     */
    @RequestMapping(value = "/v1/lists/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public PlatformList allList() {
        return fundPlatformService.allList();
    }
}
