package com.isiyi.base.java4.unit21Thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test21_21_MainThread
 * @Description 测试线程运行
 * @Author Ash-Shang
 * @Date 2020/2/17 15:50
 * @Version 1.0
 */

class LiftOff implements Runnable{

    protected int countDown = 10;

    @Override
    public void run() {
        while (--countDown > 0){
            System.out.println("#"+countDown);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test21_21_MainThread {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
    }


}
