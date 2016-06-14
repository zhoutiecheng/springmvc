package com.zhoutc.springmvc.http;

import com.zhoutc.springmvc.util.AlgorithmUtil;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoutc on 2016/6/14.
 */
public class TestHttp {

    public static void main(String[] args) {
        testMPGoods();
    }

    public static void testMPGoods(){
        String mopin_goods_url = "http://115.238.91.240:10362/fm-market-debug/common/quotation";

        Map<String,String> map = new HashMap<>();
        String time = String.valueOf(System.currentTimeMillis());
        String api_key = "AYiZxwvT6IDeSffqWRaCyre9FDGQy5IT";
        String cpUser = "200266";
        map.put("cpUser",cpUser);
        map.put("time", time);
        //cpUser+time+api_key
        map.put("sign", AlgorithmUtil.MD5(cpUser + time + api_key));

        CloseableHttpAsyncClient httpClient = FastHttpUtils.getClient(3000);
        try {
            String result = FastHttpUtils.executeGetReturnString( httpClient, mopin_goods_url, map);
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
