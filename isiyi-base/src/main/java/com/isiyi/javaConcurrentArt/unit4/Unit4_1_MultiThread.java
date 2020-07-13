package com.isiyi.javaConcurrentArt.unit4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName Unit4_1_MultiThread
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/11 17:57
 * @Version 1.0
 */
public class Unit4_1_MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());

        }
    }
}
