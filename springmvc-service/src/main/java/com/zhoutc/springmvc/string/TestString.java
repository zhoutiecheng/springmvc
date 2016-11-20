package com.zhoutc.springmvc.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhoutc.springmvc.util.TimeUtil;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhoutc on 2016-08-09.
 */
public class TestString {
    public static void main(String[] args)  throws Exception{
       try{
      /*     int c = testException();
           System.out.printf(String.valueOf(c));*/

           //testInt();
          // testDouble();
          // testFor();
           //testClassLoader();
         //  testSeria();
           //testJson();
           testFile();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void testBig(){
        BigDecimal price = new BigDecimal("0.07");
       // System.out.printf(price.setScale(2,BigDecimal.ROUND_DOWN).toString());
        BigDecimal a = new BigDecimal("1.34");
        BigDecimal b = new BigDecimal("0.06");

        BigDecimal c = b.divide(a,4,BigDecimal.ROUND_DOWN);
        System.out.printf(c.toString());

    }

    public static void testMethod() throws Exception{
        Date startDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse("201601" + "01000000000");
        System.out.printf(startDate.toString());

    }

    public static void testTime(){

        try{
            String startMonth = "201609";
            String result = new SimpleDateFormat("yyyyMM").format(TimeUtil.getAfterMonthBegin(new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(startMonth+"01000000000")));

            System.out.printf(result);
        }catch (Exception e){

         e.printStackTrace();
        }
    }


    public  static int testException() throws Exception{
        System.out.printf("aaaaaa");

        if(1==1){
            throw new Exception();
        }
        System.out.printf("bbbbbb");
        return 1;
    }

    public static void testFor(){
        Integer[] array = new Integer[]{1,2,3,4,5};
        for(int i = 0;i<10&& array[i]==1;i++){
            System.out.printf("-----------");
        }
    }

    public static void testInt(){

        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern()==str1);
        String str2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern()==str2);
        String str3 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str3.intern()==str3);

    }

    public static void testDouble(){

        long dealPrice =(long)10000;
        long amountTarget=10;
        BigDecimal fundRate=new BigDecimal(10);
        BigDecimal tail =  (new BigDecimal(dealPrice).subtract(new BigDecimal(amountTarget))).multiply(fundRate) .divide (new BigDecimal(amountTarget),2).multiply(new BigDecimal(100));
        System.out.println(tail.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    public static void testClassLoader() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        URL url = new URL("file://D:/");
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("Hello");
       // Method taskMethod =  clazz.getMethod("main");
        //taskMethod.invoke(clazz.newInstance());
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
        Method taskMethod =  clazz.getMethod("main",String[].class);
        taskMethod.invoke(clazz.newInstance(),new String[]{"123","232"});
        System.out.printf(classLoader.getParent().toString());
    }

    public static void testSeria(){
        ModelA a = new ModelA();
        ModelB b = new ModelB();
        b.b1 = "b1";
        b.b2 = "b2";
        ModelC c = new ModelC();
        c.c1 = "c1";
        c.c2 = "c2";

        a.c = c;
        a.type = 2;
        String json = JSON.toJSONString(a);
        ModelA serA = JSONObject.parseObject(json,ModelA.class);
        System.out.println(serA.type);
        System.out.println(serA.c.c1);
        System.out.println(serA.c.c2);
        System.out.println(serA.b);
    }

    public static void testJson(){
        String  a = null;
       try{
           Integer c = Integer.parseInt(a);

       }catch (Exception e){
           StringWriter sw = new StringWriter();
           PrintWriter pw = new PrintWriter(sw);
           e.printStackTrace(pw);
           System.out.println("----:"+sw.toString());
       }
    }

    public static void testFinalString(){
         final String a = "231312";
    }

    public static void testFile() throws Exception{
        File file = new File("d:\\111222\\3232\\11");
        if(!file.exists()){
            file.mkdirs();
        }


    }
}
