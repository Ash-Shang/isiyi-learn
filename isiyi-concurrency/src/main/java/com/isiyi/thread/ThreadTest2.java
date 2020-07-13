package com.isiyi.thread;


class ThreadTask implements Runnable{
    @Override
    public void run() {
        System.out.println("hello");
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTask());
        thread.start();
    }
}
