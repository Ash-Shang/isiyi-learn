package com.isiyi.base.java4.unit21Thread.daemons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DaemonFormFactory
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/2/19 16:39
 * @Version 1.0
 */
public class DaemonFormFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread()+"--"+this);
            }
        }catch (Exception e){

            System.out.println("inter");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());

        for(int i=1; i<10; i++){
            executorService.execute(new DaemonFormFactory());

        }
        System.out.println("main");

        TimeUnit.SECONDS.sleep(1);

    }
}
