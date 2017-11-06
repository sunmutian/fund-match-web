package com.jhh.match.service;

import com.jhh.match.params.result.Result;
import com.jhh.match.params.result.TResult;
import org.springframework.beans.factory.annotation.Value;

/**
 * 实现类父类
 *
 * @author tianweichang
 * @create 2017-10-23 19:40
 **/
public class BaseService {
    @Value("${url}")
    protected String url;

    /**
     * 返回码校验
     * @param result
     * @return
     */
    protected Boolean checkResultCode(Result result) {
        if (result == null) {
            return false;
        }
        return Result.SUCCESS.equals(result.getCode()) ? true : false;
    }
    /**
     * 返回码校验
     * @param result
     */
    protected TResult checkResultCode(TResult result) {
        if (result == null) {
            return null;
        }
        if(!TResult.SUCCESS.equals(result.getCode())){
            return new TResult(result.getCode(), result.getMsg());
        }
        return result;
    }
}
