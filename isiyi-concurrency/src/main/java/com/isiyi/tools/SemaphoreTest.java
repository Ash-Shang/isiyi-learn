package com.isiyi.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            threadPool.execute( () -> {
                try {
                    semaphore.acquire();
                    System.out.println( "save data----"+ finalI);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        int queueLength = semaphore.getQueueLength();
        System.out.println(queueLength);

        threadPool.shutdown();
    }

}
