package com.jhh.match.service.impl;

import com.jhh.match.params.req.FundPlatformMatchReq;
import com.jhh.match.params.req.MatchPlatformCreateParam;
import com.jhh.match.params.result.*;
import com.jhh.match.service.BaseService;
import com.jhh.match.service.FundPlatformMatchService;
import com.jhh.match.utils.DateUtil;
import com.jhh.match.utils.HttpUtil;
import com.jhh.match.utils.JsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资金平台配对实现类
 *
 * @author tianweichang
 * @create 2017-10-24 10:44
 **/
@Service("fundPlatformMatchService")
public class FundPlatformMatchServiceImpl extends BaseService implements FundPlatformMatchService {

    @Override
    public TResult createFundPlatformMatch(MatchPlatformCreateParam matchPlatformCreateParam) {
        StringBuilder tarAppIds = new StringBuilder();
        String[] sts = matchPlatformCreateParam.getTarAppIds();
        for (int i = 0; i < sts.length; i++) {
            if (i == 0) {
                tarAppIds.append(sts[i]);
            } else {
                tarAppIds.append(",").append(sts[i]);
            }
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("src_app_id", matchPlatformCreateParam.getSrcAppId());
        paramMap.put("tar_app_ids", tarAppIds.toString());

        String retJson = HttpUtil.httpForm(url + "v1/app_ref", paramMap, "POST");

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("unknown", "创建失败");
        }
        TResult result = JsonUtil.convert2Object(retJson, TResult.class);
        if (result == null) {
            return new TResult("unknown", "创建失败");
        }
        if (!TResult.SUCCESS.equals(result.getCode())) {
            return new TResult("unknown", result.getMsg());
        }
        return result;
    }

    @Override
    public TResult fundPlatformMatchList(FundPlatformMatchReq fundPlatformMatchReq) {

        TResult<List<AppMatches>> ret = new TResult(TResult.SUCCESS, "操作成功");
        StringBuilder condition = new StringBuilder();
        if (!StringUtils.isEmpty(fundPlatformMatchReq.getSrcName())) {
            condition.append("src_name=").append(fundPlatformMatchReq.getSrcName());
        }
        if (fundPlatformMatchReq.getStartTime() != null & fundPlatformMatchReq.getEndTime() != null) {
            if (condition.length() > 0) {
                condition.append("&");
            }
            condition.append("start_time=").append(fundPlatformMatchReq.getStartTime().getTime());
            condition.append("&end_time=").append(fundPlatformMatchReq.getEndTime().getTime());
        }
        if (fundPlatformMatchReq.getEnabled() != null && fundPlatformMatchReq.getEnabled() > 0 && fundPlatformMatchReq.getEnabled() < 3) {
            if (condition.length() > 0) {
                condition.append("&");
            }
            condition.append("enabled=").append(fundPlatformMatchReq.getEnabled());
        }
        String queryCondition = "";
        if (condition.length() > 0) {
            queryCondition = "?" + condition.toString();
        }
        String retJson = HttpUtil.httpGet(url + "v1/app_ref/list" + queryCondition);

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("unknown", "系统繁忙");
        }
        TResult<List<AppRefResult>> tResult = (TResult) JsonUtil.convertField(retJson, TResult.class);

        String str = JsonUtil.convert2Json(tResult.getResult());
        List<AppRefResult> list = JsonUtil.convert2Json(str, AppRefResult.class);
        if (tResult == null) {
            return new TResult("unknown", "系统繁忙");
        }
        if (!TResult.SUCCESS.equals(tResult.getCode())) {
            return new TResult("unknown", tResult.getMsg());
        }
        ret.setResult((doConvertData(list)));
        return ret;
    }

    //数据转换成页面显示的类型
    private List<AppMatches> doConvertData(List<AppRefResult> appRefResults) {
        Map<String, AppMatches> map = new HashMap<>();
        for (AppRefResult appRefResult : appRefResults) {
            if (appRefResult == null) {
                continue;
            }
            String key = new String(appRefResult.getSrcAppId().toString());
            //第一个map元素或者第一次进入map的元素
            if (map.size() == 0 || map.get(key) == null) {
                map.put(key, getAppMatches(appRefResult));

                continue;
            }
            //map中已经悠存在srcAppId,然后把tarName拼凑起来
            AppMatches appMatches = map.get(key);
            StringBuilder stringBuilder = new StringBuilder(appMatches.getTarNames());
            stringBuilder.append("、").append(appRefResult.getTarApp().getName());
            appMatches.setTarNames(stringBuilder.toString());
            map.put(key, appMatches);
        }
        List<AppMatches> returnList = new ArrayList<>();

        for (AppMatches appMatches : map.values()) {
            returnList.add(appMatches);
        }
        return returnList;
    }

    private AppMatches getAppMatches(AppRefResult appRefResult) {
        AppMatches appMatches = new AppMatches();
        appMatches.setCreateTime(DateUtil.convertDateToString(appRefResult.getCreateTime(), DateUtil.DEFAULT_FORMAT));
        appMatches.setEnabled(appRefResult.getEnabled() == true ? "启用" : "未启用");
        appMatches.setEnableData(appRefResult.getEnabled() == true ? 0 : 1);
        appMatches.setSrcAppId(appRefResult.getSrcAppId());
        appMatches.setSrcName(appRefResult.getSrcApp().getName());
        appMatches.setTarNames(appRefResult.getTarApp().getName());
        return appMatches;
    }

    @Override
    public TResult queryMatchManagementById(Long id) {
        String retJson = HttpUtil.httpGet(url + "v1/app_ref/" + id);

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("unknown", "系统繁忙");
        }
        TResult<AppRefResult> tResult = (TResult) JsonUtil.convert2Object(retJson, TResult.class);
        String str = JsonUtil.convert2Json(tResult.getResult());
        AppRefResult appRefResults = JsonUtil.convert2Object(str, AppRefResult.class);
        if (appRefResults != null) {
            TResult tResult1 = new TResult("success", "系统繁忙");
            tResult1.setResult(appRefResults);
            return tResult1;
        }
        return new TResult("unknown", "系统繁忙");
    }

    @Override
    public TResult onOrOffFundPlatformMatch(Long id, Boolean enabled, String requestMethod) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        if (RequestMethod.PUT.name().equals(requestMethod)) {
            paramMap.put("enabled", enabled);
        }
        String retJson = HttpUtil.httpForm(url + "v1/app_ref/" + id, paramMap, requestMethod);

        if (StringUtils.isEmpty(retJson)) {
            return new Result("unknown", "操作失败");
        }
        TResult result = JsonUtil.convertField(retJson, TResult.class);
        if (result == null) {
            return new TResult("unknown", "操作失败");
        }
        if (!TResult.SUCCESS.equals(result.getCode())) {
            return new TResult("unknown", result.getMsg());
        }
        return result;
    }

    @Override
    public TResult queryMatchOrders(String no) {
        String retJson = HttpUtil.httpGet(url + "v1/loan/matched_debits?no=" + no);

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("", "");
        }
        TResult<List<AppResult>> result = (TResult) JsonUtil.convertField(retJson, TResult.class);
        if (result == null) {
            return new TResult();
        }
        return new TResult(result.getCode(), result.getMsg());
    }

    @Override
    public TResult queryMatchManagementBySrcAppId(Long srcAppId) {
        String retJson = HttpUtil.httpGet(url + "v1/app_ref/list_by_" + srcAppId);

        if (StringUtils.isEmpty(retJson)) {
            return new TResult("unknown", "系统繁忙");
        }
        TResult<List<AppRefResult>> tResult = (TResult) JsonUtil.convert2Object(retJson, TResult.class);
        String str = JsonUtil.convert2Json(tResult.getResult());
        List<AppRefResult> appRefResults = JsonUtil.convert2Json(str, AppRefResult.class);
        if (appRefResults != null) {
            TResult tResult1 = new TResult("success", "系统繁忙");
            tResult1.setResult(getAppMatches(appRefResults));
            return tResult1;
        }
        return new TResult("unknown", "系统繁忙");
    }

    private AppMatches getAppMatches(List<AppRefResult> appRefResults) {
        AppMatches appMatches = new AppMatches();
        if (appRefResults == null || appRefResults.size() == 0) {
            return appMatches;
        }
        appMatches.setSrcName(appRefResults.get(0).getSrcApp().getName());
        appMatches.setSrcAppId(appRefResults.get(0).getSrcAppId());
        int len = appRefResults.size();
        Integer[] tarAppIds = new Integer[len];
        for (int i = 0; i < len; i++) {
            tarAppIds[i] = appRefResults.get(i).getTarAppId();
        }
        appMatches.setTarAppIds(tarAppIds);
        return appMatches;
    }
}
