package com.isiyi.base.java4.unit21Thread.daemons;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName DaemonThreadFactory
 * @Description 后台线程工厂
 * @Author Ash-Shang
 * @Date 2020/2/19 16:37
 * @Version 1.0
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
