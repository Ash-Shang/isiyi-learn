package com.isiyi.state;

import java.util.concurrent.TimeUnit;

public class DaemonTest2 {

    public static void main(String[] args) {

        DaemonRunner daemonRunner = new DaemonRunner();
        Thread thread = new Thread(daemonRunner,"daemon");
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread run");
    }

}

class DaemonRunner implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){

        }finally {
            System.out.println("Daemon finally run");
        }
    }
}
