package com.isiyi.state;

import java.util.concurrent.TimeUnit;

public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread busyThread = new Thread(new BusyThread(),"BusyThread");
        busyThread.setDaemon(true);

        Thread sleepThread = new Thread(new SleepThread(),"SleepThread");
        sleepThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        //sleep 5 seconds
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
          busyThread.interrupt();
//        busyThread.suspend();
//        busyThread.resume();
//        busyThread.stop();

        System.out.println("BusyThread is "+ busyThread.isInterrupted());
        System.out.println("SleepThread is "+ sleepThread.isInterrupted());

        TimeUnit.SECONDS.sleep(5);
    }
}

class SleepThread implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("SleepThread is Interrupted");
                e.printStackTrace();
            }
        }
    }
}

class BusyThread implements Runnable{
    @Override
    public void run() {
        while (true) {
        }
    }
}