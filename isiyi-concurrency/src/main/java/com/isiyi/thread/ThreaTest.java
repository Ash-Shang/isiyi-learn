package com.isiyi.thread;

public class ThreaTest extends Thread{

    @Override
    public void run() {
        System.out.println("线程："+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        ThreaTest threaTest = new ThreaTest();
        threaTest.start();
        System.out.println("**"+Thread.currentThread().getName());


    }
}
