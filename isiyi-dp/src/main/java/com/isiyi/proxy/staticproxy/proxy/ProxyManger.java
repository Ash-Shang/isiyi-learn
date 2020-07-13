package com.isiyi.proxy.staticproxy.proxy;

import com.isiyi.proxy.staticproxy.impl.LDHStar;
import com.isiyi.proxy.staticproxy.inters.Star;

public class ProxyManger implements Star {

    // 真实对象的引用
    private Star star;
    public ProxyManger(Star star) {
        super();
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("唱歌前准备");
        star.sing();
        System.out.println("善后工作");        }
}
