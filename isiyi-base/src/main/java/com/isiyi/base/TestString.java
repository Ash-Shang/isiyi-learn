package com.isiyi.base;

import org.junit.Test;

import java.util.HashSet;

public class TestString {

    @Test
    public void test1(){
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        System.out.println(aa==bb);
        System.out.println(a==b);
        System.out.println(a== aa);
        System.out.println(a.equals(aa));

    }

    @Test
    public void testString(){
        String test = "";
        test = test + "hello";
        test = test + ",";
        test = test + "world";
        test = test + ";";
        System.out.println(test);

    }

    @Test
    public void testChina(){
        System.out.println("我爱你中国");
    }

}
