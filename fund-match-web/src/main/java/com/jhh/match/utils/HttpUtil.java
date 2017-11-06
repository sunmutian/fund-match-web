package com.jhh.match.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * http请求工具栏
 *
 * @author tianweichang
 * @create 2017-10-23 17:50
 **/
public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);    //日志记录

    /**
     * httpPost
     *
     * @param url       路径
     * @param jsonParam 参数
     * @return
     */
    public static String httpPost(String url, String jsonParam) {
        return httpPost(url, jsonParam, false);
    }

    /**
     * httpPut
     *
     * @param url       路径
     * @param jsonParam 参数
     * @return
     */
    public static String httpPut(String url, String jsonParam) {
        return httpPut(url, jsonParam, false);
    }

    /**
     * post请求
     *
     * @param url            请求地址
     * @param jsonParam      参数
     * @param noNeedResponse 不需要返回结果
     * @return 返回结果
     */
    public static String httpPost(String url, String jsonParam, boolean noNeedResponse) {

        logger.info("请求参数{}", jsonParam);
        HttpClient httpClient = new DefaultHttpClient();
        String ret = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            if (result == null || result.getStatusLine() == null) {
                logger.error("post请求提交失败:" + url);
                return null;
            }
//            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {

                try {
                    /**读取服务器返回过来的json字符串数据**/
                    ret = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    logger.info("返回结果{}", ret);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return ret;
    }

    /**
     * put请求
     *
     * @param url            请求地址
     * @param jsonParam      参数
     * @param noNeedResponse 不需要返回结果
     * @return 返回结果
     */
    public static String httpPut(String url, String jsonParam, boolean noNeedResponse) {

        logger.info("请求参数{}", jsonParam);
        HttpClient httpClient = new DefaultHttpClient();
        String ret = null;
        HttpPut method = new HttpPut(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded;charset=utf-8");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {

                try {
                    /**读取服务器返回过来的json字符串数据**/
                    ret = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    logger.info("返回结果{}", ret);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return ret;
    }

    public static String httpForm(String url, Map<String, Object> params, String method) {
        URL u;
        HttpURLConnection con = null;
        // 构建请求参数
        String paramsStr = "";
        StringBuilder stringBuilder = new StringBuilder("");
        if (params != null) {
            for (Entry<String, Object> e : params.entrySet()) {
                stringBuilder.append(e.getKey());
                stringBuilder.append("=");
                stringBuilder.append(e.getValue());
                stringBuilder.append("&");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
//            stringBuilder.substring(0, stringBuilder.length() - 1);
            paramsStr = stringBuilder.toString();
        }
        logger.info("request url:{}", url);
        logger.info("request url:[{}] data:{}", url, paramsStr);
        // 尝试发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod(method);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(paramsStr);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            logger.error("http 请求失败:{}", e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // 读取返回内容
        String result = null;
        StringBuilder buffer = new StringBuilder();
        try {
            //一定要有返回值，否则无法把请求发送给server端。
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
            result = buffer.toString();
            logger.info("url:[{}]response data:{}", url, result);
        } catch (Exception e) {
            logger.error("http 返回参数解析失败:{}", e);
        }

        return result;

    }

    /**
     * 发送get请求
     *
     * @param url 请求地址
     * @return 返回结果
     */
    public static String httpGet(String url) {
        logger.info("请求参数{}", url);
        //get请求返回结果
        String jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 200) {
                /**读取服务器返回过来的json字符串数据**/
                jsonResult = EntityUtils.toString(response.getEntity());
                logger.info("返回结果{}", jsonResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return jsonResult;
    }

   /* public static void main(String[] args) {
        String url = "http://172.16.100.116:8080/dist";
//       httpPost(url,"");
        System.out.println(httpGet(url));
    }*/
}
