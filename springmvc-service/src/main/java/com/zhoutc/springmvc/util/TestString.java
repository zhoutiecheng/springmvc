package com.zhoutc.springmvc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoutc on 2016/5/25.
 */
public class TestString {
    public static void main(String[] args) {
        try{
            Map<String,String> map = new HashMap<>();
            System.out.println(map);
            if(map.get("111").equals("222")){
                System.out.println("---------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
