package com.isiyi.state;

public class DaemonTest {

    public static void main(String[] args) {
        MyLife myLife = new MyLife();
        MyDaemon myDaemon = new MyDaemon();
        Thread daemonThread = new Thread(myDaemon);
        daemonThread.setDaemon(true);

        daemonThread.start();

        new Thread(myLife).start();


    }
    
    
}

class MyDaemon implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("守护着你的第"+ i + "天");
        }
    }
}

class MyLife implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着的第"+ i + "天");
        }
        System.out.println("good bye world");
    }
}