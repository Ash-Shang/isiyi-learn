package com.isiyi.proxy.dynamicsproxy;

import com.isiyi.proxy.dynamicsproxy.factory.MyProxyFactory;
import com.isiyi.proxy.dynamicsproxy.impl.GunDog;
import com.isiyi.proxy.dynamicsproxy.inters.Dog;

public class DynamicsProxyTest {
    public static void main(String[] args) {
        /**
         * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能使用动态代理
         *
         */
        Dog dog = new GunDog();
        Dog proxy =(Dog) MyProxyFactory.getProxy(dog);
        proxy.run();
    }


}
