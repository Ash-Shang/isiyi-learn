package com.isiyi.base.java4.unit21Thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test21_28_SimpleDaemons
 * @Description 简单的后台线程测试
 * @Author Ash-Shang
 * @Date 2020/2/19 16:14
 * @Version 1.0
 */
public class Test21_28_SimpleDaemons implements Runnable {
    @Override
    public void run() {

        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread()+"--"+this);
            }
        }catch (Exception e){

        }
    }

    public static void main(String[] args) throws InterruptedException {

        for(int i=0; i<10; i++){
            Thread thread = new Thread(new Test21_28_SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("main----");
       // TimeUnit.SECONDS.sleep(3);
    }
}
