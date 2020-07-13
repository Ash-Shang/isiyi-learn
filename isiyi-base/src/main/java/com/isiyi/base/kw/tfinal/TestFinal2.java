package com.isiyi.base.kw.tfinal;

import org.junit.Test;

/**
 * @ClassName TestFinal2
 * @Description 测试final关键字
 * @Author Ash-Shang
 * @Date 2020/2/13 15:54
 * @Version 1.0
 */
public class TestFinal2 {


    @Test
    public void test1()  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c)); //true
        System.out.println((a == e)); //false
    }

    @Test
    public void test2(){
        String a = "hello2";
        final String b = getHello();
        String c = b + 2;
        System.out.println((a == c)); //false
    }


    public static String getHello() {        return "hello";    }

}
