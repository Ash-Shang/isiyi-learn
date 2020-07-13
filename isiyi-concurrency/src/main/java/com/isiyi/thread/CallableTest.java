package com.isiyi.thread;

import java.util.concurrent.*;

public class CallableTest implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("Do Something");

        TimeUnit.SECONDS.sleep(1);

        return Boolean.TRUE;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableTest test = new CallableTest();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Boolean> result = executorService.submit(test);

        Boolean aBoolean = result.get();
        String s = aBoolean ? "成功返回" : "失败返回";
        System.out.println(s);

    }



}
