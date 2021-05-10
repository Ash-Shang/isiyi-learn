package com.isiyi.proxy;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: RequestInfo
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public class RequestInfo {

    private String methodName;

    private long startTimes;

    private long responseTime;


    public RequestInfo(String methodName, long startTimes, long responseTime) {
        this.methodName = methodName;
        this.startTimes = startTimes;
        this.responseTime = responseTime;
    }
}
