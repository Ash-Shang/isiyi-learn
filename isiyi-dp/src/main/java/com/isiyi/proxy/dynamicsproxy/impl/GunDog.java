package com.isiyi.proxy.dynamicsproxy.impl;

import com.isiyi.proxy.dynamicsproxy.inters.Dog;

public class GunDog implements Dog {
    @Override
    public void run() {
        System.out.println("猎狗在跑");
    }
}
