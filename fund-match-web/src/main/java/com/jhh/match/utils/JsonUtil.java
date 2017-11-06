package com.jhh.match.utils;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * json工具栏
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
public class JsonUtil {


    /**
     * 下划线转驼峰
     *
     * @param json  "{\"user_name\":\"bflee\",\"id_number\":\"123456\"}";
     * @param clazz userName,bflee,idNumber
     * @return 对象
     */
    public static <T> T convertField(String json, Class<T> clazz) {
        T reqJson = null;
        if (StringUtils.isEmpty(json)) {
            return reqJson;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            reqJson = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reqJson;
    }

    /**
     * 驼峰转下划线
     *
     * @param object userName,bflee,idNumber
     * @return json "{\"user_name\":\"bflee\",\"id_number\":\"123456\"}";
     */
    public static String beanToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对象转json
     *
     * @param object
     * @return json
     */
    public static String convert2Json(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 对象转json
     *
     * @return json
     */
    public static <T> List<T> convert2Json(String text, Class<T> clazz) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        return JSON.parseArray(text, clazz);
    }

    public static <T> T convert2Object(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /*public static void main(String[] args) {
        TResult<List<AppResult>> tResult = new TResult<List<AppResult>>("success", "DDDDD");
        List list = new ArrayList();
        AppResult appResult = new AppResult();
        appResult.setId(1111l);
        appResult.setAppType(1);
        appResult.setName("zhangsna");
        list.add(appResult);
        tResult.setResult(list);
        String json = beanToJson(tResult);
        System.out.println(json);
        TResult<List<AppResult>> re = (TResult) convertField(json, TResult.class);
        System.out.println(re.getCode());
    }*/
}
