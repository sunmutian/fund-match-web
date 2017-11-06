package com.jhh.match.controller;

import com.jhh.match.enums.DebitMatchStateEnum;
import com.jhh.match.enums.LoanMatchStateEnum;
import com.jhh.match.params.req.FundPlatformQueryReq;
import com.jhh.match.params.result.AppResult;
import com.jhh.match.params.result.TResult;
import com.jhh.match.service.FundPlatformService;
import com.jhh.match.utils.ConstantsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 获取ftl模板文件
 *
 * @author tianweichang
 * @create 2017-10-27 11:18
 **/
@Controller
public class FtlFileController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private FundPlatformService fundPlatformService;


    /**
     * 平台信息
     */
    @RequestMapping("/platformInfoIndex")
    public String platformInfoIndex(Map<String, Object> model) {
        initSidebar(model);
        return ConstantsUtil.PLATFORM_INFO_INDEX;
    }

    /**
     * 出借平台
     *
     * @param id 平台id
     */
    @RequestMapping("/platformInfoLoan")
    public String platformInfoLoan(Map<String, Object> model, Long id) {
        model = initSidebar(model);
        model.put("nn", "aaaa");
        model.put("ddd", id);
        /*FundPlatformQueryReq fundPlatformQueryReq = new FundPlatformQueryReq();
        fundPlatformQueryReq.setType(1);
        TResult result = fundPlatformService.platformList(fundPlatformQueryReq);
        model.put("srcList", result.getResult());*/
        return ConstantsUtil.PLATFORM_INFO_LOAN;
    }

    /**
     * 借贷平台
     */
    @RequestMapping("/platformInfoDebit")
    public String platformInfoDebit(Map<String, Object> model) {
        initSidebar(model);
        return ConstantsUtil.PLATFORM_INFO_DEBIT;
    }

    /**
     * 匹配管理
     */
    @RequestMapping("/matchManagement")
    public String pairingManagement(Map<String, Object> model) {
        initSidebar(model);
        return ConstantsUtil.MATCH_MANAGEMENT;
    }

    /**
     * 出借匹配--全部
     */
    @RequestMapping("/loanMatchAll")
    public String loanMatchAll(Map<String, Object> model) {
        initSidebar(model);
        return ConstantsUtil.LOAN_MATCH_ALL;
    }

    /**
     * 出借匹配
     *
     * @param model model
     * @param id    appId
     * @param state 状态
     */
    @RequestMapping(value = "/loanMatchState", method = RequestMethod.GET)
    public String loanMatchState(Map<String, Object> model, Long id, Integer state) {
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        model.put("id", id);
        model.put("name", ((AppResult) result.getResult()).getName());
        initSidebar(model);
        String ret = LoanMatchStateEnum.getValueByState(state);
        return ret;
    }

    /**
     * 出借匹配--wait
     *
     * @param id 平台id
     */
    @RequestMapping(value = "/loanMatchWait", method = RequestMethod.GET)
    public String loanMatchWait(Map<String, Object> model, Long id) {
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        model.put("id", id);
        model.put("name", ((AppResult) result.getResult()).getName());
        initSidebar(model);
        return "loanMatchWait";
    }

    /**
     * 出借匹配
     *
     * @param id 平台id
     */
    @RequestMapping("/loanMatchIndex")
    public String laonMatchIndex(Map<String, Object> model, Long id) {
        initSidebar(model);
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        model.put("name", ((AppResult) result.getResult()).getName());
        model.put("id", id);
        return ConstantsUtil.LOAN_MATCH_INDEX;
    }

    /**
     * 借款匹配
     *
     * @param id    平台id
     * @param state 状态
     */
    @RequestMapping(value = "/debitMatchState", method = RequestMethod.GET)
    public String debitMatchState(Map<String, Object> model, Long id, Integer state) {
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        model.put("id", id);
        model.put("appName", ((AppResult) result.getResult()).getName());
        initSidebar(model);
        String ret = DebitMatchStateEnum.getValueByState(state);
        return ret;
    }

    /**
     * 出借匹配
     *
     * @param id 平台id
     */
    @RequestMapping("/debitMatchIndex")
    public String debitMatchIndex(Map<String, Object> model, Long id) {
        initSidebar(model);
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        model.put("appName", ((AppResult) result.getResult()).getName());
        model.put("id", id);
        return ConstantsUtil.DEBIT_MATCH_INDEX;
    }

    /**
     * 查看平台
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Map<String, Object> model, Long id, Integer state) {
        TResult<AppResult> result = fundPlatformService.getPlatform(id);
        if (result != null && result.getResult() != null) {
            model.put("matchedUsers", ((AppResult) result.getResult()).getUsers());
            model.put("enterprise", ((AppResult) result.getResult()).getEnterprise());
            model.put("createTime", ((AppResult) result.getResult()).getPostTimeStr());
            model.put("totalAmount", ((AppResult) result.getResult()).getTotalMoney());
            model.put("matchedAmount", ((AppResult) result.getResult()).getMatchedMoney());
            model.put("unMatchAmount", ((AppResult) result.getResult()).getUnmatchMoney());
            model.put("matchedTimes", ((AppResult) result.getResult()).getTotals());
            model.put("appName", ((AppResult) result.getResult()).getName());
        }
        initSidebar(model);
        return ConstantsUtil.PLATFORM_DETAIL;
    }

    /**
     * 初始化左边的菜单
     */
    private Map<String, Object> initSidebar(Map<String, Object> model) {
        FundPlatformQueryReq fundPlatformQueryReq = new FundPlatformQueryReq();
        fundPlatformQueryReq.setType(1);
        TResult<List<AppResult>> srcResult = fundPlatformService.platformList(fundPlatformQueryReq);
        model.put("list1", srcResult.getResult());
        fundPlatformQueryReq.setType(2);
        TResult<List<AppResult>> tarResult = fundPlatformService.platformList(fundPlatformQueryReq);
        model.put("list2", tarResult.getResult());
        return model;
    }
}
