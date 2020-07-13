package com.isiyi.xmg.fibonacci;

import java.util.ArrayList;

/**
 * 斐波那契数列
 * 0，1，1，2，3，5，8，13
 */
public class FibonacciTest {

    public static void main(String[] args) {
        //递归计算
        int i = fib1(7);
        System.out.println(i);
        int sum = fib2(7);
        System.out.println(sum);
    }

    /**
     * 递归计算
     * @param n
     * @return
     */
    public static int fib1(int n){
        if(n<= 1){
           return n;
        }
        return fib1(n-1)+fib1(n-2);
    }


    public static int fib2(int n){
        if(n<= 1) return n;

        int first = 0;
        int second = 1;



        for(int i=0; i< n-1; i++){
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }


    public static int fib3(int n){
        double sqrt = Math.sqrt(5);
        return (int) ((Math.pow((1+sqrt)/2, n) - Math.pow((1-sqrt)/2,n)) / sqrt );
    }
}
