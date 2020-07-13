package com.isiyi.base.thread;

/**
 * @ClassName TestDouble
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/2/27 21:44
 * @Version 1.0
 */
public class TestDouble implements Runnable {

    int i = 1;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new TestDouble()).start();
        }



    }

    private int incr(){
        return ++i;
    }


    @Override
    public void run() {
        System.out.println(incr());
    }
}
