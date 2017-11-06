package com.jhh.match.service.impl;

import com.jhh.match.params.req.FundPlatformCreateReq;
import com.jhh.match.params.req.FundPlatformModifyReq;
import com.jhh.match.params.req.FundPlatformQueryReq;
import com.jhh.match.params.req.LoanPlatformQueryReq;
import com.jhh.match.params.result.*;
import com.jhh.match.service.BaseService;
import com.jhh.match.service.FundPlatformService;
import com.jhh.match.utils.DateUtil;
import com.jhh.match.utils.HttpUtil;
import com.jhh.match.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资金平台
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
@Service("fundPlatformService")
public class FundPlatformServiceImpl extends BaseService implements FundPlatformService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TResult createPlatform(String json) {
        if (StringUtils.isEmpty(json)) {
            return new Result("failed", "系统繁忙，请稍后重试");
        }
        FundPlatformCreateReq fundPlatformCreateReq = JsonUtil.convert2Object(json, FundPlatformCreateReq.class);
        Map<String, Object> params = new HashMap<>();
        params.put("type", fundPlatformCreateReq.getType());
        params.put("name", fundPlatformCreateReq.getName());
        params.put("enterprise", fundPlatformCreateReq.getEnterprise());
        String retJson = HttpUtil.httpForm(url + "v1/app", params, "POST");

        if (StringUtils.isEmpty(retJson)) {
            return new Result("failed", "系统繁忙，请稍后重试");
        }
        TResult result = JsonUtil.convertField(retJson, TResult.class);
        if (result != null && TResult.SUCCESS.equals(result.getCode())) {
            return result;
        }
        return new Result("failed", "系统繁忙，请稍后重试");
    }

    @Override
    public TResult modifyPlatform(FundPlatformModifyReq fundPlatformModifyReq) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", fundPlatformModifyReq.getId());
        params.put("name", fundPlatformModifyReq.getName());
        params.put("enterprise", fundPlatformModifyReq.getEnterprise());
        String retJson = HttpUtil.httpForm(url + "v1/app", params, "PUT");

        if (StringUtils.isEmpty(retJson)) {
            return new Result("", "");
        }
        TResult result = JsonUtil.convertField(retJson, TResult.class);
        if (result != null && TResult.SUCCESS.equals(result.getCode())) {
            return result;
        }
        return result;
    }

    @Override
    public TResult platformList(FundPlatformQueryReq fundPlatformQueryReq) {
        String param = getPlatformListParams(fundPlatformQueryReq);
        String retJson = HttpUtil.httpGet(url + "v1/app/list" + param);

        if (StringUtils.isEmpty(retJson)) {
            return new TResult<List<AppResult>>("unknown", "系统繁忙");
        }

        TResult<List<AppResult>> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (checkResultCode(result) == null) {
            return new TResult("unknown", "系统繁忙");
        }
        String str = JsonUtil.convert2Json(result.getResult());
        List<AppResult> list = JsonUtil.convert2Json(str, AppResult.class);
        for (AppResult app : list) {
            app.setPostTimeStr(app.getPostTimeStr());
        }
        TResult<List<AppResult>> resultStr = new TResult<>("success", "");
        resultStr.setResult(list);
        return resultStr;
    }

    private String getPlatformListParams(FundPlatformQueryReq fundPlatformQueryReq) {
        StringBuilder ret = new StringBuilder();
        ret.append("?type=").append(fundPlatformQueryReq.getType());
        if (fundPlatformQueryReq.getEndTime() != null && fundPlatformQueryReq.getStartTime() != null) {
            ret.append("&start_time=").append(DateUtil.convertDateToString(fundPlatformQueryReq.getStartTime(), DateUtil.FULL_FORMAT));
            ret.append("&end_time=").append(DateUtil.convertDateToString(fundPlatformQueryReq.getEndTime(), DateUtil.FULL_FORMAT));
        }
        if (!StringUtils.isEmpty(fundPlatformQueryReq.getName())) {
            ret.append("&name=").append(fundPlatformQueryReq.getName());
        }
        return ret.toString();
    }

    @Override
    public TResult getPlatform(Long id) {
        String retJson = HttpUtil.httpGet(url + "v1/app/" + id);
        if (StringUtils.isEmpty(retJson)) {
            return new TResult("unknown", "unknown");
        }
        TResult<AppResult> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (result == null) {
            return new TResult("unknown", "unknown");
        }
        TResult<AppResult> ret = new TResult<>("success", "success");
        if (result.getResult() == null) {
            return new TResult("unknown", "unknown");
        }
        String js = JsonUtil.convert2Json(result.getResult());
        AppResult appResult = JsonUtil.convertField(js, AppResult.class);
        ret.setResult(appResult);
        return ret;
    }

    @Override
    public TResult searchDebit() {

        String retJson = HttpUtil.httpGet(url + "v1/debit/search");

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("", "");
        }
        TResult<PageList> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (result == null) {
            return new TResult();
        }
        return new TResult(result.getCode(), result.getMsg());
    }

    @Override
    public TResult<PageList> searchLoan(LoanPlatformQueryReq loanPlatformQueryReq) {


        // TODO: 2017/10/27 测试数据
        TResult<PageList> test = new TResult<>("success","success");
        PageList pl = new PageList();
        List<LoanOrderResult> list = new ArrayList<>();
        LoanOrderResult lo = new LoanOrderResult();
        lo.setAppNme("HAH借出");
        lo.setAppId(1);
        lo.setCardNo("6524555199909091234");
        lo.setFailCause("aaa");
        lo.setFailProcess("");
        lo.setId(1111l);
        lo.setLimits(10);
        lo.setMatcheds(100l);
        lo.setmId(99l);
        lo.setmNo("009101");
        lo.setMoney(new BigDecimal("10.22"));
        lo.setOrderNo("09109");
        lo.setOrderTime("20171027");
        lo.setPersonalName("lisi");
        lo.setPostTime("20171027");
        lo.setProperties("prop");
        lo.setState(1);
        lo.setSurplus(new BigDecimal("22.10"));
        list.add(lo);

        pl.setList(list);
        test.setResult(pl);
        if (true) {
            return test;
        }
        //10=等待匹配 20=匹配中 30=已匹配 40=打款成功 50=打款失败
        int state=10;
        String retJson = HttpUtil.httpGet(url + "v1/loan/search");
        if (StringUtils.isEmpty(retJson)) {
            return new TResult("", "");
        }
        TResult<PageList> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (checkResultCode(result) == null) {
            return new TResult();
        }
        return new TResult(result.getCode(), result.getMsg());
    }

    @Override
    public PlatformList allList() {
        PlatformList platformList = new PlatformList("success","");
        List<AppResult> srcAppList = getList(1);
        List<AppResult> tarAppList = getList(2);
        platformList.setSrcAppList(srcAppList);
        platformList.setTarAppList(tarAppList);
        return platformList;
    }

    private List<AppResult> getList(Integer type) {
        String retJson = HttpUtil.httpGet(url + "v1/app/list?type=" + type);

        if (StringUtils.isEmpty(retJson)) {
            return null;
        }
        TResult<List<AppResult>> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (checkResultCode(result) == null) {
            return null;
        }
        String str = JsonUtil.convert2Json(result.getResult());
        return JsonUtil.convert2Json(str, AppResult.class);
    }

}
