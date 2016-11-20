package com.zhoutc.springmvc.http;

import com.alibaba.fastjson.JSONObject;
import com.zhoutc.springmvc.util.AlgorithmUtil;
import com.zhoutc.springmvc.util.StringUtil;
import com.zhoutc.springmvc.util.TripleDESUtil;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhoutc on 2016/6/14.
 */
public class TestHttp {

    public static void main(String[] args) {

        sentPush();
    }

    public static void sentPush() {
        String desc = "物业费缴纳通知";
        String title = "物业费缴纳成功";
        String content = "恭喜亲,您位于万龙家园1号楼1单元102的物业费已经缴纳至，如有任何疑问，请致电400-xxx-xxxx";
        long userId = 41874;
        String merchantId = "1011";
        String appPushUrl = "http://10.0.8.11/push/admin/sendnotice";
        pushMsg(userId, title, content, desc, merchantId, appPushUrl);
    }


    /**
     * push app通知
     *
     * @param title   　　　消息标题
     * @param content 　　消息内容
     * @param desc    　　　　消息概要
     * @param userId  　　　发送到用户
     */
    public static void pushMsg(long userId, String title, String content, String desc, String merchantId, String appPushUrl) {
        try {
            JSONObject json = new JSONObject();
            json.put("type", "rich_content");


            JSONObject contents = new JSONObject();
            contents.put("title", title);
            contents.put("content", content);
            contents.put("href", "");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
            contents.put("create_at", simpleDateFormat.format(new Date()));

            JSONObject data = new JSONObject();
            data.put("contents", contents);
            data.put("push_desc", desc);
            json.put("data", data);

            Map<String, String> param = new HashMap<>();

            param.put("touid", String.valueOf(userId));
            param.put("dataid", "50007");
            param.put("data", json.toJSONString());
            param.put("fromuid", merchantId);
            CloseableHttpAsyncClient httpClient = FastHttpUtils.getClient(3000);
            String result = FastHttpUtils.executePostReturnString(httpClient, appPushUrl, param);
            System.out.println("push app消息 uid:{} result:" + result);
        } catch (Exception e) {
            System.out.println("push app消息异常");
        }
    }

    public static void testMPGoods() {
        String mopin_goods_url = "http://115.238.91.240:10362/fm-market-debug/common/quotation";

        Map<String, String> map = new HashMap<>();
        String time = String.valueOf(System.currentTimeMillis());
        String api_key = "AYiZxwvT6IDeSffqWRaCyre9FDGQy5IT";
        String cpUser = "200266";
        map.put("cpUser", cpUser);
        map.put("time", time);
        //cpUser+time+api_key
        map.put("sign", AlgorithmUtil.MD5(cpUser + time + api_key));

        CloseableHttpAsyncClient httpClient = FastHttpUtils.getClient(3000);
        try {
            String result = FastHttpUtils.executeGetReturnString(httpClient, mopin_goods_url, map);
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public static void testLLQueryOrder() {
        String lianlian_url = "http://183.129.169.172:8080/common/query.json";
        String orderId = "8caac08d7c0d440892fc824c2597fd5f";
        JSONObject request = new JSONObject();
        TreeMap<String, String> all = new TreeMap<>();

        TreeMap<String, String> body = new TreeMap<>();
        body.put("order_no", orderId);
        body.put("order_type", "01");
        request.put("body", body);

        TreeMap<String, String> header = buildLLHeader();
        all.putAll(header);
        all.putAll(body);
        String serverSign = genSign(all, "9151E5642C0816EA");
        header.put("sign", serverSign);
        request.put("header", header);
        CloseableHttpAsyncClient httpClient = FastHttpUtils.getClient(3000);
        try {
            HttpPost httpPost = new HttpPost(lianlian_url);
            StringEntity xmlEntity = new StringEntity(request.toJSONString(),
                    ContentType.create("text/json", "UTF-8"));
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(xmlEntity);
            HttpCallbackHandler<String> handler = FastHttpUtils.executeMultiReturnStringHandler(
                    httpClient, httpPost);
            System.out.println(handler.get());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String genSign(TreeMap<String, String> param, String md5Key) {
        StringBuilder temp = new StringBuilder();
        Iterator sign = param.entrySet().iterator();

        while (sign.hasNext()) {
            Map.Entry entry = (Map.Entry) sign.next();
            temp.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("&");
        }

        if (temp.length() > 0) {
            temp.deleteCharAt(temp.length() - 1);
        }

        temp.append(md5Key);
        String sign1 = StringUtil.md5String(temp.toString());
        return sign1;
    }


    public static TreeMap<String, String> buildLLHeader() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("partner_id", "10310220");
        treeMap.put("orgcode", "KX0000");
        treeMap.put("agent_id", "sc0241");
        treeMap.put("password", TripleDESUtil.getInstance().encrypt("123!@#qwe", "9151E5642C0816EA"));
        treeMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        treeMap.put("sign_type", "MD5");
        return treeMap;
    }

}
