package com.isiyi.state;

public class YieldTest {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}


class MyYield implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"开始运行。。。。。。。");
        Thread.yield();
        System.out.println(name+"运行结束。。。。。。。");
    }
}