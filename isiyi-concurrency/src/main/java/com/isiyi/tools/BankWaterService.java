package com.isiyi.tools;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService  implements Runnable{
    /**
     * 设置4个屏障，处理完成后执行当前类的run()方法
     */
    private CyclicBarrier barrier = new CyclicBarrier(4, this);

    /**
     * 假设4个sheet,启动四个线程
     */
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> bankWaterSheet = new ConcurrentHashMap<>();

    
    private void count(){
        for (int i = 0; i < 4; i++) {
            executorService.execute(() ->{
                //计算结果放在map中
                bankWaterSheet.put(Thread.currentThread().getName(), 1);
                //银行流水计算完成，插入一个屏障
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    
    @Override
    public void run() {
        System.out.println("全部计算完成_____--");
        int result = 0;
        //汇总结果
        for (Map.Entry<String, Integer> entry : bankWaterSheet.entrySet()) {
            result += entry.getValue();
        }
        //将结果输出
        bankWaterSheet.put("result", result);
        System.out.println("result: "+result);

    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();

        bankWaterService.count();
    }
}
