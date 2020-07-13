package com.isiyi.base.kw.testobj;

import com.isiyi.base.kw.tfinal.TestFinal;

/**
 * @ClassName RunMain
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/2/11 22:50
 * @Version 1.0
 */
public class RunMain {

    public static void main(String[] args) {
        TestFinal.test1();
        TestFinal testFinal = new TestFinal();
        testFinal.test2();

        String s1 =  "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


    }
}
