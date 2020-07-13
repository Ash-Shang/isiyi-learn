package io.isiyi.threadsafe;

/**
 * @ClassName SellTicket
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/18 21:02
 * @Version 1.0
 */
public class SellTicket {

    public static void main(String[] args) {
        SaleWindows windows = new SaleWindows();
        new Thread(windows,"线程A").start();
        new Thread(windows,"线程B").start();
    }

}
