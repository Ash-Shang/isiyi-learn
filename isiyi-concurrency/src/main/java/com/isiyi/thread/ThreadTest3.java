package com.isiyi.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest3 implements Runnable {
    private int ticketNum = 100;

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (ticketNum > 0){
            System.out.println(Thread.currentThread().getName()+"--拿到了第+"+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {
        ThreadTest3 t1 = new ThreadTest3();

        new Thread(t1,"小明").start();
        new Thread(t1,"小华").start();
        new Thread(t1,"小啥").start();
    }
}
