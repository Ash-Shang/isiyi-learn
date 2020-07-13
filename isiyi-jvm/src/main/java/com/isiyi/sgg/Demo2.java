package com.isiyi.sgg;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/23 21:17
 * @Version 1.0
 */
public class Demo2 {

    public static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(Demo2.num);
        System.out.println(Demo2.number);//10
    }
    public static  int number = 10;

    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println(Demo2.num);
        System.out.println(Demo2.number);
    }

}
