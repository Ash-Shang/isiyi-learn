package com.isiyi.state;

import java.util.concurrent.TimeUnit;

public class JionTest implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i< 1000; i++){
            System.out.println("vip is coming"+ i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JionTest jionTest = new JionTest();
        Thread thread = new Thread(jionTest);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(10);
        for (int j = 0; j< 500; j++){
            System.out.println("main"+j);
            if(200 == j) {
                thread.join();
            }
        }
    }
}
