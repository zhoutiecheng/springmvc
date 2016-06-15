package com.zhoutc.springmvc.aes;



import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoutc on 2016/6/14.
 */
public class TestString {
    public static void main(String[] args) {
        encodeAes();

        List a = new ArrayList();
        a.add("1");
        a.add("sdsa");
        a.add("edd");
        a.add("dad");

        System.out.println(StringUtils.join(a, ""));
    }

    public static void decodeAes()  {
        String value = "d815b04d083f222547b71947ece23b7a849a54dc6dfb36cefd5d79bbeb10926accaa160cbf4c7949a561748f3f26e249251d125b15f781a655d8a4f769b9090f09ca85236f2cb1b3192127604295042127c831a3a16ea6bdd161b3c2a89c7b28753b70f86f6705ae9eddb77442c46c1b2a6b1c33f96f4d00ca696961eb7b3015d222eabf8bcf678fed8ac39753f8b1e4581314404485f5c9d49d65c3fdd26199980a50a54f0a7c0743cbe84b7aa9f5e347927edf89fa03fdf34012f1497431539d4cfe29d179f4f4bb2b1ece0d4da7cc73f6d48e3591d725b77f94313154e7c468bebb660933d5d58b31934b9ea71118";

        String reuslt = null;
        try {
         //   reuslt = AESUtils.decrypt(value, "AYiZxwvT6IDeSffqWRaCyre9FDGQy5IT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(reuslt);
    }

    public static void encodeAes()  {
        String value = "{\"amount\":102400,\"content\":\"\",\"createTime\":\"20160614170637\",\"range\":0,\"channelOrderId\":\"44961713621d47d7897597f045ace258\",\"notifyUrl\":\"http://app.hiwemeet.com/v2/openpf/recharge/notice/mopin\",\"type\":1,\"cpUser\":\"200266\",\"mobile\":\"15011277195\"}";

        String reuslt = null;
        try {
          //  reuslt = AESUtils.encrypt(value, "AYiZxwvT6IDeSffqWRaCyre9FDGQy5IT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(reuslt);
    }
}
