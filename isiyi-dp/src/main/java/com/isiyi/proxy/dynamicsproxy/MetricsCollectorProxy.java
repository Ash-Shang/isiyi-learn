package com.isiyi.proxy.dynamicsproxy;

import com.isiyi.proxy.MetricsCollector;
import com.isiyi.proxy.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * <p></p>
 *
 * @version 1.0.0
 * @description: MetricsCollectorProxy
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;
    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(
                proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }
    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;
        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }
}

