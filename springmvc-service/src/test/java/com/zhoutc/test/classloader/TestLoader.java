package com.zhoutc.test.classloader;

import java.math.BigDecimal;

/**
 * Created by zhoutc on 2016/5/6.
 */
public class TestLoader {

    public static void main(String[] args) {
       // System.out.println(Son.fa);
       /* Father[] fathers = new Father[10];
        System.out.println(fathers.toString());*/
try{
    String settle_fen = new BigDecimal("1.212").multiply(new BigDecimal("100")).setScale(0).toString();
}catch (Exception e){
    e.printStackTrace();
}


    }
}
class Father{
    static {
        System.out.println("this is Father class");
    }
    public static int value = 1;
    public static int fa = 1;
}
class Son extends Father{
    static {
        System.out.println("this is Son class");
    }
    public static int value = 2;
    public static int so = 2;
}