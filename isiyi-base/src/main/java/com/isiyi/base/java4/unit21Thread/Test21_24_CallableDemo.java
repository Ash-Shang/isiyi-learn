package com.isiyi.base.java4.unit21Thread;

import javax.xml.transform.Source;
import java.util.concurrent.*;

/**
 * @ClassName Test21_24_CallableDemo
 * @Description 回调的线程
 * @Author Ash-Shang
 * @Date 2020/2/17 16:29
 * @Version 1.0
 */

class TaskWithResult implements Callable<String>{

    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        if(id ==7)
            new RuntimeException();

        return "Result: "+id;
    }
}

public class Test21_24_CallableDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService =
                Executors.newCachedThreadPool();

        for (int i=1; i<10; i++){
            Future<String> submit = executorService.submit(new TaskWithResult(i));

            if (submit.isDone()) {
                System.out.println(submit.get());
            }else{
                System.out.println("None Done");
            }


        }
    }

}
