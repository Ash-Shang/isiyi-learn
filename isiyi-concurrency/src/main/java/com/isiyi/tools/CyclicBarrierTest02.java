package com.isiyi.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest02 {

    static CyclicBarrier barrier = new CyclicBarrier(3,new TaskRunnable());

    public static void main(String[] args) {
        new Thread(() ->{
            try {
                barrier.await();//阻塞本线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1--->running");
        }).start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("2--->running");

    }

}

/**
 * 所有线程到达屏障即可执行，最先执行
 */
class TaskRunnable implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "-->抵达屏障！");
    }
}
