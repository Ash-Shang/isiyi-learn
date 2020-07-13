package com.isiyi.base.java4.unit21Thread.jions;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test21_211_Jion
 * @Description 测试jion
 * @Author Ash-Shang
 * @Date 2020/2/19 20:12
 * @Version 1.0
 */

class Sleeper extends Thread{

    private int time;
    Sleeper(String name, int time){
        super(name);
        this.time =time;
        start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleeper");
//        try {
//            sleep(time);
//        } catch (InterruptedException e) {
//            System.out.println(getName()+"is interrupted");
//        }
    }
}


class Joiner extends Thread{

    private int time;
    Sleeper sleeper = null;
    Joiner(String name, int time, Sleeper sleeper){
        super(name);
        this.time =time;
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
//        try {
//            sleeper.joi n();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("join");
//        try {
//            sleep(time);
//        } catch (InterruptedException e) {
//            System.out.println(getName()+"is interrupted");
//        }
    }
}

public class Test21_211_Jion {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sp",1000);
        Joiner jioner = new Joiner("jn",1000,sleeper);


    }



}
