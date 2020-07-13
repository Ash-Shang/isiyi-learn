package io.isiyi.threadsafe;

/**
 * @ClassName SaleWindows
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/18 21:03
 * @Version 1.0
 */
public class SaleWindows implements Runnable{

    private long count = 1000;

    @Override
    public void run() {
        while (count > 0){
            System.out.println("卖掉"+count+"火车票");
            count --;
        }
    }


}
